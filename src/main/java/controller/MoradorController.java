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
import model.Morador;
import model.conexaoBD;

/**
 *
 * @author devmat
 */
public class MoradorController {
    
    public boolean cadastroMorador( Morador morador){
     //criuando uma String que recebe uma comando SQL
     String query = "INSERT INTO Morador (id_unidade,nome,cpf,email,data_nasc) values (?,?,?,?,?) ";
     
     try(Connection conection = conexaoBD.getConection();
        PreparedStatement preparedStatement =
                conection.prepareStatement(query)){       
            
            // mandar os dados para dentro do insert
            preparedStatement.setInt(1,morador.getId_unidade());
             preparedStatement.setString(2,morador.getNome());
            preparedStatement.setString(3,morador.getCpf());
            preparedStatement.setString(4,morador.getEmail());
             preparedStatement.setString(5,morador.getData_nasc());
    
           
           
            
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
    
    
     public List<Morador> listarMorador(){
        List<Morador> lista = new ArrayList<>();
        
        String query = "SELECT id_unidade,nome,cpf,email,data_nasc FROM Morador ;";

        try(Connection connection = conexaoBD.getConection();//conexão com o banco de dados
     PreparedStatement preparedStatement = connection.prepareStatement(query)){
            
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next()){
                Morador morador = new Morador();
                
                morador.setId_morador(resultSet.getInt("id_unidade"));
                morador.setNome(resultSet.getString("nome"));
                morador.setCpf(resultSet.getString("cpf"));
                morador.setEmail(resultSet.getString("email"));
                morador.setData_nasc(resultSet.getString("data_nasc"));
               
                
                
                lista.add(morador);

            }//fim do while
          
             return lista;
            
        }catch(SQLException e){
         System.err.println("Erro listar o Morador "+ e );
         return null;
        }//fim do try
        
    }//fim do método listarClientes()
     
     
     public boolean deletarMorador(int idMorador){
         String query = "DELETE FROM Morador WHERE id_morador = ?";
        //Connection - conecta-se ao banco de dados
        //PreparedStatement manda o comando sql para executar no BD
        try (Connection connection = conexaoBD.getConection();//conexão com o banco de dados
     PreparedStatement preparedStatement = connection.prepareStatement(query)){//mandar o comando select 
            //mandando idUsuario para dentro do camando sql
            preparedStatement.setInt(1,idMorador);
            
                        int resultado = preparedStatement.executeUpdate();
            return resultado > 0;
           
        }catch(SQLException e){
             System.err.print(e+ " Exclusão não realizada  ");
            return false;
        }//fim do 
     }//fim do public boolean
     
     
     public List<Morador> listarMoradorNome(String nome){
     
     String query = "SELECT id_morador,id_unidade,nome,cpf,email,data_nasc FROM Morador where nome LIKE ?;";
     
      List<Morador> lista = new ArrayList<>();
        // criando o try catch
        try(Connection conection = conexaoBD.getConection();
        PreparedStatement preparedStatement = conection.prepareStatement(query)){
            
             preparedStatement.setString(1,'%'+nome+'%');
                
                ResultSet resultset = preparedStatement.executeQuery();
            // passando o valor do select para um objeto produto
            // enquanto resultset for diferente de null
            while(resultset.next()){
                // receba o valor e cadastre em produto
                  Morador morador = new Morador();
                  morador.setId_morador(resultset.getInt("id_morador"));
                  morador.setId_unidade(resultset.getInt("id_unidade"));
                  morador.setNome(resultset.getString("nome"));
                  morador.setCpf(resultset.getString("cpf"));
                  morador.setEmail(resultset.getString("email"));
                  morador.setData_nasc(resultset.getString("data_nasc"));
                  
                  
                  
                  // jogando o produto dentro da lista
                  lista.add(morador);
             }// fim do while
            return lista;
         
     }catch(SQLException erro){
         System.err.print("Erro:  " + erro);
            return null;
     }//fim do catch
     
     
 }// fim do método listarProdutorNome
    
}

