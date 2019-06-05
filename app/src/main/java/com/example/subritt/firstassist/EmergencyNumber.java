package com.example.subritt.firstassist;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class EmergencyNumber extends AppCompatActivity {

    private static final int REQUEST_CALL = 1;
    private EditText mEditTextNumber;
    private ImageView imageCall, imagecall2;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergency_number);

        textView = (TextView)findViewById(R.id.emergencyNumber_textView);
        imagecall2 = (ImageView)findViewById(R.id.callNepal_imageView);
        btnOnClick();
        //emergencyNumbers();

        mEditTextNumber = (EditText)findViewById(R.id.generalPhoneNumber_editText);
        imageCall = (ImageView)findViewById(R.id.generalCall_imageView);

        imageCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makePhoneCall();
            }
        });
    }

    public void makePhoneCall(){
        //String number = "102";
        String number = mEditTextNumber.getText().toString();
        if(number.trim().length() > 0){
            if(ContextCompat.checkSelfPermission(EmergencyNumber.this,
                    Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){

                ActivityCompat.requestPermissions(EmergencyNumber.this,
                        new String[] {Manifest.permission.CALL_PHONE}, REQUEST_CALL);
            }else{
                String dial = "tel:" + number;
                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
            }
        }else{
            Toast.makeText(EmergencyNumber.this, "Enter Phone Number", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode == REQUEST_CALL){
            if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                makePhoneCall();
            }else{
                Toast.makeText(EmergencyNumber.this, "Permission DENIED!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void emergencyNumbers(){

        String para = "102";

        textView.setText(para);
        textView.setMovementMethod(new ScrollingMovementMethod());

    }

    public void btnOnClick(){
        final String number = "102";
        imagecall2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ContextCompat.checkSelfPermission(EmergencyNumber.this,
                        Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){

                    ActivityCompat.requestPermissions(EmergencyNumber.this,
                            new String[] {Manifest.permission.CALL_PHONE}, REQUEST_CALL);
                }else{
                    String dial = "tel:" + number;
                    startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
                }
            }
        });
    }
}
