package com.example.mantenimiento;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Calendar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FormLPR extends AppCompatActivity {

    private EditText lprId;
    private EditText folioLPR;
    private EditText cuadrillaLPR;
    private EditText fechaLPR;
    private EditText placasLPR;
    private String tipoMantenimiento;

    private EditText municipioLPR;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_lpr);

        CheckBox checkBoxPreventivo = findViewById(R.id.preventivo);
        CheckBox checkBoxCorrectivo = findViewById(R.id.correctivo);

        lprId = findViewById(R.id.edittext_lprID);
        folioLPR = findViewById(R.id.edittext_folio_lpr);
        cuadrillaLPR = findViewById(R.id.edittext_cuadrilla_lpr);
        fechaLPR = findViewById(R.id.edittext_fecha_lpr);
        placasLPR = findViewById(R.id.edittext_placas_lpr);
        municipioLPR = findViewById(R.id.edittext_municipio_lpr);

        checkBoxPreventivo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxCorrectivo.setChecked(false);
                    tipoMantenimiento = "preventivo";
                }
            }
        });

        checkBoxCorrectivo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxPreventivo.setChecked(false);
                    tipoMantenimiento = "correctivo";
                }
            }
        });


        TextInputLayout inputLayoutFecha = findViewById(R.id.input_pmi_fecha);
        TextInputEditText inputEditTextFecha = (TextInputEditText) inputLayoutFecha.getEditText();
        inputEditTextFecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrarDatePicker(inputEditTextFecha);
            }
        });

        ImageButton img = findViewById(R.id.siguiente);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String lprID = lprId.getText().toString();
                String folio = folioLPR.getText().toString();
                String cuadrilla = cuadrillaLPR.getText().toString();
                String fecha = fechaLPR.getText().toString();
                String placas = placasLPR.getText().toString();
                String municipio = municipioLPR.getText().toString();
                Intent intent = new Intent(FormLPR.this, MenuPMI.class);
                startActivity(intent);
                storeMantenimiento(tipoMantenimiento, lprID, folio, cuadrilla, fecha, placas, municipio);

            }
        });

        ImageButton back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finish();

            }
        });


    }

    private void storeMantenimiento(String lprID, String folio, String cuadrilla, String fecha, String placas, String municipio, String s){
        if (TextUtils.isEmpty(lprID)){
            lprId.setError("El id del lpr es requerido");
            lprId.requestFocus();
            return;
        }
        if (TextUtils.isEmpty(folio)){
            folioLPR.setError("El folio es requerido");
            folioLPR.requestFocus();
            return;
        }
        if (TextUtils.isEmpty(cuadrilla)){
            cuadrillaLPR.setError("La cuadrilla es requerida");
            cuadrillaLPR.requestFocus();
            return;
        }
        if (TextUtils.isEmpty(fecha)) {
            fechaLPR.setError("La fecha es requerida");
            fechaLPR.requestFocus();
            return;
        }

        if(TextUtils.isEmpty(placas)){
            placasLPR.setError("Las placas del vehiculo es requerida");
            placasLPR.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(municipio)){
            municipioLPR.setError("El municipio es requerido");
            municipioLPR.requestFocus();
            return;
        }

        ApiService apiService = ApiClient.getClient();
        int idUsuario = ((Menu) getParent()).getIdUsuario();

        Call<FormResponseLPR> call = apiService.storeMantenimientoLPR(idUsuario, lprID, folio, cuadrilla, fecha, placas, tipoMantenimiento, municipio);
        call.enqueue(new Callback<FormResponseLPR>() {
            @Override
            public void onResponse(Call<FormResponseLPR> call, Response<FormResponseLPR> response) {
                if (response.isSuccessful()){
                    FormResponseLPR formResponseLPR=response.body();
                    Toast.makeText(FormLPR.this, "Registro guardado", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(FormLPR.this, MenuLPR.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(FormLPR.this, "Registros incorrectos", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<FormResponseLPR> call, Throwable t) {

            }
        });

    }

    private void mostrarDatePicker(final TextInputEditText inputEditTextFecha) {
        Calendar calendario = Calendar.getInstance();
        int año = calendario.get(Calendar.YEAR);
        int mes = calendario.get(Calendar.MONTH);
        int dia = calendario.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePicker = new DatePickerDialog(this, R.style.DatePickerTheme, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                String fechaSeleccionada = dayOfMonth + "/" + (monthOfYear + 1) + "/" + year;
                inputEditTextFecha.setText(fechaSeleccionada);
            }
        }, año, mes, dia);

        // Mostrar el DatePickerDialog
        datePicker.show();
    }
}