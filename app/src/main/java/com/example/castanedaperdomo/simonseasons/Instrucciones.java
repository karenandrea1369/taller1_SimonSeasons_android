package com.example.castanedaperdomo.simonseasons;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Observable;
import java.util.Observer;

public class Instrucciones extends AppCompatActivity implements Observer {
    private Button play,home;
    private Comunicacion2 com;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instrucciones);

        com = Comunicacion2.getRef();
        com.addObserver(this);

        play = findViewById(R.id.btn_play_instrucciones);
        home = findViewById(R.id.btn_home_instrucciones);

        //1--Home 2--Play 3--GameOver 4--Help 5--BestScore

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Instrucciones.this, Play.class);
                com.enviar("P:2");
                startActivity(i);
            }
        });
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent e = new Intent(Instrucciones.this, MainActivity.class);
                com.enviar("P:1");
                startActivity(e);
            }
        });
    }

    @Override
    public void update(Observable o, Object arg) {

    }
}
