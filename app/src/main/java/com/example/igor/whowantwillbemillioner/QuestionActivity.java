package com.example.igor.whowantwillbemillioner;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import com.example.igor.whowantwillbemillioner.Entites.Question;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class QuestionActivity extends AppCompatActivity {
 int iD;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activityquestion);
        ArrayList<Question> questionList = new ArrayList<>();
        questionList.addAll(Question.getQuestions());
        ArrayList<Integer> numbers=new ArrayList<>();
        for ( int i=0;i<questionList.size();i++){
            numbers.add(i);
        }
        Collections.shuffle(numbers);//получается у меня все перемешивается в массиве
        final Random random = new Random();
        int index=random.nextInt(numbers.size());//и + еще рандомный индекс
        iD=numbers.indexOf(index);
        //но все равно бывает что идут два одинаковых друг за другом
        // можно конечно сделать диапозон рандома поменьше, у меня вообще была идея сделать проверку на повтор
        // ну собственно я ее сделал и она работала, но потом удалил и хотел сделать
        //ArrayList вопросов, к-ые  уже были, потом там идут обмены инфой между активностями...
        //  каждый раз я бы проверял если iD в числе вопросов, к-ые уже были если нет
        // то подходит, если есть то перемешать массив, если не как не получить новый iD==>
        //все вопросы были значит игра закончена
        Button btn1 =  (Button) findViewById(R.id.btn1);
        btn1.setText(Question.getQuestions().get(iD).getAnswer()[0]);
        Button btn2 =  (Button) findViewById(R.id.btn2);
        btn2.setText(Question.getQuestions().get(iD).getAnswer()[1]);
        Button btn3 =  (Button) findViewById(R.id.btn3);
        btn3.setText(Question.getQuestions().get(iD).getAnswer()[2]);
        Button btn4 =  (Button) findViewById(R.id.btn4);
        btn4.setText(Question.getQuestions().get(iD).getAnswer()[3]);
        TextView txt1=(TextView) findViewById(R.id.txt1);
        txt1.setText(Question.getQuestions().get(iD).getQuestionText());

}
public void onStartClick(View v) {
    Animation anim = AnimationUtils.loadAnimation(this, R.anim.buttonalpha);
    v.startAnimation(anim);
    Intent intent=new Intent(this,TrueActivity.class);
    //ArrayList<Integer>checks=new ArrayList<>();
    //checks.add(iD);
   // intent.putExtra("check",checks);
   // intent.putExtra("id",iD);
    Button button = (Button) v;
    String getAnswer = Question.getQuestions().get(iD).getAnswer()[Question.getQuestions().get(iD).getTrueAnswer()];
    if (button.getText().toString().equals(getAnswer)) {
        button.setBackgroundResource(R.drawable.trueanswer);
        startActivity(intent);
        overridePendingTransition(R.anim.animstart, R.anim.myanim);
        finish();
    } else {
        button.setBackgroundResource(R.drawable.falseanswer);
    }
}}
