package com.pullstartstudios.dotit;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;


public class HomeScreen extends Activity {

    //  THIS IS A TEST CAN YOU SEE THIS--------------------------------------
    //  I can see it, hope you can see this ---------------------------------
    //  Buttons on the home screen
    ImageButton speedRound, dontTouch, fasterAndFaster;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

    }

    public void speedRoundOnclick(View v) {
        speedRound = (ImageButton) v;
        startActivity(new Intent(getApplicationContext(), SpeedRound.class));
    }

}
