/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author devmat
 */
public class RelatorioServico {
    
    String Morador;
    String nomeServico;
    String diaDaSolciticao;
    String dataConclusao;
    String statu;

    public RelatorioServico(String Morador, String nomeServico, String diaDaSolciticao, String dataConclusao, String statu) {
        this.Morador = Morador;
        this.nomeServico = nomeServico;
        this.diaDaSolciticao = diaDaSolciticao;
        this.dataConclusao = dataConclusao;
        this.statu = statu;
    }

    public RelatorioServico() {
    }

    public String getMorador() {
        return Morador;
    }

    public void setMorador(String Morador) {
        this.Morador = Morador;
    }

    public String getNomeServico() {
        return nomeServico;
    }

    public void setNomeServico(String nomeServico) {
        this.nomeServico = nomeServico;
    }

    public String getDiaDaSolciticao() {
        return diaDaSolciticao;
    }

    public void setDiaDaSolciticao(String diaDaSolciticao) {
        this.diaDaSolciticao = diaDaSolciticao;
    }

    public String getDataConclusao() {
        return dataConclusao;
    }

    public void setDataConclusao(String dataConclusao) {
        this.dataConclusao = dataConclusao;
    }

    public String getStatu() {
        return statu;
    }

    public void setStatu(String statu) {
        this.statu = statu;
    }
    
    
    
}
