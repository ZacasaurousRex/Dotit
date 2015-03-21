package com.pullstartstudios.dotit;

/*
 * ==============================
 * Version: 1.0
 * Created: March 9, 2015
 * Description: Home screen navigating to different games, settings and leader board.
 * Notes:
 * ==============================
 */

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.view.View;
import android.widget.ImageButton;


public class HomeScreen extends Activity {

    //  Buttons on the home screen
    ImageButton speedRound, dontTouch, fasterAndFaster;

    //  Creates the home page
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

    }// End on create

    //  Changes the screen when SpeedRound is clicked
    public void speedRoundOnclick(View v) {
        speedRound = (ImageButton) v;
        startActivity(new Intent(getApplicationContext(), SpeedRound.class));
        overridePendingTransition(R.anim.abc_fade_in, R.anim.abc_fade_out);

    }// End speed round

    //  Changes the screen when Don't Touch is clicked
    public void dontTouchOnclick(View v) {
        dontTouch = (ImageButton) v;
        startActivity(new Intent(getApplicationContext(), DontTouch.class));
        overridePendingTransition(R.anim.abc_fade_in, R.anim.abc_fade_out);

    }// End Don't Touch

    //  Changes the screen when SpeedRound is clicked
    public void fasterAndFasterhOnclick(View v) {
        fasterAndFaster = (ImageButton) v;
        startActivity(new Intent(getApplicationContext(), FasterAndFaster.class));
        overridePendingTransition(R.anim.abc_fade_in, R.anim.abc_fade_out);

    }// End faster and faster
}// End home screen
