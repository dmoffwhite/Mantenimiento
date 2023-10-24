package com.example.mantenimiento;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


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

        CardView brazosCard = findViewById(R.id.btn_pmi_brazos);
        brazosCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                brazosCard.setCardElevation(8);
                Intent intent = new Intent(MenuPMI.this, BrazosPMI.class);
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


    }
}