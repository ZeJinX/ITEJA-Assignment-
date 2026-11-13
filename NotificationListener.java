package ze.citychurch.messaging;

import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@MessageDriven(mappedName = "jms/NotificationQueue")
public class NotificationListener implements MessageListener {
    
    @Override 
    public void onMessage (Message message) { 
        try{
            //See if the message is text
            if (message instanceof TextMessage) {
                
                //Take the text from the message 
                TextMessage textMessage = (TextMessage) message;
                String notification = textMessage.getText();
                
                //print it to the server console 
                System.out.println("Pulled from queue: " + notification);
                
                //Pass it over to the WebSocket to broadcast to the memebers
                NotificationWebSocket.broadcast(notification);   
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    
}
