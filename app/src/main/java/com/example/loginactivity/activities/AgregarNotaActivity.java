package com.example.loginactivity.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.loginactivity.R;
import com.example.loginactivity.domains.Nota;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

import entidades.DatabaseHandler;

public class AgregarNotaActivity extends AppCompatActivity {

    DatabaseHandler db;
    private EditText nombreNotaEditText;
    private EditText descripcionEditText;
    private Button botonVolverListadoNotas;
    private Button botonGuardarNota;

    DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agg_nota);

        db = new DatabaseHandler(this);

        // Obtén referencias a los botones por sus ID
        nombreNotaEditText = findViewById(R.id.nombreEditText);
        descripcionEditText = findViewById(R.id.descripcionEditText);
        botonVolverListadoNotas = findViewById(R.id.btnVolverListadoNota);

        botonGuardarNota = findViewById(R.id.btnGuardarNota);

        botonGuardarNota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombreStr = nombreNotaEditText.getText().toString();
                String descripcionStr = descripcionEditText.getText().toString();

                LocalDate fechaActual = LocalDate.now();

                Nota nota = new Nota(
                    nombreStr,
                    descripcionStr,
                    fechaActual.format(formato)
                );

                db.addNota(nota);

                // Las credenciales son válidas
                Toast.makeText(AgregarNotaActivity.this, "Nota agregada exitosamente!", Toast.LENGTH_SHORT).show();

                // Crear un Intent para abrir MainActivity2
                Intent intent = new Intent(AgregarNotaActivity.this, ListNotasActivity.class);
                startActivity(intent);
            }
        });
    }
}
