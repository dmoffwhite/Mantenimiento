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

public class CimentacionPMI extends AppCompatActivity {

    private  boolean getNivelLimpieza;
    private  boolean getNivelEstatus;
    private EditText obsNivelPMI;
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
        setContentView(R.layout.activity_cimentacion_pmi);

        CheckBox checkBoxLimpiezaNivSI = findViewById(R.id.limpieza_piso_si);
        CheckBox checkBoxLimpiezaNivNO = findViewById(R.id.limpieza_piso_no);
        CheckBox checkBoxEstatusNivSI = findViewById(R.id.estatus_piso_si);
        CheckBox checkBoxEstatusNivNO = findViewById(R.id.estatus_piso_no);

        CheckBox checkBoxLimpiezaAcabSI = findViewById(R.id.limpieza_sup_si);
        CheckBox checkBoxLimpiezaAcabNO = findViewById(R.id.limpieza_sup_no);
        CheckBox checkBoxEstatusAcabSI = findViewById(R.id.estatus_sup_si);
        CheckBox checkBoxEstatusAcabNO = findViewById(R.id.estatus_sup_no);

        CheckBox checkBoxLimpiezaExpSI = findViewById(R.id.limpieza_cim_si);
        CheckBox checkBoxLimpiezaExpNO = findViewById(R.id.limpieza_cim_no);
        CheckBox checkBoxEstatusExpSI = findViewById(R.id.estatus_cim_si);
        CheckBox checkBoxEstatusExpNO = findViewById(R.id.estatus_cim_no);

        CheckBox checkBoxLimpiezaGroSI = findViewById(R.id.limpieza_grout_si);
        CheckBox checkBoxLimpiezaGroNO = findViewById(R.id.limpieza_grout_no);
        CheckBox checkBoxEstatusGroSI = findViewById(R.id.estatus_grout_si);
        CheckBox checkBoxEstatusGroNO = findViewById(R.id.estatus_grout_no);

        checkBoxLimpiezaNivSI.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxLimpiezaNivSI.setChecked(false);
                    getNivelLimpieza = !isChecked;
                }
            }
        });

        checkBoxLimpiezaNivNO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxLimpiezaNivNO.setChecked(false);
                    getNivelLimpieza = isChecked;
                }
            }
        });

        checkBoxEstatusNivSI.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxEstatusNivSI.setChecked(false);
                    getNivelEstatus = !isChecked;
                }
            }
        });

        checkBoxEstatusNivNO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxEstatusNivNO.setChecked(false);
                    getNivelEstatus = isChecked;
                }
            }
        });

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

        obsNivelPMI = findViewById(R.id.ob_nvl_cim_pmi);
        obsSupPMI = findViewById(R.id.ob_acb_cim_pmi);
        obsExpPMI = findViewById(R.id.ob_sup_cim_pmi);
        obsGroutPMI = findViewById(R.id.ob_grout_cim_pmi);

        ImageButton save = findViewById(R.id.siguiente_menu);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String obsNivel = obsNivelPMI.getText().toString();
                String obsAcab = obsSupPMI.getText().toString();
                String obsExp = obsExpPMI.getText().toString();
                String obsGrout = obsGroutPMI.getText().toString();
                storeCimentacion(getNivelLimpieza, getNivelEstatus, getAcabLimpieza, getAcabEstatus, getExpLimpieza, getExpEstatus, getGroutLimpieza, getGroutEstatus);
                
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

    private void storeCimentacion(boolean getNivelLimpieza, boolean getNivelEstatus, boolean getAcabLimpieza, boolean getAcabEstatus, boolean getExpLimpieza, boolean getExpEstatus, boolean getGroutLimpieza, boolean getGroutEstatus) {
        ApiService apiService = ApiClient.getClient();

        int idMantenimiento = AppData.getInstance().getIdMantenimiento();

        Call<CimResponsePMI> call = apiService.storeCimentacionPMI(idMantenimiento,getNivelLimpieza, getNivelEstatus, getAcabLimpieza, getAcabEstatus, getExpLimpieza, getExpEstatus, getGroutLimpieza, getGroutEstatus);
        call.enqueue(new Callback<CimResponsePMI>() {
            @Override
            public void onResponse(Call<CimResponsePMI> call, Response<CimResponsePMI> response) {
                if (response.isSuccessful()){
                    CimResponsePMI cimResponsePMI = response.body();
                    Toast.makeText(CimentacionPMI.this, "Registro guardado", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(CimentacionPMI.this, "Registro incorrecto", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<CimResponsePMI> call, Throwable t) {
                Toast.makeText(CimentacionPMI.this, "Error de conexión", Toast.LENGTH_SHORT).show();
            }
        });
    }


}