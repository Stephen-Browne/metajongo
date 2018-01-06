<%-- 
    Document   : ViewProperties
    Created on : 02-Jan-2018, 22:51:03
    Author     : Stephen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link rel = "stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<div class="container">
    
 
      
        <table class="table" id="DisplayWide">
              <thead class="thead-inverse">
            <tr>
                <th colspan="2">Available Properties</th>
            </tr>
              </thead>
              
              <tbody>
            <c:forEach items="${requestScope.PropertyList}" var="property">
                <tr> 
                    <td><a href=""> <img src="./imageResources/${property.getPhoto()}" class="img-responsive" alt="Product Image" /> </a></td> 
                    <td>${property.getShortDescription()}</td>
                    <td>Located in ${property.getCity()} on ${property.getStreet()}</td>
                    <td><form method="post" action="ViewPropertyServlet">
                            <input type="hidden" name="propertyid" value="${property.getId()}"/><!--Pass the current property object to the drill down -->
                            <input type="submit" name="viewProperty" value="View Property" class="button" id="ViewAdvertButton" align="right">
                        </form>
                    
                    
                </tr>
                
            </c:forEach>

                </tbody>
 
        </table>
    

<script>
    /*Tooltip*/
$(function () {
  $('[data-toggle="tooltip"]').tooltip();
});
</script>


<style>
    
    /* font Awesome http://fontawesome.io*/
@import url(//maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css);
/* Animation.css*/
@import url(https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.5.2/animate.min.css);

.col-item {
  border: 1px solid #E1E1E1;
  background: #FFF;
  margin-bottom:12px;
}
.col-item .options {
  position:absolute;
  top:6px;
  right:22px;
}
.col-item .photo {
  overflow: hidden;
}
.col-item .photo .options {
  display:none;
}
.col-item .photo img {
  margin: 0 auto;
  width: 100%;
}

.col-item .options-cart {
  position:absolute;
  left:22px;
  top:6px;
  display:none;
}
.col-item .photo:hover .options,
.col-item .photo:hover .options-cart {
  display:block;
  -webkit-animation: fadeIn .5s ease;
  -moz-animation: fadeIn .5s ease;
  -ms-animation: fadeIn .5s ease;
  -o-animation: fadeIn .5s ease;
  animation: fadeIn .5s ease;
}
.col-item .options-cart-round {
  position:absolute;
  left:42%;
  top:22%;
  display:none;
}
.col-item .options-cart-round button {
  border-radius: 50%;
  padding:14px 16px;
  
}
.col-item .options-cart-round button .fa {
  font-size:22px;
}
.col-item .photo:hover .options-cart-round {
  display:block;
  -webkit-animation: fadeInDown .5s ease;
  -moz-animation: fadeInDown .5s ease;
  -ms-animation: fadeInDown .5s ease;
  -o-animation: fadeInDown .5s ease;
  animation: fadeInDown .5s ease;
}
.col-item .info {
  padding: 10px;
  margin-top: 1px;
}
.col-item .price-details {
  width: 100%;
  margin-top: 5px;
}
.col-item .price-details h1 {
  font-size: 14px;
  line-height: 20px;
  margin: 0;
  float:left;
}
.col-item .price-details .details {
  margin-bottom: 0px;
  font-size:12px;
}
.col-item .price-details span {
  float:right;
}
.col-item .price-details .price-new {
  font-size:16px;
}
.col-item .price-details .price-old {
  font-size:18px;
  text-decoration:line-through;
}
.col-item .separator {
  border-top: 1px solid #E1E1E1;
}

.col-item .clear-left {
  clear: left;
}
.col-item .separator a {
  text-decoration:none;
}
.col-item .separator p {
  margin-bottom: 0;
  margin-top: 6px;
  text-align: center;
}

.col-item .separator p i {
  margin-right: 5px;
}
.col-item .btn-add {
  width: 60%;
  float: left;
}
.col-item .btn-add a {
  display:inline-block !important;
}
.col-item .btn-add {
  border-right: 1px solid #E1E1E1;
}
.col-item .btn-details {
  width: 40%;
  float: left;
  padding-left: 10px;
}
.col-item .btn-details a {
  display:inline-block !important;
}
.col-item .btn-details a:first-child {
  margin-right:12px;
}



  body {
        padding-top: 20px;
        padding-bottom: 60px;
        font-size: 50%;
      }

      /* Custom container */
      .container {
        margin: 0 auto;
        max-width: 1000px;
      }
      .container > hr {
        margin: 60px 0;
      }

      /* Main marketing message and sign up button */
      .jumbotron {
        margin: 80px 0;
        text-align: center;
      }
      .jumbotron h1 {
        font-size: 100px;
        line-height: 1;
      }
      .jumbotron .lead {
        font-size: 24px;
        line-height: 1.25;
      }
      .jumbotron .btn {
        font-size: 21px;
        padding: 14px 24px;
      }

      /* Supporting marketing content */
      .marketing {
        margin: 60px 0;
      }
      .marketing p + h4 {
        margin-top: 28px;
      }


      /* Customize the navbar links to be fill the entire space of the .navbar */
      .navbar .navbar-inner {
        padding: 0;
      }
      .navbar .nav {
        margin: 0;
        display: table;
        width: 100%;
      }
      .navbar .nav li {
        display: table-cell;
        width: 1%;
        float: none;
      }
      .navbar .nav li a {
        font-weight: bold;
        text-align: center;
        border-left: 1px solid rgba(255,255,255,.75);
        border-right: 1px solid rgba(0,0,0,.1);
      }
      .navbar .nav li:first-child a {
        border-left: 0;
        border-radius: 3px 0 0 3px;
      }
      .navbar .nav li:last-child a {
        border-right: 0;
        border-radius: 0 3px 3px 0;
      }
	  
	  .ContentFrame
{
	width:1200px;
	margin:auto;
	
}




</style>