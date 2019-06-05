package com.kevinwong.module.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kevinwong.core.utils.PageUtils;
import com.kevinwong.core.utils.Query;

import com.kevinwong.module.sys.mapper.QrtzCronTriggersMapper;
import com.kevinwong.module.sys.entity.QrtzCronTriggersEntity;
import com.kevinwong.module.sys.service.QrtzCronTriggersService;


@Service("qrtzCronTriggersService")
public class QrtzCronTriggersServiceImpl extends ServiceImpl<QrtzCronTriggersMapper, QrtzCronTriggersEntity> implements QrtzCronTriggersService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<QrtzCronTriggersEntity> page = this.page(
                new Query<QrtzCronTriggersEntity>().getPage(params),
                new QueryWrapper<QrtzCronTriggersEntity>()
        );

        return new PageUtils(page);
    }

}