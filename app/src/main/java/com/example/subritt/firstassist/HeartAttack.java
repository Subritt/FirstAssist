package com.example.subritt.firstassist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

public class HeartAttack extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heart_attack);

        textView = (TextView) findViewById(R.id.heartAttack1);

        String para = "- Make the patient lie down.\n" +
                "\n" +
                "- Remove extra clothings.\n" +
                "\n" +
                "- Keep the patient under the fan.\n" +
                "\n" +
                "- Pour cold water thoroughly with cold water and dry it with towel.\n" +
                "\n" +
                "- Record body temperature falls up to 38 degree celsius then stop pouring water.\n" +
                "\n" +
                "- Provide plenty of the cold water with a pinch of common salt in each of water to dink.\n" +
                "\n" +
                "- Send the patient to the hospital.";

        textView.setText(para);
        textView.setMovementMethod(new ScrollingMovementMethod());
    }
}
