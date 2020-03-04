package edu.cooper.ece366.codingForum.store;

import edu.cooper.ece366.codingForum.model.Answer;
import edu.cooper.ece366.codingForum.model.PostClass;
import edu.cooper.ece366.codingForum.model.UserClass;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnswerStoreImpl implements AnswerStore {

    private final Map<PostClass, ArrayList<Answer>> answerList;

    public AnswerStoreImpl() {
        this.answerList = new HashMap<>();
    }
    public AnswerStoreImpl(Map<PostClass, ArrayList<Answer>> answerList) {
        this.answerList = answerList;
    }

    @Override
    public String addAnswer(PostClass post, Answer ans) {
        String returnString = "";
        ArrayList<Answer> answers = answerList.getOrDefault(post, new ArrayList<>());
        answers.add(ans);
        answerList.put(post,answers);
        returnString = returnString + "Successfully answered post " + post.getId();
        if (ans.getAnswerType().contains("code")) {
            returnString = returnString + "\nSorry, our built-in compiler is not yet implemented";
        }
        return returnString;
    }

    @Override
    public List<Answer> getAnswers(PostClass post) {
        return new ArrayList<>(answerList.get(post));
    }
}
