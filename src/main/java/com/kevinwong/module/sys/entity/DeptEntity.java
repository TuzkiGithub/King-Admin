package com.kevinwong.module.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 部门表
 * 
 * @author Eastascend <EastascendWang@gmail.com>
 * @date 2019-04-28 17:15:07
 */
@Data
@TableName("sys_dept")
public class DeptEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键id
	 */
	@TableId
	private Long deptId;
	/**
	 * 父部门id
	 */
	private Long pid;
	/**
	 * 父级ids
	 */
	private String pids;
	/**
	 * 简称
	 */
	private String simpleName;
	/**
	 * 全称
	 */
	private String fullName;
	/**
	 * 描述
	 */
	private String description;
	/**
	 * 版本（乐观锁保留字段）
	 */
	private Integer version;
	/**
	 * 排序
	 */
	private Integer sort;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 修改时间
	 */
	private Date updateTime;
	/**
	 * 创建人
	 */
	private Long createUser;
	/**
	 * 修改人
	 */
	private Long updateUser;

}
