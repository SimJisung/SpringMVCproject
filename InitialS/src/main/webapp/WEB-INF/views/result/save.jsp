<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>HR-SAVE Form</title>
</head>
<body>
	<form:form commandName="hr" method="POST" action="${pageContext.request.contextPath}/save.do">
	first name : <form:input path="firstName"/>
	last name : <form:input path="lastName"/>
	salary : <form:input path="salary"/>
	
	<input type = "submit" value = "입력" />
</form:form>

<a href="${pageContext.request.contextPath}/view.do">모든 리스트 보기</a>
</body>
</html>