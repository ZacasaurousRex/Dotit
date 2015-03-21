package com.pullstartstudios.dotit;

/*
 * ==============================
 * Version: 1.0
 * Created: March 9, 2015
 * Description: User tries to tap as many dots possible in the allotted time, while the dots go faster and faster.
 * Notes:
 * ==============================
 */

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;


public class FasterAndFaster extends Activity {

    TextView score;
    int counter = 0;

    //  Creates faster and faster
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faster_and_faster);

    }// End oncreate

    public void init(){
        score = (TextView) findViewById(R.id.score_counter);
        //  When the dot is clicked
        //score.setText(counter);
    }
}// End class
