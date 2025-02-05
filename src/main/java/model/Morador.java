/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author devmat
 */
public class Morador {
    
    int id_morador;
    int id_unidade;
    String nome;
    String cpf;
    String email;
    String data_nasc;
    
    // ATENÇÃO !! caso dê erro vá no banco de dados, pode ser que esteja string aqui e "date" lá
// Construtor Vazio;
    
    public Morador (){}
    // 
    
    // Contrutor com todas as informaçoes;
    public Morador(int id_morador, int id_unidade, String nome, String cpf, String email, String data_nasc) {
        this.id_morador = id_morador;
        this.id_unidade = id_unidade;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.data_nasc = data_nasc;
    }

    public Morador(int id_unidade, String nome, String cpf, String email, String data_nasc) {
        this.id_unidade = id_unidade;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.data_nasc = data_nasc;
    }

    public int getId_morador() {
        return id_morador;
    }

    public void setId_morador(int id_morador) {
        this.id_morador = id_morador;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getData_nasc() {
        return data_nasc;
    }

    public void setData_nasc(String data_nasc) {
        this.data_nasc = data_nasc;
    }
    
    
}
