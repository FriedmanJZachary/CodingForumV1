package edu.cooper.ece366.codingForum;
import javax.naming.directory.Attributes;
import java.util.Hashtable;
import edu.cooper.ece366.*;

public class Handlers {
    Hashtable<UserClass, String> my_users = new Hashtable<UserClass, String>(); //User list

    //Handler for user creation
    public void userHandler(String name, String pass) {
        if (1==1) {
            my_users.put(new UserClass(name, pass),"NEWUSER");
        }
    }

    public Answer createAnswer(Request request) {
        Long answerPostID = getAnswerPostID();
        Long askPostID = getAskPostID(request);
        String codeFilePath = getCodeFilePath(request);
        Answer ans = new Answer(answerPostID, askPostID, codeFilePath);
        return service.createAnswer(ans)
    }

    private Long getAskPostID(final Request request) {
        returnlong.valueOf(request.params(":askpostid"));
    }

    private String getCodeFilePath(final Request request) {
        returnstring.valueOf(request.params(":codefilepath"));
    }


}

