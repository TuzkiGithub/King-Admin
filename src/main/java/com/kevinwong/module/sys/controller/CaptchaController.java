package com.kevinwong.module.sys.controller;

import java.util.Arrays;

import com.kevinwong.module.sys.entity.CaptchaEntity;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kevinwong.module.sys.service.CaptchaService;
import com.kevinwong.core.utils.K;



/**
 * 系统验证码
 *
 * @author Eastascend <EastascendWang@gmail.com>
 * @date 2019-04-30 10:23:47
 */
@RestController
@RequestMapping("sys/captcha")
public class CaptchaController {
    @Autowired
    private CaptchaService captchaService;


    /**
     * 信息
     */
    @RequestMapping("/info/{uuid}")
    @RequiresPermissions("sys:captcha:info")
    public K info(@PathVariable("uuid") String uuid){
		CaptchaEntity captcha = captchaService.getById(uuid);

        return K.ok().put("captcha", captcha);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:captcha:save")
    public K save(@RequestBody CaptchaEntity captcha){
		captchaService.save(captcha);

        return K.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:captcha:update")
    public K update(@RequestBody CaptchaEntity captcha){
		captchaService.updateById(captcha);

        return K.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:captcha:delete")
    public K delete(@RequestBody String[] uuids){
		captchaService.removeByIds(Arrays.asList(uuids));

        return K.ok();
    }

}
