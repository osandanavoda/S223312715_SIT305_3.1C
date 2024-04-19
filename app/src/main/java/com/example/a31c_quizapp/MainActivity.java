package com.example.a31c_quizapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.a31c_quizapp.R;

public class MainActivity extends AppCompatActivity {
    EditText nameEditText;
    Button startButton;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameEditText = findViewById(R.id.nameEditText);
        startButton = findViewById(R.id.startButton);
        sharedPreferences = getSharedPreferences("quiz_pref", MODE_PRIVATE);

        String savedName = sharedPreferences.getString("name", "");
        nameEditText.setText(savedName);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameEditText.getText().toString();
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("name", name);
                editor.apply();

                Intent intent = new Intent(MainActivity.this, QuizActivity.class);
                startActivity(intent);
            }
        });
    }
}
