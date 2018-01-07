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

<form class="form-signin" method="post" action="AddPropertyServlet">
<h2 class="form-signin-heading">Add a Property</h2>
        
    <select required class="form-control" id="County" name="county">
        <option value="" disabled selected hidden>City/County</option>
        <option value="Antrim">Antrim</option>
        <option value="Armagh">Armagh</option>
        <option value="Carlow">Carlow</option>
        <option value="Cavan">Cavan</option>
        <option value="Clare">Clare</option>
        <option value="Cork">Cork</option>
        <option value="Donegal">Donegal</option>
        <option value="Down">Down</option>
        <option value="Dublin">Dublin</option>
        <option value="Fermanagh">Fermanagh</option>
        <option value="Galway">Galway</option>
        <option value="Kerry">Kerry</option>
        <option value="Kildare">Kildare</option>
        <option value="Kilkenny">Kilkenny</option>
        <option value="Laois">Laois</option>
        <option value="Leitrim">Leitrim</option>
        <option value="Limerick">Limerick</option>
        <option value="Londonderry">Londonderry</option>
        <option value="Longford">Longford</option>
        <option value="Louth">Louth</option>
        <option value="Mayo">Mayo</option>
        <option value="Meath">Meath</option>
        <option value="Monaghan">Monaghan</option>
        <option value="Offaly">Offaly</option>
        <option value="Roscommon">Roscommon</option>
        <option value="Sligo">Sligo</option>
        <option value="Tipperary">Tipperary</option>
        <option value="Tyrone">Tyrone</option>
        <option value="Waterford">Waterford</option>
        <option value="Westmeath">Westmeath</option>
        <option value="Wexford">Wexford</option>
        <option value="Wicklow">Wicklow</option>
    </select><br>
        

    <input type="text" class="form-control" placeholder="Street" id="street" name="street"><br>
    <input type="number" class="form-control" placeholder="Number Of Bedrooms" id="numberofbedrooms" name="numberofbedrooms"><br>
    <input type="number" class="form-control" placeholder="Number Of Bathrooms" id="numberofbathrooms" name="numberofbathrooms"><br>
    <input type="number" class="form-control" placeholder="Price" id="price" name="price"><br>
    <input type="number" class="form-control" placeholder="Squarefeet" id="squarefeet" name="squarefeet"><br>
    <input type='text' class="form-control" placeholder='Lot Size' id='lotsize' name='lotsize'><br>
    
    <select required class='form-control' id='garagesize' name='garagesize'>
        <option value='' disabled selected hidden>Garage Size</option>
        <option value='1'>1</option>
        <option value='2'>2</option>
        <option value='3'>3</option>
        <option value='4'>4</option>
    </select><br>
    


    <!-- Ber rating -->
    <select required class="form-control" id="berrating" name="ber">
           <option value="" disabled selected hidden>Ber Rating</option>
           <option value="A1">A1</option>
           <option value="A2">A2</option>
           <option value="A3">A3</option>
           <option value="B1">B1</option>
           <option value="B2">B2</option>
           <option value="B3">B3</option>
           <option value="C1">C1</option>
           <option value="C2">C2</option>
           <option value="C3">C3</option>
           <option value="D1">D1</option>
           <option value="D2">D2</option>
           <option value="E1">E2</option>
           <option value="EXEMPT">EXEMPT</option>
           <option value="F">F</option>
           <option value="G">G</option>
    </select><br>
    
    

    <!-- Drop down for vendors managed by this agent -->
   <select required class="form-control" id="vendor" name="vendor">
         <option value="" disabled selected hidden>Vendor</option>
         <c:forEach items="${currentAgent.getVendorsCollection()}" var="vendor">
           <option value="${vendor.getVendorid()}">${vendor.getName()}</option>
         </c:forEach>
   </select><br>

    <!-- Drop down for Property types, before this page is loaded pass collection of garage objs into request -->
   <select required class="form-control" id="propertytype" name="propertytype">
         <option value="" disabled selected hidden>Property Type</option>
         <c:forEach items="${PropertyTypeList}" var="propertyTypes">
           <option value="${propertyTypes.getTypeId()}">${propertyTypes.getPType()}</option>
         </c:forEach>
   </select><br>

    <!-- Drop down for GarageType, before this page is loaded pass collection of PropertyType objs into request -->
   <select required class="form-control" id="garagetype" name="garagetype">
         <option value="" disabled selected hidden>Garage Type</option>
         <c:forEach items="${GarageTypeList}" var="garageType">
           <option value="${garageType.getGarageId()}">${garageType.getGType()}</option>
         </c:forEach>
   </select><br>

    <!-- Drop down for styles -->
      <select required class="form-control" id="styletype" name="styletype">
         <option value="" disabled selected hidden>Style Type</option>
         <c:forEach items="${StyleTypeList}" var="styleType">
           <option value="${styleType.getStyleId()}">${styleType.getPStyle()}</option>
         </c:forEach>
   </select><br>
    
    
   <textarea class="form-control" rows="3" placeholder="Enter a Description for the property, be as informative as possible" id="description" name="description"></textarea><br>


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
