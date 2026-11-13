package ze.citychurch.web;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.ServletException;
import javax.naming.InitialContext;
import javax.jms.ConnectionFactory;
import javax.jms.Queue;
import javax.jms.JMSContext;

@WebServlet(name = "MessageServlet" , urlPatterns = {"/MessageServlet"})
public class MessageServlet extends HttpServlet {
    
    
    @Override 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Will get the typed message from the notification.jsp
        String messageContent = request.getParameter("messageContent");
        
        
        //If its null the it will show all the connected users
        if (messageContent !=null && !messageContent.trim().isEmpty()) {
            
            try{
            
            //This will open the connection
            InitialContext context = new InitialContext();
            
            //Look for the factory and the queue 
            ConnectionFactory factory = (ConnectionFactory) context.lookup("jms/NotificationConnectionFactory");
            Queue queue = (Queue) context.lookup("jms/NotificationQueue");
            
            //Create and send message to queue
            JMSContext jmsContext = factory.createContext();
            jmsContext.createProducer().send(queue, messageContent);
            
        }catch (Exception e) {
            
            e.printStackTrace();
        }
            
          
        }
        
        //This will redirect the leader back to the typing page to send the message 
        response.sendRedirect("notification.jsp");
    }
}


