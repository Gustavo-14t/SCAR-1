/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Todosdecasa
 */
public class INOUTmorador {
    
   String id_morEntradaSaida;
   String id_morador;
   int id_funcionario;
   String datas;
   String statu ;

    public INOUTmorador(String id_morEntradaSaida, String id_morador, int id_funcionario, String datas, String statu) {
        this.id_morEntradaSaida = id_morEntradaSaida;
        this.id_morador = id_morador;
        this.id_funcionario = id_funcionario;
        this.datas = datas;
        this.statu = statu;
    }

    public INOUTmorador(String id_morador, int id_funcionario, String datas, String statu) {
        this.id_morador = id_morador;
        this.id_funcionario = id_funcionario;
        this.datas = datas;
        this.statu = statu;
    }

    public INOUTmorador() {
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

    public int getId_funcionario() {
        return id_funcionario;
    }

    public void setId_funcionario(int id_funcionario) {
        this.id_funcionario = id_funcionario;
    }

    public String getDatas() {
        return datas;
    }

    public void setDatas(String datas) {
        this.datas = datas;
    }

    public String getStatu() {
        return statu;
    }

    public void setStatu(String statu) {
        this.statu = statu;
    }

    
    
}
