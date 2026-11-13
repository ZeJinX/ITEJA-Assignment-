package ze.citychurch.web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ze.citychurch.store.DataStore;
import ze.citychurch.entities.User;

//Will link the HTML form action to the specific java class

@WebServlet(name = "RegistrationServlet", urlPatterns = {"/RegistrationServlet"})
public class RegistrationServlet extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Will send the HTML back to the users browser
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        //Accept username, password and role submitted from the HTML form
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String role = request.getParameter("role");
        
      
        //This will validate the input the data to e sure the fields are empty
        if (username == null || username.trim().isEmpty()||
            password == null || password.trim().isEmpty()||
            role == null || role.trim().isEmpty()) {
            
            response.sendRedirect("registration.jsp?error=empty");
            return; //Stop processing
        }
        
        //This is will prevent registration from running if user already exists
        if (DataStore.users.containsKey(username)){
          
            response.sendRedirect("registration.jsp?error=exists");
            return; //Stop processing
        }
        
        //Stores the user credentials in the in-memory data structure 
        User newUser = new User(username, password, role);
        DataStore.users.put(username, newUser);
        
        //Return an sucess response 
       response.sendRedirect("login.jsp?success=registered");                   
    }
    
}