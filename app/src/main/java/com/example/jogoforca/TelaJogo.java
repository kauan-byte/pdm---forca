package com.example.jogoforca;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.IntegerRes;
import androidx.appcompat.app.AlertDialog;
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
    private ArrayList<Palavra> listaPalavras;
    private ArrayList<Integer> listaIDsButtons;
    private int indiceImagem;
    private TextView txAcerto, txErro;
    private int acerto, erro;
    private BD bd;
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
        acerto = 0;
        erro = 0;
        listaImagem = new ArrayList<Integer>();
        listaImagem.add(R.drawable.forca_1_9);
        listaImagem.add(R.drawable.forca_2_9);
        listaImagem.add(R.drawable.forca_3_9);
        listaImagem.add(R.drawable.forca_4_9);
        listaImagem.add(R.drawable.forca_5_9);
        listaImagem.add(R.drawable.forca_6_9);
        listaImagem.add(R.drawable.forca_7_9);
        listaImagem.add(R.drawable.forca_9_9);
        listaImagem.add(R.drawable.forca_10_9);
        listaImagem.add(R.drawable.forca_11_9);

        bd = new BD(TelaJogo.this);
        listaPalavras = new ArrayList<Palavra>();
        listaPalavras = bd.listarPalavras();

        texto = findViewById(R.id.imageView3);
        palavra = new String();

        txAcerto = findViewById(R.id.textAcerto);
        txErro = findViewById(R.id.textErro);


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
        indiceImagem = 0;
        acerto = 0;
        erro = 0;
        palavra = sorteiaPalavra();
        estado = new char[palavra.length()];
        for (int i=0; i<estado.length;i++){
            estado[i] = '_';
        }
        atualizaTexto();
        for(int i=0; i<listaIDsButtons.size(); i++){
            Button b = findViewById(listaIDsButtons.get(i));
            b.setEnabled(true);
        }
        txErro.setText(Integer.toString(erro)+"/"+Integer.toString(listaImagem.size()));
        txAcerto.setText(Integer.toString(acerto));
    }

    public String sorteiaPalavra(){
        String sorteado;
        Collections.shuffle(listaPalavras);
        sorteado = listaPalavras.get(0).getNome();
        return sorteado;
    }

    public void atualizaImagem(){
        imagem.setImageResource(listaImagem.get(indiceImagem));
        indiceImagem++;
    }

    public void atualizaTexto(){
        String temp = "";
        for (int j=0; j<estado.length; j++){
            temp += estado[j]+ " ";
        }
        texto.setText(temp);
    }

    public void verificaLetra(char c){
        boolean status = false;
        for(int i=0;i<palavra.length();i++){
            if(palavra.charAt(i)==c){
                status = true;
                estado[i] = c;
            }
        }
        if(!status){
            atualizaImagem();
            erro++;
            txErro.setText(Integer.toString(erro)+"/"+Integer.toString(listaImagem.size()));
            checaTermino();
        }else{
            atualizaTexto();
            acerto++;
            txAcerto.setText(Integer.toString(acerto));
            checaTermino();
        }
    }

    public void checaTermino(){
        boolean verifica = false;
        for(int i =0;i<estado.length;i++){
            if(estado[i]=='_'){
                verifica = true;
                //se foi para true é pq ainda tem underline
            }
        }
        if(!verifica){
            //aqui se ele ganhou
            AlertDialog.Builder caixa = new AlertDialog.Builder(this);
            caixa.setTitle("Você Ganhou :)");
            caixa.setMessage("Deseja jogar novamente?");
            caixa.setPositiveButton("Jogar", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    inicializaJogo();
                }
            });
            caixa.show();
        }
        if(erro >= listaImagem.size()){
            AlertDialog.Builder caixa = new AlertDialog.Builder(this);
            caixa.setTitle("Você Perdeu :(");
            caixa.setMessage("Deseja jogar novamente?");
            caixa.setPositiveButton("Jogar", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    inicializaJogo();
                }
            });
            caixa.show();
        }
    }

    @Override
    public void onClick(View v) {
       Button b = (Button) v;
       b.setEnabled(false);
       verificaLetra(b.getText().toString().charAt(0));
    }
}