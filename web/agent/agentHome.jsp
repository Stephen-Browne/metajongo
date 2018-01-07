<%-- 
    Document   : agentHome
    Created on : 05-Dec-2017, 17:15:29
    Author     : Stephen
--%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel = "stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <div class="container">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agent Home</title>
    </head>
    <body>
        <h1>Welcome to the Agent Home page, ${currentAgent.username}</h1><br>
                <p><a href="<c:url value = "/agent/addVendor.jsp"/>">Add a Vendor</a></p>

        <p><a href="<c:url value = "/agent/updateDetails.jsp"/>">Update My Details</a></p>
  
        <p><a href="<c:url value = "/agent/viewMyVendors.jsp"/>">View Details for Vendors You're Managing</a></p>
                    
        <p><a href="<c:url value = "ViewPropertiesServlet"/>">View Properties</a></p>
        
        <p><a href="<c:url value = "PrepareForAddPropertyServlet"/>">Add a Property</a></p>
        
        


                 
          
    </body>
    </div>
</html>
