package com.company;

public class Answer {
    private final String[] alternatives;
    private int correctAnswer;

    public Answer(String[] alternatives, int correctAnswer) {
        this.alternatives= alternatives;
        this.correctAnswer = correctAnswer;
    }

    public void setCorrectAnswer(int correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public String[] getText() {
        return alternatives;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }
}
