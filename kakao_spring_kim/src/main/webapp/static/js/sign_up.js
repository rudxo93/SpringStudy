const warp_form = document.querySelectorAll('.warp_form');
warp_form[0].style.display = 'block';

const item_ip = document.querySelectorAll('.item_ip');
const btn_g = document.querySelectorAll('.btn_g');

var signUpData = { // json데이터 객체 주입
	signUpEmail: '',
	emailFlag: 0,
	signUpPassword: '',
	signUpName: '',
	signUpPhone: '',
	phoneFlag: 0
}

item_ip[0].onkeypress = () => {
	if (window.event.keyCode == 13) {  // keycode 13 = enter
		window.event.preventDefault(); // 기본으로 내장되어 있는 이벤트를 죽인다.
		next(0);
	}
}

btn_g[0].onclick = () => {
	next(0);
}

item_ip[1].onkeypress = () => {
	if (window.event.keyCode == 13) {  // keycode 13 = enter
		window.event.preventDefault(); // 기본으로 내장되어 있는 이벤트를 죽인다.
		next(1);
	}
}

btn_g[1].onclick = () => {
	next(1);
}

item_ip[2].onkeypress = () => {
	if (window.event.keyCode == 13) {  // keycode 13 = enter
		window.event.preventDefault(); // 기본으로 내장되어 있는 이벤트를 죽인다.
		next(2);
	}
}

btn_g[2].onclick = () => {
	next(2);
}

function next(indexNumber){
	const msg1 = document.querySelectorAll('.msg1');
		const msg2 = document.querySelectorAll('.msg2');
		msg1[indexNumber].style.display = 'none';  // 필수 항목입니다.
		msg2[indexNumber].style.display = 'none'; // 존재하는 아이디
	if (item_ip[indexNumber].value.length == 0) {
		msg1[indexNumber].style.display = 'block';  // 비었습니다 msg
	} else if(indexNumber == 0) {
		$.ajax({
			type: "post",
			url: "sign-up-emailCheck",
			data: { // json데이터를 받는다.
				signUpEmail: item_ip[indexNumber].value // signUpEmail 키값으로 item_ip.value전달
			},
			dataType: "text",
			success:function(data){
				signUpData = JSON.parse(data);
				if(signUpData.emailFlag == 0){
					warp_form[indexNumber].style.display = 'none';
					warp_form[indexNumber+1].style.display = 'block';
				} else if(signUpData.emailFlag == 1){
					const false_email = document.querySelector('#false_email');
					while(false_email.hasChildNodes()){
						false_email.removeChild(false_email.firstChild);
					}
					const emailTextNode = document.createTextNode(signUpData.signUpEmail);
					false_email.appendChild(emailTextNode);
					msg2[indexNumber].style.display = 'block';
				}
			},
			error:function(){
				alert('비동기 처리 오류!');
			}
			
		})
	} else if(indexNumber == 1){
		let checkFlag = checkPassword(signUpData.signUpEmail, item_ip[indexNumber].value, msg2[indexNumber]);
		if(checkFlag == true){
			warp_form[indexNumber].style.display = 'none';
			warp_form[indexNumber+1].style.display = 'block';
		} else {
			msg2[indexNumber].style.display = 'block';
		}
	} else if(indexNumber == 2){
		if(item_ip[1].value == item_ip[2].value){ // password가 서로 같으면
			signUpData.signUpPassword = item_ip[2].value;
			warp_form[indexNumber].style.display = 'none';
			warp_form[indexNumber+1].style.display = 'block';
		} else { // 다르다면?
			msg2[indexNumber].style.display = 'block';
		}
	}
}

function checkPassword(id,password, msg2){
	
	while(msg2.hasChildNodes()){ // child 노드가 존재할 경우에만 반복해서 모든 child들을 지우는 작업
		msg2.removeChild(msg2.firstChild); // checkpassword 메서드가 호출될 때 마다 모든 child들을 지우는 작업
	}
	
	 if(!/^[a-zA-Z0-9]{10,15}$/.test(password)){ 
        let msg = document.createTextNode('숫자와 영문자 조합으로 10~15자리를 사용해야 합니다.');
        msg2.appendChild(msg); // 위의 삭제작업이 끝나고 깨끗한 상태에서 부모 요소한테 append시킨다.
        return false;
    }
    
    var checkNumber = password.search(/[0-9]/g);
    var checkEnglish = password.search(/[a-z]/ig);
    
    if(checkNumber <0 || checkEnglish <0){
        let msg = document.createTextNode("숫자와 영문자를 혼용하여야 합니다.");
        msg2.appendChild(msg);
        return false;
    }
    
    if(/(\w)\1\1\1/.test(password)){
        let msg = document.createTextNode('444같은 문자를 4번 이상 사용하실 수 없습니다.');
        msg2.appendChild(msg);
        return false;
    }
    
    if(password.search(id) > -1){
        let msg = document.createTextNode("비밀번호에 아이디가 포함되었습니다.");
        msg2.appendChild(msg);
        return false;
    }
    
    return true;
    
}
