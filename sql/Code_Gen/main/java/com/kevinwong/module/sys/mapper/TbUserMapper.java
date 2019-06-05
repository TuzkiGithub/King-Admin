package com.kevinwong.module.sys.mapper;

import com.kevinwong.module.sys.entity.TbUserEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户
 * 
 * @author Eastascend <EastascendWang@gmail.com>
 * @date 2019-06-05 10:09:10
 */
@Mapper
public interface TbUserMapper extends BaseMapper<TbUserEntity> {
	
}
