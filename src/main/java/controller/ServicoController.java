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
import model.ReservaList;
import model.Servico;
import model.conexaoBD;

/**
 *
 * @author devmat
 */
public class ServicoController {
    
    public boolean SolicitarServico( Servico servico){
     //criuando uma String que recebe uma comando SQL
     String query = "INSERT INTO Servico (id_morador,nome,descricao,prazo) values (?,?,?,?) ";
     
     try(Connection conection = conexaoBD.getConection();
        PreparedStatement preparedStatement =
                conection.prepareStatement(query)){       
            
            // mandar os dados para dentro do insert
             preparedStatement.setString(1,servico.getNomeMorador());
            preparedStatement.setString(2,servico.getNome());
            preparedStatement.setString(3,servico.getDescricao());
             preparedStatement.setString(4,servico.getPrazo());
             
             
    
            
            /*try(ResultSet resultSet = preparedStatement.executeQuery()){
                return resultSet.next();
            }// final do segundo try*/
            // verifica se o insert foi executado
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
            
        }catch(SQLException e){
            // imprimindo erro que deu ao inserir usuário
            System.err.print("Erro ao Inserir Dados de Servico!" + e);
            return false;
        }// final do try catch
    
}// fim do método SolicitarServico()
    
    public boolean editarServico(Servico servico){
      String query = "UPDATE Servico SET statu = ? WHERE id_servico = ? ";
                   
    // Conexão com o banco de dados
    try (Connection conection = conexaoBD.getConection();
         PreparedStatement preparedStatement = conection.prepareStatement(query)) {

        // Definindo os parâmetros do preparedStatement
        preparedStatement.setInt(2, servico.getId_servico());  // Novo status da reserva
        preparedStatement.setString(1, servico.getStatu()); // id do morador da reserva
        // Executando o update
        int cadastrou = preparedStatement.executeUpdate();
        return cadastrou > 0;

    } catch (SQLException e) {
        System.err.println("Erro ao marcar atividade como concluída: " + e);
        return false;
    } // fim do try-catch
} // fim do método editarReserva
    
    public List<Servico> listaServicoPend(){
        List<Servico> lista = new ArrayList<>();
        
        String query = "SELECT s.id_servico as id, m.nome as Morador, s.nome as Nome,s.descricao as descricao,"
                + " s.prazo as Prazo, "
                + "s.statu as Statuz "
                + "FROM Servico s "
                + "INNER JOIN Morador m ON s.id_morador = m.id_morador "
                + "WHERE s.statu = 'pendente';";

        try(Connection connection = conexaoBD.getConection();//conexão com o banco de dados
     PreparedStatement preparedStatement = connection.prepareStatement(query)){
            
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next()){
                Servico servico = new Servico();
                
                servico.setId_servico(resultSet.getInt("id"));
                servico.setNomeMorador(resultSet.getString("morador"));
                servico.setNome(resultSet.getString("nome"));
                servico.setDescricao(resultSet.getString("descricao"));
                servico.setPrazo(resultSet.getString("prazo"));
                servico.setStatu(resultSet.getString("statuz"));

                lista.add(servico);

            }//fim do while
          
             return lista;
            
        }catch(SQLException e){
         System.err.println("Erro listar o Servico "+ e );
         return null;
        }//fim do try
        
    }//fim do método listarClientes()
    
    public List<Servico> listaServicoAprovados(){
        List<Servico> lista = new ArrayList<>();
        
        String query = "SELECT s.id_servico as id, m.nome as Morador, s.nome as Nome,s.descricao as descricao,"
                + " s.prazo as Prazo, "
                + "s.statu as Statuz "
                + "FROM Servico s "
                + "INNER JOIN Morador m ON s.id_morador = m.id_morador "
                + "WHERE s.statu = 'aprovado';";

        try(Connection connection = conexaoBD.getConection();//conexão com o banco de dados
     PreparedStatement preparedStatement = connection.prepareStatement(query)){
            
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next()){
                Servico servico = new Servico();
                
                servico.setId_servico(resultSet.getInt("id"));
                servico.setNomeMorador(resultSet.getString("morador"));
                servico.setNome(resultSet.getString("nome"));
                servico.setDescricao(resultSet.getString("descricao"));
                servico.setPrazo(resultSet.getString("prazo"));
                servico.setStatu(resultSet.getString("statuz"));

                lista.add(servico);

            }//fim do while
          
             return lista;
            
        }catch(SQLException e){
         System.err.println("Erro listar o Servico "+ e );
         return null;
        }//fim do try
        
    }//fim do método listarClientes()
    
    public boolean negarServico(int idServico){
         String query = "DELETE FROM Servico WHERE id_morador = ?";
         try (Connection connection = conexaoBD.getConection();//conexão com o banco de dados
     PreparedStatement preparedStatement = connection.prepareStatement(query)){//mandar o comando select 
            //mandando idUsuario para dentro do camando sql
            preparedStatement.setInt(1,idServico);
            
                        int resultado = preparedStatement.executeUpdate();
            return resultado > 0;
           
        }catch(SQLException e){
             System.err.print(e+ " Exclusão não realizada  ");
            return false;
        }//fim do 
     }//fim do public boolean
    
}
