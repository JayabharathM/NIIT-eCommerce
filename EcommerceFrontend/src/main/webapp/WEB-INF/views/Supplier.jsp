<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@include file="AdminHeader.jsp"%>

<html>
<head>
 <meta charset="utf-8">
   <meta name="viewport" content="width=device-width, initial-scale=1">
   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
   <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
   <title>Supplier</title>
</head>
<body>
<!-- Supplier Form Started -->
<c:if test="${flag}">
<form action="/FadshionWorldFrontend/UpdateSupplier" method="post">
</c:if>
<c:if test="${!flag}">
<form action="AddSupplier" method="post">
</c:if>
<form action="Supplier" method="post">
<table align="center" cellspacing="2">
	<tr>
		<td colspan="2">Supplier Details</td>
		<c:if test="${flag}">
			<input type="text" name="suppid" value="${supplier.suppid}"/>
		</c:if>
	</tr>
	<tr>
	<td>Supplier Name</td>
	         <c:if test="${flag}">
				<td><input type="text" name="suppname" value="${supplier.suppname}" /></td>
			</c:if>
			<c:if test="${!flag}">
	            <td><input type="text" name="suppname"/></td>
	        </c:if>
	</tr>
	<tr>
	<td>Supplier Address</td>
	<c:if test="${flag}">
				<td><input type="text" name="Address" value="${supplier.address}" /></td>
    </c:if>
    <c:if test="${!flag}">
	<td><input type="text" name="Address"/></td>
	</c:if>
	</tr>
	<tr>
	<td colspan="2">
		<input type="submit" value="AddSupplier"/>
	</td>
	</tr>
</table>
</form>
<!-- Supplier Form Completed -->

<!-- Displaying the Supplier data using Table -->
<table cellspacing="2" align="center" border="1">

	<tr bgcolor="pink">
		<td>Supplier ID</td>
		<td>Supplier Name</td>
		<td>Supplier Address</td>
		<td>Operation</td>
	</tr>
	<c:forEach items="${suppdetail}" var="supplier">
		<tr bgcolor="cyan">
			<td>${supplier.suppid}</td>
			<td>${supplier.suppname}</td>
			<td>${supplier.address}</td>
			<td><a href="<c:url value="/deleteSupplier/${supplier.suppid}"/>">Delete</a>
				<a href="<c:url value="/updateSupplier/${supplier.suppid}"/>">Update</a>
			</td>
		</tr>
	</c:forEach>
</table>
<!-- Completed Displaying Table -->



</body>
</html>

