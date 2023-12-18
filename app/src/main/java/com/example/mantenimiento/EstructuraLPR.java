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

public class EstructuraLPR extends AppCompatActivity {

    private boolean getTorbLimpieza;
    private boolean getTorbEstatus;
    private EditText obsTorBLPR;
    private boolean getGalvLimpieza;
    private boolean getGalvEstatus;
    private EditText obsGalvLPR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estructura_lpr);

        CheckBox checkBoxLimpiezaTorbSI = findViewById(R.id.limpieza_torb_si);
        CheckBox checkBoxLimpiezaTorbNO = findViewById(R.id.limpieza_torb_no);
        CheckBox checkBoxEstatusTorbSI = findViewById(R.id.estatus_torb_si);
        CheckBox checkBoxEstatusTorbNO = findViewById(R.id.estatus_torb_no);

        CheckBox checkBoxLimpiezaGalvSI = findViewById(R.id.limpieza_galv_si);
        CheckBox checkBoxLimpiezaGalvNO = findViewById(R.id.limpieza_galv_no);
        CheckBox checkBoxEstatusGalvSI = findViewById(R.id.estatus_galv_si);
        CheckBox checkBoxEstatusGalvNO = findViewById(R.id.estatus_galv_no);


        checkBoxLimpiezaTorbSI.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxLimpiezaTorbSI.setChecked(false);
                    getTorbLimpieza = !isChecked;
                }
            }
        });

        checkBoxLimpiezaTorbNO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxLimpiezaTorbNO.setChecked(false);
                    getTorbLimpieza = isChecked;
                }
            }
        });

        checkBoxEstatusTorbSI.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxEstatusTorbSI.setChecked(false);
                    getTorbEstatus = !isChecked;
                }
            }
        });

        checkBoxEstatusTorbNO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxEstatusTorbNO.setChecked(false);
                    getTorbEstatus = isChecked;
                }
            }
        });

        checkBoxLimpiezaGalvSI.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    checkBoxLimpiezaGalvSI.setChecked(false);
                    getGalvLimpieza = !isChecked;
                }
            }
        });

        checkBoxLimpiezaGalvNO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    checkBoxLimpiezaGalvSI.setChecked(false);
                    getGalvLimpieza = isChecked;
                }
            }
        });

        checkBoxEstatusGalvSI.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxEstatusGalvSI.setChecked(false);
                    getGalvEstatus = !isChecked;
                }
            }
        });

        checkBoxEstatusGalvNO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxEstatusGalvNO.setChecked(false);
                    getGalvEstatus = isChecked;
                }
            }
        });

        obsTorBLPR = findViewById(R.id.ob_torb_est_lpr);
        obsGalvLPR = findViewById(R.id.ob_galv_est_lpr);

        ImageButton save = findViewById(R.id.siguiente_menu);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String obsTor = obsTorBLPR.getText().toString();
                String obsGalv = obsGalvLPR.getText().toString();
                storeEstructura(getTorbLimpieza, getTorbEstatus, getGalvLimpieza, getGalvEstatus);
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

    private void storeEstructura(boolean getTorbLimpieza, boolean getTorbEstatus, boolean getGalvLimpieza, boolean getGalvEstatus) {
        ApiService apiService = ApiClient.getClient();

        int idMantenimiento = AppData.getInstance().getIdMantenimiento();
        Call<EstResponseLPR> call = apiService.storeEstLPR(idMantenimiento, getTorbLimpieza, getTorbEstatus, getGalvLimpieza, getGalvEstatus);
        call.enqueue(new Callback<EstResponseLPR>() {
            @Override
            public void onResponse(Call<EstResponseLPR> call, Response<EstResponseLPR> response) {
                if (response.isSuccessful()){
                    EstResponseLPR estResponseLPR = response.body();
                    Toast.makeText(EstructuraLPR.this, "Registro guardado", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(EstructuraLPR.this, "Registro incorrecto", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<EstResponseLPR> call, Throwable t) {
                Toast.makeText(EstructuraLPR.this, "Error de conexión", Toast.LENGTH_SHORT).show();
            }
        });


    }
}