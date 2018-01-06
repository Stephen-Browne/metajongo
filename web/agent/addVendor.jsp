<%-- 
    Document   : addProperty
    Created on : 05-Dec-2017, 15:23:16
    Author     : Stephen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link rel = "stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add a Vendor</title>
    </head>
    
    
    <div class="container">
    
    <body>
        <h2>Add a Vendor</h2>
        <p>Note that you will be responsible for managing the details of vendors you add to the system</p>
        <form action="../AddVendorServlet">
                <div class="form-group">
                  <label for="name">Vendor Name: </label>
                  <input type="text" class="form-control" id="name" name="vendorName">
                </div>              
                <button type="submit" class="btn btn-default">Add Vendor</button>
            </form>
    </body>
    
    </div>
    
</html>
