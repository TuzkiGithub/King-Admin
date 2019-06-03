package com.kevinwong.module.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 登录记录
 * 
 * @author Eastascend <EastascendWang@gmail.com>
 * @date 2019-04-28 17:15:07
 */
@Data
@TableName("sys_login_log")
public class LoginLogEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@TableId
	private Long loginLogId;
	/**
	 * 日志名称
	 */
	private String logName;
	/**
	 * 管理员id
	 */
	private Long userId;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 是否执行成功
	 */
	private String succeed;
	/**
	 * 具体消息
	 */
	private String message;
	/**
	 * 登录ip
	 */
	private String ipAddress;

}
