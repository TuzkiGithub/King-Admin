package com.kevinwong.module.sys.service;

import com.kevinwong.module.sys.entity.UserEntity;
import com.kevinwong.module.sys.entity.UserTokenEntity;

import java.util.Set;

/**
 * shiro相关接口
 *
 */
public interface ShiroService {
    /**
     * 获取用户权限列表
     */
    Set<String> getUserPermissions(long userId);

    UserTokenEntity queryByToken(String token);

    /**
     * 根据用户ID，查询用户
     * @param userId
     */
    UserEntity queryUser(Long userId);
}
