package com.example.occshottest;

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

public class packages extends AppCompatActivity {

    TextView nameFetch;
    TextView mailFetch;
    Button logoutBtn;
    ImageView pkgBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.packages);

        logoutBtn = findViewById(R.id.logoutBtn);
        nameFetch = findViewById(R.id.nameFetch);
        mailFetch = findViewById(R.id.mailFetch);
        pkgBtn = findViewById(R.id.pkgView);

        GoogleSignInAccount signInAccount = GoogleSignIn.getLastSignedInAccount(this);
        if (signInAccount != null){
            nameFetch.setText(signInAccount.getDisplayName());
            mailFetch.setText(signInAccount.getEmail());
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
                pkgBtn.setColorFilter(getResources().getColor(R.color.theme_red));
                Intent intent2 = new Intent(getApplicationContext(), packages_grid.class);
                startActivity(intent2);
            }
        });
    }
}