package com.example.jogoforca;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Tela3_Cadastro extends AppCompatActivity implements View.OnClickListener,{
 private Button btnCadastro, btnLister;
 private EditText caixaPalavra;
 private RadioGroup grupo;
 private String categoriaSelecionada;



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
        btnLister = findViewById(R.id.button4);
        btnLister.setOnClickListener(this);
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
    }

    @Override
    public void onClick(View v) {

    }
}