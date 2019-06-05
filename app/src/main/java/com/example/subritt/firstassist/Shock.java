package com.example.subritt.firstassist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

public class Shock extends AppCompatActivity {

    TextView textview ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shock);

        textview = (TextView) findViewById(R.id.shock1) ;

        String para = "- Break the contact by switching off the power supply.\n" +
                "\n" +
                "- Make the air passage clear and clean.\n" +
                "\n" +
                "- Restore breathing Artifical respiration and external cardic message,if needed.\n" +
                "\n" +
                "- Call for immediate medical aid." ;

        textview.setText(para);
        textview.setMovementMethod(new ScrollingMovementMethod());

    }
}
