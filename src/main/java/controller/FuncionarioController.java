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
import model.Funcionario;
import model.conexaoBD;

/**
 *
 * @author devmat
 */
public class FuncionarioController {
    
    public boolean cadastroUsuario( Funcionario funcionario){
     //criuando uma String que recebe uma comando SQL
     String query = "INSERT INTO Usuario ( nome,cpf,telefone, endereco, departamento, senha) values (?,?,?,?,?,?) ";
     
     try(Connection conection = conexaoBD.getConection();
        PreparedStatement preparedStatement =
                conection.prepareStatement(query)){       
            
            // mandar os dados para dentro do insert
            preparedStatement.setString(1,funcionario.getNome());
            preparedStatement.setString(2,funcionario.getCpf());
            preparedStatement.setString(3,funcionario.getTelefone());
             preparedStatement.setString(4,funcionario.getEndereco());
             preparedStatement.setString(5,funcionario.getDepartamento());
             preparedStatement.setString(6,funcionario.getSenha());
           
           
            
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
    
    
     public List<Funcionario> listarUsuario(){
        List<Funcionario> lista = new ArrayList<>();
        
        String query = "SELECT id_usuario,nome,cpf,telefone,endereco,departamento FROM Usuario ;";

        try(Connection connection = conexaoBD.getConection();//conexão com o banco de dados
     PreparedStatement preparedStatement = connection.prepareStatement(query)){
            
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next()){
                Funcionario funcionario = new Funcionario();
                
                funcionario.setId_funcionario(resultSet.getInt("id_funcionario"));
                funcionario.setNome(resultSet.getString("nome"));
                funcionario.setCpf(resultSet.getString("cpf"));
                funcionario.setTelefone(resultSet.getString("telefone"));
                funcionario.setEndereco(resultSet.getString("endereco"));
                funcionario.setDepartamento(resultSet.getString("departamento"));
               
                
                
                lista.add(funcionario);

            }//fim do while
          
             return lista;
            
        }catch(SQLException e){
         System.err.println("Erro listar o usuário "+ e );
         return null;
        }//fim do try
        
    }//fim do método listarClientes()
     
     
     public boolean deletarFuncionario(int idFuncionario){
         String query = "DELETE FROM Funcionario WHERE id_funcionario = ?";
        //Connection - conecta-se ao banco de dados
        //PreparedStatement manda o comando sql para executar no BD
        try (Connection connection = conexaoBD.getConection();//conexão com o banco de dados
     PreparedStatement preparedStatement = connection.prepareStatement(query)){//mandar o comando select 
            //mandando idUsuario para dentro do camando sql
            preparedStatement.setInt(1,idFuncionario);
            
                        int resultado = preparedStatement.executeUpdate();
            return resultado > 0;
           
        }catch(SQLException e){
             System.err.print(e+ " Exclusão não realizada  ");
            return false;
        }//fim do 
     }//fim do public boolean
     
     
     public List<Funcionario> listarUsuarioNome(String nome){
     
     String query = "SELECT id_funcionario,nome,cpf,telefone,departamento FROM Funcionario where nome LIKE ?;";
     
      List<Funcionario> lista = new ArrayList<>();
        // criando o try catch
        try(Connection conection = conexaoBD.getConection();
        PreparedStatement preparedStatement = conection.prepareStatement(query)){
            
             preparedStatement.setString(1,'%'+nome+'%');
                
                ResultSet resultset = preparedStatement.executeQuery();
            // passando o valor do select para um objeto produto
            // enquanto resultset for diferente de null
            while(resultset.next()){
                // receba o valor e cadastre em produto
                  Funcionario funcionario = new Funcionario();
                  funcionario.setId_funcionario(resultset.getInt("id_funcionario"));
                  funcionario.setNome(resultset.getString("nome"));
                  funcionario.setCpf(resultset.getString("cpf"));
                  funcionario.setTelefone(resultset.getString("telefone"));
                  funcionario.setDepartamento(resultset.getString("departamento"));
                  
                  
                  
                  // jogando o produto dentro da lista
                  lista.add(funcionario);
             }// fim do while
            return lista;
         
     }catch(SQLException erro){
         System.err.print("Erro:  " + erro);
            return null;
     }//fim do catch
     
     
 }// fim do método listarProdutorNome
}
