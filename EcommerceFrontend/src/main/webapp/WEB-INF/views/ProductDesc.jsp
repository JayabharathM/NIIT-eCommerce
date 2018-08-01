<%@ page language="java" contentType="text/html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ include file="Header.jsp" %>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product Description</title>
</head>

 <body>
   <table width="60%" align="center" border="1">
    <tr bgcolor="blue">
         <td colspan="3"><center>Product Description</center></td>
    </tr>
    <tr>
         <td rowspan="6"><img src="<c:url value="/resources/images/${prodinfo.prodid}.jpg" />"/></td>
    </tr>
    <tr>
         <td> Product ID </td><td>${prodinfo.prodid}</td>
    </tr>
    <tr>
         <td> product Name </td><td>${prodinfo.prodname}</td>
    </tr>
    <tr>
         <td> Supplier </td><td>${prodinfo.suppid}</td>
    </tr>
    <tr>
         <td> product Desc </td><td>${prodinfo.prodDesc}</td>
    </tr> 
    <tr>
         <td> product Price </td><td>${prodinfo.price}</td>
    </tr>
    
    <tr>
        <td><td>
        </td>
        <form action="/FadshionWorldFrontend/addToCart/${prodinfo.prodid}" methods="get">
        Quantity <input type="text" name="quantity" class="form-control btn-block "/>
        <input type="submit" value="AddToCart" class="btn btn-xs btn-success btn-block"/>
        </form>
        </td>
    </tr>
   </table>

</body>
</html>