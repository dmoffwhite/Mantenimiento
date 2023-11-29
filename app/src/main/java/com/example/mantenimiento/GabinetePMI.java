package com.example.mantenimiento;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GabinetePMI extends AppCompatActivity {

    private boolean geTuberiaLimpieza;
    private boolean geTuberiaEstatus;

    private boolean getTapaLimpieza;
    private boolean getTapaEstatus;
    private boolean getCabInLimpieza;
    private boolean getCabInEstatus;
    private boolean getExteriorLimpieza;
    private boolean getExteriorEstatus;
    private boolean getFijacionLimpieza;
    private boolean getFijacionEstatus;
    private boolean getOrientacionLimpieza;
    private boolean getOrientacionEstatus;
    private boolean getCablenNLimpieza;
    private boolean getCableNEstatus;
    private boolean getVentiladorLimpieza;
    private boolean getVentiladorEstatus;
    private boolean getFiltrosLimpieza;
    private boolean getFiltrosEstatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gabinete_pmi);

        CheckBox checkBoxLimpiezaTuberiaSI = findViewById(R.id.limpieza_tublic_si);
        CheckBox checkBoxLimpiezaTuberiaNO = findViewById(R.id.limpieza_tublic_no);
        CheckBox checkBoxEstatusTuberiaSI = findViewById(R.id.estatus_tublic_si);
        CheckBox checkBoxEstatusTuberiaNO = findViewById(R.id.estatus_tublic_no);

        CheckBox checkBoxLimpiezaTapaSI = findViewById(R.id.limpieza_tap_si);
        CheckBox checkBoxLimpiezaTapaNO = findViewById(R.id.limpieza_tap_no);
        CheckBox checkBoxEstatusTapaSI = findViewById(R.id.estatus_tap_si);
        CheckBox checkBoxEstatusTapaNO = findViewById(R.id.estatus_tap_no);

        CheckBox checkBoxCablesLimpiezaSI = findViewById(R.id.limpieza_int_si);
        CheckBox checkBoxCablesLimpiezaNO = findViewById(R.id.limpieza_int_no);
        CheckBox checkBoxCablesEstatusSI = findViewById(R.id.estatus_int_si);
        CheckBox checkBoxCablesEstatusNO = findViewById(R.id.estatus_int_no);

        CheckBox checkBoxExtLimpiezaSI = findViewById(R.id.limpieza_ext_si);
        CheckBox checkBoxExtLimpiezaNO = findViewById(R.id.limpieza_ext_no);
        CheckBox checkBoxExtEstatusSI = findViewById(R.id.estatus_ext_si);
        CheckBox checkBoxExtEstatusNO = findViewById(R.id.estatus_ext_no);

        CheckBox checkBoxFijLimpiezaSI = findViewById(R.id.limpieza_fijc_si);
        CheckBox checkBoxFijLimpiezaNO = findViewById(R.id.limpieza_fijc_no);
        CheckBox checkBoxFijEstatusSI = findViewById(R.id.estatus_fijc_si);
        CheckBox checkBoxFijEstatusNO = findViewById(R.id.estatus_fijc_no);

        CheckBox checkBoxOriLimpiezaSI = findViewById(R.id.limpieza_ori_si);
        CheckBox checkBoxOriLimpiezaNO = findViewById(R.id.limpieza_ori_no);
        CheckBox checkBoxOriEstatusSI = findViewById(R.id.estatus_ori_si);
        CheckBox checkBoxOriEstatusNO = findViewById(R.id.estatus_ori_no);

        CheckBox checkBoxCableLimpiezaSI = findViewById(R.id.limpieza_neu_si);
        CheckBox checkBoxCableLimpiezaNO = findViewById(R.id.limpieza_neu_no);
        CheckBox checkBoxCableEstatusSI = findViewById(R.id.estatus_neu_si);
        CheckBox checkBoxCableEstatusNO = findViewById(R.id.estatus_neu_no);

        CheckBox checkBoxVentLimpiezaSI = findViewById(R.id.limpieza_vent_si);
        CheckBox checkBoxVentLimpiezaNO = findViewById(R.id.limpieza_vent_no);
        CheckBox checkBoxVentEstatusSI = findViewById(R.id.estatus_vent_si);
        CheckBox checkBoxVentEstatusNO = findViewById(R.id.estatus_vent_no);

        CheckBox checkBoxFiltrLimpiezaSI = findViewById(R.id.limpieza_filt_si);
        CheckBox checkBoxFiltrLimpiezaNO = findViewById(R.id.limpieza_filt_no);
        CheckBox checkBoxFiltrEstatusSI = findViewById(R.id.estatus_filt_si);
        CheckBox checkBoxFiltrEstatusNO = findViewById(R.id.estatus_filt_no);


        checkBoxLimpiezaTuberiaSI.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxLimpiezaTuberiaSI.setChecked(false);
                    geTuberiaLimpieza = !isChecked;
                }
            }
        });

        checkBoxLimpiezaTuberiaNO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxLimpiezaTuberiaNO.setChecked(false);
                    geTuberiaLimpieza = isChecked;
                }
            }
        });

        checkBoxEstatusTuberiaSI.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxEstatusTuberiaSI.setChecked(false);
                    geTuberiaEstatus = !isChecked;
                }
            }
        });

        checkBoxEstatusTuberiaNO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxEstatusTuberiaNO.setChecked(false);
                    geTuberiaEstatus = isChecked;
                }
            }
        });



        checkBoxLimpiezaTapaSI.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxLimpiezaTapaSI.setChecked(false);
                    getTapaLimpieza = !isChecked;
                }
            }
        });

        checkBoxLimpiezaTapaNO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxLimpiezaTapaNO.setChecked(false);
                    getTapaLimpieza = isChecked;
                }
            }
        });

        checkBoxEstatusTapaSI.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxEstatusTapaSI.setChecked(false);
                    getTapaEstatus = !isChecked;
                }
            }
        });

        checkBoxEstatusTapaNO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxEstatusTapaNO.setChecked(false);
                    getTapaEstatus = isChecked;
                }
            }
        });

        checkBoxCablesLimpiezaSI.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxCablesLimpiezaSI.setChecked(false);
                    getCabInLimpieza = !isChecked;
                }
            }
        });

        checkBoxCablesLimpiezaNO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxCablesLimpiezaNO.setChecked(false);
                    getCabInLimpieza = isChecked;
                }
            }
        });

        checkBoxCablesEstatusSI.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxCablesEstatusSI.setChecked(false);
                    getCabInEstatus = !isChecked;
                }
            }
        });

        checkBoxCablesEstatusNO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxCablesEstatusNO.setChecked(false);
                    getCabInEstatus = isChecked;
                }
            }
        });


        checkBoxExtLimpiezaSI.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxExtLimpiezaSI.setChecked(false);
                    getExteriorLimpieza = !isChecked;
                }
            }
        });

        checkBoxExtLimpiezaNO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxExtLimpiezaNO.setChecked(false);
                    getExteriorLimpieza = isChecked;
                }
            }
        });

        checkBoxExtEstatusSI.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxExtEstatusSI.setChecked(false);
                    getExteriorEstatus = !isChecked;
                }
            }
        });

        checkBoxExtEstatusNO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxExtEstatusNO.setChecked(false);
                    getExteriorEstatus = isChecked;
                }
            }
        });

        checkBoxFijLimpiezaSI.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxFijLimpiezaSI.setChecked(false);
                    getFijacionLimpieza = !isChecked;
                }
            }
        });

        checkBoxFijLimpiezaNO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxFijLimpiezaNO.setChecked(false);
                    getFijacionLimpieza = isChecked;
                }
            }
        });

        checkBoxFijEstatusSI.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxFijEstatusSI.setChecked(false);
                    getFijacionEstatus = !isChecked;
                }
            }
        });

        checkBoxFijEstatusNO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxFijEstatusNO.setChecked(false);
                    getFijacionEstatus = isChecked;
                }
            }
        });

        checkBoxOriLimpiezaSI.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxOriLimpiezaSI.setChecked(false);
                    getOrientacionLimpieza = !isChecked;
                }
            }
        });

        checkBoxOriLimpiezaNO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxOriLimpiezaNO.setChecked(false);
                    getOrientacionLimpieza = isChecked;
                }
            }
        });

        checkBoxOriEstatusSI.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxOriEstatusSI.setChecked(false);
                    getOrientacionEstatus = !isChecked;
                }
            }
        });

        checkBoxOriEstatusNO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxOriEstatusNO.setChecked(false);
                    getOrientacionEstatus = isChecked;
                }
            }
        });

        checkBoxCableLimpiezaSI.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxCableLimpiezaSI.setChecked(false);
                    getCablenNLimpieza = !isChecked;
                }
            }
        });

        checkBoxCableLimpiezaSI.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxCableLimpiezaSI.setChecked(false);
                    getCablenNLimpieza = !isChecked;
                }
            }
        });

        checkBoxCableLimpiezaNO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxCableLimpiezaNO.setChecked(false);
                    getCablenNLimpieza = isChecked;
                }
            }
        });

        checkBoxCableEstatusSI.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxCableEstatusSI.setChecked(false);
                    getCableNEstatus = !isChecked;
                }
            }
        });

        checkBoxCableEstatusNO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxCableEstatusNO.setChecked(false);
                    getCableNEstatus = isChecked;
                }
            }
        });

        checkBoxVentLimpiezaSI.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxVentLimpiezaSI.setChecked(false);
                    getVentiladorLimpieza = !isChecked;
                }
            }
        });

        checkBoxVentLimpiezaNO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxVentLimpiezaNO.setChecked(false);
                    getVentiladorLimpieza = isChecked;
                }
            }
        });

        checkBoxVentEstatusSI.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxVentEstatusSI.setChecked(false);
                    getVentiladorEstatus = !isChecked;
                }
            }
        });

        checkBoxVentEstatusNO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxVentEstatusNO.setChecked(false);
                    getVentiladorEstatus = isChecked;
                }
            }
        });

        checkBoxFiltrLimpiezaSI.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxFiltrLimpiezaSI.setChecked(false);
                    getFiltrosLimpieza = !isChecked;
                }
            }
        });

        checkBoxFiltrLimpiezaNO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxFiltrLimpiezaNO.setChecked(false);
                    getFiltrosLimpieza = isChecked;
                }
            }
        });

        checkBoxFiltrEstatusSI.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxFiltrEstatusSI.setChecked(false);
                    getFiltrosEstatus = !isChecked;
                }
            }
        });

        checkBoxFiltrEstatusNO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxFiltrEstatusNO.setChecked(false);
                    getFiltrosEstatus = isChecked;
                }
            }
        });

        ImageButton save = findViewById(R.id.siguiente_menu);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                storeGabinete(geTuberiaLimpieza, geTuberiaEstatus, getTapaLimpieza, getTapaEstatus, getCabInLimpieza, getCabInEstatus, getExteriorLimpieza, getExteriorEstatus, getFijacionLimpieza, getFijacionEstatus, getOrientacionLimpieza, getOrientacionEstatus, getCablenNLimpieza, getCableNEstatus, getVentiladorLimpieza, getVentiladorEstatus, getFiltrosLimpieza, getFiltrosEstatus);
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

    private void storeGabinete(boolean geTuberiaLimpieza, boolean geTuberiaEstatus, boolean getTapaLimpieza, boolean getTapaEstatus, boolean getCabInLimpieza, boolean getCabInEstatus, boolean getExteriorLimpieza, boolean getExteriorEstatus, boolean getFijacionLimpieza, boolean getFijacionEstatus, boolean getOrientacionLimpieza, boolean getOrientacionEstatus, boolean getCablenNLimpieza, boolean getCableNEstatus, boolean getVentiladorLimpieza, boolean getVentiladorEstatus, boolean getFiltrosLimpieza, boolean getFiltrosEstatus) {
        ApiService apiService = ApiClient.getClient();

        int idMantenimiento = AppData.getInstance().getIdMantenimiento();

        Call<GabResponsePMI> call = apiService.storeGabPMI(idMantenimiento, geTuberiaLimpieza, geTuberiaEstatus, getTapaLimpieza, getTapaEstatus, getCabInLimpieza, getCabInEstatus, getExteriorLimpieza, getExteriorEstatus, getFijacionLimpieza, getFijacionEstatus, getOrientacionLimpieza, getOrientacionEstatus, getCablenNLimpieza, getCableNEstatus, getVentiladorLimpieza, getVentiladorEstatus, getFiltrosLimpieza, getFiltrosEstatus);
        call.enqueue(new Callback<GabResponsePMI>() {
            @Override
            public void onResponse(Call<GabResponsePMI> call, Response<GabResponsePMI> response) {
                if (response.isSuccessful()){
                    GabResponsePMI gabResponsePMI = response.body();
                    Toast.makeText(GabinetePMI.this, "Registro guardado", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(GabinetePMI.this, "Registro incorrecto", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<GabResponsePMI> call, Throwable t) {
                Toast.makeText(GabinetePMI.this, "Error de conexión", Toast.LENGTH_SHORT).show();
            }
        });
    }
}