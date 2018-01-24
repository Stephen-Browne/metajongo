<%-- 
    Document   : ViewRecentProperties
    Created on : 24-Jan-2018, 20:27:15
    Author     : Stephen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link rel = "stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel = "stylesheet" href="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js">
<link rel='stylesheet' href="https://cdn.datatables.net/1.10.16/css/jquery.dataTables.min.css">

<script src="https://code.jquery.com/jquery-3.3.1.min.js"
  integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
  crossorigin="anonymous"></script>
  
<script src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>

<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Recent Properties</title>
    </head>
    
    <div class="container-fluid">
    <body>
        
         <div class="form-row">
                <div class="col">
                        <input type="text" class="form-control" placeholder="Search By Location" id="searchByLocation" name="searchByLocation">
                </div>
             
                <div class="col">
                        <input type="text" class="form-control" placeholder="Search By Square Feet" id="searchBySquareFeet" name="searchBySquareFeet">
                            
                </div>
             
             <div class="col">
                        <input type="text" class="form-control" placeholder="Search By Number Of Bedrooms" id="searchByNumberOfBedrooms" name="searchByNumberOfBedrooms">
                            
                </div>
             
             <div class="col">
                        <input type="text" class="form-control" placeholder="Search By Style" id="searchByStyle" name="searchByStyle">
                            
                </div>
             
        </div>
        <br><br>
        
        


        
        
        
         <table id="example" class="display" cellspacing="0" width="75%">
        <thead>
                <tr>
                        <th></th>
                        <th>Details</th>
                        <th>Location</th>
                        <th>Square Feet</th>
                        <th>Number Of Bedrooms</th>
                        <th>Style</th>
                        <th></th>
                </tr>
        </thead>
        
        
              
        <tbody>
            <c:forEach items="${recentProperties}" var="property">
                <tr> 
                    <td><a href=""> <img src="./imageResources/${property.getPhoto()}" class="img-responsive" style="width:350px;height:200px;" alt="Product Image" /> </a></td> 
                    
                    <td>${property.getShortDescription()}</td>
                    <td>Located in ${property.getCity()} on ${property.getStreet()}</td>
                    <td>${property.getSquarefeet()}</td>
                    <td>${property.getBedrooms()}</td>
                    <td>${property.getStylesstyleId().getPStyle()}</td>
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
    
    </div>
    
    
    
</html>

<script>


var table = $('#example').DataTable( {
    
            
        "paging":   true,
        "ordering": false,
        "info":     false,
    
    columnDefs: [
        { targets: [0, 1, 2, 3, 4, 5, 6], visible: true},
        { targets: 0, "searchable": false}, // Don't allow searching by the property's image.
        { targets: '_all', visible: false }
    ]
} );

// Search the Table by Location
$('#searchByLocation').on( 'keyup', function () {
    table
        .columns( 2 )
        .search( this.value )
        .draw();
} );

$('#searchBySquareFeet').on( 'keyup', function () {
    table
        .columns( 3 )
        .search( this.value )
        .draw();
} );


$('#searchByNumberOfBedrooms').on( 'keyup', function () {
    table
        .columns( 4 )
        .search( this.value )
        .draw();
} );

$('#searchByStyle').on( 'keyup', function () {
    table
        .columns( 5 )
        .search( this.value )
        .draw();
} );








</script>
