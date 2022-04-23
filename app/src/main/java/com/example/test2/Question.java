package com.example.test2;

public class Question {
    private int id;
    private String questionNo;
    private String question;
    private String answer;


    public int getId() {
        return id;
    }

    public String getQuestionNo() {
        return questionNo;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setQuestionNo(String questionNo) {
        this.questionNo = questionNo;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
