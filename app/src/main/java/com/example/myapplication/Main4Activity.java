package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Toolbar;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class Main4Activity extends AppCompatActivity implements OnMapReadyCallback, GoogleMap.OnMapClickListener, GoogleMap.OnMapLongClickListener, GoogleMap.OnCameraIdleListener {
    Geocoder geocoder;
    MapView mapView;
    GoogleMap gmap;
    Button next;
    EditText tapTextView;
    private static final String MAP_VIEW_BUNDLE_KEY = "MapViewBundleKey";
    private Object MotionEvent;
    boolean hasLoacation = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
            next = findViewById(R.id.next);
         geocoder =  new Geocoder(this, Locale.getDefault());

        tapTextView = findViewById(R.id.et);
        Bundle mapViewBundle = null;
        if (savedInstanceState != null) {
            mapViewBundle = savedInstanceState.getBundle(MAP_VIEW_BUNDLE_KEY);
        }

        mapView = findViewById(R.id.mapView);
        mapView.onCreate(mapViewBundle);
        mapView.getMapAsync(this);



        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(hasLoacation)
                {
                    Intent intent = new Intent(Main4Activity.this,Main5Activity.class);
                    intent.putExtra("address", tapTextView.getText());
                    startActivity(intent);
                }
            }
        });

    }


    public void onMapClick(LatLng point) {
      //  tapTextView.setText("tapped, point=" + point);


    }


    public void onMapLongClick(LatLng point) {
      //  tapTextView.setText("long pressed, point=" + point);

        gmap.addMarker(new MarkerOptions().position(point).title("Marker in Sydney"));
        gmap.moveCamera(CameraUpdateFactory.newLatLng(point));
        try {
            List<Address> addresses = geocoder.getFromLocation(point.latitude, point.longitude, 1);

            String address = addresses.get(0).getAddressLine(0); // If any additional address line present than only, check with max available address lines by getMaxAddressLineIndex()
            String city = addresses.get(0).getLocality();
            tapTextView.setText(address+"  "+city);



        } catch (IOException e) {
            e.printStackTrace();
        }

        hasLoacation = true;
    }


    public void onCameraIdle() {
        //tapTextView.setText(gmap.getCameraPosition().toString());
    }






    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        Bundle mapViewBundle = outState.getBundle(MAP_VIEW_BUNDLE_KEY);
        if (mapViewBundle == null) {
            mapViewBundle = new Bundle();
            outState.putBundle(MAP_VIEW_BUNDLE_KEY, mapViewBundle);
        }

        mapView.onSaveInstanceState(mapViewBundle);
    }
    @Override
    protected void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    protected void onStart() {
        super.onStart();
        mapView.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mapView.onStop();
    }
    @Override
    protected void onPause() {
        mapView.onPause();
        super.onPause();
    }
    @Override
    protected void onDestroy() {
        mapView.onDestroy();
        super.onDestroy();
    }
    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }
    public void onMapReady(GoogleMap googleMap) {
        this.gmap = googleMap;

        this.gmap.setOnMapClickListener(this);
        this.gmap.setOnMapLongClickListener(this);
        this.gmap.setOnCameraIdleListener(this);

        gmap.setMinZoomPreference(12);
        LatLng tlv = new LatLng(	32.109333, 34.855499);
        gmap.moveCamera(CameraUpdateFactory.newLatLng(tlv));

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}


   

