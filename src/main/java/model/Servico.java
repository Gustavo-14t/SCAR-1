/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author devmat
 */
public class Servico {
    int id_servico;
    String nomeMorador;
    String nome;
    String descricao;
    String prazo;
    String statu;

    public Servico(int id_servico, String nomeMorador, String nome, String descricao, String prazo, String statu) {
        this.id_servico = id_servico;
        this.nomeMorador = nomeMorador;
        this.nome = nome;
        this.descricao = descricao;
        this.prazo = prazo;
        this.statu = statu;
    }

    public Servico(String nomeMorador, String nome, String descricao, String prazo, String statu) {
        this.nomeMorador = nomeMorador;
        this.nome = nome;
        this.descricao = descricao;
        this.prazo = prazo;
        this.statu = statu;
    }

    public Servico() {
    }

    public int getId_servico() {
        return id_servico;
    }

    public void setId_servico(int id_servico) {
        this.id_servico = id_servico;
    }

    public String getNomeMorador() {
        return nomeMorador;
    }

    public void setNomeMorador(String nomeMorador) {
        this.nomeMorador = nomeMorador;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getPrazo() {
        return prazo;
    }

    public void setPrazo(String prazo) {
        this.prazo = prazo;
    }

    public String getStatu() {
        return statu;
    }

    public void setStatu(String statu) {
        this.statu = statu;
    }
    
    
}
