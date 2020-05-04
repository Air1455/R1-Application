package com.example.r1_application.model;

import java.util.List;

public class Question {
    private String question;
    private List<String> answerChoice;
    private int choiceId;

    public Question(String question, List<String> answerChoice, int choiceId) {
        this.question = question;
        this.answerChoice = answerChoice;
        this.choiceId = choiceId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<String> getAnswerChoice() {
        return answerChoice;
    }

    public void setAnswerChoice(List<String> answerChoice) {
        this.answerChoice = answerChoice;
    }

    public int getChoiceId() {
        return choiceId;
    }

    public void setChoiceId(int choiceId) {
        this.choiceId = choiceId;
    }
}
