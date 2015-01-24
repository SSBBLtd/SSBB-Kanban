<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SSBB</title>
</head>
<body>


	<h1>SSBB Kanban</h1>
	<br /> Hello Raymond! Hello Ilya

	<c:choose>
		<c:when test="${not user.loggedIn}">
			<form action="login" method="GET">
				<input class="button" type="submit" value=login />
			</form>
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

</body>
</html>