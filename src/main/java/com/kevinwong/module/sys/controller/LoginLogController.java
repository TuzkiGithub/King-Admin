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

import com.kevinwong.module.sys.entity.LoginLogEntity;
import com.kevinwong.module.sys.service.LoginLogService;
import com.kevinwong.core.utils.PageUtils;
import com.kevinwong.core.utils.K;



/**
 * 登录记录
 *
 * @author Eastascend <EastascendWang@gmail.com>
 * @date 2019-04-28 17:15:07
 */
@RestController
@RequestMapping("sys/loginlog")
public class LoginLogController {
    @Autowired
    private LoginLogService loginLogService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:loginlog:list")
    public K list(@RequestParam Map<String, Object> params){
        PageUtils page = loginLogService.queryPage(params);

        return K.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{loginLogId}")
    @RequiresPermissions("sys:loginlog:info")
    public K info(@PathVariable("loginLogId") Long loginLogId){
		LoginLogEntity loginLog = loginLogService.getById(loginLogId);

        return K.ok().put("loginLog", loginLog);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:loginlog:save")
    public K save(@RequestBody LoginLogEntity loginLog){
		loginLogService.save(loginLog);

        return K.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:loginlog:update")
    public K update(@RequestBody LoginLogEntity loginLog){
		loginLogService.updateById(loginLog);

        return K.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:loginlog:delete")
    public K delete(@RequestBody Long[] loginLogIds){
		loginLogService.removeByIds(Arrays.asList(loginLogIds));

        return K.ok();
    }

}
