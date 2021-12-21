const item_ip = document.querySelector('.item_ip');
const btn_g = document.querySelector('.btn_g');

item_ip.onkeypress = () => {
	if(window.event.keyCode == 13){  // keycode 13 = enter
		window.event.preventDefault(); // 기본으로 내장되어 있는 이벤트를 죽인다.
		onSubmit();
	}
}

btn_g.onclick = () => {
	onSubmit();
}

function onSubmit(){
	const msg1 = document.querySelector('.msg1');
	
	if (item_ip.value.length == 0) { // name에서는 빈값인지 아닌지만 확인
		msg1.style.display = 'block';
	} else {
		const form = document.querySelector('form'); 
		form.submit();
	}
}
