package com.kevinwong.module.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 角色表
 * 
 * @author Eastascend <EastascendWang@gmail.com>
 * @date 2019-04-28 17:15:07
 */
@Data
@TableName("sys_role")
public class RoleEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键id
	 */
	@TableId
	private Long roleId;
	/**
	 * 父角色id
	 */
	private Long pid;
	/**
	 * 角色名称
	 */
	private String name;
	/**
	 * 提示
	 */
	private String description;
	/**
	 * 序号
	 */
	private Integer sort;
	/**
	 * 乐观锁
	 */
	private Integer version;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 修改时间
	 */
	private Date updateTime;
	/**
	 * 创建用户
	 */
	private Long createUser;
	/**
	 * 修改用户
	 */
	private Long updateUser;

}
