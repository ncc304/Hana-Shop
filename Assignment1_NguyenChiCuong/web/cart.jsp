<%-- 
    Document   : cart
    Created on : Apr 12, 2021, 2:25:58 PM
    Author     : nguye
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cart Page</title>
    </head>
    <body>
        <a href="LoadUserController">Back to Shopping Page</a>
        <h1>Your Cart:</h1>
        
        <c:if test="${sessionScope.shoppingCart.shoppingCart.size() > 0}">
            <form action="MainController" method="POST">
                <table border="1">
                    <thead>
                        <tr>
                            <th>No</th>
                            <th>Food Name</th>
                            <th>Amount</th>
                            <th>Price</th>
                            <th>Total</th>
                            <th>Delete</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="cart" items="${sessionScope.shoppingCart.shoppingCart.values()}" varStatus="counter">
                            <tr>
                                <td>${counter.count}</td>
                                <td>${cart.proName}</td>
                                <td>
                                    <input type="number" name="txtCartAmount" value="${cart.proQuantity}"/>
                                </td>
                                <td>${cart.proPrice}</td>
                                <td>total</td>
                                <td>
                                    <a href="DeleteCartController?productID=${cart.proID}">Delete</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </form>
        </c:if>
    </body>
</html>
