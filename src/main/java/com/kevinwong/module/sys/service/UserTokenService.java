package com.kevinwong.module.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kevinwong.core.utils.K;
import com.kevinwong.core.utils.PageUtils;
import com.kevinwong.module.sys.entity.UserTokenEntity;

import java.util.Map;

/**
 * 系统用户Token
 *
 * @author Eastascend <EastascendWang@gmail.com>
 * @date 2019-04-30 10:18:22
 */
public interface UserTokenService extends IService<UserTokenEntity> {

    PageUtils queryPage(Map<String, Object> params);

    K createToken(Long userId);

    void logout(Long userId);
}

