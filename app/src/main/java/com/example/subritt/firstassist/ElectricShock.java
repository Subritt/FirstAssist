package com.example.subritt.firstassist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

public class ElectricShock extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_electric_shock);

        textView = (TextView) findViewById(R.id.electricShock_textview);

        String para = "- Break the contact by switching off the power supply.\n" +
                "\n" +
                "- Make the air passage clear and clean.\n" +
                "\n" +
                "- Restore breathing by artificial respiration and external cardiac message,if needed.\n" +
                "\n" +
                "- Call for immediate medical aid.";

        textView.setText(para);
        textView.setMovementMethod(new ScrollingMovementMethod());
    }
}
