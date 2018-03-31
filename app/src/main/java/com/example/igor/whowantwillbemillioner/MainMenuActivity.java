package com.example.igor.whowantwillbemillioner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.example.igor.whowantwillbemillioner.Entites.Question;

import java.util.ArrayList;

public class MainMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

    }

    public void onClickExit(View view) {
        Animation anim= AnimationUtils.loadAnimation(this,R.anim.buttonalpha);
        view.startAnimation(anim);
        finish();
    }

    public void onClickStart(View view) {
        Animation anim=AnimationUtils.loadAnimation(this,R.anim.buttonalpha);
        view.startAnimation(anim);
      // int number=0;
      // ArrayList<Question> questionList = new ArrayList<>();
      //  questionList.addAll(Question.getQuestions());
      //  ArrayList<Integer> numbers=new ArrayList<>();
       // for ( int i=0;i<questionList.size();i++){
         //   numbers.add(i);
      //  }
        Intent intent = new Intent(this, QuestionActivity.class);
        //intent.putExtra("Number", number);
        //intent.putExtra("Questions", numbers);
        startActivity(intent);
        overridePendingTransition(R.anim.animstart,R.anim.myanim);
        finish();
    }
}
