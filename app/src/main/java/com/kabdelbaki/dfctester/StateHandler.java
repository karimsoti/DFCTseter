package com.kabdelbaki.dfctester;

import android.content.IntentFilter;

import java.util.ArrayList;

/**
 * Created by Kabdelbaki on 07/07/2018.
 */
public class StateHandler {

    private IntentFilter filter;
    private ArrayList<String> stateChangeMessages;

    public StateHandler() {

    }

    public ArrayList<String> getStateChangeMessages() {
        return stateChangeMessages;
    }

    public IntentFilter getFilter() {
        return filter;
    }
}
