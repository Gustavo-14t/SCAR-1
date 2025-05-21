/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package view;

import controller.MoradorController;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import model.Funcionario;
import model.Morador;
import model.Visitante;

/**
 *
 * @author devmat
 */
public class TelaEntradaSaida extends javax.swing.JInternalFrame {

    /**
     * Creates new form TelaEntradaSaida
     */
    Funcionario func;
    int idFunc;
    
    public TelaEntradaSaida(Funcionario funcionario) {
        initComponents();
        
        func =funcionario ;
        
        //Verificando se o id de funcionário está sendo pegado:
        idFunc = func.getId_funcionario();
        //System.out.println(id);
        
        pesquisarMorador();
        ListagemMorador();
        
       //calendario.setVisible(false);
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

        jSlider1 = new javax.swing.JSlider();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        SolicitEntrada = new javax.swing.JPanel();
        solicitarEntrada = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        campoPesquisar = new javax.swing.JTextField();
        jScrollPane6 = new javax.swing.JScrollPane();
        tabelaMorador = new javax.swing.JTable();
        bSolicitarVisita = new javax.swing.JButton();
        bCadastrarVisitante1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        verificarPedido = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblVisitante = new javax.swing.JTable();
        bPermitirEntrada = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        PanelEntrada = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tabelaMorador2 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        PanelSaida = new javax.swing.JPanel();
        campoNomeVistante = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaVisitante = new javax.swing.JTable();
        bPermitirSaida = new javax.swing.JButton();

        SolicitEntrada.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        solicitarEntrada.setBackground(new java.awt.Color(255, 204, 0));
        solicitarEntrada.setForeground(new java.awt.Color(0, 0, 0));
        solicitarEntrada.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("MORADOR:");
        solicitarEntrada.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

        campoPesquisar.setBackground(new java.awt.Color(255, 255, 255));
        campoPesquisar.setForeground(new java.awt.Color(0, 0, 0));
        solicitarEntrada.add(campoPesquisar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 200, 30));

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
        jScrollPane6.setViewportView(tabelaMorador);

        solicitarEntrada.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 706, 210));

        bSolicitarVisita.setText("SOLICITAR VISITA");
        solicitarEntrada.add(bSolicitarVisita, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 400, 170, 41));

        bCadastrarVisitante1.setText("CADASTRAR VISITANTE");
        bCadastrarVisitante1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCadastrarVisitante1ActionPerformed(evt);
            }
        });
        solicitarEntrada.add(bCadastrarVisitante1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 170, 35));

        jButton2.setText("SELECIONAR VISITANTE");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        solicitarEntrada.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 410, 170, 35));

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Data da visita");
        solicitarEntrada.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 270, 162, -1));

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Visitante já cadastrado ?");
        solicitarEntrada.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 390, 162, -1));

        SolicitEntrada.add(solicitarEntrada, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 717, 460));

        jTabbedPane1.addTab("Solicitação de Entrada", SolicitEntrada);

        verificarPedido.setBackground(new java.awt.Color(255, 204, 0));
        verificarPedido.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblVisitante.setModel(new javax.swing.table.DefaultTableModel(
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
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "MORADOR", "VISITANTE", "FUNCIONÁRIO", "DATA_VISITA", "STATUS"
            }
        ));
        jScrollPane2.setViewportView(tblVisitante);

        verificarPedido.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 29, 681, 286));

        bPermitirEntrada.setForeground(new java.awt.Color(255, 255, 255));
        bPermitirEntrada.setText("PERMITIR ENTRADA");
        verificarPedido.add(bPermitirEntrada, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 350, 156, 35));

        jButton1.setText("SELECIONAR VISITANTE");
        verificarPedido.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 414, -1, 35));

        jTabbedPane1.addTab("Visitas agendadas", verificarPedido);

        PanelEntrada.setBackground(new java.awt.Color(255, 204, 0));
        PanelEntrada.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        jScrollPane5.setViewportView(tabelaMorador2);

        PanelEntrada.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 48, 693, 210));

        jLabel1.setText("jLabel1");
        PanelEntrada.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 15, 163, 21));

        jTabbedPane1.addTab("Entrada", PanelEntrada);

        PanelSaida.setBackground(new java.awt.Color(255, 204, 0));

        campoNomeVistante.setBackground(new java.awt.Color(255, 255, 255));
        campoNomeVistante.setForeground(new java.awt.Color(0, 0, 0));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("NOME VISITANTE:");

        tabelaVisitante.setBackground(new java.awt.Color(255, 255, 255));
        tabelaVisitante.setForeground(new java.awt.Color(0, 0, 0));
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
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "NOME", "CPF", "TELEFONE", "PLACA VEICULO"
            }
        ));
        jScrollPane1.setViewportView(tabelaVisitante);

        bPermitirSaida.setText("PERMITIR SAIDA");

        javax.swing.GroupLayout PanelSaidaLayout = new javax.swing.GroupLayout(PanelSaida);
        PanelSaida.setLayout(PanelSaidaLayout);
        PanelSaidaLayout.setHorizontalGroup(
            PanelSaidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelSaidaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelSaidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 693, Short.MAX_VALUE)
                    .addGroup(PanelSaidaLayout.createSequentialGroup()
                        .addGroup(PanelSaidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(campoNomeVistante, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(PanelSaidaLayout.createSequentialGroup()
                .addGap(290, 290, 290)
                .addComponent(bPermitirSaida, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelSaidaLayout.setVerticalGroup(
            PanelSaidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelSaidaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoNomeVistante, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(bPermitirSaida, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(87, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Saida", PanelSaida);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tabelaMorador2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaMorador2MouseClicked
        // TODO add your handling code here:
        /*int linhaSelecionada = tabelaMorador.getSelectedRow();

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
        } // fim do if*/
    }//GEN-LAST:event_tabelaMorador2MouseClicked

    private void tabelaMoradorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaMoradorMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tabelaMoradorMouseClicked

    private void bCadastrarVisitante1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCadastrarVisitante1ActionPerformed
        // TODO add your handling code here:
        TelaCadastroVisitante cadVisitante = new TelaCadastroVisitante();
        cadVisitante.setVisible(true);
        
    }//GEN-LAST:event_bCadastrarVisitante1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        telaListaDeVisitante visitante = new telaListaDeVisitante();
        visitante.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelEntrada;
    private javax.swing.JPanel PanelSaida;
    private javax.swing.JPanel SolicitEntrada;
    private javax.swing.JButton bCadastrarVisitante1;
    private javax.swing.JButton bPermitirEntrada;
    private javax.swing.JButton bPermitirSaida;
    private javax.swing.JButton bSolicitarVisita;
    private javax.swing.JTextField campoNomeVistante;
    private javax.swing.JTextField campoPesquisar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel solicitarEntrada;
    private javax.swing.JTable tabelaMorador;
    private javax.swing.JTable tabelaMorador2;
    private javax.swing.JTable tabelaVisitante;
    private javax.swing.JTable tblVisitante;
    private javax.swing.JPanel verificarPedido;
    // End of variables declaration//GEN-END:variables
}
