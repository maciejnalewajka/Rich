package com.nalewajka.rich;

import android.graphics.drawable.AnimationDrawable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ConstraintLayout mylayout;
    AnimationDrawable animationDrawable;
    TextView textView;
    View obraz;
    int val = 1;
    boolean move = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        obraz = findViewById(R.id.obraz_id);
        anim();
    }

    public void click(View view) {
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
        if(!move){
            textView.setSelected(true);
            textView.setText(R.string.rich2);
            move = true;
        }
        else{
            textView.setSelected(false);
            textView.setText(R.string.rich);
            move = false;
        }
    }

    private void anim(){
        mylayout = findViewById(R.id.pierwszy);
        animationDrawable = (AnimationDrawable) mylayout.getBackground();
        animationDrawable.setEnterFadeDuration(10);
        animationDrawable.setExitFadeDuration(3500);
        animationDrawable.start();
    }
}