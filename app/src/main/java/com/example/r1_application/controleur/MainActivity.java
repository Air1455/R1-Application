package com.example.r1_application.controleur;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.r1_application.R;

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
        firstPageGoButton.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent goToGameActivity = new Intent ( MainActivity.this, GameActivity.class);
                startActivity ( goToGameActivity );
            }
        } );
    }
}
