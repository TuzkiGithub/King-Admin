package com.kevinwong.module.oss.controller;

import java.util.Arrays;
import java.util.Map;

import com.kevinwong.module.oss.entity.OssEntity;
import com.kevinwong.module.oss.service.OssService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kevinwong.core.utils.PageUtils;
import com.kevinwong.core.utils.K;



/**
 * 文件上传
 *
 * @author Eastascend <EastascendWang@gmail.com>
 * @date 2019-06-05 10:09:11
 */
@RestController
@RequestMapping("sys/oss")
public class OssController {
    @Autowired
    private OssService ossService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:oss:list")
    public K list(@RequestParam Map<String, Object> params){
        PageUtils page = ossService.queryPage(params);

        return K.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("sys:oss:info")
    public K info(@PathVariable("id") Long id){
		OssEntity oss = ossService.getById(id);

        return K.ok().put("oss", oss);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:oss:save")
    public K save(@RequestBody OssEntity oss){
		ossService.save(oss);

        return K.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:oss:update")
    public K update(@RequestBody OssEntity oss){
		ossService.updateById(oss);

        return K.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:oss:delete")
    public K delete(@RequestBody Long[] ids){
		ossService.removeByIds(Arrays.asList(ids));

        return K.ok();
    }

}
