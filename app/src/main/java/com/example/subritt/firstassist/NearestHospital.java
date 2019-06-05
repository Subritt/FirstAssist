package com.example.subritt.firstassist;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
//import android.location.LocationListener;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;

//public class NearestHospital extends FragmentActivity implements OnMapReadyCallback,
//        GoogleApiClient.ConnectionCallbacks,
//        GoogleApiClient.OnConnectionFailedListener,
//        LocationListener {
//
//    private GoogleMap mMap;
//    private GoogleApiClient client;
//    private LocationRequest locationRequest;
//    private Location lastLocation;
//    private Marker currentLocationMarker;
//    public static final int REQUEST_LOCATION_CODE = 99;
//    int PROXIMITY_RADIUS = 5000;
//    double latitude, longitude;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_nearest_hospital);
//
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//
//            checkLocationPermission();
//
//        }
//
//        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
//        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
//                .findFragmentById(R.id.map);
//        mapFragment.getMapAsync(this);
//    }
//
//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        //super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//
//        switch (requestCode) {
//
//            case REQUEST_LOCATION_CODE:
//                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                    //permission granted
//                    if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
//                        if (client == null) {
//                            buildGoogleApiClient();
//                        }
//                        mMap.setMyLocationEnabled(true);
//                    } else //permission denied
//                    {
//                        Toast.makeText(this, "Permission Denied!", Toast.LENGTH_LONG).show();
//                    }
//                    return;
//
//                }
//
//        }
//
//    }
//
//
//    /**
//     * Manipulates the map once available.
//     * This callback is triggered when the map is ready to be used.
//     * This is where we can add markers or lines, add listeners or move the camera. In this case,
//     * we just add a marker near Sydney, Australia.
//     * If Google Play services is not installed on the device, the user will be prompted to install
//     * it inside the SupportMapFragment. This method will only be triggered once the user has
//     * installed Google Play services and returned to the app.
//     */
//    @Override
//    public void onMapReady(GoogleMap googleMap) {
//        mMap = googleMap;
//
//        // Add a marker in Sydney and move the camera
////        LatLng sydney = new LatLng(-34, 151);
////        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
////        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
//
//        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
//
//            buildGoogleApiClient();
//            mMap.setMyLocationEnabled(true);
//        }
//
//    }
//
//    protected synchronized void buildGoogleApiClient() {
//        client = new GoogleApiClient.Builder(this).addConnectionCallbacks(this).addOnConnectionFailedListener(this).addApi(LocationServices.API).build();
//        client.connect();
//
//    }
//
//    @Override
//    public void onLocationChanged(Location location) {
//
//        latitude = location.getLatitude();
//        longitude = location.getLongitude();
//        lastLocation = location;
//
//        if (currentLocationMarker != null) {
//            currentLocationMarker.remove();
//        }
//
//        Log.d("lat = ",""+latitude);
//        LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());
//
//        MarkerOptions markerOptions = new MarkerOptions();
//        markerOptions.position(latLng);
//        markerOptions.title("Current Location");
//        markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE));
//
//        currentLocationMarker = mMap.addMarker(markerOptions);
//
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
//        mMap.animateCamera(CameraUpdateFactory.zoomBy(10));
//
//        if (client != null) {
//            LocationServices.FusedLocationApi.removeLocationUpdates(client, this);
//        }
//
//    }
//
//    public void onClick(View v) {
//
//        Object dataTransfer[] = new Object[2];
//        GetNearbyPlacesData getNearbyPlacesData = new GetNearbyPlacesData();
//
//
//        switch (v.getId()) {
//            case R.id.B_search:
//                EditText tf_location = (EditText) findViewById(R.id.Tf_location);
//                String location = tf_location.getText().toString();
//                List<Address> addressList = null;
//                MarkerOptions mo = new MarkerOptions();
//
//                if (!location.equals("")) {
//                    Geocoder geocoder = new Geocoder(this);
//                    try {
//                        addressList = geocoder.getFromLocationName(location, 10);
//
//                        if(addressList != null) {
//
//                            for (int i = 0; i < addressList.size(); i++) {
//                                Address myAddress = addressList.get(i);
//                                LatLng latLng = new LatLng(myAddress.getLatitude(), myAddress.getLongitude());
//                                mo.position(latLng);
//                                mo.title("Result");
//                                mo.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED));
//
//                                mMap.addMarker(mo);
//                                mMap.animateCamera(CameraUpdateFactory.newLatLng(latLng));
//                            }
//                        }
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                }
//                break;
//
//
//            case R.id.B_hospital:
//                mMap.clear();
//                String hospital = "hospital";
//                String url = getUrl(latitude, longitude, hospital);
//                dataTransfer[0] = mMap;
//                dataTransfer[1] = url;
//
//                getNearbyPlacesData.execute(dataTransfer);
//                Toast.makeText(NearestHospital.this, "Nearby Hospitals", Toast.LENGTH_LONG).show();
//
//                break;
//
//
//            case R.id.B_restaurant:
//                mMap.clear();
//                String restaurant = "restaurant";
//                url = getUrl(latitude, longitude, restaurant);
//                dataTransfer[0] = mMap;
//                dataTransfer[1] = url;
//
//                getNearbyPlacesData.execute(dataTransfer);
//                Toast.makeText(NearestHospital.this, "Nearby Restaurants", Toast.LENGTH_LONG).show();
//
//                break;
//
//
//            case R.id.B_school:
//                mMap.clear();
//                String school = "school";
//                url = getUrl(latitude, longitude, school);
//                dataTransfer[0] = mMap;
//                dataTransfer[1] = url;
//
//                getNearbyPlacesData.execute(dataTransfer);
//                Toast.makeText(NearestHospital.this, "Nearby Schools", Toast.LENGTH_LONG).show();
//
//                break;
//
//
//        }
//    }
//
//    private String getUrl(double latitude, double longitude, String nearbyPlace){
//
//        StringBuilder googlePlaceUrl = new StringBuilder("https://maps.googleapis.com/maps/api/place/findplacefromtext/jason?");
//        googlePlaceUrl.append("location="+latitude+","+longitude);
//        googlePlaceUrl.append("&radius="+PROXIMITY_RADIUS);
//        googlePlaceUrl.append("&type="+nearbyPlace);
//        googlePlaceUrl.append("&sensor=true");
//        googlePlaceUrl.append("&key="+"AIzaSyB8-TDiDGTI7lze1HZP7RKutYi8EANUOTw");
//
//        Log.d("MapsActivity", "url = "+googlePlaceUrl.toString());
//
//        return googlePlaceUrl.toString();
//
//    }
//
////    private String getUrl(double latitude, double longitude, String nearbyPlace) {
////        StringBuilder urlString = new StringBuilder("https://maps.googleapis.com/maps/api/findplacefromtext/search/json?");
////
////        if (nearbyPlace.equals("")) {
////            urlString.append("&location=");
////            urlString.append(Double.toString(latitude));
////            urlString.append(",");
////            urlString.append(Double.toString(longitude));
////            urlString.append("&radius=50000");  // <<-- change here
////            //   urlString.append("&types="+place);
////            urlString.append("&sensor=false&key=" + "AIzaSyB8-TDiDGTI7lze1HZP7RKutYi8EANUOTw");
////        } else {
////            urlString.append("&location=");
////            urlString.append(Double.toString(latitude));
////            urlString.append(",");
////            urlString.append(Double.toString(longitude));
////            urlString.append("&radius=50000");  // <<-- change here
////            urlString.append("&types="+nearbyPlace);
////            urlString.append("&sensor=false&key=" + "AIzaSyB8-TDiDGTI7lze1HZP7RKutYi8EANUOTw");
////        }
////        return urlString.toString();
////    }
////
////
////    protected synchronized void buildGoogleApiClient() {
////
////        client = new GoogleApiClient.Builder(this)
////                .addConnectionCallbacks(this)
////                .addOnConnectionFailedListener(this)
////                .addApi(LocationServices.API)
////                .build();
////
////        client.connect();
////
////    }
//
//
//    @Override
//    public void onConnected(@Nullable Bundle bundle) {
//
//        locationRequest = new LocationRequest();
//
//        locationRequest.setInterval(100);
//        locationRequest.setFastestInterval(1000);
//        locationRequest.setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY);
//
//        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
//            LocationServices.FusedLocationApi.requestLocationUpdates(client, locationRequest, this);
//        }
//
//    }
//
//    public boolean checkLocationPermission() {
//        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
//
//            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.ACCESS_FINE_LOCATION)) {
//
//                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_LOCATION_CODE);
//
//            } else {
//
//                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_LOCATION_CODE);
//
//            }
//
//            return false;
//
//        } else {
//            return true;
//        }
//
//    }
//
//    @Override
//    public void onConnectionSuspended(int i) {
//
//    }
//
//    @Override
//    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
//
//    }
//}


