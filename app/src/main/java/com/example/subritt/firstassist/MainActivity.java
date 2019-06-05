package com.example.subritt.firstassist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.SearchView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private RecyclerView mRecyclerView;
    private ExampleAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private ArrayList<ExampleItem> exampleList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //buttonClick();
        addItem();
        buildRecyclerView();

    }

    public void addItem(){
        exampleList.add(new ExampleItem(R.drawable.bkt,
                "ARTIFICIAL RESPIRATION"));
        exampleList.add(new ExampleItem(R.drawable.ic_add,
                "BLEEDING EAR"));
        exampleList.add(new ExampleItem(R.drawable.ic_add,
                "SHOCK"));
        exampleList.add(new ExampleItem(R.drawable.ic_add,
                "HEART ATTACK"));
        exampleList.add(new ExampleItem(R.drawable.ic_add,
                "DOG BITE"));
        exampleList.add(new ExampleItem(R.drawable.ic_add,
                "UNCONSCIOUSNESS"));
        exampleList.add(new ExampleItem(R.drawable.ic_add,
                "FOREIGN BODY IN EAR"));
        exampleList.add(new ExampleItem(R.drawable.ic_add,
                "SNAKE BITE"));
        exampleList.add(new ExampleItem(R.drawable.ic_add,
                "CHOCKING"));
        exampleList.add(new ExampleItem(R.drawable.ic_add,
                "ELECTRIC SHOCK"));
    }



    public void buildRecyclerView(){
        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new ExampleAdapter(exampleList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(new ExampleAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                changeItem(position);
            }
        });
    }

    public void changeItem(int position){
        exampleList.get(position);

        if(position == 0){
            startActivity(new Intent(this, ArtificialRespiration.class));
        }
        if(position == 1){
            startActivity(new Intent(this, BleadingEar.class));
        }
        if(position == 2){
            startActivity(new Intent(this, Shock.class));
        }
        if(position == 3){
            startActivity(new Intent(this, HeartAttack.class));
        }
        if(position == 4){
            startActivity(new Intent(this, DogBite.class));
        }
        if(position == 5){
            startActivity(new Intent(this, Unconciousness.class));
        }
        if(position == 6){
            startActivity(new Intent(this, ForeignBodyInEar.class));
        }
        if(position == 7){
            startActivity(new Intent(this, SnakeBite.class));
        }
        if(position == 8){
            startActivity(new Intent(this, Chocking.class));
        }
        if(position == 9){
            startActivity(new Intent(this, ElectricShock.class));
        }

        mAdapter.notifyItemChanged(position);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.example_menu, menu);

        MenuItem searchItem = menu.findItem(R.id.action_search2);
        android.support.v7.widget.SearchView searchView =
                (android.support.v7.widget.SearchView) searchItem.getActionView();

        searchView.setImeOptions(EditorInfo.IME_ACTION_DONE);

        searchView.setOnQueryTextListener(new android.support.v7.widget.SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                mAdapter.getFilter().filter(newText);
                return false;
            }
        });
        return true;
    }

    //-------------------------------------


    public void buttonClick(){

        //        /*----Artificial Respiration----*/
//
//        Button btn1 = (Button) findViewById(R.id.artificialRespiration) ;
//        btn1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i1 = new Intent(MainActivity.this, ArtificialRespiration.class) ;
//                startActivity(i1);
//
//            }
//        });
//
//
//        /*----Bleading Ear----*/
//
//        Button btn2 = (Button) findViewById(R.id.bleadingEar_btn) ;
//        btn2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i2 = new Intent(MainActivity.this, BleadingEar.class) ;
//                startActivity(i2);
//
//            }
//        });
//
//
//        /*----Shock----*/
//
//        Button btn3 = (Button) findViewById(R.id.shock_btn) ;
//        btn3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i3 = new Intent(MainActivity.this, Shock.class) ;
//                startActivity(i3);
//
//            }
//        });
//
//
//        /*----Heart Attack----*/
//
//        Button btn4 = (Button) findViewById(R.id.heartAttack_btn) ;
//        btn4.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i4 = new Intent(MainActivity.this, HeartAttack.class) ;
//                startActivity(i4);
//
//            }
//        });
//
//        /*----Dog Bite----*/
//
//        Button btn5 = (Button) findViewById(R.id.dogBite_btn);
//        btn5.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i5 = new Intent(MainActivity.this, DogBite.class);
//                startActivity(i5);
//            }
//        });
//
//        /*----Unconciousness----*/
//
//        Button btn6 = (Button) findViewById(R.id.unconciousness_btn);
//        btn6.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i6 = new Intent(MainActivity.this, Unconciousness.class);
//                startActivity(i6);
//            }
//        });
//
//        /*----Foreign Body In Ear----*/
//
//        Button btn7 = (Button) findViewById(R.id.foreignBodyInEar_btn);
//        btn7.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i7 = new Intent(MainActivity.this, ForeignBodyInEar.class);
//                startActivity(i7);
//            }
//        });
//
//        /*----Snake Bite----*/
//
//        Button btn8 = (Button) findViewById(R.id.snakeBite_btn);
//        btn8.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i8 = new Intent(MainActivity.this, SnakeBite.class);
//                startActivity(i8);
//            }
//        });
//
//        /*----Chocking----*/
//
//        Button btn9 = (Button) findViewById(R.id.chocking_btn);
//        btn9.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i9 = new Intent(MainActivity.this, Chocking.class);
//                startActivity(i9);
//            }
//        });
//
//        /*----Electric Shock----*/
//
//        Button btn10 = (Button) findViewById(R.id.electricShock_btn);
//        btn10.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i10 = new Intent(MainActivity.this, ElectricShock.class);
//                startActivity(i10);
//            }
//        });

        /*----Login Activity----*/

//        Button loginBtn = (Button)findViewById(R.id.user_login) ;
//        loginBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent iL = new Intent(MainActivity.this, UserLogin.class) ;
//
//                startActivity(iL);
//            }
//        });

    }



    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_login) {
            // Handle the login action. login changed to chat

            Intent loginIntent = new Intent(MainActivity.this, UserLogin.class);
            startActivity(loginIntent);

        } else if (id == R.id.nav_notify) {

            startActivity(new Intent(MainActivity.this, NotificationActivity.class));

        } else if (id == R.id.nav_emergency_number) {

            Intent emergencyNumberIntent = new Intent(MainActivity.this, EmergencyNumber.class);
            startActivity(emergencyNumberIntent);

        } else if (id == R.id.nav_nearest_hospital) {

            Intent nearestHospitalIntent = new Intent(MainActivity.this, NearestHospital.class) ;
            startActivity(nearestHospitalIntent);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}
