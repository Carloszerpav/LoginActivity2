package com.example.loginactivity;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.loginactivity.activities.MainActivity2;

import java.util.List;

public class ListTarea extends AppCompatActivity {
    private ImageView flechaAtras;
    private ImageView agregarTarea;
    private ListView listaTareas;
    //private TareasManager tareasManager; // Cambia la importación a la clase TareasManager

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_tarea);

        flechaAtras = findViewById(R.id.flechaatrasT);
        agregarTarea = findViewById(R.id.aggtarea);
        listaTareas = findViewById(R.id.listtarea);

        // Inicializa TareasManager con el contexto actual
        //tareasManager = new TareasManager(this);

        // Configura un clic en la imagen de flecha hacia atrás para ir a MainActivity2
        flechaAtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListTarea.this, MainActivity2.class);
                startActivity(intent);
            }
        });

        // Configura un clic en la imagen de agregar tarea para ir a AggTarea
        agregarTarea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListTarea.this, AggTarea.class);
                startActivity(intent);
            }
        });

        // Obtén la lista de tareas desde la base de datos
        List<String> tareas = obtenerTareasDesdeBaseDeDatos();

        // Configura el adaptador para mostrar las tareas en el ListView
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, tareas);
        listaTareas.setAdapter(adapter);
    }

    // Método para obtener la lista de tareas desde la base de datos
    private List<String> obtenerTareasDesdeBaseDeDatos() {
        // Utiliza TareasManager para obtener las tareas desde la base de datos
        List<String> tareas = null;
        // Retorna la lista de tareas obtenida desde la base de datos
        return tareas;
    }
}

