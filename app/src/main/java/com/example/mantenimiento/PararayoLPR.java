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

    private boolean getMastilLimpieza;
    private boolean getMastilEstatus;

    private EditText obsPuntaFaradayLPR;
    private EditText obsMastilLPR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pararayo_lpr);

        CheckBox checkBoxLimpiezaPuntaSI = findViewById(R.id.limpieza_far_lpr_si);
        CheckBox checkBoxLimpiezaPuntaNO = findViewById(R.id.limpieza_far_lpr_no);
        CheckBox checkBoxEstatusPuntaSI = findViewById(R.id.estatus_far_lpr_si);
        CheckBox checkBoxEstatusPuntaNO = findViewById(R.id.estatus_far_lpr_no);

        CheckBox checkBoxLimpiezaMastilSI = findViewById(R.id.limpieza_mast_lpr_si);
        CheckBox checkBoxLimpiezaMastilNO = findViewById(R.id.limpieza_mast_lpr_no);
        CheckBox checkBoxEstatusMastilSI = findViewById(R.id.estatus_mast_lpr_si);
        CheckBox checkBoxEstatusMastilNO = findViewById(R.id.estatus_mast_lpr_no);

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

        checkBoxLimpiezaMastilSI.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxLimpiezaMastilSI.setChecked(false);
                    getMastilLimpieza = !isChecked;
                }
            }
        });

        checkBoxLimpiezaMastilNO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxLimpiezaMastilNO.setChecked(false);
                    getMastilLimpieza = isChecked;
                }
            }
        });

        checkBoxEstatusMastilSI.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxEstatusMastilSI.setChecked(false);
                    getMastilEstatus = !isChecked;
                }
            }
        });

        checkBoxEstatusMastilNO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxEstatusMastilNO.setChecked(false);
                    getMastilEstatus = isChecked;
                }
            }
        });

        obsPuntaFaradayLPR = findViewById(R.id.ob_far_par_lpr);
        obsMastilLPR = findViewById(R.id.ob_mastil_par_lpr);


        ImageButton save = findViewById(R.id.siguiente_menu);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String obsPuntaFaraday = obsPuntaFaradayLPR.getText().toString();
                String obsMastil = obsMastilLPR.getText().toString();
                storePararayo(getPuntaLimpieza, getPuntaEstatus, getMastilLimpieza, getMastilEstatus, obsPuntaFaraday, obsMastil);
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

    private void storePararayo(boolean getPuntaLimpieza, boolean getPuntaEstatus, boolean getMastilLimpieza, boolean getMastilEstatus, String obsPuntaFaraday, String obsMastil) {
        ApiService apiService = ApiClient.getClient();

        int idMantenimiento = AppData.getInstance().getIdMantenimiento();


        Call<PararayoResponseLPR> call = apiService.storePararayosLPR(idMantenimiento, getPuntaLimpieza, getPuntaEstatus, getMastilLimpieza, getMastilEstatus, obsPuntaFaraday, obsMastil);
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