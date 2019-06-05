package com.example.subritt.firstassist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telecom.TelecomManager;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

public class ForeignBodyInEar extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foreign_body_in_ear);

        textView = (TextView) findViewById(R.id.foreignBodyInEar_textview);

        String para ="- Solid -Do not try to remove,scratch or probe it.\n" +
                "\n" +
                "- Insect - Put a few drop of water in the ear and turn the head so that affected ear points upwards.\n" +
                "\n" +
                "- keep the head in that position for 5 minutes, then turn the head downward so that the water flows out.\n" +
                "\n" +
                "- Arrange immediate medical aid.";

        textView.setText(para);
        textView.setMovementMethod(new ScrollingMovementMethod());
    }
}
