/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author devmat
 */
public class Visitante {
    
int id_visitante;
String Nome;
String Cpf;
String Telefone;
String PlacaVeiculo;

    public Visitante(int id_visitante, String Nome, String Cpf, String Telefone, String PlacaVeiculo) {
        this.id_visitante = id_visitante;
        this.Nome = Nome;
        this.Cpf = Cpf;
        this.Telefone = Telefone;
        this.PlacaVeiculo = PlacaVeiculo;
    }

    public Visitante(String Nome, String Cpf, String Telefone, String PlacaVeiculo) {
        this.Nome = Nome;
        this.Cpf = Cpf;
        this.Telefone = Telefone;
        this.PlacaVeiculo = PlacaVeiculo;
    }

    public Visitante() {
    }

    public int getId_visitante() {
        return id_visitante;
    }

    public void setId_visitante(int id_visitante) {
        this.id_visitante = id_visitante;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getCpf() {
        return Cpf;
    }

    public void setCpf(String Cpf) {
        this.Cpf = Cpf;
    }

    public String getTelefone() {
        return Telefone;
    }

    public void setTelefone(String Telefone) {
        this.Telefone = Telefone;
    }

    public String getPlacaVeiculo() {
        return PlacaVeiculo;
    }

    public void setPlacaVeiculo(String PlacaVeiculo) {
        this.PlacaVeiculo = PlacaVeiculo;
    }
    


}
