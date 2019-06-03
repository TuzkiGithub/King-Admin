package com.kevinwong.module.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kevinwong.core.utils.PageUtils;
import com.kevinwong.core.utils.Query;

import com.kevinwong.module.sys.mapper.OperationLogMapper;
import com.kevinwong.module.sys.entity.OperationLogEntity;
import com.kevinwong.module.sys.service.OperationLogService;


@Service("operationLogService")
public class OperationLogServiceImpl extends ServiceImpl<OperationLogMapper, OperationLogEntity> implements OperationLogService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<OperationLogEntity> page = this.page(
                new Query<OperationLogEntity>().getPage(params),
                new QueryWrapper<OperationLogEntity>()
        );

        return new PageUtils(page);
    }

}