package com.company;

import java.util.Map;

public class PlayerResult {
    private String name;
    private int result;
    private Map<String, String> questionAnswer;

    public PlayerResult(String name, int result, Map<String, String> questionAnswer) {
        this.name = name;
        this.result = result;
        this.questionAnswer = questionAnswer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public Map<String, String> getQuestionAnswer() {
        return questionAnswer;
    }

    public void setQuestionAnswer(Map<String, String> questionAnswer) {
        this.questionAnswer = questionAnswer;
    }
}
