package com.spring.kakao.service;

import java.util.List;

import com.spring.kakao.model.beans.NoticeBean;
import com.spring.kakao.model.dto.NoticeDto;
import com.spring.kakao.model.dto.NoticeInsertDto;

public interface NoticeService {
	
	public NoticeBean getNoticeBean(); // noticeBean 생성
	public int parseIntPageNumber(String pageNumber); // parameter가 string형태로 넘어오기 때문에 int로 바꿔주기
	public List<NoticeDto> getNoticeListAll();// 게시글 리스트 전부 가져오기
	public List<NoticeDto> getNoticeList(int pageNumber); // 필요한만큼(20개)씩 잘라서 넣는 list
	public NoticeDto fileUpload(NoticeInsertDto noticeInsertDto); // 파일 업로드
	public int noticeInsert(NoticeInsertDto noticeInsertDto); // insert 첨부파일 db에 넣기
	public int getNoticeMaxCode(); // 만약 코드번호가 200번이라면 201번에 insert해야한다.
	
}
