package com.example.subritt.firstassist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

public class Chocking extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chocking);

        textView = (TextView) findViewById(R.id.chocking_textview);

        String para = "- Ask a person to speak or cough.\n" +
                "\n" +
                "- Deliver 5 back blows(It involve hitting a victim with palm on the back ).\n" +
                "\n" +
                "- Perform abdominal thrusts\n" +
                "(Stand or kneel behind the person and wrap your arms around his or her waist. " +
                "Locate the navel with one or two fingers of one hand. " +
                "Make a fist with the other hand and place the thumb side against the middle of the person's abdomen, just above the navel and well below the lower tip of breastbone).\n" +
                "\n" +
                "- Repeat sequence of the back blows and abdominal thrusts.";

        textView.setText(para);
        textView.setMovementMethod(new ScrollingMovementMethod());
    }
}