/*------------------------------------------*/

//public class NearestHospital extends FragmentActivity implements OnMapReadyCallback,
//        GoogleApiClient.ConnectionCallbacks,
//        GoogleApiClient.OnConnectionFailedListener,
//        LocationListener {

public class NearestHospital extends FragmentActivity implements OnMapReadyCallback,
        GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener,
        LocationListener{


    private GoogleMap mMap;
    private GoogleApiClient client;
    private LocationRequest locationRequest;
    private Location lastlocation;
    private Marker currentLocationmMarker;
    public static final int REQUEST_LOCATION_CODE = 99;
    int PROXIMITY_RADIUS = 5000;
    double latitude,longitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nearest_hospital);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
        {
            checkLocationPermission();

        }
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch(requestCode)
        {
            case REQUEST_LOCATION_CODE:
                if(grantResults.length >0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                {
                    if(ContextCompat.checkSelfPermission(this,Manifest.permission.ACCESS_FINE_LOCATION) !=  PackageManager.PERMISSION_GRANTED)
                    {
                        if(client == null)
                        {
                            bulidGoogleApiClient();
                        }
                        mMap.setMyLocationEnabled(true);
                    }
                }
                else
                {
                    Toast.makeText(this,"Permission Denied" , Toast.LENGTH_LONG).show();
                }
        }
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            bulidGoogleApiClient();
            mMap.setMyLocationEnabled(true);
        }
    }


    protected synchronized void bulidGoogleApiClient() {
        client = new GoogleApiClient.Builder(this).addConnectionCallbacks(this).addOnConnectionFailedListener(this).addApi(LocationServices.API).build();
        client.connect();

    }

    @Override
    public void onLocationChanged(Location location) {

        latitude = location.getLatitude();
        longitude = location.getLongitude();
        lastlocation = location;
        if(currentLocationmMarker != null)
        {
            currentLocationmMarker.remove();

        }
        Log.d("lat = ",""+latitude);
        LatLng latLng = new LatLng(location.getLatitude() , location.getLongitude());
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(latLng);
        markerOptions.title("Current Location");
        markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED));
        currentLocationmMarker = mMap.addMarker(markerOptions);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        mMap.animateCamera(CameraUpdateFactory.zoomBy(10));

        if(client != null)
        {
            LocationServices.FusedLocationApi.removeLocationUpdates(client,this);
        }
    }

    public void onClick(View v)
    {
        Object dataTransfer[] = new Object[2];
        GetNearbyPlacesData getNearbyPlacesData = new GetNearbyPlacesData();

        switch(v.getId())
        {
            case R.id.B_search:
                EditText tf_location =  findViewById(R.id.Tf_location);
                String location = tf_location.getText().toString();
                List<Address> addressList;


                if(!location.equals(""))
                {
                    Geocoder geocoder = new Geocoder(this);

                    try {
                        addressList = geocoder.getFromLocationName(location, 5);

                        if(addressList != null)
                        {
                            for(int i = 0;i<addressList.size();i++)
                            {
                                LatLng latLng = new LatLng(addressList.get(i).getLatitude() , addressList.get(i).getLongitude());
                                MarkerOptions markerOptions = new MarkerOptions();
                                markerOptions.position(latLng);
                                markerOptions.title(location);
                                mMap.addMarker(markerOptions);
                                mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
                                mMap.animateCamera(CameraUpdateFactory.zoomTo(10));
                            }
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                break;

            case R.id.B_hospital:
                mMap.clear();
                String hospital = "hospital";
                String url = getUrl(latitude, longitude, hospital);
                dataTransfer[0] = mMap;
                dataTransfer[1] = url;

                getNearbyPlacesData.execute(dataTransfer);
                Toast.makeText(NearestHospital.this, "Showing Nearby Hospitals", Toast.LENGTH_SHORT).show();
                break;

//            case R.id.B_school:
//                mMap.clear();
//                String school = "school";
//                url = getUrl(latitude, longitude, school);
//                dataTransfer[0] = mMap;
//                dataTransfer[1] = url;
//
//                getNearbyPlacesData.execute(dataTransfer);
//                Toast.makeText(NearestHospital.this, "Showing Nearby Schools", Toast.LENGTH_SHORT).show();
//                break;
//
//            case R.id.B_restaurant:
//                mMap.clear();
//                String restaurant = "restaurant";
//                url = getUrl(latitude, longitude, restaurant);
//                dataTransfer[0] = mMap;
//                dataTransfer[1] = url;
//
//                getNearbyPlacesData.execute(dataTransfer);
//                Toast.makeText(NearestHospital.this, "Showing Nearby Restaurants", Toast.LENGTH_SHORT).show();
//                break;
        }
    }


    private String getUrl(double latitude , double longitude , String nearbyPlace)
    {

        StringBuilder googlePlaceUrl = new StringBuilder("https://maps.googleapis.com/maps/api/place/nearbysearch/json?");
        googlePlaceUrl.append("location="+latitude+","+longitude);
        googlePlaceUrl.append("&radius="+PROXIMITY_RADIUS);
        googlePlaceUrl.append("&type="+nearbyPlace);
        googlePlaceUrl.append("&sensor=true");
        googlePlaceUrl.append("&key="+"AIzaSyBLEPBRfw7sMb73Mr88L91Jqh3tuE4mKsE");

        Log.d("MapsActivity", "url = "+googlePlaceUrl.toString());

        return googlePlaceUrl.toString();
    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {

        locationRequest = new LocationRequest();
        locationRequest.setInterval(100);
        locationRequest.setFastestInterval(1000);
        locationRequest.setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY);


        if(ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION ) == PackageManager.PERMISSION_GRANTED)
        {
            LocationServices.FusedLocationApi.requestLocationUpdates(client, locationRequest, this);
        }
    }


    public boolean checkLocationPermission()
    {
        if(ContextCompat.checkSelfPermission(this,Manifest.permission.ACCESS_FINE_LOCATION)  != PackageManager.PERMISSION_GRANTED )
        {

            if (ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.ACCESS_FINE_LOCATION))
            {
                ActivityCompat.requestPermissions(this,new String[] {Manifest.permission.ACCESS_FINE_LOCATION },REQUEST_LOCATION_CODE);
            }
            else
            {
                ActivityCompat.requestPermissions(this,new String[] {Manifest.permission.ACCESS_FINE_LOCATION },REQUEST_LOCATION_CODE);
            }
            return false;

        }
        else
            return true;
    }


    @Override
    public void onConnectionSuspended(int i) {
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
    }
}
