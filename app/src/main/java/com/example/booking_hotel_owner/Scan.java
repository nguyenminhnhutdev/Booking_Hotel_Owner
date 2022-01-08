package com.example.booking_hotel_owner;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class Scan extends AppCompatActivity {
ImageView Scan1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan);
        Scan1=findViewById(R.id.Scan1);
        Scan1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IntentIntegrator intentIntegrator= new IntentIntegrator(Scan.this);
                intentIntegrator.setPrompt("Check Booking");
                intentIntegrator.setBeepEnabled(true);
                intentIntegrator.setOrientationLocked(true);
                intentIntegrator.setCaptureActivity(Capture.class);
                intentIntegrator.initiateScan();
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        IntentResult intentResult= IntentIntegrator.parseActivityResult(requestCode,resultCode,data);
        if(intentResult.getContents()!=null)
        {
            AlertDialog.Builder builder= new AlertDialog.Builder(Scan.this);
            builder.setMessage(intentResult.getContents());
            builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();

                }
            });
            builder.show();
        }else {
            Toast.makeText(Scan.this, "k thjeer scan", Toast.LENGTH_SHORT).show();
        }
    }
}