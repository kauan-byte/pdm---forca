package com.example.jogoforca;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.IntegerRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class TelaJogo extends AppCompatActivity implements View.OnClickListener {

    private ImageView imagem;
    private String palavra;
    private char[] estado;
    private TextView texto;
    private ArrayList<Integer> listaImagem;
    private ArrayList<String> listaPalavras;
    private ArrayList<Integer> listaIDsButtons;
    private int indiceImagem;
    private Button b1;

    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tela_jogo);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        imagem = findViewById(R.id.imageView);
        indiceImagem = 0;
        listaImagem = new ArrayList<Integer>();
        listaImagem.add(R.drawable.forca_1_9);
        listaImagem.add(R.drawable.forca_2_9);
        listaImagem.add(R.drawable.forca_3_9);
        listaImagem.add(R.drawable.forca_4_9);
        listaImagem.add(R.drawable.forca_5_9);
        listaImagem.add(R.drawable.forca_6_9);
        listaImagem.add(R.drawable.forca_7_9);
        listaImagem.add(R.drawable.forca_9_9);

        b1 = findViewById(R.id.btn1);
        b1.setOnClickListener(this);


        listaPalavras = new ArrayList<String>();
        listaPalavras.add("CASA");
        listaPalavras.add("ABACATE");
        listaPalavras.add("TOMATE");
        listaPalavras.add("LIXO");
        listaPalavras.add("CADEIRA");
        listaPalavras.add("CARTEIRA");
        listaPalavras.add("MESA");
        listaPalavras.add("ASFALTO");
        listaPalavras.add("CARRETA");
        listaPalavras.add("TROMBONE");
        listaPalavras.add("QUEIJO");

        texto = findViewById(R.id.imageView3);
        palavra = new String();

        listaIDsButtons = new ArrayList<Integer>();
        listaIDsButtons.add(R.id.btn1);
        listaIDsButtons.add(R.id.btn2);
        listaIDsButtons.add(R.id.btn3);
        listaIDsButtons.add(R.id.btn4);
        listaIDsButtons.add(R.id.btn5);
        listaIDsButtons.add(R.id.btn6);
        listaIDsButtons.add(R.id.btn7);
        listaIDsButtons.add(R.id.btn8);
        listaIDsButtons.add(R.id.btn9);
        listaIDsButtons.add(R.id.btn10);
        listaIDsButtons.add(R.id.btn11);
        listaIDsButtons.add(R.id.btn12);
        listaIDsButtons.add(R.id.btn13);
        listaIDsButtons.add(R.id.btn14);
        listaIDsButtons.add(R.id.btn15);
        listaIDsButtons.add(R.id.btn16);
        listaIDsButtons.add(R.id.btn17);
        listaIDsButtons.add(R.id.btn18);
        listaIDsButtons.add(R.id.btn19);
        listaIDsButtons.add(R.id.btn20);
        listaIDsButtons.add(R.id.btn21);
        listaIDsButtons.add(R.id.btn22);
        listaIDsButtons.add(R.id.btn23);
        listaIDsButtons.add(R.id.btn24);
        listaIDsButtons.add(R.id.btn25);
        listaIDsButtons.add(R.id.btn26);

        for(int i=0; i<listaIDsButtons.size(); i++){
            Button b = findViewById(listaIDsButtons.get(i));
            b.setOnClickListener(this);
        }

        inicializaJogo();
    }

    public void inicializaJogo(){
        imagem.setImageResource(R.drawable.forca_0_9);
        palavra = sorteiaPalavra();
        estado = new char[palavra.length()];
        for (int i=0; i<estado.length;i++){
            estado[i] = '_';
        }
        String temp = "";
        for (int j=0; j<estado.length; j++){
            temp += estado[j]+ " ";
        }

        texto.setText(temp);

        for(int i=0; i<listaIDsButtons.size(); i++){
            Button b = findViewById(listaIDsButtons.get(i));
            b.setEnabled(true);
        }
    }

    public String sorteiaPalavra(){
        String sorteado;
        Collections.shuffle(listaPalavras);
        sorteado = listaPalavras.get(0);
        return sorteado;
    }

    public void atualizaImagem(){
        imagem.setImageResource(listaImagem.get(indiceImagem));
        indiceImagem++;
    }

    @Override
    public void onClick(View v) {
       Button b = (Button) v;
       b.setEnabled(false);
       texto.setText(b.getText().toString());
    }
}