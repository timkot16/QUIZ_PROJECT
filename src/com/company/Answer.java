package com.company;

public class Answer {
    private String[] alternatives;
    private int correctAnswer;

    private String text;
    private boolean correct;
    private int id;

    public Answer(int id, String text, boolean correct) {
        this.id = id;
        this.text = text;
        this.correct = correct;
    }

    public Answer(String[] alternatives, int correctAnswer) {
        this.alternatives = alternatives;
        this.correctAnswer = correctAnswer;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCorrectAnswer(int correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public String[] getAlternatives() {
        return alternatives;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }
}
