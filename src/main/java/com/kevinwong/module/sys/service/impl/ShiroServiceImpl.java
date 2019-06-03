package com.kevinwong.module.sys.service.impl;


import com.kevinwong.core.utils.Constant;
import com.kevinwong.module.sys.entity.MenuEntity;
import com.kevinwong.module.sys.entity.UserEntity;
import com.kevinwong.module.sys.entity.UserTokenEntity;
import com.kevinwong.module.sys.mapper.MenuMapper;
import com.kevinwong.module.sys.mapper.UserMapper;
import com.kevinwong.module.sys.mapper.UserTokenMapper;
import com.kevinwong.module.sys.service.ShiroService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ShiroServiceImpl implements ShiroService {
    @Autowired
    private MenuMapper menuMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserTokenMapper userTokenMapper;

    @Override
    public Set<String> getUserPermissions(long userId) {
        List<String> permsList;

        //系统管理员，拥有最高权限
        if(userId == Constant.SUPER_ADMIN){
            List<MenuEntity> menuList = menuMapper.selectList(null);
            permsList = new ArrayList<>(menuList.size());
            for(MenuEntity menu : menuList){
                permsList.add(menu.getPerms());
            }
        }else{
            permsList = userMapper.queryAllPerms(userId);
        }
        //用户权限列表
        Set<String> permsSet = new HashSet<>();
        for(String perms : permsList){
            if(StringUtils.isBlank(perms)){
                continue;
            }
            permsSet.addAll(Arrays.asList(perms.trim().split(",")));
        }
        return permsSet;
    }

    @Override
    public UserTokenEntity queryByToken(String token) {
        return userTokenMapper.queryByToken(token);
    }

    @Override
    public UserEntity queryUser(Long userId) {
        return userMapper.selectById(userId);
    }
}
