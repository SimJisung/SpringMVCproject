<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<title>개인 사용자 페이지</title>


</head>
<body>
	
	<form:form commandName="hr" method="POST" action="${pageContext.request.contextPath}/update.do">
		<form:hidden path="id" value = "${hr.id}"/> 
		first name : <form:input path="firstName" value = "${hr.firstName}"/>
		last name : <form:input path="lastName" value = "${hr.lastName}"/>
		salary : <form:input path="salary" value  = "${hr.salary}"/>
		
		<form:button id = "update" > 수정 </form:button>
	</form:form>
	
	<form:form commandName="hr" method="POST" action="${pageContext.request.contextPath}/delete.do">
		<form:hidden path="id" value = "${hr.id}"/>
		<form:button id = "delete" > 삭제 </form:button>
	</form:form>

</body>
</html>