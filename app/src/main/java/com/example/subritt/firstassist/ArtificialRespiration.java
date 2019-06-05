package com.example.subritt.firstassist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.widget.TextView;

public class ArtificialRespiration extends AppCompatActivity {

    TextView textview ;

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        //return super.onCreateOptionsMenu(menu);
//
//        getMenuInflater().inflate(R.menu.menu_artificial_respiration, menu);
//
//        return true ;
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artificial_respiration);

        textview = (TextView)findViewById(R.id.artificialRespiration) ;

        String para = "-Keep the head slightly backward and open the jaw.\n" +
                "\n" +
                "-Seal the victim's nose to prevent escape of air by pinching with thumb and index finger.\n" +
                "\n" +
                "-Take deep breath , open your mouth widely, place it over the victim's mouth and make a tight seal.\n" +
                "\n" +
                "-Quickly blow the full breath into the mouth of victim.\n" +
                "\n" +
                "-Remove your mouth from the victim and allow him to exhale passively.\n" +
                "\n" +
                "-Repeat the procedure 12 to 15 times per minute till medical aid is arranged." ;
        textview.setText(para);

        textview.setMovementMethod(new ScrollingMovementMethod());
    }


}
