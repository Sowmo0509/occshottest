package com.example.occshottest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;
import org.w3c.dom.Text;

public class status extends AppCompatActivity {

    TextView orderVerifyTime, arrivalTime, timeStart, timeEnd, overTime, photoshootEnd;
    ImageView orderTick, arrivalTick, startTick, endTick, overtimeTick, shootEndTick;
    private DatabaseReference client_db;
    public String notYet = "Not Yet Done";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status);

        orderVerifyTime = findViewById(R.id.orderVerifyTime);
        arrivalTime = findViewById(R.id.arrivalTime);
        timeStart = findViewById(R.id.timeStart);
        timeEnd = findViewById(R.id.timeEnd);
        overTime = findViewById(R.id.overTime);
        photoshootEnd = findViewById(R.id.photoshootEnd);

        orderTick = findViewById(R.id.orderTick);
        arrivalTick = findViewById(R.id.arrivalTick);
        startTick = findViewById(R.id.startTick);
        endTick = findViewById(R.id.endTick);
        overtimeTick = findViewById(R.id.overtimeTick);
        shootEndTick = findViewById(R.id.shootEndTick);

        addOrderTime();

    }

    private void addOrderTime() {
        GoogleSignInAccount signInAccount = GoogleSignIn.getLastSignedInAccount(this);
        if (signInAccount != null){
            String mailWithDomain = signInAccount.getEmail();
            String mailWithoutDomain = mailWithDomain.replaceAll("@gmail.com", "");
            client_db = FirebaseDatabase.getInstance().getReference("Client").child(mailWithoutDomain);


            // fetching starts
            client_db.child("OrderVerify").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                    if (snapshot.exists()){
                        String orVerTi = snapshot.getValue().toString();
                        orderVerifyTime.setText(orVerTi);
                        orderTick.setImageResource(R.drawable.red_tick);
                    }
                    else{
                        orderVerifyTime.setText(notYet);
                        orderTick.setImageResource(R.drawable.grey_tick);
                    }
                }

                @Override
                public void onCancelled(@NonNull @NotNull DatabaseError error) {

                }
            });

            client_db.child("Arrival").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                    if (snapshot.exists()){
                        String orVerTi = snapshot.getValue().toString();
                        arrivalTime.setText(orVerTi);
                        arrivalTick.setImageResource(R.drawable.red_tick);
                    }else{
                        arrivalTime.setText(notYet);
                        arrivalTick.setImageResource(R.drawable.grey_tick);
                    }
                }

                @Override
                public void onCancelled(@NonNull @NotNull DatabaseError error) {

                }
            });

            client_db.child("Overtime").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                    if (snapshot.exists()){
                        String orVerTi = snapshot.getValue().toString();
                        overTime.setText(orVerTi);
                        overtimeTick.setImageResource(R.drawable.red_tick);
                    }else{
                        overTime.setText(notYet);
                        overtimeTick.setImageResource(R.drawable.grey_tick);
                    }
                }

                @Override
                public void onCancelled(@NonNull @NotNull DatabaseError error) {

                }
            });

            client_db.child("Shoot End").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                    if (snapshot.exists()){
                        String orVerTi = snapshot.getValue().toString();
                        photoshootEnd.setText(orVerTi);
                        shootEndTick.setImageResource(R.drawable.red_tick);
                    }else{
                        photoshootEnd.setText(notYet);
                        shootEndTick.setImageResource(R.drawable.grey_tick);
                    }
                }

                @Override
                public void onCancelled(@NonNull @NotNull DatabaseError error) {

                }
            });

            client_db.child("Time End").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                    if (snapshot.exists()){
                        String orVerTi = snapshot.getValue().toString();
                        timeEnd.setText(orVerTi);
                        endTick.setImageResource(R.drawable.red_tick);
                    }else{
                        timeEnd.setText(notYet);
                        endTick.setImageResource(R.drawable.grey_tick);
                    }
                }

                @Override
                public void onCancelled(@NonNull @NotNull DatabaseError error) {

                }
            });

            client_db.child("Time Start").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                    if (snapshot.exists()){
                        String orVerTi = snapshot.getValue().toString();
                        timeStart.setText(orVerTi);
                        startTick.setImageResource(R.drawable.red_tick);
                    } else {
                        timeStart.setText(notYet);
                        startTick.setImageResource(R.drawable.grey_tick);
                    }
                }

                @Override
                public void onCancelled(@NonNull @NotNull DatabaseError error) {

                }
            });
        }
    }
}