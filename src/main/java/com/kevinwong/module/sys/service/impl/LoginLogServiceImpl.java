package com.kevinwong.module.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kevinwong.core.utils.PageUtils;
import com.kevinwong.core.utils.Query;

import com.kevinwong.module.sys.mapper.LoginLogMapper;
import com.kevinwong.module.sys.entity.LoginLogEntity;
import com.kevinwong.module.sys.service.LoginLogService;


@Service("loginLogService")
public class LoginLogServiceImpl extends ServiceImpl<LoginLogMapper, LoginLogEntity> implements LoginLogService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<LoginLogEntity> page = this.page(
                new Query<LoginLogEntity>().getPage(params),
                new QueryWrapper<LoginLogEntity>()
        );

        return new PageUtils(page);
    }

}