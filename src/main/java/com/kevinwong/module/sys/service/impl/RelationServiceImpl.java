package com.kevinwong.module.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kevinwong.core.utils.PageUtils;
import com.kevinwong.core.utils.Query;

import com.kevinwong.module.sys.mapper.RelationMapper;
import com.kevinwong.module.sys.entity.RelationEntity;
import com.kevinwong.module.sys.service.RelationService;


@Service("relationService")
public class RelationServiceImpl extends ServiceImpl<RelationMapper, RelationEntity> implements RelationService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<RelationEntity> page = this.page(
                new Query<RelationEntity>().getPage(params),
                new QueryWrapper<RelationEntity>()
        );

        return new PageUtils(page);
    }

}