package com.study.mybatis.service;


import org.apache.log4j.Logger;
import org.junit.Test;

import com.study.mybatis.model.User;

public class UserOperationTest {

	Logger LOGGER = org.apache.log4j.Logger.getLogger(User.class);
	@Test
	public void CreateUserTest() {
		UserOperation user = new UserOperation();
//		user.createUser();
		user.queryUser();
		LOGGER.debug("ABC");
	}
}
