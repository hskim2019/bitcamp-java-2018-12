<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
  trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>사진 조회</title>
  <jsp:include page="../commonCss.jsp"/>
</head>
<body>

  <jsp:include page="../header.jsp" />

 <div class="container">
  <h1>사진 조회</h1>
<c:choose>
<c:when test="${empty board}">
  <p>해당 사진을 찾을 수 없습니다.</p>
</c:when>
<c:otherwise>
  <form action='update' method='post' enctype='multipart/form-data'>
    <div class="form-group row">
      <label for="no" class="col-sm-2 col-form-label">번호</label>
      <div class="col-sm-10">
       <input type="text" class="form-control-plaintext" id="no" name='no' value='${board.no}'
        readonly>
      </div>
     </div>
   
      <div class="form-group row">
      <label for="title" class="col-sm-2 col-form-label">제목</label>
      <div class="col-sm-8">
       <input type="text" class="form-control" id="title" name='title' value='${board.title}'>
      </div>
     </div>
      <div class="form-group row">
    <label for="startDate" class="col-sm-2 col-form-label">등록일</label>
    <div class="col-sm-3">
      <input type="date" class="form-control-plaintext"  id="createdDate" 
         name='createdDate' value='${board.createdDate}' readonly>
    </div>
  </div>
    <div class="form-group row">
    <label for="startDate" class="col-sm-2 col-form-label">조회수</label>
    <div class="col-sm-3">
      <input type="number" class="form-control-plaintext"  id="createdDate" 
         name='createdDate' value='${board.viewCount}' readonly>
    </div>
  </div>
  
     <div class="form-group row">
    <label for="startDate" class="col-sm-2 col-form-label">수업</label>
    <div class="col-sm-3">
       <td><select name='lessonNo'>
          <c:forEach items="${lessons}" var="lesson">
            <option value="${lesson.no}"
              ${board.lessonNo == lesson.no ? "selected" : ""}>${lesson.title}(${lesson.startDate}
              ~
              ${lesson.endDate})
            </option>
          </c:forEach>
        </select></td>
    </div>
  </div>
  
  
    
 <div class="form-group row">
    <label class="col-sm-2 col-form-label"></label>
    <div class="col-sm-8">
    <p>최소 한 개의 사진 파일을 등록해야 합니다.</p>
    </div>
  </div>
  
  
   <div class="form-group row">
    <label for="startDate" class="col-sm-2 col-form-label">사진1</label>
    <div class="col-sm-8">
     <td><input type='file' name='photo'></td>
    </div>
  </div>
     <div class="form-group row">
    <label for="startDate" class="col-sm-2 col-form-label">사진2</label>
    <div class="col-sm-8">
     <td><input type='file' name='photo'></td>
    </div>
  </div>
     <div class="form-group row">
    <label for="startDate" class="col-sm-2 col-form-label">사진3</label>
    <div class="col-sm-8">
     <td><input type='file' name='photo'></td>
    </div>
  </div>
     <div class="form-group row">
    <label for="startDate" class="col-sm-2 col-form-label">사진4</label>
    <div class="col-sm-8">
     <td><input type='file' name='photo'></td>
    </div>
  </div>
     <div class="form-group row">
    <label for="startDate" class="col-sm-2 col-form-label">사진5</label>
    <div class="col-sm-8">
     <td><input type='file' name='photo'></td>
    </div>
  </div>
  
   <div class="form-group row">
      <label for="photoFile" class="col-sm-2 col-form-label">사진</label>
      <div class="col-sm-8">
  <td>
          <c:set var="contextRootPath" value="${pageContext.servletContext.contextPath}"></c:set>
          <c:forEach items="${board.files}" var="file"> 
            <img src='${contextRootPath}/upload/photoboard/${file.filePath}' style='height: 80px'> 
          </c:forEach>
        </td>
        </div>
        </div>
        
       <div class="form-group row">
      <div class="col-sm-10">
       <a class="btn btn-primary" href='.'>목록</a> <a class="btn btn-primary"
        href='delete/${board.no}'>삭제</a>
       <button class="btn btn-primary">변경</button>
      </div>
     </div>
  </form>
</c:otherwise>
</c:choose>

 </div> <!-- .container -->

 <jsp:include page="../javascript.jsp" />
</body>
</html>