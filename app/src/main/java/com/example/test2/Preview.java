package com.example.test2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

public class Preview extends AppCompatActivity {
    public int questionInt = 1;
    private Button btnNext, btnPrev;
    private EditText question_no, question, answer;
    private List<Question> questionList;
    private Question que;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview);

        question_no = findViewById(R.id.txtQuestionNo);
        question = findViewById(R.id.txtQuestion);
        answer = findViewById(R.id.txtAnswer);

        questionList = getAllQuestions();

        que = nextQuestion(questionInt);

        btnNext = findViewById(R.id.buttonNext);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (questionInt <3){
                    que = nextQuestion(questionInt);
                    setFields(que);
                    questionInt++;
                }


            }
        });

        btnPrev = findViewById(R.id.buttonPrevious);

        btnPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (questionInt >0){
                    que = nextQuestion(questionInt);
                    setFields(que);
                    questionInt--;
                }

            }
        });
    }

    private List<Question> getAllQuestions() {
        DBhelper myDB = new DBhelper(Preview.this);
        return myDB.getAllQuestions();
    }

    private Question nextQuestion(int num) {

        return questionList.get(num);

    }

    private void setFields(Question q) {
        question_no.setText("Question " + (questionInt + 1) + "/3: \n \n" + q.getQuestion());
        question.setText(q.getQuestion());
        answer.setText(q.getAnswer());

    }


}