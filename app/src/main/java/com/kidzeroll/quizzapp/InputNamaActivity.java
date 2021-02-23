package com.kidzeroll.quizzapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class InputNamaActivity extends AppCompatActivity {

    EditText tvInput;
    Button btnLanjutkan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_nama);

        tvInput = findViewById(R.id.tv_input);
        btnLanjutkan = findViewById(R.id.btn_lanjutkan);

        btnLanjutkan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent z = new Intent(InputNamaActivity.this, QuizActivity.class);
                z.putExtra("tvNama", tvInput.getText().toString());
                startActivity(z);
                finish();
            }
        });
    }
}