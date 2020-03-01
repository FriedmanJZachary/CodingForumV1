package edu.cooper.ece366.codingForum;

import org.apache.log4j.BasicConfigurator;
import javax.naming.directory.Attributes;
import java.util.Hashtable;
import static spark.Spark.*;
import edu.cooper.ece366.codingForum.*;

public class SparkUser {
    public static void main(String[] args) {
        final Handlers myHandler = new Handlers();
        //Basic Hello World response
        get("/hello", (req, res) -> "Hello World \n");

        //Determine what to do with 3-field string
        get("/:action/:field1/:field2", (req,res)-> {
            String action = req.params(":action");

            //If 'action' has called for creation of a new user, do so and report
            if (action.contains("newUser")){
                myHandler.userHandler(req);
                return "Hello: New User Requested\n";
            }
            else if (action.contains("answer")){
                myHandler.answerHandler(req);
            }

            return "Hello: Nothing Happened" + "\n"; //None of the conditions were met, and so nothing was done
        });
    }
}
