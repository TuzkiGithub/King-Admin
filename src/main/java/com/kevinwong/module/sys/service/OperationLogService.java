package com.kevinwong.module.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kevinwong.core.utils.PageUtils;
import com.kevinwong.module.sys.entity.OperationLogEntity;

import java.util.Map;

/**
 * 操作日志
 *
 * @author Eastascend <EastascendWang@gmail.com>
 * @date 2019-04-28 17:15:07
 */
public interface OperationLogService extends IService<OperationLogEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

