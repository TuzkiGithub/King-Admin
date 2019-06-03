package com.kevinwong.module.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kevinwong.core.utils.PageUtils;
import com.kevinwong.core.utils.Query;

import com.kevinwong.module.sys.mapper.DeptMapper;
import com.kevinwong.module.sys.entity.DeptEntity;
import com.kevinwong.module.sys.service.DeptService;


@Service("deptService")
public class DeptServiceImpl extends ServiceImpl<DeptMapper, DeptEntity> implements DeptService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<DeptEntity> page = this.page(
                new Query<DeptEntity>().getPage(params),
                new QueryWrapper<DeptEntity>()
        );

        return new PageUtils(page);
    }

}