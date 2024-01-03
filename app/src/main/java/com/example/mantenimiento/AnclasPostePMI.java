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

public class AnclasPostePMI extends AppCompatActivity {

    private boolean getCuerdaLimpieza;
    private boolean getCuerdaEstatus;
    private EditText obsCuerdaAnclasPMI;
    private boolean getPiezasLimpieza;
    private boolean getPiezasEstatus;
    private EditText obsPiezasAnclasPMI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anclas_poste_pmi);

        CheckBox checkBoxLimpiezaCuerdaSI = findViewById(R.id.limpieza_cuerd_si);
        CheckBox checkBoxLimpiezaCuerdaNO = findViewById(R.id.limpieza_cuerd_no);
        CheckBox checkBoxEstatusCuerdaSI = findViewById(R.id.estatus_cuerd_si);
        CheckBox checkBoxEstatusCuerdaNO = findViewById(R.id.estatus_cuerd_no);

        CheckBox checkBoxLimpiezaPiezasSI = findViewById(R.id.limpieza_piezas_si);
        CheckBox checkBoxLimpiezaPiezasNO = findViewById(R.id.limpieza_piezas_no);
        CheckBox checkBoxEstatusPiezasSI = findViewById(R.id.estatus_piezas_si);
        CheckBox checkBoxEstatusPiezasNO = findViewById(R.id.estatus_piezas_no);


        checkBoxLimpiezaCuerdaSI.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    getCuerdaLimpieza = isChecked;
            }
        });

        checkBoxLimpiezaCuerdaNO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    getCuerdaLimpieza = !isChecked;

            }
        });

        checkBoxEstatusCuerdaSI.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    getCuerdaEstatus = isChecked;
            }
        });

        checkBoxEstatusCuerdaNO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    getCuerdaEstatus = !isChecked;

            }
        });

        checkBoxLimpiezaPiezasSI.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    getPiezasLimpieza = isChecked;
            }
        });

        checkBoxLimpiezaPiezasNO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    getPiezasLimpieza = !isChecked;

            }
        });

        checkBoxEstatusPiezasSI.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    getPiezasEstatus =isChecked;

            }
        });

        checkBoxEstatusPiezasNO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxEstatusPiezasNO.setChecked(false);
                    getPiezasEstatus =!isChecked;
                }
            }
        });

        obsCuerdaAnclasPMI = findViewById(R.id.ob_cuerd_anc_pmi);
        obsPiezasAnclasPMI = findViewById(R.id.ob_piezas_anc_pmi);
        
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

        Call<AnclasResponsePMI> call = apiService.storeAnclasPMI(idMantenimiento, getCuerdaLimpieza, getCuerdaEstatus, getPiezasLimpieza, getPiezasEstatus, obsCuerda, obsPiezas);
        call.enqueue(new Callback<AnclasResponsePMI>() {
            @Override
            public void onResponse(Call<AnclasResponsePMI> call, Response<AnclasResponsePMI> response) {
                if (response.isSuccessful()){
                    AnclasResponsePMI anclasResponsePMI = response.body();
                    Toast.makeText(AnclasPostePMI.this, "Registro guardado", Toast.LENGTH_SHORT).show();

                }else{
                    Toast.makeText(AnclasPostePMI.this, "Registro incorrecto", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<AnclasResponsePMI> call, Throwable t) {
                Toast.makeText(AnclasPostePMI.this, "Error de conexión", Toast.LENGTH_SHORT).show();
            }
        });
    }


}