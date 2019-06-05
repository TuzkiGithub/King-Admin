package com.kevinwong.module.sys.controller;

import com.kevinwong.core.utils.K;
import com.kevinwong.module.sys.entity.UserEntity;
import com.kevinwong.module.sys.form.SysLoginForm;
import com.kevinwong.module.sys.service.CaptchaService;
import com.kevinwong.module.sys.service.UserService;
import com.kevinwong.module.sys.service.UserTokenService;
import org.apache.commons.io.IOUtils;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Map;

import static com.kevinwong.module.sys.controller.AbstractController.getUserId;

/**
 * @Program: King-Admin
 * @Class: LoginController
 * @Description: 登录控制器
 * @Author: Eastascend <EastascendWang@gmail.com>
 * @Date: 2019-04-29 16:37
 **/
@RestController
public class LoginController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserTokenService userTokenService;
    @Autowired
    private CaptchaService captchaService;

    /**
     * captcha
     * @param response
     * @param uuid
     * @throws IOException
     */
    @GetMapping("captcha.jpg")
    public void captcha(HttpServletRequest request, HttpServletResponse response, String uuid) throws IOException {

        HttpSession session = request.getSession();

        response.setDateHeader("Expires", 0);

        // Set standard HTTP/1.1 no-cache headers.
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");

        // Set IE extended HTTP/1.1 no-cache headers (use addHeader).
        response.addHeader("Cache-Control", "post-check=0, pre-check=0");

        // Set standard HTTP/1.0 no-cache header.
        response.setHeader("Pragma", "no-cache");

        // return a jpeg
        response.setContentType("image/jpeg");


        BufferedImage image = captchaService.getCaptcha(uuid);

        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(image, "jpg", out);
        IOUtils.closeQuietly(out);
    }

    /**
     * login
     * @param form
     * @return K
     */
    @PostMapping("/sys/login")
    public Map<String, Object> login(@RequestBody SysLoginForm form){

        boolean captcha = captchaService.validate(form.getUuid(), form.getCaptcha());
//        if (!captcha){
//            return K.error("验证码不正确！");
//        }

        UserEntity user = userService.queryByUserName(form.getUsername());
        if (user == null || !user.getPassword().equals(new Sha256Hash(form.getPassword(), user.getSalt()).toHex())){
            return K.error("账号或密码不正确！");
        }

        if (user.getStatus().equals("0")){
            return K.error("账号已锁定，请联系管理员！");
        }

        K k = userTokenService.createToken(user.getUserId());
        return k;
    }

    /**
     * logout
     * @return K
     */
    @PostMapping("/sys/logout")
    public K logout(){
        userTokenService.logout(getUserId());
        return K.ok();
    }
}
