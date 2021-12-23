package com.spring.kakao.model.dao;

import java.util.List;

import com.spring.kakao.model.dto.NoticeDto;

public interface NoticeDao {

	public List<NoticeDto> getNoticeListAll(); // 게시글 리스트 전부 
	
}
