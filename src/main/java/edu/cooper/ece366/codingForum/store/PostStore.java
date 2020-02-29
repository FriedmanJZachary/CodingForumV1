package edu.cooper.ece366.codingForum.store;

import edu.cooper.ece366.codingForum.model.PostClass;
import edu.cooper.ece366.codingForum.model.UserClass;
import spark.ResponseTransformer;

public interface PostStore {

//    PostClass getPost(PostClass post);

    void addLike(PostClass post, UserClass user);

    void addTag(PostClass post, String tag);

    void editPost(PostClass post, String text);
}
