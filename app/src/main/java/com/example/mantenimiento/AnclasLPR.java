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

public class AnclasLPR extends AppCompatActivity {

    private boolean getCuerdaLimpieza;
    private boolean getCuerdaEstatus;
    private EditText obsCuerdaAnclasPMI;
    private boolean getPiezasLimpieza;
    private boolean getPiezasEstatus;
    private EditText obsPiezasAnclasPMI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anclas_lpr);

        CheckBox checkBoxLimpiezaCuerdaSI = findViewById(R.id.limpieza_cuerd_lpr_si);
        CheckBox checkBoxLimpiezaCuerdaNO = findViewById(R.id.limpieza_cuerd_lpr_no);
        CheckBox checkBoxEstatusCuerdaSI = findViewById(R.id.estatus_cuerd_lpr_si);
        CheckBox checkBoxEstatusCuerdaNO = findViewById(R.id.estatus_cuerd_lpr_no);

        CheckBox checkBoxLimpiezaPiezasSI = findViewById(R.id.limpieza_tuer_lpr_si);
        CheckBox checkBoxLimpiezaPiezasNO = findViewById(R.id.limpieza_tuer_lpr_no);
        CheckBox checkBoxEstatusPiezasSI = findViewById(R.id.estatus_tuer_lpr_si);
        CheckBox checkBoxEstatusPiezasNO = findViewById(R.id.estatus_tuer_lpr_no);

        checkBoxLimpiezaCuerdaSI.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    checkBoxLimpiezaCuerdaNO.setChecked(false);
                    getCuerdaLimpieza = isChecked;

            }
        });

        checkBoxLimpiezaCuerdaNO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    checkBoxLimpiezaCuerdaSI.setChecked(false);
                    getCuerdaLimpieza = !isChecked;
            }
        });

        checkBoxEstatusCuerdaSI.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    checkBoxEstatusCuerdaNO.setChecked(false);
                    getCuerdaEstatus = isChecked;

            }
        });

        checkBoxEstatusCuerdaNO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    checkBoxEstatusCuerdaSI.setChecked(false);
                    getCuerdaEstatus = !isChecked;

            }
        });

        checkBoxLimpiezaPiezasSI.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    checkBoxLimpiezaPiezasNO.setChecked(false);
                    getPiezasLimpieza = isChecked;

            }
        });

        checkBoxLimpiezaPiezasNO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    checkBoxLimpiezaPiezasSI.setChecked(false);
                    getPiezasLimpieza = !isChecked;

            }
        });

        checkBoxEstatusPiezasSI.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    checkBoxEstatusPiezasNO.setChecked(false);
                    getPiezasEstatus =isChecked;
            }
        });

        checkBoxEstatusPiezasNO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    checkBoxEstatusPiezasSI.setChecked(false);
                    getPiezasEstatus =!isChecked;

            }
        });

        obsCuerdaAnclasPMI = findViewById(R.id.ob_cuerd_anc_lpr);
        obsPiezasAnclasPMI = findViewById(R.id.ob_tuer_anc_lpr);

        ImageButton save = findViewById(R.id.siguiente_menu);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String obsCuerda = obsCuerdaAnclasPMI.getText().toString();
                String obsPiezas = obsPiezasAnclasPMI.getText().toString();
                storeAnclas(getCuerdaLimpieza, getCuerdaEstatus, getPiezasLimpieza, getPiezasEstatus, obsCuerda, obsPiezas);
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

    private void storeAnclas(boolean getCuerdaLimpieza, boolean getCuerdaEstatus, boolean getPiezasLimpieza, boolean getPiezasEstatus, String obsCuerda, String obsPiezas) {
        ApiService apiService = ApiClient.getClient();

        int idMantenimiento = AppData.getInstance().getIdMantenimiento();
        Call<AnclasResponseLPR> call = apiService.storeAnclasLPR(idMantenimiento, getCuerdaLimpieza, getCuerdaEstatus, getPiezasLimpieza, getPiezasEstatus, obsCuerda, obsPiezas);
        call.enqueue(new Callback<AnclasResponseLPR>() {
            @Override
            public void onResponse(Call<AnclasResponseLPR> call, Response<AnclasResponseLPR> response) {
                if (response.isSuccessful()){
                    AnclasResponseLPR anclasResponseLPR = response.body();
                    Toast.makeText(AnclasLPR.this, "Registro guardado", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(AnclasLPR.this, "Registro incorrecto", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<AnclasResponseLPR> call, Throwable t) {
                Toast.makeText(AnclasLPR.this, "Error de conexión", Toast.LENGTH_SHORT).show();

            }
        });

    }
}