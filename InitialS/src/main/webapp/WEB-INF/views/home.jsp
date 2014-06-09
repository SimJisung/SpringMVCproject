<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>

<form:form commandName="hr" method="POST" action="${pageContext.request.contextPath}/save.do">
	first name : <form:input path="firstName"/>
	last name : <form:input path="lastName"/>
	salary : <form:input path="salary"/>
	
	<input type = "submit" value = "입력" />
</form:form>

<a href="${pageContext.request.contextPath}/view.do">모든 리스트 보기</a>   

</body>
</html>
