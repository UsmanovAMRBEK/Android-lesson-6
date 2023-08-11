package com.example.android_lesson_006.questions;

public class Question {
    String question;
    String answer1;
    String answer2;
    String answer3;
    int correctAnswer;

    public Question(String question, String answer1, String answer2, String answer3, int correctAnswer) {
        this.question = question;
        this.answer1 = answer1;
        this.answer2 =answer2;
        this.answer3 = answer3;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer1() {
        return answer1;
    }

    public void setAnswer1(String answer1) {
        this.answer1 = answer1;
    }

    public String getAnswer2() {
        return answer2;
    }

    public void setAnswer2(String answer2) {
        this.answer2 = answer2;
    }

    public String getAnswer3() {
        return answer3;
    }

    public void setAnswer3(String answer3) {
        this.answer3 = answer3;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(int correctAnswer) {
        this.correctAnswer = correctAnswer;
    }
}
