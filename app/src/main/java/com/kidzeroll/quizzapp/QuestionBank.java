package com.kidzeroll.quizzapp;

public class QuestionBank {

    private String textQuestions [] = {
            "1 + 1 = ",
            "2 + 2 = ",
            "3 + 3 = ",
            "4 + 4 = ",
            "5 + 5 = "

    };

    // array of multiple choices for each question
    private String multipleChoice [][] = {
            {"2", "3", "4", "5"},
            {"3", "4", "5", "6"},
            {"4", "5", "6", "7"},
            {"5", "6", "7", "8"},
            {"10", "11", "12", "13"}
    };

    private String mCorrectAnswers[] = {"2", "4", "6", "8", "10"};

    public int getLength(){
        return textQuestions.length;
    }

    public String getQuestion(int a) {
        String question = textQuestions[a];
        return question;
    }

    public String getChoice(int index, int num) {
        String choice0 = multipleChoice[index][num-1];
        return choice0;
    }

    public String getCorrectAnswer(int a) {
        String answer = mCorrectAnswers[a];
        return answer;
    }
}
