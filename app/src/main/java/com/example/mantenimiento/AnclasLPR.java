package com.example.mantenimiento;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class AnclasLPR extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anclas_lpr);

        ImageButton img = findViewById(R.id.back);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Intent intent = new Intent(AnclasLPR.this, MenuLPR.class);
                startActivity(intent);*/
                finish();

            }
        });

    }
}