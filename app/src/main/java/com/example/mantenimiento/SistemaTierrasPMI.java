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

public class SistemaTierrasPMI extends AppCompatActivity {

    private boolean getNivelLimpieza;
    private boolean getNivelEstatus;
    private EditText obsNivelPMI;
    private boolean getRegistroLimpieza;
    private boolean getRegistroEstatus;
    private EditText obsRegistroPMI;
    private boolean getEstadoCLimpieza;
    private boolean getEstadoCEstado;
    private EditText obsEstadoPMI;
    private boolean getCablesNLimpieza;
    private boolean getCablesNEstatus;
    private EditText obsCablesPMI;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sistema_tierras_pmi);


        CheckBox checkBoxLimpiezaNivelSI = findViewById(R.id.limpieza_ban_si);
        CheckBox checkBoxLimpiezaNivelNO = findViewById(R.id.limpieza_ban_no);
        CheckBox checkBoxEstatusNivelSI = findViewById(R.id.estatus_ban_si);
        CheckBox checkBoxEstatusNivelNO = findViewById(R.id.estatus_ban_no);

        CheckBox checkBoxLimpiezaRegSI = findViewById(R.id.limpieza_reg_si);
        CheckBox checkBoxLimpiezaRegNO = findViewById(R.id.limpieza_reg_no);
        CheckBox checkBoxEstatusRegSI = findViewById(R.id.estatus_reg_si);
        CheckBox checkBoxEstatusRegNO = findViewById(R.id.estatus_reg_no);

        CheckBox checkBoxLimpiezaEstSI = findViewById(R.id.limpieza_estcon_si);
        CheckBox checkBoxLimpiezaEstNO = findViewById(R.id.limpieza_estcon_no);
        CheckBox checkBoxEstatusEstSI = findViewById(R.id.estatus_estcon_si);
        CheckBox checkBoxEstatusEstNO = findViewById(R.id.estatus_estcon_no);

        CheckBox checkBoxLimpiezaCabSI = findViewById(R.id.limpieza_cabn_si);
        CheckBox checkBoxLimpiezaCabNO = findViewById(R.id.limpieza_cabn_no);
        CheckBox checkBoxEstatusCabSI = findViewById(R.id.estatus_cabn_si);
        CheckBox checkBoxEstatusCabNO = findViewById(R.id.estatus_cabn_no);


        checkBoxLimpiezaNivelSI.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                    getNivelLimpieza = isChecked;

            }
        });

        checkBoxLimpiezaNivelNO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    getNivelLimpieza = !isChecked;
            }
        });

        checkBoxEstatusNivelSI.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                    getNivelEstatus = isChecked;

            }
        });

        checkBoxEstatusNivelNO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                    getNivelEstatus = !isChecked;

            }
        });

        checkBoxLimpiezaRegSI.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    getRegistroLimpieza = isChecked;

            }
        });

        checkBoxLimpiezaRegNO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    getRegistroLimpieza = !isChecked;


            }
        });

        checkBoxEstatusRegSI.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    getRegistroEstatus = isChecked;

            }
        });

        checkBoxEstatusRegNO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    getRegistroEstatus = !isChecked;

            }
        });

        checkBoxLimpiezaEstSI.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                    getEstadoCLimpieza = isChecked;

            }
        });

        checkBoxLimpiezaEstNO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                    getEstadoCLimpieza = !isChecked;

            }
        });

        checkBoxEstatusEstSI.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                    getEstadoCEstado = isChecked;

            }
        });

        checkBoxEstatusEstNO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                    getEstadoCEstado = !isChecked;

            }
        });

        checkBoxLimpiezaCabSI.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    getCablesNLimpieza = isChecked;

            }
        });

        checkBoxLimpiezaCabNO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                    getCablesNLimpieza = !isChecked;

            }
        });

        checkBoxEstatusCabSI.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                    getCablesNEstatus = isChecked;

            }
        });

        checkBoxEstatusCabNO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    getCablesNEstatus = !isChecked;
            }
        });

        obsNivelPMI = findViewById(R.id.ob_ban_tierra_pmi);
        obsRegistroPMI = findViewById(R.id.ob_reg_tierra_pmi);
        obsEstadoPMI = findViewById(R.id.ob_estcon_tierra_pmi);
        obsCablesPMI = findViewById(R.id.ob_cabn_tierra_pmi);

        ImageButton save = findViewById(R.id.siguiente_menu);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String obsNivel = obsNivelPMI.getText().toString();
                String obsRegistro = obsRegistroPMI.getText().toString();
                String obsEstado = obsEstadoPMI.getText().toString();
                String obsCables = obsCablesPMI.getText().toString();
                storeSistema(getNivelLimpieza, getNivelEstatus, getRegistroLimpieza, getRegistroEstatus, getEstadoCLimpieza, getEstadoCEstado, getCablesNLimpieza, getCablesNEstatus, obsNivel, obsRegistro, obsEstado, obsCables);
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

    private void storeSistema(boolean getNivelLimpieza, boolean getNivelEstatus, boolean getRegistroLimpieza, boolean getRegistroEstatus, boolean getEstadoCLimpieza, boolean getEstadoCEstado, boolean getCablesNLimpieza, boolean getCablesNEstatus, String obsNivel, String obsRegistro, String obsEstado, String obsCables) {
        ApiService apiService = ApiClient.getClient();

        int idMantenimiento = AppData.getInstance().getIdMantenimiento();

        Call<SistemaResponsePMI> call = apiService.storeSistemaPMI(idMantenimiento, getNivelLimpieza, getNivelEstatus, getRegistroLimpieza, getRegistroEstatus, getEstadoCLimpieza, getEstadoCEstado, getCablesNLimpieza, getCablesNEstatus, obsNivel, obsRegistro, obsEstado, obsCables);
        call.enqueue(new Callback<SistemaResponsePMI>() {
            @Override
            public void onResponse(Call<SistemaResponsePMI> call, Response<SistemaResponsePMI> response) {
                if (response.isSuccessful()){
                    SistemaResponsePMI sistemaResponsePMI = response.body();
                    Toast.makeText(SistemaTierrasPMI.this, "Registro guardado", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(SistemaTierrasPMI.this, "Registro incorrecto", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<SistemaResponsePMI> call, Throwable t) {
                Toast.makeText(SistemaTierrasPMI.this, "Error de conexión", Toast.LENGTH_SHORT).show();
            }
        });
    }
}