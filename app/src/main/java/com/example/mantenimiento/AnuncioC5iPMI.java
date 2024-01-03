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

public class AnuncioC5iPMI extends AppCompatActivity {

    private boolean getEstructuraLimpieza;
    private boolean getEstructuraEstatus;

    private EditText obsEstructuraAnuPMI;
    private boolean getOrientacionLimpieza;
    private boolean getOrientacionEstatus;
    private EditText obsOrientaAnuPMI;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anuncio_c5i_pmi);

        CheckBox checkBoxLimpiezaEstrSI = findViewById(R.id.limpieza_est_si);
        CheckBox checkBoxLimpiezaEstrNO = findViewById(R.id.limpieza_est_no);
        CheckBox checkBoxEstatusEstrSI = findViewById(R.id.estatus_est_si);
        CheckBox checkBoxEstatusEstrNO = findViewById(R.id.estatus_est_no);

        CheckBox checkBoxLimpiezaOriSI = findViewById(R.id.limpieza_ori_an_si);
        CheckBox checkBoxLimpiezaOriNO = findViewById(R.id.limpieza_ori_an_no);
        CheckBox checkBoxEstatusOriSI = findViewById(R.id.estatus_ori_an_si);
        CheckBox checkBoxEstatusOriNO = findViewById(R.id.estatus_ori_an_no);

        checkBoxLimpiezaEstrSI.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxLimpiezaEstrSI.setChecked(false);
                    getEstructuraLimpieza = !isChecked;
                }
            }
        });

        checkBoxLimpiezaEstrNO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxLimpiezaEstrNO.setChecked(false);
                    getEstructuraLimpieza = isChecked;
                }
            }
        });

        checkBoxEstatusEstrSI.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxEstatusEstrSI.setChecked(false);
                    getEstructuraEstatus = !isChecked;
                }
            }
        });

        checkBoxEstatusEstrNO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxEstatusEstrNO.setChecked(false);
                    getEstructuraEstatus = isChecked;
                }
            }
        });


        checkBoxLimpiezaOriSI.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxLimpiezaOriSI.setChecked(false);
                    getOrientacionLimpieza = !isChecked;
                }
            }
        });

        checkBoxLimpiezaOriNO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxLimpiezaOriNO.setChecked(false);
                    getOrientacionLimpieza = isChecked;
                }
            }
        });

        checkBoxEstatusOriSI.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxEstatusOriSI.setChecked(false);
                    getOrientacionEstatus = !isChecked;
                }
            }
        });

        checkBoxEstatusOriNO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxEstatusOriNO.setChecked(false);
                    getOrientacionEstatus = isChecked;
                }
            }
        });

        obsEstructuraAnuPMI = findViewById(R.id.ob_est_an_pmi);
        obsOrientaAnuPMI = findViewById(R.id.ob_ori_anun_pmi);

        ImageButton save = findViewById(R.id.siguiente_menu);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String obsEstructura = obsEstructuraAnuPMI.getText().toString();
                String obsOrientacion = obsOrientaAnuPMI.getText().toString();
                storeAnuncio(getEstructuraLimpieza, getEstructuraEstatus, getOrientacionLimpieza, getOrientacionEstatus, obsEstructura, obsOrientacion);
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

    private void storeAnuncio(boolean getEstructuraLimpieza, boolean getEstructuraEstatus, boolean getOrientacionLimpieza, boolean getOrientacionEstatus, String obsEstructura, String obsOrientacion) {
        ApiService apiService = ApiClient.getClient();

        int idMantenimiento = AppData.getInstance().getIdMantenimiento();

        Call<AnuncioResponsePMI> call = apiService.storeAnuncioPMI(idMantenimiento, getEstructuraLimpieza, getEstructuraEstatus, getOrientacionLimpieza, getOrientacionEstatus, obsEstructura, obsOrientacion);
        call.enqueue(new Callback<AnuncioResponsePMI>() {
            @Override
            public void onResponse(Call<AnuncioResponsePMI> call, Response<AnuncioResponsePMI> response) {
                if (response.isSuccessful()){
                    AnuncioResponsePMI anuncioResponsePMI = response.body();
                    Toast.makeText(AnuncioC5iPMI.this, "Registro guardado", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(AnuncioC5iPMI.this, "Registro incorrecto", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<AnuncioResponsePMI> call, Throwable t) {
                Toast.makeText(AnuncioC5iPMI.this, "Error de conexión", Toast.LENGTH_SHORT).show();
            }
        });
    }
}