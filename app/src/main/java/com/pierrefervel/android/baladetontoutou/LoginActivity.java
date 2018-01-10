package com.pierrefervel.android.baladetontoutou;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.pierrefervel.android.baladetontoutou.models.User;

public class LoginActivity extends AppCompatActivity {

    private EditText mLoginInput;
    private Button mLoginButton;

    public static final String USER_FIRSTNAME = "USER_FIRSTNAME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mLoginInput = findViewById(R.id.activity_login_name_input);
        mLoginButton = findViewById(R.id.activity_login_button);

        mLoginButton.setEnabled(false);
        mLoginInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence s, int i, int i1, int i2) {
                mLoginButton.setEnabled(s.toString().length() != 0);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        mLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String firstName = mLoginInput.getText().toString();

                Intent mainActivity = new Intent(LoginActivity.this, MainActivity.class);
                mainActivity.putExtra(USER_FIRSTNAME, firstName);
                startActivity(mainActivity);
                finish();
            }
        });
    }
}
