package com.example.occshottest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Locale;

public class maplocation extends AppCompatActivity implements LocationListener {

    Button button_location;
    TextView textLocation1;
    TextView textLocation2;
    TextView textLocation3;
    LocationManager locationManager;
    private DatabaseReference rootDatabaseref;
    private DatabaseReference rootDatabaseref2;
    private double latgeo_db;
    private double longgeo_db;
    double datalat;
    double datalong;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maplocation);

        textLocation1 = findViewById(R.id.textLocation1);
        textLocation2 = findViewById(R.id.textLocation2);
        textLocation3 = findViewById(R.id.textLocation3);
        button_location = findViewById(R.id.button_location);

        rootDatabaseref = FirebaseDatabase.getInstance().getReference("Lat");
        rootDatabaseref2 = FirebaseDatabase.getInstance().getReference("Long");

        // Runtime Permission for Location Access
        if (ContextCompat.checkSelfPermission(maplocation.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(maplocation.this, new String[]{
                    Manifest.permission.ACCESS_FINE_LOCATION}, 100);
        }


        button_location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rootDatabaseref.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                        datalong = Double.parseDouble(snapshot.getValue().toString());
                    }

                    @Override
                    public void onCancelled(@NonNull @NotNull DatabaseError error) {

                    }
                });
                rootDatabaseref2.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                        datalat = Double.parseDouble(snapshot.getValue().toString());
                    }

                    @Override
                    public void onCancelled(@NonNull @NotNull DatabaseError error) {

                    }
                });
                getLocation();
            }
        });
    }

    private void getLocation() {
        try {
            locationManager = (LocationManager) getApplicationContext().getSystemService(LOCATION_SERVICE);
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return;
            }
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5000, 0, maplocation.this);
        }catch (Exception e){
            //e.printStackTrace();
        }

        //Toast.makeText(this, ""+datalong+","+datalat, Toast.LENGTH_SHORT).show();
        Geocoder geocoder = new Geocoder(maplocation.this, Locale.getDefault());

        try{
            List<Address> addresses = geocoder.getFromLocation(datalong,datalat, 1);
            String address = addresses.get(0).getAddressLine(0);

            textLocation3.setText(address);

        }catch (Exception e){
            //e.printStackTrace();
            Toast.makeText(this, "Click Again", Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    public void onLocationChanged(@NonNull Location location) {

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(@NonNull String provider) {

    }

    @Override
    public void onProviderDisabled(@NonNull String provider) {

    }
}