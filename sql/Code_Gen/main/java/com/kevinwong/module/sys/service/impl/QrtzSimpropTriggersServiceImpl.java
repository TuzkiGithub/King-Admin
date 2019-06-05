package com.kevinwong.module.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kevinwong.core.utils.PageUtils;
import com.kevinwong.core.utils.Query;

import com.kevinwong.module.sys.mapper.QrtzSimpropTriggersMapper;
import com.kevinwong.module.sys.entity.QrtzSimpropTriggersEntity;
import com.kevinwong.module.sys.service.QrtzSimpropTriggersService;


@Service("qrtzSimpropTriggersService")
public class QrtzSimpropTriggersServiceImpl extends ServiceImpl<QrtzSimpropTriggersMapper, QrtzSimpropTriggersEntity> implements QrtzSimpropTriggersService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<QrtzSimpropTriggersEntity> page = this.page(
                new Query<QrtzSimpropTriggersEntity>().getPage(params),
                new QueryWrapper<QrtzSimpropTriggersEntity>()
        );

        return new PageUtils(page);
    }

}