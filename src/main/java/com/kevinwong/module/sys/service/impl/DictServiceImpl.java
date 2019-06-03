package com.kevinwong.module.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kevinwong.core.utils.PageUtils;
import com.kevinwong.core.utils.Query;

import com.kevinwong.module.sys.mapper.DictMapper;
import com.kevinwong.module.sys.entity.DictEntity;
import com.kevinwong.module.sys.service.DictService;


@Service("dictService")
public class DictServiceImpl extends ServiceImpl<DictMapper, DictEntity> implements DictService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<DictEntity> page = this.page(
                new Query<DictEntity>().getPage(params),
                new QueryWrapper<DictEntity>()
        );

        return new PageUtils(page);
    }

}