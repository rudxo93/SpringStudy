const notice_submit = document.querySelector(".notice_submit"); 
const updateForm = document.querySelector("#update-form");
const file_dbtn = document.querySelectorAll('.file-dbtn');
const file_name = document.querySelectorAll('.file-name');

for(let i = 0; i < file_dbtn.length; i++){ // 토글
    file_dbtn[i].onclick = () => {
        if(file_name[i].style.textDecoration == 'none' || file_name[i].style.textDecoration == ''){
            file_name[i].style.textDecoration = 'line-through'; // 가운데 줄이 그어진다.
        }else{
            file_name[i].style.textDecoration = 'none';
        }
    }
}

function noticeUpdate(){
	let formData = new FormData(updateForm); // formData에 delete할 파일들을 추가해준다. 
	for(let i = 0; i < file_name.length; i++){
		if(file_name[i].style.textDecoration == 'line-through'){ // 여러개의 파일name중에 중간에 줄이 그어진것
			// 줄이 그어진 파일들을 formData에 추가한다.
			let originFileNames = formData.getAll('originFileNames'); // hidden태그 안에 들어있는 value값
			let tempFileNames = formData.getAll('tempFileNames'); // getAll 배열로 전체를 들고온다.
			formData.append('deleteOriginFileNames', originFileNames[i]); // formData 에 저장
			formData.append('deleteTempFileNames', tempFileNames[i]);
		}
	}
	$.ajax({
		type: "put",
		url: "/notice/update/" + formData.get('notice_code'),
		enctype: "multipart/form-data",
		data: formData,
		processData: false,
		contentType: false,
		success: function(data){
			
		},
		error: function(){
			alert('전송 실패!');
		}
	})
}

notice_submit.onclick = () => {
	const notice_title = document.querySelector(".notice_title");
	const notice_writer = document.querySelector(".notice_writer");
	const notice_content = document.querySelector(".notice_content");
	if(notice_title.value.length == 0){
		alert("공지사항의 제목을 입력해 주세요.");
	}else if(notice_writer.value.length == 0){
		alert("로그인이 되지 않았습니다. 로그인 후 사용바랍니다.");
	}else if(notice_content.value.length == 0){
		alert("공지사항 내용을 입력해 주세요.");
	}else {
		noticeUpdate();
	}
}