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

import com.kevinwong.module.sys.entity.ScheduleJobEntity;
import com.kevinwong.module.sys.service.ScheduleJobService;
import com.kevinwong.core.utils.PageUtils;
import com.kevinwong.core.utils.K;



/**
 * 定时任务
 *
 * @author Eastascend <EastascendWang@gmail.com>
 * @date 2019-06-05 10:09:10
 */
@RestController
@RequestMapping("sys/schedulejob")
public class ScheduleJobController {
    @Autowired
    private ScheduleJobService scheduleJobService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:schedulejob:list")
    public K list(@RequestParam Map<String, Object> params){
        PageUtils page = scheduleJobService.queryPage(params);

        return K.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{jobId}")
    @RequiresPermissions("sys:schedulejob:info")
    public K info(@PathVariable("jobId") Long jobId){
		ScheduleJobEntity scheduleJob = scheduleJobService.getById(jobId);

        return K.ok().put("scheduleJob", scheduleJob);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:schedulejob:save")
    public K save(@RequestBody ScheduleJobEntity scheduleJob){
		scheduleJobService.save(scheduleJob);

        return K.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:schedulejob:update")
    public K update(@RequestBody ScheduleJobEntity scheduleJob){
		scheduleJobService.updateById(scheduleJob);

        return K.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:schedulejob:delete")
    public K delete(@RequestBody Long[] jobIds){
		scheduleJobService.removeByIds(Arrays.asList(jobIds));

        return K.ok();
    }

}
