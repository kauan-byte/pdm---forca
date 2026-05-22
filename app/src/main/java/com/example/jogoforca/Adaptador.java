package com.example.jogoforca;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adaptador extends RecyclerView.Adapter<RecyHolder> {
    private ArrayList<Palavra> lista;
    @NonNull
    @Override
    public RecyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout, parent, false);
        return new RecyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyHolder holder, int position) {
        holder.txPalavra.setText(lista.get(position).getNome());
        holder.txCategoria.setText(lista.get(position).getCategoria());
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }
    public Adaptador(ArrayList<Palavra> listaRecebida){
        this.lista = listaRecebida;
    }
}
