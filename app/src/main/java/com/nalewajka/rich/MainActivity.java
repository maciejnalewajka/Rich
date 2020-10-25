package com.nalewajka.rich;

import android.graphics.drawable.AnimationDrawable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private View obraz;
    private int val = 1;
    private boolean move = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        obraz = findViewById(R.id.obraz_id);
        ImageView imageView = findViewById(R.id.imageView);
        ImageView imageView2 = findViewById(R.id.imageView2);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                move();
            }
        });

        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rotate();
            }
        });
        anim();
        move();
    }

    private void rotate() {
        switch (val){
            case 1:
                obraz.setBackgroundResource(R.drawable.round2);
                val = 2;
                break;
            case 2:
                obraz.setBackgroundResource(R.drawable.round3);
                val = 3;
                break;
            case 3:
                obraz.setBackgroundResource(R.drawable.round4);
                val = 4;
                break;
            case 4:
                obraz.setBackgroundResource(R.drawable.round);
                val = 1;
                break;
        }
    }

    private void move() {
        if(!move){
            textView.setText(R.string.rich);
            move = true;
        }
        else{
            textView.setText(R.string.rich2);
            move = false;
        }
    }

    private void anim(){
        ConstraintLayout mylayout = findViewById(R.id.pierwszy);
        AnimationDrawable animationDrawable = (AnimationDrawable) mylayout.getBackground();
        animationDrawable.setEnterFadeDuration(10);
        animationDrawable.setExitFadeDuration(3500);
        animationDrawable.start();
    }
}