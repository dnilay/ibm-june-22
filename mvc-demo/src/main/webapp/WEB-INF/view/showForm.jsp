<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>input form</title>
</head>
<body>
<h2>Provide Student Data...</h2>
<hr/>
<form:form action="processForm" method="post" modelAttribute="student">
First Name:<form:input path="firstName" />
<br/>
Last Name:<form:input path="lastName"/>
<br/>
Email:<form:input path="email"/>
<input type="submit">
</form:form>
</body>
</html>