package edu.cooper.ece366.codingForum.store;

import edu.cooper.ece366.codingForum.model.Answer;
import edu.cooper.ece366.codingForum.model.PostClass;
import edu.cooper.ece366.codingForum.model.UserClass;

import java.util.HashMap;
import java.util.Map;

public interface AnswerStore {

    void addAnswer(PostClass post, Answer ans);

    Answer getAnswers(PostClass post);
}