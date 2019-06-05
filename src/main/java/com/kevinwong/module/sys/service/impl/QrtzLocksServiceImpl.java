package com.kevinwong.module.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kevinwong.core.utils.PageUtils;
import com.kevinwong.core.utils.Query;

import com.kevinwong.module.sys.mapper.QrtzLocksMapper;
import com.kevinwong.module.sys.entity.QrtzLocksEntity;
import com.kevinwong.module.sys.service.QrtzLocksService;


@Service("qrtzLocksService")
public class QrtzLocksServiceImpl extends ServiceImpl<QrtzLocksMapper, QrtzLocksEntity> implements QrtzLocksService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<QrtzLocksEntity> page = this.page(
                new Query<QrtzLocksEntity>().getPage(params),
                new QueryWrapper<QrtzLocksEntity>()
        );

        return new PageUtils(page);
    }

}