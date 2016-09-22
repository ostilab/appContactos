/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.osti.ostirh.appContacto.Modelo;

/**
 *
 * @author Samuel Mavungo
 */
public class Contacto {

    public Contacto(String nome, String email, String mensagem, long telefone) {
        this.nome = nome;
        this.email = email;
        this.mensagem = mensagem;
        this.telefone = telefone;
    }

    private String nome;
    private String email;
    private String mensagem;
    private long telefone;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public long getTelefone() {
        return telefone;
    }

    public void setTelefone(long telefone) {
        this.telefone = telefone;
    }
}
