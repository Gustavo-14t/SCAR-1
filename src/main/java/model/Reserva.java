/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author devmat
 */
public class Reserva {
    
    int id_reserva;
    int id_chave;
    int id_morador;
    int id_unidade;
    int id_funcionario;
    String data_reserva;
    String statu;
    
    // Construtor vazio;
    public Reserva (){}

    public Reserva(int id_reserva, int id_chave, int id_morador, int id_unidade, int id_funcionario, String data_reserva, String statu) {
        this.id_reserva = id_reserva;
        this.id_chave = id_chave;
        this.id_morador = id_morador;
        this.id_unidade = id_unidade;
        this.id_funcionario = id_funcionario;
        this.data_reserva = data_reserva;
        this.statu = statu;
    }

    public Reserva(int id_chave, int id_morador, int id_unidade, int id_funcionario, String data_reserva, String statu) {
        this.id_chave = id_chave;
        this.id_morador = id_morador;
        this.id_unidade = id_unidade;
        this.id_funcionario = id_funcionario;
        this.data_reserva = data_reserva;
        this.statu = statu;
    }

    public int getId_reserva() {
        return id_reserva;
    }

    public void setId_reserva(int id_reserva) {
        this.id_reserva = id_reserva;
    }

    public int getId_chave() {
        return id_chave;
    }

    public void setId_chave(int id_chave) {
        this.id_chave = id_chave;
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

    public int getId_funcionario() {
        return id_funcionario;
    }

    public void setId_funcionario(int id_funcionario) {
        this.id_funcionario = id_funcionario;
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
