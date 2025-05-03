/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import model.Unidade;
import model.conexaoBD;

/**
 *
 * @author devmat
 */
public class UnidadeController {
    public boolean cadastroUnidade(Unidade unidade) {
    String queryUnidade = "INSERT INTO Unidade (id_chave, nome, tipo, numero, bloco, capacidade, descricao, dimensoes) "
            + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

    try (Connection conection = conexaoBD.getConection()) {
        try (PreparedStatement preparedStatementUnidade = conection.prepareStatement(queryUnidade)) {
            preparedStatementUnidade.setLong(1, unidade.getId_chave());
            preparedStatementUnidade.setString(2, unidade.getNome());
            preparedStatementUnidade.setString(3, unidade.getTipo());
            preparedStatementUnidade.setString(4, unidade.getNumero());
            preparedStatementUnidade.setString(5, unidade.getBloco());
            preparedStatementUnidade.setString(6, unidade.getCapacidade());
            preparedStatementUnidade.setString(7, unidade.getDescricao());
            preparedStatementUnidade.setString(8, unidade.getDomensoes());

            int rowsAffected = preparedStatementUnidade.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            System.err.println("Erro ao inserir unidade: " + e);
            return false;
        }

    } catch (SQLException e) {
        System.err.println("Erro de conexão: " + e);
        return false;
    }
}
  
    
     public List<Unidade> listarUnidade(){
        List<Unidade> lista = new ArrayList<>();
        
        String query = "SELECT  id_unidade,id_chave,nome,tipo,numero,bloco,capacidade,descricao,dimensoes FROM Unidade ;";

        try(Connection connection = conexaoBD.getConection();//conexão com o banco de dados
     PreparedStatement preparedStatement = connection.prepareStatement(query)){
            
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next()){
                Unidade unidade = new Unidade();
                unidade.setId_unidade(resultSet.getInt("id_unidade"));
                unidade.setId_chave(resultSet.getInt("id_chave"));
                unidade.setNome(resultSet.getString("nome"));
                 unidade.setTipo(resultSet.getString("tipo"));
                  unidade.setNumero(resultSet.getString("numero"));
                unidade.setBloco(resultSet.getString("bloco"));
                unidade.setCapacidade(resultSet.getString("capacidade"));
                unidade.setDescricao(resultSet.getString("Descricao"));
                unidade.setDomensoes(resultSet.getString("dimensoes"));

                lista.add(unidade);

            }//fim do while
          
             return lista;
            
        }catch(SQLException e){
         System.err.println("Erro listar o Morador "+ e );
         return null;
        }//fim do try
        
    }//fim do método listarClientes()
     
     
     public boolean deletarUnidade(int idUnidade){
         String query = "DELETE FROM Unidade WHERE id_Unidade = ?";
        //Connection - conecta-se ao banco de dados
        //PreparedStatement manda o comando sql para executar no BD
        try (Connection connection = conexaoBD.getConection();//conexão com o banco de dados
     PreparedStatement preparedStatement = connection.prepareStatement(query)){//mandar o comando select 
            //mandando idUsuario para dentro do camando sql
            preparedStatement.setInt(1,idUnidade);
            
                        int resultado = preparedStatement.executeUpdate();
            return resultado > 0;
           
        }catch(SQLException e){
             System.err.print(e+ " Exclusão não realizada  ");
            return false;
        }//fim do 
     }//fim do public boolean
     
     
     public List<Unidade> listarUnidadeNome(String nome){
     
     String query = "SELECT id_unidade,id_chave,nome,tipo,numero,bloco,capacidade FROM Unidade where nome LIKE ?;";
     
      List<Unidade> lista = new ArrayList<>();
        // criando o try catch
        try(Connection conection = conexaoBD.getConection();
        PreparedStatement preparedStatement = conection.prepareStatement(query)){
            
             preparedStatement.setString(1,'%'+nome+'%');
                
                ResultSet resultset = preparedStatement.executeQuery();
            // passando o valor do select para um objeto produto
            // enquanto resultset for diferente de null
            while(resultset.next()){
                // receba o valor e cadastre em produto
                  Unidade unidade = new Unidade();
                  unidade.setId_unidade(resultset.getInt("id_unidade"));
                unidade.setId_chave(resultset.getInt("id_chave"));
                unidade.setNome(resultset.getString("nome"));
                 unidade.setTipo(resultset.getString("tipo"));
                  unidade.setNumero(resultset.getString("numero"));
                unidade.setBloco(resultset.getString("bloco"));
                unidade.setCapacidade(resultset.getString("capacidade"));
                
                  
                  
                  
                  // jogando o produto dentro da lista
                  lista.add(unidade);
             }// fim do while
            return lista;
         
     }catch(SQLException erro){
         System.err.print("Erro:  " + erro);
            return null;
     }//fim do catch
          
 }// fim do método listarProdutorNome
     
  
     
     public List<Unidade> listarEventNome(String nome){
     
     String query = "SELECT id_unidade,id_chave,nome,tipo,numero,bloco,capacidade "
             + "FROM Unidade where tipo = 'Espaço de evento' AND nome LIKE ?;";
     
      List<Unidade> lista = new ArrayList<>();
        // criando o try catch
        try(Connection conection = conexaoBD.getConection();
        PreparedStatement preparedStatement = conection.prepareStatement(query)){
            
             preparedStatement.setString(1,'%'+nome+'%');
                
                ResultSet resultset = preparedStatement.executeQuery();
            // passando o valor do select para um objeto produto
            // enquanto resultset for diferente de null
            while(resultset.next()){
                // receba o valor e cadastre em produto
                  Unidade unidade = new Unidade();
                  unidade.setId_unidade(resultset.getInt("id_unidade"));
                unidade.setId_chave(resultset.getInt("id_chave"));
                unidade.setNome(resultset.getString("nome"));
                 unidade.setTipo(resultset.getString("tipo"));
                  unidade.setNumero(resultset.getString("numero"));
                unidade.setBloco(resultset.getString("bloco"));
                unidade.setCapacidade(resultset.getString("capacidade"));
                
                  
                  
                  
                  // jogando o produto dentro da lista
                  lista.add(unidade);
             }// fim do while
            return lista;
         
     }catch(SQLException erro){
         System.err.print("Erro:  " + erro);
            return null;
     }//fim do catch
     
     
 }// fim do método listarProdutorNome
     
     public List<Unidade> listarEspacoEvent(){
        List<Unidade> lista = new ArrayList<>();
        
        String query = "SELECT id_unidade,id_chave,nome,tipo,numero,bloco,capacidade FROM Unidade "
                + "WHERE tipo = 'Espaço de evento' ;";

        try(Connection connection = conexaoBD.getConection();//conexão com o banco de dados
     PreparedStatement preparedStatement = connection.prepareStatement(query)){
            
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next()){
                Unidade unidade = new Unidade();
                unidade.setId_unidade(resultSet.getInt("id_unidade"));
                unidade.setId_chave(resultSet.getInt("id_chave"));
                unidade.setNome(resultSet.getString("nome"));
                 unidade.setTipo(resultSet.getString("tipo"));
                  unidade.setNumero(resultSet.getString("numero"));
                unidade.setBloco(resultSet.getString("bloco"));
                unidade.setCapacidade(resultSet.getString("capacidade"));
                

                lista.add(unidade);

            }//fim do while
          
             return lista;
            
        }catch(SQLException e){
         System.err.println("Erro listar o Morador "+ e );
         return null;
        }//fim do try
        
    }//fim do método listarClientes()
}
