package com.example.mantenimiento;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ImageButton;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Calendar;

public class FormLPR extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_lpr);

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
                Intent intent = new Intent(FormLPR.this, MenuPMI.class);
                startActivity(intent);
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