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
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Random;


public class DontTouch extends Activity {

    private TextView score;
    private int touchCounter = 0;
    private int totalCounter = 0;
    private int totalDots = 0;
    private ImageButton startDot, dot1, dot2, dot3;
    private Animation fadeOut, fadeIn;

    //  Creates Don't Touch
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dont_touch);


        //  Initializes the start dot
        createStart();

        //  Checks if the start dot has been clicked
        if(!startDot.isClickable()){
            //  createDot();
        }
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
                //  Makes the start dot disappear
                startDot.startAnimation(fadeOut);
                startDot.setVisibility(View.INVISIBLE);
                startDot.setClickable(false);

                //  Shows the next dot and the score
                score = (TextView) findViewById(R.id.score_counter);
                score.startAnimation(fadeIn);
                score.setVisibility(View.VISIBLE);
                createDot();
            }// End on click
        });//   End on click listener
    }// End create start


    //  Creates the dots to play
    public void createDot(){
        //  A dot has been created, update total
        ++totalDots;

        //  Used to randomly generate a color for the images to be
        Random randColGen = new Random();
        int randCol = randColGen.nextInt(6) + 1;
        String randID = "dot" + randCol;
        int id = getResources().getIdentifier(randID, "drawable", getPackageName());

        //  Gets the display size to determine where the location of the dots should be
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);

        int width = metrics.widthPixels;
        int height = metrics.heightPixels;

        //  Creates the random location for the dot to appear
        Random randXGen = new Random();
        int randXLoc = randXGen.nextInt(width);

        Random randYGen = new Random();
        int yParam = (int) (score.getHeight() + score.getY());
        int randYLoc = randYGen.nextInt(height - yParam);;

        //  Determines which dot to create this time
        switch(totalDots) {
            case 1:
                dot1 = (ImageButton) findViewById(R.id.dot1);
                dot1.setImageResource(id);

                //  Checks if the dot goes off the screen
                if(randXLoc + dot1.getWidth() >= width)
                    dot1.setX(randXLoc - dot1.getWidth());
                else
                    dot1.setX(randXLoc);

                //  Checks if the Y goes off the screen
                if(randYLoc + dot1.getHeight() >= height)
                    dot1.setY(randYLoc - dot1.getHeight());
                else
                    dot1.setY(randYLoc);

                dot1.startAnimation(fadeIn);
                dot1.setVisibility(View.VISIBLE);
                dot1.setClickable(true);

                //  Handle click
                dot1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });
                break;

            case 2:
                dot2 = (ImageButton) findViewById(R.id.dot2);
                dot2.setImageResource(id);

                //  Checks if the dot goes off the screen
                if(randXLoc + dot2.getWidth() >= width)
                    dot2.setX(randXLoc - dot2.getWidth());
                else
                    dot2.setX(randXLoc);

                //  Checks if the Y goes off the screen
                if(randYLoc + dot2.getHeight() >= height)
                    dot2.setY(randYLoc - dot2.getHeight());
                else
                    dot2.setY(randYLoc);

                dot2.startAnimation(fadeIn);
                dot2.setVisibility(View.VISIBLE);
                dot2.setClickable(true);
                break;

            case 3:
                dot3 = (ImageButton) findViewById(R.id.dot3);
                dot3.setImageResource(id);

                //  Checks if the dot goes off the screen
                if(randXLoc + dot3.getWidth() >= width)
                    dot3.setX(randXLoc - dot3.getWidth());
                else
                    dot3.setX(randXLoc);

                //  Checks if the Y goes off the screen
                if(randYLoc + dot3.getHeight() >= height)
                    dot3.setY(randYLoc - dot3.getHeight());
                else
                    dot3.setY(randYLoc);

                dot3.startAnimation(fadeIn);
                dot3.setVisibility(View.VISIBLE);
                dot3.setClickable(true);
                break;
        }// End switch
    }// End createDot
}// End Don't touch
