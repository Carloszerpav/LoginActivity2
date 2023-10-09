package com.example.loginactivity.domains;

import static android.R.attr.name;
import static android.R.attr.theme;

public class Nota {
    int id;
    String nombre;
    String descripcion;
    String fecha;

    public Nota(){
        super();
    }

    public Nota(int id, String nombre, String descripcion, String fecha){
        super();
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fecha = fecha;
    }

    public Nota(String nombre, String descripcion, String fecha){
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fecha = fecha;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getFecha() {
        return fecha;
    }
}
