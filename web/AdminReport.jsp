<%-- 
    Document   : AdminReport
    Created on : 10-Jan-2018, 18:31:32
    Author     : Stephen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <link rel = "stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

        
        <title>Report</title>
    </head>
    <div class="container-fluid">
        
    <body>
        <h1>Report</h1>
           <c:forEach items="${agentsForReport}" var="agent">
               <p>Agent Name: ${agent.getName()}<br>Total Properties: ${agent.getNumberOfProperties()}</p>
               
               <c:if test="${agent.getNumberOfProperties() > 0}">
               
                    <table class="table">
                        <thead>
                            <tr>
                                 <th>Property Name</th>
                                 <th>Price</th>
                                 <th>Views</th>
                            </tr>
                        </thead>

                        <tbody>
                                 <c:forEach items="${agent.getPropertiesCollection()}" var="property">
                                     <tr>
                                         <td>${property.getShortDescription()}</td>
                                         <td>${property.getPrice()}</td>
                                         <td>${property.getViews()}</td>
                                     </tr>
                                 </c:forEach>
                                     <tr>
                                         <td><strong>Total Price:</strong> ${agent.getTotalPropertiesPrice()}</td>
                                     </tr>
                        </tbody>
                    </table>
                                
                </c:if>
               
           </c:forEach>
               
               <p>
                   <strong>Total Number Of Properties: ${totalNumberOfProperties}</strong><br>
                   <strong>Total Price for all Properties: ${totalPropertyPrice}</strong>
                   
               </p>
               
               
               <h2 style="font-weight: bold">Oldest Properties in System:</h2>
               <table class="table">
                   <thead>
                   <th>
                       Property Name
                   </th>
                   <th>
                       Price
                   </th>
                   <th>
                       Views
                   </th>
                   </thead>
               
           <c:forEach items="${OldestProperties}" var="oldProperty">           
                <tr>
                    <td>${oldProperty.getShortDescription()}</td>
                    <td>${oldProperty.getPrice()}</td>
                    <td>${oldProperty.getViews()}</td>
                </tr>
           </c:forEach>
                   
                </table>
               
           
               
               
    </body>
    
    </div>
</html>
