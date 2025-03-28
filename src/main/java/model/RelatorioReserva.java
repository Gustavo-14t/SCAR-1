/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author devmat
 */
public class RelatorioReserva {

   String func_entrega;
   String data_entrega;
   String func_devolucao;
   String data_devolucao;
   String morador;

   
    public RelatorioReserva(String func_entrega, String data_entrega, String func_devolucao, String data_devolucao, String morador) {
        this.func_entrega = func_entrega;
        this.data_entrega = data_entrega;
        this.func_devolucao = func_devolucao;
        this.data_devolucao = data_devolucao;
        this.morador = morador;
    }
     public RelatorioReserva() {
    }
           
    public String getFunc_entrega() {
        return func_entrega;
    }

    public void setFunc_entrega(String func_entrega) {
        this.func_entrega = func_entrega;
    }

    public String getData_entrega() {
        return data_entrega;
    }

    public void setData_entrega(String data_entrega) {
        this.data_entrega = data_entrega;
    }

    public String getFunc_devolucao() {
        return func_devolucao;
    }

    public void setFunc_devolucao(String func_devolucao) {
        this.func_devolucao = func_devolucao;
    }

    public String getData_devolucao() {
        return data_devolucao;
    }

    public void setData_devolucao(String data_devolucao) {
        this.data_devolucao = data_devolucao;
    }

    public String getMorador() {
        return morador;
    }

    public void setMorador(String morador) {
        this.morador = morador;
    }

   
}
