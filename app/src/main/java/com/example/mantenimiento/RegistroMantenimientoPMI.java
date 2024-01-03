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

public class RegistroMantenimientoPMI extends AppCompatActivity {

    private boolean getGalvLimpieza;
    private boolean getGalvEstatus;
    private EditText obsGalvRegistroPMI;
    private boolean getTorxLimpieza;
    private boolean getTorxEstatus;
    private EditText obsTorxRegistroPMI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_mantenimiento_pmi);

        CheckBox checkBoxLimpiezaGalvSI = findViewById(R.id.limpieza_gal_si);
        CheckBox checkBoxLimpiezaGalvNO = findViewById(R.id.limpieza_gal_no);
        CheckBox checkBoxEstatusGalvSI = findViewById(R.id.estatus_gal_si);
        CheckBox checkBoxEstatusGalvNO = findViewById(R.id.estatus_gal_no);

        CheckBox checkBoxLimpiezaTorxSI = findViewById(R.id.limpieza_torx_si);
        CheckBox checkBoxLimpiezaTorxNO = findViewById(R.id.limpieza_torx_no);
        CheckBox checkBoxEstatusTorxSI = findViewById(R.id.estatus_torx_si);
        CheckBox checkBoxEstatusTorxNO = findViewById(R.id.estatus_torx_no);


        checkBoxLimpiezaGalvSI.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxLimpiezaGalvSI.setChecked(false);
                    getGalvLimpieza = !isChecked;
                }
            }
        });

        checkBoxLimpiezaGalvNO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxLimpiezaGalvNO.setChecked(false);
                    getGalvLimpieza = isChecked;
                }
            }
        });

        checkBoxEstatusGalvSI.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    checkBoxEstatusGalvSI.setChecked(false);
                    getGalvEstatus = !isChecked;
                }
            }
        });

        checkBoxEstatusGalvNO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    checkBoxEstatusGalvNO.setChecked(false);
                    getGalvEstatus = isChecked;
                }
            }
        });

        checkBoxLimpiezaTorxSI.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxLimpiezaTorxSI.setChecked(false);
                    getTorxLimpieza = !isChecked;
                }
            }
        });

        checkBoxLimpiezaTorxNO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxLimpiezaTorxNO.setChecked(false);
                    getTorxLimpieza = isChecked;
                }
            }
        });

        checkBoxEstatusTorxSI.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxEstatusTorxSI.setChecked(false);
                    getTorxEstatus = !isChecked;
                }
            }
        });

        checkBoxEstatusTorxNO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxEstatusTorxNO.setChecked(false);
                    getTorxEstatus = isChecked;
                }
            }
        });

        obsGalvRegistroPMI = findViewById(R.id.ob_gal_reg_pmi);
        obsTorxRegistroPMI = findViewById(R.id.ob_torx_reg_pmi);

        ImageButton save = findViewById(R.id.siguiente_menu);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String obsGalv = obsGalvRegistroPMI.getText().toString();
                String obsTorx = obsTorxRegistroPMI.getText().toString();
                storeRegistro(getGalvLimpieza, getGalvEstatus, getTorxLimpieza, getTorxEstatus, obsGalv, obsTorx);
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

    private void storeRegistro(boolean getGalvLimpieza, boolean getGalvEstatus, boolean getTorxLimpieza, boolean getTorxEstatus, String obsGalv, String obsTorx) {
    ApiService apiService = ApiClient.getClient();

    int idMantenimiento = AppData.getInstance().getIdMantenimiento();

        Call <RegistroResponsePMI> call = apiService.storeRegistroPMI(idMantenimiento, getGalvLimpieza, getGalvEstatus, getTorxLimpieza, getTorxEstatus, obsGalv, obsTorx);
        call.enqueue(new Callback<RegistroResponsePMI>() {
            @Override
            public void onResponse(Call<RegistroResponsePMI> call, Response<RegistroResponsePMI> response) {
                if (response.isSuccessful()){
                    RegistroResponsePMI registroResponsePMI = response.body();
                    Toast.makeText(RegistroMantenimientoPMI.this, "Registro guardado", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(RegistroMantenimientoPMI.this, "Registro incorrecto", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<RegistroResponsePMI> call, Throwable t) {
                Toast.makeText(RegistroMantenimientoPMI.this, "Error de conexión", Toast.LENGTH_SHORT).show();
            }
        });

    }
}