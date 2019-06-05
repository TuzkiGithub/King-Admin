package com.kevinwong.module.oss.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kevinwong.core.utils.PageUtils;
import com.kevinwong.module.oss.entity.OssEntity;

import java.util.Map;

/**
 * 文件上传
 *
 * @author Eastascend <EastascendWang@gmail.com>
 * @date 2019-06-05 10:09:11
 */
public interface OssService extends IService<OssEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

