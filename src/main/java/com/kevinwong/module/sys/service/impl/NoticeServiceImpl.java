package com.kevinwong.module.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kevinwong.core.utils.PageUtils;
import com.kevinwong.core.utils.Query;

import com.kevinwong.module.sys.mapper.NoticeMapper;
import com.kevinwong.module.sys.entity.NoticeEntity;
import com.kevinwong.module.sys.service.NoticeService;


@Service("noticeService")
public class NoticeServiceImpl extends ServiceImpl<NoticeMapper, NoticeEntity> implements NoticeService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<NoticeEntity> page = this.page(
                new Query<NoticeEntity>().getPage(params),
                new QueryWrapper<NoticeEntity>()
        );

        return new PageUtils(page);
    }

}