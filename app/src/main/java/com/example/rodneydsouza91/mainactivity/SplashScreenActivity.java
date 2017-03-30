package com.example.rodneydsouza91.mainactivity;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Toast;
import android.widget.VideoView;

/**
 * Created by rodneydsouza91 on 25-03-2017.
 */
public class SplashScreenActivity extends Activity {
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            try {
                VideoView videoHolder = new VideoView(this);
                setContentView(videoHolder);
                Uri video = Uri.parse("android.resource://com.example.rodneydsouza91.mainactivity/" + R.raw.splash7);
                videoHolder.setLayoutParams(new FrameLayout.LayoutParams(800,1180));
                videoHolder.setVideoURI(video);
                videoHolder.requestFocus();

                videoHolder.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    public void onCompletion(MediaPlayer mp) {
                        jump();
                    }
                });
                videoHolder.start();
            } catch (Exception ex) {
                jump();
            }
        }

        @Override
        public boolean onTouchEvent(MotionEvent event) {
            Toast.makeText(getApplicationContext(),"i know your excited stop clicking!!",Toast.LENGTH_LONG).show();
            return true;
        }

        private void jump() {
            if (isFinishing())
                return;
            startActivity(new Intent(this, MainActivity.class));
            finish();
        }
}
