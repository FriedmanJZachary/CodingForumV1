package edu.cooper.ece366.codingForum.model;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
public class Answer {
    // Instance Variables
    private final String username;
    private final Long askPostID;
    private final String answerType; // with code or post reply
    private final String content; // either a file path to code or a reply text
    private final Timestamp timestamp;

    public Answer(String username, Long askPostID, String answerType, String content){
        this.username = username;
        this.askPostID = askPostID;
        this.answerType = answerType;
        this.content = content;
        timestamp = new Timestamp(System.currentTimeMillis());
    }

    public String getUsername() { return username; }
    public Long getAskPostID() { return askPostID; }
    public String getAnswerType() { return answerType; }
    public String getContent() { return content; }
    public Timestamp getTime() { return timestamp; }

    static final AtomicLong NEXT_ID = new AtomicLong(0);
    final long answerID = NEXT_ID.getAndIncrement();
}