<%--
  Created by IntelliJ IDEA.
  User: Nilay
  Date: 15-06-2022
  Time: 14:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<br>
<h1>Customer Added Successfully</h1>
<hr/>
First Name:${CUSTOMER.firstName}<br/>
Last Name:${CUSTOMER.lastName}</br>
Email:${CUSTOMER.email}
<a href="add_customer.jsp">back</a>
</body>
</html>
