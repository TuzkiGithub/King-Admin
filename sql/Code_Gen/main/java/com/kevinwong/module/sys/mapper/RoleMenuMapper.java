package com.kevinwong.module.sys.mapper;

import com.kevinwong.module.sys.entity.RoleMenuEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 角色与菜单对应关系
 * 
 * @author Eastascend <EastascendWang@gmail.com>
 * @date 2019-06-05 10:09:11
 */
@Mapper
public interface RoleMenuMapper extends BaseMapper<RoleMenuEntity> {
	
}
