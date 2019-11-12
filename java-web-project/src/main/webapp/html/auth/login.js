if (window.localStorage.getItem('email')) {
  //document.querySelector('#email').value = localStorage.getItem('email')
	document.querySelector('#email').value = localStorage.email
	//local storage는 만료가 없고, session storage는 세션 종료되면(브라우저 종료 시) 지워짐
	//이메일 저장 시
}


$('#login-btn').click (() => {
//  var xhr = new XMLHttpRequest()
//  xhr.onreadystatechange = function() {
//    if (xhr.readyState != 4 || xhr.status != 200)
//      return;
//    
//    var data = JSON.parse(xhr.responseText);
//    
//    if (data.status == 'success') {
//      location.href = "../index.html"
//        
//    } else {
//      alert('로그인 실패입니다!\n' + data.message);
//    }
//  };
//  xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
	var email = $('#email').val();

  $.post('../../app/json/auth/login', {
	  email: $('#email').val(),
	  password: $('#password').val()
	  
  }, 
  
  function(data) {
	  if (data.status == 'success') {
		  location.href = "../index.html"
	  } else {
		 alert('로그인 실패입니다!\n' + data.message);  
	  }
  });
  
  
  if (document.querySelector('#saveEmail:checked') != null) {
    // 웹브라우저의 로컬 스토리지에 이메일을 저장한다.
    //window.localStorage.setItem("email", email);
    window.localStorage.email = email;
  } else {
    window.localStorage.removeItem("email");
  }
  
});

// Naver clientId _nWXrJJcmrBqfz0G0OA2
var naverLogin = new naver.LoginWithNaverId(
		{
			clientId: "_nWXrJJcmrBqfz0G0OA2",
			callbackUrl: "http://127.0.0.1:8080/java-web-project/html/auth/callback.html",
			isPopup: false, /* 팝업을 통한 연동처리 여부 */
			loginButton: {color: "green", type: 3, height: 60} /* 로그인 버튼의 타입을 지정 */
		}
	);
	
	/* 설정정보를 초기화하고 연동을 준비 */
	naverLogin.init();






