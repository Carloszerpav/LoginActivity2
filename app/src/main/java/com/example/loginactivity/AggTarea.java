package com.example.loginactivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.loginactivity.ListTarea;
import com.example.loginactivity.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import entidades.DatabaseHandler;

public class AggTarea extends AppCompatActivity {

    private EditText nombreTareaEditText;
    private EditText descripcionEditText;
    private Button guardarButton;
    private Button volverButton;
    private DatabaseHandler dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agg_tarea);

        nombreTareaEditText = findViewById(R.id.nomtarea);
        descripcionEditText = findViewById(R.id.descript);
        guardarButton = findViewById(R.id.guardartarea);
        volverButton = findViewById(R.id.volvertarea);

        dbHelper = new DatabaseHandler(this);

        guardarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                guardarTareaEnBaseDeDatos();
            }
        });

        volverButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AggTarea.this, ListTarea.class));
            }
        });
    }

    private void guardarTareaEnBaseDeDatos() {
        String nombreTarea = nombreTareaEditText.getText().toString();
        String descripcion = descripcionEditText.getText().toString();
        String fecha = obtenerFechaActual();

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("nombre", nombreTarea);
        values.put("descripcion", descripcion);
        values.put("fecha", fecha);

        long newRowId = db.insert("tareas", null, values);
        db.close();

        if (newRowId != -1) {
            Toast.makeText(this, "Tarea guardada correctamente", Toast.LENGTH_SHORT).show();
            limpiarCampos();
        } else {
            Toast.makeText(this, "Error al guardar la tarea", Toast.LENGTH_SHORT).show();
        }
    }

    private String obtenerFechaActual() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        return dateFormat.format(calendar.getTime());
    }

    private void limpiarCampos() {
        nombreTareaEditText.setText("");
        descripcionEditText.setText("");
    }
}
