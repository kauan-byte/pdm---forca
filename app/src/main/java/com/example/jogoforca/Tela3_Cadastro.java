package com.example.jogoforca;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class Tela3_Cadastro extends AppCompatActivity implements View.OnClickListener{
 private Button btnCadastro, btnListar;
 private EditText caixaPalavra;
 private RadioGroup grupo;
 private String categoriaSelecionada, palavraDigitada;
 private BD bd;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tela3_cadastro);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        btnCadastro = findViewById(R.id.button2);
        btnCadastro.setOnClickListener(this);
        btnListar = findViewById(R.id.button4);
        btnListar.setOnClickListener(this);
        categoriaSelecionada = "Objeto Escolar";
        caixaPalavra = findViewById(R.id.editTextText);
        grupo = findViewById(R.id.id_grupo);
        grupo.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(@NonNull RadioGroup group, int i) {
                if(group == grupo){
                    if(i == R.id.radioButton2){
                        categoriaSelecionada = "Frutas";
                    }
                    if(i == R.id.radioButton4){
                        categoriaSelecionada = "Ferramenta";
                    }
                    if(i == R.id.radioButton5){
                        categoriaSelecionada = "Objeto Escolar";
                    }
                    if(i == R.id.radioButton6){
                        categoriaSelecionada = "Eletrodoméstico";
                    }
                    if(i == R.id.radioButton7){
                        categoriaSelecionada = "Esporte";
                    }
                }
            }
        });
        bd = new BD(Tela3_Cadastro.this);
    }

    @Override
    public void onClick(View v) {
        if(v == btnCadastro){
            palavraDigitada = caixaPalavra.getText().toString();
            Palavra p = new Palavra();
            p.setNome(palavraDigitada);
            p.setCategoria(categoriaSelecionada);
            bd.salvarPalavra(p);
            Toast.makeText(this, "Salvo!", Toast.LENGTH_SHORT).show();
        }
        if(v == btnListar){
            ArrayList<Palavra> lista = new ArrayList<Palavra>();
            lista = bd.listarPalavras();
            String stringao = new String();
            for(int i =0; i< lista.size(); i++){
                stringao+= lista.get(i).getNome() +"|"+lista.get(i).getCategoria()+" ";
            }
            Toast.makeText(this, stringao, Toast.LENGTH_SHORT).show();
        }

    }
}