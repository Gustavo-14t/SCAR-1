/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package view;

import controller.ChaveController;
import controller.UnidadeController;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import model.Chave;
import model.Unidade;

/**
 *
 * @author devmat
 */
public class TelaCadastroUnidade extends javax.swing.JInternalFrame {
    
    int idUnidade;
    int idChave;
    
    /**
     * Creates new form TelaCadastroUnidade
     */
    public TelaCadastroUnidade() {
        initComponents();
        
        ListagemUnidades();
        pesquisarUsuario();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
     public void limparCampos(){
        campoNomeChave.setText("");
        campoNome.setText("");
        campoTipo.setSelectedIndex(-1);
         campoNumero.setText("");
         campoBloco.setText("");
         campoCapacidade.setText("");
         campoDimensoes.setText("");
         campoDescricao.setText("");
    }
     
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
       UnidadeController controller = new UnidadeController();
        // capturando a lista de produtos que vem do banco de dados
        List<Unidade> listausuario = controller.listarUnidadeNome(nomeUsuario);
        
        // Obtendo o modelo da tabela
        DefaultTableModel modeloTabela = 
                (DefaultTableModel) listaUnidade.getModel();
    
    // Limpando a tabela antes de adicionar novos dados
       modeloTabela.setRowCount(0);
    
    // Verificando se a lista não é nula
    if (listausuario != null && !listausuario.isEmpty()) {
        // Jogando os dados para dentro da minha tabela
        for (Unidade unidade : listausuario) {
            // Criando uma nova linha para a tabela
            Object[] linha = {
             
    unidade.getId_unidade() != 0 ? unidade.getId_unidade() : "N/A", // Ajuste para int
    unidade.getId_chave() != 0 ? unidade.getId_chave() : "N/A", // Ajuste para int
    unidade.getNome() != null ? unidade.getNome() : "N/A", // Verifique se é null
    unidade.getNumero() != null ? unidade.getNumero() : "N/A", // Verifique se é null
    unidade.getBloco() != null ? unidade.getBloco() : "N/A", // Verifique se é null
    unidade.getTipo() != null ? unidade.getTipo() : "N/A", // Verifique se é null
    unidade.getCapacidade() != null ? unidade.getCapacidade() : "N/A" // Verifique se é null
                    
                   
};

   
            // Adicionando a linha ao modelo da tabela
            modeloTabela.addRow(linha);
        }
    } else {
        JOptionPane.showMessageDialog
        (this, "Nenhuma unidade encontrada.");
    }
}// fim do metodo ListagemUsuarioN()
     
