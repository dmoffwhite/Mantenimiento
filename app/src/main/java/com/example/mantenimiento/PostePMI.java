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

    private boolean getConectoresLimpieza;
    private boolean getConectoresEstatus;
    private EditText obsConectoresPMI;

    private boolean getElementosLimpieza;
    private boolean getElementosEstatus;
    private EditText obsElementosPMI;

    private boolean getSeccionesLimpieza;
    private boolean getSeccionesEstatus;
    private EditText obsSeccionesPMI;

    private boolean getPinturaLimpieza;
    private boolean getPinturaEstatus;
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

                    getConectoresLimpieza = isChecked;

            }
        });

        checkBoxLimpiezaConectoresNO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                    getConectoresLimpieza = !isChecked;

            }
        });

        checkBoxEstatusConectoresSI.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    getConectoresEstatus = isChecked;

            }
        });

        checkBoxEstatusConectoresNO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    getElementosEstatus = !isChecked;

            }
        });

        //Elementos

        checkBoxLimpiezaElementosSI.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                    getElementosLimpieza = isChecked;

            }
        });

        checkBoxLimpiezaElementosNO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                    getElementosLimpieza = !isChecked;

            }
        });

        checkBoxEstatusElementosSI.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                    getElementosEstatus = isChecked;

            }
        });

        checkBoxEstatusElementosNO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                    getElementosEstatus = !isChecked;

            }
        });

        //Secciones

        checkBoxLimpiezaSeccionesSI.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                    getSeccionesLimpieza = isChecked;

            }
        });

        checkBoxLimpiezaSeccionesNO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                    getSeccionesLimpieza = !isChecked;

            }
        });

        checkBoxEstatusSeccionesSI.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                    getSeccionesEstatus = isChecked;

            }
        });

        checkBoxEstatusSeccionesNO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                    getSeccionesEstatus = !isChecked;

            }
        });


        checkBoxLimpiezaPinturaSI.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    getPinturaLimpieza = isChecked;

            }
        });

        checkBoxLimpiezaPinturaNO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                    getPinturaLimpieza = !isChecked;

            }
        });

        checkBoxEstatusPinturaSi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                    getPinturaEstatus = isChecked;

            }
        });

        checkBoxEstatusPinturaNO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    getPinturaEstatus = !isChecked;
            }
        });



        obsConectoresPMI = findViewById(R.id.ob_con_pos_pmi);

        obsElementosPMI = findViewById(R.id.ob_ele_pos_pmi);

        obsSeccionesPMI = findViewById(R.id.ob_secc_pos_pmi);

        obsPinturaPMI = findViewById(R.id.ob_pin_pos_pmi);


        ImageButton save = findViewById(R.id.siguiente_menu);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String obsConectores  = obsConectoresPMI.getText().toString();
                String obsElementos = obsElementosPMI.getText().toString();
                String obsSecciones = obsSeccionesPMI.getText().toString();
                String obsPintura = obsPinturaPMI.getText().toString();
                storePoste(getConectoresLimpieza, getConectoresEstatus,  getElementosLimpieza, getElementosEstatus,  getSeccionesLimpieza, getSeccionesEstatus,  getPinturaLimpieza, getPinturaEstatus, obsConectores, obsElementos, obsSecciones, obsPintura);
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

    private void storePoste(boolean getConectoresLimpieza, boolean getConectoresEstatus,  boolean getElementosLimpieza, boolean getElementosEstatus, boolean getSeccionesLimpieza, boolean getSeccionesEstatus,  boolean getPinturaLimpieza, boolean getPinturaEstatus, String obsConectores, String obsElementos, String obsSecciones, String obsPintura) {

        ApiService apiService = ApiClient.getClient();


        int idMantenimiento = AppData.getInstance().getIdMantenimiento();


        Call<PosteResponsePMI> call = apiService.storePostePMI(idMantenimiento, getConectoresLimpieza, getConectoresEstatus,  getElementosLimpieza, getElementosEstatus,  getSeccionesLimpieza, getSeccionesEstatus,  getPinturaLimpieza, getPinturaEstatus, obsConectores, obsElementos, obsSecciones, obsPintura);
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