package com.kevinwong.module.sys.mapper;

import com.kevinwong.module.sys.entity.RoleEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 角色表
 * 
 * @author Eastascend <EastascendWang@gmail.com>
 * @date 2019-04-28 17:15:07
 */
@Mapper
public interface RoleMapper extends BaseMapper<RoleEntity> {
	
}
