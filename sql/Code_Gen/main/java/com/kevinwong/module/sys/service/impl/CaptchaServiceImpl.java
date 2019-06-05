package com.kevinwong.module.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kevinwong.core.utils.PageUtils;
import com.kevinwong.core.utils.Query;

import com.kevinwong.module.sys.service.CaptchaService;


@Service("captchaService")
public class CaptchaServiceImpl extends ServiceImpl<CaptchaMapper, CaptchaEntity> implements CaptchaService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CaptchaEntity> page = this.page(
                new Query<CaptchaEntity>().getPage(params),
                new QueryWrapper<CaptchaEntity>()
        );

        return new PageUtils(page);
    }

}