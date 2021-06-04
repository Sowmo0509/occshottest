package com.example.occshottest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.provider.Settings;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

public class delivery extends AppCompatActivity {

    TextView shootEndDate, paymentDate, jpegDeliveryDate, pickingDate, printingDate, closeDate;
    ImageView shootTick, paymentTick, jpegTick, pickTick, printingTick, closeTick;
    private DatabaseReference client_db;
    public String notYet = "Not Yet Done";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery);

        shootEndDate = findViewById(R.id.shootEndDate);
        paymentDate = findViewById(R.id.paymentDate);
        jpegDeliveryDate = findViewById(R.id.jpegDeliveryDate);
        pickingDate = findViewById(R.id.pickingDate);
        printingDate = findViewById(R.id.printingDate);
        closeDate = findViewById(R.id.closeDate);

        shootTick = findViewById(R.id.shootTick);
        paymentTick = findViewById(R.id.paymentTick);
        jpegTick = findViewById(R.id.jpegTick);
        pickTick = findViewById(R.id.pickTick);
        printingTick = findViewById(R.id.printingTick);
        closeTick = findViewById(R.id.closeTick);

        if(!isConnected(this)){
            showCustomDialogue();
        }

        startDataFetch();
    }

    private void startDataFetch() {
        GoogleSignInAccount signInAccount = GoogleSignIn.getLastSignedInAccount(this);
        if (signInAccount != null){
            String mailWithDomain = signInAccount.getEmail();
            String mailWithoutDomain = mailWithDomain.replaceAll("@gmail.com", "");
            client_db = FirebaseDatabase.getInstance().getReference("Client").child(mailWithoutDomain);


            // fetching starts
            client_db.child("Shoot End Date").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                    if (snapshot.exists()){
                        String orVerTi = snapshot.getValue().toString();
                        shootEndDate.setText(orVerTi);
                        shootTick.setImageResource(R.drawable.red_tick);
                    }
                    else{
                        shootEndDate.setText(notYet);
                        shootTick.setImageResource(R.drawable.grey_tick);
                    }
                }

                @Override
                public void onCancelled(@NonNull @NotNull DatabaseError error) {

                }
            });

            client_db.child("Payment Date").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                    if (snapshot.exists()){
                        String orVerTi = snapshot.getValue().toString();
                        paymentDate.setText(orVerTi);
                        paymentTick.setImageResource(R.drawable.red_tick);
                    }else{
                        paymentDate.setText(notYet);
                        paymentTick.setImageResource(R.drawable.grey_tick);
                    }
                }

                @Override
                public void onCancelled(@NonNull @NotNull DatabaseError error) {

                }
            });

            client_db.child("JPEG Delivery").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                    if (snapshot.exists()){
                        String orVerTi = snapshot.getValue().toString();
                        jpegDeliveryDate.setText(orVerTi);
                        jpegTick.setImageResource(R.drawable.red_tick);
                    }else{
                        jpegDeliveryDate.setText(notYet);
                        jpegTick.setImageResource(R.drawable.grey_tick);
                    }
                }

                @Override
                public void onCancelled(@NonNull @NotNull DatabaseError error) {

                }
            });

            client_db.child("Picked for Print").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                    if (snapshot.exists()){
                        String orVerTi = snapshot.getValue().toString();
                        pickingDate.setText(orVerTi);
                        pickTick.setImageResource(R.drawable.red_tick);
                    }else{
                        pickingDate.setText(notYet);
                        pickTick.setImageResource(R.drawable.grey_tick);
                    }
                }

                @Override
                public void onCancelled(@NonNull @NotNull DatabaseError error) {

                }
            });

            client_db.child("Printing Date").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                    if (snapshot.exists()){
                        String orVerTi = snapshot.getValue().toString();
                        printingDate.setText(orVerTi);
                        printingTick.setImageResource(R.drawable.red_tick);
                    }else{
                        printingDate.setText(notYet);
                        printingTick.setImageResource(R.drawable.grey_tick);
                    }
                }

                @Override
                public void onCancelled(@NonNull @NotNull DatabaseError error) {

                }
            });

            client_db.child("Order Close Date").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                    if (snapshot.exists()){
                        String orVerTi = snapshot.getValue().toString();
                        closeDate.setText(orVerTi);
                        closeTick.setImageResource(R.drawable.red_tick);
                    } else {
                        closeDate.setText(notYet);
                        closeTick.setImageResource(R.drawable.grey_tick);
                    }
                }

                @Override
                public void onCancelled(@NonNull @NotNull DatabaseError error) {

                }
            });
        }
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

    private boolean isConnected(delivery delivery) {
        ConnectivityManager connectivityManager = (ConnectivityManager) delivery.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo wifiConnection = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        NetworkInfo mobileConnection = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);

        if((wifiConnection != null && wifiConnection.isConnected()) || (mobileConnection != null && mobileConnection.isConnected())){
            return true;
        }else{
            return false;
        }

    }
}