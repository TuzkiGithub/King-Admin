package com.kevinwong.module.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kevinwong.core.utils.PageUtils;
import com.kevinwong.module.sys.entity.RelationEntity;

import java.util.Map;

/**
 * 角色和菜单关联表
 *
 * @author Eastascend <EastascendWang@gmail.com>
 * @date 2019-04-28 17:15:07
 */
public interface RelationService extends IService<RelationEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

