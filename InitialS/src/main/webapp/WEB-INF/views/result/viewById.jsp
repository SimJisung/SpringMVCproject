<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>개인 사용자 페이지</title>
</head>
<body>
	
	<form:form commandName="result" method="POST" action="${pageContext.request.contextPath}/update.do">
		<form:hidden path="id" value = "${result.id}"/> 
		first name : <form:input path="firstName" value = "${result.firstName}"/>
		last name : <form:input path="lastName" value = "${result.lastName}"/>
		salary : <form:input path="salary" value  = "${result.salary}"/>
		
		<input type = "submit" value = "수정" />
	</form:form>
	
	

</body>
</html>