package com.estudojava;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Stream;

public class Modelcadastro{



    public Modelcadastro(
        String cpf, String nome_mae, String id, String data_nascimento, String genero, String
        isDeleting
    ) {
        this.cpf = cpf;
        this.nome_mae = nome_mae;
        this.id = id;
        this.data_nascimento = data_nascimento;
        this.genero = genero;
        this.isDeleting = isDeleting;
    }



    private String cpf, nome_mae, id, data_nascimento, genero, isDeleting;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome_mae() {
        return nome_mae;
    }

    public void setNome_mae(String nome_mae) {
        this.nome_mae = nome_mae;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(String data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getIsDeleting() {
        return isDeleting;
    }

    public void setIsDeleting(String isDeleting) {
        this.isDeleting = isDeleting;
    }

    public Modelcadastro() {

    }





}
