package edu.cooper.ece366.codingForum;
import edu.cooper.ece366.codingForum.model.UserClass;
import edu.cooper.ece366.codingForum.model.PostClass;
import edu.cooper.ece366.codingForum.model.Answer;
import spark.Request;
import java.util.HashMap;
import java.util.Map;

public class Handlers {
    Map<String, UserClass> userList = new HashMap<String, UserClass>();

    //Handler for user creation
    public String userHandler(Request req) {
        String pass = req.params(":field2");
        String name = req.params(":field1");
        if (!userList.containsKey(name)) {
            UserClass newU = new UserClass(name, pass);
            userList.put(name, newU);
            System.out.print(userList.get(name).userName + "\n");
            return "NEW USER CREATED";
        } else {
            System.out.print("USER REPEATED\n");
            return "USER REPEATED";
        }
    }

    //Handler for user deletion
    public String userRemover(Request req) {
        String pass = req.params(":field2");
        String name = req.params(":field1");
        if (userList.containsKey(name)) {
            UserClass currentUser = userList.get(name);
            System.out.print("CURRENT PASS = " + currentUser.pass + "\n");
            System.out.print("PASS = " + pass + "\n");

            //Check user authentication
            if (currentUser.pass.equals(pass)) {
                userList.remove(currentUser);
                System.out.print(userList + "\n");
                return "USER DELETED";
            } else {
                return "USER AUTHENTICATION REJECTED";
            }
        } else {
            System.out.print("USER NOT FOUND\n");
            return "USER NOT FOUND";
        }
    }

    //Handler for password modification
    public String passChange(Request req) {
        String oldPass = req.params(":field2");
        String newPass = req.params(":field3");
        String name = req.params(":field1");

        if (userList.containsKey(name)) {
            if (userList.get(name).pass.equals(oldPass)) {
                userList.get(name).pass = newPass;
                return "USER PASSWORD CHANGED";
            } else {
                return "USER AUTHENTICATION REJECTED";
            }
        } else {
            System.out.print("USER NOT FOUND\n");
            return "USER NOT FOUND";
        }
    }

    //TESTCOMMENT
    //ANOTHER COMMENT
    // Handler to answer coding problems or posts
    public String answerHandler(Request request) {
        String username = getUsername(request);
        Long askPostID = getAskPostID(request);
        String answerType = getAnswerType(request); // will be either code or reply
        String content = getContent(request);
        Answer ans = new Answer(username, askPostID, answerType, content);
        return ans.postAnswer();
    }

    private String getUsername(final Request request) {
        return String.valueOf(request.params(":field1"));
    }

    private Long getAskPostID(final Request request) {
        return Long.valueOf(request.params(":field2"));
    }

    private String getAnswerType(final Request request) {
        return String.valueOf(request.params(":field3"));
    }

    private String getContent(final Request request) {
        return String.valueOf(request.params(":field4"));
    }
}
