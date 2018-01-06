<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link rel = "stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    
    <div class="container">
    <body>
      <h3>Welcome to LIT Realty</h3>
      <shiro:notAuthenticated>
      <a href="login.jsp">Login</a>
      </shiro:notAuthenticated>
      
      <shiro:authenticated> <!--Only those logged in will see this-->
                
        <form method="post" action="logoutServlet">
            <input type="submit" value="logout">
        </form>
                
    </shiro:authenticated>
    </div>
      
    </body>
</html>
