package com.kevinwong.module.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 操作日志
 * 
 * @author Eastascend <EastascendWang@gmail.com>
 * @date 2019-04-28 17:15:07
 */
@Data
@TableName("sys_operation_log")
public class OperationLogEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@TableId
	private Long operationLogId;
	/**
	 * 日志类型(字典)
	 */
	private String logType;
	/**
	 * 日志名称
	 */
	private String logName;
	/**
	 * 用户id
	 */
	private Long userId;
	/**
	 * 类名称
	 */
	private String className;
	/**
	 * 方法名称
	 */
	private String method;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 是否成功(字典)
	 */
	private String succeed;
	/**
	 * 备注
	 */
	private String message;

}
