package com.example.mantenimiento;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ObservacionGrlPMI extends AppCompatActivity {

    private EditText obsGrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_observacion_grl_pmi);

        obsGrl = findViewById(R.id.obs_grl_pmi);

        ImageButton save = findViewById(R.id.siguiente_menu);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String obs = obsGrl.getText().toString();
                storeObservacion(obs);
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

    private void storeObservacion(String obs) {
        ApiService apiService = ApiClient.getClient();
        int idMantenimiento  = AppData.getInstance().getIdMantenimiento();

        Call<ObsResponsePMI> call = apiService.updateOBSPMI(idMantenimiento, obs);
        call.enqueue(new Callback<ObsResponsePMI>() {
            @Override
            public void onResponse(Call<ObsResponsePMI> call, Response<ObsResponsePMI> response) {
                if (response.isSuccessful()){
                    Toast.makeText(ObservacionGrlPMI.this, "Registro guardado", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(ObservacionGrlPMI.this, "Registro incorrecto", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ObsResponsePMI> call, Throwable t) {
                Toast.makeText(ObservacionGrlPMI.this, "Error de conexión", Toast.LENGTH_SHORT).show();
            }
        });
    }
}