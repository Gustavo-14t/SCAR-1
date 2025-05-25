/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Todosdecasa
 */
public class controleINOUTmorador {
    
    String id_CMINOUT;
    String id_morEntradaSaida;
    int id_funcionario; 
    String funcionarioSaida;
    String dataSaida; 
    String funcionarioEntrada;
    String dataEntrada;
    String statu;

    public controleINOUTmorador(String id_CMINOUT, String id_morEntradaSaida, int id_funcionario, String funcionarioSaida, String dataSaida, String funcionarioEntrada, String dataEntrada, String statu) {
        this.id_CMINOUT = id_CMINOUT;
        this.id_morEntradaSaida = id_morEntradaSaida;
        this.id_funcionario = id_funcionario;
        this.funcionarioSaida = funcionarioSaida;
        this.dataSaida = dataSaida;
        this.funcionarioEntrada = funcionarioEntrada;
        this.dataEntrada = dataEntrada;
        this.statu = statu;
    }

    public controleINOUTmorador(String id_morEntradaSaida, int id_funcionario, String funcionarioSaida, String dataSaida, String funcionarioEntrada, String dataEntrada, String statu) {
        this.id_morEntradaSaida = id_morEntradaSaida;
        this.id_funcionario = id_funcionario;
        this.funcionarioSaida = funcionarioSaida;
        this.dataSaida = dataSaida;
        this.funcionarioEntrada = funcionarioEntrada;
        this.dataEntrada = dataEntrada;
        this.statu = statu;
    }

    public controleINOUTmorador() {
    }

    public String getId_CMINOUT() {
        return id_CMINOUT;
    }

    public void setId_CMINOUT(String id_CMINOUT) {
        this.id_CMINOUT = id_CMINOUT;
    }

    public String getId_morEntradaSaida() {
        return id_morEntradaSaida;
    }

    public void setId_morEntradaSaida(String id_morEntradaSaida) {
        this.id_morEntradaSaida = id_morEntradaSaida;
    }

    public int getId_funcionario() {
        return id_funcionario;
    }

    public void setId_funcionario(int id_funcionario) {
        this.id_funcionario = id_funcionario;
    }

    public String getFuncionarioSaida() {
        return funcionarioSaida;
    }

    public void setFuncionarioSaida(String funcionarioSaida) {
        this.funcionarioSaida = funcionarioSaida;
    }

    public String getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(String dataSaida) {
        this.dataSaida = dataSaida;
    }

    public String getFuncionarioEntrada() {
        return funcionarioEntrada;
    }

    public void setFuncionarioEntrada(String funcionarioEntrada) {
        this.funcionarioEntrada = funcionarioEntrada;
    }

    public String getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(String dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public String getStatu() {
        return statu;
    }

    public void setStatu(String statu) {
        this.statu = statu;
    }

   
    
    

    
}
