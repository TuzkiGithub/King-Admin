package com.kevinwong.module.sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kevinwong.module.sys.entity.CaptchaEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 系统验证码
 * 
 * @author Eastascend <EastascendWang@gmail.com>
 * @date 2019-06-05 10:09:10
 */
@Mapper
public interface CaptchaMapper extends BaseMapper<CaptchaEntity> {
	
}
