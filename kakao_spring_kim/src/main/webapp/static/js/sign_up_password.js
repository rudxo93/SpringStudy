const item_ip = document.querySelector('.item_ip');
const btn_g = document.querySelector('.btn_g');

item_ip.onkeypress = () => {
	if(window.event.keyCode == 13){ // keycode 13 = enter
		window.event.preventDefault(); // 기본으로 내장되어 있는 이벤트를 죽인다. 
		onSubmit();
	}
}

btn_g.onclick = () => {
	onSubmit();
}

function onSubmit(){
	const msg1 = document.querySelector('.msg1');
	const msg2 = document.querySelector('.msg2');
	
	if (item_ip.value.length == 0) {
		msg1.style.display = 'block';
		msg2.style.display = 'none';
	} else { // 빈값이 아니라면 else일때 한번 더 체크
		msg1.style.display = 'none';
		const id = document.querySelector("#id");  // id를 들고온다.
		let flag = checkPassword(id.value, item_ip.value);  // checkPassword function 호출 /id의 값과 item_ip(password)의 값을 넘긴다.
		if (flag == true) {  // flag가 true라면 submit 날리고 아니라면 submit날리지 않는다.
			const form = document.querySelector('form');
			form.submit();
		} else {
			msg2.style.display = 'block';
		}
	}
}

function checkPassword(id,password){
	const msg2 = document.querySelector('.msg2');
	
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