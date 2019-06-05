package com.kevinwong.module.sys.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 角色
 * 
 * @author Eastascend <EastascendWang@gmail.com>
 * @date 2019-06-05 10:09:11
 */
@Data
@TableName("sys_role")
public class RoleEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId(type = IdType.INPUT)
	private Long roleId;
	/**
	 * 角色名称
	 */
	private String roleName;
	/**
	 * 备注
	 */
	private String remark;
	/**
	 * 创建者ID
	 */
	private Long createUserId;
	/**
	 * 创建时间
	 */
	private Date createTime;

}
