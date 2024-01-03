package com.example.mantenimiento;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MenuLPR extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_lpr);

        CardView pararayoCard = findViewById(R.id.btn_lpr_pararayo);
        pararayoCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuLPR.this, PararayoLPR.class);
                startActivity(intent);
            }
        });

        CardView equipamientoCard = findViewById(R.id.btn_lpr_equipamiento);
        equipamientoCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuLPR.this, EquipamientoLPR.class);
                startActivity(intent);
            }
        });

        CardView electrificacionCard = findViewById(R.id.btn_lpr_electrificacion);
        electrificacionCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuLPR.this, ElectificacionLPR.class);
                startActivity(intent);
            }
        });

        CardView gabineteCard = findViewById(R.id.btn_lpr_gabinete);
        gabineteCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuLPR.this, GabineteLPR.class);
                startActivity(intent);
            }
        });

        CardView registroCard = findViewById(R.id.btn_lpr_registro);
        registroCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuLPR.this, RegistroMantenimientoLPR.class);
                startActivity(intent);
            }
        });

        CardView anclasCard = findViewById(R.id.btn_lpr_anclas);
        anclasCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuLPR.this, AnclasLPR.class);
                startActivity(intent);
            }
        });

        CardView cimentacionCard = findViewById(R.id.btn_lpr_cimentacion);
        cimentacionCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuLPR.this, CimentacionLPR.class);
                startActivity(intent);
            }
        });


        CardView estructuraCard = findViewById(R.id.btn_lpr_estructura);
        estructuraCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuLPR.this, EstructuraLPR.class);
                startActivity(intent);
            }
        });

        CardView sistematierrasCard = findViewById(R.id.btn_lpr_tierras);
        sistematierrasCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuLPR.this, SistemaTierrasLPR.class);
                startActivity(intent);
            }
        });

        CardView obs = findViewById(R.id.btn_lpr_tierras);
        obs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuLPR.this, ObservacionGrlLPR.class);
                startActivity(intent);
            }
        });

        ImageButton img = findViewById(R.id.back);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();

            }
        });



    }
}