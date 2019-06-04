package com.kevinwong.module.sys.service.impl;

import com.kevinwong.module.sys.service.RelationService;
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

import com.kevinwong.module.sys.mapper.MenuMapper;
import com.kevinwong.module.sys.entity.MenuEntity;
import com.kevinwong.module.sys.service.MenuService;


@Service("menuService")
public class MenuServiceImpl extends ServiceImpl<MenuMapper, MenuEntity> implements MenuService {

    @Autowired
    private UserService userService;

    @Autowired
    private RelationService relationService;

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
        return null;
    }

    @Override
    public void delete(Long mwnuId) {

    }

}