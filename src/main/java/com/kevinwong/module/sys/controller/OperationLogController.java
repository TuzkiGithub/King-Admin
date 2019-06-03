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

import com.kevinwong.module.sys.entity.OperationLogEntity;
import com.kevinwong.module.sys.service.OperationLogService;
import com.kevinwong.core.utils.PageUtils;
import com.kevinwong.core.utils.K;



/**
 * 操作日志
 *
 * @author Eastascend <EastascendWang@gmail.com>
 * @date 2019-04-28 17:15:07
 */
@RestController
@RequestMapping("sys/operationlog")
public class OperationLogController {
    @Autowired
    private OperationLogService operationLogService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:operationlog:list")
    public K list(@RequestParam Map<String, Object> params){
        PageUtils page = operationLogService.queryPage(params);

        return K.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{operationLogId}")
    @RequiresPermissions("sys:operationlog:info")
    public K info(@PathVariable("operationLogId") Long operationLogId){
		OperationLogEntity operationLog = operationLogService.getById(operationLogId);

        return K.ok().put("operationLog", operationLog);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:operationlog:save")
    public K save(@RequestBody OperationLogEntity operationLog){
		operationLogService.save(operationLog);

        return K.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:operationlog:update")
    public K update(@RequestBody OperationLogEntity operationLog){
		operationLogService.updateById(operationLog);

        return K.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:operationlog:delete")
    public K delete(@RequestBody Long[] operationLogIds){
		operationLogService.removeByIds(Arrays.asList(operationLogIds));

        return K.ok();
    }

}
