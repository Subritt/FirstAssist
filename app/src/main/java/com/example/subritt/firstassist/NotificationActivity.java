package com.example.subritt.firstassist;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NotificationActivity extends AppCompatActivity {

    private Button sendNotificaitonBtn;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        editText = (EditText) findViewById(R.id.notificationMessage_editText);
        sendNotificaitonBtn = (Button)findViewById(R.id.sendNotification_btn);

        sendNotificaitonBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://console.firebase.google.com/project/first-assist/notification")));
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.back_menu, menu);

        MenuItem backItem = menu.findItem(R.id.action_back) ;

        backItem.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                if(item.getItemId() == R.id.action_back){
                    startActivity(new Intent(NotificationActivity.this, MainActivity.class));
                }

                return true;
            }
        });

        return true;
    }
}
