<%-- 
    Document   : createProduct
    Created on : Apr 10, 2021, 11:44:01 PM
    Author     : nguye
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create a new Products Page</title>
    </head>
    <body>
        <c:if test="${sessionScope.User_info.roleID != 'AD' or sessionScope.User_info == null}">
            <c:redirect url="login.jsp"></c:redirect>
        </c:if>
        <a href="LoadAdminController">Back to Admin Page</a>
        <h1>Create a new Products:</h1>
        <form action="MainController" method="POST" enctype="multipart/form-data">
            ID: <input type="text" name="txtProductID"/> <br/>
            Name: <input type="text" name="txtProductName"/> <br/>
            Price: <input type="text" name="txtProductPrice"/> <br/>
            Quantity: <input type="number" name="txtProductQuantity"/> <br/>
            Image: <input type="file" name="ProductImage"/> <br/>
            Description <input type="text" name="txtProductDescription"/> <br/>
            Cate: <select name="cbbCate">
                <c:if test="${sessionScope.List_Category != null}">
                    <c:forEach var="listCate" items="${sessionScope.List_Category}">
                        <option value="${listCate.cateID}">${listCate.cateName}</option>
                    </c:forEach>
                </c:if>
            </select>
            <input type="submit" name="action" value="Create"/>
        </form>
    </body>
</html>
