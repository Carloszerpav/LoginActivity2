package com.example.loginactivity.activities;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.loginactivity.ListTarea;
import com.example.loginactivity.R;

public class MainActivity2 extends AppCompatActivity {
    private Button botonNotas;
    private Button botonTareas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        // Obtén referencias a los botones por sus ID
        botonNotas = findViewById(R.id.nota);
        botonTareas = findViewById(R.id.tarea);

        // Agrega un OnClickListener al botón "NOTAS"
        botonNotas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Crea un intent para abrir ListNotasActivity
                Intent intent = new Intent(MainActivity2.this, ListNotasActivity.class);

                // Inicia la actividad ListNotasActivity
                startActivity(intent);
            }
        });

        // Agrega un OnClickListener al botón "TAREAS POR HACER"
        botonTareas.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                // Crea un intent para abrir ListTareaActivity
                Intent intent = new Intent(MainActivity2.this, ListTarea.class);

                // Inicia la actividad ListTareaActivity
                startActivity(intent);
            }
        });
    }
}
