package com.example.castanedaperdomo.simonseasons;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Observable;
import java.util.Observer;

public class Play extends AppCompatActivity implements Observer {

    private Button primavera, verano, otono, invierno;
    private TextView tiempo;
    private Comunicacion2 com;
    private boolean perder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        com = Comunicacion2.getRef();
        com.addObserver(this);
        perder= false;

        primavera = findViewById(R.id.btn_primavera_play);
        verano = findViewById(R.id.btn_verano_play);
        invierno = findViewById(R.id.btn_invierno_play);
        otono = findViewById(R.id.btn_otono_play);

        tiempo= findViewById(R.id.tv_tiempo_play);

        primavera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                com.enviar("E:primavera");
            }
        });

        verano.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                com.enviar("E:verano");
            }
        });

        invierno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                com.enviar("E:invierno");
            }
        });

        otono.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                com.enviar("E:otono");
            }
        });

       // getSupportActionBar().hide();


        if(perder==true){

            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(getApplicationContext(),String.valueOf(perder), Toast.LENGTH_SHORT).show();
                }
            });

            Intent i = new Intent(Play.this, GameOver.class);
            startActivity(i);
            //perder = false;
        }
    }

//    public void perder(){
//        Intent i = new Intent(Play.this, GameOver.class);
//        startActivity(i);
//    }

    @Override
    public void update(Observable o, Object arg) {
        final String mensaje = (String)arg;

        if(mensaje.equalsIgnoreCase("pierde")) {
            Intent i = new Intent(getApplicationContext(), GameOver.class);
            startActivity(i);
        }

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
//                if(mensaje.contains("P:3")) {
//                    Toast.makeText(getApplicationContext(), "Perdiste :c", Toast.LENGTH_SHORT).show();
//                }
                if (mensaje.contains("T:")){
                    String[] partido = mensaje.split(":");
                    tiempo.setText(partido[1]);
                }
            }
        });


    }
}
