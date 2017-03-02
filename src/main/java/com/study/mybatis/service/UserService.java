package com.study.mybatis.service;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.study.mybatis.inter.UserMapper;
import com.study.mybatis.model.User;
import com.study.mybatis.model.UserExample;

public class UserService {

	public void insertUser(User user) {
		SqlSession sqlSession = BatisUtil.getSqlSessionFactory().openSession();
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			userMapper.insert(user);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}

	public User getUserById(Integer userId) {
		SqlSession sqlSession = BatisUtil.getSqlSessionFactory().openSession();
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			return userMapper.selectByPrimaryKey(userId);
		} finally {
			sqlSession.close();
		}
	}

	public void deleteUser(Integer userId) {
		SqlSession sqlSession = BatisUtil.getSqlSessionFactory().openSession();
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			userMapper.deleteByPrimaryKey(userId);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}

	}
	public List<User> queryUserByTime(Date date) {
		SqlSession sqlSession = BatisUtil.getSqlSessionFactory().openSession();
		try{
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			UserExample example = new UserExample();
			example.createCriteria().andCreateOnGreaterThanOrEqualTo(date).andCreateOnLessThanOrEqualTo(date);
			List<User> users = userMapper.selectByExample(example);
			sqlSession.commit();
			return users;
		} finally {
			sqlSession.close();
		}
	}

}