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
import model.inoutVisitante;

/**
 *
 * @author Todosdecasa
 */
public class controllerInoutVisitante {
    
    public boolean cadastroUsuario( inoutVisitante iov){
     //criuando uma String que recebe uma comando SQL
     String query = "INSERT INTO VisitanteINOUT ( nomeMorador,nomeVisitante,nomeFuncionario, dataVisita, statu)"
             + " values (?,?,?,?,'PENDENTE') ";
     
     try(Connection conection = conexaoBD.getConection();
        PreparedStatement preparedStatement =
                conection.prepareStatement(query)){       
            
            // mandar os dados para dentro do insert
            preparedStatement.setString(1,iov.getNomeMorador());
            preparedStatement.setString(2,iov.getNomeVisitante());
            preparedStatement.setString(3,iov.getNomeFuncionario());
             preparedStatement.setString(4,iov.getDataVisita());
             
             
           
           
            
            /*try(ResultSet resultSet = preparedStatement.executeQuery()){
                return resultSet.next();
            }// final do segundo try*/
            // verifica se o insert foi executado
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
            
        }catch(SQLException e){
            // imprimindo erro que deu ao inserir usuário
            System.err.print("Erro ao Inserir Dados!" + e);
            return false;
        }// final do try catch
    
}// fim do método cadastroTurno()
    
    public List<inoutVisitante> listarVisitas(){
        List<inoutVisitante> lista = new ArrayList<>();
        
        String query = "SELECT *FROM VisitanteINOUT where statu = 'PENDENTE' ;";

        try(Connection connection = conexaoBD.getConection();//conexão com o banco de dados
     PreparedStatement preparedStatement = connection.prepareStatement(query)){
            
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next()){
                inoutVisitante iov = new inoutVisitante();
                
                iov.setId_ControleEntradaSaida(resultSet.getString("id_ControleEntradaSaida"));
                iov.setNomeMorador(resultSet.getString("nomeMorador"));
                iov.setNomeVisitante(resultSet.getString("nomeVisitante"));
                iov.setNomeFuncionario(resultSet.getString("nomeFuncionario"));
                iov.setDataVisita(resultSet.getString("dataVisita"));
                iov.setStatu(resultSet.getString("statu"));
               
                
                
                lista.add(iov);

            }//fim do while
          
             return lista;
            
        }catch(SQLException e){
         System.err.println("Erro listar o usuário "+ e );
         return null;
        }//fim do try
        
    }//fim do método listarClientes()
    
    public List<inoutVisitante> listarSaidaDeVisita(){
        List<inoutVisitante> lista = new ArrayList<>();
        
        String query = "SELECT nomeMorador,nomeVisitante, statu FROM VisitanteINOUT  where statu = 'ENTRADA' ;";

        try(Connection connection = conexaoBD.getConection();//conexão com o banco de dados
     PreparedStatement preparedStatement = connection.prepareStatement(query)){
            
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next()){
                inoutVisitante iov = new inoutVisitante();
                
                
                iov.setNomeMorador(resultSet.getString("nomeMorador"));
                iov.setNomeVisitante(resultSet.getString("nomeVisitante"));
                iov.setStatu(resultSet.getString("statu"));
               
                
                
                lista.add(iov);

            }//fim do while
          
             return lista;
            
        }catch(SQLException e){
         System.err.println("Erro listar o usuário "+ e );
         return null;
        }//fim do try
        
    }//fim do método listarClientes()
    
     public boolean editarVisita(inoutVisitante iov){
      String query = "Update VisitanteINOUT set statu = ?, nomeFuncionario = ? where id_ControleEntradaSaida = ? ";
                   
    // Conexão com o banco de dados
    try (Connection conection = conexaoBD.getConection();
         PreparedStatement preparedStatement = conection.prepareStatement(query)) {

        // Definindo os parâmetros do preparedStatement
        preparedStatement.setString(1, iov.getStatu());  // Novo status da reserva
        preparedStatement.setString(2, iov.getNomeFuncionario()); // id do morador da reserva
        preparedStatement.setString(3, iov.getId_ControleEntradaSaida());
        // Executando o update
        int cadastrou = preparedStatement.executeUpdate();
        return cadastrou > 0;

    } catch (SQLException e) {
        System.err.println("Erro ao editar o status da Visita: " + e);
        return false;
    } // fim do try-catch
} // fim do método editarReserva
    
}
