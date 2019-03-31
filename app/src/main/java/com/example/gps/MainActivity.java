package com.example.gps;

import android.Manifest;
import android.app.Activity;
import android.location.Location;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button) findViewById(R.id.btn);
        ActivityCompat.requestPermissions(MainActivity.this, new String[] {Manifest.permission.ACCESS_FINE_LOCATION}, 123);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                GPStracker gt = new GPStracker(getApplicationContext());
                Location l = gt.getLocation();
                if( l == null){
                    Toast.makeText(getApplicationContext(),"GPS unable to get Value",Toast.LENGTH_SHORT).show();
                }else {
                    double lat = l.getLatitude();
                    double lon = l.getLongitude();
                    Toast.makeText(getApplicationContext(),"Lat = "+lat+"\n Lon = "+lon,Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}