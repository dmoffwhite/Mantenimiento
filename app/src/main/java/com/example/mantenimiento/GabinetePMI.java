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

public class GabinetePMI extends AppCompatActivity {

    private boolean geTuberiaLimpieza;
    private boolean geTuberiaEstatus;
    private EditText obsTubPMI;

    private boolean getTapaLimpieza;
    private boolean getTapaEstatus;
    private EditText obsTapaPMI;
    private boolean getCabInLimpieza;
    private boolean getCabInEstatus;
    private EditText obsCabInPMI;
    private boolean getExteriorLimpieza;
    private boolean getExteriorEstatus;
    private EditText obsExteriorPMI;
    private boolean getFijacionLimpieza;
    private boolean getFijacionEstatus;
    private EditText obsFijacionPMI;
    private boolean getOrientacionLimpieza;
    private boolean getOrientacionEstatus;
    private EditText obsOrientacionPMI;
    private boolean getCablenNLimpieza;
    private boolean getCableNEstatus;
    private EditText obsCablePMI;
    private boolean getVentiladorLimpieza;
    private boolean getVentiladorEstatus;
    private EditText obsVentiladorPMI;
    private boolean getFiltrosLimpieza;
    private boolean getFiltrosEstatus;
    private EditText obsFiltrosPMI;

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
                    geTuberiaLimpieza = isChecked;

            }
        });

        checkBoxLimpiezaTuberiaNO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    geTuberiaLimpieza = !isChecked;

            }
        });

        checkBoxEstatusTuberiaSI.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    geTuberiaEstatus = isChecked;

            }
        });

        checkBoxEstatusTuberiaNO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                    geTuberiaEstatus = !isChecked;

            }
        });



        checkBoxLimpiezaTapaSI.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    getTapaLimpieza = isChecked;

            }
        });

        checkBoxLimpiezaTapaNO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    getTapaLimpieza = !isChecked;

            }
        });

        checkBoxEstatusTapaSI.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    getTapaEstatus = isChecked;

            }
        });

        checkBoxEstatusTapaNO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    getTapaEstatus = !isChecked;

            }
        });

        checkBoxCablesLimpiezaSI.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    getCabInLimpieza = isChecked;

            }
        });

        checkBoxCablesLimpiezaNO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    getCabInLimpieza = !isChecked;
            }
        });

        checkBoxCablesEstatusSI.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    getCabInEstatus = isChecked;

            }
        });

        checkBoxCablesEstatusNO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    getCabInEstatus = !isChecked;

            }
        });


        checkBoxExtLimpiezaSI.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    getExteriorLimpieza = isChecked;

            }
        });

        checkBoxExtLimpiezaNO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    getExteriorLimpieza = !isChecked;

            }
        });

        checkBoxExtEstatusSI.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    getExteriorEstatus = isChecked;

            }
        });

        checkBoxExtEstatusNO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    getExteriorEstatus = !isChecked;

            }
        });

        checkBoxFijLimpiezaSI.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    getFijacionLimpieza = isChecked;

            }
        });

        checkBoxFijLimpiezaNO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    getFijacionLimpieza = !isChecked;

            }
        });

        checkBoxFijEstatusSI.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    getFijacionEstatus = isChecked;
            }
        });

        checkBoxFijEstatusNO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    getFijacionEstatus = !isChecked;

            }
        });

        checkBoxOriLimpiezaSI.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    getOrientacionLimpieza = isChecked;
            }
        });

        checkBoxOriLimpiezaNO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    getOrientacionLimpieza = !isChecked;

            }
        });

        checkBoxOriEstatusSI.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    getOrientacionEstatus = isChecked;

            }
        });

        checkBoxOriEstatusNO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    getOrientacionEstatus = !isChecked;

            }
        });

        checkBoxCableLimpiezaSI.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    getCablenNLimpieza = isChecked;

            }
        });


        checkBoxCableLimpiezaNO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    getCablenNLimpieza = !isChecked;

            }
        });

        checkBoxCableEstatusSI.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    getCableNEstatus = isChecked;
            }
        });

        checkBoxCableEstatusNO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    getCableNEstatus = !isChecked;

            }
        });

        checkBoxVentLimpiezaSI.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    getVentiladorLimpieza = isChecked;

            }
        });

        checkBoxVentLimpiezaNO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    getVentiladorLimpieza = !isChecked;

            }
        });

        checkBoxVentEstatusSI.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    getVentiladorEstatus = isChecked;

            }
        });

        checkBoxVentEstatusNO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    getVentiladorEstatus = !isChecked;

            }
        });

        checkBoxFiltrLimpiezaSI.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    getFiltrosLimpieza = isChecked;

            }
        });

        checkBoxFiltrLimpiezaNO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    getFiltrosLimpieza = !isChecked;
            }
        });

        checkBoxFiltrEstatusSI.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                    getFiltrosEstatus = isChecked;

            }
        });

        checkBoxFiltrEstatusNO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    getFiltrosEstatus = !isChecked;

            }
        });

        obsTubPMI = findViewById(R.id.ob_tuli_ga_pmi);
        obsTapaPMI = findViewById(R.id.ob_tap_ga_pmi);
        obsCabInPMI = findViewById(R.id.ob_cai_ga_pmi);
        obsExteriorPMI = findViewById(R.id.ob_ext_ga_pmi);
        obsFijacionPMI = findViewById(R.id.ob_fija_ga_pmi);
        obsOrientacionPMI = findViewById(R.id.ob_ori_ga_pmi);
        obsCablePMI = findViewById(R.id.ob_neu_ga_pmi);
        obsVentiladorPMI = findViewById(R.id.ob_vent_ga_pmi);
        obsFiltrosPMI = findViewById(R.id.ob_filt_ga_pmi);



        ImageButton save = findViewById(R.id.siguiente_menu);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String obsTub = obsTubPMI.getText().toString();
                String obsTapa = obsTapaPMI.getText().toString();
                String obsCabIn = obsCabInPMI.getText().toString();
                String obsExt = obsExteriorPMI.getText().toString();
                String obsFijacion = obsFijacionPMI.getText().toString();
                String obsOrientacion = obsOrientacionPMI.getText().toString();
                String obsCable = obsCablePMI.getText().toString();
                String obsVentilador = obsVentiladorPMI.getText().toString();
                String obsFiltros = obsFiltrosPMI.getText().toString();

                storeGabinete(geTuberiaLimpieza, geTuberiaEstatus, getTapaLimpieza, getTapaEstatus, getCabInLimpieza, getCabInEstatus, getExteriorLimpieza, getExteriorEstatus, getFijacionLimpieza, getFijacionEstatus, getOrientacionLimpieza, getOrientacionEstatus, getCablenNLimpieza, getCableNEstatus, getVentiladorLimpieza, getVentiladorEstatus, getFiltrosLimpieza, getFiltrosEstatus, obsTub, obsTapa, obsCabIn, obsExt, obsFijacion, obsOrientacion, obsCable, obsVentilador, obsFiltros);
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

    private void storeGabinete(boolean geTuberiaLimpieza, boolean geTuberiaEstatus, boolean getTapaLimpieza, boolean getTapaEstatus, boolean getCabInLimpieza, boolean getCabInEstatus, boolean getExteriorLimpieza, boolean getExteriorEstatus, boolean getFijacionLimpieza, boolean getFijacionEstatus, boolean getOrientacionLimpieza, boolean getOrientacionEstatus, boolean getCablenNLimpieza, boolean getCableNEstatus, boolean getVentiladorLimpieza, boolean getVentiladorEstatus, boolean getFiltrosLimpieza, boolean getFiltrosEstatus, String obsTub, String obsTapa, String obsCabIn, String obsExt, String obsFijacion, String obsOrientacion, String obsCable, String obsVentilador, String obsFiltros) {
        ApiService apiService = ApiClient.getClient();

        int idMantenimiento = AppData.getInstance().getIdMantenimiento();

        Call<GabResponsePMI> call = apiService.storeGabPMI(idMantenimiento, geTuberiaLimpieza, geTuberiaEstatus, getTapaLimpieza, getTapaEstatus, getCabInLimpieza, getCabInEstatus, getExteriorLimpieza, getExteriorEstatus, getFijacionLimpieza, getFijacionEstatus, getOrientacionLimpieza, getOrientacionEstatus, getCablenNLimpieza, getCableNEstatus, getVentiladorLimpieza, getVentiladorEstatus, getFiltrosLimpieza, getFiltrosEstatus, obsTub, obsTapa, obsCabIn, obsExt, obsFijacion, obsOrientacion, obsCable, obsVentilador, obsFiltros);
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
                Toast.makeText(GabinetePMI.this, "Error en la conexión" + t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}