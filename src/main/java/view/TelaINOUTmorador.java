/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package view;

import controller.INOUTmorController;
import controller.MoradorController;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import model.Funcionario;
import model.INOUTmorador;
import model.Morador;

/**
 *
 * @author Todosdecasa
 */


public class TelaINOUTmorador extends javax.swing.JInternalFrame {

    /**
     * Creates new form TelaINOUTmorador
     */
    Funcionario func;
    
    String idMor;
    
    public TelaINOUTmorador(Funcionario funcionario) {
        initComponents();
        
        func = funcionario;
        
        
        ListagemMorador();
        pesquisarMorador();
    }
    
    public void pesquisarMorador(){
        campoPesquisar.getDocument().addDocumentListener(
                new DocumentListener(){
            //Anotação que informa que eu nção estou escrevendo um método e sim que eu estou sobre escrevendo
            //o método atual
             @Override
            public void insertUpdate(javax.swing.event.DocumentEvent e){
                pesquisar();
            }// fim do insertUpdate
             @Override
            public void removeUpdate(javax.swing.event.DocumentEvent e){
                pesquisar();
            }
             @Override
         public void changedUpdate(javax.swing.event.DocumentEvent e){
                pesquisar();
         }
        private void pesquisar (){
            ListagemMoradorNome(campoPesquisar.getText());
        }//fim do método pesquisar
        });//fim do método de captura
    }//fim do método PesquisarUsuario
   
    
    public void ListagemMoradorNome(String nomeUsuario){
        
        // chamando o produtos controller
        MoradorController controller = new MoradorController();
        // capturando a lista de produtos que vem do banco de dados
        List<Morador> listausuario = controller.listarMoradorNome(nomeUsuario);
        
        // Obtendo o modelo da tabela
        DefaultTableModel modeloTabela = 
                (DefaultTableModel) tabelaMorador1.getModel();
    
    // Limpando a tabela antes de adicionar novos dados
       modeloTabela.setRowCount(0);
    
    // Verificando se a lista não é nula
    if (listausuario != null && !listausuario.isEmpty()) {
        // Jogando os dados para dentro da minha tabela
        for (Morador morador : listausuario) {
            // Criando uma nova linha para a tabela
            Object[] linha = {
              
    morador.getId_morador() != 0 ? morador.getId_morador() : "N/A", // Ajuste para int
    morador.getId_unidade() != 0 ? morador.getId_unidade() : "N/A", // Ajuste para int
    morador.getNome() != null ? morador.getNome() : "N/A", // Verifique se é null
    morador.getCpf() != null ? morador.getCpf() : "N/A", // Verifique se é null
    morador.getEmail() != null ? morador.getEmail() : "N/A", // Verifique se é null
    morador.getData_nasc() != null ? morador.getData_nasc() : "N/A" // Verifique se é null
};

   
            // Adicionando a linha ao modelo da tabela
            modeloTabela.addRow(linha);
        }
    } else {
        JOptionPane.showMessageDialog
        (this, "Nenhum Morador encontrado.");
    }
}// fim do metodo ListagemUsuarioN()
    
