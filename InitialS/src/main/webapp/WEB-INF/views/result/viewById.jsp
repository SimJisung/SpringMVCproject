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
	
	<form:form commandName="hr" method="POST" action="${pageContext.request.contextPath}/update.do">
		<form:hidden path="id" value = "${hr.id}"/> 
		first name : <form:input path="firstName" value = "${hr.firstName}"/>
		last name : <form:input path="lastName" value = "${hr.lastName}"/>
		salary : <form:input path="salary" value  = "${hr.salary}"/>
		
		<input type = "submit" value = "수정" />
	</form:form>
	
	

</body>
</html>