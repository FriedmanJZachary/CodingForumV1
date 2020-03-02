package edu.cooper.ece366.codingForum.store;

import edu.cooper.ece366.codingForum.model.PostClass;
import edu.cooper.ece366.codingForum.model.UserClass;
import spark.ResponseTransformer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PostStoreImpl implements PostStore{

    //private Map<Long id, PostClass> postList = new HashMap<Long, PostClass>;




    public void addLike(PostClass post, UserClass user){
        throw new UnsupportedOperationException("Error: addLike not implemented yet\n");
    }

    public void addTag(PostClass post, String tag){
        throw new UnsupportedOperationException("Error: addTag not implemented yet\n");
    }

    public void editPost(PostClass post, String text){
        throw new UnsupportedOperationException("Error: editPost not implemented yet\n");
    }

}
