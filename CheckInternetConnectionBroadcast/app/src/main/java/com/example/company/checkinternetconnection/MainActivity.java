package com.example.company.checkinternetconnection;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements ConnectivityReceiver.ConnectivityReceiverListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkConnection();
    }

    private void checkConnection(){
        boolean isConnected = ConnectivityReceiver.isConnected();
        showSnack(isConnected);
    }

    private void showSnack(boolean isConnected){
        if(isConnected){
            setContentView(R.layout.activity_main);
        }else{
           setContentView(R.layout.no_internet);
        }
    }
    @Override
    protected void onResume(){
        super.onResume();
        MyApplication.getInstance().setConnectivityListener(this);
    }


    public void onNetworkConnectionChanged(boolean isConnected){
        showSnack(isConnected);
    }
}
