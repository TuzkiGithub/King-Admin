package com.kevinwong.module.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 角色和菜单关联表
 * 
 * @author Eastascend <EastascendWang@gmail.com>
 * @date 2019-04-28 17:15:07
 */
@Data
@TableName("sys_relation")
public class RelationEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@TableId
	private Long relationId;
	/**
	 * 菜单id
	 */
	private Long menuId;
	/**
	 * 角色id
	 */
	private Long roleId;

}
