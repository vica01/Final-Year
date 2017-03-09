package com.finalyearstudentvitus.splash;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.util.Log;

/**
 * Created by Emmanuel on 1/20/2017.
 */

public class Splash extends Activity {

    private static final String TAG = "SplashMessage";

    ImageView appIcon;
    TextView text1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        Log.i(TAG, "SplashOnCreate");

        tag1();
        tag2();
    }




    private void findview()
    {
        appIcon = (ImageView)findViewById(R.id.icongun);
        text1 = (TextView)findViewById(R.id.textView);
    }



    private void settinganimation()
    {
        //animation
        Animation anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fromleft);
        Animation anima = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fromright);

        //assigning the animation to the image view
        appIcon.setAnimation(anim);
        text1.setAnimation(anima);

        //define what happens when the application completes
        anim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                try
                {
                    Log.i(TAG, "now running tag3");
                    tag3();
                    Log.i(TAG, "tag3() just finished running");
                }
                catch (Exception e)
                {
                    Log.e(TAG, "error in running tag3");
                }

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }

            private void tag3()
            {
                Intent i = new Intent(Splash.this, Main2Activity.class);
                Splash.this.startActivity(i);
                finish();
            }
        });

    }

    private void tag1()
    {
        try
        {
            findview();
            Log.i(TAG, "findview() just finished running its course");
        }
        catch (Exception e)
        {
            Log.e(TAG, "error in running the function findview()");
        }
    }

    private void tag2()
    {
        try
        {
            settinganimation();
            Log.i(TAG, "settinganimation() just finished running its course");
        }
        catch (Exception e)
        {
            Log.e(TAG, "error in running the function settinganimation()");
        }
    }


}
