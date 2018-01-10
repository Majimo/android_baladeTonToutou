package com.pierrefervel.android.baladetontoutou;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.support.v7.widget.ActionMenuView;
import android.widget.Button;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button mLoginButton;
    private Button mMapButton;
    private Button mDogButton;
    private Button mHistoryButton;
    private Button mWalksButton;

    private ActionMenuView amvMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Configure Toolbar
        this.configureToolbar();

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
                goToMap();
            }
        });

        mWalksButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Click on Walks
                goToWalks();
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_activity_main, amvMenu.getMenu());
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Action on icon click
        switch (item.getItemId()) {
            case R.id.menu_activity_main :
                Toast.makeText(this, "Vous êtes déjà à l'acceuil du menu", Toast.LENGTH_LONG).show();
                return true;
            case R.id.menu_activity_map :
                goToMap();
                return true;
            case R.id.menu_activity_dog :
                Toast.makeText(this, "Pas d'accès à cette zone pour le moment, désolé", Toast.LENGTH_LONG).show();
                return true;
            case R.id.menu_activity_history :
                Toast.makeText(this, "Pas d'accès à cette zone pour le moment, désolé", Toast.LENGTH_LONG).show();
                return true;
            case R.id.menu_activity_walks :
                goToWalks();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void configureToolbar(){
        // Add toolbar view inside activity
        Toolbar t = (Toolbar) findViewById(R.id.tToolbar);
        amvMenu = (ActionMenuView) t.findViewById(R.id.amvMenu);
        amvMenu.setOnMenuItemClickListener(new ActionMenuView.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                return onOptionsItemSelected(menuItem);
            }
        });
        setSupportActionBar(t);
        getSupportActionBar().setTitle(null);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void goToMap() {
        Intent mapActivity = new Intent(MainActivity.this, MapActivity.class);
        startActivity(mapActivity);
    }

    public void goToWalks() {
        Intent walksActivity = new Intent(MainActivity.this, WalksActivity.class);
        startActivity(walksActivity);
    }
}
