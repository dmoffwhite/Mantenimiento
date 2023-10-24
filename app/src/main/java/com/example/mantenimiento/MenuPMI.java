package com.example.mantenimiento;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuPMI extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_pmi);

        CardView cardView = findViewById(R.id.btn_pmi_poste);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cardView.setCardElevation(8);
                Intent intent = new Intent(MenuPMI.this, PostePMI.class);
                startActivity(intent);
            }
        });


    }
}