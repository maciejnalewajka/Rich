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
    private int val = 0;
    private int val2 = 0;
    private String string;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        obraz = findViewById(R.id.obraz_id);
        ImageView imageView = findViewById(R.id.imageView);
        ImageView imageView2 = findViewById(R.id.imageView2);
        string = getResources().getString(R.string.rich);

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
            case 0:
                obraz.setBackgroundResource(R.drawable.round2);
                val = 1;
                break;
            case 1:
                obraz.setBackgroundResource(R.drawable.round3);
                val = 2;
                break;
            case 2:
                obraz.setBackgroundResource(R.drawable.round4);
                val = 3;
                break;
            case 3:
                obraz.setBackgroundResource(R.drawable.round);
                val = 0;
                break;
        }
    }

    private void move() {
        StringBuilder str = new StringBuilder(string.substring(0, 3));
        for (int i = 0;i < val2; i++){
            str.append(" very");
        }
        str.append(string.substring(3));
        textView.setText(str.toString());
        if (val2 == 3){ val2 = 0; }
        else {val2 += 1;}
    }

    private void anim(){
        ConstraintLayout mylayout = findViewById(R.id.pierwszy);
        AnimationDrawable animationDrawable = (AnimationDrawable) mylayout.getBackground();
        animationDrawable.setEnterFadeDuration(10);
        animationDrawable.setExitFadeDuration(3500);
        animationDrawable.start();
    }
}