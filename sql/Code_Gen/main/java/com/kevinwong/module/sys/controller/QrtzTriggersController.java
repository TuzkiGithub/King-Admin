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

import com.kevinwong.module.sys.entity.QrtzTriggersEntity;
import com.kevinwong.module.sys.service.QrtzTriggersService;
import com.kevinwong.core.utils.PageUtils;
import com.kevinwong.core.utils.K;



/**
 * 
 *
 * @author Eastascend <EastascendWang@gmail.com>
 * @date 2019-06-05 10:09:10
 */
@RestController
@RequestMapping("sys/qrtztriggers")
public class QrtzTriggersController {
    @Autowired
    private QrtzTriggersService qrtzTriggersService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:qrtztriggers:list")
    public K list(@RequestParam Map<String, Object> params){
        PageUtils page = qrtzTriggersService.queryPage(params);

        return K.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{schedName}")
    @RequiresPermissions("sys:qrtztriggers:info")
    public K info(@PathVariable("schedName") String schedName){
		QrtzTriggersEntity qrtzTriggers = qrtzTriggersService.getById(schedName);

        return K.ok().put("qrtzTriggers", qrtzTriggers);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:qrtztriggers:save")
    public K save(@RequestBody QrtzTriggersEntity qrtzTriggers){
		qrtzTriggersService.save(qrtzTriggers);

        return K.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:qrtztriggers:update")
    public K update(@RequestBody QrtzTriggersEntity qrtzTriggers){
		qrtzTriggersService.updateById(qrtzTriggers);

        return K.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:qrtztriggers:delete")
    public K delete(@RequestBody String[] schedNames){
		qrtzTriggersService.removeByIds(Arrays.asList(schedNames));

        return K.ok();
    }

}
