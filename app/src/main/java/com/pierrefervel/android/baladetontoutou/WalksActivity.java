package com.pierrefervel.android.baladetontoutou;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import java.util.ArrayList;

public class WalksActivity extends AppCompatActivity {

    private Button mWalksInscription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_walks);

    }

    @Override
    public void onBackPressed() {
        finish();
        super.onBackPressed();
    }
}
