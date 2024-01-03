package com.example.mantenimiento;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EdgeEffect;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegistroMantenimientoLPR extends AppCompatActivity {

    private boolean getTubGalLimpieza;
    private boolean getTubGalEstatus;
    private EditText obsTubGalvLPR;
    private boolean getTorSLimpieza;
    private boolean getTorSEstatus;
    private EditText obsTorSLPR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_mantenimiento_lpr);

        CheckBox checkBoxLimpiezaTubGalvSI = findViewById(R.id.limpieza_tubg_lpr_si);
        CheckBox checkBoxLimpiezaTubGalvNO = findViewById(R.id.limpieza_tubg_lpr_no);
        CheckBox checkBoxEstatusTubGalvSI = findViewById(R.id.estatus_tubg_lpr_si);
        CheckBox checkBoxEstatusTubGalvNO = findViewById(R.id.estatus_tubg_lpr_no);

        CheckBox checkBoxLimpiezaTorSI = findViewById(R.id.limpieza_tors_lpr_si);
        CheckBox checkBoxLimpiezaTorNO = findViewById(R.id.limpieza_tors_lpr_no);
        CheckBox checkBoxEstatusTorSI = findViewById(R.id.estatus_tors_lpr_si);
        CheckBox checkBoxEstatusTorNO = findViewById(R.id.estatus_tors_lpr_no);

        checkBoxLimpiezaTubGalvSI.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                    getTubGalLimpieza = isChecked;

            }
        });

        checkBoxLimpiezaTubGalvNO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                    getTubGalLimpieza = !isChecked;

            }
        });

        checkBoxEstatusTubGalvSI.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    getTubGalEstatus = isChecked;

            }
        });

        checkBoxEstatusTubGalvNO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                    getTubGalEstatus = !isChecked;

            }
        });

        checkBoxLimpiezaTorSI.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                    getTorSLimpieza = isChecked;

            }
        });

        checkBoxLimpiezaTorNO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                    getTorSLimpieza = !isChecked;

            }
        });

        checkBoxEstatusTorSI.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                    getTorSEstatus = isChecked;

            }
        });

        checkBoxEstatusTorNO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    getTorSEstatus = !isChecked;
            }
        });

        obsTubGalvLPR = findViewById(R.id.ob_tubga_reg_lpr);
        obsTorSLPR = findViewById(R.id.ob_tors_reg_lpr);

        ImageButton save = findViewById(R.id.siguiente_menu);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String obsTubGalv = obsTubGalvLPR.getText().toString();
                String obsTor = obsTorSLPR.getText().toString();
                storeRegistro(getTubGalLimpieza, getTubGalEstatus, getTorSLimpieza, getTorSEstatus, obsTubGalv, obsTor);
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

    private void storeRegistro(boolean getTubGalLimpieza, boolean getTubGalEstatus, boolean getTorSLimpieza, boolean getTorSEstatus, String obsTubGalv, String obsTor) {
        ApiService apiService = ApiClient.getClient();

        int idMantenimiento = AppData.getInstance().getIdMantenimiento();

        Call<RegistroResponseLPR> call = apiService.storeRegLPR(idMantenimiento, getTubGalLimpieza, getTubGalEstatus, getTorSLimpieza, getTorSEstatus, obsTubGalv, obsTor);
        call.enqueue(new Callback<RegistroResponseLPR>() {
            @Override
            public void onResponse(Call<RegistroResponseLPR> call, Response<RegistroResponseLPR> response) {
                if (response.isSuccessful()){
                    RegistroResponseLPR registroResponseLPR = response.body();
                    Toast.makeText(RegistroMantenimientoLPR.this, "Registro correcto", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(RegistroMantenimientoLPR.this, "Registro incorrecto", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<RegistroResponseLPR> call, Throwable t) {
                Toast.makeText(RegistroMantenimientoLPR.this, "Error de conexión", Toast.LENGTH_SHORT).show();
            }
        });

    }
}