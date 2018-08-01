<%@ page language="java" contentType="text/html"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta charset="utf-8">
   <meta name="viewport" content="width=device-width, initial-scale=1">
   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
   <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
   <title>IndexPage</title>
</head>
<body>
   <!-- <security:authorize access="hasRole('ROLE_ADMIN')"></security:authorize> -->
   <jsp:include page="WEB-INF/views/Header.jsp"></jsp:include>
   <h2 align="center">Fashion World</h2>
   
   </br/> <br/>
   <div class="container">
      <div class="row">
         <div class="col-md-offset-2">
           <div id="imageCarousel" class="carousel slide" data interval="2000" data-ride="carousel">
             <div class="Carousel-inner">
                <div class="item active">
                    <img src="<c:url value="/resources/images/shoppingbags.jpg"/>"  class ="img-responsive"/> 
                 <div class="carousel-caption">
                 </div>
               </div>
               <div class="item">
               <img src="<c:url value="/resources/images/dresses.jpg"/>"  class ="img-responsive"/>
                 <div class="carousel-caption">
                 </div>
               </div>
                <div class="item">
               <img src="<c:url value="/resources/images/jackets.jpg"/>"  class ="img-responsive"/>
                 <div class="carousel-caption">
                 </div>
               </div>
            </div>
          </div>
       </div>
     </div>
   </div>


</body>
</html>
