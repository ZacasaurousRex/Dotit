package com.pullstartstudios.dotit;

/*
 * ==============================
 * Version: 1.0
 * Created: March 9, 2015
 * Description: User tries to get to the end of time while tapping all dots, but the bad dots.
 * Notes: Just want to make this push so you can pull
 * ==============================
 */

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.TypedValue;
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
    private int totalDots = 1;
    private ImageButton startDot, dot1, dot2, dot3;
    private Animation fadeOut, fadeIn;

    //  Creates Don't Touch
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dont_touch);
        //  Shows the next dot and the score
        score = (TextView) findViewById(R.id.score_counter);

        //  Initializes the start dot
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
                //  Makes the start dot disappear
                startDot.startAnimation(fadeOut);
                startDot.setVisibility(View.INVISIBLE);
                startDot.setClickable(false);

                score.setText("0");
                score.startAnimation(fadeIn);
                score.setVisibility(View.VISIBLE);
                createDot1();
            }// End on click
        });//   End on click listener
    }// End create start


    //  Creates the dots to play
    public void createDot1() {
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
        int randYLoc = randYGen.nextInt(height - yParam) + yParam;

        //  Determines which dot to create this time
        ++totalCounter;
        dot1 = (ImageButton) findViewById(R.id.dot1);
        dot1.setImageResource(id);

        //  Checks if the dot goes off the screen
        if (randXLoc + dot1.getWidth() >= width)
            dot1.setX(randXLoc - dot1.getWidth());
        else
            dot1.setX(randXLoc);

        //  Checks if the Y goes off the screen
        if (randYLoc + dot1.getHeight() >= height)
            dot1.setY(randYLoc - dot1.getHeight());
        else
            dot1.setY(randYLoc);

        //  Sets the size to a random size
        Random size = new Random();
        int diam = size.nextInt(30) + 50;
        dot1.getLayoutParams().height = diam;
        dot1.getLayoutParams().width = diam;

        //  Visually creates the dot
        dot1.startAnimation(fadeIn);
        dot1.setVisibility(View.VISIBLE);
        dot1.setClickable(true);

        //  Handle click
        dot1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dot1.startAnimation(fadeOut);
                dot1.setVisibility(View.INVISIBLE);
                dot1.setClickable(false);
                score.setText(String.valueOf(++touchCounter));
                createDot1();

                //  Used to determine adding another dot
                Random another = new Random();
                int createAnother = another.nextInt(5);
                if (totalDots < 2 && createAnother == 3){
                    createDot2();
                    ++totalDots;
                }// End if
            }
        });
    }

    public void createDot2() {
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
        int randYLoc = randYGen.nextInt(height - yParam) + yParam;

        ++totalCounter;
        dot2 = (ImageButton) findViewById(R.id.dot2);
        dot2.setImageResource(id);

        //  Checks if the dot goes off the screen
        if (randXLoc + dot2.getWidth() >= width)
            dot2.setX(randXLoc - dot2.getWidth());
        else
            dot2.setX(randXLoc);

        //  Checks if the Y goes off the screen
        if (randYLoc + dot2.getHeight() >= height)
            dot2.setY(randYLoc - dot2.getHeight());
        else
            dot2.setY(randYLoc);

        //  Sets the size to a random size
        Random size = new Random();
        int diam = size.nextInt(30) + 50;
        dot1.getLayoutParams().height = diam;
        dot1.getLayoutParams().width = diam;

        //  Visually creates the dot
        dot2.startAnimation(fadeIn);
        dot2.setVisibility(View.VISIBLE);
        dot2.setClickable(true);

        //  Handle click
        dot2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dot2.startAnimation(fadeOut);
                dot2.setVisibility(View.INVISIBLE);
                dot2.setClickable(false);
                score.setText(String.valueOf(++touchCounter));
                createDot2();

                Random another = new Random();
                int createAnother = another.nextInt(6);
                if(totalDots <3 && createAnother == 3) {
                    createDot3();
                    ++totalDots;
                }

            }
        });
    }
    public void createDot3() {
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
        int randYLoc = randYGen.nextInt(height - yParam) + yParam;


        ++totalCounter;
        dot3 = (ImageButton) findViewById(R.id.dot3);
        dot3.setImageResource(id);

        //  Checks if the dot goes off the screen
        if (randXLoc + dot3.getWidth() >= width)
            dot3.setX(randXLoc - dot3.getWidth());
        else
            dot3.setX(randXLoc);

        //  Checks if the Y goes off the screen
        if (randYLoc + dot3.getHeight() >= height)
            dot3.setY(randYLoc - dot3.getHeight());
        else
            dot3.setY(randYLoc);

        //  Creates a random size
        Random size = new Random();
        int diam = size.nextInt(30) + 50;
        dot1.getLayoutParams().height = diam;
        dot1.getLayoutParams().width = diam;

        //  Visually creates the dot
        dot3.startAnimation(fadeIn);
        dot3.setVisibility(View.VISIBLE);
        dot3.setClickable(true);

        //  Handle click
        dot3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dot3.startAnimation(fadeOut);
                dot3.setVisibility(View.INVISIBLE);
                dot3.setClickable(false);
                score.setText(String.valueOf(++touchCounter));
                createDot3();

            }
        });
    }
}// End Don't touch
