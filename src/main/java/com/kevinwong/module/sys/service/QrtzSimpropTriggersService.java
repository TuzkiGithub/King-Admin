package com.kevinwong.module.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kevinwong.core.utils.PageUtils;
import com.kevinwong.module.sys.entity.QrtzSimpropTriggersEntity;

import java.util.Map;

/**
 * 
 *
 * @author Eastascend <EastascendWang@gmail.com>
 * @date 2019-06-05 10:09:10
 */
public interface QrtzSimpropTriggersService extends IService<QrtzSimpropTriggersEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

