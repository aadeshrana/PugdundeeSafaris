package com.example.thearbiter.pugdundeesafaris;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.reflect.Type;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        final TextView splashscreenText = (TextView) findViewById(R.id.splashscreentitle);
        final TextView splashscreenText2 = (TextView) findViewById(R.id.splashscreentitle2);
        final ImageView imageView = (ImageView)findViewById(R.id.imageViewsplash);

        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/lobster.ttf");
        splashscreenText.setTypeface(typeface);
        splashscreenText2.setTypeface(typeface);
        final Animation animation = AnimationUtils.loadAnimation(this,R.anim.bottom_up);
        final Animation animation2 = AnimationUtils.loadAnimation(this,R.anim.fade_in);

      /*  splashscreenText.startAnimation(animation);
        splashscreenText2.startAnimation(animation);
        imageView.startAnimation(animation);*/

        Thread thread2 = new Thread(){
            @Override
            public void run() {
                super.run();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        splashscreenText.startAnimation(animation);
                        splashscreenText2.startAnimation(animation);
                        imageView.startAnimation(animation);

                       /* splashscreenText.startAnimation(animation2);
                        splashscreenText2.startAnimation(animation2);
                        imageView.startAnimation(animation2);*/

                    }
                });
            }
        };
thread2.start();
        Thread thread = new Thread() {
            @Override
            public void run() {
                super.run();
                try {
                    sleep(1500);
                    Intent intent = new Intent(SplashScreen.this, MainActivity.class);
                    startActivity(intent);
                    overridePendingTransition(R.anim.left_in,R.anim.left_out);
                    finish();


                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        thread.start();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_splash_screen, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity inf AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
