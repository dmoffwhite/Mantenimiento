package com.example.mantenimiento;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostePMI extends AppCompatActivity {

    private String getConectoresLimpieza;
    private String getConectoresEstatus;
    private EditText obsConectoresPMI;

    private String getElementosLimpieza;
    private String getElementosEstatus;
    private EditText obsElementosPMI;

    private String getSeccionesLimpieza;
    private String getSeccionesEstatus;
    private EditText obsSeccionesPMI;

    private String getPinturaLimpieza;
    private String getPinturaEstatus;
    private EditText obsPinturaPMI;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poste_pmi);

        CheckBox checkBoxLimpiezaConectoresSI = findViewById(R.id.limpieza_con_si);
        CheckBox checkBoxLimpiezaConectoresNO = findViewById(R.id.limpieza_con_no);
        CheckBox checkBoxEstatusConectoresSI = findViewById(R.id.estatus_con_si);
        CheckBox checkBoxEstatusConectoresNO = findViewById(R.id.estatus_con_no);

        CheckBox checkBoxLimpiezaElementosSI = findViewById(R.id.limpieza_ele_si);
        CheckBox checkBoxLimpiezaElementosNO = findViewById(R.id.limpieza_ele_no);
        CheckBox checkBoxEstatusElementosSI = findViewById(R.id.estatus_ele_si);
        CheckBox checkBoxEstatusElementosNO = findViewById(R.id.estatus_ele_no);

        CheckBox checkBoxLimpiezaSeccionesSI = findViewById(R.id.limpieza_secc_si);
        CheckBox checkBoxLimpiezaSeccionesNO = findViewById(R.id.limpieza_secc_no);
        CheckBox checkBoxEstatusSeccionesSI = findViewById(R.id.estatus_secc_si);
        CheckBox checkBoxEstatusSeccionesNO = findViewById(R.id.estatus_secc_no);

        CheckBox checkBoxLimpiezaPinturaSI = findViewById(R.id.limpieza_pint_si);
        CheckBox checkBoxLimpiezaPinturaNO = findViewById(R.id.limpieza_pint_no);
        CheckBox checkBoxEstatusPinturaSi = findViewById(R.id.estatus_pint_si);
        CheckBox checkBoxEstatusPinturaNO = findViewById(R.id.estatus_pint_no);


        //Conectores

        checkBoxLimpiezaConectoresSI.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxLimpiezaConectoresSI.setChecked(false);
                    getConectoresLimpieza = "No";
                }
            }
        });

        checkBoxLimpiezaConectoresNO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxLimpiezaConectoresNO.setChecked(false);
                    getConectoresLimpieza = "Si";
                }
            }
        });

        checkBoxEstatusConectoresSI.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    checkBoxEstatusConectoresSI.setChecked(false);
                    getConectoresEstatus = "No";
                }
            }
        });

        checkBoxEstatusConectoresNO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    checkBoxEstatusConectoresNO.setChecked(false);
                    getElementosLimpieza = "Si";
                }
            }
        });

        //Elementos

        checkBoxLimpiezaElementosSI.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    checkBoxLimpiezaElementosSI.setChecked(false);
                    getElementosLimpieza = "No";
                }
            }
        });

        checkBoxLimpiezaElementosNO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    checkBoxLimpiezaElementosNO.setChecked(false);
                    getElementosLimpieza = "Si";
                }
            }
        });

        checkBoxEstatusElementosSI.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxEstatusElementosSI.setChecked(false);
                    getElementosEstatus = "No";
                }
            }
        });

        checkBoxEstatusElementosNO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxEstatusElementosNO.setChecked(false);
                    getElementosEstatus = "Si";
                }
            }
        });

        //Secciones

        checkBoxLimpiezaSeccionesSI.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxLimpiezaSeccionesSI.setChecked(false);
                    getSeccionesLimpieza = "No";
                }
            }
        });

        checkBoxLimpiezaSeccionesNO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxLimpiezaSeccionesNO.setChecked(false);
                    getSeccionesLimpieza = "Si";
                }
            }
        });

        checkBoxEstatusSeccionesSI.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxEstatusSeccionesSI.setChecked(false);
                    getSeccionesEstatus = "No";
                }
            }
        });

        checkBoxEstatusSeccionesNO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    checkBoxEstatusSeccionesNO.setChecked(false);
                    getSeccionesEstatus = "Si";
                }
            }
        });


        checkBoxLimpiezaPinturaSI.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxLimpiezaPinturaSI.setChecked(false);
                    getPinturaLimpieza = "No";
                }
            }
        });

        checkBoxLimpiezaPinturaNO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    checkBoxLimpiezaPinturaNO.setChecked(false);
                    getPinturaLimpieza = "Si";
                }
            }
        });

        checkBoxEstatusPinturaSi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxEstatusPinturaSi.setChecked(false);
                    getPinturaEstatus = "No";
                }
            }
        });

        checkBoxEstatusPinturaNO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    checkBoxEstatusPinturaNO.setChecked(false);
                    getPinturaEstatus = "Si";
                }
            }
        });



        obsConectoresPMI = findViewById(R.id.ob_con_pos_pmi);

        obsElementosPMI = findViewById(R.id.ob_ele_pos_pmi);

        obsSeccionesPMI = findViewById(R.id.ob_secc_pos_pmi);

        obsPinturaPMI = findViewById(R.id.ob_pin_pos_pmi);


        ImageButton img = findViewById(R.id.back);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String obsConectores  = obsConectoresPMI.getText().toString();
                String obsElementos = obsElementosPMI.getText().toString();
                String obsSecciones = obsSeccionesPMI.getText().toString();
                String obsPintura = obsPinturaPMI.getText().toString();
                finish();
                storePoste(getConectoresLimpieza, getConectoresEstatus, obsConectores, getElementosLimpieza, getElementosEstatus, obsElementos, getSeccionesLimpieza, getSeccionesEstatus, obsSecciones, getPinturaLimpieza, getPinturaEstatus, obsPintura);
            }
        });
    }

    private void storePoste(String getConectoresLimpieza, String getConectoresEstatus, String obsConectores, String getElementosLimpieza, String getElementosEstatus, String obsElementos, String getSeccionesLimpieza, String getSeccionesEstatus, String obsSecciones, String getPinturaLimpieza, String getPinturaEstatus, String obsPintura) {

        ApiService apiService = ApiClient.getClient();

        int idUsuario = ((Menu) getParent()).getIdUsuario();

        Call<PosteResponsePMI> call = apiService.storePostePMI(idUsuario, getConectoresLimpieza, getConectoresEstatus, obsConectores, getElementosLimpieza, getElementosEstatus, obsElementos, getSeccionesLimpieza, getSeccionesEstatus, obsSecciones, getPinturaLimpieza, getPinturaEstatus, obsPintura);
        call.enqueue(new Callback<PosteResponsePMI>() {
            @Override
            public void onResponse(Call<PosteResponsePMI> call, Response<PosteResponsePMI> response) {
                if(response.isSuccessful()){
                    PosteResponsePMI posteResponsePMI = response.body();
                    Toast.makeText(PostePMI.this, "Registro guardado", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(PostePMI.this, "Registro incorrecto", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<PosteResponsePMI> call, Throwable t) {
                Toast.makeText(PostePMI.this, "Error de conexión" + t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

    }
}