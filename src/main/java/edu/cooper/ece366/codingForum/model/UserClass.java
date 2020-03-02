package edu.cooper.ece366.codingForum.model;
import edu.cooper.ece366.codingForum.*;

public class UserClass {
    // Instance Variables
    public String userName;
    public String pass;
    public String firstName;
    public String lastName;
    public String email;

    // Constructor Declaration of Class
    public UserClass(String userName, String pass, String firstName, String lastName, String email) {
        this.userName = userName;
        this.pass = pass;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    //Name display method
    public String getName()
    {
        return userName;
    }
}