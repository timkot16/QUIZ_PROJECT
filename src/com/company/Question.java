package com.company;

public class Question {
    private final String questionText;
    private final int questionID;

    public Question(String questionText, int questionID) {
        this.questionText = questionText;
        this.questionID = questionID;
    }

    public String getQuestionText() {
        return questionText;
    }

    public int getQuestionID() {
        return questionID;
    }
}
