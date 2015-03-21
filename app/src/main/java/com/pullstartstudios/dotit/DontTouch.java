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
import android.widget.TextView;


public class DontTouch extends Activity {

    TextView score;
    int counter = 0;
    //  Creates Don't Touch
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dont_touch);

    }// End on create

    public void init(){
        score = (TextView) findViewById(R.id.score_counter);
        //  When the dot is clicked
        //score.setText(counter);
    }
}
