package edu.cooper.ece366.codingForum.store;

import edu.cooper.ece366.codingForum.model.Answer;
import edu.cooper.ece366.codingForum.model.PostClass;
import edu.cooper.ece366.codingForum.model.UserClass;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnswerStoreImpl implements AnswerStore {

    private final Map<PostClass, Answer> answerList;

    public AnswerStoreImpl() {
        this.answerList = new HashMap<>();
    }
    public AnswerStoreImpl(Map<PostClass, Answer> answerList) {
        this.answerList = answerList;
    }

    @Override
    public void addAnswer(PostClass post, Answer ans) {
        answerList.put(post, ans);
    }

    @Override
    public Answer getAnswers(PostClass post) {
        throw new UnsupportedOperationException("Error: editPost not implemented yet\n");
    }
}