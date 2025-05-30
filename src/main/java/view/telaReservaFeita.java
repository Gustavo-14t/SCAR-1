/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package view;

import controller.ContResController;
import controller.ReservaController;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.ControleReserva;
import model.Funcionario;
import model.RelatorioReserva;
import model.Reserva;
import model.ReservaList;

/**
 *
 * @author devmat
 */
public class telaReservaFeita extends javax.swing.JInternalFrame {

    Funcionario funcionario;
    
    String nomeUnidade;
    String nomeMorador;
    String funcEntrega;
    String morador;
    
    /**
     * Creates new form telaReservaFeita
     */
    public telaReservaFeita(Funcionario funcao) {
        initComponents();
        ListagemReservaAprov();
        ListagemReservaPende();
        ListagemRelatorio();
        
      funcionario = funcao;
    }
    
        public void ListagemRelatorio(){
        //cria um objeto de vendasController
        ContResController controller = new  ContResController();
        //capturando a lista de relatório de vendas
        List<RelatorioReserva> lista = controller.listarRelatorios();
        
        //modelo padrão de tabela
       DefaultTableModel modeloTabela = (DefaultTableModel)tabelaDevolucao.getModel();
        
       //Limpando a tabela antes de adicionar nobvos dados
       modeloTabela.setRowCount(0);
       
       //verificar se a lista esta vazia
       if(lista !=null && !lista.isEmpty()){
           for (RelatorioReserva reserva : lista){
               Object[] linha = {
                   reserva.getFunc_entrega(),
                   reserva.getData_entrega(),
                   reserva.getFunc_devolucao(),
                   reserva.getData_devolucao(),
                   reserva.getMorador(),
   
               };//fim do objeto linha
               modeloTabela.addRow(linha);
               
           }//fim do for
       }else{
           JOptionPane.showMessageDialog(null,"Não existem Reservas aprovadas para devolução!");
       }//fim do else
    
    }

