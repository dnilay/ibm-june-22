<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- CSS only -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor"
	crossorigin="anonymous">
<title>add_person</title>
</head>
<body>
	<div>
		<form:form action="processForm" method="post" modelAttribute="person">
		<form:hidden path="personId" />
			<label>First Name</label>
			<form:input path="firstName" />
			<br />
			<label>Last Name</label>
			<form:input path="lastName" />
			<br />
			<label>Age</label>
			<form:input path="age" />
			<input type="submit">
		</form:form>
	</div>
</body>
</html>