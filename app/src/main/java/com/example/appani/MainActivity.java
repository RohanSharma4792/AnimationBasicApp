package com.example.appani;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.graphics.Interpolator;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       Button button = findViewById(R.id.zoom);
        View Imageview = findViewById(R.id.logo);
        Button move = findViewById(R.id.movebtn);
        Button rotate  = findViewById(R.id.rotate);
        Button blink  = findViewById(R.id.blink);
        Button fade = findViewById(R.id.fadebtn);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animZoomIn = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.zoom_in);
                Imageview.startAnimation(animZoomIn);

            }
        });
        blink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation blink_animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.blinkimg);
                Imageview.startAnimation(blink_animation);
            }
        });
        fade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation fade_anim = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_img);
                Imageview.startAnimation(fade_anim);
            }
        });
        move.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ObjectAnimator animation = ObjectAnimator.ofFloat(Imageview,"translationX",100f);
                animation.start();
            }
        });
        rotate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation rt = new  RotateAnimation(0,90, Animation.RELATIVE_TO_SELF,0.5f);
                rt.setDuration(2000);
                rt.setInterpolator(new LinearInterpolator());
                Imageview.startAnimation(rt);

            }
        });



    }
}