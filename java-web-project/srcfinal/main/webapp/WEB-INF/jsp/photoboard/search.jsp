<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
  trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>사진 검색</title>
  <jsp:include page="../commonCss.jsp"/>
</head>
<body>
  <jsp:include page="../header.jsp" />
  <div class="container">
    <h1>사진 검색</h1>
    <div class="bit-list">
      <table class="table table-hover">
        <thead>
          <tr>
            <th scope="col">번호</th>
            <th scope="col">제목</th>
            <th scope="col">등록일</th>
            <th scope="col">조회수</th>
            <th scope="col">수업</th>
          </tr>
        </thead>
        <tbody>
          <c:forEach items="${list}" var="board">
            <tr>
              <th scope="row">${board.no}</th>
              <td><a href='${board.no}'>${board.title}</a></td>
              <td>${board.createdDate}</td>
              <td>${board.viewCount}</td>
              <td>${board.lessonNo}</td>
            </tr>
          </c:forEach>
        </tbody>
      </table>
    </div>
    <!-- .bit-list -->

    <p>
      <a href='.' class="btn btn-primary btn-sm">목록</a>
    </p>
  </div>
  <!-- .bit-list -->
  <jsp:include page="../javascript.jsp" />
</body>
</html>








