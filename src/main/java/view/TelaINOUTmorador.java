/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package view;

import controller.INOUTmorController;
import controller.MoradorController;
import controller.controllerControleInoutMor;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import model.Funcionario;
import model.INOUTmorador;
import model.Morador;
import model.controleINOUTmorador;
import model.moradorAndINOUT;

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
    String idCim;
    
    public TelaINOUTmorador(Funcionario funcionario) {
        initComponents();
        
        func = funcionario;
        
         ListagemINOUT();
        ListagemMorador();
        pesquisarMorador();
    }
    public void ListagemINOUT(){
        //cria um objeto de vendasController
        controllerControleInoutMor controller = new  controllerControleInoutMor();
        //capturando a lista de relatório de vendas
        List<model.controleINOUTmorador> lista = controller.listarINOUT();
        
        //modelo padrão de tabela
       DefaultTableModel modeloTabela = (DefaultTableModel)tabelaINOUT.getModel();
        
       //Limpando a tabela antes de adicionar nobvos dados
       modeloTabela.setRowCount(0);
       
       //verificar se a lista esta vazia
       if(lista !=null && !lista.isEmpty()){
           for (model.controleINOUTmorador reserva : lista){
               Object[] linha = {
                   reserva.getId_CMINOUT(),
                   reserva.getId_morEntradaSaida(),
                   reserva.getFuncionarioSaida(),
                   reserva.getDataSaida(),
                   reserva.getStatu(),
                   
   
               };//fim do objeto linha
               modeloTabela.addRow(linha);
               
           }//fim do for
       }else{
           JOptionPane.showMessageDialog(null,"Não existem Entradas ou Saídas!");
       }//fim do else
    
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
       INOUTmorController controller = new INOUTmorController();
        // capturando a lista de produtos que vem do banco de dados
        List<moradorAndINOUT> listarMorador= controller.listarMoradornull();
        
        // Obtendo o modelo da tabela
        DefaultTableModel modeloTabela = 
                (DefaultTableModel) tabelaMorador1.getModel();
    
    // Limpando a tabela antes de adicionar novos dados
       modeloTabela.setRowCount(0);
    
    // Verificando se a lista não é nula
    if (listarMorador != null && !listarMorador.isEmpty()) {
        // Jogando os dados para dentro da minha tabela
        
        for (moradorAndINOUT morador : listarMorador) {
            // Criando uma nova linha para a tabela
            Object[] linha = {
             morador.getId_morEntradaSaida(),
             morador.getId_morador(), // Ajuste para int
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
    } // Verificação se a tabela tem linhas
    if (modeloTabela.getRowCount() == 0) {
        panelMoradores.setVisible(false);
    } else {
        panelMoradores.setVisible(true);
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
        panelMoradores = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tabelaMorador1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        campoPesquisar = new javax.swing.JTextField();
        panelEnter = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        tabelaINOUT = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelMoradores.setBackground(new java.awt.Color(255, 204, 0));
        panelMoradores.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
                "CONTROLE", "ID", "NOME", "CPF", "EMAIL", "DATA NASCIMENTO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, false
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

        panelMoradores.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 700, 270));

        jButton1.setText("Permitir Entrada");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        panelMoradores.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 350, 150, 40));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("MORADOR:");
        panelMoradores.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        campoPesquisar.setBackground(new java.awt.Color(255, 255, 255));
        campoPesquisar.setForeground(new java.awt.Color(0, 0, 0));
        panelMoradores.add(campoPesquisar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 200, 30));

        jTabbedPane1.addTab("Moradores", panelMoradores);

        panelEnter.setBackground(new java.awt.Color(255, 204, 0));
        panelEnter.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabelaINOUT.setBackground(new java.awt.Color(255, 255, 255));
        tabelaINOUT.setForeground(new java.awt.Color(0, 0, 0));
        tabelaINOUT.setModel(new javax.swing.table.DefaultTableModel(
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
                {null, null, null, null, null}
            },
            new String [] {
                "CONTROLE", "MORADOR", "FUNCIONARIO", "DATA_MOVIMENTO", "STATU"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaINOUT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaINOUTMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(tabelaINOUT);

        panelEnter.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 706, 210));

        jButton2.setText("Entrada");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        panelEnter.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 280, 110, 40));

        jButton3.setText("Saída");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        panelEnter.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 280, 110, 40));

        jTabbedPane1.addTab("Morador Entrada", panelEnter);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 730, 470));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
        
        controllerControleInoutMor controla = new controllerControleInoutMor();
        
        
       controleINOUTmorador cim = new controleINOUTmorador ();
       cim.setId_funcionario(func.getId_funcionario());
        cim.setId_morEntradaSaida(idMor);
        
        
        if (idMor == null || idMor.trim().isEmpty() || "null".equals(idMor)) {
    JOptionPane.showMessageDialog(this, "Selecione um morador.");
    return;
}
        // passando os dados da venda para o banco de dados
        boolean cadastrou = controller.editarINOUT(iomorador);
        boolean cdastro = controla.editarControleINOUTMor(cim) ;
        if(cadastrou){
            JOptionPane.showMessageDialog(
                    null,"Entrada de Morador registrada com sucesso");
            
         if(cdastro){
            JOptionPane.showMessageDialog(
                    null,"Pegamo o id do funcionario");
        }else{
           JOptionPane.showMessageDialog(
                    null,"Não foi possível pegar o id de funcionario"); 
        }// fim do else
        }else{
           JOptionPane.showMessageDialog(
                    null,"Não foi possivel registrar a saída do morador!"); 
        }// fim do else
        ListagemMorador();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tabelaINOUTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaINOUTMouseClicked
        // TODO add your handling code here:
        int linhaSelecionada = tabelaINOUT.getSelectedRow();

        //verificando se alguam linha foi selecionada
        if(linhaSelecionada>=0){
            //definir modelo default para a tabela
            DefaultTableModel modeloTabela =
            (DefaultTableModel) tabelaINOUT.getModel();

            //jogando os dados da tabela para os campos de texto
           idCim = modeloTabela.getValueAt(linhaSelecionada, 0).toString();
        }//fim do if
    }//GEN-LAST:event_tabelaINOUTMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        System.out.println("idCim: " + idCim);
        if (idCim == null || idCim.trim().isEmpty() || "null".equals(idCim)) {
        JOptionPane.showMessageDialog(this, "Selecione um controle (linha da tabela de entradas/saídas).");
        return;
    }

    controllerControleInoutMor controller = new controllerControleInoutMor();
    
    controleINOUTmorador cim = new controleINOUTmorador();
    cim.setStatu("ENTRADA");
    cim.setFuncionarioSaida(func.getNome());
    cim.setId_CMINOUT(idCim);  // <- aqui precisa estar preenchido
    
    boolean cadastrou = controller.entradaOuSaida(cim);
    if(cadastrou){
        JOptionPane.showMessageDialog(null, "Entrada registrada com sucesso");
         ListagemINOUT();
    } else {
        JOptionPane.showMessageDialog(null, "Não foi possível registrar entrada");
    }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
    System.out.println("idCim: " + idCim);   
    if (idCim == null || idCim.trim().isEmpty() || "null".equals(idCim)) {
        JOptionPane.showMessageDialog(this, "Selecione um controle (linha da tabela de entradas/saídas).");
        return;
    }

    controllerControleInoutMor controller = new controllerControleInoutMor();
    
    controleINOUTmorador cim = new controleINOUTmorador();
    cim.setStatu("SAIDA");
    cim.setFuncionarioSaida(func.getNome());
    cim.setId_CMINOUT(idCim);
    
    boolean cadastrou = controller.entradaOuSaida(cim);
    if(cadastrou){
        JOptionPane.showMessageDialog(null, "Saída registrada com sucesso");
         ListagemINOUT();
    } else {
        JOptionPane.showMessageDialog(null, "Não foi possível registrar saída");
    }

    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField campoPesquisar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel panelEnter;
    private javax.swing.JPanel panelMoradores;
    private javax.swing.JTable tabelaINOUT;
    private javax.swing.JTable tabelaMorador1;
    // End of variables declaration//GEN-END:variables
}
