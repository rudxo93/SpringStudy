package com.spring.study.di;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("c1")
public class AirConditionerRemoteControl implements RemoteControl {
	@Value("LG")
	private String company;
	
	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	@Override
	public void on() {
		System.out.println(company + "에어컨 전원을 켭니다.");
	}

	@Override
	public void off() {
		System.out.println(company + "에어컨 전원을 끕니다.");
	}

}
