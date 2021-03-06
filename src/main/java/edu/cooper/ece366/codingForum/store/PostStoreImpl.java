package edu.cooper.ece366.codingForum.store;

import edu.cooper.ece366.codingForum.model.PostClass;
import edu.cooper.ece366.codingForum.model.UserClass;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PostStoreImpl implements PostStore {

    private Map<Long, PostClass> postList;

    public PostStoreImpl() {
        this.postList = new HashMap<>();
    }
    public PostStoreImpl(Map<Long, PostClass> postList) {this.postList = postList;}
    public PostStoreImpl(PostClass post) {
        postList.put(post.getId(), post);
    }

    public void newPost(PostClass post){
        postList.put(post.getId(), post);
    }

    @Override
    public PostClass getPost(Long id) {
        return postList.get(id);
    }

    @Override
    public void addLike(PostClass post, UserClass user){
        throw new UnsupportedOperationException("Error: addLike not implemented yet\n");
    }

    @Override
    public void addTag(PostClass post, String newtag){
        String[] tags = post.getTags();
        tags = Arrays.copyOf(tags, tags.length +1);
        tags[tags.length-1] = newtag;

        post.setTags(tags);
    }

    @Override
    public void editPost(PostClass post, String text){
        throw new UnsupportedOperationException("Error: editPost not implemented yet\n");
    }

}
