<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
  trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>회원 검색</title>
  <jsp:include page="../commonCss.jsp"/>
</head>
<body>
  <jsp:include page="../header.jsp" />
  
 <div class="container">
  <h1>회원 검색</h1>
 <table class="table table-hover">
    <thead>
     <tr>
      <th scope="col">번호</th>
      <th scope="col">이름</th>
      <th scope="col">이메일</th>
      <th scope="col">전화</th>
      <th scope="col">가입일</th>
     </tr>
    </thead>
    <tbody>
<c:forEach items="${list}" var="member">
    <tr>
      <td>${member.no}</td>
      <td><a href='${member.no}'>${member.name}</a></td>
      <td>${member.email}</td>
      <td>${member.tel}</td>
      <td>${member.registeredDate}</td>
    </tr>
</c:forEach>
  </table>
  <p>
     <a href='.' class="btn btn-primary btn-sm">목록</a>
  </p>
   </div>
  <!-- .bit-list -->
  <jsp:include page="../javascript.jsp" />
</body>
</html>
