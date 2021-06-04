package com.example.occshottest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class packages_grid extends AppCompatActivity {

    // ImageView List
    ImageView pkg1img, pkg2img, pkg3img, pkg4img, pkg5img, pkg6img;

    // TextView List
    TextView pkg1name, pkg2name, pkg3name, pkg4name, pkg5name, pkg6name;
    TextView pkg1price, pkg2price, pkg3price, pkg4price, pkg5price, pkg6price;

    // Firebase Database Starts
    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = firebaseDatabase.getReference();

    // Image Retrieve
    private DatabaseReference pkg1img_db = databaseReference.child("pkg1img");
    private DatabaseReference pkg2img_db = databaseReference.child("pkg2img");
    private DatabaseReference pkg3img_db = databaseReference.child("pkg3img");
    private DatabaseReference pkg4img_db = databaseReference.child("pkg4img");
    private DatabaseReference pkg5img_db = databaseReference.child("pkg5img");
    private DatabaseReference pkg6img_db = databaseReference.child("pkg6img");

    // Name Retrieve
    private DatabaseReference pkg1name_db = databaseReference.child("pkg1name");
    private DatabaseReference pkg2name_db = databaseReference.child("pkg2name");
    private DatabaseReference pkg3name_db = databaseReference.child("pkg3name");
    private DatabaseReference pkg4name_db = databaseReference.child("pkg4name");
    private DatabaseReference pkg5name_db = databaseReference.child("pkg5name");
    private DatabaseReference pkg6name_db = databaseReference.child("pkg6name");

    // Price Retrieve
    private DatabaseReference pkg1price_db = databaseReference.child("pkg1price");
    private DatabaseReference pkg2price_db = databaseReference.child("pkg2price");
    private DatabaseReference pkg3price_db = databaseReference.child("pkg3price");
    private DatabaseReference pkg4price_db = databaseReference.child("pkg4price");
    private DatabaseReference pkg5price_db = databaseReference.child("pkg5price");
    private DatabaseReference pkg6price_db = databaseReference.child("pkg6price");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_packages_grid);

        // IMAGE ID
        pkg1img = findViewById(R.id.pkg1img);
        pkg2img = findViewById(R.id.pkg2img);
        pkg3img = findViewById(R.id.pkg3img);
        pkg4img = findViewById(R.id.pkg4img);
        pkg5img = findViewById(R.id.pkg5img);
        pkg6img = findViewById(R.id.pkg6img);

        // NAME ID
        pkg1name = findViewById(R.id.pkg1name);
        pkg2name = findViewById(R.id.pkg2name);
        pkg3name = findViewById(R.id.pkg3name);
        pkg4name = findViewById(R.id.pkg4name);
        pkg5name = findViewById(R.id.pkg5name);
        pkg6name = findViewById(R.id.pkg6name);

        // PRICE ID
        pkg1price = findViewById(R.id.pkg1price);
        pkg2price = findViewById(R.id.pkg2price);
        pkg3price = findViewById(R.id.pkg3price);
        pkg4price = findViewById(R.id.pkg4price);
        pkg5price = findViewById(R.id.pkg5price);
        pkg6price = findViewById(R.id.pkg6price);

        if(!isConnected(this)){
            showCustomDialogue();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();

        // pkg1img
        pkg1img_db.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @org.jetbrains.annotations.NotNull DataSnapshot snapshot) {
                String link = snapshot.getValue(String.class);
                Picasso.get().load(link).into(pkg1img);
            }

            @Override
            public void onCancelled(@NonNull @org.jetbrains.annotations.NotNull DatabaseError error) {
                // goes empty
            }
        });
        // pkg2img
        pkg2img_db.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @org.jetbrains.annotations.NotNull DataSnapshot snapshot) {
                String link = snapshot.getValue(String.class);
                Picasso.get().load(link).into(pkg2img);
            }

            @Override
            public void onCancelled(@NonNull @org.jetbrains.annotations.NotNull DatabaseError error) {
                // goes empty
            }
        });
        // pkg3img
        pkg3img_db.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @org.jetbrains.annotations.NotNull DataSnapshot snapshot) {
                String link = snapshot.getValue(String.class);
                Picasso.get().load(link).into(pkg3img);
            }

            @Override
            public void onCancelled(@NonNull @org.jetbrains.annotations.NotNull DatabaseError error) {
                // goes empty
            }
        });
        // pkg4img
        pkg4img_db.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @org.jetbrains.annotations.NotNull DataSnapshot snapshot) {
                String link = snapshot.getValue(String.class);
                Picasso.get().load(link).into(pkg4img);
            }

            @Override
            public void onCancelled(@NonNull @org.jetbrains.annotations.NotNull DatabaseError error) {
                // goes empty
            }
        });
        // pkg5img
        pkg5img_db.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @org.jetbrains.annotations.NotNull DataSnapshot snapshot) {
                String link = snapshot.getValue(String.class);
                Picasso.get().load(link).into(pkg5img);
            }

            @Override
            public void onCancelled(@NonNull @org.jetbrains.annotations.NotNull DatabaseError error) {
                // goes empty
            }
        });
        // pkg6img
        pkg6img_db.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @org.jetbrains.annotations.NotNull DataSnapshot snapshot) {
                String link = snapshot.getValue(String.class);
                Picasso.get().load(link).into(pkg6img);
            }

            @Override
            public void onCancelled(@NonNull @org.jetbrains.annotations.NotNull DatabaseError error) {
                // goes empty
            }
        });

        // pkg1name
        pkg1name_db.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @org.jetbrains.annotations.NotNull DataSnapshot snapshot) {
                String name = snapshot.getValue().toString();
                pkg1name.setText(name);
            }

            @Override
            public void onCancelled(@NonNull @org.jetbrains.annotations.NotNull DatabaseError error) {
                // goes empty
            }
        });
        // pkg2name
        pkg2name_db.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @org.jetbrains.annotations.NotNull DataSnapshot snapshot) {
                String name = snapshot.getValue().toString();
                pkg2name.setText(name);
            }

            @Override
            public void onCancelled(@NonNull @org.jetbrains.annotations.NotNull DatabaseError error) {
                // goes empty
            }
        });
        // pkg3name
        pkg3name_db.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @org.jetbrains.annotations.NotNull DataSnapshot snapshot) {
                String name = snapshot.getValue().toString();
                pkg3name.setText(name);
            }

            @Override
            public void onCancelled(@NonNull @org.jetbrains.annotations.NotNull DatabaseError error) {
                // goes empty
            }
        });
        // pkg4name
        pkg4name_db.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @org.jetbrains.annotations.NotNull DataSnapshot snapshot) {
                String name = snapshot.getValue().toString();
                pkg4name.setText(name);
            }

            @Override
            public void onCancelled(@NonNull @org.jetbrains.annotations.NotNull DatabaseError error) {
                // goes empty
            }
        });
        // pkg5name
        pkg5name_db.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @org.jetbrains.annotations.NotNull DataSnapshot snapshot) {
                String name = snapshot.getValue().toString();
                pkg5name.setText(name);
            }

            @Override
            public void onCancelled(@NonNull @org.jetbrains.annotations.NotNull DatabaseError error) {
                // goes empty
            }
        });
        // pkg6name
        pkg6name_db.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @org.jetbrains.annotations.NotNull DataSnapshot snapshot) {
                String name = snapshot.getValue().toString();
                pkg6name.setText(name);
            }

            @Override
            public void onCancelled(@NonNull @org.jetbrains.annotations.NotNull DatabaseError error) {
                // goes empty
            }
        });

        // pkg1price
        pkg1price_db.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @org.jetbrains.annotations.NotNull DataSnapshot snapshot) {
                String name = snapshot.getValue().toString();
                pkg1price.setText(name);
            }

            @Override
            public void onCancelled(@NonNull @org.jetbrains.annotations.NotNull DatabaseError error) {
                // goes empty
            }
        });
        // pkg2price
        pkg2price_db.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @org.jetbrains.annotations.NotNull DataSnapshot snapshot) {
                String name = snapshot.getValue().toString();
                pkg2price.setText(name);
            }

            @Override
            public void onCancelled(@NonNull @org.jetbrains.annotations.NotNull DatabaseError error) {
                // goes empty
            }
        });
        // pkg3price
        pkg3price_db.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @org.jetbrains.annotations.NotNull DataSnapshot snapshot) {
                String name = snapshot.getValue().toString();
                pkg3price.setText(name);
            }

            @Override
            public void onCancelled(@NonNull @org.jetbrains.annotations.NotNull DatabaseError error) {
                // goes empty
            }
        });
        // pkg4price
        pkg4price_db.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @org.jetbrains.annotations.NotNull DataSnapshot snapshot) {
                String name = snapshot.getValue().toString();
                pkg4price.setText(name);
            }

            @Override
            public void onCancelled(@NonNull @org.jetbrains.annotations.NotNull DatabaseError error) {
                // goes empty
            }
        });
        // pkg5price
        pkg5price_db.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @org.jetbrains.annotations.NotNull DataSnapshot snapshot) {
                String name = snapshot.getValue().toString();
                pkg5price.setText(name);
            }

            @Override
            public void onCancelled(@NonNull @org.jetbrains.annotations.NotNull DatabaseError error) {
                // goes empty
            }
        });
        // pkg6price
        pkg6price_db.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @org.jetbrains.annotations.NotNull DataSnapshot snapshot) {
                String name = snapshot.getValue().toString();
                pkg6price.setText(name);
            }

            @Override
            public void onCancelled(@NonNull @org.jetbrains.annotations.NotNull DatabaseError error) {
                // goes empty
            }
        });

        // WEBVIEW
        pkg1img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWebView();
            }
        });
        pkg2img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWebView();
            }
        });
        pkg3img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWebView();
            }
        });
        pkg4img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWebView();
            }
        });
        pkg5img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWebView();
            }
        });
        pkg6img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWebView();
            }
        });
    }

    private void openWebView() {
        Intent intent = new Intent(getApplicationContext(), package_pricing.class);
        startActivity(intent);
    }

    private void showCustomDialogue() {
        /*AlertDialog.Builder builder = new AlertDialog.Builder(packages.this);
        builder.setMessage("Please connect to the internet.").setCancelable(false).setPositiveButton("Connect", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                startActivity(new Intent(Settings.ACTION_WIFI_SETTINGS));
            }
        })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        finish();
                    }
                });*/
        Toast.makeText(this, "NO INTERNET", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this, noInternet.class));
    }

    private boolean isConnected(packages_grid packages_grid) {
        ConnectivityManager connectivityManager = (ConnectivityManager) packages_grid.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo wifiConnection = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        NetworkInfo mobileConnection = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);

        if((wifiConnection != null && wifiConnection.isConnected()) || (mobileConnection != null && mobileConnection.isConnected())){
            return true;
        }else{
            return false;
        }

    }
}