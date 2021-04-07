<%-- 
    Document   : index
    Created on : Apr 7, 2021, 4:48:04 PM
    Author     : nguye
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:if test="${sessionScope.User_info != null}">
            <a href="MainController?action=Logout">Logout</a>
            <h1>Welcome ${sessionScope.User_info.userName}</h1>
        </c:if>
        <c:if test="${sessionScope.User_info == null}">
            <a href="login.jsp">Login</a>  
        </c:if>    
        <h1>Hana Shop</h1>


    </body>
</html>
