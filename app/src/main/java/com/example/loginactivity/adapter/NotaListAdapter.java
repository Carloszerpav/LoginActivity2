package com.example.loginactivity.adapter;


import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.loginactivity.activities.AgregarNotaActivity;
import com.example.loginactivity.activities.ListNotasActivity;
import com.example.loginactivity.domains.Nota;
import com.example.loginactivity.R;

import java.time.LocalDate;
import java.util.List;

import entidades.DatabaseHandler;

public class NotaListAdapter extends RecyclerView.Adapter<NotaListAdapter.ViewHolder> {
    private List<Nota> listadoNotas;

    public NotaListAdapter(List<Nota> notas) {
        listadoNotas = notas;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Nota item = listadoNotas.get(position);
        holder.textViewId.setText("ID: " + item.getId());
        holder.textViewNombre.setText("NOMBRE: " + item.getNombre());
        holder.textViewDescripcion.setText("DESCRIPCION: " +item.getDescripcion());
        holder.textViewFecha.setText("FECHA: " + item.getFecha());

        holder.btnEliminarNota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Llama a un método para eliminar el elemento en esta posición

            }
        });
    }

    // Método para eliminar una nota
    public void eliminarNota(int position) {
        if (position >= 0 && position < listadoNotas.size()) {
            // Elimina el elemento de la lista de datos
            listadoNotas.remove(position);
            // Notifica al adaptador que se ha eliminado un elemento en esta posición
            notifyItemRemoved(position);
        }
    }

    @Override
    public int getItemCount() {
        return listadoNotas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textViewId;
        TextView textViewNombre;
        TextView textViewDescripcion;
        TextView textViewFecha;
        Button btnEditarNota;
        Button btnEliminarNota;

        public ViewHolder(View itemView) {
            super(itemView);

            textViewId = itemView.findViewById(R.id.textViewId);
            textViewNombre = itemView.findViewById(R.id.textViewNombre);
            textViewDescripcion = itemView.findViewById(R.id.textViewDescripcion);
            textViewFecha = itemView.findViewById(R.id.textViewFecha);
            btnEditarNota = itemView.findViewById(R.id.btnEditarNota);
            btnEliminarNota = itemView.findViewById(R.id.btnEliminarNota);
        }
    }

    public List<Nota> getListadoNotas() {
        return listadoNotas;
    }

    public void setListadoNotas(List<Nota> listadoNotas) {
        this.listadoNotas = listadoNotas;
    }
}
