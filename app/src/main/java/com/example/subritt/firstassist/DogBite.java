package com.example.subritt.firstassist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

public class DogBite extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dog_bite);

        textView = (TextView) findViewById(R.id.dogBite_textview);

        String para = "- Clean the wound immediately with water.\n" +
                "\n" +
                "- Then wash with antiseptic soapand water.\n" +
                "\n" +
                "- Don't try to stop bleeding.\n" +
                "\n" +
                "- Don't cover the wound.\n" +
                "\n" +
                "- Send the patient to hospital for treatment.";

        textView.setText(para);
        textView.setMovementMethod(new ScrollingMovementMethod());
    }
}
