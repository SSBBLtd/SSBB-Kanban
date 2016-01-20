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

<br />
<a href="#openModal">Create a new task</a>

<div id="openModal" class="modalDialog">
	<div>
		<h1>Create a new task</h1>
		<a href="#close" title="Close" class="close">X</a>
		<f:form action="createTask" method="POST" commandName="task">
			<f:input type="text" path="title" value="Task Name" />
			<f:input type="text" path="description" value="Description" />
			<f:input type="text" path="estimate" value="1" />
			<f:input type="text" path="timeRemaining" value="1" />
			<input class="button" type="submit" value="Create Task" />
		</f:form>
	</div>
</div>
<br>



<div id="kanbanBoardWrapper" class="tableWrapper">
	<table id="kanbanBoardContent" class="tableContent">
		<tr id="kanbanBoardHeaders">
			<th>To Do</th>
			<th>In Progress</th>
			<th>Done</th>
		</tr>
		<tr>
			<c:forEach var="task" items="${project.tasks}">

				<tr>${task.title}
				</tr>
				<br>
			</c:forEach>
		</tr>
	</table>


</div>


