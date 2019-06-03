package com.kevinwong.module.sys.controller;

import com.kevinwong.module.sys.entity.UserEntity;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Controller公共组件
 */
public abstract class AbstractController {
	protected Logger logger = LoggerFactory.getLogger(getClass());

	protected static UserEntity getUser() {
		return (UserEntity) SecurityUtils.getSubject().getPrincipal();
	}

	protected static Long getUserId() {
		return getUser().getUserId();
	}
}