    public void ListagemMorador(){
    
        
        // chamando o produtos controller
        MoradorController controller = new MoradorController();
        // capturando a lista de produtos que vem do banco de dados
        List<Morador> listarMorador= controller.listarMorador();
        
        // Obtendo o modelo da tabela
        DefaultTableModel modeloTabela = 
                (DefaultTableModel) tabelaMorador1.getModel();
    
    // Limpando a tabela antes de adicionar novos dados
       modeloTabela.setRowCount(0);
    
    // Verificando se a lista não é nula
    if (listarMorador != null && !listarMorador.isEmpty()) {
        // Jogando os dados para dentro da minha tabela
        for (Morador morador : listarMorador) {
            // Criando uma nova linha para a tabela
            Object[] linha = {
             morador.getId_morador(), // Ajuste para int
             morador.getId_unidade(), // Ajuste para int
             morador.getNome(), // Verifique se é null
             morador.getCpf(), // Verifique se é null
             morador.getEmail(), // Verifique se é null
             morador.getData_nasc() // Verifique se é null
            };
            // Adicionando a linha ao modelo da tabela
            modeloTabela.addRow(linha);
           
        }
         
        
    } else {
        JOptionPane.showMessageDialog
        (this, "Nenhum Morador encontrado.");
    }
       
 }//fim do método de listagemUsuarioP()

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        panelEntrada = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tabelaMorador1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        campoPesquisar = new javax.swing.JTextField();
        panelSaida = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tabelaMorador2 = new javax.swing.JTable();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelEntrada.setBackground(new java.awt.Color(255, 204, 0));
        panelEntrada.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabelaMorador1.setBackground(new java.awt.Color(255, 255, 255));
        tabelaMorador1.setForeground(new java.awt.Color(0, 0, 0));
        tabelaMorador1.setModel(new javax.swing.table.DefaultTableModel(
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
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "CASA", "NOME", "CPF", "EMAIL", "DATA NASCIMENTO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaMorador1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaMorador1MouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(tabelaMorador1);

        panelEntrada.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 700, 270));

        jButton1.setText("Permitir Entrada");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        panelEntrada.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 350, 150, 40));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("MORADOR:");
        panelEntrada.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        campoPesquisar.setBackground(new java.awt.Color(255, 255, 255));
        campoPesquisar.setForeground(new java.awt.Color(0, 0, 0));
        panelEntrada.add(campoPesquisar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 200, 30));

        jTabbedPane1.addTab("Morador Entrada", panelEntrada);

        panelSaida.setBackground(new java.awt.Color(255, 204, 0));
        panelSaida.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabelaMorador2.setBackground(new java.awt.Color(255, 255, 255));
        tabelaMorador2.setForeground(new java.awt.Color(0, 0, 0));
        tabelaMorador2.setModel(new javax.swing.table.DefaultTableModel(
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
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "CASA", "NOME", "CPF", "EMAIL", "DATA NASCIMENTO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaMorador2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaMorador2MouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tabelaMorador2);

        panelSaida.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 706, 210));

        jTabbedPane1.addTab("Morador Saída", panelSaida);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 1, 730, 470));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tabelaMorador2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaMorador2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tabelaMorador2MouseClicked

    private void tabelaMorador1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaMorador1MouseClicked
        // TODO add your handling code here:
        // TODO add your handling code here:
        // TODO add your handling code here:7
        int linhaSelecionada = tabelaMorador1.getSelectedRow();

        //verificando se alguam linha foi selecionada
        if(linhaSelecionada>=0){
            //definir modelo default para a tabela
            DefaultTableModel modeloTabela =
            (DefaultTableModel) tabelaMorador1.getModel();

            //jogando os dados da tabela para os campos de texto
           idMor = modeloTabela.getValueAt(linhaSelecionada, 0).toString();
        }//fim do if
    }//GEN-LAST:event_tabelaMorador1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:    
        //criando o objeto Controller
        INOUTmorController controller = new INOUTmorController();
        
        INOUTmorador iomorador = new INOUTmorador ();
        //passando os valores para o objeto vendas
        iomorador.setId_morador(idMor);
        iomorador.setId_funcionario(func.getId_funcionario());
        
        
        if (idMor == "null" ) {
    JOptionPane.showMessageDialog(this, "Selecione um morador.");
    return;
}
        // passando os dados da venda para o banco de dados
        boolean cadastrou = controller.OUTmorador(iomorador);
        if(cadastrou){
            JOptionPane.showMessageDialog(
                    null,"Saída de Morador registrada com sucesso");
        }else{
           JOptionPane.showMessageDialog(
                    null,"Não foi possivel registrar a saída do morador!"); 
        }// fim do else
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField campoPesquisar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel panelEntrada;
    private javax.swing.JPanel panelSaida;
    private javax.swing.JTable tabelaMorador1;
    private javax.swing.JTable tabelaMorador2;
    // End of variables declaration//GEN-END:variables
}
