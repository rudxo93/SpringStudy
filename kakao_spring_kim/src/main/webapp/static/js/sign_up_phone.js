const item_ip = document.querySelector('.item_ip');
const btn_g = document.querySelector('.btn_g');
const button_round = document.querySelector('.button_round');
const submit_flag = document.querySelector('#submit_flag');
const flag = document.querySelector('#flag');

if(flag.value == 0){
	const msg1 = document.querySelector('.msg1');
	const msg2 = document.querySelector('.msg2');
	const msg3 = document.querySelector('.msg3');
	msg1.style.display = "none";
	msg2.style.display = "none";
	msg3.style.display = "block";
}else if(flag.value == 1){
	const msg1 = document.querySelector('.msg1');
	const msg2 = document.querySelector('.msg2');
	const msg3 = document.querySelector('.msg3');
	const msg4 = document.querySelector('.msg4');
	msg1.style.display = "none";
	msg2.style.display = "none";
	msg3.style.display = "none";
	msg4.style.display = "block";
	const phone = document.querySelector('#phone');
	item_ip.value = phone.value;
	item_ip.readOnly = true;
}else if(flag.value == 2){
	const msg1 = document.querySelector('.msg1');
	const msg2 = document.querySelector('.msg2');
	const msg3 = document.querySelector('.msg3');
	msg1.style.display = "none";
	msg2.style.display = "block";
	msg3.style.display = "none";
}

item_ip.onkeypress = () => {
	if(window.event.keyCode == 13){  // keycode 13 = enter
		window.event.preventDefault(); // 기본으로 내장되어 있는 이벤트를 죽인다.
		if(flag.value == 1){
			submit_flag.value = 1; //  마침 버튼
			onSubmit();
		}
	}
}

btn_g.onclick = () => {
	if(flag.value == 1){ // 인증이 완료되야지만 submit버튼이 눌려진다.
		submit_flag.value = 1; //  마침 버튼
		onSubmit();
	}
}

button_round.onclick = () => {
	submit_flag.value = 2;//  인증 버튼
	onSubmit();
}

function onSubmit(){
	const msg1 = document.querySelector('.msg1');
	
	if (item_ip.value.length == 0) {
		msg1.style.display = 'block';
	} else {
		const form = document.querySelector('form'); 
		form.submit();
	}
}
