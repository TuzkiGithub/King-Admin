package com.kevinwong.module.sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kevinwong.module.sys.entity.RoleEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 角色
 * 
 * @author Eastascend <EastascendWang@gmail.com>
 * @date 2019-06-05 10:09:11
 */
@Mapper
public interface RoleMapper extends BaseMapper<RoleEntity> {
	
}
