package ze.citychurch.store;

import ze.citychurch.entities.User;
import java.util.concurrent.ConcurrentHashMap;


//In-memory data storage repo
public class DataStore 
{
   //A thread safe map that acts as my database 
    //Key = String (username), Value = User Object
    public static final ConcurrentHashMap<String, User> users = new ConcurrentHashMap<>();
    
    //Static block that runs once app starts
    //I use it here to pre-load a leader accoint so I have a admin to run tests
    static 
    {
        users.put("admin", new User("admin", "admin123", "Church Leader"));
    }
}
