package com.example.mantenimiento;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PararayoLPR extends AppCompatActivity {

    private boolean getPuntaLimpieza;
    private boolean getPuntaEstatus;

    private EditText obsPuntaFaradayLPR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pararayo_lpr);

        CheckBox checkBoxLimpiezaPuntaSI = findViewById(R.id.limpieza_far_lpr_si);
        CheckBox checkBoxLimpiezaPuntaNO = findViewById(R.id.limpieza_far_lpr_no);
        CheckBox checkBoxEstatusPuntaSI = findViewById(R.id.estatus_far_lpr_si);
        CheckBox checkBoxEstatusPuntaNO = findViewById(R.id.estatus_far_lpr_no);

        checkBoxLimpiezaPuntaSI.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxLimpiezaPuntaSI.setChecked(false);
                    getPuntaLimpieza = !isChecked;
                }
            }
        });

        checkBoxLimpiezaPuntaNO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxLimpiezaPuntaNO.setChecked(false);
                    getPuntaLimpieza = isChecked;
                }
            }
        });

        checkBoxEstatusPuntaSI.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    checkBoxEstatusPuntaSI.setChecked(false);
                    getPuntaEstatus = !isChecked;
                }
            }
        });

        checkBoxEstatusPuntaNO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    checkBoxEstatusPuntaNO.setChecked(false);
                    getPuntaEstatus = isChecked;
                }
            }
        });

        obsPuntaFaradayLPR = findViewById(R.id.ob_far_par_lpr);

        ImageButton save = findViewById(R.id.siguiente_menu);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String obsPuntaFaraday = obsPuntaFaradayLPR.getText().toString();
                storePararayo(getPuntaLimpieza, getPuntaEstatus);
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

    private void storePararayo(boolean getPuntaLimpieza, boolean getPuntaEstatus) {
        ApiService apiService = ApiClient.getClient();

        int idMantenimiento = AppData.getInstance().getIdMantenimiento();


        Call<PararayoResponseLPR> call = apiService.storePararayosLPR(idMantenimiento, getPuntaLimpieza, getPuntaEstatus);
        call.enqueue(new Callback<PararayoResponseLPR>() {
            @Override
            public void onResponse(Call<PararayoResponseLPR> call, Response<PararayoResponseLPR> response) {
                if (response.isSuccessful()){
                    PararayoResponseLPR pararayoResponseLPR = response.body();
                    Toast.makeText(PararayoLPR.this, "Registro guardado", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(PararayoLPR.this, "Registro incorrecto", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<PararayoResponseLPR> call, Throwable t) {
                Toast.makeText(PararayoLPR.this, "Error en la conexion" + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }


}