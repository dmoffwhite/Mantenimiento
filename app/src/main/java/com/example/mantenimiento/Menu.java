package com.example.mantenimiento;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Menu extends AppCompatActivity {

   private Button pmi;
   private Button lpr;

   public int idUsuario;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        pmi = findViewById(R.id.pmi_menu);
        lpr = findViewById(R.id.lpr_menu);


        idUsuario = getIntent().getIntExtra("idUsuario", -1);


        pmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pmiIntent = new Intent(Menu.this, FormPMI.class);
                //pmiIntent.putExtra("idUsuario", idUsuario);
                startActivity(pmiIntent);
            }
        });

        lpr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent lprIntent = new Intent(Menu.this, FormLPR.class);
                //lprIntent.putExtra("idUsuario", idUsuario);
                startActivity(lprIntent);
            }
        });

    }

    public int getIdUsuario() {
        return idUsuario;
    }
}