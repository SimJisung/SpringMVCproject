<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

	<form:form commandName="hr" method="POST" action="${pageContext.request.contextPath}/hr/save.do">
		first name : <form:input path="firstName"/>
		last name : <form:input path="lastName"/>
		salary : <form:input path="salary"/>
		
		<input type = "submit" value = "입력" />
	</form:form>

<a href="${pageContext.request.contextPath}/hr/view.do">모든 리스트 보기</a>
