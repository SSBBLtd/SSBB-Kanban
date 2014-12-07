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


	<h1>Registration Page</h1>
	<br />
	<f:form action="register/register" method="POST" commandName="user">
		<f:input type="text" value="First Name" path="firstName" />
		<f:input type="text" value="Last Name" path="lastName" />
		<f:input type="text" value="email" path="email" />
		<f:password value="Password" path="password" />
		<br />
		<input class="button" type="submit" value=Register />
	</f:form>
	<br />
	<form action="home" method="GET">
		<input class="button" type="submit" value="Home" />
	</form>

</body>
</html>