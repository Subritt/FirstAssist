//package com.example.subritt.firstassist;
//
//import android.os.AsyncTask;
//import android.util.Log;
//
//import com.google.android.gms.maps.CameraUpdateFactory;
//import com.google.android.gms.maps.GoogleMap;
//import com.google.android.gms.maps.model.BitmapDescriptorFactory;
//import com.google.android.gms.maps.model.LatLng;
//import com.google.android.gms.maps.model.MarkerOptions;
//
//import java.io.IOException;
//import java.util.HashMap;
//import java.util.List;
//
//public class GetNearbyPlacesData2 extends AsyncTask<Object, String, String> {
//
//    String googlePlacesData;
//    GoogleMap mMap;
//    String url;
//
//    @Override
//    protected String doInBackground(Object... objects) {
//
//        mMap = (GoogleMap)objects[0];
//        url = (String)objects[1];
//        DownloadUrl2 downloadUrl = new DownloadUrl2();
//        try {
//            googlePlacesData = downloadUrl.readUrl(url);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return googlePlacesData;
//    }
//
//    @Override
//    protected void onPostExecute(String s) {
//        //super.onPostExecute(s);
//
//        List<HashMap<String, String>> nearbyPlaceList = null;
//        DataParser2 Parser = new DataParser2();
//
//        nearbyPlaceList = Parser.parse(s);
//        Log.d("nearbyplacesdata","called parse method");
//        showNearbyPlaces(nearbyPlaceList);
//    }
//
//    private void showNearbyPlaces(List<HashMap<String, String>> nearbyPlaceList){
//
//        for( int i = 0 ; i < nearbyPlaceList.size() ; i++){
//
//            MarkerOptions markerOptions = new MarkerOptions();
//            HashMap<String, String> googlePlace = nearbyPlaceList.get(i);
//
//            String placeName = googlePlace.get("place_name");
//            String vicinity = googlePlace.get("vicinity");
//            double lat = Double.parseDouble(googlePlace.get("lat"));
//            double lng = Double.parseDouble(googlePlace.get("lng"));
//
//            LatLng latLng = new LatLng(lat, lng);
//            markerOptions.position(latLng);
//            markerOptions.title(placeName+" : "+vicinity);
//            markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED));
//
//            mMap.addMarker(markerOptions);
//            mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
//            mMap.animateCamera(CameraUpdateFactory.zoomTo(10));
//
//        }
//
//    }
//}
