package com.example.loginactivity;

import androidx.appcompat.app.AppCompatActivity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Calendar;

import entidades.DatabaseHandler;

public class AggNota extends AppCompatActivity {

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

        calendar = Calendar.getInstance();

        botonSeleccionarFecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);

                android.app.DatePickerDialog datePickerDialog = new android.app.DatePickerDialog(AggNota.this,
                        new android.app.DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                                fechaSeleccionada = dayOfMonth + "/" + (month + 1) + "/" + year;
                                textViewFecha.setText(fechaSeleccionada);
                            }
                        }, year, month, dayOfMonth);

                datePickerDialog.show();
            }
        });

        guardarNotaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombreNota = editTextNombreNota.getText().toString();
                String descripcion = editTextDescripcion.getText().toString();

                // Guardar la nota en la tabla de notas
                /*dbHelper = new DatabaseHandler(AggNota.this);
                SQLiteDatabase db = dbHelper.getWritableDatabase();

                ContentValues values = new ContentValues();
                values.put(Tables.Notas.COLUMNA_NOMBRE, nombreNota);
                values.put(Tables.Notas.COLUMNA_DESCRIPCION, descripcion);
                values.put(Tables.Notas.COLUMNA_FECHA, fechaSeleccionada);

                long newRowId = db.insert(Tables.Notas.NOMBRE_TABLA, null, values);

                if (newRowId != -1) {
                    Toast.makeText(AggNota.this, "Nota guardada", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(AggNota.this, "Error al guardar la nota", Toast.LENGTH_SHORT).show();
                }

                // Cerrar la base de datos
                db.close();
AggNota
                 */

                // Después de guardar la nota, inicia la actividad ListNotasActivity
                Intent intent = new Intent(AggNota.this, ListNotasActivity.class);
                startActivity(intent);
            }
        });

        volverNotaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Crear un Intent para abrir ListNotasActivity
                Intent intent = new Intent(AggNota.this, ListNotasActivity.class);
                startActivity(intent);
            }
        });
    }
}
