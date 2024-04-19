package com.example.a31c_quizapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.a31c_quizapp.R;

public class FinalScoreActivity extends AppCompatActivity {
    TextView scoreTextView;
    EditText nameEditText;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_score);

        scoreTextView = findViewById(R.id.scoreTextView);
        nameEditText = findViewById(R.id.nameEditText);
        Button takeNewQuizButton = findViewById(R.id.takeNewQuizButton);
        Button finishButton = findViewById(R.id.finishButton);

        sharedPreferences = getSharedPreferences("quiz_pref", MODE_PRIVATE);
        String name = sharedPreferences.getString("name", "");
        nameEditText.setText(name);

        int score = getIntent().getIntExtra("score", 0);
        scoreTextView.setText("Your score: " + score);

        takeNewQuizButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FinalScoreActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        finishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
