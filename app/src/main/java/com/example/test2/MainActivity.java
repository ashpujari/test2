package com.example.test2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText questionNo, question, answer;
    Button btnAdd, btnDone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        questionNo = findViewById(R.id.txtQuestionNo);
        question = findViewById(R.id.txtQuestion);
        answer = findViewById(R.id.txtAnswer);

        btnAdd = findViewById(R.id.buttonAdd);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBhelper db = new DBhelper(MainActivity.this);
                boolean result = db.insertQuestion(
                        questionNo.getText().toString().trim(),
                        question.getText().toString().trim(),
                        answer.getText().toString().trim());

                if (result) {
                    Toast.makeText(getApplicationContext(), "Saved Successfully", Toast.LENGTH_SHORT).show();
                    //clear fields

                    questionNo.setText(null);
                    question.setText(null);
                    answer.setText(null);

                    questionNo.requestFocus();
                } else {
                    Toast.makeText(getApplicationContext(), "Error Encountered while Saving.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnDone = findViewById(R.id.buttonDone);
        btnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Preview.class);

                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(i);

                finish();
            }
        });

    }
}