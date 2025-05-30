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
import model.Reserva;
import model.ReservaList;
import model.conexaoBD;

/**
 *
 * @author devmat
 */
public class ReservaController {
    public boolean cadastroReserva( Reserva reserva){
     //criuando uma String que recebe uma comando SQL
     String query = "INSERT INTO Reserva (id_chave,id_morador,id_unidade,id_funcionario,data_reserva,statu) values (?,?,?,?,?,?) ";
     
     try(Connection conection = conexaoBD.getConection();
        PreparedStatement preparedStatement =
                conection.prepareStatement(query)){       
            
            // mandar os dados para dentro do insert
            preparedStatement.setInt(1,reserva.getId_chave());
             preparedStatement.setInt(2,reserva.getId_morador());
            preparedStatement.setInt(3,reserva.getId_unidade());
            preparedStatement.setInt(4,reserva.getId_funcionario());
             preparedStatement.setString(5,reserva.getData_reserva());
             preparedStatement.setString(6,reserva.getStatu());
             
    
            
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
    
   public boolean editarReserva(ReservaList reserva){
      String query = "UPDATE r \n" +
"SET r.statu = ?\n" +
"FROM Reserva r\n" +
"INNER JOIN Morador m ON r.id_morador = m.id_morador\n" +
"INNER JOIN Unidade u ON r.id_unidade = u.id_unidade\n" +
"WHERE m.nome = ? and u.nome = ? ";
                   
    // Conexão com o banco de dados
    try (Connection conection = conexaoBD.getConection();
         PreparedStatement preparedStatement = conection.prepareStatement(query)) {

        // Definindo os parâmetros do preparedStatement
        preparedStatement.setString(1, reserva.getStatu());  // Novo status da reserva
        preparedStatement.setString(2, reserva.getMorador()); // id do morador da reserva
        preparedStatement.setString(3, reserva.getUnidade());
        // Executando o update
        int cadastrou = preparedStatement.executeUpdate();
        return cadastrou > 0;

    } catch (SQLException e) {
        System.err.println("Erro ao editar o status da reserva: " + e);
        return false;
    } // fim do try-catch
} // fim do método editarReserva
 
    
    
     public List<Reserva> listarRserva(){
        List<Reserva> lista = new ArrayList<>();
        
        String query = "SELECT id_chave,id_morador,id_unidade,id_funcionario,data_reserva,statu FROM Reserva ;";

        try(Connection connection = conexaoBD.getConection();//conexão com o banco de dados
     PreparedStatement preparedStatement = connection.prepareStatement(query)){
            
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next()){
                Reserva reserva = new Reserva();
                
                 reserva.setId_chave(resultSet.getInt("id_chave"));
                  reserva.setId_morador(resultSet.getInt("id_morador"));
                reserva.setId_unidade(resultSet.getInt("id_unidade"));
                reserva.setId_funcionario(resultSet.getInt("id_funcionario"));
                reserva.setData_reserva(resultSet.getString("data_reserva"));
                reserva.setStatu(resultSet.getString("statu"));

                lista.add(reserva);

            }//fim do while
          
             return lista;
            
        }catch(SQLException e){
         System.err.println("Erro listar o Reserva "+ e );
         return null;
        }//fim do try
        
    }//fim do método listarClientes()

     public List <ReservaList> listarReservasAprov(){
        String query = " SELECT m.nome as Morador ,u.nome as Unidade ,"
                + "f.nome as Funcionario,c.nome as Chave ,v.data_reserva as Data_reserva,v.statu as Sttatus \n" +
"FROM Reserva v INNER JOIN Morador m  ON v.id_morador =m.id_morador \n" +
"INNER JOIN unidade u ON v.id_unidade = u.id_unidade \n" +
"INNER JOIN Funcionario f ON v.id_funcionario = f.id_funcionario\n" +
"INNER JOIN chave c ON v.id_chave = c.id_chave"
                + " WHERE v.statu = 'Aprovado'";

        
                     List<ReservaList> lista = new ArrayList<>();
                     
        try(Connection conection = conexaoBD.getConection();
        PreparedStatement preparedStatement =conection.prepareStatement(query);
         ResultSet resultset = preparedStatement.executeQuery() ){
            
            while(resultset.next()){
                ReservaList reserva = new ReservaList();
                
               reserva.setChave(resultset.getString("Chave"));
               reserva.setMorador(resultset.getString("Morador"));
               reserva.setUnidade(resultset.getString("Unidade"));
               reserva.setFuncionario(resultset.getString("Funcionario"));
               reserva.setData_reserva(resultset.getString("Data_reserva"));
               reserva.setStatu(resultset.getString("Sttatus"));
                
                lista.add(reserva);

            }//fim do while
 
            return lista;

        }catch(SQLException e){
            System.err.print("Erro ao listar Reservas "+ e);
            return null;
        }// final do try catch
}
     
     public List <ReservaList> listarReservasPendente(){
        String query = " SELECT m.nome as Morador ,u.nome as Unidade ,"
                + "f.nome as Funcionario,c.nome as Chave ,v.data_reserva as Data_reserva,v.statu as Sttatus \n" +
"FROM Reserva v INNER JOIN Morador m  ON v.id_morador =m.id_morador \n" +
"INNER JOIN unidade u ON v.id_unidade = u.id_unidade \n" +
"INNER JOIN Funcionario f ON v.id_funcionario = f.id_funcionario\n" +
"INNER JOIN chave c ON v.id_chave = c.id_chave"
                + " WHERE v.statu = 'pendente'";
        
                     List<ReservaList> lista = new ArrayList<>();
                     
        try(Connection conection = conexaoBD.getConection();
        PreparedStatement preparedStatement =conection.prepareStatement(query);
         ResultSet resultset = preparedStatement.executeQuery() ){
            
            while(resultset.next()){
                ReservaList reserva = new ReservaList();
                
               reserva.setChave(resultset.getString("Chave"));
               reserva.setMorador(resultset.getString("Morador"));
               reserva.setUnidade(resultset.getString("Unidade"));
               reserva.setFuncionario(resultset.getString("Funcionario"));
               reserva.setData_reserva(resultset.getString("Data_reserva"));
               reserva.setStatu(resultset.getString("Sttatus"));
                
                lista.add(reserva);

            }//fim do while
 
            return lista;

        }catch(SQLException e){
            System.err.print("Erro ao listar Reservas "+ e);
            return null;
        }// final do try catch
}
     public boolean deletarReserva(){
         String query = "DELETE FROM Reserva WHERE morador = ? and chave = ?";
        //Connection - conecta-se ao banco de dados
        //PreparedStatement manda o comando sql para executar no BD
        try (Connection connection = conexaoBD.getConection();//conexão com o banco de dados
     PreparedStatement preparedStatement = connection.prepareStatement(query)){//mandar o comando select 
            //mandando idUsuario para dentro do camando sql
            //preparedStatement.setInt();
            
                        int resultado = preparedStatement.executeUpdate();
            return resultado > 0;
           
        }catch(SQLException e){
             System.err.print(e+ " Exclusão não realizada  ");
            return false;
        }//fim do 
     }//fim do public boolean

}
