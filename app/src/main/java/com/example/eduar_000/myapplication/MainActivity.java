package com.example.eduar_000.myapplication;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.*;
import android.provider.Settings;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.google.android.gms.maps.GoogleMap;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {

    private ImageView img1;
    private ImageView img2;
    private ImageView img3;
    private ImageView img4;
    private ImageView img5;
    private ImageView img6;
    private AlertDialog alert;
    private GoogleMap mMap;
    private double latitude;
    private double longitude;
    private LocationManager locationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img1 = (ImageView)findViewById(R.id.img1);
        img1.setOnClickListener(this);

        img2 = (ImageView) findViewById(R.id.img2);
        img2.setOnClickListener(this);

        img3 = (ImageView) findViewById(R.id.img3);
        img3.setOnClickListener(this);

        img4 = (ImageView) findViewById(R.id.img4);
        img4.setOnClickListener(this);

        img5 = (ImageView) findViewById(R.id.img5);
        img5.setOnClickListener(this);

        img6 = (ImageView) findViewById(R.id.img6);
        img6.setOnClickListener(this);

        checkGps();
    }

    public void checkGps() {
        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        boolean gps = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);

        if(!gps) {

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("GPS desabilitado, para melhorar a localização habilite o GPS");
            builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });
            builder.setPositiveButton("Habilitar", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                    startActivity(intent);
                }
            });
            alert = builder.create();
            alert.show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        } else if(id == R.id.portuguese){
            
            return true;
        } else if(id == R.id.english) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        if( v == img1) {
            intent = new Intent(MainActivity.this, Police_Activity.class);
        } else if(v == img2){
            intent = new Intent(MainActivity.this, GasStation_Activity.class);
        } else if(v == img3){
            intent = new Intent(MainActivity.this, Pharmacy_Activity.class);
        } else if(v == img4){
            intent = new Intent(MainActivity.this, Hospital_Activity.class);
        } else if(v == img5){
            intent = new Intent(MainActivity.this, Ambulance_Activity.class);
        } else if(v == img6) {
            intent = new Intent(MainActivity.this, FireMan_Activity.class);
        }
        startActivity(intent);
    }
}
