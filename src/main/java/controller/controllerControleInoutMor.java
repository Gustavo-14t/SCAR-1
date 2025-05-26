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
import model.conexaoBD;
import model.controleINOUTmorador;
import view.relatorioEntradaSaida;

/**
 *
 * @author Todosdecasa
 */
public class controllerControleInoutMor {
    
    public boolean editarControleINOUTMor(controleINOUTmorador morador) {
    String query =  
    "UPDATE c " +
    "SET c.id_funcionario = f.id_funcionario, " +
    "    c.funcionarioSaida = f.nome " +
    "FROM ControleMoradorINOUT c " +
    "INNER JOIN MoradorINOUT m ON c.id_morEntradaSaida = m.id_morEntradaSaida " +
    "INNER JOIN Funcionario f ON f.id_funcionario = ? " +
    "WHERE m.id_morador = ?";
;

    try (Connection conection = conexaoBD.getConection();
         PreparedStatement preparedStatement = conection.prepareStatement(query)) {

        preparedStatement.setInt(1, morador.getId_funcionario());
        preparedStatement.setString(2, morador.getId_morEntradaSaida()); 

        int cadastrou = preparedStatement.executeUpdate();
        return cadastrou > 0;

    } catch (SQLException e) {
        System.err.println("Erro em controle entrada/saida: " + e);
        return false;
    }
}

    
    public boolean entradaOuSaida(controleINOUTmorador morador) {
    String query =  
    "Update ControleMoradorINOUT set statu = ?,  dataSaida = GETDATE(), funcionarioSaida = ? where id_CMINOUT = ?";
;

    try (Connection conection = conexaoBD.getConection();
         PreparedStatement preparedStatement = conection.prepareStatement(query)) {

        preparedStatement.setString(1, morador.getStatu());
        preparedStatement.setString(2, morador.getFuncionarioSaida()); 
        preparedStatement.setString(3, morador.getId_CMINOUT()); 

        int cadastrou = preparedStatement.executeUpdate();
        return cadastrou > 0;

    } catch (SQLException e) {
        System.err.println("Erro em controle entrada/saida: " + e);
        return false;
    }
}
    
    public List <controleINOUTmorador> listarINOUT(){
        String query = "SELECT c.id_CMINOUT,m.nome AS nomeMorador,f.nome AS nomeFuncionario,c.dataSaida, c.statu"
                + " FROM ControleMoradorINOUT c "
                + "INNER JOIN MoradorINOUT mi ON c.id_morEntradaSaida = mi.id_morEntradaSaida "
                + "INNER JOIN Morador m ON mi.id_morador = m.id_morador "
                + "INNER JOIN Funcionario f ON c.id_funcionario = f.id_funcionario";
        
                     List<controleINOUTmorador> lista = new ArrayList<>();
                     
        try(Connection conection = conexaoBD.getConection();
        PreparedStatement preparedStatement =conection.prepareStatement(query);
         ResultSet resultset = preparedStatement.executeQuery() ){
            
            while(resultset.next()){
                controleINOUTmorador cim = new controleINOUTmorador();
                
                cim.setId_CMINOUT(resultset.getString("id_CMINOUT"));
                cim.setId_morEntradaSaida(resultset.getString("nomeMorador"));
                cim.setFuncionarioSaida(resultset.getString("nomeFuncionario"));
                cim.setDataSaida(resultset.getString("dataSaida"));
                cim.setStatu(resultset.getString("statu"));
                
                lista.add(cim);

            }//fim do while
 
            return lista;

        }catch(SQLException e){
            System.err.print("Erro ao listar relatório de Entradas e saídas "+ e);
            return null;
        }// final do try catch
}
    
}
