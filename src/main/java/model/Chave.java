/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author devmat
 */
public class Chave {
    
    int id_chave;
    int id_unidade;
    String nome;
    
    //Construtor vazio;
    
    public Chave (){}
    
    // Construtor com todas as informaçõe;

    public Chave(int id_chave, int id_unidade, String nome) {
        this.id_chave = id_chave;
        this.id_unidade = id_unidade;
        this.nome = nome;
    }

    public Chave(int id_unidade, String nome) {
        this.id_unidade = id_unidade;
        this.nome = nome;
    }

    public int getId_chave() {
        return id_chave;
    }

    public void setId_chave(int id_chave) {
        this.id_chave = id_chave;
    }

    public int getId_unidade() {
        return id_unidade;
    }

    public void setId_unidade(int id_unidade) {
        this.id_unidade = id_unidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
}
