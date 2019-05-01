<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>새 사진</title>
<link rel="stylesheet"
  href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
  integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
  crossorigin="anonymous">
<link rel="stylesheet" href="${contextRootPath}/css/common.css">
</head>

<body>
  <div class="container">
    <h1>새 사진</h1>
    <form action='add' method='post' enctype='multipart/form-data'>

      <div class="form-group row">
        <label for="startDate" class="col-sm-2 col-form-label">수업</label>
        <div class="col-sm-3">
          <td><select name='lessonNo'>
              <option value='0'>수업을 선택하세요</option>
              <c:forEach items="${lessons}" var="lesson">
                <option value="${lesson.no}">${lesson.title}</option>
              </c:forEach>
          </select></td>
        </div>
      </div>

      <div class="form-group row">
        <label for="title" class="col-sm-2 col-form-label">사진 제목</label>
        <div class="col-sm-5">
          <input type="text" class="form-control" id="title" name='title'>
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
        <div class="col-sm-10">
          <button class="btn btn-primary">등록</button>
          <a class="btn btn-primary" href='.'>목록</a>
        </div>
      </div>
    </form>
  </div>
  <!-- .container -->

  <jsp:include page="../javascript.jsp" />
</body>
</html>