package com.kevinwong.module.sys.controller;

import java.util.Arrays;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kevinwong.module.sys.service.UserTokenService;
import com.kevinwong.core.utils.PageUtils;
import com.kevinwong.core.utils.K;



/**
 * 系统用户Token
 *
 * @author Eastascend <EastascendWang@gmail.com>
 * @date 2019-06-05 10:09:10
 */
@RestController
@RequestMapping("sys/usertoken")
public class UserTokenController {
    @Autowired
    private UserTokenService userTokenService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:usertoken:list")
    public K list(@RequestParam Map<String, Object> params){
        PageUtils page = userTokenService.queryPage(params);

        return K.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{userId}")
    @RequiresPermissions("sys:usertoken:info")
    public K info(@PathVariable("userId") Long userId){
		UserTokenEntity userToken = userTokenService.getById(userId);

        return K.ok().put("userToken", userToken);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:usertoken:save")
    public K save(@RequestBody UserTokenEntity userToken){
		userTokenService.save(userToken);

        return K.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:usertoken:update")
    public K update(@RequestBody UserTokenEntity userToken){
		userTokenService.updateById(userToken);

        return K.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:usertoken:delete")
    public K delete(@RequestBody Long[] userIds){
		userTokenService.removeByIds(Arrays.asList(userIds));

        return K.ok();
    }

}
