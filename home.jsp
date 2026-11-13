<%@page import="ze.citychurch.entities.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    //Session checking that the user is actually logged in 
    User activeUser = (User) session.getAttribute("activeUser");
    if (activeUser == null) 
    {
     response.sendRedirect("login.jsp");
     return;
    }
    
%>


                    
<!DOCTYPE html>
<html>
    <head>
        <title>City Church - Home</title>
        <meta charset="UTF-8">
        <link rel="stylesheet" href="style.css">  
    </head>
    <body>
        <div class="cross-icon">&#9840;</div>
        <h2>City Church</h2>
        <h3>Home</h3>
        <div class="card">
            <p style="color: #555; margin-bottom: 20px;">Welcome Back <b><%= activeUser.getUsername()%></b>!</p>
        
        <div id="notificationsBox" style="border:1px solid #E0D4CC; border-radius: 8px; height: 200px; width:100%; overflow-y:auto ; padding: 15px; background-color: #FCF9F6; text-align: left; margin-bottom: 20px;"> 
                 <ul id="messageList" style="list-style-type: none; padding: 0; margin: 0;">
                
                 </ul>
        </div>
        
        
        
        <!-- This will display my send notification button only if the user is a Church Leader -->
        <% if("Church Leader".equals(activeUser.getRole())) { %>
        
        <a href="notification.jsp" style="display: block; margin-bottom: 10px;">Admin: Send Notification</a>
        <% } %>
        
        <a href="login.jsp">Logout</a>
        </div>
        
        <div class="footer">City Church - Bringing the community together</div>
        
      <script>
            // I have hardcoded the exact URL to prevent routing errors as I was experiencing 
            var wsURL = "ws://" + document.location.host + "/CityChurchNotifications/notifications";
            var webSocket = new WebSocket(wsURL);
            
            // This will be the tracker
            webSocket.onopen = function(event) {
                console.log("SUCCESS: WebSocket is connected and listening!");
            };
            
            //  The second tracker for errors
            webSocket.onerror = function(event) {
                console.error("CRITICAL ERROR: WebSocket failed to connect.");
            };
            
            // The third tracker for success
            webSocket.onmessage = function(event) {
                console.log("MESSAGE RECEIVED from server: " + event.data);
                
                var messageList = document.getElementById('messageList');
                var newListItem = document.createElement("li");
                
                newListItem.style.color = "#333";
                newListItem.style.marginBottom = "15px";
                newListItem.style.paddingBottom = "15px";
                newListItem.style.borderBottom = "1px solid #E0D4CC";
                newListItem.style.lineHeight = "1.6";
                newListItem.style.fontWeight = "bold";
                
                var cleanMessage = event.data.replace(/\n/g, "<br>");
                newListItem.innerHTML = cleanMessage;
                
                messageList.appendChild(newListItem);
            };
        </script>
    </body>
</html>