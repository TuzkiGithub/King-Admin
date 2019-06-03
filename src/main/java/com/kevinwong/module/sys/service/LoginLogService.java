package com.kevinwong.module.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kevinwong.core.utils.PageUtils;
import com.kevinwong.module.sys.entity.LoginLogEntity;

import java.util.Map;

/**
 * 登录记录
 *
 * @author Eastascend <EastascendWang@gmail.com>
 * @date 2019-04-28 17:15:07
 */
public interface LoginLogService extends IService<LoginLogEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

