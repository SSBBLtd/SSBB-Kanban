<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>

<br />
<h1>Landing Page</h1>

<h1>Welcome ${user.firstName} ${user.lastName}</h1>

	<c:forEach var="project" items="${user.projects}">
	<f:form action="loadSelectedProject" method="POST"
		commandName="project">
		<f:input path="name" value="${project.name}" type="submit"
			class="button"/>
	</f:form>
	<br>
	</c:forEach>


<form action="home" method="GET">
	<input class="button" type="submit" value="home" />
</form>
<br />
<form action="logout" method="POST">
	<input class="button" type="submit" value="Logout" />
</form>
<br />
<a href="#openModal">Create Project</a>


<div id="openModal" class="modalDialog">
	<div>
		<h1>Create a new project</h1>
		<a href="#close" title="Close" class="close">X</a>
		<f:form action="createProject" method="POST" commandName="project">
			<f:input type="text" path="name" />
			<f:input type="text" path="description" />
			<input class="button" type="submit" value="Create Project" />
		</f:form>
	</div>
</div>