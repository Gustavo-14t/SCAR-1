/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author devmat
 */
public class ReservaList {
    
    String chave;
    String morador;
    String unidade;
    String funcionario;
    String data_reserva;
    String statu;  

    public ReservaList() {
    }

    public ReservaList(String chave, String morador, String unidade, String funcionario, String data_reserva, String statu) {
        this.chave = chave;
        this.morador = morador;
        this.unidade = unidade;
        this.funcionario = funcionario;
        this.data_reserva = data_reserva;
        this.statu = statu;
    }
    public String getChave() {
        return chave;
    }

    public void setChave(String chave) {
        this.chave = chave;
    }

    public String getMorador() {
        return morador;
    }

    public void setMorador(String morador) {
        this.morador = morador;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public String getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(String funcionario) {
        this.funcionario = funcionario;
    }

    public String getData_reserva() {
        return data_reserva;
    }

    public void setData_reserva(String data_reserva) {
        this.data_reserva = data_reserva;
    }

    public String getStatu() {
        return statu;
    }

    public void setStatu(String statu) {
        this.statu = statu;
    }
    
   
}
