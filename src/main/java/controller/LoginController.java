/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Funcionario;
import model.conexaoBD;

/**
 *
 * @author Estudo_TI
 */
public class LoginController {
    // Método de autenticação de usuário
     public Funcionario authenticate(String cpf, String senha){
     String query = "SELECT * FROM Funcionario WHERE cpf = ? and senha = ?";
     try(Connection connection = conexaoBD.getConection();//conexão com o banco de dados
     PreparedStatement preparedStatement = connection.prepareStatement(query)){//mandar o comando select 
         //para ser executado no banco de dados
             
      preparedStatement.setString(1, cpf);
      preparedStatement.setString(2, senha);
      
      
      try(ResultSet resultSet = preparedStatement.executeQuery()){
          
       if(resultSet.next()){
          
        int idFuncionario = resultSet.getInt("id_funcionario");
        String nome = resultSet.getString("nome");
        String telefone = resultSet.getString("telefone");
        String endereco = resultSet.getString("endereco");
       String departamento = resultSet.getString("departamento");

          return new Funcionario(idFuncionario,nome,cpf,telefone,endereco,departamento,senha);
       }//fim do if
       
      }//fim do try
     } catch(SQLException e){
         System.err.println("Erro ao autenticar o usuário "+ e.getMessage() );
         return null;
     }//fim do catch
        return null;
    }//fim do public
    
}
