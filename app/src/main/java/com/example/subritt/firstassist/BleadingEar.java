package com.example.subritt.firstassist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

public class BleadingEar extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bleading_ear);

        textView = (TextView) findViewById(R.id.bleadingEar_textview);

        String para = "-Lay the patient with the head slightly raised.\n" +
                "\n" +
                "-Incline the head to the affected side and apply a dry dressing over the ear with loose bandage.\n" +
                "\n" +
                "-Apply pressure in front of the ear. \n" +
                "\n" +
                "-Send for medical aid immediately.";

        textView.setText(para);
        textView.setMovementMethod(new ScrollingMovementMethod());
    }
}
