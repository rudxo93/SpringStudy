package com.springboot.study.model.dao;

import org.apache.ibatis.annotations.Mapper;

import com.springboot.study.model.vo.Login;

@Mapper
public interface LoginDao {
	 
	public int login(Login login);

}
 