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

import com.kevinwong.module.sys.entity.QrtzSimpropTriggersEntity;
import com.kevinwong.module.sys.service.QrtzSimpropTriggersService;
import com.kevinwong.core.utils.PageUtils;
import com.kevinwong.core.utils.K;



/**
 * 
 *
 * @author Eastascend <EastascendWang@gmail.com>
 * @date 2019-06-05 10:09:10
 */
@RestController
@RequestMapping("sys/qrtzsimproptriggers")
public class QrtzSimpropTriggersController {
    @Autowired
    private QrtzSimpropTriggersService qrtzSimpropTriggersService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:qrtzsimproptriggers:list")
    public K list(@RequestParam Map<String, Object> params){
        PageUtils page = qrtzSimpropTriggersService.queryPage(params);

        return K.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{schedName}")
    @RequiresPermissions("sys:qrtzsimproptriggers:info")
    public K info(@PathVariable("schedName") String schedName){
		QrtzSimpropTriggersEntity qrtzSimpropTriggers = qrtzSimpropTriggersService.getById(schedName);

        return K.ok().put("qrtzSimpropTriggers", qrtzSimpropTriggers);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:qrtzsimproptriggers:save")
    public K save(@RequestBody QrtzSimpropTriggersEntity qrtzSimpropTriggers){
		qrtzSimpropTriggersService.save(qrtzSimpropTriggers);

        return K.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:qrtzsimproptriggers:update")
    public K update(@RequestBody QrtzSimpropTriggersEntity qrtzSimpropTriggers){
		qrtzSimpropTriggersService.updateById(qrtzSimpropTriggers);

        return K.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:qrtzsimproptriggers:delete")
    public K delete(@RequestBody String[] schedNames){
		qrtzSimpropTriggersService.removeByIds(Arrays.asList(schedNames));

        return K.ok();
    }

}
