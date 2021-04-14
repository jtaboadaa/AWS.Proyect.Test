package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    TextView tvFecha;
    TextView tvHora;
    TextView tvLongitud;
    TextView tvLatitud;
    Button btnEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvFecha = (TextView)findViewById(R.id.tvFecha);
        tvHora = (TextView)findViewById(R.id.tvHora);
        tvLongitud = (TextView)findViewById(R.id.tvLongitud);
        tvLatitud = (TextView)findViewById(R.id.tvLatitud);
        btnEnviar = findViewById(R.id.btnEnviar);



        // SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        //Date date = new Date();
        //String fecha = dateFormat.format(date);
        //String hour = String.valueOf(android.text.format.DateFormat.format("dd-MM-yyyy", new java.util.Date()));
        btnEnviar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String date = String.valueOf(android.text.format.DateFormat.format("MM-dd-yyyy", new java.util.Date()));
                String hour = String.valueOf(android.text.format.DateFormat.format("HH:mm", new java.util.Date()));

                tvFecha.setText("Fecha: "+date);
                tvHora.setText(("Hora: "+hour));


                LocationManager locationManager = (LocationManager) MainActivity.this.getSystemService(Context.LOCATION_SERVICE);
                LocationListener locationListener = new LocationListener() {
                    public void onLocationChanged(Location location) {

                        // Called when a new location is found by the network location provider.
                        tvLatitud.setText("Latitud: " + location.getLatitude());
                        tvLongitud.setText("Longitud: " + location.getLongitude());
                    }

                    public void onStatusChanged(String provider, int status, Bundle extras) {
                    }

                    public void onProviderEnabled(String provider) {
                    }

                    public void onProviderDisabled(String provider) {
                    }

                    ;

                };
                // Register the listener with the Location Manager to receive location updates
                int permissionCheck = ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_FINE_LOCATION);

                MessageSender messageSender = new MessageSender();
                messageSender.execute(tvFecha.getText().toString(),tvHora.getText().toString(),tvLatitud.getText().toString(),tvLongitud.getText().toString());

                locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 1, 0, locationListener);
                Toast.makeText(MainActivity.this, "MSJ Enviado", Toast.LENGTH_LONG).show();
            }
        });
        int permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION);

        if(permissionCheck == PackageManager.PERMISSION_DENIED){

            if(ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.ACCESS_FINE_LOCATION)) {

            } else {

                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                        1);
            }
        }
    }





}