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

import com.kevinwong.module.sys.entity.UserRoleEntity;
import com.kevinwong.module.sys.service.UserRoleService;
import com.kevinwong.core.utils.PageUtils;
import com.kevinwong.core.utils.K;



/**
 * 用户与角色对应关系
 *
 * @author Eastascend <EastascendWang@gmail.com>
 * @date 2019-06-05 10:09:10
 */
@RestController
@RequestMapping("sys/userrole")
public class UserRoleController {
    @Autowired
    private UserRoleService userRoleService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:userrole:list")
    public K list(@RequestParam Map<String, Object> params){
        PageUtils page = userRoleService.queryPage(params);

        return K.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("sys:userrole:info")
    public K info(@PathVariable("id") Long id){
		UserRoleEntity userRole = userRoleService.getById(id);

        return K.ok().put("userRole", userRole);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:userrole:save")
    public K save(@RequestBody UserRoleEntity userRole){
		userRoleService.save(userRole);

        return K.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:userrole:update")
    public K update(@RequestBody UserRoleEntity userRole){
		userRoleService.updateById(userRole);

        return K.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:userrole:delete")
    public K delete(@RequestBody Long[] ids){
		userRoleService.removeByIds(Arrays.asList(ids));

        return K.ok();
    }

}
