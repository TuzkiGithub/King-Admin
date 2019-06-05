package com.kevinwong.module.sys.mapper;

import com.kevinwong.module.sys.entity.UserRoleEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户与角色对应关系
 * 
 * @author Eastascend <EastascendWang@gmail.com>
 * @date 2019-06-05 10:09:10
 */
@Mapper
public interface UserRoleMapper extends BaseMapper<UserRoleEntity> {
	
}
