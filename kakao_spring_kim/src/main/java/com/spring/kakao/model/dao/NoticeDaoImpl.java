package com.spring.kakao.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.kakao.model.dto.NoticeDto;

@Repository
public class NoticeDaoImpl implements NoticeDao{

	@Autowired
	private SqlSession session;
	
	private static final String NAME_SPACE = "com.spring.kakao.model.dao.NoticeDao.";
	
	@Override
	public List<NoticeDto> getNoticeListAll() {
		return session.selectList(NAME_SPACE + "getnoticeListAll");
	}
	
}
