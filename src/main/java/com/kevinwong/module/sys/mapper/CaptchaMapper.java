package com.kevinwong.module.sys.mapper;

import com.kevinwong.module.sys.entity.CaptchaEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 系统验证码
 * 
 * @author Eastascend <EastascendWang@gmail.com>
 * @date 2019-04-30 10:23:47
 */
@Mapper
public interface CaptchaMapper extends BaseMapper<CaptchaEntity> {
	
}
