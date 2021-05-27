package com.example.occshottest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class packages extends AppCompatActivity {

    private TextView nameFetch;
    private TextView mailFetch;
    private TextView costTotal;
    private Button logoutBtn;
    private ImageView pkgBtn;
    private ImageView mapBtn;
    private ImageView orderBtn;

    // Firebase Database Starts
    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = firebaseDatabase.getReference("Client");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.packages);

        logoutBtn = findViewById(R.id.logoutBtn);
        nameFetch = findViewById(R.id.nameFetch);
        mailFetch = findViewById(R.id.mailFetch);
        costTotal = findViewById(R.id.costTotal);
        pkgBtn = findViewById(R.id.pkgView);
        mapBtn = findViewById(R.id.mapView);
        orderBtn = findViewById(R.id.orderView);

        GoogleSignInAccount signInAccount = GoogleSignIn.getLastSignedInAccount(this);
        if (signInAccount != null){
            nameFetch.setText(signInAccount.getDisplayName());
            mailFetch.setText(signInAccount.getEmail());
            String mailWithDomain = signInAccount.getEmail();
            String mailWithoutDomain = mailWithDomain.replaceAll("@gmail.com", "");

            //cost show here
            DatabaseReference priceCheck = databaseReference.child(mailWithoutDomain);
            priceCheck.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull @org.jetbrains.annotations.NotNull DataSnapshot snapshot) {
                    if (snapshot.exists()){
                        String price = snapshot.child("Cost").getValue().toString();
                        costTotal.setText(price);
                    }
                    else{
                        String priceNo = "No Package Selected";
                        costTotal.setText(priceNo);
                    }
                }

                @Override
                public void onCancelled(@NonNull @org.jetbrains.annotations.NotNull DatabaseError error) {
                    // goes empty
                }
            });
        }

        logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        pkgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(getApplicationContext(), packages_grid.class);
                startActivity(intent2);
            }
        });

        mapBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(getApplicationContext(), maplocation.class);
                startActivity(intent3);
            }
        });

        orderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent4 = new Intent(getApplicationContext(), order.class);
                startActivity(intent4);
            }
        });
    }
}