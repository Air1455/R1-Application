package com.example.r1_application.controleur;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.r1_application.R;
import com.example.r1_application.model.User;

public class MainActivity extends AppCompatActivity {

    private EditText userNameEditText;
    private Button firstPageGoButton;
    private TextView welcomeMessage;
    private User user;
    public static final int GAME_ACTIVITY_REQUEST_CODE = 42;
    private SharedPreferences preferences;

    public static final String PREF_KEY_SCORE = "PREF_KEY_SCORE";
    public static final String PREF_KEY_NAME = "PREF_KEY_NAME";

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult ( requestCode, resultCode, data );
        if (GAME_ACTIVITY_REQUEST_CODE == requestCode && RESULT_OK == resultCode) {
            int score = data.getIntExtra ( GameActivity.BUNDLE_EXTRA_SCORE, 0 );
            preferences.edit ().putInt ( PREF_KEY_SCORE, score ).apply ();

            greetUser();
        }
    }

    private void greetUser() {
        String name = preferences.getString(PREF_KEY_NAME, null);

        if (null != name) {
            int score = preferences.getInt(PREF_KEY_SCORE, 0);

            String fulltext = "Welcome back, " + name
                    + "!\nYour last score was " + score
                    + ", will you do better this time?";
            welcomeMessage.setText(fulltext);
            userNameEditText.setText(name);
            userNameEditText.setSelection(name.length());
            firstPageGoButton.setEnabled(true);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );

        firstPageGoButton = findViewById ( R.id.firstPageGoButton );
        userNameEditText = findViewById ( R.id.userNameEditText );
        welcomeMessage = findViewById ( R.id.welcomeText );
        user = new User();

        preferences = getPreferences ( MODE_PRIVATE );
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
                String userName = userNameEditText.getText ().toString ();
                user.setUserName ( userName );

                preferences.edit ().putString ( PREF_KEY_NAME, user.getUserName () ).apply ();

                Intent goToGameActivity = new Intent ( MainActivity.this, GameActivity.class);
                startActivity ( goToGameActivity );
                startActivityForResult ( goToGameActivity, GAME_ACTIVITY_REQUEST_CODE );
            }
        } );

    }
}
