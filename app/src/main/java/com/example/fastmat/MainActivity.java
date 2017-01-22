package com.example.fastmat;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mWelcomeText;
    private TextView mButtonText;
    private Typeface tf1;
    private Typeface tf2;
    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mWelcomeText = (TextView) findViewById(R.id.welcomeText);
        tf1 = Typeface.createFromAsset(getAssets(), "fonts/BungeeShade-Regular.ttf");
        mWelcomeText.setTypeface(tf1);

        mButtonText = (TextView) findViewById(R.id.startButton);
        tf2 = Typeface.createFromAsset(getAssets(), "fonts/Lato-Black.ttf");
        mButtonText.setTypeface(tf2);

        mButton = (Button) findViewById(R.id.startButton);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startQuiz();
            }
        });

    }

    public void startQuiz(){
        Intent intent = new Intent(this, QuizActivity.class);
        startActivity(intent);
    }
}
