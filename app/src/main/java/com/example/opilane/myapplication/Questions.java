package com.example.opilane.myapplication;

public class Questions {

    // array of questions
    public Integer MyQuestions [] = {
            R.drawable.canada,
            R.drawable.turkey,
            R.drawable.unitedkingdom,
            R.drawable.usa,
            R.drawable.japan
    };

    //array of multiple choices for each question
    private String MyChoices[][] = {
            {"Vancouver", "Toronto", "Ottowa", "Winnipeg"},
            {"Ankara", "Istanbul", "Bursa", "Mersin"},
            {"London", "Edinburgh", "Cardiff", "Manchester"},
            {"Washington, DC", "New York", "Seattle", "Las Vegas"},
            {"Kyoto", "Tokyo", "Osaka", "Nagoya"}

    };

    // array of correct answers - in the same order as array of questions
    private String MyCorrectAnswers[] = {"Toronto", "Istanbul", "Great Britain", "Washington, DC", "Tokyo"};

    // method returns number of questions
    public int getLength() {
        return MyQuestions.length;
    }

    // method returns question from array textQuestions[] based on array index
    public Integer getQuestion(int a) {
        Integer question = MyQuestions[a];
        return question;
    }

    // method returns a single multiple choice item for question based on array index,
    // based on number of multiple choice item in the list - 1, 2, 3 or 4 as an argument
    public String getChoice(int index, int num) {
        String choice0 = MyChoices[index][num - 1];
        return choice0;
    }

    //  method returns correct answer for the question based on array index
    public String getCorrectAnswer(int a) {
        String answer = MyCorrectAnswers[a];
        return answer;
    }
}
