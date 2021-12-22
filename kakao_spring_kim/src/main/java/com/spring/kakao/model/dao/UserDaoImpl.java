package com.spring.kakao.model.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.kakao.model.json.SignUpVo;

@Repository
public class UserDaoImpl implements UserDao {
	
	@Autowired
	private SqlSession session;
	
	private static final String NAME_SPACE = "com.spring.kakao.model.dao.UserDao.";
	
	@Override
	public int emailCheck(String signUpEmail) {
		return session.selectOne(NAME_SPACE + "emailCheck", signUpEmail);
	}
	
	@Override
	public int phoneCheck(SignUpVo signUpVo) {
		return session.selectOne(NAME_SPACE + "phoneCheck", signUpVo);
	}
	
	@Override
	public int signUp(SignUpVo signUpVo) {
		return session.insert(NAME_SPACE + "signUp", signUpVo);
	}

}
