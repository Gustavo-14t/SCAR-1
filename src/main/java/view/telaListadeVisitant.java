/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package view;

import controller.VisitanteController;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import model.Visitante;

/**
 *
 * @author Todosdecasa
 */
public class telaListadeVisitant extends javax.swing.JDialog {

    String nomeVisita;
    String cpf;
    
    /**
     * Creates new form telaListadeVisitant
     */
    public telaListadeVisitant(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        
        initComponents();
        
        pesquisarVisitante();
        ListagemVisitante();
    }
    
    // getters
    public String getNomeVisita() {
        return nomeVisita;
    }

    public String getCpf() {
        return cpf;
    }


    
    public void pesquisarVisitante(){
        campoPesquisa.getDocument().addDocumentListener(
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
            ListagemVisitanteN(campoPesquisa.getText());
        }//fim do método pesquisar
        });//fim do método de captura
    }//fim do método PesquisarUsuario
   
   public void ListagemVisitanteN(String nomeUsuario){
        
        // chamando o produtos controller
        VisitanteController controller = new VisitanteController();
        // capturando a lista de produtos que vem do banco de dados
        List<Visitante> listaVisitante = controller.listarVisitanteNome(nomeUsuario);
        
        // Obtendo o modelo da tabela
        DefaultTableModel modeloTabela = 
                (DefaultTableModel) tabelaVisitante.getModel();
    
    // Limpando a tabela antes de adicionar novos dados
       modeloTabela.setRowCount(0);
    
    // Verificando se a lista não é nula
    if (listaVisitante != null && !listaVisitante.isEmpty()) {
        // Jogando os dados para dentro da minha tabela
                for (Visitante visitante : listaVisitante) {
            // Criando uma nova linha para a tabela
            Object[] linha = {
                visitante.getNome(),
                visitante.getCpf(),
                visitante.getTelefone(),
                visitante.getPlacaVeiculo(),
                
            };
            // Adicionando a linha ao modelo da tabela
            modeloTabela.addRow(linha);
        }
    } else {
        JOptionPane.showMessageDialog
        (this, "Nenhum Visitante encontrado.");
    }
}// fim do metodo ListagemUsuarioN()
    
    public void ListagemVisitante(){
        
        // chamando o produtos controller
       VisitanteController controller = new VisitanteController();
        // capturando a lista de produtos que vem do banco de dados
        List<Visitante> listaVisitante= controller.listarVisitante();
        
        // Obtendo o modelo da tabela
        DefaultTableModel modeloTabela = 
                (DefaultTableModel) tabelaVisitante.getModel();
    
    // Limpando a tabela antes de adicionar novos dados
       modeloTabela.setRowCount(0);
    
    // Verificando se a lista não é nula
    if (listaVisitante != null && !listaVisitante.isEmpty()) {
        // Jogando os dados para dentro da minha tabela
        for (Visitante visitante : listaVisitante) {
            // Criando uma nova linha para a tabela
            Object[] linha = {
                visitante.getNome(),
                visitante.getCpf(),
                visitante.getTelefone(),
                visitante.getPlacaVeiculo(),
                
            };
            // Adicionando a linha ao modelo da tabela
            modeloTabela.addRow(linha);
        }
    } else {
        JOptionPane.showMessageDialog
        (this, "Nenhum Visitante encontrado.");
    }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaVisitante = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        campoPesquisa = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 204, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabelaVisitante.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "NOME", "CPF", "TELEFONE", "PLACA VEÍCULO"
            }
        ));
        tabelaVisitante.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaVisitanteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaVisitante);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 68, 590, 201));

        jButton1.setText("Selecionar Visitante");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(425, 297, 187, 33));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Pesquisar visitante por nome:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 6, -1, -1));
        jPanel1.add(campoPesquisa, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 32, 231, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 620, 350));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tabelaVisitanteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaVisitanteMouseClicked
        // TODO add your handling code here:
        // TODO add your handling code here:7
        int linhaSelecionada = tabelaVisitante.getSelectedRow();

        //verificando se alguam linha foi selecionada
        if(linhaSelecionada>=0){
            //definir modelo default para a tabela
            DefaultTableModel modeloTabela =
            (DefaultTableModel) tabelaVisitante.getModel();

            //jogando os dados da tabela para os campos de texto
            nomeVisita = modeloTabela.getValueAt(linhaSelecionada, 0).toString();
            cpf = modeloTabela.getValueAt(linhaSelecionada, 1).toString();
        }//fim do if
    }//GEN-LAST:event_tabelaVisitanteMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        System.out.println("Visitante selecionado: " + nomeVisita + " - " + cpf);
        dispose(); // fecha a janela
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(telaListadeVisitant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(telaListadeVisitant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(telaListadeVisitant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(telaListadeVisitant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                telaListadeVisitant dialog = new telaListadeVisitant(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField campoPesquisa;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaVisitante;
    // End of variables declaration//GEN-END:variables
}
