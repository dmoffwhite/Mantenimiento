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

public class EquipamientoLPR extends AppCompatActivity {

    private boolean getRadioLimpieza;
    private boolean getRadioEstatus;

    private EditText obsRadioEquipamientoLPR;

    private boolean getCamLimpieza;
    private boolean getCamEstatus;
    private  EditText obsCamEquipamientoLPR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equipamiento_lpr);

        CheckBox checkBoxLimpiezaRadioSI = findViewById(R.id.limpieza_rad_lpr_si);
        CheckBox checkBoxLimpiezaRadioNO = findViewById(R.id.limpieza_rad_lpr_no);
        CheckBox checkBoxEstatusRadioSI = findViewById(R.id.estatus_rad_lpr_si);
        CheckBox checkBoxEstatusRadioNO = findViewById(R.id.estatus_rad_lpr_no);


        CheckBox checkBoxLimpiezaCamSI = findViewById(R.id.limpieza_cam_lpr_si);
        CheckBox checkBoxLimpiezaCamNO = findViewById(R.id.limpieza_cam_lpr_no);
        CheckBox checkBoxEstatusCamSI = findViewById(R.id.estatus_cam_lpr_si);
        CheckBox checkBoxEstatusCamNO = findViewById(R.id.estatus_cam_lpr_no);

        checkBoxLimpiezaRadioSI.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                checkBoxLimpiezaRadioNO.setChecked(false);
                getRadioLimpieza = isChecked;

            }
        });

        checkBoxLimpiezaRadioNO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                checkBoxLimpiezaRadioSI.setChecked(false);
                getRadioLimpieza = !isChecked;

            }
        });


        checkBoxEstatusRadioSI.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                checkBoxEstatusRadioNO.setChecked(false);
                    getRadioEstatus = isChecked;

            }
        });

        checkBoxEstatusRadioNO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                checkBoxEstatusRadioSI.setChecked(false);
                getRadioEstatus = !isChecked;

            }
        });

        checkBoxLimpiezaCamSI.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                checkBoxLimpiezaCamNO.setChecked(false);
                getCamLimpieza = isChecked;
            }
        });

        checkBoxLimpiezaCamNO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                checkBoxLimpiezaCamSI.setChecked(false);
                getCamLimpieza = !isChecked;
            }
        });

        checkBoxEstatusCamSI.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                checkBoxEstatusCamNO.setChecked(false);
                getCamEstatus = isChecked;

            }
        });

        checkBoxEstatusCamNO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                checkBoxEstatusCamSI.setChecked(false);
                getCamEstatus = !isChecked;

            }
        });

        obsRadioEquipamientoLPR = findViewById(R.id.ob_rad_equi_lpr);
        obsCamEquipamientoLPR = findViewById(R.id.ob_cam_equi_lpr);

        ImageButton save = findViewById(R.id.siguiente_menu);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String obsRadio = obsRadioEquipamientoLPR.getText().toString();
                String obsCam = obsCamEquipamientoLPR.getText().toString();
                storeEquipamiento(getRadioLimpieza, getRadioEstatus, getCamLimpieza, getCamEstatus, obsRadio, obsCam);
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

    private void storeEquipamiento(boolean getRadioLimpieza, boolean getRadioEstatus, boolean getCamLimpieza, boolean getCamEstatus, String obsRadio, String obsCam) {
        ApiService apiService = ApiClient.getClient();
        int idMantenimiento = AppData.getInstance().getIdMantenimiento();

        Call<EquipResponseLPR> call = apiService.storeEquipLPR(idMantenimiento, getRadioLimpieza, getRadioEstatus, getCamLimpieza, getCamEstatus, obsRadio, obsCam);
        call.enqueue(new Callback<EquipResponseLPR>() {
            @Override
            public void onResponse(Call<EquipResponseLPR> call, Response<EquipResponseLPR> response) {
                if (response.isSuccessful()){
                    EquipResponseLPR equipamientoLPR = response.body();
                    Toast.makeText(EquipamientoLPR.this, "Registro guardado", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(EquipamientoLPR.this, "Registro incorrecto", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<EquipResponseLPR> call, Throwable t) {
                Toast.makeText(EquipamientoLPR.this, "Error en la conexión" + t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

    }
}