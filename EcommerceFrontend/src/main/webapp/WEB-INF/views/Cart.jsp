<%@ page language="java" contentType="text/html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@include file="Header.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cart</title>
</head>
<body>

<table cellspacing="3" align="center">
<tr>
    <td colspan="5"><center><h3>Shopping Cart</h3></center></td>
</tr>


<c:forEach items="${cartitems}" var="cartitem">
<tr>
    <form action="<c:url value="/updateCartItem/${cartitem.citemid}"/>" method="get">
    <td>${cartitem.prodname}</td>
    <td><input type="text" value="${cartitem.quantity}" name="quantity"/></td>
    <td>${cartitem.price * cartitem.quantity}</td>
    <td><img src="<c:url value='/resources/images/${cartitem.prodid}.jpg'/>" width="100"/></td> 
    <td>
        <input type="submit" value="UPDATE" class="btn-success btn-block" name="update" />
        
        <a href="<c:url value="/deleteCartItem/${cartitem.citemid}"/>">Delete</a>
    </td>
    </form>
</tr>
</c:forEach>
<tr>
    <td> <a href="/FadshionWorldFrontend/ProductPage"> ContinueShopping </a><br></td>
  
    <td> <a href="/FadshionWorldFrontend/Checkout">CheckOut</a></td>
</tr>

</table>

</body>
</html>