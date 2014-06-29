<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
	<table>
		<tr>
			<td>
				id
			</td>
			<td>
				firstName
			</td>
			<td>
				lastName
			</td>
			<td>
				Salary
			</td>
		</tr>
		
		<c:forEach var = "result" items="${LIST}">
			<tr>
				<td class = "goEvent" id = "resultId">
					<a href = "${pageContext.request.contextPath}/hr/view/${result.id}">
						${result.id}
					</a>
				</td>
				<td class = "goEvent">
					${result.firstName}
				</td>
				<td class = "goEvent"> 
					${result.lastName}
				</td>
				<td class = "goEvent"> 
					${result.salary}
				</td>
			</tr>
		</c:forEach>
	</table>	
		
	