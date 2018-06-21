package com.example.company.battercheck;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.RecoverySystem;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class BatteryActivity extends AppCompatActivity {

    private BroadcastReceiver bcr = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            int level = intent.getIntExtra("level", 0);
            ProgressBar progBar = (ProgressBar) findViewById(R.id.pb);
            progBar.setProgress(level);
            TextView tv = (TextView) findViewById(R.id.tv);
            tv.setText("Battery Level: " + Integer.toString(level) + "%");

            if (level < 55) {
                Toast.makeText(BatteryActivity.this, "You have low battery", Toast.LENGTH_LONG).show();
                AlertDialog.Builder alertBuilder = new AlertDialog.Builder(BatteryActivity.this);
                alertBuilder.setTitle("Low Battery");
                alertBuilder.setMessage("You have low battery, connect to a power source");
                alertBuilder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }

                    ;
                });
                AlertDialog ad = alertBuilder.create();
                ad.show();
            }
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battery_screen);

        registerReceiver(bcr, new IntentFilter(
            Intent.ACTION_BATTERY_CHANGED));
        }
    }
