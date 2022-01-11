package com.springboot.security.domain.user;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor // 생성자에 모든 매개변수가 다 있는것
@NoArgsConstructor // 아무것도 없는 기본 생성자
@Data
public class User {
	
	private String id;
	private String username;
	private String password;
	private String email;
	private String name;
	private String role;
	private String provider;
	private Date createdate;
	private Date updatedate;

}
