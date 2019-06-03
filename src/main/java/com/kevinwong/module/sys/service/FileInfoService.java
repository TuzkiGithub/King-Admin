package com.kevinwong.module.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kevinwong.core.utils.PageUtils;
import com.kevinwong.module.sys.entity.FileInfoEntity;

import java.util.Map;

/**
 * 文件信息表

 *
 * @author Eastascend <EastascendWang@gmail.com>
 * @date 2019-04-28 17:15:07
 */
public interface FileInfoService extends IService<FileInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

