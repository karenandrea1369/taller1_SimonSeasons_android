package com.example.castanedaperdomo.simonseasons;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Play extends AppCompatActivity {

    private Button primavera, verano, otono, invierno;
    private Comunicacion2 com;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        com = Comunicacion2.getRef();




    }
}
