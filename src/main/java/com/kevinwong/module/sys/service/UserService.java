package com.kevinwong.module.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kevinwong.core.utils.PageUtils;
import com.kevinwong.module.sys.entity.UserEntity;

import java.util.List;
import java.util.Map;

/**
 * 管理员表
 *
 * @author Eastascend <EastascendWang@gmail.com>
 * @date 2019-04-28 17:15:07
 */
public interface UserService extends IService<UserEntity> {

    PageUtils queryPage(Map<String, Object> params);

    UserEntity queryByUserName(String username);

    List<Long> queryAllMenuId(Long userId);
}

