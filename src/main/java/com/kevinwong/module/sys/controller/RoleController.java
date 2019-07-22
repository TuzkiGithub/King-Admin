package com.kevinwong.module.sys.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.kevinwong.core.utils.Constant;
import com.kevinwong.core.validator.ValidatorUtils;
import com.kevinwong.module.sys.entity.RoleEntity;
import com.kevinwong.module.sys.service.RoleService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kevinwong.core.utils.PageUtils;
import com.kevinwong.core.utils.K;

import static com.kevinwong.module.sys.controller.AbstractController.getUserId;


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
     * 角色列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:role:list")
    public K list(@RequestParam Map<String, Object> params){
        //如果非超级管理员，只查询自己创建的角色列表
        if (getUserId() != Constant.SUPER_ADMIN) {
            params.put("createUserId", getUserId());
        }


        PageUtils page = roleService.queryPage(params);

        return K.ok().put("page", page);
    }


    /**
     * 角色信息
     */
    @RequestMapping("/info/{roleId}")
    @RequiresPermissions("sys:role:info")
    public K info(@PathVariable("roleId") Long roleId){
		RoleEntity role = roleService.getById(roleId);

		//查询角色对应的菜单
        List<Long> menuList = roleService.queryMenuList(roleId);
        role.setMenuIdList(menuList);

        return K.ok().put("role", role);
    }

    /**
     * 保存角色
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:role:save")
    public K save(@RequestBody RoleEntity role){
        ValidatorUtils.validateEntity(role);
        role.setCreateUserId(getUserId());
        roleService.save(role);

        return K.ok();
    }

    /**
     * 修改角色
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:role:update")
    public K update(@RequestBody RoleEntity role){
        ValidatorUtils.validateEntity(role);

        role.setCreateUserId(getUserId());
		roleService.updateById(role);

        return K.ok();
    }

    /**
     * 删除角色
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:role:delete")
    public K delete(@RequestBody Long[] roleIds){
		roleService.removeByIds(Arrays.asList(roleIds));

        return K.ok();
    }

}
