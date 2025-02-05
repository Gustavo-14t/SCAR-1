/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author devmat
 */
public class ControleReserva {
    
    int id_controleReserva;
    int id_reserva;
    String data_entrega;
    String data_devolucao;
    String funcionario_entrega;
    String funcionario_devolucao;
    
    // Construtor vazio;
    
   public ControleReserva (){}
   
   
   // Construtor com todas as informacoes abaixo;

    public ControleReserva(int id_controleReserva, int id_reserva, String data_entrega, String data_devolucao, String funcionario_entrega, String funcionario_devolucao) {
        this.id_controleReserva = id_controleReserva;
        this.id_reserva = id_reserva;
        this.data_entrega = data_entrega;
        this.data_devolucao = data_devolucao;
        this.funcionario_entrega = funcionario_entrega;
        this.funcionario_devolucao = funcionario_devolucao;
    }

    public ControleReserva(int id_reserva, String data_entrega, String data_devolucao, String funcionario_entrega, String funcionario_devolucao) {
        this.id_reserva = id_reserva;
        this.data_entrega = data_entrega;
        this.data_devolucao = data_devolucao;
        this.funcionario_entrega = funcionario_entrega;
        this.funcionario_devolucao = funcionario_devolucao;
    }

    public int getId_controleReserva() {
        return id_controleReserva;
    }

    public void setId_controleReserva(int id_controleReserva) {
        this.id_controleReserva = id_controleReserva;
    }

    public int getId_reserva() {
        return id_reserva;
    }

    public void setId_reserva(int id_reserva) {
        this.id_reserva = id_reserva;
    }

    public String getData_entrega() {
        return data_entrega;
    }

    public void setData_entrega(String data_entrega) {
        this.data_entrega = data_entrega;
    }

    public String getData_devolucao() {
        return data_devolucao;
    }

    public void setData_devolucao(String data_devolucao) {
        this.data_devolucao = data_devolucao;
    }

    public String getFuncionario_entrega() {
        return funcionario_entrega;
    }

    public void setFuncionario_entrega(String funcionario_entrega) {
        this.funcionario_entrega = funcionario_entrega;
    }

    public String getFuncionario_devolucao() {
        return funcionario_devolucao;
    }

    public void setFuncionario_devolucao(String funcionario_devolucao) {
        this.funcionario_devolucao = funcionario_devolucao;
    }
   
   
}
