<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<title>person_list</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<h2>Person Management</h2>
		</div>
		<a class="btn btn-primary" href="showForm" role="button">add
			person</a> 
		<a class="btn btn-primary" href="showSearchForm" role="button">
			search person</a>
		<hr />
		<table class="table">
			<thead>
				<tr>
					<th scope="col">#</th>
					<th scope="col">First Name</th>
					<th scope="col">Last Name</th>
					<th scope="col">Age</th>
					<th scope="col">Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="person" items="${persons}">

					<c:url var="updateLink" value="/showFormForUpdate">
						<c:param name="personId" value="${person.personId}" />
					</c:url>
					<c:url var="deleteLink" value="/deletePerson">
						<c:param name="personId" value="${person.personId}" />
					</c:url>
					<tr>
						<td>${person.personId}</td>
						<td>${person.firstName}</td>
						<td>${person.lastName}</td>
						<td>${person.age}</td>
						<td><a href="${updateLink}">Update</a>|<a
							href="${deleteLink}">Delete</a></td>

					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>