package entidades;

public class ScriptDB {
    public static final String TABLE_NOTAS = "notas";
    public static final String TABLE_NOTAS_COLUMNA_ID = "id";
    public static final String TABLE_NOTAS_COLUMNA_NOMBRE = "nombre";
    public static final String TABLE_NOTAS_COLUMNA_DESCRIPCION = "descripcion";
    public static final String TABLE_NOTAS_COLUMNA_FECHA = "fecha";

    public String getScriptCreateTableNotas(){

        return  "CREATE TABLE " + TABLE_NOTAS + " (" +
                TABLE_NOTAS_COLUMNA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                TABLE_NOTAS_COLUMNA_NOMBRE + " TEXT, " +
                TABLE_NOTAS_COLUMNA_DESCRIPCION + " TEXT, " +
                TABLE_NOTAS_COLUMNA_FECHA + " TEXT)";
    }


}
