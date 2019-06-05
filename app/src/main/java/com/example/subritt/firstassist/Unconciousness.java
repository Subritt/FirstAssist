package com.example.subritt.firstassist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

public class Unconciousness extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unconciousness);

        textView = (TextView) findViewById(R.id.unconciousness_textview);

        String para = "- Make the patient lie down on his belly with the head turned to one side.\n" +
                "\n" +
                "- Check breathing and pulse.\n" +
                "\n" +
                "- Loose tight cloths.\n" +
                "\n" +
                "- Clean the air-way.\n" +
                "\n" +
                "- Give artifical respiration and external cardiac massage, if needed.\n" +
                "\n" +
                "- Transport the patient to the hospital.";

        textView.setText(para);
        textView.setMovementMethod(new ScrollingMovementMethod());
    }
}
