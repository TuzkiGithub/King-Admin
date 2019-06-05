package com.kevinwong.module.oss.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kevinwong.module.oss.entity.OssEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 文件上传
 * 
 * @author Eastascend <EastascendWang@gmail.com>
 * @date 2019-06-05 10:09:11
 */
@Mapper
public interface OssMapper extends BaseMapper<OssEntity> {
	
}
