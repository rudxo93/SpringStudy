package com.spring.study.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/*
 *  중앙제어 시스템
 */
@Component
public class CentralControl {
	
	@Autowired
	@Qualifier("c1")
	private RemoteControl control4;
	@Autowired
	@Qualifier("c2")
	private RemoteControl control5;
	
	public CentralControl() {  // 기본생성자
		
	}
	/*
	public CentralControl(RemoteControl control1, RemoteControl control2) {
		this.control1 = control1;
		this.control2 = control2;
	}
	*/
	public void onAll() {
		control4.on();
		control5.on();
	}
	
	public void offAll() {
		control4.off();
		control5.off();
	}
}
