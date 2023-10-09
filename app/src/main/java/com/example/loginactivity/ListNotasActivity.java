package com.example.loginactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import android.widget.TableRow;

public class ListNotasActivity extends AppCompatActivity {


    private TableRow listadoNotasView;
    private ImageView volverAtrasImageView;
    private ImageView aggNotaImageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_notas);

        // Inicializa el administrador de notas
        //notasManager = new entidades.NotasManager(this);

        // Obtén una referencia a la lista en tu diseño XML
        listadoNotasView = findViewById(R.id.listnotas);

        // Configura el adaptador para mostrar las notas desde la base de datos
        /*SimpleCursorAdapter adapter = new SimpleCursorAdapter(
                this,
                android.R.layout.simple_list_item_2,
                notasManager.getNotasCursor(),
                new String[]{tablas.Notas.COLUMNA_NOMBRE, tablas.Notas.COLUMNA_DESCRIPCION},
                new int[]{android.R.id.text1, android.R.id.text2}
        );*/

        // Asigna el adaptador a la lista
       // notasListView.setAdapter(adapter);

        // Maneja la selección de un elemento de la lista
        /*notasListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Implementa lo que desees hacer al hacer clic en una nota en la lista
                // Puedes abrir una actividad de detalle o realizar cualquier otra acción
            }
        });*/

        // Obtén referencia a la imagen con ID "aggnota" en tu diseño XML
        aggNotaImageView = findViewById(R.id.aggnota);

        // Agrega un OnClickListener a la imagen "aggnota"
        aggNotaImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Crea un Intent para abrir la actividad AggNota
                Intent intent = new Intent(ListNotasActivity.this, AddNotaActivity.class);
                startActivity(intent);
            }
        });

        // Obtén referencia a la imagen con ID "flechaatras" en tu diseño XML
        volverAtrasImageView = findViewById(R.id.flechaatras);

        // Agrega un OnClickListener a la imagen "flechaatras"
        volverAtrasImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Crea un Intent para volver a la actividad MainActivity2
                Intent intent = new Intent(ListNotasActivity.this, MainActivity2.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Actualiza la lista de notas cuando la actividad se reanuda
        //notasManager.refrescarNotas();
    }
}
