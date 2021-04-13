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
        <a href="LoadUserController">Shopping Cart</a> <br/>
        
        
        
        <a href="createProduct.jsp">Create a new Product</a>
        
        
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
                    <th>Quantity</th>
                    <th>Status</th>
                    <th>Create Date</th>
                    <th>Delete</th>
                    <th>Update</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="list" items="${sessionScope.List_Product}" varStatus="counter">
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
                    <td>${list.proQuantity}</td>
                    <td>${list.proStatus}</td>
                    <td>${list.proCreateDate}</td>
                    <td>
                        <a href="MainController?action=DeleteProduct&productID=${list.proID}">Delete</a>
                    </td>
                    <td>
                        <form action="MainController" method="POST">
                        <input type="hidden" name="productID" value="${list.proID}"/>
                        <input type="submit" name="action" value="Update Product"/>
                        </form>
                    </td>
                </tr>
                </c:forEach>
            </tbody>
        </table>
            </c:if>
        </c:if>
        
    </body>
</html>
