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
import model.Chave;
import model.conexaoBD;

/**
 *
 * @author devmat
 */
public class ChaveController {
     public boolean cadastroChave( Chave chave){
     //criuando uma String que recebe uma comando SQL
     String query = "INSERT INTO Atividade (id_unidade, nome) values (?,?) ";
     
     try(Connection conection = conexaoBD.getConection();
        PreparedStatement preparedStatement =
                conection.prepareStatement(query)){       
            
            // mandar os dados para dentro do insert
            preparedStatement.setInt(1,chave.getId_unidade());
            preparedStatement.setString(2,chave.getNome());

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
     
     public List<Chave> listarChave(){
        List<Chave> lista = new ArrayList<>();
        
        String query = "SELECT id_chave,id_unidade,nome FROM Chave ;";

        try(Connection connection = conexaoBD.getConection();//conexão com o banco de dados
     PreparedStatement preparedStatement = connection.prepareStatement(query)){
            
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next()){
                Chave chave = new Chave();
                
                chave.setId_chave(resultSet.getInt("id_chave"));
                chave.setId_unidade(resultSet.getInt("id_unidade"));
                chave.setNome(resultSet.getString("nome"));
                
                
                
                lista.add(chave);

            }//fim do while
          
             return lista;
            
        }catch(SQLException e){
         System.err.println("Erro listar a chave "+ e );
         return null;
        }//fim do try
        
    }//fim do método listarChave()
     
     
     public boolean deletarChave(int idChave){
        
         String query = "DELETE FROM Chave WHERE id_chave = ?";
        //Connection - conecta-se ao banco de dados
        //PreparedStatement manda o comando sql para executar no BD
        try (Connection connection = conexaoBD.getConection();//conexão com o banco de dados
     PreparedStatement preparedStatement = connection.prepareStatement(query)){//mandar o comando select 
            //mandando idUsuario para dentro do camando sql
            preparedStatement.setInt(1,idChave);
            
                        int resultado = preparedStatement.executeUpdate();
            return resultado > 0;
           
        }catch(SQLException e){
             System.err.print(e+ " Exclusão não realizada  ");
            return false;
        }//fim do 
     }//fim do public boolean
}
