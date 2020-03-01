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

