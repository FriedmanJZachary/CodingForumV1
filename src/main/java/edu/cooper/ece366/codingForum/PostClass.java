package edu.cooper.ece366.codingForum;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

public class PostClass {
    // Instance Variables
    private final Long id;
    private final Integer type; //coding problem or post/question
    private final String author; //UserClass.id

    private String post;    //body of text containing the post
    private String tags[];  //each string is a tag

    private final Timestamp timestamp;
    private Map<Integer, String> likes = new HashMap<Integer, String>();

    public PostClass(Long id, Integer type, String author, String post, String tags[]){
        this.id = id;
        this.type = type;
        this.author = author;
        this.post = post;
        this.tags = tags;

        timestamp = new Timestamp(System.currentTimeMillis());
     //   likes = new Map<Integer, String>();


    }

    public Long getId() { return id; }
    public Integer getType() { return type; }
    public String getAuthor() { return author; }
    public String[] getTags() { return tags; }
    public Timestamp getTime() { return timestamp; }


}
