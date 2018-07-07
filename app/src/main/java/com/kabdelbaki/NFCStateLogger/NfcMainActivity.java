package com.kabdelbaki.NFCStateLogger;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

import com.kabdelbaki.dfctester.MainActivity;
import com.kabdelbaki.dfctester.R;

import java.util.ArrayList;

/**
 * Created by Kabdelbaki on 06/07/2018.
 */

public class NfcMainActivity extends AppCompatActivity {

    private String TAG = "NfcState";
    private NfcStateHandler nfcStateHandler;
    private ArrayList<String> nfcLogArrayList;


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR2)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nfc__logger_activity_main);
        this.nfcStateHandler = new NfcStateHandler(this);
        registerReceiver(this.nfcStateHandler.getNfcBroadcastListener(), nfcStateHandler.getFilter());
        this.setNfcLogArrayList(nfcStateHandler);

        ScrollView sv = (ScrollView) findViewById(R.id.scrollView); // Creates a scroll view
        Button btn = (Button) findViewById(R.id.button);            // Button for refresh
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nfcStateChangeUi(nfcLogArrayList);
            }
        });

    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR2)
    @Override
    /**
     * On resume
     */
    protected void onResume() {
//        registerReceiver(this.nfcStateHandler.getNfcBroadcastListener(), nfcStateHandler.getFilter());
        this.nfcStateChangeUi(this.nfcLogArrayList);

        super.onResume();
    }

    @Override
    public void onDestroy() {

        try {
            if (this.nfcStateHandler != null) {
                this.unregisterReceiver(this.nfcStateHandler);
            }
        } catch (IllegalArgumentException ex) {
            Log.v(TAG, ex.getMessage());
//            Intent intent = new Intent(NfcMainActivity.this, MainActivity.class);
//            startActivity(intent);
        }
//        this.unregisterReceiver(this.nfcStateHandler);

        super.onDestroy();
    }


    public void setNfcLogArrayList(NfcStateHandler nfcStateChangeList) {
        this.nfcLogArrayList = nfcStateChangeList.getNfcStateChangeMessages();
    }


    /**
     * Method used to instantiate a TextView object and text to it with the use of the NFC State arraylist
     *
     * @param nfcStateChangeList
     * @return
     */
    public TextView nfcStateChangeUi(ArrayList<String> nfcStateChangeList) {


        TextView textView = (TextView) findViewById(R.id.logPanel);
        textView.setText("");
        for (int i = 0; i < nfcStateChangeList.size(); i++) {
            textView.append(nfcStateChangeList.get(i) + "\n");
        }
        textView.setMovementMethod(new ScrollingMovementMethod());

        return textView;
    }

    /**
     * @param nfcState
     * @return
     */

    public static String storeNfcStateChange(String nfcState) {
        return nfcState;
    }
}







