package entidades;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.loginactivity.domains.Nota;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "TESTDB";
    private static final String TABLE_NOTA = "NOTA";
    private static final String TABLE_NOTA_COLUMNA_ID = "id";
    private static final String TABLE_NOTA_COLUMNA_NOMBRE = "nombre";
    private static final String TABLE_NOTA_COLUMNA_DESCRIPCION = "descripcion";
    private static final String TABLE_NOTA_COLUMNA_FECHA = "fecha";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creacion de tablas
    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NOTA + " (" +
                TABLE_NOTA_COLUMNA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                TABLE_NOTA_COLUMNA_NOMBRE + " TEXT, " +
                TABLE_NOTA_COLUMNA_DESCRIPCION + " TEXT, " +
                TABLE_NOTA_COLUMNA_FECHA + " TEXT)";

        db.execSQL(query);
    }

    // Actualizando la base de datos
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Eliminar la tabla anterior si existía
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NOTA);
        // Crear tablas nuevamente
        onCreate(db);
    }

    /**
     * Operaciones: Insertar, Leer, Actualizar y Eliminar Notas
     */

    // Insertar Nota
    public void addNota(Nota nota) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues notaNueva = new ContentValues();

        notaNueva.put(TABLE_NOTA_COLUMNA_NOMBRE, nota.getNombre());
        notaNueva.put(TABLE_NOTA_COLUMNA_DESCRIPCION, nota.getDescripcion());
        notaNueva.put(TABLE_NOTA_COLUMNA_FECHA, nota.getFecha());

        // Insertando fila
        long id = db.insert(TABLE_NOTA, null, notaNueva);
        int parseInt = (int) id;
        nota.setId(parseInt);

        db.close(); // Cerrando conexion a base de datos
    }

    // Obtener una nota
    Nota getNota(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_NOTA, new String[] { TABLE_NOTA_COLUMNA_ID,
                        TABLE_NOTA_COLUMNA_NOMBRE, TABLE_NOTA_COLUMNA_DESCRIPCION, TABLE_NOTA_COLUMNA_FECHA }, TABLE_NOTA_COLUMNA_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);

        if (cursor != null)
            cursor.moveToFirst();

        Nota nota = new Nota(
                Integer.parseInt(cursor.getString(0)),
                cursor.getString(1),
                cursor.getString(2),
                cursor.getString(3)
        );
        // return country
        return nota;
    }

    // Obtener todas las notas
    public List<Nota> getAllNotas() {
        List<Nota> notaList = new ArrayList<>();
        // Seleccionar todas las filas
        String selectQuery = "SELECT  * FROM " + TABLE_NOTA;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // Recorrer todas las filas y agregar a la lista
        if (cursor.moveToFirst()) {
            do {
                Nota nota = new Nota();
                nota.setId(Integer.parseInt(cursor.getString(0)));
                nota.setNombre(cursor.getString(1));
                nota.setDescripcion(cursor.getString(2));
                nota.setFecha(cursor.getString(3));
                // Agregando Nota a la lista
                notaList.add(nota);
            } while (cursor.moveToNext());
        }

        // return country list
        return notaList;
    }

    // Actualizar nota
    public int updateNota(Nota nota) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues notaEditada = new ContentValues();
        notaEditada.put(TABLE_NOTA_COLUMNA_NOMBRE, nota.getNombre());
        notaEditada.put(TABLE_NOTA_COLUMNA_DESCRIPCION, nota.getDescripcion()); // Descripcion
        notaEditada.put(TABLE_NOTA_COLUMNA_FECHA, nota.getFecha()); // Fecha

        // updating row
        return db.update(TABLE_NOTA, notaEditada, TABLE_NOTA_COLUMNA_ID + " = ?",
                new String[] { String.valueOf(nota.getId()) });
    }

    // Eliminar nota
    public void deleteNota(Nota nota) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NOTA, TABLE_NOTA_COLUMNA_ID + " = ?",
                new String[] { String.valueOf(nota.getId()) });
        db.close();
    }

    // Eliminar todas las notas
    public void deleteAllNotas() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NOTA,null,null);
        db.close();
    }

}
