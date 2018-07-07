package com.kabdelbaki.WifiSateLogger;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

import com.kabdelbaki.dfctester.StateHandler;

import java.util.ArrayList;

/**
 * Created by Kabdelbaki on 07/07/2018.
 */
public class WifiStateHandler extends BroadcastReceiver implements StateHandler {


    private BroadcastReceiver WifiBroadcastReceiver;

    @Override
    public void onReceive(Context context, Intent intent) {

    }

    @Override
    public ArrayList<String> getStateChangeMessages() {
        return null;
    }

    @Override
    public IntentFilter getFilter() {
        return null;
    }
}
