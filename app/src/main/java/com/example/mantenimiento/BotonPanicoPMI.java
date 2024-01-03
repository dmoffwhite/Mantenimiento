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

public class BotonPanicoPMI extends AppCompatActivity {

    private boolean getValidacionLimpieza;
    private boolean getValidacionEstatus;
    private EditText obsValidacionBotonPMI;

    private boolean getTornillosLimpieza;
    private boolean getTornillosEstatus;
    private EditText obsTornillosBotonPMI;
    private boolean getSuperficieLimpieza;
    private boolean getSuperficieEstatus;
    private EditText obsSuperficieBotonPMI;
    private boolean getConexionesLimpieza;
    private boolean getConexionesEstatus;
    private EditText obsConexionesBotonPMI;
    private boolean getCableadoLimpieza;
    private boolean getCableadoEstatus;
    private EditText obsCableadoBotonPMI;
    private boolean getFimwareLimpieza;
    private boolean getFimwareEstatus;
    private EditText obsFimwareBotonPMI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boton_panico_pmi);

        CheckBox checkBoxLimpiezaValSI = findViewById(R.id.limpieza_val_si);
        CheckBox checkBoxLimpiezaValNO = findViewById(R.id.limpieza_val_no);
        CheckBox checkBoxEstatusValSI = findViewById(R.id.estatus_val_si);
        CheckBox checkBoxEstatusValNO = findViewById(R.id.estatus_val_no);

        CheckBox checkBoxLimpiezaTornSI = findViewById(R.id.limpieza_torn_si);
        CheckBox checkBoxLimpiezaTornNO = findViewById(R.id.limpieza_torn_no);
        CheckBox checkBoxEstatusTornSI = findViewById(R.id.estatus_torn_si);
        CheckBox checkBoxEstatusTornNO = findViewById(R.id.estatus_torn_no);

        CheckBox checkBoxLimpiezaSupSI = findViewById(R.id.limpieza_acab_si);
        CheckBox checkBoxLimpiezaSupNO = findViewById(R.id.limpieza_acab_no);
        CheckBox checkBoxEstatusSupSI = findViewById(R.id.estatus_acab_si);
        CheckBox checkBoxEstatusSupNO = findViewById(R.id.estatus_acab_no);

        CheckBox checkBoxLimpiezaConxSI = findViewById(R.id.limpieza_conx_si);
        CheckBox checkBoxLimpiezaConxNO = findViewById(R.id.limpieza_conx_no);
        CheckBox checkBoxEstatusConxSI = findViewById(R.id.estatus_conx_si);
        CheckBox checkBoxEstatusConxNO = findViewById(R.id.estatus_conx_no);

        CheckBox checkBoxLimpiezaCabSI = findViewById(R.id.limpieza_cab_si);
        CheckBox checkBoxLimpiezaCabNO = findViewById(R.id.limpieza_cab_no);
        CheckBox checkBoxEstatusCabSI = findViewById(R.id.estatus_cab_si);
        CheckBox checkBoxEstatusCabNO = findViewById(R.id.estatus_cab_no);

        CheckBox checkBoxLimpiezaFimSI = findViewById(R.id.limpieza_fimw_si);
        CheckBox checkBoxLimpiezaFimNO = findViewById(R.id.limpieza_fimw_no);
        CheckBox checkBoxEstatusFimSI = findViewById(R.id.estatus_fimw_si);
        CheckBox checkBoxEstatusFimNO = findViewById(R.id.estatus_fimw_no);

        checkBoxLimpiezaValSI.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    getValidacionLimpieza = isChecked;

            }
        });

        checkBoxLimpiezaValNO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    getValidacionLimpieza = !isChecked;

            }
        });

        checkBoxEstatusValSI.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    getValidacionEstatus = isChecked;

            }
        });

        checkBoxEstatusValNO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    getValidacionEstatus = !isChecked;

            }
        });

        checkBoxLimpiezaTornSI.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    getTornillosLimpieza = isChecked;

            }
        });

        checkBoxLimpiezaTornNO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    getTornillosLimpieza = !isChecked;

            }
        });

        checkBoxEstatusTornSI.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    getTornillosEstatus = isChecked;

            }
        });

        checkBoxEstatusTornNO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    getTornillosEstatus = !isChecked;

            }
        });

        checkBoxLimpiezaSupSI.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    getSuperficieLimpieza = isChecked;

            }
        });

        checkBoxLimpiezaSupNO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    getSuperficieLimpieza = !isChecked;
            }
        });

        checkBoxEstatusSupSI.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    getSuperficieEstatus = isChecked;

            }
        });

        checkBoxEstatusSupNO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    getSuperficieEstatus = !isChecked;

            }
        });

        checkBoxLimpiezaConxSI.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    getConexionesLimpieza = isChecked;

            }
        });

        checkBoxLimpiezaConxNO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    getConexionesLimpieza = !isChecked;

            }
        });

        checkBoxEstatusConxSI.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    getConexionesEstatus = isChecked;

            }
        });

        checkBoxEstatusConxNO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    getConexionesEstatus = !isChecked;

            }
        });

        checkBoxLimpiezaCabSI.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    getCableadoLimpieza = isChecked;

            }
        });

        checkBoxLimpiezaCabNO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    getCableadoLimpieza = !isChecked;
            }
        });

        checkBoxEstatusCabSI.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    getCableadoEstatus = isChecked;

            }
        });

        checkBoxEstatusCabNO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    getCableadoEstatus = !isChecked;

            }
        });

        checkBoxLimpiezaFimSI.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    getFimwareLimpieza = isChecked;

            }
        });

        checkBoxLimpiezaFimNO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    getFimwareLimpieza = !isChecked;
            }
        });

        checkBoxEstatusFimSI.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    getFimwareEstatus = isChecked;
            }
        });

        checkBoxEstatusFimNO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    getFimwareEstatus = !isChecked;

            }
        });

        obsValidacionBotonPMI = findViewById(R.id.ob_val_boton_pmi);
        obsTornillosBotonPMI = findViewById(R.id.ob_tor_boton_pmi);
        obsSuperficieBotonPMI = findViewById(R.id.ob_sup_boton_pmi);
        obsConexionesBotonPMI = findViewById(R.id.ob_conx_boton_pmi);
        obsCableadoBotonPMI = findViewById(R.id.ob_cab_boton_pmi);
        obsFimwareBotonPMI = findViewById(R.id.ob_fim_boton_pmi);


        ImageButton save = findViewById(R.id.siguiente_menu);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String obsValidacion = obsValidacionBotonPMI.getText().toString();
                String obsTornillos = obsTornillosBotonPMI.getText().toString();
                String obsSuperficie = obsSuperficieBotonPMI.getText().toString();
                String obsConexiones = obsConexionesBotonPMI.getText().toString();
                String obsCableado = obsCableadoBotonPMI.getText().toString();
                String obsFimware = obsFimwareBotonPMI.getText().toString();
                storeBoton(getValidacionLimpieza, getValidacionEstatus, getTornillosLimpieza, getTornillosEstatus, getSuperficieLimpieza, getSuperficieEstatus, getConexionesLimpieza, getConexionesEstatus, getCableadoLimpieza, getCableadoEstatus, getFimwareLimpieza, getFimwareEstatus, obsValidacion, obsTornillos, obsSuperficie, obsConexiones, obsCableado, obsFimware);
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

    private void storeBoton(boolean getValidacionLimpieza, boolean getValidacionEstatus, boolean getTornillosLimpieza, boolean getTornillosEstatus, boolean getSuperficieLimpieza, boolean getSuperficieEstatus, boolean getConexionesLimpieza, boolean getConexionesEstatus, boolean getCableadoLimpieza, boolean getCableadoEstatus, boolean getFimwareLimpieza, boolean getFimwareEstatus, String obsValidacion, String obsTornillos, String obsSuperficie, String obsConexiones, String obsCableado, String obsFimware) {
    ApiService apiService = ApiClient.getClient();

    int idMantenimiento = AppData.getInstance().getIdMantenimiento();

      Call<BotonResponsePMI> call = apiService.storeBotonPMI(idMantenimiento, getValidacionLimpieza, getValidacionEstatus, getTornillosLimpieza, getTornillosEstatus, getSuperficieLimpieza, getSuperficieEstatus, getConexionesLimpieza, getConexionesEstatus, getCableadoLimpieza, getCableadoEstatus, getFimwareLimpieza, getFimwareEstatus, obsValidacion, obsTornillos, obsSuperficie, obsConexiones, obsCableado, obsFimware);
      call.enqueue(new Callback<BotonResponsePMI>() {
          @Override
          public void onResponse(Call<BotonResponsePMI> call, Response<BotonResponsePMI> response) {
              if (response.isSuccessful()){
                  BotonResponsePMI botonResponsePMI = response.body();
                  Toast.makeText(BotonPanicoPMI.this, "Registro guardado", Toast.LENGTH_SHORT).show();
              }else{
                  Toast.makeText(BotonPanicoPMI.this, "Registro incorrecto", Toast.LENGTH_SHORT).show();
              }
          }

          @Override
          public void onFailure(Call<BotonResponsePMI> call, Throwable t) {
            Toast.makeText(BotonPanicoPMI.this, "Error de conexón", Toast.LENGTH_SHORT).show();
          }
      });
    }
}