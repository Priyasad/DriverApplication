package com.example.darshanapriyasad.driverapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

import com.example.darshanapriyasad.driverapp.controller.DriverController;
import com.example.darshanapriyasad.driverapp.support.DownloadDetail;

public class DriverLogin extends AppCompatActivity {


    private Button loginButton;
    DriverController driverController;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        driverController = new DriverController();

        loginButton = (Button) findViewById(R.id.button);

        if(driverController.isRegisterd()){

        }else{
            Toast.makeText(getApplicationContext(), "No Driver Yet", Toast.LENGTH_LONG).show();

            addDriver();
        }


    }

    private void addDriver() {
        // add driver code here

        DownloadDetail downloadDetail = new DownloadDetail();
        String[] driverDetails = downloadDetail.getDriverDetails();

        String driver_id = null;
        String user_name = null;
        String password = null;

        if(driverDetails != null){
            driver_id = driverDetails[0];
            user_name = driverDetails[1];
            password = driverDetails[2];
        }

        if(password != null){
            driverController.addDriver(driver_id,user_name,password);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_driver_login, menu);
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
