package com.kevinwong.module.sys.mapper;

import com.kevinwong.module.sys.entity.LoginLogEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 登录记录
 * 
 * @author Eastascend <EastascendWang@gmail.com>
 * @date 2019-04-28 17:15:07
 */
@Mapper
public interface LoginLogMapper extends BaseMapper<LoginLogEntity> {
	
}
