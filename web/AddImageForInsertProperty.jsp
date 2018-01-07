<%-- 
    Document   : AddProperty
    Created on : 04-Jan-2018, 16:47:58
    Author     : Stephen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel = "stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel ='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/2.3.2/css/bootstrap-responsive.min.css'>
        <%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

        <body>

    <div class="container">

            <form class="form-signin" method="post" action="AddPropertyServlet" enctype="multipart/form-data">


            <!-- Choose an Image, more can be added later after the property has been inserted -->
            <label class="btn btn-primary btn-file">
                Choose an Image <input type="file" style="display: none;" name="propertyimage">
            </label><br><br><br>


            <button class="btn btn-primary" type="submit">Add Property</button><br>
            <img src="./imageResources//homeLogo.png" alt="logo" style="width:150px;height:150px" id="formlogo">

            </form>

    </div>
            

        
        
        
<style type='text/css'>
                
                 body {
        padding-top: 40px;
        padding-bottom: 40px;
        background-color: #f5f5f5;
      }

      .form-signin {
        width: 700px;
		height: 1150px;
        padding: 19px 29px 29px;
        margin: 0 auto 20px;
        background-color: #fff;
        border: 1px solid #e5e5e5;
        -webkit-border-radius: 5px;
           -moz-border-radius: 5px;
                border-radius: 5px;
        -webkit-box-shadow: 0 1px 2px rgba(0,0,0,.05);
           -moz-box-shadow: 0 1px 2px rgba(0,0,0,.05);
                box-shadow: 0 1px 2px rgba(0,0,0,.05);
      }
      .form-signin .form-signin-heading,
      .form-signin .checkbox {
        margin-bottom: 10px;
      }
	  
	 .form-signin-heading
	 {
		 margin-bottom:20px;
		 margin-left: 50px;
		 
	 }
      .form-signin input[type="text"],
      .form-signin input[type="password"] {
        font-size: 16px;
        height: auto;
        margin-bottom: 20px;
        padding: 20px 20px;
		}
		
		#formlogo
	{
		position:relative;
		float: right;
		top: -115px;

		
		
		#CreateButton
		{
		margin-left:300px;
		
		}
		
		
		
	}
        
        .btn-file {
    position: relative;
    overflow: hidden;
}
.btn-file input[type=file] {
    position: absolute;
    top: 0;
    right: 0;
    min-width: 100%;
    min-height: 100%;
    font-size: 100px;
    text-align: right;
    filter: alpha(opacity=0);
    opacity: 0;
    outline: none;
    background: white;
    cursor: inherit;
    display: block;
}
      

    </style>
                
  
        
</html>
