package com.example.a31c_quizapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class QuizActivity extends AppCompatActivity {
    private TextView questionTextView;
    private RadioGroup answerOptionsRadioGroup;
    private Button submitButton;
    private ProgressBar progressBar;
    private int currentQuestionIndex = 0; // Index of the current question
    private String[] questions = {"What is the chemical symbol for gold??", "What is the OS of Iphone?"};
    private String[][] options = {{"Au", "Ag", "Pt"}, {"Android", "IOS", "HarmonyOS"}};
    private String[] correctAnswers = {"Au", "IOS"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        questionTextView = findViewById(R.id.questionTextView);
        answerOptionsRadioGroup = findViewById(R.id.answerOptionsRadioGroup);
        submitButton = findViewById(R.id.submitButton);
        progressBar = findViewById(R.id.progressBar);

        showQuestion(); // Display the first question

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(); // Check the selected answer
            }
        });
    }

    private void showQuestion() {
        if (currentQuestionIndex < questions.length) {
            // Display the current question and its options
            questionTextView.setText(questions[currentQuestionIndex]);

            answerOptionsRadioGroup.removeAllViews(); // Clear previous options

            for (int i = 0; i < options[currentQuestionIndex].length; i++) {
                RadioButton radioButton = new RadioButton(QuizActivity.this);
                radioButton.setText(options[currentQuestionIndex][i]);
                answerOptionsRadioGroup.addView(radioButton);
            }

            // Update progress bar
            int progress = (int) (((double) currentQuestionIndex / questions.length) * 100);
            progressBar.setProgress(progress);
        } else {
            // If all questions are answered
            Toast.makeText(QuizActivity.this, "Quiz completed!", Toast.LENGTH_SHORT).show();

        }
    }

    private void checkAnswer() {
        // Get the selected RadioButton
        int radioButtonId = answerOptionsRadioGroup.getCheckedRadioButtonId();
        RadioButton radioButton = findViewById(radioButtonId);

        // Check if an option is selected
        if (radioButton != null) {
            String selectedAnswer = radioButton.getText().toString();
            String correctAnswer = correctAnswers[currentQuestionIndex];

            // Check if the selected answer is correct
            if (selectedAnswer.equals(correctAnswer)) {
                Toast.makeText(QuizActivity.this, "Correct!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(QuizActivity.this, "Incorrect! Correct answer: " + correctAnswer, Toast.LENGTH_SHORT).show();
            }

            // Move to the next question
            currentQuestionIndex++;
            showQuestion();
        } else {
            // If no option is selected
            Toast.makeText(QuizActivity.this, "Please select an answer", Toast.LENGTH_SHORT).show();
        }
    }
}

