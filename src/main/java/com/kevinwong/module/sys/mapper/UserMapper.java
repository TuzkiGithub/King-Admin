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

    List<String> queryAllPerms(long userId);

    UserEntity queryByUserName(String username);

    List<Long> queryAllMenuId(Long userId);
}
