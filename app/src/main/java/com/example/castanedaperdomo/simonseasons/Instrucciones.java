package com.example.castanedaperdomo.simonseasons;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Instrucciones extends AppCompatActivity {
    private Button play,home;
    private Comunicacion2 com;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instrucciones);

        play = findViewById(R.id.btn_play_instrucciones);
        home = findViewById(R.id.btn_home_instrucciones);


        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Instrucciones.this, Play.class);
                startActivity(i);
            }
        });
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Instrucciones.this, MainActivity.class);
                startActivity(i);
            }
        });
    }
}
