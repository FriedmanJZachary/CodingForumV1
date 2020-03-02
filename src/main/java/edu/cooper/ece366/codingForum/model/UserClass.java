
package edu.cooper.ece366.codingForum.model;
import edu.cooper.ece366.codingForum.*;

public class UserClass {
    // Instance Variables
    public String userName;
    public String pass;

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