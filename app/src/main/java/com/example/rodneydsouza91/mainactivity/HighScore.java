package com.example.rodneydsouza91.mainactivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by rodneydsouza91 on 27-02-2017.
 */
public class HighScore extends AppCompatActivity {
    TextView textView,textView2,textView3,textView4;

    SharedPreferences sharedPreferences;// = getSharedPreferences("your_file_name", MODE_PRIVATE);
    //int highscore = prefs.getInt("PREFS", 0);    //1st para--file name, 2nd para

    private Button button;

    @Override
    protected void onCreate(Bundle bundle){
        super.onCreate(bundle);
        setContentView(R.layout.activity_high_score);

        textView=(TextView)findViewById(R.id.text1);
        textView2=(TextView)findViewById(R.id.text2);
        textView3=(TextView)findViewById(R.id.text3);
        textView4=(TextView)findViewById(R.id.text4);
        button=(Button)findViewById(R.id.button1h);

        sharedPreferences = getSharedPreferences("SHAR_PREF_NAME", 0);

        textView.setText("1."+sharedPreferences.getInt("score1",0));
        textView2.setText("2."+sharedPreferences.getInt("score2",0));
        textView3.setText("3."+sharedPreferences.getInt("score3",0));
        textView4.setText("4."+sharedPreferences.getInt("score4",0));

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sharedPreferences.edit().clear().apply();
                startActivity(new Intent(getApplicationContext(),HighScore.class));
                finish();
            }
        });
    }
}
