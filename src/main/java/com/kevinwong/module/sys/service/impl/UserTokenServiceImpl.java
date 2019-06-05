package com.kevinwong.module.sys.service.impl;

import com.kevinwong.core.utils.K;
import com.kevinwong.module.sys.entity.UserTokenEntity;
import com.kevinwong.module.sys.mapper.UserTokenMapper;
import com.kevinwong.module.sys.oauth2.TokenGenerator;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kevinwong.core.utils.PageUtils;
import com.kevinwong.core.utils.Query;

import com.kevinwong.module.sys.service.UserTokenService;


@Service("userTokenService")
public class UserTokenServiceImpl extends ServiceImpl<UserTokenMapper, UserTokenEntity> implements UserTokenService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<UserTokenEntity> page = this.page(
                new Query<UserTokenEntity>().getPage(params),
                new QueryWrapper<UserTokenEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public K createToken(Long userId) {
        return null;
    }

    @Override
    public void logout(Long userId) {
        String token = TokenGenerator.generateValue();

        UserTokenEntity tokenEntity = new UserTokenEntity();
        tokenEntity.setUserId(userId);
        tokenEntity.setToken(token);
        this.updateById(tokenEntity);
    }

}