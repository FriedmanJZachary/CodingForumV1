package edu.cooper.ece366.codingForum.store;

import edu.cooper.ece366.codingForum.model.Answer;
import edu.cooper.ece366.codingForum.model.PostClass;
import edu.cooper.ece366.codingForum.model.UserClass;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

public interface AnswerStore {

    String addAnswer(PostClass post, Answer ans);

    List<Answer> getAnswers(PostClass post);
}