package com.springboot.security.config.auth;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

import com.springboot.security.domain.user.User;

import lombok.Data;

@Data
public class PrincipalDetails implements UserDetails, OAuth2User {
	
	private static final long serialVersionUID = 1L;
	
	private User user;
	private Map<String, Object> attributes;
	
	public PrincipalDetails(User user) {
		// 일반 로그인
		this.user = user;
	}
	
	public PrincipalDetails(User user, Map<String, Object> attributes) {
		// OAuth2 로그인
		this.user = user;
		this.attributes = attributes;
	}

	/*
	권한이 하나가 아닐 수 있기때문에 return은 Collection이다.
	kim이라는 아이디가 ROLE_ADMIN일수도 있고 ROLE_USER....와 같이 한 계정에
	여러개를 들고 있을수도 있다.
	그렇기 때문에 이러한것들을 다 저장하려면 Collection안에서 List를 사용해야한다.
	List를 만들어서 반환
	 */
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		Collection<GrantedAuthority> collection = new ArrayList<GrantedAuthority>();
		collection.add(new GrantedAuthority() {
			@Override
			public String getAuthority() {
				return user.getRole();
			}
		});
		return collection;
	}

	@Override
	public String getPassword() { // DB에서 들고와야 한다.
		// TODO Auto-generated method stub
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true; // 계정이 만료됐는지?? false라면 계정 만료
	}
	
	// 예를들어 인증절차를 걸쳐서 들어왔을때 자동으로 이메일 인증 들어와서
	// 그 인증이 ok됐다라면 다시 자동으로 true로 바꿔주면 된다.
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true; // 계정이 잠겼는지? ex) 비밀번호 5회 틀릴시 계정잠기는 세팅 / 잠겼으면 false
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true; // 1년이상 계정을 사용하지 않으면 휴먼계정 / false 사용할 수 없는 계정
	}
	
	/*
	예를들어 몇년이상 로그인기록이 없어서 회원정보를 삭제하고자 합니다 라는
	메일을 받았던 적이 있을것이다.
	그러면 여기서 일단 false로 만들어 두고 법에 따라 개인정보를 들고있을수 있는데
	그 기간이 지나면 데이터베이스에서도 지워야 한다.
	여기서만 false를 하면 DB에는 안지워진것이다.
	*/
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true; // 계정을 임시탈퇴
	}

	@Override
	public Map<String, Object> getAttributes() {
		return attributes;
	}

	@Override
	public String getName() {
		return (String)attributes.get("name");
	}

}
