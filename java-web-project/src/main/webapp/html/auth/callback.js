var token = location.href.split('#')[1].split('=')[1].split('&')[0]

var naverLogin = new naver.LoginWithNaverId(
{
  clientId: "_nWXrJJcmrBqfz0G0OA2",
  callbackUrl: "http://127.0.0.1:8080/java-web-project/html/auth/callback.html",
  isPopup: false,
  callbackHandle: true
});

    /* (3) 네아로 로그인 정보를 초기화하기 위하여 init을 호출 */
naverLogin.init();

    /*
     * (4) Callback의 처리. 정상적으로 Callback 처리가 완료될 경우 main page로 redirect(또는 Popup
     * close)
     */
window.addEventListener('load', function () {
	naverLogin.getLoginStatus(function (status) {
		if (status) {
			/* (5) 필수적으로 받아야하는 프로필 정보가 있다면 callback처리 시점에 체크 */
			var email = naverLogin.user.getEmail();
			var name = naverLogin.user.getName();
			
			var isRequire = true;
			 
			if( email == undefined || email == null) {
				alert("이메일은 필수정보입니다. 정보제공을 동의해주세요.");
				isRequire = false;

			} else if (name == undefined || name == null) {
				alert("이름은 필수정보입니다. 정보제공을 동의해주세요.");
				isRequire = false;
			}
			
			if(isRequire == false) {
				/* (5-1) 사용자 정보 재동의를 위하여 다시 네아로 동의페이지로 이동함 */
				naverLogin.reprompt();
				return;
			} else {
				login()
				
			}

			//window.location.replace("http://" + window.location.hostname + ( (location.port==""||location.port==undefined)?"":":" + location.port) + "/sample/main.html");
			
		} else {
			console.log("callback 처리에 실패하였습니다.");
		}
	});
});


function login(){
	$.post('../../app/json/auth/snsLogin', {
		token : token
	},
	function(data) {
		if (data.status == 'success') {
			location.href = '../index.html'
		} else if (data.status == 'no-data') {
			console.log('잘못 된 토큰인가보다')
		}
	})
}
		
		
		
		