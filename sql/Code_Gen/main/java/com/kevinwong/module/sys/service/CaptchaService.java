package com.kevinwong.module.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kevinwong.core.utils.PageUtils;

import java.util.Map;

/**
 * 系统验证码
 *
 * @author Eastascend <EastascendWang@gmail.com>
 * @date 2019-06-05 10:09:10
 */
public interface CaptchaService extends IService<CaptchaEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

