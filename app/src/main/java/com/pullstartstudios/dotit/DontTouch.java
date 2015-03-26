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
    Animation fadeOut, fadeIn;

    //  Creates Don't Touch
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dont_touch);
        score = (TextView) findViewById(R.id.score_counter);
        createStart();
    }// End on create

    public void createStart() {
        //  initializes the start dot
        startDot = (ImageButton) findViewById(R.id.start_dot);

        //  Creates the fade out animation
        fadeOut = AnimationUtils.loadAnimation(this, R.anim.abc_fade_out);
        fadeOut.setDuration(150);
        fadeIn = AnimationUtils.loadAnimation(this, R.anim.abc_fade_in);
        fadeIn.setDuration(150);

        startDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startDot.startAnimation(fadeOut);
                startDot.setVisibility(View.INVISIBLE);
                startDot.setClickable(false);
                score.startAnimation(fadeIn);
                score.setVisibility(View.VISIBLE);
                //  createDot();
            }// End on click
        });//   End on click listener
    }// End create start
}
