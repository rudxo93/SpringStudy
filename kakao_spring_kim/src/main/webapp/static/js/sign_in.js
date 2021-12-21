const item_ip = document.querySelectorAll('.item_ip');

item_ip[0].onclick = () => {
    const info_tip = document.querySelector('.info_tip');
    info_tip.style.display = 'block';
}

item_ip[0].onkeyup = () => {
    const util_tf = document.querySelector('.util_tf');
    util_tf.style.display = 'block';
    if(item_ip[0].value.length == 0){
        util_tf.style.display = 'none';
    }
}

item_ip[0].onblur = () => {
    const info_tip = document.querySelector('.info_tip');
    if(item_ip[0].value.length == 0){
        const util_tf = document.querySelector('.util_tf');
        info_tip.style.display = 'none';
        util_tf.style.display = 'none';
    }
}

const btn_login = document.querySelector('.btn_login');
const msg1 = document.querySelector('.msg1');
const msg2 = document.querySelector('.msg2');
const msg3 = document.querySelector('.msg3');
const msg4 = document.querySelector('.msg4');
const flag = document.querySelector('#flag');
const return_id = document.querySelector('#return_id');
const return_password = document.querySelector('#return_password');

if(flag.value == 0){ // 아이디도 존재하지 않는것
	const util_tf = document.querySelector('.util_tf');
    util_tf.style.display = 'block';
	msg1.style.display = "none";
	msg2.style.display = "block";
	msg3.style.display = "none";
	msg4.style.display = "none";
	item_ip[0].value = return_id.value;
	item_ip[0].focus();
} else if(flag.value == 1){
	const util_tf = document.querySelector('.util_tf');
    util_tf.style.display = 'block';
	msg1.style.display = "none"; 
	msg2.style.display = "none";
	msg3.style.display = "none";
	msg4.style.display = "block";
	item_ip[0].value = return_id.value; // 로그인을 실패하게 되면 아이디와 비밀번호가 그대로 남아있는 것이 편하다.
	item_ip[1].value = return_password.value;
	item_ip[1].focus();
}

item_ip[0].onkeypress = () => {
	if (window.event.keyCode == 13) {  // keycode 13 = enter
		window.event.preventDefault(); // 기본으로 내장되어 있는 이벤트를 죽인다.
		item_ip[1].focus();
	}
}

item_ip[1].onkeypress = () => {
	if (window.event.keyCode == 13) {  // keycode 13 = enter
		window.event.preventDefault(); // 기본으로 내장되어 있는 이벤트를 죽인다.
		onSubmit();
	}
}

btn_login.onclick = () => {
	onSubmit();
}

function onSubmit(){ // item_ip [0] => id, item_ip [1] => password
	if(item_ip[0].value.length == 0){ // id값이 비었다면?
		msg1.style.display = "block";
		msg2.style.display = "none";
		msg3.style.display = "none";
		msg4.style.display = "none";
	} else if(item_ip[1].value.length == 0){ // 아이디는 안 비었고 비밀번호가 비었다면?
		msg1.style.display = "none";
		msg2.style.display = "none";
		msg3.style.display = "block";
		msg4.style.display = "none";
	} else{ // 둘다 비어있지 않다면?
		const form = document.querySelector('form');
		form.submit();
	}
}