package com.kabdelbaki.dfctester;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.kabdelbaki.NFCStateLogger.NfcMainActivity;

/**
 * Created by Kabdelbaki on 06/07/2018.
 */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.nfcStateLoggerButton();

    }

    public Button wifiStateLogger(){
       Button wifiBtn = (Button) findViewById(R.id.wifiBtn);

        return wifiBtn;
    }


    public Button nfcStateLoggerButton() {
        Button nfcBtn = (Button) findViewById(R.id.nfcBtn);
        nfcBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, NfcMainActivity.class);
//                Intent viewable = new Intent(Intent.ACTION_VIEW);
                startActivity(intent);
            }
        });
        return nfcBtn;
    }
}
