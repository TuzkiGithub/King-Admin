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

import com.kevinwong.module.sys.entity.DictEntity;
import com.kevinwong.module.sys.service.DictService;
import com.kevinwong.core.utils.PageUtils;
import com.kevinwong.core.utils.K;



/**
 * 字典表
 *
 * @author Eastascend <EastascendWang@gmail.com>
 * @date 2019-04-28 17:15:07
 */
@RestController
@RequestMapping("sys/dict")
public class DictController {
    @Autowired
    private DictService dictService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:dict:list")
    public K list(@RequestParam Map<String, Object> params){
        PageUtils page = dictService.queryPage(params);

        return K.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{dictId}")
    @RequiresPermissions("sys:dict:info")
    public K info(@PathVariable("dictId") Long dictId){
		DictEntity dict = dictService.getById(dictId);

        return K.ok().put("dict", dict);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:dict:save")
    public K save(@RequestBody DictEntity dict){
		dictService.save(dict);

        return K.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:dict:update")
    public K update(@RequestBody DictEntity dict){
		dictService.updateById(dict);

        return K.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:dict:delete")
    public K delete(@RequestBody Long[] dictIds){
		dictService.removeByIds(Arrays.asList(dictIds));

        return K.ok();
    }

}
