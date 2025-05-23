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
import model.INOUTmorador;
import model.conexaoBD;

/**
 *
 * @author Todosdecasa
 */
public class INOUTmorController {
    
    public boolean OUTmorador( INOUTmorador iomorador){
     //criuando uma String que recebe uma comando SQL
     String query = "INSERT INTO MoradorINOUT ( id_morador, id_funcionario, datas, statu) values (?,?,GETDATE(),'SAÍDA') ";
     
     try(Connection conection = conexaoBD.getConection();
        PreparedStatement preparedStatement =
                conection.prepareStatement(query)){       
            
            // mandar os dados para dentro do insert
            preparedStatement.setString(1,iomorador.getId_morador());
            preparedStatement.setInt(2,iomorador.getId_funcionario());
             
            /*try(ResultSet resultSet = preparedStatement.executeQuery()){
                return resultSet.next();
            }// final do segundo try*/
            // verifica se o insert foi executado
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
            
        }catch(SQLException e){
            // imprimindo erro que deu ao inserir usuário
            System.err.print("Erro INOUTmor, ao SAIR!" + e);
            return false;
        }// final do try catch
    
}// fim do método cadastroTurno()
    
    public boolean INmorador( INOUTmorador iomorador){
     //criuando uma String que recebe uma comando SQL
     String query = "INSERT INTO INOUTmorador ( id_morador, id_funcionario, datas, statu) values (?,?,GETDATE(),'ENTRADA') ";
     
     try(Connection conection = conexaoBD.getConection();
        PreparedStatement preparedStatement =
                conection.prepareStatement(query)){       
            
            // mandar os dados para dentro do insert
            preparedStatement.setString(1,iomorador.getId_morador());
            preparedStatement.setInt(2,iomorador.getId_funcionario());
             
            /*try(ResultSet resultSet = preparedStatement.executeQuery()){
                return resultSet.next();
            }// final do segundo try*/
            // verifica se o insert foi executado
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
            
        }catch(SQLException e){
            // imprimindo erro que deu ao inserir usuário
            System.err.print("Erro INOUTmor, ao ENTRAR!" + e);
            return false;
        }// final do try catch
    
}// fim do método cadastroTurno()
    
     public List<INOUTmorador> listarUsuario(){
        List<INOUTmorador> lista = new ArrayList<>();
        
        String query = "SELECT id_funcionario,nome,cpf,telefone,endereco,departamento FROM Funcionario ;";

        try(Connection connection = conexaoBD.getConection();//conexão com o banco de dados
     PreparedStatement preparedStatement = connection.prepareStatement(query)){
            
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next()){
                INOUTmorador morador = new INOUTmorador();
                
                morador.setId_funcionario(resultSet.getInt("id_morador"));
                
                lista.add(morador);

            }//fim do while
          
             return lista;
            
        }catch(SQLException e){
         System.err.println("Erro listar o usuário "+ e );
         return null;
        }//fim do try
        
    }//fim do método listarClientes()
    
}
