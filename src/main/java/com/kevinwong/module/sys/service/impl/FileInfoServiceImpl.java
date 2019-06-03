package com.kevinwong.module.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kevinwong.core.utils.PageUtils;
import com.kevinwong.core.utils.Query;

import com.kevinwong.module.sys.mapper.FileInfoMapper;
import com.kevinwong.module.sys.entity.FileInfoEntity;
import com.kevinwong.module.sys.service.FileInfoService;


@Service("fileInfoService")
public class FileInfoServiceImpl extends ServiceImpl<FileInfoMapper, FileInfoEntity> implements FileInfoService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<FileInfoEntity> page = this.page(
                new Query<FileInfoEntity>().getPage(params),
                new QueryWrapper<FileInfoEntity>()
        );

        return new PageUtils(page);
    }

}