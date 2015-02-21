<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<tiles:insertDefinition name="home" />
 --%>

<%-- <html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SSBB</title>
<link rel="stylesheet" href="<c:url value="/resources/styling.css" />"
	type="text/css" />
</head>
<body> --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>

	<h1>SSBB Kanban</h1>
	<br /> Hello Raymond! Hello Ilya

	<c:choose>
		<c:when test="${not user.loggedIn}">
			<f:form action="login" method="POST" commandName="user">
				email <f:input type="text" path="email" />
				<br /> 
				Password <f:password path="password" />
				<br />
				<input class="button" type="submit" value=login />
			</f:form>
			<br />
			<form action="register">
				<input class="button" type="submit" value=Register />
			</form>
		</c:when>
		<c:otherwise>
			<h2>You are logged in as ${user.firstName} ${user.lastName}</h2>
			<form action="landing" method="GET">
				<input class="button" type="submit" value="Go to your account" />
			</form>
			<form action="logout" method="POST">
				<input class="button" type="submit" value="Logout" />
			</form>
		</c:otherwise>
	</c:choose>

<!-- </body>
</html> -->