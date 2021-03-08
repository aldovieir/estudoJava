package com.estudojava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import java.io.IOException;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Formulario2 extends AppCompatActivity {

    private TextView cpf, dataNascimento, nomeMae, resultGenero;
    private RadioButton masculino, feminino, outros;
    Modelcadastro cadastro;
    Button cadastrar;
    Button irListaCadastros;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario2);

        cpf = findViewById(R.id.cpf);
        dataNascimento = findViewById(R.id.datanascimnto);
        nomeMae = findViewById(R.id.nome_mae);
        masculino = findViewById(R.id.masculino);
        feminino = findViewById(R.id.feminino);
        outros = findViewById(R.id.outros);
        cadastrar = findViewById(R.id.botaocadastrar);
        irListaCadastros= findViewById(R.id.botaoListarCadastros);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://603c2f43f4333a0017b673f2.mockapi.io/")
                .addConverterFactory(GsonConverterFactory.create()).build();

        String genero  = "";
        String setCpf = cpf.getText().toString();
        String setData = dataNascimento.getText().toString();
        String setNomemae= nomeMae.getText().toString();
        String deleting = "false";
        if(masculino.isChecked()){
            genero = "Masculino";
        } else if( feminino.isChecked()){
            genero= "Feminino";
        } else if(outros.isChecked()){
            genero = "outros";
        }
        cadastro = new Modelcadastro();
        cadastro.setCpf(setCpf);
        cadastro.setNome_mae(setNomemae);
        cadastro.setGenero(genero);
        cadastro.setData_nascimento(setData);
        cadastro.setIsDeleting(deleting);
        cadastro.setId("2");
        cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MockApi mockApi = retrofit.create(MockApi.class);
                Call<Modelcadastro>  response = mockApi.cadastrar(cadastro);

                try {
                    response.execute();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });


        irListaCadastros.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent1 = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent1);
            }
        });

    }


    }
