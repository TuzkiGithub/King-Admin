package com.kevinwong.module.sys.mapper;

import com.kevinwong.module.sys.entity.MenuEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 菜单表
 * 
 * @author Eastascend <EastascendWang@gmail.com>
 * @date 2019-04-28 17:15:07
 */
@Mapper
public interface MenuMapper extends BaseMapper<MenuEntity> {

    /**
     * 根据父菜单，查询子菜单
     * @param parentId
     * @return
     */
    List<MenuEntity> queryListByParentId(Long parentId);

    /**
     * 获取不包含按钮的菜单列表
     * @return
     */
    List<MenuEntity> queryNotButtonList();
}
