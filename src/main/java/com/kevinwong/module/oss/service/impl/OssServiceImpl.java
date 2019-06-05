package com.kevinwong.module.oss.service.impl;

import com.kevinwong.module.oss.entity.OssEntity;
import com.kevinwong.module.oss.mapper.OssMapper;
import com.kevinwong.module.oss.service.OssService;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kevinwong.core.utils.PageUtils;
import com.kevinwong.core.utils.Query;


@Service("ossService")
public class OssServiceImpl extends ServiceImpl<OssMapper, OssEntity> implements OssService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<OssEntity> page = this.page(
                new Query<OssEntity>().getPage(params),
                new QueryWrapper<OssEntity>()
        );

        return new PageUtils(page);
    }

}