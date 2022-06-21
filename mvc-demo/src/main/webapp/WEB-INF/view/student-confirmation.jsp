<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>confirmation page</title>
</head>
<body>
<h2>Student Is Confirmed...</h2>
<hr/>
<p>
First Name:${STUDENT.firstName}
Last Name:${STUDENT.lastName}
Email:${STUDENT.email}
</p>
</body>
</html>