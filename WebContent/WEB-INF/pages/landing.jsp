<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>

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
