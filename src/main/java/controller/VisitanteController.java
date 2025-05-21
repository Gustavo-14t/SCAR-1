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
import model.Visitante;
import model.conexaoBD;

/**
 *
 * @author devmat
 */
public class VisitanteController {
    
    public boolean cadastroVisita( Visitante visitante){
     //criuando uma String que recebe uma comando SQL
     String query = "INSERT INTO Visitante ( nome, cpf, telefone, PlacaVeiculo) values (?,?,?,?) ";
     
     try(Connection conection = conexaoBD.getConection();
        PreparedStatement preparedStatement =
                conection.prepareStatement(query)){       
            
            // mandar os dados para dentro do insert
            
            preparedStatement.setString(1,visitante.getNome());
            preparedStatement.setString(2,visitante.getCpf());
             preparedStatement.setString(3,visitante.getTelefone());
              preparedStatement.setString(4,visitante.getPlacaVeiculo());
           
           
            
            /*try(ResultSet resultSet = preparedStatement.executeQuery()){
                return resultSet.next();
            }// final do segundo try*/
            // verifica se o insert foi executado
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
            
        }catch(SQLException e){
            // imprimindo erro que deu ao inserir usuário
            System.err.print("Erro no ControllerVisitante ao tentar Inserir Dados!" + e);
            return false;
        }// final do try catch
    
}// fim do método cadastroTurno()
    
    public List<Visitante> listarVisitante(){
        List<Visitante> lista = new ArrayList<>();
        
        String query = "SELECT nome, cpf, telefone, PlacaVeiculo FROM Visitante ;";

        try(Connection connection = conexaoBD.getConection();//conexão com o banco de dados
     PreparedStatement preparedStatement = connection.prepareStatement(query)){
            
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next()){
                Visitante visita = new Visitante();
                
                visita.setNome(resultSet.getString("nome"));
                visita.setCpf(resultSet.getString("cpf"));
                visita.setTelefone(resultSet.getString("telefone"));
                visita.setPlacaVeiculo(resultSet.getString("PlacaVeiculo"));
                
                lista.add(visita);

            }//fim do while
          
             return lista;
            
        }catch(SQLException e){
         System.err.println("Erro em ControllerVisitante "+ e );
         return null;
        }//fim do try
        
    }//fim do método listarClientes()
    
    public List<Visitante> listarVisitanteNome(String nome){
     
     String query = "SELECT nome,cpf,telefone,PlacaVeiculo FROM Visitante where nome LIKE ?;";
     
      List<Visitante> lista = new ArrayList<>();
        // criando o try catch
        try(Connection conection = conexaoBD.getConection();
        PreparedStatement preparedStatement = conection.prepareStatement(query)){
            
             preparedStatement.setString(1,'%'+nome+'%');
                
                ResultSet resultset = preparedStatement.executeQuery();
            // passando o valor do select para um objeto produto
            // enquanto resultset for diferente de null
            while(resultset.next()){
                // receba o valor e cadastre em produto
                  Visitante visita = new Visitante();
                  visita.setNome(resultset.getString("nome"));
                  visita.setCpf(resultset.getString("cpf"));
                  visita.setTelefone(resultset.getString("telefone"));
                  visita.setPlacaVeiculo(resultset.getString("PlacaVeiculo"));

                  // jogando o produto dentro da lista
                  lista.add(visita);
             }// fim do while
            return lista;
         
     }catch(SQLException erro){
         System.err.print("Erro:  " + erro);
            return null;
     }//fim do catch
     
     
 }// fim do método listarProdutorNome
    
}
