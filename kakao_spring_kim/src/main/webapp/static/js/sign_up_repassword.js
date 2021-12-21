const item_ip = document.querySelector('.item_ip');
const btn_g = document.querySelector('.btn_g');

item_ip.onkeypress = () => {
	if(window.event.keyCode == 13){ // keycode 13 = enter
		window.event.preventDefault(); // 기본으로 내장되어 있는 이벤트를 죽인다.
		onSubmit();
	}
}
// 기본으로 내장되어 있는 이벤트를 죽인다.
btn_g.onclick = () => {
	onSubmit();
}

function onSubmit(){
	const password = document.querySelector('#password');
	const msg1 = document.querySelector('.msg1');
	const msg2 = document.querySelector('.msg2');
	if(item_ip.value.length == 0){
		msg1.style.display = 'block';
		msg2.style.display = 'none';
	} else { // 빈값이 아니라면 else일때 한번 더 체크
		msg1.style.display = 'none';
		if(password.value == item_ip.value){ // password.value 와 item_ip.value가 같다는 것은 비밀번호가 일치한다.
			const form = document.querySelector('form');// 비밀번호가 일치한다면 form을 submit한다.
			form.submit();
		}else {
			msg2.style.display = 'block';
		}
	}
}
