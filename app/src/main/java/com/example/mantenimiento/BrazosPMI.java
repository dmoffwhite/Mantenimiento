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

public class BrazosPMI extends AppCompatActivity {

    private boolean getCarcasaLimpieza;
    private boolean getCarcasaEstatus;
    private EditText obsCarcasaBrazosPMI;

    private boolean getTuberiaLimpieza;
    private boolean getTuberiaEstatus;
    private EditText obsTuberiaBrazosPMI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brazos_pmi);

        CheckBox checkBoxLimpiezaCarcasaSI = findViewById(R.id.limpieza_carc_si);
        CheckBox checkBoxLimpiezaCarcasaNO = findViewById(R.id.limpieza_carc_no);
        CheckBox checkBoxEstatusCarcasaSI = findViewById(R.id.estatus_carc_si);
        CheckBox checkBoxEstatusCarcasaNO = findViewById(R.id.estatus_carc_no);

        CheckBox checkBoxLimpiezaTuberiaSI = findViewById(R.id.limpieza_tub_si);
        CheckBox checkBoxLimpiezaTuberiaNO = findViewById(R.id.limpieza_tub_no);
        CheckBox checkBoxEstatusTuberiaSI = findViewById(R.id.estatus_tub_si);
        CheckBox checkBoxEstatusTuberiaNO = findViewById(R.id.estatus_tub_no);


        checkBoxLimpiezaCarcasaSI.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                getCarcasaLimpieza = isChecked;
            }
        });

        checkBoxLimpiezaCarcasaNO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    getCarcasaLimpieza = !isChecked;

            }
        });

        checkBoxEstatusCarcasaSI.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    getCarcasaEstatus = isChecked;

            }
        });

        checkBoxEstatusCarcasaNO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    getCarcasaEstatus = !isChecked;
            }
        });

        checkBoxLimpiezaTuberiaSI.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    getTuberiaLimpieza = isChecked;

            }
        });

        checkBoxLimpiezaTuberiaNO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    getTuberiaLimpieza = !isChecked;
            }
        });

        checkBoxEstatusTuberiaSI.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    getTuberiaEstatus = isChecked;

            }
        });

        checkBoxEstatusTuberiaNO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    getTuberiaEstatus = !isChecked;
            }
        });

        obsCarcasaBrazosPMI = findViewById(R.id.ob_carc_braz_pmi);
        obsTuberiaBrazosPMI = findViewById(R.id.ob_tub_braz_pmi);

        ImageButton save = findViewById(R.id.siguiente_menu);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String obsCarcasa = obsCarcasaBrazosPMI.getText().toString();
                String obsTuberia = obsTuberiaBrazosPMI.getText().toString();
                storeBrazos(getCarcasaLimpieza, getCarcasaEstatus, getTuberiaLimpieza, getTuberiaEstatus, obsCarcasa, obsTuberia);
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

    private void storeBrazos(boolean getCarcasaLimpieza, boolean getCarcasaEstatus, boolean getTuberiaLimpieza, boolean getTuberiaEstatus, String obsCarcasa, String obsTuberia) {
        ApiService apiService = ApiClient.getClient();

        int idMantenimiento = AppData.getInstance().getIdMantenimiento();

        Call<BrazosResponsePMI> call = apiService.storeBrazosPMI(idMantenimiento, getCarcasaLimpieza, getCarcasaEstatus, getTuberiaLimpieza, getTuberiaEstatus, obsCarcasa, obsTuberia);
        call.enqueue(new Callback<BrazosResponsePMI>() {
            @Override
            public void onResponse(Call<BrazosResponsePMI> call, Response<BrazosResponsePMI> response) {
                if(response.isSuccessful()){
                    BrazosResponsePMI brazosResponsePMI = response.body();
                    Toast.makeText(BrazosPMI.this, "Registro guardado", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(BrazosPMI.this, "Registro incorrecto", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<BrazosResponsePMI> call, Throwable t) {
                Toast.makeText(BrazosPMI.this, "Error de conexión", Toast.LENGTH_SHORT).show();
            }
        });


    }
}