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

import com.kevinwong.core.utils.PageUtils;
import com.kevinwong.core.utils.K;



/**
 * 角色
 *
 * @author Eastascend <EastascendWang@gmail.com>
 * @date 2019-06-05 10:09:11
 */
@RestController
@RequestMapping("sys/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:role:list")
    public K list(@RequestParam Map<String, Object> params){
        PageUtils page = roleService.queryPage(params);

        return K.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{roleId}")
    @RequiresPermissions("sys:role:info")
    public K info(@PathVariable("roleId") Long roleId){
		RoleEntity role = roleService.getById(roleId);

        return K.ok().put("role", role);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:role:save")
    public K save(@RequestBody RoleEntity role){
		roleService.save(role);

        return K.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:role:update")
    public K update(@RequestBody RoleEntity role){
		roleService.updateById(role);

        return K.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:role:delete")
    public K delete(@RequestBody Long[] roleIds){
		roleService.removeByIds(Arrays.asList(roleIds));

        return K.ok();
    }

}
