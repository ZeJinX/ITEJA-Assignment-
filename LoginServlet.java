package ze.citychurch.web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import ze.citychurch.entities.User;
import ze.citychurch.store.DataStore;


@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        //This will accept the username and password that will be submitted by the user from the HTML form
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        out.println("<html><body>");
        
        //This will be a function to validate the input data to not be empty 
        if (username == null || username.trim().isEmpty() ||
            password == null || password.trim().isEmpty()) {
            
            response.sendRedirect("login.jsp?error=empty");
            return;   
        }
        
        //Function to check is user exists in the DataStore Map
        if (DataStore.users.containsKey(username)){
            
            //this will retrieve the stored user object
            User storedUser = DataStore.users.get(username);
            
            //ensure the password matches
            if (storedUser.getPassword().equals(password)){
                
                //If successful will create a Http Session 
                //the "true" parameter will create a new session if one doesnt exist
                HttpSession session = request.getSession(true);
                
                //this will store authenicated user object inside the session
                session.setAttribute("activeUser", storedUser);
                
                response.sendRedirect("home.jsp");
                
            }else{
                
                //if the password did not match
                response.sendRedirect("login.jsp?error=invalid");
                
            }
        }else {
                    //Username was not found in map
            response.sendRedirect("login.jsp?error=invalid");
                    }
      
    }
}


