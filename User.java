package ze.citychurch.entities;

// User class to hold the user's information 

public class User
{
    //The properties of the user that will be captured and stored 
    private String username;
    private String password;
    private String role; //The roles will be either a MEMBER or a CHURCH LEADER    


//The constructor for the java objects 
public User()
{

}

//The parameterised constructor to crate a new user 
public User(String username, String password, String role)
{
    this.username = username;
    this.password = password;
    this.role = role;

}

// The getters and setters to secure access and update the data 
public String getUsername()
{
    return username;
}

public void setUsername(String username)
{
   this.username = username;
}

public String getPassword()
{
   return password;  
}

public void setPassword(String password)
{
   this.password = password;
}

public String getRole()
{
   return role;
}

public void setRole(String role)
{
   this.role = role;
}

}
