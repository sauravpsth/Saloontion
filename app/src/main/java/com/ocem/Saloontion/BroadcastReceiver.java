package com.ocem.Saloontion;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.widget.Toast;

public class BroadcastReceiver extends android.content.BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (ConnectivityManager.CONNECTIVITY_ACTION.equals( intent.getAction() )){
            boolean nonConnectivity = intent.getBooleanExtra( ConnectivityManager.EXTRA_NO_CONNECTIVITY,false );
            if (nonConnectivity){
                Toast.makeText( context, "No internet connection", Toast.LENGTH_SHORT ).show();
            }
            else {
                Toast.makeText( context, "Internet connected", Toast.LENGTH_SHORT ).show();
            }
        }

    }
}