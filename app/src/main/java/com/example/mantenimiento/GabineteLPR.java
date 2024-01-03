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

public class GabineteLPR extends AppCompatActivity {

    private boolean getTubLicLimpieza;
    private boolean getTubLicEstatus;
    private EditText obsTubGabLPR;
    private boolean getTorSegLimpieza;
    private boolean getTorSegEstatus;
    private EditText obsTorSegGabLPR;
    private boolean getCabLimpieza;
    private boolean getCabEstatus;
    private EditText obsCabGabLPR;
    private boolean getExtLimpieza;
    private boolean getExtEstatus;
    private EditText obsExtGabLPR;
    private boolean getCierLimpieza;
    private boolean getCierEstatus;
    private EditText obsCierGabLPR;
    private boolean getCabNeuLimpieza;
    private boolean getCabNeuEstatus;
    private EditText obsCabNeuGabLPR;
    private boolean getVentLimpieza;
    private boolean getVentEstatus;
    private EditText obsVentGabLPR;
    private boolean getFiltLimpieza;
    private boolean getFiltEstatus;
    private EditText obsFiltGabLPR;
    private boolean getSilLimpieza;
    private boolean getSilEstatus;
    private EditText obsSilGabLPR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gabinete_lpr);

        CheckBox checkBoxLimpiezaTubSI = findViewById(R.id.limpieza_tub_lpr_si);
        CheckBox checkBoxLimpiezaTubNO = findViewById(R.id.limpieza_tub_lpr_no);
        CheckBox checkBoxEstatusTubSI = findViewById(R.id.estatus_tub_lpr_si);
        CheckBox checkBoxEstatusTubNO = findViewById(R.id.estatus_tub_lpr_no);

        CheckBox checkBoxLimpiezaSegSI = findViewById(R.id.limpieza_seg_lpr_si);
        CheckBox checkBoxLimpiezaSegNO = findViewById(R.id.limpieza_seg_lpr_no);
        CheckBox checkBoxEstatusSegSI = findViewById(R.id.estatus_seg_lpr_si);
        CheckBox checkBoxEstatusSegNO = findViewById(R.id.estatus_seg_lpr_no);

        CheckBox checkBoxLimpiezaCabSI = findViewById(R.id.limpieza_cab_lpr_si);
        CheckBox checkBoxLimpiezaCabNO = findViewById(R.id.limpieza_cab_lpr_no);
        CheckBox checkBoxEstatusCabSI = findViewById(R.id.estatus_cab_lpr_si);
        CheckBox checkBoxEstatusCabNO = findViewById(R.id.estatus_cab_lpr_no);

        CheckBox checkBoxLimpiezaExtSI = findViewById(R.id.limpieza_ext_lpr_si);
        CheckBox checkBoxLimpiezaExtNO = findViewById(R.id.limpieza_ext_lpr_no);
        CheckBox checkBoxEstatusExtSI = findViewById(R.id.estatus_ext_lpr_si);
        CheckBox checkBoxEstatusExtNO = findViewById(R.id.estatus_ext_lpr_no);

        CheckBox checkBoxLimpiezaCieSI = findViewById(R.id.limpieza_cier_lpr_si);
        CheckBox checkBoxLimpiezaCieNO = findViewById(R.id.limpieza_cier_lpr_no);
        CheckBox checkBoxEstatusCieSI = findViewById(R.id.estatus_cier_lpr_si);
        CheckBox checkBoxEstatusCieNO = findViewById(R.id.estatus_cier_lpr_no);

        CheckBox checkBoxLimpiezaCabnSI = findViewById(R.id.limpieza_cabn_lpr_si);
        CheckBox checkBoxLimpiezaCabnNO = findViewById(R.id.limpieza_cabn_lpr_no);
        CheckBox checkBoxEstatusCabnSI = findViewById(R.id.estatus_cabnc_lpr_si);
        CheckBox checkBoxEstatusCabnNO = findViewById(R.id.estatus_cabnc_lpr_no);

        CheckBox checkBoxLimpiezaVenSI = findViewById(R.id.limpieza_vent_lpr_si);
        CheckBox checkBoxLimpiezaVenNO = findViewById(R.id.limpieza_vent_lpr_no);
        CheckBox checkBoxEstatusVenSI = findViewById(R.id.estatus_vent_lpr_si);
        CheckBox checkBoxEstatusVenNO = findViewById(R.id.estatus_vent_lpr_no);

        CheckBox checkBoxLimpiezaFilSI = findViewById(R.id.limpieza_filt_lpr_si);
        CheckBox checkBoxLimpiezaFilNO = findViewById(R.id.limpieza_filt_lpr_no);
        CheckBox checkBoxEstatusFilSI = findViewById(R.id.estatus_filt_lpr_si);
        CheckBox checkBoxEstatusFilNO = findViewById(R.id.estatus_filt_lpr_no);

        CheckBox checkBoxLimpiezaSilSI = findViewById(R.id.limpieza_sil_si);
        CheckBox checkBoxLimpiezaSilNO = findViewById(R.id.limpieza_sil_no);
        CheckBox checkBoxEstatusSilSI = findViewById(R.id.estatus_sil_si);
        CheckBox checkBoxEstatusSilNO = findViewById(R.id.estatus_sil_no);

        checkBoxLimpiezaTubSI.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxLimpiezaTubSI.setChecked(false);
                    getTubLicLimpieza = !isChecked;
                }
            }
        });
        checkBoxLimpiezaTubNO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxLimpiezaTubNO.setChecked(false);
                    getTubLicLimpieza = isChecked;
                }
            }
        });

        checkBoxEstatusTubSI.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxEstatusTubSI.setChecked(false);
                    getTubLicEstatus = !isChecked;
                }
            }
        });

        checkBoxEstatusTubNO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxEstatusTubNO.setChecked(false);
                    getTubLicEstatus = isChecked;
                }
            }
        });

        checkBoxLimpiezaSegSI.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxLimpiezaSegSI.setChecked(false);
                    getTorSegLimpieza = !isChecked;
                }
            }
        });

        checkBoxLimpiezaSegNO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxLimpiezaSegNO.setChecked(false);
                    getTorSegLimpieza = isChecked;
                }
            }
        });

        checkBoxEstatusSegSI.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxEstatusSegSI.setChecked(false);
                    getTorSegEstatus = !isChecked;
                }
            }
        });


        checkBoxEstatusSegNO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxEstatusSegNO.setChecked(false);
                    getTorSegEstatus = isChecked;
                }
            }
        });

        checkBoxLimpiezaCabSI.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxLimpiezaCabSI.setChecked(false);
                    getCabLimpieza = !isChecked;
                }
            }
        });

        checkBoxLimpiezaCabNO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxLimpiezaCabNO.setChecked(false);
                    getCabLimpieza = isChecked;
                }
            }
        });

        checkBoxEstatusCabSI.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxEstatusCabSI.setChecked(false);
                    getCabEstatus = !isChecked;
                }
            }
        });

        checkBoxEstatusCabNO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxEstatusCabNO.setChecked(false);
                    getCabEstatus = isChecked;
                }
            }
        });

        checkBoxLimpiezaExtSI.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxLimpiezaExtSI.setChecked(false);
                    getExtLimpieza = !isChecked;
                }
            }
        });

        checkBoxLimpiezaExtNO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxLimpiezaExtNO.setChecked(false);
                    getExtLimpieza = isChecked;
                }
            }
        });

        checkBoxEstatusExtSI.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxEstatusExtSI.setChecked(false);
                    getExtEstatus = !isChecked;
                }
            }
        });

        checkBoxEstatusExtNO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxEstatusExtNO.setChecked(false);
                    getExtEstatus = isChecked;
                }
            }
        });

        checkBoxLimpiezaCieSI.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxLimpiezaCieSI.setChecked(false);
                    getCierLimpieza = !isChecked;
                }
            }
        });

        checkBoxLimpiezaCieNO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxLimpiezaCieNO.setChecked(false);
                    getCierLimpieza = isChecked;
                }
            }
        });

        checkBoxEstatusCieSI.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxEstatusCieSI.setChecked(false);
                    getCierEstatus = !isChecked;
                }
            }
        });

        checkBoxEstatusCieNO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxEstatusCieNO.setChecked(false);
                    getCierEstatus = isChecked;
                }
            }
        });

        checkBoxLimpiezaCabnSI.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxLimpiezaCabnSI.setChecked(false);
                    getCabNeuLimpieza = !isChecked;
                }
            }
        });

        checkBoxLimpiezaCabnNO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxLimpiezaCabnNO.setChecked(false);
                    getCabNeuLimpieza = isChecked;
                }
            }
        });

        checkBoxEstatusCabnSI.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxEstatusCabnSI.setChecked(false);
                    getCabNeuEstatus = !isChecked;
                }
            }
        });
        checkBoxEstatusCabnNO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxEstatusCabnNO.setChecked(false);
                    getCabNeuEstatus = isChecked;
                }
            }
        });

        checkBoxLimpiezaVenSI.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxLimpiezaVenSI.setChecked(false);
                    getVentLimpieza = !isChecked;
                }
            }
        });

        checkBoxLimpiezaVenNO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxLimpiezaVenNO.setChecked(false);
                    getVentLimpieza = isChecked;
                }
            }
        });

        checkBoxEstatusVenSI.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxEstatusVenSI.setChecked(false);
                    getVentEstatus = !isChecked;
                }
            }
        });

        checkBoxEstatusVenNO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxEstatusVenNO.setChecked(false);
                    getVentEstatus = isChecked;
                }
            }
        });

        checkBoxLimpiezaFilSI.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxLimpiezaFilSI.setChecked(false);
                    getFiltLimpieza = !isChecked;
                }
            }
        });

        checkBoxLimpiezaFilNO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxLimpiezaFilNO.setChecked(false);
                    getFiltLimpieza = isChecked;
                }
            }
        });

        checkBoxEstatusFilSI.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxEstatusFilSI.setChecked(false);
                    getFiltEstatus = !isChecked;
                }
            }
        });

        checkBoxEstatusFilNO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxEstatusFilNO.setChecked(false);
                    getFiltEstatus = isChecked;
                }
            }
        });

        checkBoxLimpiezaSilSI.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxLimpiezaSilSI.setChecked(false);
                    getSilLimpieza = !isChecked;
                }
            }
        });

        checkBoxLimpiezaSilNO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxLimpiezaSilNO.setChecked(false);
                    getSilLimpieza = isChecked;
                }
            }
        });

        checkBoxEstatusSilSI.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxEstatusSilSI.setChecked(false);
                    getSilEstatus = !isChecked;
                }
            }
        });

        checkBoxEstatusSilNO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxEstatusSilNO.setChecked(false);
                    getSilEstatus = isChecked;
                }
            }
        });

        obsTubGabLPR = findViewById(R.id.ob_tub_gab_lpr);
        obsTorSegGabLPR = findViewById(R.id.ob_seg_gab_lpr);
        obsCabGabLPR = findViewById(R.id.ob_cab_gab_lpr);
        obsExtGabLPR = findViewById(R.id.ob_ext_gab_lpr);
        obsCierGabLPR = findViewById(R.id.ob_cier_gab_lpr);
        obsCabNeuGabLPR = findViewById(R.id.ob_cabnC_gab_lpr);
        obsVentGabLPR = findViewById(R.id.ob_vent_ga_lpr);
        obsFiltGabLPR = findViewById(R.id.ob_filt_ga_lpr);
        obsSilGabLPR = findViewById(R.id.ob_sil_gab_lpr);

        ImageButton save = findViewById(R.id.siguiente_menu);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String obsTub = obsTubGabLPR.getText().toString();
                String obsTor = obsTorSegGabLPR.getText().toString();
                String obsCab = obsCabGabLPR.getText().toString();
                String obsExt = obsExtGabLPR.getText().toString();
                String obsCier = obsCierGabLPR.getText().toString();
                String obsCabN = obsCabNeuGabLPR.getText().toString();
                String obsVent = obsVentGabLPR.getText().toString();
                String obsFilt = obsFiltGabLPR.getText().toString();
                String obsSil = obsSilGabLPR.getText().toString();
                storeGabinete(getTubLicLimpieza, getTubLicEstatus, getTorSegLimpieza, getTorSegEstatus, getCabLimpieza, getCabEstatus, getExtLimpieza, getExtEstatus, getCierLimpieza, getCierEstatus, getCabNeuLimpieza, getCabNeuEstatus, getVentLimpieza, getVentEstatus, getFiltLimpieza, getFiltEstatus, getSilLimpieza, getSilEstatus);
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

    private void storeGabinete(boolean getTubLicLimpieza, boolean getTubLicEstatus, boolean getTorSegLimpieza, boolean getTorSegEstatus, boolean getCabLimpieza, boolean getCabEstatus, boolean getExtLimpieza, boolean getExtEstatus, boolean getCierLimpieza, boolean getCierEstatus, boolean getCabNeuLimpieza, boolean getCabNeuEstatus, boolean getVentLimpieza, boolean getVentEstatus, boolean getFiltLimpieza, boolean getFiltEstatus, boolean getSilLimpieza, boolean getSilEstatus) {
        ApiService apiService = ApiClient.getClient();

        int idMantenimiento = AppData.getInstance().getIdMantenimiento();
        Call<GabResponseLPR> call = apiService.storeGabLPR(idMantenimiento, getTubLicLimpieza, getTubLicEstatus, getTorSegLimpieza, getTorSegEstatus, getCabLimpieza, getCabEstatus, getExtLimpieza, getExtEstatus, getCierLimpieza, getCierEstatus, getCabNeuLimpieza, getCabNeuEstatus, getVentLimpieza, getVentEstatus, getFiltLimpieza, getFiltEstatus, getSilLimpieza, getSilEstatus);
        call.enqueue(new Callback<GabResponseLPR>() {
            @Override
            public void onResponse(Call<GabResponseLPR> call, Response<GabResponseLPR> response) {
                if (response.isSuccessful()){
                    GabResponseLPR gabResponseLPR = response.body();
                    Toast.makeText(GabineteLPR.this, "Registro guardado", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(GabineteLPR.this, "Registro incorrecto", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<GabResponseLPR> call, Throwable t) {
                Toast.makeText(GabineteLPR.this, "Error en la conexión" + t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });


    }
}