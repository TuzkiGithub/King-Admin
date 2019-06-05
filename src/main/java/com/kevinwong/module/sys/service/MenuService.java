package com.kevinwong.module.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kevinwong.core.utils.PageUtils;
import com.kevinwong.module.sys.entity.MenuEntity;

import java.util.List;
import java.util.Map;

/**
 * 菜单表
 *
 * @author Eastascend <EastascendWang@gmail.com>
 * @date 2019-04-28 17:15:07
 */
public interface MenuService extends IService<MenuEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 根据父菜单 查询子菜单
     * @param parentId 父菜单ID
     * @param mendIdList 用户菜单ID
     * @return
     */
    List<MenuEntity> queryListByParentId(Long parentId, List<Long> mendIdList);

    /**
     * 根据父菜单 查询子菜单
     * @param parentId 父菜单ID
     * @return
     */
    List<MenuEntity> queryListByParentId(Long parentId);

    /**
     * 获取不包含按钮菜单
     * @return
     */
    List<MenuEntity> queryNotButtonList();

    /**
     * 获取用户菜单列表
     * @param userId
     * @return
     */
    List<MenuEntity> getUserMenuList(Long userId);

    /**
     * 删除
     * @param menuId
     */
    void delete(Long menuId);
}

