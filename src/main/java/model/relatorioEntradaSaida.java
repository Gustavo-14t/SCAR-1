/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Todosdecasa
 */
public class relatorioEntradaSaida {
 
    String tipoMovimentacao;
    String nomeFuncionario;
    String dataMovimentacao;
    String nomeMorador;

    public relatorioEntradaSaida(String tipoMovimentacao, String nomeFuncionario, String dataMovimentacao, String nomeMorador) {
        this.tipoMovimentacao = tipoMovimentacao;
        this.nomeFuncionario = nomeFuncionario;
        this.dataMovimentacao = dataMovimentacao;
        this.nomeMorador = nomeMorador;
    }

    public relatorioEntradaSaida() {
    }

    public String getTipoMovimentacao() {
        return tipoMovimentacao;
    }

    public void setTipoMovimentacao(String tipoMovimentacao) {
        this.tipoMovimentacao = tipoMovimentacao;
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

    public String getNomeMorador() {
        return nomeMorador;
    }

    public void setNomeMorador(String nomeMorador) {
        this.nomeMorador = nomeMorador;
    }

  
}
