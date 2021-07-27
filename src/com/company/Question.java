package com.company;

import java.util.List;

public class Question {
    private String questionText;
    private int questionID;
    private List<Answer> answers;

    public Question() {
    }

    public Question(int questionID, String questionText, List<Answer> answers) {
        this.questionID = questionID;
        this.questionText = questionText;
        this.answers = answers;
    }

    public Question(String questionText, int questionID) {
        this.questionText = questionText;
        this.questionID = questionID;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }


    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public int getQuestionID() {
        return questionID;
    }

    public Answer getAnswerById(int id) {
        for (Answer answer : answers) {
            if (answer.getId() == id) {
                return answer;
            }
        }
        return null;
    }
}
