package com.adidroid.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.Random;
import java.util.Vector;

public class drawActivity extends AppCompatActivity {
    // randomize the animation
    animationView animatedGraphicsView;
    animationView animatedGraphicsView2;
    animationView animatedGraphicsView3;
    animationView animatedGraphicsView4;
    animationView animatedGraphicsView5;
    animationView animatedGraphicsView6;
    animationView animatedGraphicsView7;
    animationView animatedGraphicsView8;
    animationView animatedGraphicsView9;
    animationView animatedGraphicsView10;
    Vector<animationView> allAnimation;
    int count=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw);
        allAnimation= new Vector<>();
        animatedGraphicsView = (animationView) findViewById(R.id.animationView);
        allAnimation.add(animatedGraphicsView);
        animatedGraphicsView2 = (animationView) findViewById(R.id.animationView2);
        allAnimation.add(animatedGraphicsView2);
        animatedGraphicsView3 = (animationView) findViewById(R.id.animationView3);
        allAnimation.add(animatedGraphicsView3);
        animatedGraphicsView4 = (animationView) findViewById(R.id.animationView4);
        allAnimation.add(animatedGraphicsView4);
        animatedGraphicsView5 = (animationView) findViewById(R.id.animationView5);
        allAnimation.add(animatedGraphicsView5);
        animatedGraphicsView6 = (animationView) findViewById(R.id.animationView6);
        allAnimation.add(animatedGraphicsView6);
        animatedGraphicsView7 = (animationView) findViewById(R.id.animationView7);
        allAnimation.add(animatedGraphicsView7);
        animatedGraphicsView8 = (animationView) findViewById(R.id.animationView7);
        allAnimation.add(animatedGraphicsView8);
        animatedGraphicsView9 = (animationView) findViewById(R.id.animationView9);
        allAnimation.add(animatedGraphicsView9);
        animatedGraphicsView10 = (animationView) findViewById(R.id.animationView10);
        allAnimation.add(animatedGraphicsView10);

    }

    public void click_button(View v){
        Log.d("myapp","click_button- count : "+count);
        Random random = new Random();
        if(count > 10){
            Log.d("myapp","function: click_button - count < 0 ");
            count=0;
            int i1 = 2 + random.nextInt(10);
            allAnimation.get(count).setAnimationParams(i1 * 1000);
            count++;
        }
        if(count < 0 ){
            Log.d("myapp","function: click_button - count < 0 ");
            count=0;
        }else{
            int i1 = 2 + random.nextInt(10);
            allAnimation.get(count).setAnimationParams(i1 * 1000);
            count++;
        }

    }
}
