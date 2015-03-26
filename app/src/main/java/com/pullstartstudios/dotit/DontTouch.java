package com.pullstartstudios.dotit;

/*
 * ==============================
 * Version: 1.0
 * Created: March 9, 2015
 * Description: User tries to get to the end of time while tapping all dots, but the bad dots.
 * Notes:
 * ==============================
 */

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.TextView;


public class DontTouch extends Activity {

    TextView score;
    int counter = 0;
    ImageButton startDot;
    Animation fadeOut;

    //  Creates Don't Touch
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dont_touch);
        score = (TextView) findViewById(R.id.score_counter);
    }// End on create

    public void createStart() {
        startDot = (ImageButton) findViewById(R.id.start_dot);
        fadeOut = AnimationUtils.loadAnimation(this, R.anim.abc_fade_out);
        startDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startDot.startAnimation(fadeOut);
                startDot.setVisibility(View.INVISIBLE);
                startDot.setClickable(false);
            }
        });

    }// End create start
}
