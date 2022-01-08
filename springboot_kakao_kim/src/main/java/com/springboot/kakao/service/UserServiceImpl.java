package com.springboot.kakao.service;

import java.util.UUID;

import javax.servlet.http.Cookie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.kakao.mapper.UserDao;
import com.springboot.kakao.model.dto.UserDto;
import com.springboot.kakao.model.vo.SignInVo;
import com.springboot.kakao.model.vo.SignUpVo;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;
	
	@Override
	public int signUpEmailCheck(String signUpEmail) {
		return userDao.emailCheck(signUpEmail);
	}
	
	@Override
	public int signUpPhoneCheck(SignUpVo signUpVo) {
		return userDao.phoneCheck(signUpVo);
	}
	
	@Override
	public int signUp(SignUpVo signUpVo) {
		return userDao.signUp(signUpVo);
	}
	
	@Override
	public int signIn(SignInVo signInVo) {
		return userDao.signIn(signInVo);
	}

	@Override
	public UserDto getUser(String user_email) {
		return userDao.getUser(user_email);
	}
	
	@Override
	public Cookie setUserCookie(String user_email) {
		Cookie cookie_email = new Cookie("user_email", user_email);
		cookie_email.setMaxAge(60*60*24); // 24시간 동안 유지
		return cookie_email;
	}
	
	@Override
	public int oAuthSignUp(SignUpVo signUpVo) {
		// 이메일을 들고오면 @gmail.com까지 들고오기 때문에 0번 index부터 @ 전까지 잘라낸다.
		signUpVo.setSignUpEmail(signUpVo.getSignUpEmail().substring(0, signUpVo.getSignUpEmail().lastIndexOf("@")));
		signUpVo.setSignUpPassword(UUID.randomUUID().toString()); // 패스워드 설정
		signUpVo.setSignUpPhone("010-0000-0000"); // 우선 빈값, 회원 수정 페이지에서 알아서 처리 하게끔
		
		return userDao.signUp(signUpVo);
	}
}
