<%-- 
    Document   : SearchProperties
    Created on : 22-Jan-2018, 16:23:36
    Author     : Stephen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link rel = "stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search Properties</title>
    </head>
    <body>
        
         <table class="table" id="DisplayWide">
              <thead class="thead-inverse">
            <tr>
                <th colspan="2">Available Properties</th>
            </tr>
              </thead>
              
              <tbody>
            <c:forEach items="${allproperties}" var="property">
                <tr> 
                    <td><a href=""> <img src="./imageResources/${property.getPhoto()}" class="img-responsive" style="width:350px;height:200px;" alt="Product Image" /> </a></td> 
                    
                    <td>${property.getShortDescription()}</td>
                    <td>Located in ${property.getCity()} on ${property.getStreet()}</td>
                    <td><form method="post" action="ViewPropertyServlet">
                            <input type="hidden" name="propertyid" value="${property.getId()}"/><!--Pass the current property object to the drill down -->
                            <input type="submit" name="viewProperty" value="View Property" class="button" id="ViewAdvertButton" align="right">
                        </form>
                    </td>
                    
                    
                </tr>
                
            </c:forEach>

                </tbody>
 
        </table>
        
        
        
        
    </body>
</html>
