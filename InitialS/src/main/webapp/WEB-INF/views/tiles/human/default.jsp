<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>
	<tiles:insertAttribute name = "title" ignore="true" />
</title>
</head>
<body>
	<div id = "header">
		<tiles:insertAttribute name="header" />
	</div>
	
	<div id = "body">
		<tiles:insertAttribute name = "menu" />
		<tiles:insertAttribute name = "body" />
	</div>
	
	<div id = "footer">
		<tiles:insertAttribute name = "footer" />
	</div>
</body>
</html>