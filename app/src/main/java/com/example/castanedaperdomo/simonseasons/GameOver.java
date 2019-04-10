package com.example.castanedaperdomo.simonseasons;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GameOver extends AppCompatActivity {

    private Button reset,home;
    private Comunicacion2 com;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);

        reset = findViewById(R.id.btn_reset_gameover);
        home = findViewById(R.id.btn_home_instrucciones);

       reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(GameOver.this, Play.class);
                startActivity(i);
            }
        });
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(GameOver.this, MainActivity.class);
                startActivity(i);
            }
        });
    }
}
