<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>내역 리스트 </title>
</head>
<body>
	<table>
		<tr>
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
				<td>
					${result.firstName}
				</td>
				<td>
					${result.lastName}
				</td>
				<td>
					${result.salary}
				</td>
			</tr>
		</c:forEach>
		
		
		
	</table>
</body>
</html>