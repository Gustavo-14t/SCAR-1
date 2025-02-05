/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author devmat
 */
public class Atividade {
    
    int id_atividade;
    int id_funcionario;
    String nome;
    String descricao;
    String datas;
    String statu;
    
    //Construtor vazio;
    public Atividade (){}
    
    // Construtor com todas as informacoes abaixo;

    public Atividade(int id_atividade, int id_funcionario, String nome, String descricao, String datas, String statu) {
        this.id_atividade = id_atividade;
        this.id_funcionario = id_funcionario;
        this.nome = nome;
        this.descricao = descricao;
        this.datas = datas;
        this.statu = statu;
    }

    public Atividade(int id_funcionario, String nome, String descricao, String datas, String statu) {
        this.id_funcionario = id_funcionario;
        this.nome = nome;
        this.descricao = descricao;
        this.datas = datas;
        this.statu = statu;
    }

    public int getId_atividade() {
        return id_atividade;
    }

    public void setId_atividade(int id_atividade) {
        this.id_atividade = id_atividade;
    }

    public int getId_funcionario() {
        return id_funcionario;
    }

    public void setId_funcionario(int id_funcionario) {
        this.id_funcionario = id_funcionario;
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

    public String getDatas() {
        return datas;
    }

    public void setDatas(String datas) {
        this.datas = datas;
    }

    public String getStatu() {
        return statu;
    }

    public void setStatu(String statu) {
        this.statu = statu;
    }
    
    
}
