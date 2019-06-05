package com.kevinwong.module.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

import com.mysql.cj.jdbc.Blob;
import lombok.Data;

/**
 * 
 * 
 * @author Eastascend <EastascendWang@gmail.com>
 * @date 2019-06-05 10:09:10
 */
@Data
@TableName("qrtz_calendars")
public class QrtzCalendarsEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private String schedName;
	/**
	 * 
	 */
	private String calendarName;
	/**
	 * 
	 */
	private Blob calendar;

}
