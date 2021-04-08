<%-- 
    Document   : admin
    Created on : Apr 7, 2021, 2:02:33 PM
    Author     : nguye
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Page</title>
    </head>
    <body>
        <c:if test="${sessionScope.User_info.roleID != 'AD' or sessionScope.User_info == null}">
            <c:redirect url="login.jsp"></c:redirect>
        </c:if>
        <a href="MainController?action=Logout">Logout</a>
        <h1>Welcome ${sessionScope.User_info.userName}</h1>
        
        
        
    </body>
</html>
