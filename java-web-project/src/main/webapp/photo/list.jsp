<%@page import="com.eomcs.lms.domain.PhotoBoard"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
 trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>

<html>
<head>
<title>사진 목록</title>
</head>
<body>

 <jsp:include page="/header.jsp"></jsp:include>

 <h1>사진 목록(JSP2+EL)</h1>
 <p>
  <a href='add'>사진 추가</a>
 </p>
 <table border='1'>
  <tr>
   <th>번호</th>
   <th>제목</th>
   <th>등록일</th>
   <th>조회수</th>
   <th>수업 번호</th>
  </tr>
    <jsp:useBean scope="request" id="list" type="java.util.List<PhotoBoard>"/>
  <%
  	for (PhotoBoard photoBoard : list) {
             pageContext.setAttribute("photoBoard", photoBoard);
  %>
  <tr>  
   <td>${photoBoard.no}</td>
   <td><a href='detail?no=${photoBoard.no}'>${photoBoard.title}</a></td>
   <td>${photoBoard.createdDate}</td>
   <td>${photoBoard.viewCount}</td>
   <td>${photoBoard.lessonNo}</td>
   <%
   	}
   %>
  
 </table>
 <form action='search'>
  수업번호: <input type='number' name='lessonNo'> 검색어: <input type='text' name='keyword'>
  <button type='submit'>검색</button>
 </form>
 <a href='../index.html'>처음화면</a>
</body>
</html>
