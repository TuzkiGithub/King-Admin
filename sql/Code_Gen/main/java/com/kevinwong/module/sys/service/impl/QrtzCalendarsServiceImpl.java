package com.kevinwong.module.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kevinwong.core.utils.PageUtils;
import com.kevinwong.core.utils.Query;

import com.kevinwong.module.sys.mapper.QrtzCalendarsMapper;
import com.kevinwong.module.sys.entity.QrtzCalendarsEntity;
import com.kevinwong.module.sys.service.QrtzCalendarsService;


@Service("qrtzCalendarsService")
public class QrtzCalendarsServiceImpl extends ServiceImpl<QrtzCalendarsMapper, QrtzCalendarsEntity> implements QrtzCalendarsService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<QrtzCalendarsEntity> page = this.page(
                new Query<QrtzCalendarsEntity>().getPage(params),
                new QueryWrapper<QrtzCalendarsEntity>()
        );

        return new PageUtils(page);
    }

}