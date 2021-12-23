package com.spring.kakao.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.kakao.model.beans.NoticeBean;
import com.spring.kakao.model.dao.NoticeDao;
import com.spring.kakao.model.dto.NoticeDto;

@Service
public class NoticeServiceImpl implements NoticeService {

	@Autowired
	private NoticeDao noticeDao;
	
	private NoticeBean noticeBean;
	private List<NoticeDto> noticeListAll;
	
	public void setNoticeBean(int pageNumber) {
		noticeBean = new NoticeBean(); // 객체 생성
		noticeBean.setNoticeTotalCount(noticeListAll.size()); // 리스트의 최대 크기
		// 페이징 처리
		noticeBean.setPageNumber(pageNumber);
		noticeBean.setStartIndex();
		noticeBean.setEndIndex(); 
		noticeBean.setTotalPage();
		noticeBean.setStartPage();
		noticeBean.setEndPage();
	}
	
	@Override
	public NoticeBean getNoticeBean() { // getter
		return noticeBean;
	}

	// String형태로 넘어오는 pageNumber를 int로 변환
	@Override
	public int parseIntPageNumber(String pageNumber) {
		return Integer.parseInt(pageNumber);
	}
	
	@Override
	public List<NoticeDto> getNoticeListAll() { // 다른곳에서 사용할 일이 있을 수 있다.
		return noticeDao.getNoticeListAll();
	}
	
	@Override
	public List<NoticeDto> getNoticeList(int pageNumber) { // 리스트 가져오는 로직 완성
		noticeListAll = getNoticeListAll();
		List<NoticeDto> noticeList = new ArrayList<NoticeDto>();
		
		setNoticeBean(pageNumber);
		
		for(int i = noticeBean.getStartIndex(); i < noticeBean.getEndIndex() && i < noticeBean.getNoticeTotalCount(); i++) { // 페이징 처리 for문
			noticeList.add(noticeListAll.get(i));
		}
		return noticeList;
	}
	
}
