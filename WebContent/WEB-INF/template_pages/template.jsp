<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SSBB</title>
<link rel="stylesheet" href="<c:url value="/resources/styling.css" />"
	type="text/css" />
</head>
<body>
	<div id="banner">
		<tiles:insertAttribute name="header" />
	</div>
	<div></div>
	<tiles:insertAttribute name="navigation_bar" />
	<div></div>
	<div id="page">
		<tiles:insertAttribute name="content" />
	</div>
	<div></div>
	<div id="footer_wrapper">
		<tiles:insertAttribute name="footer" />
	</div>
</body>
</html>