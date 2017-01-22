package com.example.fastmat;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {

    private Typeface tf1;
    private TextView mCountdownText;
    private TextView mOperationText;
    private EditText mAnswer;
    private Calculation mCalculation = new Calculation();
    private int mNumberOfPoints;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        mCountdownText = (TextView) findViewById(R.id.countdownText);
        mOperationText = (TextView) findViewById(R.id.operationText);
        mAnswer = (EditText) findViewById(R.id.answer);

        tf1 = Typeface.createFromAsset(getAssets(), "fonts/Lato-Black.ttf");
        mCountdownText.setTypeface(tf1);

        new CountDownTimer(25000, 1000) {

            public void onTick(long millisUntilFinished) {
                mCountdownText.setText("" + millisUntilFinished / 1000);
                if(millisUntilFinished/1000 <= 10){
                    mCountdownText.setTextColor(Color.RED);
                    mCountdownText.setTextSize(35);
                }
            }

            public void onFinish() {
                Intent intent = new Intent(QuizActivity.this, ResultActivity.class);
                intent.putExtra("Points", mNumberOfPoints);
                startActivity(intent);
            }
        }.start();
        playGame();
    }

    public void playGame(){
        mCalculation.generateQuestion();
        String question = mCalculation.getQuestion();
        final int answer = mCalculation.getAnswer();
        mOperationText.setText(question);

        mAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String getUserInput = mAnswer.getText().toString();
                if(getUserInput.isEmpty()){
                    Toast.makeText(QuizActivity.this, "You are entering nothing!", Toast.LENGTH_SHORT).show();
                }
                else {
                    int answerOfUser = Integer.parseInt(mAnswer.getText().toString());
                    if (answer == answerOfUser) {
                        mNumberOfPoints++;
                    }
                    mAnswer.setText("");
                    playGame();
                }
            }
        });
    }
}
