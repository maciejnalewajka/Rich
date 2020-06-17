package com.rich;

import android.graphics.drawable.AnimationDrawable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ConstraintLayout mylayout;
    AnimationDrawable anim;
    int val = 1;
    boolean val2 = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        anim();

    }

    public void click(View view) {
        View obraz = findViewById(R.id.obraz_id);

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


    public void on(View view) {
        TextView textView = findViewById(R.id.textView);
        if(!val2){
            textView.setSelected(true);
            textView.setText(R.string.rich2);
            val2 = true;
        }
        else{
            textView.setSelected(false);
            textView.setText(R.string.rich);
            val2 = false;
        }
    }

    public void anim(){
        mylayout = findViewById(R.id.pierwszy);
        anim = (AnimationDrawable) mylayout.getBackground();
        anim.setEnterFadeDuration(10);
        anim.setExitFadeDuration(3000);
        anim.start();
    }
}
