<%@ page language="java" contentType="text/html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@include file="Header.jsp"%>

<html>
<head>
   <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
   <title>Order Confirmation</title>
</head>

<body>
    <table cellspacing="4" align="center" >
       <tr>
            <td colspan="5"><center><h3>Shopping Cart</h3></center></td>
       </tr>
       <tr bgcolor='blue'>
         <td>Product Name</td>
         <td>Quantity</td>
         <td>Images</td>
         <td>SubTotal</td>
         
        
        </tr>
  <c:forEach items="${cartitems}" var="cartitem">
  <tr>
    <td>${cartitem.prodname}</td>
    <td>${cartitem.quantity}</td>
    <td><img src="<c:url value='/resources/images/${cartitem.prodid}.jpg'/>" width="100"/></td> 
    <td>${cartitem.price * cartitem.quantity}</td>
    
  </tr>
  <c:set var="pid" value="${cartitem.citemid}"/>
  </c:forEach>
  <tr>
      <td colspan="3"> Grand total </td>
      <td>${grandtotal}</td>
  </tr>
   <tr>
   <td><br><br><br><a href="/FadshionWorldFrontend/Payment/${pid}"> Make Payment</a></td>
  </tr>
 
  
</body>
</html>