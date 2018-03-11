package com.example.feeder.cadastro;

import java.io.Serializable;

/**
 * Created by feeder on 11/03/18.
 */

public class Usuario implements Serializable{

    String ra;
    String email;
    String endereco;
    String nome;

    public String getRa() {
        return ra;
    }

    public void setRa(String ra) {
        this.ra = ra;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
