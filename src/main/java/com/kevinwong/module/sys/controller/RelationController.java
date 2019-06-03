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

import com.kevinwong.module.sys.entity.RelationEntity;
import com.kevinwong.module.sys.service.RelationService;
import com.kevinwong.core.utils.PageUtils;
import com.kevinwong.core.utils.K;



/**
 * 角色和菜单关联表
 *
 * @author Eastascend <EastascendWang@gmail.com>
 * @date 2019-04-28 17:15:07
 */
@RestController
@RequestMapping("sys/relation")
public class RelationController {
    @Autowired
    private RelationService relationService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:relation:list")
    public K list(@RequestParam Map<String, Object> params){
        PageUtils page = relationService.queryPage(params);

        return K.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{relationId}")
    @RequiresPermissions("sys:relation:info")
    public K info(@PathVariable("relationId") Long relationId){
		RelationEntity relation = relationService.getById(relationId);

        return K.ok().put("relation", relation);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:relation:save")
    public K save(@RequestBody RelationEntity relation){
		relationService.save(relation);

        return K.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:relation:update")
    public K update(@RequestBody RelationEntity relation){
		relationService.updateById(relation);

        return K.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:relation:delete")
    public K delete(@RequestBody Long[] relationIds){
		relationService.removeByIds(Arrays.asList(relationIds));

        return K.ok();
    }

}
