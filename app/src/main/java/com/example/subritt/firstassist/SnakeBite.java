package com.example.subritt.firstassist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

public class SnakeBite extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snake_bite);

        textView = (TextView) findViewById(R.id.snakeBite_textview);

        String para = "\n" +
                "- Reassure the patient.\n" +
                "\n" +
                "- Don't allow the person to walk or run.\n" +
                "\n" +
                "- Don't suck the blood from the wound of the victim.\n" +
                "\n" +
                "- Apply a ligature(a cloth to be tighted above the snake bite) if it is in leg or hand.\n" +
                "\n" +
                "- Wash the wound with soap.\n" +
                "\n" +
                "- Allow free bleeding.";

        textView.setText(para);
        textView.setMovementMethod(new ScrollingMovementMethod());
    }
}
