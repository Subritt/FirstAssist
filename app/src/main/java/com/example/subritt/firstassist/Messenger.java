package com.example.subritt.firstassist;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ServerValue;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Messenger extends AppCompatActivity {

    //private TextView loggout;
    EditText inputMessage;
    private FirebaseAuth firebaseAuth;
//    private DatabaseReference mRootRef;
//    private String mCurrentUserId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messenger);

        Button send ;
        send = (Button)findViewById(R.id.send_btn);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(Messenger.this, "Under Construction", Toast.LENGTH_SHORT).show();

            }
        });

//       firebaseAuth = FirebaseAuth.getInstance();
//
//        Button logout;
//        logout = (Button)findViewById(R.id.logout_btn);
//        logout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                firebaseAuth.signOut();
//                finish();
//                startActivity(new Intent(Messenger.this, UserLogin.class));
//            }
//        });

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_messenger, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        firebaseAuth = FirebaseAuth.getInstance();
        switch (item.getItemId()){
            case R.id.action_logout:{

                firebaseAuth.signOut();
                finish();
                startActivity(new Intent(Messenger.this, UserLogin.class));

            }
        }
        return true;
    }


}
