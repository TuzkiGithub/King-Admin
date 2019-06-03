package com.kevinwong.module.sys.mapper;

import com.kevinwong.module.sys.entity.UserTokenEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 系统用户Token
 * 
 * @author Eastascend <EastascendWang@gmail.com>
 * @date 2019-04-30 10:18:22
 */
@Mapper
public interface UserTokenMapper extends BaseMapper<UserTokenEntity> {

    UserTokenEntity queryByToken(String token);
}
