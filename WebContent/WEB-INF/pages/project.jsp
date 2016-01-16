<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>

<br />
<link rel="stylesheet" href="<c:url value="/resources/table.css" />"
	type="text/css" />

<h1>PROJECTS!</h1>

<h1>This is project: ${project.name}</h1>
<p>${project.description}</p>

<div id="kanbanBoardWrapper" class="tableWrapper">
	<table id="kanbanBoardContent" class="tableContent">
		<tr id="kanbanBoardHeaders">
			<th>To Do</th>
			<th>In Progress</th>
			<th>Done</th>
		</tr>
		<tr>
			<td><br> <br> <br> <br> <br></td>
		</tr>
	</table>


</div>


