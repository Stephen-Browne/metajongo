<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Home</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body> 
        
        <p> 
            
<!--only see the below section if you're a guest i.e you haven't logged in yet-->

        <shiro:guest> 


        
        <h2>Login</h2>
        <h3 style="font-weight: bold">Note: logging in is for staff only</h3>
        <c:if test="${shiroLoginFailure != null}">
            
            Username or password is incorrect
            
        </c:if>
            
            
        <form name="loginform" method="post" action="loginServlet">

            <table border="0" cellspacing="2" cellpadding="2">

                <tbody>
                    <tr>
                        <td> <label for="username">Username:</label></td>
                        <td><input type="text" id="username" name="username" /></td>
                    </tr>
                    <tr>
                        <td> <label for="password">Password:</label></td>
                        <td> <input type="password" id="password" name="password" /></td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="Login" /></td>
                        <td><input type="reset" value="Reset" /></td>
                    </tr>
                </tbody>
            </table>
            <br/>
            <label for="rememberMe">Remember me:</label>
            <input type="checkbox" id="rememberMe" name="rememberMe" value="true" />
            <br/>
            
            </shiro:guest>
                           
            <shiro:user> <!--Only those logged in will see this-->
                
                You're already logged in!
                
            </shiro:user>



            <br/>




        </form>

    </body>
</html>
