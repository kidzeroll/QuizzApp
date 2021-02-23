package com.kidzeroll.quizzapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {

    private QuestionBank mQuestionLibrary = new QuestionBank();
    private  TextView mNama; // untuk text nama
    private TextView mScoreView;   // Untuk menampilkan skor saat ini
    private TextView mQuestionView;  //menampilkan jawaban
    private Button mButtonChoice1; // jawaban 1
    private Button mButtonChoice2; // jawaban 2
    private Button mButtonChoice3; //jawaban 3
    private Button mButtonChoice4; //jawaban 4

    private String mAnswer;  // untuk cek jawaban benar atau tidaknya
    private int mScore = 0;  // current total score
    private int mQuestionNumber = 0; //

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        mNama = findViewById(R.id.tv_nama);
        mScoreView = (TextView)findViewById(R.id.score);
        mQuestionView = (TextView)findViewById(R.id.question);
        mButtonChoice1 = (Button)findViewById(R.id.choice1);
        mButtonChoice2 = (Button)findViewById(R.id.choice2);
        mButtonChoice3 = (Button)findViewById(R.id.choice3);
        mButtonChoice4 = (Button)findViewById(R.id.choice4);
        updateQuestion();
        tvNama();
        updateScore(mScore);
    }

    private void updateQuestion(){
        //
        if(mQuestionNumber<mQuestionLibrary.getLength() ){


            mQuestionView.setText(mQuestionLibrary.getQuestion(mQuestionNumber));
            mButtonChoice1.setText(mQuestionLibrary.getChoice(mQuestionNumber, 1));
            mButtonChoice2.setText(mQuestionLibrary.getChoice(mQuestionNumber, 2));
            mButtonChoice3.setText(mQuestionLibrary.getChoice(mQuestionNumber, 3));
            mButtonChoice4.setText(mQuestionLibrary.getChoice(mQuestionNumber,4));
            mAnswer = mQuestionLibrary.getCorrectAnswer(mQuestionNumber);
            mQuestionNumber++;
        }
        else {
            Toast.makeText(QuizActivity.this, "It was the last question!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(QuizActivity.this, HighestScoreActivity.class);
            intent.putExtra("score", mScore); // pass the current score to the second screen
            intent.putExtra("user", mNama.getText().toString());
            startActivity(intent);
            finish();
        }
    }

    private void updateScore(int point) {
        mScoreView.setText("" + mScore+"/"+mQuestionLibrary.getLength());
    }

    private void tvNama(){
        Intent in = getIntent();
        String tv1 = in.getExtras().getString("tvNama");
        mNama.setText(tv1);
    }

    public void onClick(View view) {
        //semua logika untuk semua tombol jawaban dalam satu metode
        Button answer = (Button) view;
        // jika jawabannya benar, tingkatkan skornya
        if (answer.getText() == mAnswer){
            mScore = mScore + 1;
            Toast.makeText(QuizActivity.this, "Benar!", Toast.LENGTH_SHORT).show();
        }else
            Toast.makeText(QuizActivity.this, "Salah!", Toast.LENGTH_SHORT).show();

        updateScore(mScore);
        updateQuestion();
    }
}