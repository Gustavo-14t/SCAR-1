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
      public int cadastroChave(Chave chave) {
        // Comando SQL para inserir a chave
        String query = "INSERT INTO Chave (nome) VALUES (?)";
        
        try (Connection connection = conexaoBD.getConection();
             PreparedStatement preparedStatement = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS)) {
            
            // Enviar os dados para o banco
            preparedStatement.setString(1, chave.getNome());

            // Executar o comando de inserção
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                // Se a inserção foi bem-sucedida, recuperar o ID gerado
                try (ResultSet resultSet = preparedStatement.getGeneratedKeys()) {
                    if (resultSet.next()) {
                        return resultSet.getInt(1); // Retorna o ID gerado
                    }
                }
            }
        } catch (SQLException e) {
            // Exibir erro caso haja problemas ao inserir a chave
            System.err.println("Erro ao Inserir Dados! " + e);
        }
        return -1; // Caso haja algum erro ou a inserção falhe, retorna um ID inválido
    }

     
     public List<Chave> listarChave(){
        List<Chave> lista = new ArrayList<>();
        
        String query = "SELECT id_chave,nome FROM Chave ;";

        try(Connection connection = conexaoBD.getConection();//conexão com o banco de dados
     PreparedStatement preparedStatement = connection.prepareStatement(query)){
            
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next()){
                Chave chave = new Chave();
                
                chave.setId_chave(resultSet.getInt("id_chave"));
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
