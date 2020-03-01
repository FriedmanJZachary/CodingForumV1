package edu.cooper.ece366.codingForum;
import edu.cooper.ece366.codingForum.model.UserClass;
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

        if (userList.get(name).pass.equals(oldPass)){
            userList.get(name).pass = newPass;
            return "USER PASSWORD CHANGED";
        } else {
            return "USER AUTHENTICATION REJECTED";
        }
    }

//    public Answer createAnswer(Request request) {
//        Long answerPostID = getAnswerPostID();
//        Long askPostID = getAskPostID(request);
//        String codeFilePath = getCodeFilePath(request);
//        Answer ans = new Answer(answerPostID, askPostID, codeFilePath);
//        return service.createAnswer(ans);
//    }
//
//    private Long getAskPostID(final Request request) {
//        returnlong.valueOf(request.params(":askpostid"));
//    }
//
//    private String getCodeFilePath(final Request request) {
//        returnstring.valueOf(request.params(":codefilepath"));
//    }


}




