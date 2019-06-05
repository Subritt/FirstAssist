package com.example.subritt.firstassist;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Registration extends AppCompatActivity {

    public static final String TAG = "UserData";
    private DocumentReference documentReference = FirebaseFirestore.getInstance().collection("userData").document();

    public static final String USER_NAME = "UserName";
    public static final String EMAIL = "Email";
    public static final String PASSWORD = "Password";
    public static final String PHONE_NUMBER = "PhoneNumber";

    private EditText userName, userEmail, userPassword, userPhoneNumber;
    private Button regBtn ;
    private TextView alreadyRegistered;
    private FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
    //private ImageView userProfilePicture;
    String email, name, phoneNumber, password;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        setUIViews();

        firebaseAuth = FirebaseAuth.getInstance() ;


//        alreadyRegistered.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent userLogin = new Intent(Registration.this, Login.class) ;
//                startActivity(userLogin);
//            }
//        });

        regBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validate()){
                    //Upload to the Database
                    String user_email = userEmail.getText().toString().trim() ;
                    String user_password = userPassword.getText().toString().trim() ;

                    firebaseAuth.createUserWithEmailAndPassword(user_email, user_password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if(task.isSuccessful()) {

//                                Toast.makeText(Registration.this, "Registration Successfull!!", Toast.LENGTH_SHORT).show();
//                                startActivity(new Intent(Registration.this, UserLogin.class));
                                sendEmailVerification();

                                /*----Testing without Email verification----*/
//                                sendUserData();
//                                firebaseAuth.signOut();
//                                Toast.makeText(Registration.this, "Successfully Registered, Upload Complete!", Toast.LENGTH_SHORT).show();
//                                finish();
//                                startActivity(new Intent(Registration.this, UserLogin.class));

                            }else {

                                Toast.makeText(Registration.this, "Registeration Failed!!", Toast.LENGTH_SHORT).show();

                            }
                        }
                    });

                }
            }
        });

        alreadyRegistered.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Registration.this, UserLogin.class));
            }
        });
    }

    private void setUIViews(){

        userName = (EditText)findViewById(R.id.register_name) ;
        userEmail = (EditText)findViewById(R.id.register_email) ;
        userPassword = (EditText)findViewById(R.id.register_password) ;
        regBtn = (Button)findViewById(R.id.register_button) ;
        alreadyRegistered = (TextView)findViewById(R.id.register_textview) ;
        userPhoneNumber = (EditText)findViewById(R.id.register_phoneNumber);
        //userProfilePicture = (ImageView)findViewById(R.id.register_imageView);

    }

    private Boolean validate(){

        Boolean result = false ;

        name = userName.getText().toString() ;
        email = userEmail.getText().toString() ;
        password = userPassword.getText().toString() ;
        phoneNumber = userPhoneNumber.getText().toString();

        if(name.isEmpty() || email.isEmpty() || password.isEmpty() || phoneNumber.isEmpty()){
            Toast.makeText(this, "Please enter all details", Toast.LENGTH_SHORT).show() ;

        }else{
            result = true ;
        }

        return result ;

    }

    private void sendEmailVerification(){
        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
        if(firebaseUser!=null){
            firebaseUser.sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if(task.isSuccessful()){

                        sendUserData();

                        Toast.makeText(Registration.this, "Successfully Registered, Verification mail sent!", Toast.LENGTH_SHORT).show();
                        firebaseAuth.signOut();
                        finish();
                        startActivity(new Intent(Registration.this, UserLogin.class));
                    }else{
                        Toast.makeText(Registration.this, "Verification mail hasn't been sent!", Toast.LENGTH_SHORT).show(); //when firebase is down
                    }
                }
            });
        }
    }

    private void sendUserData(){
//        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
//        DatabaseReference myRef = firebaseDatabase.getReference(firebaseAuth.getUid());
//        UserProfile userProfile = new UserProfile(phoneNumber, email, name);
//        myRef.setValue(userProfile);

//        EditText sendName = (EditText) findViewById(R.id.register_name);
//        EditText sendEmail = (EditText) findViewById(R.id.register_email);
//        EditText sendPassword = (EditText) findViewById(R.id.register_password);
//        EditText sendPhone = (EditText) findViewById(R.id.register_phoneNumber);

        //FirebaseFirestore db = FirebaseFirestore.getInstance();


        if(userName.getText().toString().isEmpty() || userEmail.getText().toString().isEmpty()
                || userPassword.getText().toString().isEmpty() || userPhoneNumber.getText().toString().isEmpty()){
            return;
        }
        Map<String, Object> saveUserInfo = new HashMap<String, Object>();
        saveUserInfo.put(USER_NAME, userName.getText().toString());
        saveUserInfo.put(EMAIL, userEmail.getText().toString());
        saveUserInfo.put(PASSWORD, userPassword.getText().toString());
        saveUserInfo.put(PHONE_NUMBER, userPhoneNumber.getText().toString());

//        db.collection("userInfo")
//                .add(saveUserInfo)
//                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
//                    @Override
//                    public void onSuccess(DocumentReference documentReference) {
//                        Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId());
//                    }
//                })
//                .addOnFailureListener(new OnFailureListener() {
//                    @Override
//                    public void onFailure(@NonNull Exception e) {
//                        Log.w(TAG, "Error adding document", e);
//                    }
//                });


        documentReference.set(saveUserInfo).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Log.d(TAG, "Document has been saved");
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.w(TAG, "Document was not saved!", e);
            }
        });

    }

}
