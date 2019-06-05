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

import com.kevinwong.module.sys.entity.ConfigEntity;
import com.kevinwong.module.sys.service.ConfigService;
import com.kevinwong.core.utils.PageUtils;
import com.kevinwong.core.utils.K;



/**
 * 系统配置信息表
 *
 * @author Eastascend <EastascendWang@gmail.com>
 * @date 2019-06-05 10:09:10
 */
@RestController
@RequestMapping("sys/config")
public class ConfigController {
    @Autowired
    private ConfigService configService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:config:list")
    public K list(@RequestParam Map<String, Object> params){
        PageUtils page = configService.queryPage(params);

        return K.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("sys:config:info")
    public K info(@PathVariable("id") Long id){
		ConfigEntity config = configService.getById(id);

        return K.ok().put("config", config);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:config:save")
    public K save(@RequestBody ConfigEntity config){
		configService.save(config);

        return K.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:config:update")
    public K update(@RequestBody ConfigEntity config){
		configService.updateById(config);

        return K.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:config:delete")
    public K delete(@RequestBody Long[] ids){
		configService.removeByIds(Arrays.asList(ids));

        return K.ok();
    }

}
