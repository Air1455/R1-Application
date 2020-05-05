package com.example.r1_application.model;

import java.util.Collections;
import java.util.List;

public class QuestionList {
    private List<Question> questionList;
    private int nextQuestionIndex;

    public QuestionList(List<Question> questionList) {
        this.questionList = questionList;
        Collections.shuffle(questionList);
        nextQuestionIndex = 0;
    }

    public Question getQuestion(){
        if(nextQuestionIndex == questionList.size()){
            nextQuestionIndex = 0;
        }
        return questionList.get ( nextQuestionIndex++ );
    }

    public List<Question> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<Question> questionList) {
        questionList = questionList;
    }
}
