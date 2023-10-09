package com.example.loginactivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class AgregarNotaActivity extends AppCompatActivity {

    private EditText nombreNotaEditText;
    private EditText descripcionEditText;
    private Button botonVolverListadoNotas;
    private Button botonGuardarNota;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        // Obtén referencias a los botones por sus ID
        nombreNotaEditText = findViewById(R.id.nomnota);
        descripcionEditText = findViewById(R.id.descrip);
        botonVolverListadoNotas = findViewById(R.id.volvernota);
        botonGuardarNota = findViewById(R.id.guardarnota);

    }
}
