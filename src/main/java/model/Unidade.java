/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author devmat
 */
public class Unidade {
    
    int id_unidade;
     int id_chave;
    String tipo;
    String numero;
    String bloco;
    String capacidade;
    String descricao;
    String nome;
    String domensoes;

    public Unidade(int id_unidade, int id_chave, String tipo, String numero, String bloco, String capacidade, String descricao, String nome, String domensoes) {
        this.id_unidade = id_unidade;
        this.id_chave = id_chave;
        this.tipo = tipo;
        this.numero = numero;
        this.bloco = bloco;
        this.capacidade = capacidade;
        this.descricao = descricao;
        this.nome = nome;
        this.domensoes = domensoes;
    }

    public Unidade(int id_chave, String tipo, String numero, String bloco, String capacidade, String descricao, String nome, String domensoes) {
        this.id_chave = id_chave;
        this.tipo = tipo;
        this.numero = numero;
        this.bloco = bloco;
        this.capacidade = capacidade;
        this.descricao = descricao;
        this.nome = nome;
        this.domensoes = domensoes;
    }

    public Unidade() {
    }

    public int getId_unidade() {
        return id_unidade;
    }

    public void setId_unidade(int id_unidade) {
        this.id_unidade = id_unidade;
    }

    public int getId_chave() {
        return id_chave;
    }

    public void setId_chave(int id_chave) {
        this.id_chave = id_chave;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBloco() {
        return bloco;
    }

    public void setBloco(String bloco) {
        this.bloco = bloco;
    }

    public String getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(String capacidade) {
        this.capacidade = capacidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDomensoes() {
        return domensoes;
    }

    public void setDomensoes(String domensoes) {
        this.domensoes = domensoes;
    }
    
    
    
}
