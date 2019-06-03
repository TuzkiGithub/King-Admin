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

import com.kevinwong.module.sys.entity.FileInfoEntity;
import com.kevinwong.module.sys.service.FileInfoService;
import com.kevinwong.core.utils.PageUtils;
import com.kevinwong.core.utils.K;



/**
 * 文件信息表

 *
 * @author Eastascend <EastascendWang@gmail.com>
 * @date 2019-04-28 17:15:07
 */
@RestController
@RequestMapping("sys/fileinfo")
public class FileInfoController {
    @Autowired
    private FileInfoService fileInfoService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:fileinfo:list")
    public K list(@RequestParam Map<String, Object> params){
        PageUtils page = fileInfoService.queryPage(params);

        return K.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{fileId}")
    @RequiresPermissions("sys:fileinfo:info")
    public K info(@PathVariable("fileId") String fileId){
		FileInfoEntity fileInfo = fileInfoService.getById(fileId);

        return K.ok().put("fileInfo", fileInfo);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:fileinfo:save")
    public K save(@RequestBody FileInfoEntity fileInfo){
		fileInfoService.save(fileInfo);

        return K.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:fileinfo:update")
    public K update(@RequestBody FileInfoEntity fileInfo){
		fileInfoService.updateById(fileInfo);

        return K.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:fileinfo:delete")
    public K delete(@RequestBody String[] fileIds){
		fileInfoService.removeByIds(Arrays.asList(fileIds));

        return K.ok();
    }

}
