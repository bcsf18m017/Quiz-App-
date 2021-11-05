package com.example.alphaprac;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class QuizPage extends AppCompatActivity {


    String questions[],key[],answers[];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_page2);
    }
    public void setQuestions()
    {
        questions=new String[26];


    }
    public void setKeys()
    {}

}