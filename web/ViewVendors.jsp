<%-- 
    Document   : ViewVendors
    Created on : 10-Jan-2018, 18:00:54
    Author     : Stephen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link rel = "stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel ='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/2.3.2/css/bootstrap-responsive.min.css'>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html>
    <head>
            <title>My Vendors</title>
    </head>
    
    <body>
        
        <div class="container-fluid">


<table class="table">
  <thead>
    <tr>
        <th>Vendor ID</th>  
        <th>Vendor Name</th>
    </tr>
  </thead>
  <tbody>
        <c:forEach items="${requestScope.vendors}" var="vendor">
                <tr>
                    <td>${vendor.getVendorid()}</td>
                    <td>${vendor.getName()}</td>
                </tr>
        </c:forEach>
  </tbody>
</table>
            
        </div>        
            
    </body>
    
    
            
            
            
            
</html>