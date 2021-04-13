<%-- 
    Document   : updateProduct
    Created on : Apr 13, 2021, 10:49:03 AM
    Author     : nguye
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Product Page</title>
    </head>
    <body>
        <c:if test="${sessionScope.User_info.roleID != 'AD' or sessionScope.User_info == null}">
            <c:redirect url="login.jsp"></c:redirect>
        </c:if>
        <a href="LoadAdminController">Back to Admin Page</a>
        <h1>Update Product</h1>
        <c:if test="${requestScope.Product_found != null}">
            <c:set value="${requestScope.Product_found}" var="proDTO"/>

            <form action="MainController" method="POST" enctype="multipart/form-data">
                ID: <input type="text" name="txtProductID" value="${proDTO.proID}" readonly="true"/> <br/>
                Name: <input type="text" name="txtProductName" value="${proDTO.proName}"/> <br/>
                Price: <input type="text" name="txtProductPrice" value="${proDTO.proPrice}"/> <br/>
                Quantity: <input type="number" name="txtProductQuantity" value="${proDTO.proQuantity}"/> <br/>
                Status: <select name="cbbStatus">
                    <c:if test="${sessionScope.listStatus != null}">
                        <c:forEach var="status" items="${sessionScope.listStatus}">
                            <option value="${status}" <c:if test="${status == proDTO.proStatus}">selected</c:if>>
                                ${status}
                            </option>
                        </c:forEach>
                    </c:if>
                </select> <br/>
                Image: <input type="file" name="ProductImage"/> <br/>
                Description <input type="text" name="txtProductDescription" value="${proDTO.proDescription}"/> <br/>
                Cate: <select name="cbbCate">
                    <c:if test="${sessionScope.List_Category != null}">
                        <c:forEach var="listCate" items="${sessionScope.List_Category}">
                            <option value="${listCate.cateID}" <c:if test="${listCate.cateID == proDTO.cateID}">selected</c:if>>
                                ${listCate.cateName}
                            </option>
                        </c:forEach>
                    </c:if>
                </select>
                <input type="hidden" name="proImg" value="${proDTO.proImage}"/>
                <input type="submit" name="action" value="Update this"/>
            </form>
        </c:if>
    </body>
</html>
