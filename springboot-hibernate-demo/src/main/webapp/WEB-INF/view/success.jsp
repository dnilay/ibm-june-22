<%@page import="com.example.demo.entity.Person"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>success page.</title>
</head>
<body>
<%
	Person person=(Person)request.getAttribute("person");
	if(person.getFirstName()==null)
	{
		out.println("no person found..");
	}
	else
	{
		out.println(person.getFirstName()+"<br/>"+person.getLastName()+"<br/>"+person.getAge());
	}
%>
</body>
</html>