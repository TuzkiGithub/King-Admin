package com.kevinwong.module.job.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kevinwong.module.job.entity.ScheduleJobEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 定时任务
 * 
 * @author Eastascend <EastascendWang@gmail.com>
 * @date 2019-06-05 10:09:10
 */
@Mapper
public interface ScheduleJobMapper extends BaseMapper<ScheduleJobEntity> {
	
}
