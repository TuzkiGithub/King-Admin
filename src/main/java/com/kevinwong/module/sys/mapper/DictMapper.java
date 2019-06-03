package com.kevinwong.module.sys.mapper;

import com.kevinwong.module.sys.entity.DictEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 字典表
 * 
 * @author Eastascend <EastascendWang@gmail.com>
 * @date 2019-04-28 17:15:07
 */
@Mapper
public interface DictMapper extends BaseMapper<DictEntity> {
	
}
