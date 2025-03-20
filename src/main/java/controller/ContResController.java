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
import model.ControleReserva;
import model.RelatorioReserva;
import model.conexaoBD;

/**
 *
 * @author devmat
 */
public class ContResController {
    public boolean cadastroUnidade( ControleReserva contRes){
     //criuando uma String que recebe uma comando SQL
     String query = "INSERT INTO ControleReserva (id_reserva,data_entrega,data_devolucao,funcionario_entrega,funcionario_devolucao) values (?,?,?,?,?) ";
     
     try(Connection conection = conexaoBD.getConection();
        PreparedStatement preparedStatement =
                conection.prepareStatement(query)){       
            
            // mandar os dados para dentro do insert
            preparedStatement.setInt(1,contRes.getId_reserva());
             preparedStatement.setString(2,contRes.getData_entrega());
            preparedStatement.setString(3,contRes.getData_devolucao());
            preparedStatement.setString(4,contRes.getFuncionario_entrega());
             preparedStatement.setString(5,contRes.getFuncionario_devolucao());
    
            
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
    
    
     public List<ControleReserva> listarUnidade(){
        List<ControleReserva> lista = new ArrayList<>();
        
        String query = "SELECT id_reserva,data_entrega,data_devolucao,funcionario_entrega,funcionario_devolucao FROM ControleReserva ;";

        try(Connection connection = conexaoBD.getConection();//conexão com o banco de dados
     PreparedStatement preparedStatement = connection.prepareStatement(query)){
            
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next()){
                ControleReserva contRes = new ControleReserva();     
                 contRes.setId_reserva(resultSet.getInt("id_reserva"));
                  contRes.setData_entrega(resultSet.getString("data_entrega"));
                contRes.setData_devolucao(resultSet.getString("data_devolucao"));
                contRes.setFuncionario_entrega(resultSet.getString("funcionario_entrega"));
                contRes.setFuncionario_devolucao(resultSet.getString("funcionario_devolucao"));
                

                lista.add(contRes);

            }//fim do while
          
             return lista;
            
        }catch(SQLException e){
         System.err.println("Erro listar o Controle De Reserva "+ e );
         return null;
        }//fim do try
        
    }//fim do método listarClientes()
     
     
     public boolean deletarUnidade(int idContRes){
         String query = "DELETE FROM ControleReserva WHERE id_controleReserva = ?";
        //Connection - conecta-se ao banco de dados
        //PreparedStatement manda o comando sql para executar no BD
        try (Connection connection = conexaoBD.getConection();//conexão com o banco de dados
     PreparedStatement preparedStatement = connection.prepareStatement(query)){//mandar o comando select 
            //mandando idUsuario para dentro do camando sql
            preparedStatement.setInt(1,idContRes);
            
                        int resultado = preparedStatement.executeUpdate();
            return resultado > 0;
           
        }catch(SQLException e){
             System.err.print(e+ " Exclusão não realizada  ");
            return false;
        }//fim do 
     }//fim do public boolean
    
     public List <RelatorioReserva> listarTodasAsVendas(){
        String query = " SELECT c.nome as Cliente ,p.nome as Produto ,u.nome as Vendedor,v.quantidade as Quantidade ,v.valor as Preco,v.datavenda as Data_da_venda "
                + " FROM Vendas v INNER JOIN clientes c ON v.idcliente =c.id " +
                    " INNER JOIN produtos p ON v.idproduto = p.id " +
                     "  INNER JOIN Usuario u ON v.idvendedor = u.id_cliente;";
        
                     List<RelatorioReserva> lista = new ArrayList<>();
                     
        try(Connection conection = conexaoBD.getConection();
        PreparedStatement preparedStatement =conection.prepareStatement(query);
         ResultSet resultset = preparedStatement.executeQuery() ){
            
            while(resultset.next()){
                RelatorioReserva reserva = new RelatorioReserva();
                
                //vendas.setNomeCliente(resultset.getString("Cliente"));
                //vendas.setNomeProduto(resultset.getString("Produto"));
                //vendas.setNomeVendedor(resultset.getString("Vendedor"));
                //vendas.setQuantidade(resultset.getInt("Quantidade"));
                //vendas.setPreco(resultset.getFloat("Preco"));
                //vendas.setDataVenda(resultset.getString("Data_da_venda"));
                
                lista.add(reserva);

            }//fim do while
 
            return lista;

        }catch(SQLException e){
            System.err.print("Erro ao listar vendas "+ e);
            return null;
        }// final do try catch
}
}
