package com.example.castanedaperdomo.simonseasons;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.Observable;
import java.util.Observer;

public class MainActivity extends AppCompatActivity implements Observer {

    private Comunicacion2 com;
    private Button help,bestScore;
    private ImageButton play;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        play = findViewById(R.id.btn_play_main);
        help = findViewById(R.id.btn_help_main);
        bestScore = findViewById(R.id.btn_bestscore_main);



        com = Comunicacion2.getRef();
        com.addObserver(this);

        //1--Home 2--Play 3--GameOver 4--Help 5--BestScore

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Play.class);
                com.enviar("P:2");
                startActivity(i);

            }
        });
        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent e = new Intent(MainActivity.this, Instrucciones.class);
                com.enviar("P:4");
                startActivity(e);
            }
        });

        bestScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(MainActivity.this, BestScore.class);
                com.enviar("P:5");
                startActivity(a);
            }
        });
    }

    @Override
    public void update(Observable observable, Object o) {
        final String mensaje = (String)o;
//        runOnUiThread(new Runnable() {
//            @Override
//            public void run() {
//                //Toast.makeText(getApplicationContext(), mensaje, Toast.LENGTH_SHORT).show();
//            }
//        });

    }
}
