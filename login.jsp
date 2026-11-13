<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <title>City Church - Login</title>
        <meta charset="UTF-8"> 
        <link rel="stylesheet" href="style.css">
    </head>
    
    <body>
        <div class="cross-icon">&#9840;</div>
        <h2>City Church Notification System</h2>
        <h3>Login</h3> 
        
        <!-- This will send a POST Request to the loginServlet -->
        <div class="card">
            
            <%
                String error = request.getParameter("error");
                String success = request.getParameter("success");
                if ("invalid".equals(error)) {
                %>
                <p style="color: #D8000C; background-color: #FFD2D2; padding: 10px; border-radius: 5px; font-size: 14px; margin-bottom: 15px;">Error:Incorrect username or password.</p>
                <%
                }else if("empty".equals(error)) {
               %>
               <p style="color: #D8000c; background-color: #FFD2D2; padding: 10px; border-radius: 5px; font-size: 14px; margin-bottom: 15px;">Error: Username and password are required.</p>
               <%
                }else if ("registered".equals(success)){
               %>
               <p style="color: #4F8A10; background-color: #DFF2BF; padding: 10px; border-radius: 5px; font-size: 14px; margin-bottom: 15px;">Registration Successful! Please log in.</p>
               <%
                }
               %>
               
        <form action="LoginServlet" method="POST">
            
            <input type="text" id="username" name="username" placeholder="Username" required>
            
            <input type="password" id="password" name="password" placeholder="Password" required>
            
            <input type="submit" value="Login">
        </form>
        
        <br>
        <a href="registration.jsp">Don't have an account? Register here! </a>
        </div>
    <div class="footer">City Church - Bringing the Community together</div>
    </body>
</html>
        
