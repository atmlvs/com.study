package com.study.mybatis.service;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.apache.log4j.*;
import com.study.mybatis.model.User;

public class UserOperation {
	Logger LOGGER = org.apache.log4j.Logger.getLogger(UserOperation.class);

	public void createUser() {
		UserService service = new UserService();
		User user = new User();
		user.setId(1);
		user.setUsername("omc");
		user.setCreateOn(new Date());
		service.insertUser(user);
		User added = service.getUserById(user.getId());
		LOGGER.info("added: " + added.getId());
	}
	
	public void queryUser() {
		UserService service = new UserService();
//		User user = new User();
//		Date current = new Date();
//		Calendar cal = Calendar.getInstance();
//		cal.setTime(current);
//		cal.add(Calendar.HOUR, -1);
//		Date date = cal.getTime();
		Date date1 = new Date(1488474372863L);
		LOGGER.info(date1.toString());
		try{
		
			Date date = new Date(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse("2017-03-03 01:06:12").getTime());
			List<User> users = service.queryUserByTime(date);
			User user = service.getUserById(1);
			LOGGER.info("user1: " + user.getCreateOn());
			LOGGER.info("queried: " + users.get(0).getId());
			LOGGER.info("queried: " + date.toString());	
		}
		catch (Exception e) {
			LOGGER.debug("Exception-----");
			LOGGER.debug(e);
		}
			
	}
	
//	public static void main(String[] args) {
//		UserOperation user = new UserOperation();
//		user.createUser();
//	}

}
