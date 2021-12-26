package com.spring.kakao.model.dao;

import java.util.List;

import com.spring.kakao.model.dto.NoticeDto;

public interface NoticeDao {

	public List<NoticeDto> getNoticeListAll(); // 게시글 리스트 전부 
	public int getNoticeMaxCode();
	public int noticeMstInsert(NoticeDto noticeDto); // noticeDto  전달
	public int noticeDtlInsert(NoticeDto noticeDto);
	
}
