/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.conexaoBD;
import model.historicoInoutVisitante;

/**
 *
 * @author Todosdecasa
 */
public class relatorioIOvisitante {
    
    public List <historicoInoutVisitante> listarRelatorios(){
        String query = "SELECT nomeMorador,nomeVisitante,nomeFuncionario,dataMovimentacao,tipoMovimentacao "
                + "FROM HistoricoVisitanteINOUT";
        
                     List<historicoInoutVisitante> lista = new ArrayList<>();
                     
        try(Connection conection = conexaoBD.getConection();
        PreparedStatement preparedStatement =conection.prepareStatement(query);
         ResultSet resultset = preparedStatement.executeQuery() ){
            
            while(resultset.next()){
                historicoInoutVisitante reserva = new historicoInoutVisitante();
                
                reserva.setNomeMorador(resultset.getString("nomeMorador"));
                reserva.setNomeFuncionario(resultset.getString("nomeVisitante"));
                reserva.setNomeFuncionario(resultset.getString("nomeFuncionario"));
                reserva.setDataMovimentacao(resultset.getString("dataMovimentacao"));
                reserva.setTipoMovimentacao(resultset.getString("tipoMovimentacao"));
                
                
                lista.add(reserva);

            }//fim do while
 
            return lista;

        }catch(SQLException e){
            System.err.print("Erro ao listar relatório de Entradas e saídas "+ e);
            return null;
        }// final do try catch
}
    
}
