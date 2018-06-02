package br.com.rcamilo.customer.model;

import java.io.Serializable;

public class Account {

    private Integer id;

    private Integer tipo;

    private String numero;

    public Account() {
    }

    public Account(Integer id, Integer tipo, String numero) {
        this.id = id;
        this.tipo = tipo;
        this.numero= numero;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
}