     public void ListagemUnidades(){
        
        // chamando o produtos controller
        UnidadeController controller = new UnidadeController();
        // capturando a lista de produtos que vem do banco de dados
        List<Unidade> listaunidade = controller.listarUnidade();
        
        // Obtendo o modelo da tabela
        DefaultTableModel modeloTabela = 
                (DefaultTableModel) listaUnidade.getModel();
    
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
                unidade.getNumero(),
                unidade.getBloco(),
                unidade.getTipo(),
               unidade.getCapacidade()
             
            };
            // Adicionando a linha ao modelo da tabela
            modeloTabela.addRow(linha);
        }
    } else {
        JOptionPane.showMessageDialog
        (this, "Nenhuma unidade encontrada.");
    }
}// fim do metodo ListagemdeProdutos()
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        nome = new javax.swing.JLabel();
        campoNome = new javax.swing.JTextField();
        tipo = new javax.swing.JLabel();
        campoTipo = new javax.swing.JComboBox<>();
        numero = new javax.swing.JLabel();
        campoNumero = new javax.swing.JTextField();
        bloco = new javax.swing.JLabel();
        campoBloco = new javax.swing.JTextField();
        capacidade = new javax.swing.JLabel();
        campoCapacidade = new javax.swing.JTextField();
        dimensoes = new javax.swing.JLabel();
        campoDimensoes = new javax.swing.JTextField();
        descicao = new javax.swing.JLabel();
        campoDescricao = new javax.swing.JTextField();
        nomeChave = new javax.swing.JLabel();
        campoNomeChave = new javax.swing.JTextField();
        butaoCadastrar = new javax.swing.JToggleButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaUnidade = new javax.swing.JTable();
        campoPesquisar = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        butaoDeletar = new javax.swing.JButton();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane1.setBackground(new java.awt.Color(255, 153, 0));
        jTabbedPane1.setForeground(new java.awt.Color(0, 0, 0));

        jPanel1.setBackground(new java.awt.Color(255, 204, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        nome.setForeground(new java.awt.Color(0, 0, 0));
        nome.setText("NOME:");
        jPanel1.add(nome, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 70, -1));

        campoNome.setBackground(new java.awt.Color(255, 255, 255));
        campoNome.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(campoNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 220, 35));

        tipo.setForeground(new java.awt.Color(0, 0, 0));
        tipo.setText("TIPO:");
        jPanel1.add(tipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 62, -1));

        campoTipo.setBackground(new java.awt.Color(255, 255, 255));
        campoTipo.setForeground(new java.awt.Color(0, 0, 0));
        campoTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Casa", "Espaço De Evento", "Outros", " " }));
        campoTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoTipoActionPerformed(evt);
            }
        });
        jPanel1.add(campoTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 220, 35));

        numero.setForeground(new java.awt.Color(0, 0, 0));
        numero.setText("NUMERO:");
        jPanel1.add(numero, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 56, -1));

        campoNumero.setBackground(new java.awt.Color(255, 255, 255));
        campoNumero.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(campoNumero, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 220, 35));

        bloco.setForeground(new java.awt.Color(0, 0, 0));
        bloco.setText("BLOCO:");
        jPanel1.add(bloco, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 64, -1));

        campoBloco.setBackground(new java.awt.Color(255, 255, 255));
        campoBloco.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(campoBloco, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 220, 35));

        capacidade.setForeground(new java.awt.Color(0, 0, 0));
        capacidade.setText("CAPACIDADE(PESSOAS):");
        jPanel1.add(capacidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 20, 140, -1));

        campoCapacidade.setBackground(new java.awt.Color(255, 255, 255));
        campoCapacidade.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(campoCapacidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 40, 220, 35));

        dimensoes.setForeground(new java.awt.Color(0, 0, 0));
        dimensoes.setText("DIMENSÕES");
        jPanel1.add(dimensoes, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 80, 80, -1));

        campoDimensoes.setBackground(new java.awt.Color(255, 255, 255));
        campoDimensoes.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(campoDimensoes, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 100, 220, 35));

        descicao.setForeground(new java.awt.Color(0, 0, 0));
        descicao.setText("DESCRIÇÃO");
        jPanel1.add(descicao, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 150, 103, -1));

        campoDescricao.setBackground(new java.awt.Color(255, 255, 255));
        campoDescricao.setForeground(new java.awt.Color(0, 0, 0));
        campoDescricao.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jPanel1.add(campoDescricao, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 170, 220, 110));

        nomeChave.setForeground(new java.awt.Color(0, 0, 0));
        nomeChave.setText("NOME CHAVE:");
        jPanel1.add(nomeChave, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 30, 90, -1));

        campoNomeChave.setBackground(new java.awt.Color(255, 255, 255));
        campoNomeChave.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(campoNomeChave, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 50, 120, 35));

        butaoCadastrar.setText("Cadastrar");
        butaoCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butaoCadastrarActionPerformed(evt);
            }
        });
        jPanel1.add(butaoCadastrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 220, 125, 57));

        jTabbedPane1.addTab("Cadastrar", jPanel1);

        jPanel4.setBackground(new java.awt.Color(255, 204, 0));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        listaUnidade.setBackground(new java.awt.Color(255, 255, 255));
        listaUnidade.setForeground(new java.awt.Color(0, 0, 0));
        listaUnidade.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, "", "", "", "", ""},
                {null, null, "", "", "", "", ""},
                {null, null, "", "", "", "", null},
                {null, null, "", "", null, "", ""},
                {null, null, "", "", "", "", null},
                {null, null, null, "", "", "", null},
                {null, null, "", null, "", null, ""},
                {null, null, null, null, null, null, ""},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "ID CHAVE", "Nome", "Numero", "Bloco", "Tipo", "Capacidade"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        listaUnidade.setSelectionBackground(new java.awt.Color(255, 255, 255));
        listaUnidade.setSelectionForeground(new java.awt.Color(0, 0, 0));
        listaUnidade.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaUnidadeMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(listaUnidade);

        jPanel4.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 90, 706, 285));

        campoPesquisar.setBackground(new java.awt.Color(255, 255, 255));
        campoPesquisar.setForeground(new java.awt.Color(0, 0, 0));
        jPanel4.add(campoPesquisar, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 40, 380, 35));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("PESQUISAR:");
        jPanel4.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 14, 87, -1));

        butaoDeletar.setBackground(new java.awt.Color(255, 204, 0));
        butaoDeletar.setForeground(new java.awt.Color(0, 0, 0));
        butaoDeletar.setText("DELETAR");
        butaoDeletar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        butaoDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butaoDeletarActionPerformed(evt);
            }
        });
        jPanel4.add(butaoDeletar, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 380, 85, 38));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Deletar", jPanel2);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 730, 470));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void butaoCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butaoCadastrarActionPerformed
        // TODO add your handling code here:
        if(campoNome.getText().isEmpty() || campoNumero.getText().isEmpty() || campoBloco.getText().isEmpty() ||
    campoCapacidade.getText().isEmpty() || campoDimensoes.getText().isEmpty() || 
                campoDescricao.getText().isEmpty() || campoNomeChave.getText().isEmpty() ){
            JOptionPane.showMessageDialog(null, "Preencha todos os campos");
        }else{
      
       try {
    ChaveController controller = new ChaveController();
    Chave chave = new Chave(campoNomeChave.getText());
    idChave = controller.cadastroChave(chave); 
    if (idChave > 0) {
        JOptionPane.showMessageDialog(null, "Chave Cadastrada com Sucesso!");
    } else {
        JOptionPane.showMessageDialog(null, "Erro ao cadastrar a chave.");
        return;
    }

    UnidadeController unidadeController = new UnidadeController();
    Unidade unidade = new Unidade(
        idChave, 
        campoTipo.getSelectedItem().toString(),
        campoNumero.getText(),
        campoBloco.getText(),
        campoCapacidade.getText(),
        campoDescricao.getText(),    
        campoNome.getText(),
        campoDimensoes.getText()
       
    );
    unidadeController.cadastroUnidade(unidade);
    JOptionPane.showMessageDialog(null, "Unidade Cadastrada com Sucesso!");
    
    ListagemUnidades();
    limparCampos();

} catch (Exception e) {
    JOptionPane.showMessageDialog(null, "Erro ao cadastrar: " + e.getMessage());
}

        }
    }//GEN-LAST:event_butaoCadastrarActionPerformed

    private void campoTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoTipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoTipoActionPerformed

    private void listaUnidadeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaUnidadeMouseClicked
        // TODO add your handling code here:
        int linhaSelecionada = listaUnidade.getSelectedRow();

    // Verificando se alguma linha foi selecionada
    if (linhaSelecionada >= 0) {
        // Definir modelo default para a tabela
        DefaultTableModel modeloTabela = (DefaultTableModel) listaUnidade.getModel();

        // Verificando se os valores não são nulos antes de usar toString()
        idUnidade = modeloTabela.getValueAt(linhaSelecionada, 0) != null 
                    ? Integer.parseInt(modeloTabela.getValueAt(linhaSelecionada, 0).toString()) 
                    : 0;  // Valor padrão para idMorador (caso seja nulo)
        
        this.idChave = modeloTabela.getValueAt(linhaSelecionada, 1) != null 
                    ? Integer.parseInt(modeloTabela.getValueAt(linhaSelecionada, 1).toString()) 
                    : 0;  // Valor padrão para idUnidade (caso seja nulo)
        
        campoNome.setText(modeloTabela.getValueAt(linhaSelecionada, 2) != null 
                          ? modeloTabela.getValueAt(linhaSelecionada, 2).toString() 
                          : "N/A");  // Valor padrão para Nome (caso seja nulo)
        
        campoNumero.setText(modeloTabela.getValueAt(linhaSelecionada, 3) != null 
                         ? modeloTabela.getValueAt(linhaSelecionada, 3).toString() 
                         : "N/A");  // Valor padrão para CPF (caso seja nulo)
        
        campoBloco.setText(modeloTabela.getValueAt(linhaSelecionada, 4) != null 
                           ? modeloTabela.getValueAt(linhaSelecionada, 4).toString() 
                           : "N/A");  // Valor padrão para Email (caso seja nulo)
        
        campoTipo.setSelectedItem(modeloTabela.getValueAt(linhaSelecionada,5) != null 
               ? modeloTabela.getValueAt(linhaSelecionada, 3).toString() 
                         : "N/A");  // Valor padrão para Data de Nascimento (caso seja nulo)
    } // fim do if
    }//GEN-LAST:event_listaUnidadeMouseClicked

    private void butaoDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butaoDeletarActionPerformed
        // TODO add your handling code here:
        UnidadeController controller = new UnidadeController();

        try{
            controller.deletarUnidade (this.idUnidade);
            JOptionPane.showMessageDialog(null,"Usuario excluído com sucesso");

             ListagemUnidades();
             limparCampos();
           campoPesquisar.setText("");
            
        }catch(Exception erro){
            JOptionPane.showMessageDialog(null,"Erro ao excluir o Produto "+ erro);
        }                                      
                                    

    }//GEN-LAST:event_butaoDeletarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bloco;
    private javax.swing.JToggleButton butaoCadastrar;
    private javax.swing.JButton butaoDeletar;
    private javax.swing.JTextField campoBloco;
    private javax.swing.JTextField campoCapacidade;
    private javax.swing.JTextField campoDescricao;
    private javax.swing.JTextField campoDimensoes;
    private javax.swing.JTextField campoNome;
    private javax.swing.JTextField campoNomeChave;
    private javax.swing.JTextField campoNumero;
    private javax.swing.JTextField campoPesquisar;
    private javax.swing.JComboBox<String> campoTipo;
    private javax.swing.JLabel capacidade;
    private javax.swing.JLabel descicao;
    private javax.swing.JLabel dimensoes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable listaUnidade;
    private javax.swing.JLabel nome;
    private javax.swing.JLabel nomeChave;
    private javax.swing.JLabel numero;
    private javax.swing.JLabel tipo;
    // End of variables declaration//GEN-END:variables
}
