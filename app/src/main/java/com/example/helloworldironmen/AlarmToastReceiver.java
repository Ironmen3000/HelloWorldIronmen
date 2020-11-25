package com.example.helloworldironmen;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class AlarmToastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, " KAMU BELUM MEMBUKA APLIKASI HARI INI",Toast.LENGTH_LONG).show();
    }
}
