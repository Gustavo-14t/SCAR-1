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
import model.RelatorioServico;
import model.conexaoBD;

/**
 *
 * @author devmat
 */
public class ContServiceController {
 
     public List<RelatorioServico> listarServico(){
        List<RelatorioServico> lista = new ArrayList<>();
        
        String query = "SELECT  morador, nomeServico, diaDaSolicitacao, dataConclusao, statu FROM ControleServico;";

        try(Connection connection = conexaoBD.getConection();//conexão com o banco de dados
     PreparedStatement preparedStatement = connection.prepareStatement(query)){
            
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next()){
                RelatorioServico contService = new RelatorioServico();     
                 contService.setMorador(resultSet.getString("morador"));
                  contService.setNomeServico(resultSet.getString("nomeServico"));
                contService.setDiaDaSolciticao(resultSet.getString("diaDaSolicitacao"));
                contService.setDataConclusao(resultSet.getString("dataConclusao"));
                contService.setStatu(resultSet.getString("statu"));
                

                lista.add(contService);

            }//fim do while
          
             return lista;
            
        }catch(SQLException e){
         System.err.println("Erro listar o Controle de serviço " + e );
         return null;
        }//fim do try
        
    }//fim do método listarClientes()
    
}
