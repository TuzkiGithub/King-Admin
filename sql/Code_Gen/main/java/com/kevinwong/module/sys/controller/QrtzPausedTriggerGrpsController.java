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

import com.kevinwong.module.sys.entity.QrtzPausedTriggerGrpsEntity;
import com.kevinwong.module.sys.service.QrtzPausedTriggerGrpsService;
import com.kevinwong.core.utils.PageUtils;
import com.kevinwong.core.utils.K;



/**
 * 
 *
 * @author Eastascend <EastascendWang@gmail.com>
 * @date 2019-06-05 10:09:10
 */
@RestController
@RequestMapping("sys/qrtzpausedtriggergrps")
public class QrtzPausedTriggerGrpsController {
    @Autowired
    private QrtzPausedTriggerGrpsService qrtzPausedTriggerGrpsService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:qrtzpausedtriggergrps:list")
    public K list(@RequestParam Map<String, Object> params){
        PageUtils page = qrtzPausedTriggerGrpsService.queryPage(params);

        return K.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{schedName}")
    @RequiresPermissions("sys:qrtzpausedtriggergrps:info")
    public K info(@PathVariable("schedName") String schedName){
		QrtzPausedTriggerGrpsEntity qrtzPausedTriggerGrps = qrtzPausedTriggerGrpsService.getById(schedName);

        return K.ok().put("qrtzPausedTriggerGrps", qrtzPausedTriggerGrps);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:qrtzpausedtriggergrps:save")
    public K save(@RequestBody QrtzPausedTriggerGrpsEntity qrtzPausedTriggerGrps){
		qrtzPausedTriggerGrpsService.save(qrtzPausedTriggerGrps);

        return K.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:qrtzpausedtriggergrps:update")
    public K update(@RequestBody QrtzPausedTriggerGrpsEntity qrtzPausedTriggerGrps){
		qrtzPausedTriggerGrpsService.updateById(qrtzPausedTriggerGrps);

        return K.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:qrtzpausedtriggergrps:delete")
    public K delete(@RequestBody String[] schedNames){
		qrtzPausedTriggerGrpsService.removeByIds(Arrays.asList(schedNames));

        return K.ok();
    }

}
