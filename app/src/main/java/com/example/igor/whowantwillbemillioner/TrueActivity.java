package com.example.igor.whowantwillbemillioner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import java.util.ArrayList;

public class TrueActivity extends AppCompatActivity {
   // ArrayList<Integer> check=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitytrue);
        //check=getIntent().getIntegerArrayListExtra("check");
    }
    public void Click(View view){
        Animation anim= AnimationUtils.loadAnimation(this,R.anim.buttonalpha);
        view.startAnimation(anim);
        Intent intent=new Intent(this,QuestionActivity.class);
        //intent.putExtra("TrueCheck",check);
        startActivity(intent);
        finish();
        }
    }

