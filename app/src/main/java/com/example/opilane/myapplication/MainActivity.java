package com.example.opilane.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Questions MyQuestions = new Questions();

    private Button choice5; //multible choice1 from Questions
    private Button choice6; //multible choice2 from Questions
    private Button choice7; //multible choice3 from Questions
    private Button choice8; //multible choice4 from Questions
    private TextView score; //view for current total score
    private ImageView question; // current question to answer
    private String MyAnswer; // correct answer for question
    private int MyScore = 0; // current total score
    private int MyQuestionNumber = 0; // current question number


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // setup screen for the first question with four alternative to answer
        choice5 = (Button) findViewById(R.id.choice5);
        choice6 = (Button) findViewById(R.id.choice6);
        choice7 = (Button) findViewById(R.id.choice7);
        choice8 = (Button) findViewById(R.id.choice8);
        score = (TextView) findViewById(R.id.score);
        question = (ImageView) findViewById(R.id.imageView1);
        updateQuestion();
        // show current total score for the user
        updateScore(MyScore);
    }

    private void updateScore(int point) {
        score.setText("" + MyScore + "/" + MyQuestions.getLength());
    }

    private void updateQuestion() {
        // check if we are not outside array bounds for questions
        if (MyQuestionNumber < MyQuestions.getLength()) {
            // set the text for new question, and new 4 alternative to answer on four buttons
            question.setImageResource(MyQuestions.getQuestion(MyQuestionNumber));
            choice5.setText(MyQuestions.getChoice(MyQuestionNumber, 1));
            choice6.setText(MyQuestions.getChoice(MyQuestionNumber, 2));
            choice7.setText(MyQuestions.getChoice(MyQuestionNumber, 3));
            choice8.setText(MyQuestions.getChoice(MyQuestionNumber, 4));
            MyAnswer = MyQuestions.getCorrectAnswer(MyQuestionNumber);
            MyQuestionNumber++;
        } else {
            Toast.makeText(MainActivity.this, "It was the last question!", Toast.LENGTH_SHORT).show();
            //last question, create new activity & show current and highest score
            //we use intent which is responsible for providing switch between current activity and new one
            Intent intent = new Intent(MainActivity.this, HighestScoreActivity.class);
            intent.putExtra("score", MyScore); // pass the current score to the second screen
            startActivity(intent);
        }
    }

    public void onClick(View view) {
        //all logic for all answer buttons in one method
        Button answer = (Button) view;
        // if the answer is correct, increase the score
        if (answer.getText() == MyAnswer) {
            MyScore = MyScore + 1;
            Toast.makeText(MainActivity.this, "Correct!", Toast.LENGTH_SHORT).show();
        } else
            Toast.makeText(MainActivity.this, "Wrong!", Toast.LENGTH_SHORT).show();
        // show current total score for the user
        updateScore(MyScore);
        // once the user answers the question we move on to the next one
        updateQuestion();
    }
}
