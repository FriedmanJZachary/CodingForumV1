package edu.cooper.ece366.codingForum;
import edu.cooper.ece366.codingForum.*;

public class UserClass {
    // Instance Variables
    String userName;
    String pass;

    // Constructor Declaration of Class
    public UserClass(String userName, String pass) {
        this.userName = userName;
        this.pass = pass;
    }

    //Name display method
    public String getName()
    {
        return userName;
    }

}