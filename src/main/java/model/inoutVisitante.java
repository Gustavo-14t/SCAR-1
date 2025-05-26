/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Todosdecasa
 */
public class inoutVisitante {
    
    
String id_ControleEntradaSaida;
String nomeMorador;
String nomeVisitante;
String nomeFuncionario;
String dataVisita;
String statu;

    public inoutVisitante(String id_ControleEntradaSaida, String nomeMorador, String nomeVisitante, String nomeFuncionario, String dataVisita, String statu) {
        this.id_ControleEntradaSaida = id_ControleEntradaSaida;
        this.nomeMorador = nomeMorador;
        this.nomeVisitante = nomeVisitante;
        this.nomeFuncionario = nomeFuncionario;
        this.dataVisita = dataVisita;
        this.statu = statu;
    }

    public inoutVisitante() {
    }

    public String getId_ControleEntradaSaida() {
        return id_ControleEntradaSaida;
    }

    public void setId_ControleEntradaSaida(String id_ControleEntradaSaida) {
        this.id_ControleEntradaSaida = id_ControleEntradaSaida;
    }

    public String getNomeMorador() {
        return nomeMorador;
    }

    public void setNomeMorador(String nomeMorador) {
        this.nomeMorador = nomeMorador;
    }

    public String getNomeVisitante() {
        return nomeVisitante;
    }

    public void setNomeVisitante(String nomeVisitante) {
        this.nomeVisitante = nomeVisitante;
    }

    public String getNomeFuncionario() {
        return nomeFuncionario;
    }

    public void setNomeFuncionario(String nomeFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
    }

    public String getDataVisita() {
        return dataVisita;
    }

    public void setDataVisita(String dataVisita) {
        this.dataVisita = dataVisita;
    }

    public String getStatu() {
        return statu;
    }

    public void setStatu(String statu) {
        this.statu = statu;
    }


    
}
