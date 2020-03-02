package edu.cooper.ece366.codingForum;
import edu.cooper.ece366.codingForum.model.UserClass;
import edu.cooper.ece366.codingForum.model.PostClass;
import edu.cooper.ece366.codingForum.model.Answer;
import edu.cooper.ece366.codingForum.store.AnswerStore;
import edu.cooper.ece366.codingForum.store.PostStore;
import spark.Request;
import java.util.HashMap;
import java.util.Map;

public class Handlers {
    Map<String, UserClass> userList = new HashMap<String, UserClass>();
    private final PostStore postStore;
    private final AnswerStore answerStore;

    public Handlers(PostStore postStore, AnswerStore answerStore) {
        this.postStore = postStore;
        this.answerStore = answerStore;
    }

// ###################### Creating/removing/modifying USERS ###################### //

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
                userList.remove(name); //Bug fixed
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

    //Check if user in database
    public boolean isUser(String name) {
        if (userList.containsKey(name)) {
            return true;
        } else {
            return false;
        }
    }

// ###################### Creating/deleting/modifying POSTS ###################### //

    // http://localhost:4567/zach3/question/"c c++ structs"/"Can I make a C struct in C++?"

    // Handler for post creation action=newPost
    public String postCreate(Request req) {
        String username = req.params(":field1");
        String type = req.params(":field2");
        String tags = req.params(":field3");
        String post = req.params(":field4");

        // checks if the provided username is valid
        if(!userList.containsKey(username)){
            System.out.print("USER NOT FOUND\n");
            return "USER NOT FOUND";
        }

        // Seperates tags (single string containing commas) into array of strings
        String delimiter = " ";
        String[] tagsArray = tags.split(delimiter);
        // Creates and saves a new post object
        PostClass newPost = new PostClass(type, username, post, tagsArray);
        postStore.newPost(newPost);

        String idString = newPost.getId().toString();
        System.out.print("NEW POST CREATED WITH ID: " + "idString\n");
        return idString;
    }


// ###################### ANSWERS AND COMMENTS FOR POSTS ###################### //

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

// test comment