/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
    
}
