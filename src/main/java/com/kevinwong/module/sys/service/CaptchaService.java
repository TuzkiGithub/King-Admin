package com.kevinwong.module.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kevinwong.core.utils.PageUtils;
import com.kevinwong.module.sys.entity.CaptchaEntity;

import java.awt.image.BufferedImage;
import java.util.Map;

/**
 * 系统验证码
 *
 * @author Eastascend <EastascendWang@gmail.com>
 * @date 2019-04-30 10:23:47
 */
public interface CaptchaService extends IService<CaptchaEntity> {

    BufferedImage getCaptcha(String uuid);

    boolean validate(String uuid, String code);

}

