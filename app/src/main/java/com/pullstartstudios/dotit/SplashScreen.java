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
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class  SplashScreen extends Activity {

    private static String TAG = SplashScreen.class.getName();
    private static long SLEEP_TIME = 3;//   Used for the amount of time to display splash screen
    private ImageView logoImage;
    private Animation aniFadeIn, t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //  Hides the notification bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_splash_screen);

        //  The Displayed context on the splash screen
        logoImage = (ImageView)findViewById(R.id.title);
        //company = (TextView)findViewById(R.id.CompanytInfo);

        //  Fade splash screen logo
        aniFadeIn = AnimationUtils.loadAnimation(this, R.anim.fade);
        logoImage.setVisibility(View.VISIBLE);//    Used to make the image visible during fade
        logoImage.startAnimation(aniFadeIn);

        //  Used to transition to the home screen
        IntentLauncher launcher = new IntentLauncher();
        launcher.start();
    }// End on create

    //  Used to switch between different screens
    private class IntentLauncher extends Thread {
        @Override
        public void run() {
            try {
                Thread.sleep(SLEEP_TIME*1000);//    Displays the splash screen for short time
            } catch (Exception e) {
                Log.e(TAG, e.getMessage());
            }

            //  Switches to the home screen activity
            Intent intent = new Intent(SplashScreen.this, HomeScreen.class);
            SplashScreen.this.startActivity(intent);
            SplashScreen.this.overridePendingTransition(R.anim.abc_fade_in, R.anim.abc_fade_out);
            SplashScreen.this.finish();
        }// End run
    }// End intent launcher
}// End class
