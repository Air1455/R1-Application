package com.example.r1_application;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText userNameEditText;
    private Button firstPageGoButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );

        firstPageGoButton = findViewById ( R.id.firstPageGoButton );
        userNameEditText = findViewById ( R.id.userNameEditText );

        firstPageGoButton.setEnabled ( false );
        userNameEditText.addTextChangedListener ( new TextWatcher () {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(userNameEditText.length() != 0){
                    firstPageGoButton.setEnabled ( true );
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        } );
    }
}
