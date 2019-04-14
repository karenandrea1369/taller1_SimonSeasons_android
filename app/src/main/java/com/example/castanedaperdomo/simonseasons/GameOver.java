package com.example.castanedaperdomo.simonseasons;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Observable;
import java.util.Observer;

public class GameOver extends AppCompatActivity implements Observer {

    private Button reset,home;
    private Comunicacion2 com;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);

        com = Comunicacion2.getRef();
        com.addObserver(this);

        reset = findViewById(R.id.btn_reset_gameover);
        home = findViewById(R.id.btn_home_instrucciones);

        //1--Home 2--Play 3--GameOver 4--Help 5--BestScore

       reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(GameOver.this, Play.class);
                com.enviar("P:2");
                startActivity(i);
            }
        });
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent e = new Intent(GameOver.this, MainActivity.class);
                com.enviar("P:1");
                startActivity(e);
            }
        });
    }

    @Override
    public void update(Observable o, Object arg) {

    }
}
