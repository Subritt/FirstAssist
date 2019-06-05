package com.example.subritt.firstassist;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.flags.impl.DataUtils;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.security.PrivateKey;

import static com.example.subritt.firstassist.R.menu.menu_userlogin;

public class UserLogin extends AppCompatActivity {

    private EditText Name;
    private EditText Password;
    private TextView Attempts;
    private Button Login;
    private int counter = 5;
    private FirebaseAuth firebaseAuth;
    private ProgressDialog progressDialog;
    private TextView forgotPassword;

    public String currentEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);

        Name = (EditText)findViewById(R.id.login_name);
        Password = (EditText)findViewById(R.id.login_password);
        Attempts = (TextView) findViewById(R.id.login_attempts);
        Login = (Button)findViewById(R.id.login_btn);
        forgotPassword = (TextView)findViewById(R.id.fordotPassword_textview);

        Attempts.setText("No of attempts remaining: 5");

        firebaseAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);

        /*----Check user session----*/
        FirebaseUser user = firebaseAuth.getCurrentUser();

        if(user != null){

            finish();
            startActivity(new Intent(UserLogin.this, ChatRoomActivity.class));
        }

        /*----Login Button----*/

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentEmail = Name.getText().toString();
                if(!Name.getText().toString().isEmpty() && !Password.getText().toString().isEmpty()) {
                    validate(Name.getText().toString(), Password.getText().toString());
                }
                else {
                    Name.getText().clear();
                    Password.getText().clear();
                    Toast.makeText(UserLogin.this, "Empty Fields!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        /*----Register Activity----*/

        TextView registerTxt = (TextView)findViewById(R.id.login_register) ;
        registerTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iReg = new Intent(UserLogin.this, Registration.class);

                startActivity(iReg);
            }
        });

        /*----Forgot Password----*/

        forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UserLogin.this, PasswordActivity.class));
            }
        });

    }

    private void validate(final String userName, String userPassword){

//        if((userName.equals("Admin")) && (userPassword.equals("1234567"))){
//
//            startActivity(new Intent(UserLogin.this, Messenger .class));
//
//        }else{
//
//            Toast.makeText(UserLogin.this, "Incorrect Username or Password !!", Toast.LENGTH_SHORT).show();
//
//            counter-- ;
//
//            Attempts.setText("No of Attempts remaining: " +String.valueOf(counter));
//
//            if(counter == 0){
//
//                Login.setEnabled(false);
//
//            }
//
//        }

        firebaseAuth.signInWithEmailAndPassword(userName, userPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {


                progressDialog.setMessage("Loading...Have Patience");
                progressDialog.show();

                if(task.isSuccessful()){
                    progressDialog.dismiss();
//                    Toast.makeText(UserLogin.this, "Login Success", Toast.LENGTH_SHORT).show();
//                    startActivity(new Intent(UserLogin.this, Messenger.class));
                    checkEmailVerification();
                }else{
                    Toast.makeText(UserLogin.this, "Incorrect Username or Password", Toast.LENGTH_SHORT).show();
                    counter--;
                    Attempts.setText("No if attempts remaining: " +String.valueOf(counter));
                    if(counter == 0){
                        Login.setEnabled(false);
                    }
                }

            }
        });


    }


    /*----Email Verification----*/

    private void checkEmailVerification(){
        FirebaseUser firebaseUser = firebaseAuth.getInstance().getCurrentUser();
        Boolean emailflag = firebaseUser.isEmailVerified();

        //startActivity(new Intent(UserLogin.this, Messenger.class));

        if(emailflag){
            finish();
//            Name.getText().clear();
//            Password.getText().clear();
            startActivity(new Intent(UserLogin.this, ChatRoomActivity.class));
        }else{
            Toast.makeText(this, "Verify your email", Toast.LENGTH_SHORT).show();
            firebaseAuth.signOut();
        }
    }


    /*----Toolbar----*/

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_userlogin, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if(id == R.id.action_home){
            startActivity(new Intent(UserLogin.this, MainActivity.class));
        }
        return true;
    }

    /*-------Getting email typed by user-------*/

    public EditText getName() {
        return Name;
    }
}
