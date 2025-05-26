/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Todosdecasa
 */
public class moradorAndINOUT {
    
   String id_morEntradaSaida;
   String id_morador;
   String nome;
   String cpf;
   String email;
   String data_nasc;

    public moradorAndINOUT(String id_morEntradaSaida, String id_morador, String nome, String cpf, String email, String data_nasc) {
        this.id_morEntradaSaida = id_morEntradaSaida;
        this.id_morador = id_morador;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.data_nasc = data_nasc;
    }

    public moradorAndINOUT() {
    }

    public String getId_morEntradaSaida() {
        return id_morEntradaSaida;
    }

    public void setId_morEntradaSaida(String id_morEntradaSaida) {
        this.id_morEntradaSaida = id_morEntradaSaida;
    }

    public String getId_morador() {
        return id_morador;
    }

    public void setId_morador(String id_morador) {
        this.id_morador = id_morador;
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
