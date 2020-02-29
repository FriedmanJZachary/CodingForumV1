package edu.cooper.ece366.codingForum;

import edu.cooper.ece366.codingForum.model.UserClass;
import spark.Request;

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

