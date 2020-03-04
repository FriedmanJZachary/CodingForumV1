
package edu.cooper.ece366.codingForum.model;
import edu.cooper.ece366.codingForum.*;
import java.util.ArrayList;
import java.util.List;

public class UserClass {
    // Instance Variables
    public String userName;
    public String pass;
    public ArrayList<Long> postList;

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

    public void addPost(Long post)
    {
        postList.add(post);
    }

    public void removePost(Long post)
    {
        postList.remove(post);
    }

    public ArrayList<Long> returnPost(Long post)
    {
        return postList;
    }


}