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

public class CimentacionLPR extends AppCompatActivity {

    private boolean getAcabLimpieza;
    private boolean getAcabEstatus;
    private EditText obsSupPMI;
    private boolean getExpLimpieza;
    private boolean getExpEstatus;
    private EditText obsExpPMI;
    private boolean getGroutLimpieza;
    private boolean getGroutEstatus;
    private EditText obsGroutPMI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cimentacion_lpr);

        CheckBox checkBoxLimpiezaAcabSI = findViewById(R.id.limpieza_sup_lpr_si);
        CheckBox checkBoxLimpiezaAcabNO = findViewById(R.id.limpieza_sup_lpr_no);
        CheckBox checkBoxEstatusAcabSI = findViewById(R.id.estatus_sup_lpr_si);
        CheckBox checkBoxEstatusAcabNO = findViewById(R.id.estatus_sup_lpr_no);

        CheckBox checkBoxLimpiezaExpSI = findViewById(R.id.limpieza_cim_lpr_si);
        CheckBox checkBoxLimpiezaExpNO = findViewById(R.id.limpieza_cim_lpr_no);
        CheckBox checkBoxEstatusExpSI = findViewById(R.id.estatus_cim_lpr_si);
        CheckBox checkBoxEstatusExpNO = findViewById(R.id.estatus_cim_lpr_no);

        CheckBox checkBoxLimpiezaGroSI = findViewById(R.id.limpieza_grout_lpr_si);
        CheckBox checkBoxLimpiezaGroNO = findViewById(R.id.limpieza_grout_lpr_no);
        CheckBox checkBoxEstatusGroSI = findViewById(R.id.estatus_grout_lpr_si);
        CheckBox checkBoxEstatusGroNO = findViewById(R.id.estatus_grout_lpr_no);


        checkBoxLimpiezaAcabSI.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxLimpiezaAcabSI.setChecked(false);
                    getAcabLimpieza = !isChecked;
                }
            }
        });

        checkBoxLimpiezaAcabNO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxLimpiezaAcabNO.setChecked(false);
                    getAcabLimpieza = isChecked;
                }
            }
        });

        checkBoxEstatusAcabSI.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxEstatusAcabSI.setChecked(false);
                    getAcabEstatus = !isChecked;
                }
            }
        });

        checkBoxEstatusAcabNO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxEstatusAcabNO.setChecked(false);
                    getAcabEstatus = isChecked;
                }
            }
        });

        checkBoxLimpiezaExpSI.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    checkBoxLimpiezaExpSI.setChecked(false);
                    getExpLimpieza = !isChecked;
                }
            }
        });

        checkBoxLimpiezaExpNO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    checkBoxLimpiezaExpNO.setChecked(false);
                    getExpLimpieza = isChecked;
                }
            }
        });

        checkBoxEstatusExpSI.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxEstatusExpSI.setChecked(false);
                    getExpEstatus = !isChecked;
                }
            }
        });

        checkBoxEstatusExpNO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxEstatusExpNO.setChecked(false);
                    getExpEstatus = isChecked;
                }
            }
        });

        checkBoxLimpiezaGroSI.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxLimpiezaGroSI.setChecked(false);
                    getGroutLimpieza = !isChecked;
                }
            }
        });

        checkBoxLimpiezaGroNO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxLimpiezaGroNO.setChecked(false);
                    getGroutLimpieza = isChecked;
                }
            }
        });

        checkBoxEstatusGroSI.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxEstatusGroSI.setChecked(false);
                    getGroutEstatus = !isChecked;
                }
            }
        });

        checkBoxEstatusGroNO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxEstatusGroNO.setChecked(false);
                    getGroutEstatus = isChecked;
                }
            }
        });

        obsSupPMI = findViewById(R.id.ob_acb_cim_lpr_pmi);
        obsExpPMI = findViewById(R.id.ob_sup_cim_lpr_pmi);
        obsGroutPMI = findViewById(R.id.ob_grout_cim_lpr_pmi);

        ImageButton save = findViewById(R.id.siguiente_menu);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String obsAcab = obsSupPMI.getText().toString();
                String obsExp = obsExpPMI.getText().toString();
                String obsGrout = obsGroutPMI.getText().toString();
                storeCimentacion(getAcabLimpieza, getAcabEstatus, getExpLimpieza, getExpEstatus, getGroutLimpieza, getGroutEstatus, obsAcab, obsExp, obsGrout);

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

    private void storeCimentacion(boolean getAcabLimpieza, boolean getAcabEstatus, boolean getExpLimpieza, boolean getExpEstatus, boolean getGroutLimpieza, boolean getGroutEstatus, String obsAcab, String obsExp, String obsGrout) {
        ApiService apiService = ApiClient.getClient();

        int idMantenimiento = AppData.getInstance().getIdMantenimiento();
        Call<CimResponseLPR> call = apiService.storeCimLPR(idMantenimiento, getAcabLimpieza, getAcabEstatus, getExpLimpieza, getExpEstatus, getGroutLimpieza, getGroutEstatus, obsAcab, obsExp, obsGrout);
        call.enqueue(new Callback<CimResponseLPR>() {
            @Override
            public void onResponse(Call<CimResponseLPR> call, Response<CimResponseLPR> response) {
                if (response.isSuccessful()){
                    CimResponseLPR cimResponseLPR = response.body();
                    Toast.makeText(CimentacionLPR.this, "Registro guardado", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(CimentacionLPR.this, "Registro incorrecto", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<CimResponseLPR> call, Throwable t) {
                Toast.makeText(CimentacionLPR.this, "Error de conexión", Toast.LENGTH_SHORT).show();
            }
        });
    }
}