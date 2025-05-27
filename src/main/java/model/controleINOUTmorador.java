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
    
       
    String nomeMorador;
    String nomeFuncionario; 
    String dataMovimentacao;
    String statu;

    public controleINOUTmorador(String nomeMorador, String nomeFuncionario, String dataMovimentacao, String statu) {
        this.nomeMorador = nomeMorador;
        this.nomeFuncionario = nomeFuncionario;
        this.dataMovimentacao = dataMovimentacao;
        this.statu = statu;
    }

    public controleINOUTmorador() {
    }

    public String getNomeMorador() {
        return nomeMorador;
    }

    public void setNomeMorador(String nomeMorador) {
        this.nomeMorador = nomeMorador;
    }

    public String getNomeFuncionario() {
        return nomeFuncionario;
    }

    public void setNomeFuncionario(String nomeFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
    }

    public String getDataMovimentacao() {
        return dataMovimentacao;
    }

    public void setDataMovimentacao(String dataMovimentacao) {
        this.dataMovimentacao = dataMovimentacao;
    }

    public String getStatu() {
        return statu;
    }

    public void setStatu(String statu) {
        this.statu = statu;
    }
    
    
    
}
