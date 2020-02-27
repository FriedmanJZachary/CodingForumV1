package edu.cooper.ece366.codingForum;
import javax.naming.directory.Attributes;
import java.util.Hashtable;
import spark.Request;
import edu.cooper.ece366.*;
import java.util.Map;

public class Handlers {
    Map<String, UserClass> my_users; //User list

    //Handler for user creation
    public void userHandler(Request req) {
        String pass = req.params(":field2");
        String name = req.params(":field1");
        if (1==1) {
            my_users.put(name, new UserClass(name, pass));
        }
    }

}

