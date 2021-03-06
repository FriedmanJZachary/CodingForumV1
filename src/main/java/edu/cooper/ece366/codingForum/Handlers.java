package edu.cooper.ece366.codingForum;
import edu.cooper.ece366.codingForum.model.UserClass;
import edu.cooper.ece366.codingForum.model.PostClass;
import edu.cooper.ece366.codingForum.model.Answer;
import edu.cooper.ece366.codingForum.store.AnswerStore;
import edu.cooper.ece366.codingForum.store.PostStore;
import spark.Request;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

public class Handlers {
    Map<String, UserClass> userList = new HashMap<>();
    private final PostStore postStore;
    private final AnswerStore answerStore;

    public Handlers(PostStore postStore, AnswerStore answerStore) {
        this.postStore = postStore;
        this.answerStore = answerStore;
    }

// ###################### Creating/removing/modifying USERS ###################### //

    //Handler for user creation
    public String userHandler(Request req) {
        String name = req.params(":field1");
        String pass = req.params(":field2");
        String firstName = req.params(":field2");
        String lastName = req.params(":field1");
        String email = req.params(":field2");

        if (!userList.containsKey(name)) {
            UserClass newU = new UserClass(name, pass, firstName, lastName, email);
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
        return userList.containsKey(name);
    }

// ###################### Creating/deleting/modifying POSTS ###################### //

    // Handler for post creation action=newPost
    // Format: /newPost/username/type/tag1-tag2-.../"content of post"
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

        // Separates tags (single string containing commas) into array of strings
        String delimiter = "-";
        String[] tagsArray = tags.split(delimiter);
        // Creates and saves a new post object
        PostClass newPost = new PostClass(type, username, post, tagsArray);
        postStore.newPost(newPost);

        String idString = newPost.getId().toString();
        System.out.print("NEW POST CREATED WITH ID: " + idString + "\n");

        return "NEW POST CREATED WITH ID: " + idString;
    }

    // Handler for post creation action=editTags
    // Format: /addTags/postID/tags
    public String postAddTags(Request req) {
        String idstr = req.params(":field1");
        String tags = req.params(":field2");

        Long id = Long.parseLong(idstr);

        PostClass post = postStore.getPost(id);
        postStore.addTag(post, tags);

        System.out.print("Tag '" + tags + "' added to POST with ID: " + idstr +"\n" );
        return("TAG '" + tags + "' ADDED TO POST WITH ID: " + idstr +"\n" );
    }
    public String returnPost(Request req) {
        String idstr = req.params(":field1");
        Long id = Long.parseLong(idstr);
        PostClass post = postStore.getPost(id);
        return post.getBody();
    }


    // ###################### ANSWERS AND COMMENTS FOR POSTS ###################### //
    // Handler to answer coding problems or posts
    public String answerHandler(Request request) {
        String username = String.valueOf(request.params(":field1"));
        if (!isUser(username)) {return "User does not exist!";}
        Long askPostID = Long.valueOf(request.params(":field2"));
        String answerType = String.valueOf(request.params(":field3")); // will be either code or reply
        String content = String.valueOf(request.params(":field4"));
        Answer ans = new Answer(username, askPostID, answerType, content);
        PostClass post = postStore.getPost(askPostID);
        return answerStore.addAnswer(post, ans);
    }

    public String getAnswersHandler(Request request) {
        Long askPostID = Long.valueOf(request.params(":field1"));
        PostClass post = postStore.getPost(askPostID);
        List<Answer> answerList = answerStore.getAnswers(post);
        String answerContent = "\nAnswers to Post: " + post.getBody().replace("_"," ") + "\n\n";
        for (int i = 0; i < answerList.size(); i++) {
            Answer answer = answerList.get(i);
            answerContent = answerContent + answer.getUsername() + ": " + answer.getContent().replace("_"," ") + "\n\n";
        }
        return answerContent;
    }
}