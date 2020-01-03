package com.ictapp1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.widget.Toast;

public class IncomingClass extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle b = intent.getExtras();

        String state = b.getString(TelephonyManager.EXTRA_STATE);
        if (b!= null){
        if(state.equals(TelephonyManager.EXTRA_STATE_RINGING))
            {
                Toast.makeText(context, "YOU HAVE INCOMING CALLS"
                        + b.getString(TelephonyManager.EXTRA_INCOMING_NUMBER), Toast.LENGTH_SHORT).show();
            }
        }
    }
}
