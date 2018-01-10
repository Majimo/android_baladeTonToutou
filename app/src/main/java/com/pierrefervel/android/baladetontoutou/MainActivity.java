package com.pierrefervel.android.baladetontoutou;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button mLoginButton;
    private Button mMapButton;
    private Button mDogButton;
    private Button mHistoryButton;
    private Button mWalksButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLoginButton = findViewById(R.id.activity_main_login);
        mMapButton = findViewById(R.id.activity_main_map);
        mDogButton = findViewById(R.id.activity_main_dog);
        mHistoryButton = findViewById(R.id.activity_main_history);
        mWalksButton = findViewById(R.id.activity_main_walks);
        Intent iin = getIntent();
        Bundle b = iin.getExtras();

        if (b != null) {
            String firstName = "Connecté : " + b.get(LoginActivity.USER_FIRSTNAME);
            mLoginButton.setText(firstName);
            mDogButton.setEnabled(true);
            mHistoryButton.setEnabled(true);
        }
        else {
            mDogButton.setEnabled(false);
            mHistoryButton.setEnabled(false);
        }

        mLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Click on Login
                Intent loginActivity = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(loginActivity);
            }
        });

        mMapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Click on Map
                Intent mapActivity = new Intent(MainActivity.this, MapActivity.class);
                startActivity(mapActivity);
            }
        });

        mWalksButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Click on Walks
                Intent walksActivity = new Intent(MainActivity.this, WalksActivity.class);
                startActivity(walksActivity);
            }
        });

        mDogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Click on Dog
            }
        });

        mHistoryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Click on History
            }
        });

    }
}
