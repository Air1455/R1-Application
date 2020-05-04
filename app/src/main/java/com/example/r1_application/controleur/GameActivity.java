package com.example.r1_application.controleur;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.r1_application.R;

public class GameActivity extends AppCompatActivity {
    private TextView gameQuestion;
    private Button gameAnswer1;
    private Button gameAnswer2;
    private Button gameAnswer3;
    private Button gameAnswer4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_game );

        gameQuestion = findViewById ( R.id.gameQuestion );
        gameAnswer1 = findViewById ( R.id.gameAnswer1 );
        gameAnswer2 = findViewById ( R.id.gameAnswer2 );
        gameAnswer3 = findViewById ( R.id.gameAnswer3 );
        gameAnswer4 = findViewById ( R.id.gameAnswer4 );
    }
}
