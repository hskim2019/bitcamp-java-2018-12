<%@ page language="java" contentType="text/plain; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:url value="http://www.etnews.co.kr" var="url1"/>

<%-- 지정된 URL을 요청하고 서버로부터 받은 콘텐트를 contents라는 이름으로 
     PageContext 보관소에 저장한다. --%>
<c:import url="${url1}"/>