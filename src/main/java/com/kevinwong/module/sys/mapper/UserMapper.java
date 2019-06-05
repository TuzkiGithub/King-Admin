package com.kevinwong.module.sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kevinwong.module.sys.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 系统用户
 * 
 * @author Eastascend <EastascendWang@gmail.com>
 * @date 2019-06-05 10:09:10
 */
@Mapper
public interface UserMapper extends BaseMapper<UserEntity> {

    /**
     * 查询用户所有权限
     * @param userId
     * @return
     */
    List<String> queryAllPerms(long userId);

    /**
     * 根据用户名，查询系统用户
     * @param username
     * @return
     */
    UserEntity queryByUserName(String username);

    /**
     * 查询用户的所有菜单ID
     * @param userId
     * @return
     */
    List<Long> queryAllMenuId(Long userId);
}
