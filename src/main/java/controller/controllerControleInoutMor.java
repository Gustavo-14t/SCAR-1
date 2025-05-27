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
import model.controleINOUTmorador;


/**
 *
 * @author Todosdecasa
 */
public class controllerControleInoutMor {
    
    public boolean insertControleCim( controleINOUTmorador cim){
     //criuando uma String que recebe uma comando SQL
     String query = "INSERT INTO ControleMoradorINOUT "
             + "( nomeMorador,nomeFuncionario, dataMovimentacao, statu)"
             + " values (?,?,GETDATE(),'ENTRADA') ";
     
     try(Connection conection = conexaoBD.getConection();
        PreparedStatement preparedStatement =
                conection.prepareStatement(query)){       
            
            // mandar os dados para dentro do insert
            preparedStatement.setString(1,cim.getNomeMorador());
            preparedStatement.setString(2,cim.getNomeFuncionario());

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
            
        }catch(SQLException e){
            // imprimindo erro que deu ao inserir usuário
            System.err.print("Erro em ControllerInoutMor: Método - insertControleCim !" + e);
            return false;
        }// final do try catch
    
}// fim do método cadastroTurno()
       
    public boolean entradaOuSaida(controleINOUTmorador morador) {
    String query =  
    "Update ControleMoradorINOUT set statu = ?,  dataMovimentacao = GETDATE(), nomeFuncionario = ? where nomeMorador = ?";


    try (Connection conection = conexaoBD.getConection();
         PreparedStatement preparedStatement = conection.prepareStatement(query)) {

        preparedStatement.setString(1, morador.getStatu());
        preparedStatement.setString(2, morador.getNomeFuncionario()); 
        preparedStatement.setString(3, morador.getNomeMorador()); 

        int cadastrou = preparedStatement.executeUpdate();
        return cadastrou > 0;

    } catch (SQLException e) {
        System.err.println("Erro em controle entrada/saida: " + e);
        return false;
    }
}
    public List<controleINOUTmorador> listarCim(){
        List<controleINOUTmorador> lista = new ArrayList<>();
        
        String query = "SELECT nomeMorador,nomeFuncionario,dataMovimentacao,statu FROM ControleMoradorINOUT ;";

        try(Connection connection = conexaoBD.getConection();//conexão com o banco de dados
     PreparedStatement preparedStatement = connection.prepareStatement(query)){
            
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next()){
                controleINOUTmorador cim = new controleINOUTmorador();
                
                cim.setNomeMorador(resultSet.getString("nomeMorador"));
                cim.setNomeFuncionario(resultSet.getString("nomeFuncionario"));
                cim.setDataMovimentacao(resultSet.getString("dataMovimentacao"));
                cim.setStatu(resultSet.getString("statu"));
 
                lista.add(cim);

            }//fim do while
          
             return lista;
            
        }catch(SQLException e){
         System.err.println("Erro listar o usuário "+ e );
         return null;
        }//fim do try
        
    }//fim do método listarClientes()
    
}
