package ze.citychurch.messaging;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import javax.websocket.OnClose;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import ze.citychurch.web.MessageServlet;
        

//Will define the URL endpoint that the browsers will connect to for the project

@ServerEndpoint ("/notifications")
public class NotificationWebSocket {
    
    private static final Set<Session> sessions = Collections.synchronizedSet(new HashSet <>());
    
    @OnOpen
    public void onOpen(Session session) {
        
        sessions.add(session);
    }
    
    @OnClose
    public void onClose(Session session) {
        
        sessions.remove(session);
    }
    
    //This method will call to send a message to everyone in the list
    public static void broadcast(String message) {
        
        
        for (Session session : sessions) { 
            if(session.isOpen()) {
                
              try {
                  session.getBasicRemote().sendText(message);
            }catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
  }
    
}
    
    
    
    
    
 
    

