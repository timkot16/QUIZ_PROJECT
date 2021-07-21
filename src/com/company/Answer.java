package com.company;

public class Answer {
    private final String text;
    private int correctAnswer;

    public Answer(String text) {
        this.text = text;
    }

    public void setCorrectAnswer(int correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public String getText() {
        return text;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }
}
