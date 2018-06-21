package com.example.company.incomingsms;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class IncomingSms extends BroadcastReceiver{

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"You have recieved a Text Message",Toast.LENGTH_LONG).show();
    }
}
