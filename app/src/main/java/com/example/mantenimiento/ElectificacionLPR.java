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

public class ElectificacionLPR extends AppCompatActivity {

    private boolean getRevisionLimpieza;
    private boolean getRevisionEstatus;
    private EditText obsRevisionLPR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_electificacion_lpr);

        CheckBox checkBoxLimpiezaRevSI = findViewById(R.id.limpieza_rev_si);
        CheckBox checkBoxLimpiezaRevNO = findViewById(R.id.limpieza_rev_no);
        CheckBox checkBoxEstatusRevSI = findViewById(R.id.estatus_rev_si);
        CheckBox checkBoxEstatusRevNO = findViewById(R.id.estatus_rev_no);


        checkBoxLimpiezaRevSI.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxLimpiezaRevSI.setChecked(false);
                    getRevisionLimpieza = !isChecked;
                }
            }
        });

        checkBoxLimpiezaRevNO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxLimpiezaRevNO.setChecked(false);
                    getRevisionLimpieza = isChecked;
                }
            }
        });

        checkBoxEstatusRevSI.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxEstatusRevSI.setChecked(false);
                    getRevisionEstatus = !isChecked;
                }
            }
        });

        checkBoxEstatusRevNO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxEstatusRevNO.setChecked(false);
                    getRevisionEstatus = isChecked;
                }
            }
        });

        obsRevisionLPR = findViewById(R.id.ob_rev_ele_lpr);

        ImageButton save = findViewById(R.id.siguiente_menu);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String obsRevision = obsRevisionLPR.getText().toString();
                storeElectrificacion(getRevisionLimpieza, getRevisionEstatus);
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

    private void storeElectrificacion(boolean getRevisionLimpieza, boolean getRevisionEstatus) {
        ApiService apiService = ApiClient.getClient();
        int idMantenimiento = AppData.getInstance().getIdMantenimiento();

        Call<ElectResponseLPR> call = apiService.storeElecLPR(idMantenimiento, getRevisionLimpieza, getRevisionEstatus);
        call.enqueue(new Callback<ElectResponseLPR>() {
            @Override
            public void onResponse(Call<ElectResponseLPR> call, Response<ElectResponseLPR> response) {
                if (response.isSuccessful()){
                    ElectResponseLPR electResponseLPR = response.body();
                    Toast.makeText(ElectificacionLPR.this, "Registro guardado", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(ElectificacionLPR.this, "Registro incorrecto", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ElectResponseLPR> call, Throwable t) {
                Toast.makeText(ElectificacionLPR.this, "Error en la conexión" + t.getMessage(), Toast.LENGTH_LONG).show();

            }
        });


    }
}