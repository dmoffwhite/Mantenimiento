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

public class EquipamientoPMI extends AppCompatActivity {

    private boolean getRadioLimpieza;
    private boolean getRadioEstatus;

    private EditText obsRadioEquipamientoPMI;
    private boolean getPTZLimpieza;
    private boolean getPTZEstatus;
    private EditText obsPTZEquipamientoPMI;
    private boolean getFijaLimpieza;
    private boolean getFijaEstatus;
    private EditText obsFijaEquipamientoPMI;
    private boolean getAnaliLimpieza;
    private boolean getAnaliEstatus;
    private EditText obsAnaliEquipamientoPMI;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equipamiento_pmi);

        CheckBox checkBoxLimpiezaRadioSI = findViewById(R.id.limpieza_rad_si);
        CheckBox checkBoxLimpiezaRadioNO = findViewById(R.id.limpieza_rad_no);
        CheckBox checkBoxEstatusRadioSI = findViewById(R.id.estatus_rad_si);
        CheckBox checkBoxEstatusRadioNO = findViewById(R.id.estatus_rad_no);

        CheckBox checkBoxLimpiezaPTZSI = findViewById(R.id.limpieza_ptz_si);
        CheckBox checkBoxLimpiezaPTZNO = findViewById(R.id.limpieza_ptz_no);
        CheckBox checkBoxEstatusPTZSI = findViewById(R.id.estatus_ptz_si);
        CheckBox checkBoxEstatusPTZNO = findViewById(R.id.estatus_ptz_no);

        CheckBox checkBoxLimpiezaFijaSI = findViewById(R.id.limpieza_fija_si);
        CheckBox checkBoxLimpiezaFijaNO = findViewById(R.id.limpieza_fija_no);
        CheckBox checkBoxEstatusFijaSI = findViewById(R.id.estatus_fija_si);
        CheckBox checkBoxEstatusFijaNO = findViewById(R.id.estatus_fija_no);

        CheckBox checkBoxLimpiezaAnSI = findViewById(R.id.limpieza_an_si);
        CheckBox checkBoxLimpiezaAnNO = findViewById(R.id.limpieza_an_no);
        CheckBox checkBoxEstatusAnSI = findViewById(R.id.estatus_an_si);
        CheckBox checkBoxEstatusAnNO = findViewById(R.id.estatus_an_no);

        checkBoxLimpiezaRadioSI.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxLimpiezaRadioSI.setChecked(false);
                    getRadioLimpieza = !isChecked;
                }

            }
        });

        checkBoxLimpiezaRadioNO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxLimpiezaRadioNO.setChecked(false);
                    getRadioLimpieza = isChecked;
                }
            }
        });

        checkBoxEstatusRadioSI.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxEstatusRadioSI.setChecked(false);
                    getRadioEstatus = !isChecked;
                }
            }
        });

        checkBoxEstatusRadioNO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxEstatusRadioNO.setChecked(false);
                    getRadioEstatus = isChecked;
                }
            }
        });

        checkBoxLimpiezaPTZSI.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxLimpiezaPTZSI.setChecked(false);
                    getPTZLimpieza = !isChecked;
                }
            }
        });

        checkBoxLimpiezaPTZNO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxLimpiezaPTZNO.setChecked(false);
                    getPTZLimpieza = !isChecked;
                }
            }
        });


        checkBoxEstatusPTZSI.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxEstatusPTZSI.setChecked(false);
                    getPTZEstatus = !isChecked;
                }
            }
        });

        checkBoxEstatusPTZNO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxEstatusPTZNO.setChecked(false);
                    getPTZEstatus = isChecked;
                }
            }
        });

        checkBoxLimpiezaFijaSI.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    checkBoxLimpiezaFijaSI.setChecked(false);
                    getFijaLimpieza = !isChecked;
                }
            }
        });

        checkBoxLimpiezaFijaNO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    checkBoxLimpiezaFijaNO.setChecked(false);
                    getFijaLimpieza = isChecked;
                }
            }
        });

        checkBoxEstatusFijaSI.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    checkBoxEstatusFijaSI.setChecked(false);
                    getFijaEstatus = !isChecked;
                }
            }
        });

        checkBoxEstatusFijaNO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    checkBoxEstatusFijaNO.setChecked(false);
                    getFijaEstatus = isChecked;
                }
            }
        });

        checkBoxLimpiezaAnSI.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxLimpiezaAnSI.setChecked(false);
                    getAnaliLimpieza = !isChecked;
                }
            }
        });

        checkBoxLimpiezaAnNO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxLimpiezaAnNO.setChecked(false);
                    getAnaliLimpieza = isChecked;
                }
            }
        });

        checkBoxEstatusAnSI.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxEstatusAnSI.setChecked(false);
                    getAnaliEstatus = !isChecked;
                }
            }
        });

        checkBoxEstatusAnNO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxEstatusAnNO.setChecked(false);
                    getAnaliEstatus = isChecked;
                }
            }
        });

        obsRadioEquipamientoPMI = findViewById(R.id.ob_rad_equi_pmi);
        obsPTZEquipamientoPMI = findViewById(R.id.ob_ptz_equi_pmi);
        obsFijaEquipamientoPMI = findViewById(R.id.ob_fija_equi_pmi);
        obsAnaliEquipamientoPMI = findViewById(R.id.ob_an_equi_pmi);

        ImageButton save = findViewById(R.id.siguiente_menu);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String obsRadio = obsRadioEquipamientoPMI.getText().toString();
                String obsPTZ = obsPTZEquipamientoPMI.getText().toString();
                String obsFija = obsFijaEquipamientoPMI.getText().toString();
                String obsAna = obsAnaliEquipamientoPMI.getText().toString();
                storeEquipamiento(getRadioLimpieza, getRadioEstatus, getPTZLimpieza, getPTZEstatus, getFijaLimpieza, getFijaEstatus, getAnaliLimpieza, getAnaliEstatus, obsRadio, obsPTZ, obsFija, obsAna);
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

    private void storeEquipamiento(boolean getRadioLimpieza, boolean getRadioEstatus, boolean getPTZLimpieza, boolean getPTZEstatus, boolean getFijaLimpieza, boolean getFijaEstatus, boolean getAnaliLimpieza, boolean getAnaliEstatus, String obsRadio, String obsPTZ, String obsFija, String obsAna) {
        ApiService apiService = ApiClient.getClient();
        int idMantenimiento = AppData.getInstance().getIdMantenimiento();

        Call<EquipResponsePMI> call = apiService.storeEquipPMI(idMantenimiento, getRadioLimpieza, getRadioEstatus, getPTZLimpieza, getPTZEstatus, getFijaLimpieza, getFijaEstatus, getAnaliLimpieza, getAnaliEstatus, obsRadio, obsPTZ, obsFija, obsAna);
        call.enqueue(new Callback<EquipResponsePMI>() {
            @Override
            public void onResponse(Call<EquipResponsePMI> call, Response<EquipResponsePMI> response) {
                if (response.isSuccessful()){
                    EquipResponsePMI equipResponsePMI = response.body();
                    Toast.makeText(EquipamientoPMI.this, "Registro guardado", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(EquipamientoPMI.this, "Registro no guardado", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<EquipResponsePMI> call, Throwable t) {
                Toast.makeText(EquipamientoPMI.this, "Error en la conexión" + t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}