package com.kevinwong.core.utils;


import cn.hutool.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

/**
 * 返回数据
 * 
 * @author Eastascend <EastascendWang@gmail.com>
 */
public class K extends HashMap<String, Object> {
	private static final long serialVersionUID = 1L;
	
	public K() {
		put("code", 0);
	}
	
	public static K error() {
		return error(HttpStatus.HTTP_INTERNAL_ERROR, "未知异常，请联系管理员");
	}
	
	public static K error(String msg) {
		return error(HttpStatus.HTTP_INTERNAL_ERROR, msg);
	}
	
	public static K error(int code, String msg) {
		K k = new K();
		k.put("code", code);
		k.put("msg", msg);
		return k;
	}

	public static K ok(String msg) {
		K k = new K();
		k.put("msg", msg);
		return k;
	}
	
	public static K ok(Map<String, Object> map) {
		K k = new K();
		k.putAll(map);
		return k;
	}
	
	public static K ok() {
		return new K();
	}

	public K put(String key, Object value) {
		super.put(key, value);
		return this;
	}
}
