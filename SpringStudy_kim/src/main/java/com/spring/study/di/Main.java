package com.spring.study.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	
	public static void main(String[] args) {
		/*
		AirConditionerRemoteControl airConditionerRemoteControl = new AirConditionerRemoteControl();
		TvRemoteControl tvRemoteControl = new TvRemoteControl();
		TvRemoteControl tvRemoteControl2 = new TvRemoteControl();
		
		CentralControl centralControl = new CentralControl(tvRemoteControl, tvRemoteControl2);
		
		airConditionerRemoteControl.on();
		
		airConditionerRemoteControl.off();
		
		tvRemoteControl.on();
		tvRemoteControl.off();
		
		centralControl.onAll();
		centralControl.offAll(); 
		*/
		ApplicationContext context = new ClassPathXmlApplicationContext("com/spring/study/di/RemoteControlBeans.xml");  // IOC컨테이너 불러오기
		CentralControl centralControlDi = (CentralControl)context.getBean("centralControl"); // IOC에서 bean하나 가져오기(다운캐스팅 해주기)
		centralControlDi.onAll();
		centralControlDi.offAll();
		
	}

}
