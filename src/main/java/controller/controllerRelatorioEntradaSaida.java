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
import model.relatorioEntradaSaida;

/**
 *
 * @author Todosdecasa
 */
public class controllerRelatorioEntradaSaida {
    
    public List <relatorioEntradaSaida> listarRelatorios(){
        String query = " SELECT \n" +
"    m.nome AS nomeMorador,\n" +
"    h.nomeFuncionario,\n" +
"    h.dataMovimentacao,\n" +
"    h.tipoMovimentacao\n" +
"FROM HistoricoMovimentacaoMorador h\n" +
"INNER JOIN ControleMoradorINOUT c ON h.id_CMINOUT = c.id_CMINOUT\n" +
"INNER JOIN MoradorINOUT mi ON c.id_morEntradaSaida = mi.id_morEntradaSaida\n" +
"INNER JOIN Morador m ON mi.id_morador = m.id_morador";
        
                     List<relatorioEntradaSaida> lista = new ArrayList<>();
                     
        try(Connection conection = conexaoBD.getConection();
        PreparedStatement preparedStatement =conection.prepareStatement(query);
         ResultSet resultset = preparedStatement.executeQuery() ){
            
            while(resultset.next()){
                relatorioEntradaSaida reserva = new relatorioEntradaSaida();
                
                reserva.setNomeMorador(resultset.getString("nomeMorador"));
                reserva.setNomeFuncionario(resultset.getString("nomeFuncionario"));
                reserva.setDataMovimentacao(resultset.getString("dataMovimentacao"));
                reserva.setTipoMovimentacao(resultset.getString("tipoMovimentacao"));
                
                
                lista.add(reserva);

            }//fim do while
 
            return lista;

        }catch(SQLException e){
            System.err.print("Erro ao listar relatório de Entradas e saídas "+ e);
            return null;
        }// final do try catch
}
    
}
