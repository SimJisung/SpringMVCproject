<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<P>  The time on the server is ${serverTime}. </P>

<a href = "${pageContext.request.contextPath}/hr/view.do">인사정보 바로가기 </a>  <br/> 

<a href = "${pageContext.request.contextPath}/hr/save.do">인사정보 입력하기 </a>   
