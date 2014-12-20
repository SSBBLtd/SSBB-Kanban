<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Landing Page</title>
</head>
<body>

	<br />
	<h1>Landing Page</h1>

	<h1>Welcome ${user.firstName} ${user.lastName}</h1>
	<form action="home" method="GET">
		<input class="button" type="submit" value="home" />
	</form>
	<br />
	<form action="logout" method="POST">
		<input class="button" type="submit" value="Logout" />
	</form>
</body>
</html>