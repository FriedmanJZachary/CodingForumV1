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
        returnString = returnString + "SUCCESFFULY ANSWERED POST WITH ID: " + post.getId();
        if (ans.getAnswerType().contains("code")) {
            returnString = returnString + "\nSORRY, OUR BUILT-IN COMPILER IS NOT YET IMPLEMENTED.";
        }
        return returnString;
    }

    @Override
    public List<Answer> getAnswers(PostClass post) {
        return new ArrayList<>(answerList.get(post));
    }
}
