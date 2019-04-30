<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>test1</title>
</head>
<body>
<h1>test3 실행</h1>
</body>
</html>
<%
// 다른 도메인에서 AJAX 요청이 들어왔을 때 이 JSP 결과를 가져가도록 허락한다
// => 이 헤더를 붙이지 않으면 다른 도메인의 AJAX 요청은 거절된다
//    * 모든 도메인에 대해 허락, 특정 도메인 지정도 가능
response.setHeader("Access-Control-Allow-Origin", "*");

// 일부러 응답을 지연시킨다
Thread.currentThread().sleep(10000);
%>