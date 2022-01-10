package com.springboot.security.web.dto.auth;

import lombok.Data;

@Data
public class SignUpRespDto<T> {
	
	private int code;
	private T msg; // T는 제네릭 사용

}
  