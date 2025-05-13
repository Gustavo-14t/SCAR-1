/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author devmat
 */
public class ControleServico {
    
int id_controleServico;
String id_servico;
String morador;
String nomeServico;
String diaDaSolicitacao;
String dataConclusao;
String statu;

    public ControleServico(int id_controleServico, String id_servico, String morador, String nomeServico, String diaDaSolicitacao, String dataConclusao, String statu) {
        this.id_controleServico = id_controleServico;
        this.id_servico = id_servico;
        this.morador = morador;
        this.nomeServico = nomeServico;
        this.diaDaSolicitacao = diaDaSolicitacao;
        this.dataConclusao = dataConclusao;
        this.statu = statu;
    }

    public ControleServico(String id_servico, String morador, String nomeServico, String diaDaSolicitacao, String dataConclusao, String statu) {
        this.id_servico = id_servico;
        this.morador = morador;
        this.nomeServico = nomeServico;
        this.diaDaSolicitacao = diaDaSolicitacao;
        this.dataConclusao = dataConclusao;
        this.statu = statu;
    }

    public ControleServico() {
    }

    public int getId_controleServico() {
        return id_controleServico;
    }

    public void setId_controleServico(int id_controleServico) {
        this.id_controleServico = id_controleServico;
    }

    public String getId_servico() {
        return id_servico;
    }

    public void setId_servico(String id_servico) {
        this.id_servico = id_servico;
    }

    public String getMorador() {
        return morador;
    }

    public void setMorador(String morador) {
        this.morador = morador;
    }

    public String getNomeServico() {
        return nomeServico;
    }

    public void setNomeServico(String nomeServico) {
        this.nomeServico = nomeServico;
    }

    public String getDiaDaSolicitacao() {
        return diaDaSolicitacao;
    }

    public void setDiaDaSolicitacao(String diaDaSolicitacao) {
        this.diaDaSolicitacao = diaDaSolicitacao;
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
