package com.example.rodneydsouza91.mainactivity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.*;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.VideoView;

import java.util.Locale;

import static android.provider.Settings.ACTION_LOCALE_SETTINGS;

public class MainActivity extends Activity {

    static MediaPlayer click;
    static MediaPlayer gameOnsound;
    private Button button1,button2,button3,button4;
    private ImageButton imageButton1,imageButton2,imageButton3,imageButton4,imageButton5;
    ProgressDialog pd;
    Locale myLocale;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        gameOnsound = MediaPlayer.create(MainActivity.this,R.raw.gameon);
        pd = new ProgressDialog(MainActivity.this);
        pd.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        pd.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        pd.getWindow().setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL);
        pd.show();
        setContentView(R.layout.activity_main);

        gameOnsound.start();

        button1 = (Button) findViewById(R.id.button1);   //panel
        button2 = (Button) findViewById(R.id.button2);  //Highscore
        button3 = (Button) findViewById(R.id.button3);  //Feedback
        button4 = (Button) findViewById(R.id.button4);  //Exit


        imageButton1=(ImageButton)findViewById(R.id.imageButton1);
        imageButton2=(ImageButton)findViewById(R.id.imageButton2);
        imageButton3=(ImageButton)findViewById(R.id.imageButton3);
        imageButton4=(ImageButton)findViewById(R.id.imageButton4);
        imageButton5=(ImageButton)findViewById(R.id.imageButton5);

        click = MediaPlayer.create(MainActivity.this, R.raw.fuzzyclick);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click.start();
                startActivity(new Intent(MainActivity.this, PanelActivity.class));
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click.start();
                startActivity(new Intent(MainActivity.this, HighScore.class));
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click.start();
                startActivity(new Intent(MainActivity.this, Feedback.class));
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title=getResources().getString(R.string.title);
                String yes=getResources().getString(R.string.Yes);
                String no=getResources().getString(R.string.No);
                AlertDialog.Builder a_builder = new AlertDialog.Builder(MainActivity.this);
                a_builder.setMessage(title)
                        .setCancelable(false)
                        .setPositiveButton(yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                //*****
                                gameOnsound.release();
                                click.release();
                                MainActivity.this.finish();
                            }
                        })
                        .setNegativeButton(no, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {

                                dialog.cancel();
                            }
                        });
                AlertDialog a = a_builder.create();
                a.show();
            }
        });

        imageButton1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                click.start();
                setLocale("hi");
                finish();
            }
        });
        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click.start();
                setLocale("values");
                finish();
            }
        });
        imageButton3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                click.start();
                setLocale("ar");
                finish();
            }
        });
        imageButton4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                click.start();
                setLocale("fr");
                finish();
            }
        });
        imageButton5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                click.start();
                setLocale("es");
                finish();
            }
        });
    }

    public void setLocale(String lang) {

        myLocale = new Locale(lang);
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.locale = myLocale;
        res.updateConfiguration(conf, dm);
        Intent refresh = new Intent(this, MainActivity.class);
        startActivity(refresh);
    }
}
