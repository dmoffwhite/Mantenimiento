package com.example.mantenimiento;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
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

public class FormPMI extends AppCompatActivity {

    private EditText pmiId;
    private EditText folioPMI;
    private EditText cuadrillaPMI;
    private EditText fechaPMI;
    private EditText placasPMI;

    private String tipoMantenimiento;
    private AutoCompleteTextView municipioPMI;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_pmi);

        AutoCompleteTextView autoCompleteMunicipio = findViewById(R.id.edittext_municipio_pmi);
        ArrayAdapter<String> municipioAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_dropdown_item_1line,
                getResources().getStringArray(R.array.array_municipios)
        );
        autoCompleteMunicipio.setAdapter(municipioAdapter);

        autoCompleteMunicipio.setOnItemClickListener((parent, view, position, id) -> {
            String selectedMunicipio = (String) parent.getItemAtPosition(position);
            Toast.makeText(this, "Municipio seleccionado" + selectedMunicipio, Toast.LENGTH_SHORT).show();

        });



        CheckBox checkBoxPreventivo = findViewById(R.id.preventivo);
        CheckBox checkBoxCorrectivo = findViewById(R.id.correctivo);

        pmiId = findViewById(R.id.edittext_pmiID);
        folioPMI = findViewById(R.id.edittext_folio_pmi);
        cuadrillaPMI = findViewById(R.id.edittext_cuadrilla_pmi);
        fechaPMI = findViewById(R.id.edittext_fecha_pmi);
        placasPMI = findViewById(R.id.edittext_placas_pmi);
        municipioPMI = autoCompleteMunicipio;


        checkBoxPreventivo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    checkBoxCorrectivo.setChecked(false);
                     tipoMantenimiento = "PREVENTIVO";
                }
            }
        });

        checkBoxCorrectivo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    checkBoxPreventivo.setChecked(false);
                     tipoMantenimiento = "CORRECTIVO";
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
                String pmiID = pmiId.getText().toString();
                String folio = folioPMI.getText().toString();
                String cuadrilla = cuadrillaPMI.getText().toString();
                String fecha = fechaPMI.getText().toString();
                String placas = placasPMI.getText().toString();
                String municipio = autoCompleteMunicipio.getEditableText().toString();
                Intent intent = new Intent(FormPMI.this, MenuPMI.class);
                startActivity(intent);
                storeMantenimiento(tipoMantenimiento, pmiID, folio, cuadrilla, fecha, placas, municipio);
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

    private void storeMantenimiento(String pmiID, String folio, String cuadrilla, String fecha, String placas, String municipio, String s) {
        if(TextUtils.isEmpty(pmiID)){
            pmiId.setError("El id del pmi es requerido");
            pmiId.requestFocus();
            return;
        }

        if(TextUtils.isEmpty(folio)){
            folioPMI.setError("El folio es requerido");
            folioPMI.requestFocus();
            return;
        }

        if(TextUtils.isEmpty(cuadrilla)){
            cuadrillaPMI.setError("La cuadrilla es requerida");
            cuadrillaPMI.requestFocus();
            return;
        }

        if(TextUtils.isEmpty(fecha)){
            fechaPMI.setError("La fecha es requerida");
            fechaPMI.requestFocus();
            return;
        }

        if(TextUtils.isEmpty(placas)){
            placasPMI.setError("Las placas del vehiculo es requerida");
            placasPMI.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(municipio)){
            municipioPMI.setError("El municipio es requerido");
            municipioPMI.requestFocus();
            return;
        }

        ApiService apiService = ApiClient.getClient();
        int idUsuario = ((Menu) getParent()).getIdUsuario();

        Call<FormResponsePMI> call = apiService.storeMantenimientoPMI(idUsuario, pmiID, folio, cuadrilla, fecha, placas, tipoMantenimiento, municipio);
        call.enqueue(new Callback<FormResponsePMI>() {
            @Override
            public void onResponse(Call<FormResponsePMI> call, Response<FormResponsePMI> response) {
                if(response.isSuccessful()){
                    FormResponsePMI formResponsePMI = response.body();
                    int idMantenimiento = formResponsePMI.getIdMantenimiento();
                    Toast.makeText(FormPMI.this, "Registro guardado", Toast.LENGTH_SHORT).show();
                    AppData.getInstance().setIdMantenimiento(idMantenimiento);
                    Intent intent = new Intent(FormPMI.this, MenuPMI.class);
                    intent.putExtra("idMantenimiento" , idMantenimiento);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(FormPMI.this, "Registro incorrecto", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<FormResponsePMI> call, Throwable t) {
                Toast.makeText(FormPMI.this, "Error de conexión" + t.getMessage(), Toast.LENGTH_LONG).show();

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
                // Cuando el usuario selecciona la fecha en el DatePickerDialog
                String fechaSeleccionada = dayOfMonth + "/" + (monthOfYear + 1) + "/" + year;
                inputEditTextFecha.setText(fechaSeleccionada);
            }
        }, año, mes, dia);

        // Mostrar el DatePickerDialog
        datePicker.show();
    }

}
