<%@page import="ze.citychurch.entities.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    //The session check
    User activeUser = (User) session.getAttribute("activeUser");
    if(activeUser == null) 
    {
    
        response.sendRedirect("login.jsp");
        return;
    }
    
//The Role based access control and if they are not the leader they get pushed back to the home page
    if(!"Church Leader".equals(activeUser.getRole())){
     
       response.sendRedirect("home.jsp");
       return;
    }
   
%>

<!DOCTYPE html>
<html> 
    <head>    
        <title>City Church - Send Notification</title>   
        <meta charset="UTF-8">
        <link rel="stylesheet" href="style.css">
        
    </head>
    <body>
        <div class="cross-icon">&#9840;</div>
        <h2>City Church Notification System</h2>
        <h3>Server-Side</h3>
        
        <div class="card">
            <p style="font-weight: bold; color: #333; margin-bottom: 15px; text-align: left;">Write a notification to send to the church members:</p>
        
        <form action="MessageServlet" method="POST">
            <textarea name="messageContent" rows="4" cols="50" required placeholder="Please enter any event details or announcements here.. "></textarea>
             
            <input type="submit" value="Send Notification">
        </form>
 
        <a href="home.jsp">Back to Home</a>
        </div>
        
        <div class="footer">City Church - Bringing the community together</div>
    </body>
</html>



