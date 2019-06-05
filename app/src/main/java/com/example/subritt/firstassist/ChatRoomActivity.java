package com.example.subritt.firstassist;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirestoreRegistrar;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class ChatRoomActivity extends AppCompatActivity {

    private Button add_room;
    private EditText room_name;
    private ListView listView;
    private ArrayAdapter<String> arrayAdapter;
    private ArrayList<String> list_of_rooms = new ArrayList<>();
    private String name;
    private DatabaseReference root = FirebaseDatabase.getInstance().getReference().getRoot();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_room);

        add_room = (Button)findViewById(R.id.addRoom_btn);
        room_name = (EditText)findViewById(R.id.roomName_editText);
        listView = (ListView)findViewById(R.id.chatRoom_listview);

        arrayAdapter = new ArrayAdapter<String>(ChatRoomActivity.this,
                android.R.layout.simple_list_item_1, list_of_rooms);

        listView.setAdapter(arrayAdapter);

        request_user_name();

        add_room.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Map<String, Object> map = new HashMap<String, Object>();
                map.put(room_name.getText().toString(),"");
                root.updateChildren(map);

                room_name.getText().clear();
            }
        });

        root.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                Set<String> set = new HashSet<String>();
                Iterator iterator = dataSnapshot.getChildren().iterator();
                while ((iterator.hasNext())){
                    set.add(((DataSnapshot)iterator.next()).getKey());
                }
                list_of_rooms.clear();
                list_of_rooms.addAll(set);

                arrayAdapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ChatRoomActivity.this, ChatRoom.class);
                intent.putExtra("room_name", ((TextView)view).getText().toString());
                intent.putExtra("user_name", name);
                startActivity(intent);
            }
        });
    }


    public void request_user_name(){
        AlertDialog.Builder builder = new AlertDialog.Builder(ChatRoomActivity.this);
        builder.setTitle("Enter name:");

        final EditText input_field = new EditText(this);

        builder.setView(input_field);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                name = input_field.getText().toString();
            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
                request_user_name();
            }
        });

        builder.show();
        /*----------------------------------------*/

//        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
//        FirebaseUser firebaseUser = firebaseAuth.getInstance().getCurrentUser();
//        name = firebaseUser.toString();

//        UserLogin userName = new UserLogin();
//        name = userName.currentEmail;


//        FirebaseFirestore db = FirebaseFirestore.getInstance();
//
//        name = db.collection("userData").document("userInfo").toString();


//        DocumentReference documentReference = FirebaseFirestore.getInstance()
//                .collection("userData").document();
//
//        documentReference.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
//            @Override
//            public void onSuccess(DocumentSnapshot documentSnapshot) {
//                if (documentSnapshot.exists()){
//                    String email = documentSnapshot.getString("Email");
//                    if (email == currentEmail){
////                        String document = documentSnapshot.getDocumentReference("Email").toString();
//                        name = documentSnapshot.getString("UserName");
//                    }
//                }
//            }
//        });



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        final FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_messenger, menu);

        MenuItem backItem = menu.findItem(R.id.action_logout) ;

        backItem.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                if(item.getItemId() == R.id.action_logout){
                    firebaseAuth.signOut();
                    finish();
                    startActivity(new Intent(ChatRoomActivity.this, UserLogin.class));
                }

                return true;
            }
        });

        return true;
    }
}
