package com.kevinwong.module.sys.service.impl;

import com.kevinwong.module.sys.entity.RoleEntity;
import com.kevinwong.module.sys.mapper.RoleMapper;
import com.kevinwong.module.sys.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kevinwong.core.utils.PageUtils;
import com.kevinwong.core.utils.Query;


@Service("roleService")
public class RoleServiceImpl extends ServiceImpl<RoleMapper, RoleEntity> implements RoleService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<RoleEntity> page = this.page(
                new Query<RoleEntity>().getPage(params),
                new QueryWrapper<RoleEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<Long> queryMenuList(Long roleId) {
        return null;
    }

}