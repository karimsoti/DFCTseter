package com.kabdelbaki.dfctester;

import android.content.Context;
import android.content.IntentFilter;

import java.util.ArrayList;

/**
 * Created by Kabdelbaki on 07/07/2018.
 */
public interface StateHandler {


    ArrayList<String> getStateChangeMessages();

    IntentFilter getFilter();
}
