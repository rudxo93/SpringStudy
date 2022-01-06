package com.springboot.kakao.model.dto;

import java.util.Arrays;

import org.springframework.web.multipart.MultipartFile;

public class NoticeUpdateDto {
	
	private int notice_code;
	private String notice_content;
	private MultipartFile[] notice_file; // 추가될 파일 받아오기
	private String[] originFileNames; //ㄱ
	private String[] tempFileNames; // ㅡㄴ 기존 항목 가져오기
	private String[] deleteOriginFileNames; //ㄱ 
	private String[] deleteTempFileNames; // ㅡㄴ 지울 항목
	
	public int getNotice_code() {
		return notice_code;
	}
	public void setNotice_code(int notice_code) {
		this.notice_code = notice_code;
	}
	public String getNotice_content() {
		return notice_content;
	}
	public void setNotice_content(String notice_content) {
		this.notice_content = notice_content;
	}
	public MultipartFile[] getNotice_file() {
		return notice_file;
	}
	public void setNotice_file(MultipartFile[] notice_file) {
		this.notice_file = notice_file;
	}
	public String[] getOriginFileNames() {
		return originFileNames;
	}
	public void setOriginFileNames(String[] originFileNames) {
		this.originFileNames = originFileNames;
	}
	public String[] getTempFileNames() {
		return tempFileNames;
	}
	public void setTempFileNames(String[] tempFileNames) {
		this.tempFileNames = tempFileNames;
	}
	public String[] getDeleteOriginFileNames() {
		return deleteOriginFileNames;
	}
	public void setDeleteOriginFileNames(String[] deleteOriginFileNames) {
		this.deleteOriginFileNames = deleteOriginFileNames;
	}
	public String[] getDeleteTempFileNames() {
		return deleteTempFileNames;
	}
	public void setDeleteTempFileNames(String[] deleteTempFileNames) {
		this.deleteTempFileNames = deleteTempFileNames;
	}
	
	@Override
	public String toString() {
		return "NoticeUpdateDto [notice_code=" + notice_code + ", notice_content=" + notice_content + ", notice_file="
				+ Arrays.toString(notice_file) + ", originFileNames=" + Arrays.toString(originFileNames)
				+ ", tempFileNames=" + Arrays.toString(tempFileNames) + ", deleteOriginFileNames="
				+ Arrays.toString(deleteOriginFileNames) + ", deleteTempFileNames="
				+ Arrays.toString(deleteTempFileNames) + "]";
	}
	

}
