package com.springboot.security.web.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.springboot.security.domain.user.User;
import com.springboot.security.domain.user.UserRepository;
import com.springboot.security.web.dto.auth.SignUpDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AuthSerivceImpl implements AuthService{	
	
	private final UserRepository userRepository;
	
	@Override
	public int signup(SignUpDto signUpDto) {
		
		User user = signUpDto.toEntity();
		int userNameCheckResult = userRepository.usernameCheck(user);
		if(userNameCheckResult == 1) {
			// 이미 존재하는 username
			return 2;
		} else {
			// 회원가입 가능
			user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword())); // 암호화된 password로 set한다.
			user.setRole("ROLE_USER");
			int signupResult = userRepository.signup(user);
			return signupResult;
		}
	}

}
