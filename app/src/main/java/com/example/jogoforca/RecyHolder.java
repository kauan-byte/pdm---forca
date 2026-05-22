package com.example.jogoforca;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyHolder extends RecyclerView.ViewHolder {
    protected TextView txPalavra, txCategoria;
    public RecyHolder(@NonNull View itemView) {
        super(itemView);
        txPalavra = itemView.findViewById(R.id.txpalavra);
        txCategoria = itemView.findViewById(R.id.txcategoria);
    }
}
