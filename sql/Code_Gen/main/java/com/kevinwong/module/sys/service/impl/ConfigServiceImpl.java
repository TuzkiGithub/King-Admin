package com.kevinwong.module.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kevinwong.core.utils.PageUtils;
import com.kevinwong.core.utils.Query;

import com.kevinwong.module.sys.mapper.ConfigMapper;
import com.kevinwong.module.sys.entity.ConfigEntity;
import com.kevinwong.module.sys.service.ConfigService;


@Service("configService")
public class ConfigServiceImpl extends ServiceImpl<ConfigMapper, ConfigEntity> implements ConfigService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ConfigEntity> page = this.page(
                new Query<ConfigEntity>().getPage(params),
                new QueryWrapper<ConfigEntity>()
        );

        return new PageUtils(page);
    }

}