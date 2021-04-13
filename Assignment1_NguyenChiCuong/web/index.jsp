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
        <a href="cart.jsp">View Cart</a>
        <c:if test="${sessionScope.List_Product != null}">
            <c:if test="${not empty sessionScope.List_Product}">
                <table border="1">
                    <thead>
                        <tr>
                            <th>No</th>
                            <th>Image</th>
                            <th>Product Name</th>
                            <th>Description</th>
                            <th>Price</th>
                            <th>Category Name</th>
                            <th>Status</th>
                            <th>Create Date</th>
                            <th>Cart</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="list" items="${sessionScope.List_Product}" varStatus="counter">
                            <c:if test="${list.proStatus == true}">
                                <tr>
                                    <td>${counter.count}</td>
                                    <td>
                                        <img src="${list.proImage}" height="80px" width="80px"/>
                                    </td>   
                                    <td>${list.proName}</td>
                                    <td>${list.proDescription}</td>
                                    <td>${list.proPrice}</td>
                                    <c:if test="${sessionScope.List_Category != null}">
                                        <c:forEach var="checkCateID" items="${sessionScope.List_Category}">
                                            <c:if test="${checkCateID.cateID == list.cateID}">
                                                <td>${checkCateID.cateName}</td> 
                                            </c:if>
                                        </c:forEach>
                                    </c:if>
                                    <td>${list.proStatus}</td>
                                    <td>${list.proCreateDate}</td>
                                    <td>
                                        <a href="AddCartController?productID=${list.proID}">Add to Cart</a>
                                    </td>
                                </tr>
                            </c:if>
                        </c:forEach>
                    </tbody>
                </table>
            </c:if>
        </c:if>

    </body>
</html>
