<%-- 
    Document   : ViewProperty
    Created on : 03-Jan-2018, 16:48:08
    Author     : Stephen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link rel = "stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

<div class="container-fluid">
    <div class="content-wrapper">	
		<div class="item-container">	
			<div class="container">	
				<div class="col-md-12">
					
                                     <c:forEach items="${property.getImagesCollection()}" var="image">
                                        <img class="mySlides" src="./imageResources/${image.getImageName()}" style="width:500px;height:500px;">
                                     </c:forEach>
                                        <button class="w3-button w3-display-left" onclick="plusDivs(-1)">&#10094;</button>
                                        <button class="w3-button w3-display-right" onclick="plusDivs(+1)">&#10095;</button>
                                    
                                    
                                    
                                    
                                    
                                    
					
					
				</div>
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
					
				<div class="col-md-7">
                                    <div class="product-title">Property Number: ${requestScope.property.getListingNum()}</div>
					<div class="product-desc">${requestScope.property.getDescription()}</div>
					<div class="product-rating"><i class="fa fa-star gold"></i> <i class="fa fa-star gold"></i> <i class="fa fa-star gold"></i> <i class="fa fa-star gold"></i> <i class="fa fa-star-o"></i> </div>
					<hr>
                                        <div class="product-price">€${requestScope.property.getPrice()}</div>
					<div class="product-stock"></div>
					<hr>
                                        
                                        <!-- Hide the edit and delete buttons if the agent associated with this property isn't the one viewing it -->
                                        <c:if test="${currentAgent == requestScope.property.getAgentsagentId()}">
					<div class="btn-group cart">
						<button type="button" class="btn btn-success">
							Add to cart 
						</button>
					</div>
                                        
                                        <form method="post" action="AddImageToPropertyServlet">
					<div class="btn-group wishlist">
                                            <input type="hidden" name="propertyId" value="${property.getId()}">
                                            <input type="hidden" name="fromViewProperty" value="1">
                                            <button type="submit" class="btn btn-danger">
							Add An Image 
                                            </button>
                                        </form>
                                            
					</div>
                                        </c:if>
                                        <!-- End Hiding -->
                                        
                                        
                                        
				</div>
			</div> 
		</div>
		<div class="container-fluid">		
			<div class="col-md-12 product-info">
					<ul id="myTab" class="nav nav-tabs nav_tabs">
						
						<li class="active"><a href="#service-one" data-toggle="tab">DESCRIPTION</a></li>
						<li><a href="#service-two" data-toggle="tab">PRODUCT INFO</a></li>
						<li><a href="#service-three" data-toggle="tab">REVIEWS</a></li>
						
					</ul>
				<div id="myTabContent" class="tab-content">
						<div class="tab-pane fade in active" id="service-one">
						 
							<section class="container product-info">
                                                            <b><h2>Property Details</h2><b><br>
                                                                    <strong>City: </strong>${requestScope.property.getCity()}<br>
                                                                    <strong>Street: </strong>${requestScope.property.getStreet()}<br>
                                                                    <strong>Number Of Bedrooms: </strong>${requestScope.property.getBedrooms()}<br>
                                                                    <strong>Number of Bathrooms: </strong>${requestScope.property.getBathrooms()}<br>
                                                                    <strong>Squarefeet: </strong>${requestScope.property.getSquarefeet()}<br>
                                                                    <strong>berRating: </strong>${requestScope.property.getBerRating()}<br>
                                                                    <strong>Lot Size: </strong>${requestScope.property.getLotsize()}<br>
                                                                    <strong>Date Added: </strong>${requestScope.property.getDateAdded()}<br>
							</section>
										  
						</div>
					<div class="tab-pane fade" id="service-two">
						
						<section class="container">
								
						</section>
						
					</div>
					<div class="tab-pane fade" id="service-three">
												
					</div>
				</div>
				<hr>
			</div>
		</div>
	</div>
</div>
                                                        
                                                        
                                                        
                                                        
<script>
var slideIndex = 0;
carousel();

function carousel() {
    var i;
    var x = document.getElementsByClassName("mySlides");
    for (i = 0; i < x.length; i++) {
      x[i].style.display = "none"; 
    }
    slideIndex++;
    if (slideIndex > x.length) {slideIndex = 1} 
    x[slideIndex-1].style.display = "block"; 
    setTimeout(carousel, 2000); // Change image every 2 seconds
}
</script>


<style type="text/css">


    
    body {
        padding-top: 20px;
        padding-bottom: 60px;
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
	  
	  #logo
	  {
		position:relative;
		float: right;
		top: -175px;
	  }
	  
	  
	 #KeyInfo
	 {
		 margin-top:50px;
		 margin-bottom:50px;
	 }
	  
	  #Desc
	  {
		  margin-bottom:50px;
	  }
	
	
	 #sellerInfo
	 {
		 margin-bottom:50px;
	 }


/*********************************************
        		Theme Elements
*********************************************/

.gold{
	color: #FFBF00;
}

/*********************************************
					PRODUCTS
*********************************************/

.product{
	border: 1px solid #dddddd;
	height: 321px;
}

.product>img{
	max-width: 230px;
}

.product-rating{
	font-size: 20px;
	margin-bottom: 25px;
}

.product-title{
	font-size: 20px;
}

.product-desc{
	font-size: 14px;
}

.product-price{
	font-size: 22px;
}

.product-stock{
	color: #74DF00;
	font-size: 20px;
	margin-top: 10px;
}

.product-info{
		margin-top: 50px;
}

/*********************************************
					VIEW
*********************************************/

.content-wrapper {
	max-width: 1140px;
	background: #fff;
	margin: 0 auto;
	margin-top: 25px;
	margin-bottom: 10px;
	border: 0px;
	border-radius: 0px;
}

.container-fluid{
	max-width: 1140px;
	margin: 0 auto;
}

.view-wrapper {
	float: right;
	max-width: 70%;
	margin-top: 25px;
}

.container {
	padding-left: 0px;
	padding-right: 0px;
	max-width: 100%;
}

/*********************************************
				ITEM 
*********************************************/

.service1-items {
	padding: 0px 0 0px 0;
	float: left;
	position: relative;
	overflow: hidden;
	max-width: 100%;
	height: 321px;
	width: 130px;
}

.service1-item {
	height: 107px;
	width: 120px;
	display: block;
	float: left;
	position: relative;
	padding-right: 20px;
	border-right: 1px solid #DDD;
	border-top: 1px solid #DDD;
	border-bottom: 1px solid #DDD;
}

.service1-item > img {
	max-height: 110px;
	max-width: 110px;
	opacity: 0.6;
	transition: all .2s ease-in;
	-o-transition: all .2s ease-in;
	-moz-transition: all .2s ease-in;
	-webkit-transition: all .2s ease-in;
}

.service1-item > img:hover {
	cursor: pointer;
	opacity: 1;
}

.service-image-left {
	padding-right: 50px;
}

.service-image-right {
	padding-left: 50px;
}

.service-image-left > center > img,.service-image-right > center > img{
	max-height: 155px;
}

		 
		  
		  
	  
    
    
    
    
</style>