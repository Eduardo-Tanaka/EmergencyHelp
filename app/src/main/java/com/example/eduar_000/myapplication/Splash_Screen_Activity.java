package com.example.eduar_000.myapplication;

import android.content.Intent;
import android.os.Bundle;

import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import com.google.android.gms.maps.model.LatLng;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;


public class Splash_Screen_Activity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                startActivity(new Intent(Splash_Screen_Activity.this, MainActivity.class));
                finish();
            }
        }, 1000);
        //splash();
    }
/*
    public void splash() {

        Thread thread = new Thread(){
            @Override
            public void run(){
                try {
                    sleep(1000);
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                }catch (InterruptedException e){
                    e.printStackTrace();
                }

            }
        };
        thread.start();

        setContentView(R.layout.activity_splash__screen__activiry);
    }
*/
    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_splash__screen__activiry, menu);
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
        }

        return super.onOptionsItemSelected(item);
    }

}
