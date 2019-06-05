package com.kevinwong.module.sys.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 系统用户Token
 * 
 * @author Eastascend <EastascendWang@gmail.com>
 * @date 2019-06-05 10:09:10
 */
@Data
@TableName("sys_user_token")
public class UserTokenEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 用户ID
	 */
	@TableId(type = IdType.INPUT)
	private Long userId;
	/**
	 * token
	 */
	private String token;
	/**
	 * 过期时间
	 */
	private Date expireTime;
	/**
	 * 更新时间
	 */
	private Date updateTime;

}
