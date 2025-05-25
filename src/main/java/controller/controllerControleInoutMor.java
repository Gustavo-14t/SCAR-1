/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.conexaoBD;
import model.controleINOUTmorador;

/**
 *
 * @author Todosdecasa
 */
public class controllerControleInoutMor {
    
    public boolean editarControleINOUTMor(controleINOUTmorador morador){
      String query = "String sql = \"\"\"\n" +
"    UPDATE c\n" +
"    SET \n" +
"        c.id_funcionario = f.id_funcionario,\n" +
"        c.funcionarioSaida = f.nome  -- ou c.funcionarioEntrada\n" +
"    FROM ControleMoradorINOUT c\n" +
"    INNER JOIN MoradorINOUT m ON c.id_morEntradaSaida = m.id_morEntradaSaida\n" +
"    INNER JOIN Funcionario f ON f.id_funcionario = ?\n" +
"    WHERE m.id_morador = ?";

                   
    // Conexão com o banco de dados
    try (Connection conection = conexaoBD.getConection();
         PreparedStatement preparedStatement = conection.prepareStatement(query)) {

        // Definindo os parâmetros do preparedStatement
        preparedStatement.setInt(1, morador.getId_funcionario()); // id do morador da reserva
        preparedStatement.setString(2, morador.getId_morEntradaSaida());
        // Executando o update
        int cadastrou = preparedStatement.executeUpdate();
        return cadastrou > 0;

    } catch (SQLException e) {
        System.err.println("Erro em controle entrada saida: " + e);
        return false;
    } // fim do try-catch
} // fim do método editarReserva
    
}
