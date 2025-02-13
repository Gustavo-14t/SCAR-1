/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package view;

import controller.MoradorController;
import controller.UnidadeController;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import model.Morador;
import model.Unidade;

/**
 *
 * @author devmat
 */
public class CadMorador extends javax.swing.JInternalFrame {

    /**
     * Creates new form CadMorador
     */
    int idUnidade;
    int idMorador;
    
    public CadMorador() {
        initComponents();
        ListagemUnidades();
        pesquisarUsuario();
        ListagemUsuarioDelet();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    public void pesquisarUsuario(){
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
            ListagemUsuarioN(campoPesquisar.getText());
        }//fim do método pesquisar
        });//fim do método de captura
    }//fim do método PesquisarUsuario
    
    
    public void ListagemUsuarioN(String nomeUsuario){
        
        // chamando o produtos controller
        MoradorController controller = new MoradorController();
        // capturando a lista de produtos que vem do banco de dados
        List<Morador> listausuario = controller.listarMoradorNome(nomeUsuario);
        
        // Obtendo o modelo da tabela
        DefaultTableModel modeloTabela = 
                (DefaultTableModel) tabelaMorador.getModel();
    
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
        (this, "Nenhum produto encontrado.");
    }
}// fim do metodo ListagemUsuarioN()
    
    public void limparCampos(){
        campoNome.setText("");
         campoCpf.setText("");
         campNascimento.setText("");
         campoEmail.setText("");
                
    }
    public void ListagemUsuarioDelet(){
    
        
        // chamando o produtos controller
        MoradorController controller = new MoradorController();
        // capturando a lista de produtos que vem do banco de dados
        List<Morador> listarMorador= controller.listarMorador();
        
        // Obtendo o modelo da tabela
        DefaultTableModel modeloTabela = 
                (DefaultTableModel) tabelaMorador.getModel();
    
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
        (this, "Nenhum Cliente encontrado.");
    }
       
 }//fim do método de listagemUsuarioP()
    
    
         public void ListagemUnidades(){
        
        // chamando o produtos controller
        UnidadeController controller = new UnidadeController();
        // capturando a lista de produtos que vem do banco de dados
        List<Unidade> listaunidade = controller.listarUnidade();
        
        // Obtendo o modelo da tabela
        DefaultTableModel modeloTabela = 
                (DefaultTableModel) tabelaUnidade.getModel();
    
    // Limpando a tabela antes de adicionar novos dados
       modeloTabela.setRowCount(0);
    
    // Verificando se a lista não é nula
    if (listaunidade != null && !listaunidade.isEmpty()) {
        // Jogando os dados para dentro da minha tabela
        for (Unidade unidade : listaunidade) {
            // Criando uma nova linha para a tabela
            Object[] linha = {
                unidade.getId_unidade(),
                unidade.getId_chave(),
                unidade.getNome(),
                unidade.getTipo(),
                unidade.getNumero(),
                unidade.getBloco(),
                unidade.getCapacidade(),
                unidade.getDescricao(),
                unidade.getDomensoes()
            };
            // Adicionando a linha ao modelo da tabela
            modeloTabela.addRow(linha);
        }
    } else {
        JOptionPane.showMessageDialog
        (this, "Nenhum produto encontrado.");
    }
}// fim do metodo ListagemdeProdutos()
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        telaDeletar = new javax.swing.JTabbedPane();
        telaCadastro = new javax.swing.JPanel();
        butaoCadastrar = new javax.swing.JToggleButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        campNascimento = new javax.swing.JFormattedTextField();
        campoEmail = new javax.swing.JTextField();
        campoNome = new javax.swing.JTextField();
        campoCpf = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaUnidade = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tabelaMorador = new javax.swing.JTable();
        botaoDeletar = new javax.swing.JButton();
        campoPesquisar = new javax.swing.JTextField();

        telaCadastro.setBackground(new java.awt.Color(255, 204, 0));
        telaCadastro.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        butaoCadastrar.setBackground(new java.awt.Color(255, 204, 0));
        butaoCadastrar.setForeground(new java.awt.Color(0, 0, 0));
        butaoCadastrar.setText("CADASTRAR");
        butaoCadastrar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        butaoCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butaoCadastrarActionPerformed(evt);
            }
        });
        telaCadastro.add(butaoCadastrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 380, 110, 40));

        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("NOME:");
        telaCadastro.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 20));

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("CPF:");
        telaCadastro.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 30, 20));

        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("E-MAIL:");
        telaCadastro.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 80, 50, 20));

        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("DATA DE NASCIMENTO:");
        telaCadastro.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 10, -1, -1));

        campNascimento.setBackground(new java.awt.Color(255, 255, 255));
        campNascimento.setForeground(new java.awt.Color(0, 0, 0));
        try {
            campNascimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        campNascimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campNascimentoActionPerformed(evt);
            }
        });
        telaCadastro.add(campNascimento, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 30, 150, 40));

        campoEmail.setBackground(new java.awt.Color(255, 255, 255));
        campoEmail.setForeground(new java.awt.Color(0, 0, 0));
        telaCadastro.add(campoEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 100, 250, 35));

        campoNome.setBackground(new java.awt.Color(255, 255, 255));
        campoNome.setForeground(new java.awt.Color(0, 0, 0));
        telaCadastro.add(campoNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 250, 35));

        campoCpf.setBackground(new java.awt.Color(255, 255, 255));
        campoCpf.setForeground(new java.awt.Color(0, 0, 0));
        campoCpf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoCpfActionPerformed(evt);
            }
        });
        telaCadastro.add(campoCpf, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 250, 35));

        tabelaUnidade.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "CHAVE", "NOME", "TIPO", "NUMERO", "BLOCO", "CAPACIDADE", "DESCRICÃO", "DIMENSÕES"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaUnidade.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaUnidadeMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaUnidade);

        telaCadastro.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 700, 180));

        telaDeletar.addTab("Cadastrar", telaCadastro);

        jPanel1.setBackground(new java.awt.Color(255, 204, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setBackground(new java.awt.Color(0, 0, 0));
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("PESQUISAR :");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, 20));

        tabelaMorador.setBackground(new java.awt.Color(255, 255, 255));
        tabelaMorador.setForeground(new java.awt.Color(0, 0, 0));
        tabelaMorador.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelaMorador.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaMoradorMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tabelaMorador);

        jPanel1.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 700, 270));

        botaoDeletar.setBackground(new java.awt.Color(255, 204, 0));
        botaoDeletar.setForeground(new java.awt.Color(0, 0, 0));
        botaoDeletar.setText("EXCLUIR");
        botaoDeletar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        botaoDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoDeletarActionPerformed(evt);
            }
        });
        jPanel1.add(botaoDeletar, new org.netbeans.lib.awtextra.AbsoluteConstraints(315, 380, 90, 30));

        campoPesquisar.setBackground(new java.awt.Color(255, 255, 255));
        campoPesquisar.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(campoPesquisar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 250, 35));

        telaDeletar.addTab("Deletar", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(telaDeletar, javax.swing.GroupLayout.DEFAULT_SIZE, 718, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(telaDeletar, javax.swing.GroupLayout.DEFAULT_SIZE, 464, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void butaoCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butaoCadastrarActionPerformed
        // TODO add your handling code here:
        //criando o objeto Controller     
       try{
       MoradorController controller = new MoradorController();
         // criando um objeto do tipo usuario da pasta model
            Morador user = new Morador(
               this.idUnidade,
                campoNome.getText(),
                campoCpf.getText(),
                campoEmail.getText(),
                campNascimento.getText()      
            );
            
                // chamando o metodo de cadastrar o usuario no banco de dados
            controller.cadastroMorador(user);
            JOptionPane.showMessageDialog
            (null,"Usuario Cadastrado com Sucesso!");

            ListagemUsuarioDelet();
             ListagemUnidades();
            limparCampos();

        }catch(Exception e){
             JOptionPane.showMessageDialog
            (null,"Usuario Não Cadastrado! "+e);
        }
    }//GEN-LAST:event_butaoCadastrarActionPerformed

    private void campNascimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campNascimentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campNascimentoActionPerformed

    private void botaoDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoDeletarActionPerformed
        // TODO add your handling code here:
        
        MoradorController controller = new MoradorController();

        try{
            controller.deletarMorador (this.idMorador);
            JOptionPane.showMessageDialog(null,"Usuario excluído com sucesso");

             ListagemUsuarioDelet();
           campoPesquisar.setText("");
            
        }catch(Exception erro){
            JOptionPane.showMessageDialog(null,"Erro ao excluir o Produto "+ erro);
        }                                      

    }//GEN-LAST:event_botaoDeletarActionPerformed

    private void campoCpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoCpfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoCpfActionPerformed

    private void tabelaUnidadeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaUnidadeMouseClicked
        // TODO add your handling code here:
        int linhaSelecionada = tabelaUnidade.getSelectedRow();
        
        if(linhaSelecionada>=0){
            
            DefaultTableModel modelotabela = (DefaultTableModel) tabelaUnidade.getModel();
            //salvando o id do produto selecioando
            this.idUnidade = Integer.parseInt(modelotabela.getValueAt(linhaSelecionada, 0).toString());
 
        }//fim do if
    }//GEN-LAST:event_tabelaUnidadeMouseClicked

    private void tabelaMoradorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaMoradorMouseClicked
        // TODO add your handling code here:
        int linhaSelecionada = tabelaMorador.getSelectedRow();

    // Verificando se alguma linha foi selecionada
    if (linhaSelecionada >= 0) {
        // Definir modelo default para a tabela
        DefaultTableModel modeloTabela = (DefaultTableModel) tabelaMorador.getModel();

        // Verificando se os valores não são nulos antes de usar toString()
        idMorador = modeloTabela.getValueAt(linhaSelecionada, 0) != null 
                    ? Integer.parseInt(modeloTabela.getValueAt(linhaSelecionada, 0).toString()) 
                    : 0;  // Valor padrão para idMorador (caso seja nulo)
        
        idUnidade = modeloTabela.getValueAt(linhaSelecionada, 1) != null 
                    ? Integer.parseInt(modeloTabela.getValueAt(linhaSelecionada, 1).toString()) 
                    : 0;  // Valor padrão para idUnidade (caso seja nulo)
        
        campoNome.setText(modeloTabela.getValueAt(linhaSelecionada, 2) != null 
                          ? modeloTabela.getValueAt(linhaSelecionada, 2).toString() 
                          : "N/A");  // Valor padrão para Nome (caso seja nulo)
        
        campoCpf.setText(modeloTabela.getValueAt(linhaSelecionada, 3) != null 
                         ? modeloTabela.getValueAt(linhaSelecionada, 3).toString() 
                         : "N/A");  // Valor padrão para CPF (caso seja nulo)
        
        campoEmail.setText(modeloTabela.getValueAt(linhaSelecionada, 4) != null 
                           ? modeloTabela.getValueAt(linhaSelecionada, 4).toString() 
                           : "N/A");  // Valor padrão para Email (caso seja nulo)
        
        campNascimento.setText(modeloTabela.getValueAt(linhaSelecionada, 5) != null 
                               ? modeloTabela.getValueAt(linhaSelecionada, 5).toString() 
                               : "N/A");  // Valor padrão para Data de Nascimento (caso seja nulo)
    } // fim do if
    }//GEN-LAST:event_tabelaMoradorMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoDeletar;
    private javax.swing.JToggleButton butaoCadastrar;
    private javax.swing.JFormattedTextField campNascimento;
    private javax.swing.JTextField campoCpf;
    private javax.swing.JTextField campoEmail;
    private javax.swing.JTextField campoNome;
    private javax.swing.JTextField campoPesquisar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable tabelaMorador;
    private javax.swing.JTable tabelaUnidade;
    private javax.swing.JPanel telaCadastro;
    private javax.swing.JTabbedPane telaDeletar;
    // End of variables declaration//GEN-END:variables
}
