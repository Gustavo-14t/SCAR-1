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
import model.Atividade;
import model.conexaoBD;

/**
 *
 * @author devmat
 */
public class AtividadeController {
    public boolean cadastroAtividade( Atividade atividade){
     //criuando uma String que recebe uma comando SQL
     String query = "INSERT INTO Atividade (id_funcionario, nome, descricao, datas, statu) values (?,?,?,?,?) ";
     
     try(Connection conection = conexaoBD.getConection();
        PreparedStatement preparedStatement =
                conection.prepareStatement(query)){       
            
            // mandar os dados para dentro do insert
            preparedStatement.setInt(1,atividade.getId_funcionario());
            preparedStatement.setString(2,atividade.getNome());
            preparedStatement.setString(3,atividade.getDescricao());
             preparedStatement.setString(4,atividade.getDatas());
              preparedStatement.setString(5,atividade.getStatu());
           
           
            
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
    
    
     public List<Atividade> listarAtividade(){
        List<Atividade> lista = new ArrayList<>();
        
        String query = "SELECT id_atividade,id_funcionario,nome,descricao,datas,statu FROM Atividade ;";

        try(Connection connection = conexaoBD.getConection();//conexão com o banco de dados
     PreparedStatement preparedStatement = connection.prepareStatement(query)){
            
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next()){
                Atividade atividade = new Atividade();
                
                atividade.setId_atividade(resultSet.getInt("id_atividade"));
                atividade.setId_funcionario(resultSet.getInt("id_funcionario"));
                atividade.setNome(resultSet.getString("nome"));
                atividade.setDescricao(resultSet.getString("descricao"));
                atividade.setDatas(resultSet.getString("datas"));
                 atividade.setStatu(resultSet.getString("statu"));
                
                
                lista.add(atividade);

            }//fim do while
          
             return lista;
            
        }catch(SQLException e){
         System.err.println("Erro listar o usuário "+ e );
         return null;
        }//fim do try
        
    }//fim do método listarClientes()
     
     
     public boolean deletarUsuario(int idAtividade){
        
         String query = "DELETE FROM Atividade WHERE id_atividade = ?";
        //Connection - conecta-se ao banco de dados
        //PreparedStatement manda o comando sql para executar no BD
        try (Connection connection = conexaoBD.getConection();//conexão com o banco de dados
     PreparedStatement preparedStatement = connection.prepareStatement(query)){//mandar o comando select 
            //mandando idUsuario para dentro do camando sql
            preparedStatement.setInt(1,idAtividade);
            
                        int resultado = preparedStatement.executeUpdate();
            return resultado > 0;
           
        }catch(SQLException e){
             System.err.print(e+ " Exclusão não realizada  ");
            return false;
        }//fim do 
     }//fim do public boolean
     
     
     /*public List<Atividade> listarUsuarioNome(String nome){
     
     String query = "SELECT id_usuario,nome,cpf,cargo FROM Usuario where nome LIKE ?;";
     
      List<Usuario> lista = new ArrayList<>();
        // criando o try catch
        try(Connection conection = ConexaoBD.getConection();
        PreparedStatement preparedStatement = conection.prepareStatement(query)){
            
             preparedStatement.setString(1,'%'+nome+'%');
                
                ResultSet resultset = preparedStatement.executeQuery();
            // passando o valor do select para um objeto produto
            // enquanto resultset for diferente de null
            while(resultset.next()){
                // receba o valor e cadastre em produto
                  Usuario usuario = new Usuario();
                  usuario.setId_usuario(resultset.getInt("id_usuario"));
                  usuario.setNome(resultset.getString("nome"));
                  usuario.setCpf(resultset.getString("cpf"));
                  usuario.setCargo(resultset.getString("cargo"));
                  
                  
                  // jogando o produto dentro da lista
                  lista.add(usuario);
             }// fim do while
            return lista;
         
     }catch(SQLException erro){
         System.err.print("Erro:  " + erro);
            return null;
     }//fim do catch
     
     
 }// fim do método listarProdutorNome
     */
}
