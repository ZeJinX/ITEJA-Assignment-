<%-- 
    Document   : registration
    Created on : 05 Aug 2026, 16:23:23
    Author     : Zeke
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>City Church - Registration</title>
        <meta charset="UTF-8">
        <link rel="stylesheet" href="style.css">
    </head>
    <body>
        <div class="cross-icon">&#9840;</div>
        <h2>City Church Notification System</h2>
        <h3>Registration</h3>
        
        <!-- This will send a Post request to the registration Servlet -->
    <div class="card">
        <form action="RegistrationServlet" method="POST">
            
            
            <input type="text" id="username" name="username" placeholder="Username" required>
            
            
            <input type="password" id="password" name="password" placeholder="Password" required>
            
            
            <select id="role" name="role">
                <option value="Member">Member</option>
                <option value="Church Leader">Church Leader</option> 
            </select>
                <input type="submit" value="Register"> 
        </form>
        
        <!-- Link to the log in page -->
        <a href="login.jsp">Already have an account? Login in here.</a>
    </div>
        <div class="footer"> City Church - Bringing the Community together</div>
    </body>
</html>
