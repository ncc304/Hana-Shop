<%-- 
    Document   : login
    Created on : Apr 7, 2021, 1:59:04 PM
    Author     : nguye
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <a href="index.jsp">Home</a>
        <h1>Login</h1>
        <form action="MainController" method="POST">
            User ID: <input type="text" name="txtID" required="true" minlength="2" maxlength="10"/> <br/>
            Password: <input type="password" name="txtPassword" required="true" minlength="2" maxlength="10"/>
            <input type="submit" name="action" value="Login"/>
        </form>
        <c:if test="${sessionScope.ERROR != null}">
            <h3 style="color: red;">${sessionScope.ERROR}</h3>
        </c:if>
    </body>
</html>
