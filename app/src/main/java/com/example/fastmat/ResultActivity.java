package com.example.fastmat;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    private Typeface tf1;
    private TextView mTextView;
    private Button mButton;

    private int mPoints;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        mTextView = (TextView) findViewById(R.id.resultText);
        mButton = (Button) findViewById(R.id.playAgainButton);

        tf1 = Typeface.createFromAsset(getAssets(), "fonts/Lato-Black.ttf");
        mTextView.setTypeface(tf1);

        Intent intent = getIntent();
        mPoints = intent.getIntExtra("Points", 0);

        mTextView.setText("Your Score: " + mPoints);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ResultActivity.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });

    }
}
