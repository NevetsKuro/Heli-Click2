package com.example.rodneydsouza91.mainactivity;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

/**
 * Created by rodneydsouza91 on 27-02-2017.
 */
public class Feedback extends AppCompatActivity{

    static MediaPlayer click;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.feedback);

        final Button button1=(Button)findViewById(R.id.button);
       // final MediaPlayer mp= MediaPlayer.create(Feedback.this, R.raw.click);
        click=MediaPlayer.create(Feedback.this,R.raw.fuzzyclick);

        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                click.start();
                submit();
            }
        });
    }

    public void submit(){

        EditText name=(EditText) findViewById(R.id.name);
        EditText email=(EditText) findViewById(R.id.email);
        EditText rollnclass=(EditText) findViewById(R.id.rollnclass);
        EditText feedback=(EditText) findViewById(R.id.feedback);
        RatingBar simpleRatingBar = (RatingBar) findViewById(R.id.ratingBar); // initiate a rating bar
        String rating = "Rating :: " + simpleRatingBar.getRating(); //create a string for rating
        Toast.makeText(getApplicationContext(), "Total Rated" + rating, Toast.LENGTH_LONG).show();

        if (name.getText().toString().equals("")) {
            name.setError("Error");
        }
        if (email.getText().toString().equals("")) {
            name.setError("Error");
        }
        if (rollnclass.getText().toString().equals("")) {
            name.setError("Error");
        }
        if (feedback.getText().toString().equals("")) {
            name.setError("Error");
        }
        else {
            Intent i = new Intent(Intent.ACTION_SEND);
            i.setData(Uri.parse("mail.to:"));
            i.setType("message/html");
            i.putExtra(Intent.EXTRA_EMAIL, new String[]{"stevenfernz96@gmail.com"});
            i.putExtra(Intent.EXTRA_SUBJECT, "Rollno and class is:"+rollnclass.getText().toString());
            i.putExtra(Intent.EXTRA_TEXT, "dear unknown, \n"
                            + feedback.getText().toString() + "\n Regards,"
                            + email.getText().toString()
            );

            try {

                startActivity(Intent.createChooser(i, "Message Send"));
                Toast.makeText(Feedback.this, "Mail send", Toast.LENGTH_LONG);
                Log.i("email send...", "");
                click.release();
                finish();
            }
            catch (android.content.ActivityNotFoundException ex) {
                Toast.makeText(getApplicationContext(), "no mail found", Toast.LENGTH_LONG).show();
            }
            catch(Exception e)
            {
                Toast.makeText(this,  "unexpected error!!!" + email.toString(), Toast.LENGTH_LONG).show();
            }

        }

    }

}
