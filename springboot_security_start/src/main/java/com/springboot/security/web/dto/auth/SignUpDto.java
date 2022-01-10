package com.springboot.security.web.dto.auth;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class SignUpDto {
	
	@NotBlank
	@Size(min = 2, max = 20)
	private String username;
	
	@NotBlank
	private String password;
	
	@NotBlank
	private String email;
	
	@NotBlank
	private String name;

}
 