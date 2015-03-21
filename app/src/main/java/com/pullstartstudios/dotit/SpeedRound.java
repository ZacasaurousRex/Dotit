package com.pullstartstudios.dotit;

/*
 * ==============================
 * Version: 1.0
 * Created: March 9, 2015
 * Description: User tries to tap as many dots as they can before time runs out.
 *
 * ==============================
 */

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;


public class SpeedRound extends Activity {

    int counter = 0;
    TextView score;

    //  Creates the speed round
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speed_round);
        init();

    }// End on Create

    public void init(){
        score = (TextView) findViewById(R.id.score_counter);
        //  When the dot is clicked
        //score.setText(counter);
    }
}// End class
