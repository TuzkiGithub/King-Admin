package com.kevinwong.module.sys.service.impl;

import com.kevinwong.core.utils.Constant;
import com.kevinwong.core.utils.MapUtils;
import com.kevinwong.module.sys.entity.MenuEntity;
import com.kevinwong.module.sys.mapper.MenuMapper;
import com.kevinwong.module.sys.service.RoleMenuService;
import com.kevinwong.module.sys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kevinwong.core.utils.PageUtils;
import com.kevinwong.core.utils.Query;

import com.kevinwong.module.sys.service.MenuService;


@Service("menuService")
public class MenuServiceImpl extends ServiceImpl<MenuMapper, MenuEntity> implements MenuService {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleMenuService roleMenuService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<MenuEntity> page = this.page(
                new Query<MenuEntity>().getPage(params),
                new QueryWrapper<MenuEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<MenuEntity> queryListByParentId(Long parentId, List<Long> mendIdList) {
        List<MenuEntity> menuList = queryListByParentId(parentId);
        if (mendIdList == null) {
            return menuList;
        }

        List<MenuEntity> userMenuList = new ArrayList<>();
        for (MenuEntity menu : menuList){
            if (mendIdList.contains(menu.getMenuId())){
                userMenuList.add(menu);
            }
        }
        return userMenuList;
    }

    @Override
    public List<MenuEntity> queryListByParentId(Long parentId) {
        return baseMapper.queryListByParentId(parentId);
    }

    @Override
    public List<MenuEntity> queryNotButtonList() {
        return baseMapper.queryNotButtonList();
    }

    @Override
    public List<MenuEntity> getUserMenuList(Long userId) {
        //系统管理员 拥有最高权限
        if (userId == Constant.SUPER_ADMIN) {
            return getAllMenuList(null);
        }

        //用户菜单列表
        List<Long> menuIdList = userService.queryAllMenuId(userId);

        return getAllMenuList(menuIdList);
    }

    @Override
    public void delete(Long menuId) {
        //删除菜单
        this.removeById(menuId);
        //删除菜单与角色关联
        roleMenuService.removeByMap(new MapUtils().put("menu_id", menuId));
    }

    /**
     * 获取所有菜单列表
     * @param menuIdList
     * @return
     */
    private List<MenuEntity> getAllMenuList(List<Long> menuIdList){
        //查询根菜单列表
        List<MenuEntity> menuList = queryListByParentId(0L, menuIdList);

        //递归获取子菜单
        getMenuTreeList(menuList, menuIdList);
        
        return menuList;
    }

    /**
     * 递归获取子菜单
     * @param menuList
     * @param menuIdList
     * @return
     */
    private List<MenuEntity> getMenuTreeList(List<MenuEntity> menuList, List<Long> menuIdList) {
        List<MenuEntity> subMenuList = new ArrayList<MenuEntity>();

        for (MenuEntity entity : menuList) {
            if (entity.getType() == Constant.MenuType.CATALOG.getValue()){
                entity.setList(getMenuTreeList(queryListByParentId(entity.getParentId(), menuIdList), menuIdList));
            }
            subMenuList.add(entity);
        }

        return subMenuList;
    }

}