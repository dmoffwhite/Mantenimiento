package com.example.mantenimiento;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.io.IOException;

import okhttp3.Cache;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PararayoPMI extends AppCompatActivity {

    private boolean getPuntaLimpieza;
    private boolean getPuntaEstatus;

    private EditText obsPuntaFaradayPMI;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pararayo_pmi);

        CheckBox checkBoxLimpiezaPuntaSI = findViewById(R.id.limpieza_far_si);
        CheckBox checkBoxLimpiezaPuntaNO = findViewById(R.id.limpieza_far_no);
        CheckBox checkBoxEstatusPuntaSI = findViewById(R.id.estatus_far_si);
        CheckBox checkBoxEstatusPuntaNO = findViewById(R.id.estatus_far_no);

        checkBoxLimpiezaPuntaSI.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    getPuntaLimpieza = isChecked;

            }
        });

        checkBoxLimpiezaPuntaNO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    getPuntaLimpieza = !isChecked;

            }
        });

        checkBoxEstatusPuntaSI.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    getPuntaEstatus = isChecked;

            }
        });

        checkBoxEstatusPuntaNO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                    getPuntaEstatus = !isChecked;

            }
        });

        obsPuntaFaradayPMI = findViewById(R.id.ob_far_par_pmi);

        ImageButton save = findViewById(R.id.siguiente_menu);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String obsPuntaFaraday = obsPuntaFaradayPMI.getText().toString();
                storePararayo(getPuntaLimpieza, getPuntaEstatus, obsPuntaFaraday);
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



    private void storePararayo(boolean getPuntaLimpieza, boolean getPuntaEstatus, String obsPuntaFaraday) {
        ApiService apiService = ApiClient.getClient();

        int idMantenimiento = AppData.getInstance().getIdMantenimiento();

        Call<PararayoResponsePMI> call = apiService.storePararayosPMI(idMantenimiento, getPuntaLimpieza, getPuntaEstatus, obsPuntaFaraday);
        call.enqueue(new Callback<PararayoResponsePMI>() {
            @Override
            public void onResponse(Call<PararayoResponsePMI> call, Response<PararayoResponsePMI> response) {
                if (response.isSuccessful()){
                    PararayoResponsePMI pararayoResponsePMI = response.body();
                    Toast.makeText(PararayoPMI.this, "Registro guardado", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(PararayoPMI.this, "Registro incorrecto", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<PararayoResponsePMI> call, Throwable t) {
                Toast.makeText(PararayoPMI.this, "Error en la conexión" + t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}