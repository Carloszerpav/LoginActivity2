package com.example.loginactivity.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.loginactivity.R;
import com.example.loginactivity.adapter.NotaListAdapter;
import com.example.loginactivity.domains.Nota;

import java.util.List;

import entidades.DatabaseHandler;

public class ListNotasActivity extends AppCompatActivity {

    private ImageView volverAtrasImageView;
    private ImageView agregarNotaImageView;
    private DatabaseHandler db;
    private List<Nota> notas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_notas);

        try {
            db = new DatabaseHandler(this);
            notas = db.getAllNotas();

            RecyclerView notasListRecyclerView = findViewById(R.id.notasListRecyclerView);
            NotaListAdapter notaListAdapter = new NotaListAdapter(notas);
            LinearLayoutManager layoutManager = new LinearLayoutManager(this);
            notasListRecyclerView.setLayoutManager(layoutManager);

            // Asigna el adaptador al RecyclerView
            notasListRecyclerView.setAdapter(notaListAdapter);

            // Funcionalidad Agregar Nota
            agregarNotaImageView = findViewById(R.id.btnAgregarNota);
            agregarNotaImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Crea un Intent para abrir la actividad AggNota
                    Intent intent = new Intent(ListNotasActivity.this, AgregarNotaActivity.class);
                    startActivity(intent);
                }
            });

            // Funcionalidad Volver Atras
            volverAtrasImageView = findViewById(R.id.btnVolverAtras);
            volverAtrasImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Crea un Intent para volver a la actividad MainActivity2
                    Intent intent = new Intent(ListNotasActivity.this, MainActivity2.class);
                    startActivity(intent);
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
            Log.e("Error", "Error en ListNotasActivity: " + e.getMessage());
        }

    }

    @Override
    protected void onResume() {
        super.onResume();
        // Actualiza la lista de notas cuando la actividad se reanuda
        db = new DatabaseHandler(this);
        notas = db.getAllNotas();

        RecyclerView notasListRecyclerView = findViewById(R.id.notasListRecyclerView);

        // Obtiene una referencia al adaptador existente y actualiza sus datos
        NotaListAdapter notaListAdapter = (NotaListAdapter) notasListRecyclerView.getAdapter();
        notaListAdapter.setListadoNotas(notas);
        notaListAdapter.notifyDataSetChanged();
    }
}
