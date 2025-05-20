/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
            
            preparedStatement.setString(2,visitante.getNome());
            preparedStatement.setString(3,visitante.getCpf());
             preparedStatement.setString(4,visitante.getTelefone());
              preparedStatement.setString(5,visitante.getPlacaVeiculo());
           
           
            
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
    
}
