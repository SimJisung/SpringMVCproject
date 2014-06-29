<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	입력 완료 됨.
	<br/>
	<br/>
	MR. ${hr.firstName} Thanks a lot! 
	<br/>
	성 : ${hr.firstName}
	<br/>
	이름 : ${hr.lastName}
	<br/>
	연봉 : ${hr.salary}
	<br/>
	
	<a href = "${pageContext.request.contextPath}/hr/view.do">인사정보 바로가기 </a>   	
	
