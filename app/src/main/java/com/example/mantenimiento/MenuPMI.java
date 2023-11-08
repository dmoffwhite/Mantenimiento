package com.example.mantenimiento;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;


public class MenuPMI extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_pmi);

        CardView posteCard = findViewById(R.id.btn_pmi_poste);
        posteCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                posteCard.setCardElevation(8);
                Intent intent = new Intent(MenuPMI.this, PostePMI.class);
                startActivity(intent);
            }
        });

        CardView pararayosCard = findViewById(R.id.btn_pmi_para);
        pararayosCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuPMI.this, PararayoPMI.class);
                startActivity(intent);
            }
        });

        CardView brazosCard = findViewById(R.id.btn_pmi_brazos);
        brazosCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                brazosCard.setCardElevation(8);
                Intent intent = new Intent(MenuPMI.this, BrazosPMI.class);
                startActivity(intent);
            }
        });

        CardView equipamientoCard = findViewById(R.id.btn_pmi_equip);
        equipamientoCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuPMI.this, EquipamientoPMI.class);
                startActivity(intent);
            }
        });

        CardView gabineteCard = findViewById(R.id.btn_pmi_gabinete);
        gabineteCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuPMI.this, GabinetePMI.class);
                startActivity(intent);
            }
        });

        CardView anuncio  = findViewById(R.id.btn_pmi_anuncio);
        anuncio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuPMI.this, AnuncioC5iPMI.class);
                startActivity(intent);
            }
        });

        CardView boton = findViewById(R.id.btn_pmi_boton);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuPMI.this, BotonPanicoPMI.class);
                startActivity(intent);
            }
        });

        CardView registro = findViewById(R.id.btn_pmi_registro);
        registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuPMI.this, RegistroMantenimientoPMI.class);
                startActivity(intent);
            }
        });

        CardView anclas = findViewById(R.id.btn_pmi_anclas);
        anclas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuPMI.this, AnclasPostePMI.class);
                startActivity(intent);
            }
        });

        CardView cimentacion = findViewById(R.id.btn_pmi_cimentacion);
        cimentacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuPMI.this, CimentacionPMI.class);
                startActivity(intent);
            }
        });

        CardView tierra = findViewById(R.id.btn_pmi_sistema);
        tierra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuPMI.this, SistemaTierrasPMI.class);
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