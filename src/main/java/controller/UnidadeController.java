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
import model.Unidade;
import model.conexaoBD;

/**
 *
 * @author devmat
 */
public class UnidadeController {
    public boolean cadastroUnidade( Unidade unidade){
     //criuando uma String que recebe uma comando SQL
     String query = "INSERT INTO Unidade (tipo,nome,cpf,email,data_nasc) values (?,?,?,?,?) ";
     
     try(Connection conection = conexaoBD.getConection();
        PreparedStatement preparedStatement =
                conection.prepareStatement(query)){       
            
            // mandar os dados para dentro do insert
            preparedStatement.setString(1,unidade.getTipo());
             preparedStatement.setString(2,unidade.getNumero());
            preparedStatement.setString(3,unidade.getBloco());
            preparedStatement.setString(4,unidade.getCapacidade());
             preparedStatement.setString(5,unidade.getDescricao());
             preparedStatement.setString(6,unidade.getNome());
              preparedStatement.setString(7,unidade.getDomensoes());
    
            
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
    
    
     public List<Unidade> listarUnidade(){
        List<Unidade> lista = new ArrayList<>();
        
        String query = "SELECT tipo,numero,bloco,capacidade,descricao,nome,dimensoes FROM Unidade ;";

        try(Connection connection = conexaoBD.getConection();//conexão com o banco de dados
     PreparedStatement preparedStatement = connection.prepareStatement(query)){
            
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next()){
                Unidade unidade = new Unidade();     
                 unidade.setTipo(resultSet.getString("tipo"));
                  unidade.setNumero(resultSet.getString("numero"));
                unidade.setBloco(resultSet.getString("bloco"));
                unidade.setCapacidade(resultSet.getString("capacidade"));
                unidade.setDescricao(resultSet.getString("Descricao"));
                unidade.setNome(resultSet.getString("nome"));
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
}
