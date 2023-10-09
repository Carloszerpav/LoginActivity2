package com.example.loginactivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class AddNotaActivity extends AppCompatActivity {

    private Button botonSeleccionarFecha, guardarNotaButton, volverNotaButton;
    private TextView textViewFecha;
    private EditText editTextNombreNota, editTextDescripcion;
    private Calendar calendar;
    private String fechaSeleccionada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agg_nota);

        botonSeleccionarFecha = findViewById(R.id.botonSeleccionarFecha);
        textViewFecha = findViewById(R.id.textView3);
        editTextNombreNota = findViewById(R.id.nomnota);
        editTextDescripcion = findViewById(R.id.descrip);
        guardarNotaButton = findViewById(R.id.guardarnota);
        volverNotaButton = findViewById(R.id.volvernota);

    }
}