     public void ListagemReservaAprov(){
        //cria um objeto de vendasController
        ReservaController controller = new  ReservaController();
        //capturando a lista de relatório de vendas
        List<ReservaList> lista = controller.listarReservasAprov();
        
        //modelo padrão de tabela
       DefaultTableModel modeloTabela = (DefaultTableModel)tabelaReservaA.getModel();
        
       //Limpando a tabela antes de adicionar nobvos dados
       modeloTabela.setRowCount(0);
       
       //verificar se a lista esta vazia
       if(lista !=null && !lista.isEmpty()){
           for (ReservaList reserva : lista){
               Object[] linha = {
                   reserva.getMorador(),
                   reserva.getChave(),
                   reserva.getUnidade(),
                   reserva.getFuncionario(),
                   reserva.getData_reserva(),
                   reserva.getStatu(),
                   
                       
               };//fim do objeto linha
               modeloTabela.addRow(linha);
               
           }//fim do for
       }else{
           JOptionPane.showMessageDialog(null,"Não existem Reservas Aprovadas!");
       }//fim do else
        
    }//fim do método de ListagemVendas()
    
      
       public void ListagemReservaPende(){
        //cria um objeto de vendasController
        ReservaController controller = new  ReservaController();
        //capturando a lista de relatório de vendas
        List<ReservaList> lista = controller.listarReservasPendente();
        
        //modelo padrão de tabela
       DefaultTableModel modeloTabela = (DefaultTableModel)tabelaReservaP.getModel();
        
       //Limpando a tabela antes de adicionar nobvos dados
       modeloTabela.setRowCount(0);
       
       //verificar se a lista esta vazia
       if(lista !=null && !lista.isEmpty()){
           for (ReservaList reserva : lista){
               Object[] linha = {
                   reserva.getMorador(),
                   reserva.getChave(),
                   reserva.getUnidade(),
                   reserva.getFuncionario(),
                   reserva.getData_reserva(),
                   reserva.getStatu(),
                   
                       
               };//fim do objeto linha
               modeloTabela.addRow(linha);
               
           }//fim do for
       }else{
           JOptionPane.showMessageDialog(null,"Não existem Reservas pendentes!");
       }//fim do else
        
    }//fim do método de ListagemVendas()
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaReservaA = new javax.swing.JTable();
        campoAprovado = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabelaDevolucao = new javax.swing.JTable();
        buttomEntreg = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaReservaP = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        campoPendente = new javax.swing.JTextField();
        bAprovar = new javax.swing.JButton();
        buttomNegar = new javax.swing.JButton();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 204, 0));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabelaReservaA.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Morador", "Chave", "Unidade", "Funcionario", "Data Reserva", "Status"
            }
        ));
        tabelaReservaA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaReservaAMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabelaReservaA);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 67, 690, 240));

        campoAprovado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoAprovadoActionPerformed(evt);
            }
        });
        jPanel2.add(campoAprovado, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, 287, 35));

        jLabel2.setForeground(new java.awt.Color(51, 51, 55));
        jLabel2.setText("Pesquisar");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 70, 23));

        jTabbedPane1.addTab("Reservas Aprovadas", jPanel2);

        jPanel3.setBackground(new java.awt.Color(255, 204, 0));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabelaDevolucao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Funcionario entrega", "Entrega", "Funcionario Devolução", "Devolução", "Morador"
            }
        ));
        tabelaDevolucao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaDevolucaoMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tabelaDevolucao);

        jPanel3.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 37, 690, 290));

        buttomEntreg.setText("Registrar Devolução");
        buttomEntreg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttomEntregActionPerformed(evt);
            }
        });
        jPanel3.add(buttomEntreg, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 340, 150, -1));

        jTabbedPane1.addTab("Registrar devolução", jPanel3);

        jPanel1.setBackground(new java.awt.Color(255, 204, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabelaReservaP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Morador", "Chave", "Unidade", "Funcionario", "Data Reserva", "Status"
            }
        ));
        tabelaReservaP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaReservaPMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaReservaP);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 67, 659, 175));

        jLabel1.setForeground(new java.awt.Color(51, 51, 55));
        jLabel1.setText("Pesquisar");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 18, 60, 23));

        campoPendente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoPendenteActionPerformed(evt);
            }
        });
        jPanel1.add(campoPendente, new org.netbeans.lib.awtextra.AbsoluteConstraints(88, 12, 287, 35));

        bAprovar.setText("Aprovar Reserva");
        bAprovar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAprovarActionPerformed(evt);
            }
        });
        jPanel1.add(bAprovar, new org.netbeans.lib.awtextra.AbsoluteConstraints(554, 270, 130, -1));

        buttomNegar.setText("Negar Reserva");
        buttomNegar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttomNegarActionPerformed(evt);
            }
        });
        jPanel1.add(buttomNegar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 270, -1, -1));

        jTabbedPane1.addTab("Reservas Pendentes", jPanel1);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 730, 470));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void campoPendenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoPendenteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoPendenteActionPerformed

    private void bAprovarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAprovarActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:
         //criando o objeto Controller
         //passando os valores para o objeto vendas
        ReservaController controller = new ReservaController();
        
        ReservaList reserva = new ReservaList ();
        //passando os valores para o objeto vendas
         reserva.setStatu("Aprovado");
        reserva.setMorador(this.nomeMorador);
        reserva.setUnidade(this.nomeUnidade);
   
        // passando os dados da venda para o banco de dados
        boolean cadastrou = controller.editarReserva(reserva);
        if(cadastrou){
            JOptionPane.showMessageDialog(
                    null,"Reserva aprovada com sucesso");
            
        }else{
           JOptionPane.showMessageDialog(
                    null,"Não foi possivel aprovar reserva!"); 
        }// fim do else 
        ListagemReservaPende();
        ListagemReservaAprov();
        ListagemRelatorio();
    }//GEN-LAST:event_bAprovarActionPerformed

    private void campoAprovadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoAprovadoActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_campoAprovadoActionPerformed

    
    private void tabelaReservaAMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaReservaAMouseClicked
        // TODO add your handling code here:
           int linhaSelecionada = tabelaReservaA.getSelectedRow();

    // Verificando se alguma linha foi selecionada
    if (linhaSelecionada >= 0) {
        // Definir modelo default para a tabela
        DefaultTableModel modeloTabela = (DefaultTableModel) tabelaReservaA.getModel();

        // Verificando se os valores não são nulos antes de usar toString()
        
        nomeMorador = modeloTabela.getValueAt(linhaSelecionada, 0) != null 
                    ? modeloTabela.getValueAt(linhaSelecionada, 0).toString() 
                    : "";  // Valor padrão para nomeMorador (caso seja nulo)
        nomeUnidade = modeloTabela.getValueAt(linhaSelecionada, 0) != null 
                    ? modeloTabela.getValueAt(linhaSelecionada, 2).toString() 
                    : "";  // Valor padrão para nomeMorador (caso seja nulo)
        
    } // fim do if
    }//GEN-LAST:event_tabelaReservaAMouseClicked

    private void tabelaReservaPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaReservaPMouseClicked
         // TODO add your handling code here:
        int linhaSelecionada = tabelaReservaP.getSelectedRow();

    // Verificando se alguma linha foi selecionada
    if (linhaSelecionada >= 0) {
        // Definir modelo default para a tabela
        DefaultTableModel modeloTabela = (DefaultTableModel) tabelaReservaP.getModel();

        // Verificando se os valores não são nulos antes de usar toString()
        
         nomeMorador = modeloTabela.getValueAt(linhaSelecionada, 0) != null 
                    ? modeloTabela.getValueAt(linhaSelecionada, 0).toString() 
                    : "";  // Valor padrão para nomeMorador (caso seja nulo)
         nomeUnidade = modeloTabela.getValueAt(linhaSelecionada, 0) != null 
                    ? modeloTabela.getValueAt(linhaSelecionada, 2).toString() 
                    : "";  // Valor padrão para nomeMorador (caso seja nulo)
        
    } // fim do if
    }//GEN-LAST:event_tabelaReservaPMouseClicked

    private void buttomNegarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttomNegarActionPerformed
        // TODO add your handling code here:
   
    }//GEN-LAST:event_buttomNegarActionPerformed

    private void buttomEntregActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttomEntregActionPerformed
        // TODO add your handling code here:
       //criando o objeto Controller
  
    ContResController controller = new ContResController();
    
    RelatorioReserva reserva = new RelatorioReserva ();
    reserva.setFunc_devolucao(this.funcionario.getNome());
    reserva.setFunc_entrega(this.funcEntrega);
    reserva.setMorador(this.morador);
    
   
    boolean cadastrou = controller.editarContRes(reserva);
    
    if (cadastrou) {
        JOptionPane.showMessageDialog(null,"Devolução registrada com Sucesso");
    } else {
        JOptionPane.showMessageDialog(null,"Não foi possível registrar devolução!");
    }
    
    ListagemRelatorio();
    
    }//GEN-LAST:event_buttomEntregActionPerformed

    private void tabelaDevolucaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaDevolucaoMouseClicked
        // TODO add your handling code here:
         int linhaSelecionada = tabelaDevolucao.getSelectedRow();

    // Verificando se alguma linha foi selecionada
    if (linhaSelecionada >= 0) {
        // Definir modelo default para a tabela
        DefaultTableModel modeloTabela = (DefaultTableModel) tabelaDevolucao.getModel();

        // Verificando se os valores não são nulos antes de usar toString()
        
         funcEntrega = modeloTabela.getValueAt(linhaSelecionada, 0) != null 
                    ? modeloTabela.getValueAt(linhaSelecionada, 0).toString() 
                    : "";  // Valor padrão para nomeMorador (caso seja nulo)
         morador = modeloTabela.getValueAt(linhaSelecionada, 0) != null 
                    ? modeloTabela.getValueAt(linhaSelecionada, 4).toString() 
                    : "";  // Valor padrão para nomeMorador (caso seja nulo)
    }//GEN-LAST:event_tabelaDevolucaoMouseClicked
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAprovar;
    private javax.swing.JButton buttomEntreg;
    private javax.swing.JButton buttomNegar;
    private javax.swing.JTextField campoAprovado;
    private javax.swing.JTextField campoPendente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tabelaDevolucao;
    private javax.swing.JTable tabelaReservaA;
    private javax.swing.JTable tabelaReservaP;
    // End of variables declaration//GEN-END:variables
}
