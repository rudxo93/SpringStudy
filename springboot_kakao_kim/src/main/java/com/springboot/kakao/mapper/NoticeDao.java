package com.springboot.kakao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.springboot.kakao.model.dto.NoticeDto;

@Mapper
public interface NoticeDao {

	public List<NoticeDto> getNoticeListAll(); // 게시글 리스트 전부 
	public int getNoticeMaxCode();
	public int noticeMstInsert(NoticeDto noticeDto); // noticeDto  전달
	public int noticeDtlInsert(NoticeDto noticeDto);
	public NoticeDto getNotice(int notice_code); // dtl페이지
	public int plusNoticeCount(int notice_code); // 조회수 증가
	public int noticeMstDelete(int notice_code); // 게시글 삭제
	public int noticeDtlDelete(int notice_code);  // 게시글 삭제
	
}
