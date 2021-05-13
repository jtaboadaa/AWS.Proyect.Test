package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.os.StrictMode;
import android.provider.Settings;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ByteArrayPool;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;



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

        btnEnviar = (Button) findViewById(R.id.btnEnviar);

        btnEnviar.setOnClickListener(new View.OnClickListener() {

            @SuppressWarnings("deprecation")
            @Override
            public void onClick(View v) {

                String date = String.valueOf(android.text.format.DateFormat.format("MM-dd-yyyy", new java.util.Date()));
                String hour = String.valueOf(android.text.format.DateFormat.format("HH:mm", new java.util.Date()));

                tvFecha.setText(date);
                tvHora.setText((hour));

                LocationManager locationManager = (LocationManager) MainActivity.this.getSystemService(Context.LOCATION_SERVICE);
                LocationListener locationListener = new LocationListener() {
                    public void onLocationChanged(Location location) {

                        // Called when a new location is found by the network location provider.
                        tvLatitud.setText(""+ location.getLatitude());
                        tvLongitud.setText(""+location.getLongitude());
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

                locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, locationListener);
                MessageSender messageSender = new MessageSender();
                messageSender.execute(tvFecha.getText().toString(),tvHora.getText().toString(),tvLatitud.getText().toString(),tvLongitud.getText().toString());
                Toast.makeText(MainActivity.this, "Ubicacion Enviada", Toast.LENGTH_LONG).show();

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