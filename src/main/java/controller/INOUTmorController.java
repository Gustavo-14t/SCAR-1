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
import model.Morador;
import model.ReservaList;
import model.conexaoBD;

/**
 *
 * @author Todosdecasa
 */
public class INOUTmorController {
    
    public boolean OUTmorador( INOUTmorador iomorador){
     //criuando uma String que recebe uma comando SQL
     String query = "INSERT INTO MoradorINOUT ( id_morador, id_funcionario, datas, statu) values (?,'SAÍDA') ";
     
     try(Connection conection = conexaoBD.getConection();
        PreparedStatement preparedStatement =
                conection.prepareStatement(query)){       
            
            // mandar os dados para dentro do insert
            preparedStatement.setString(1,iomorador.getId_morador());
            
             
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
     String query = "INSERT INTO INOUTmorador ( id_morador, id_funcionario, datas, statu) values (?,'ENTRADA') ";
     
     try(Connection conection = conexaoBD.getConection();
        PreparedStatement preparedStatement =
                conection.prepareStatement(query)){       
            
            // mandar os dados para dentro do insert
            preparedStatement.setString(1,iomorador.getId_morador());
             
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
    
    public boolean editarINOUT(INOUTmorador morador){
      String query = "update set statu = 'SAÍDA' from MoradorINOUT where id_morador = ? ";
                   
    // Conexão com o banco de dados
    try (Connection conection = conexaoBD.getConection();
         PreparedStatement preparedStatement = conection.prepareStatement(query)) {

        // Definindo os parâmetros do preparedStatement
        preparedStatement.setString(1, morador.getId_morador()); // id do morador da reserva
        // Executando o update
        int cadastrou = preparedStatement.executeUpdate();
        return cadastrou > 0;

    } catch (SQLException e) {
        System.err.println("Erro ao editar o status de entrada e saida: " + e);
        return false;
    } // fim do try-catch
} // fim do método editarReserva
    
     public List<Morador> listarMoradornull(){
        List<Morador> lista = new ArrayList<>();
        
        String query = "select m.nome, m.cpf, m.email, m.data_nasc from MoradorINOUT mi\n" +
"JOIN Morador m ON m.id_morador = mi.id_morador";

        try(Connection connection = conexaoBD.getConection();//conexão com o banco de dados
     PreparedStatement preparedStatement = connection.prepareStatement(query)){
            
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next()){
                Morador morador = new Morador();
                
                morador.getNome();
                morador.getCpf();
                morador.getEmail();
                morador.getData_nasc();
                
                lista.add(morador);

            }//fim do while
          
             return lista;
            
        }catch(SQLException e){
         System.err.println("Erro listar o usuário "+ e );
         return null;
        }//fim do try
        
    }//fim do método listarClientes()
    
}
