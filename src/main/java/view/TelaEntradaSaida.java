/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package view;

import controller.FuncionarioController;
import controller.MoradorController;
import controller.controllerInoutVisitante;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import model.Funcionario;
import model.Morador;
import model.Visitante;
import model.inoutVisitante;

/**
 *
 * @author devmat
 */
public class TelaEntradaSaida extends javax.swing.JInternalFrame {

    /**
     * Creates new form TelaEntradaSaida
     */
    Funcionario func;
    String idFunc;
    String nomeMor;
    String idVisitCont;
    
    public TelaEntradaSaida(Funcionario funcionario) {
        initComponents();
        
        func =funcionario ;
        
        //Verificando se o id de funcionário está sendo pegado:
        if(func.getNome()!=null){
        idFunc = func.getNome();
        System.out.println(idFunc);
        }
        pesquisarMorador();
        ListagemMorador();
        ListagemVisitas();
        listarSaidaDeVisita();
      Verificacao();

    }
    
    public void Verificacao(){
         if (!campoNome.getText().trim().isEmpty() && !campoCpf.getText().trim().isEmpty()) {
    labelData.setVisible(true);
    calendario.setVisible(true);
} else {
    labelData.setVisible(false);
    calendario.setVisible(false);
}
    }
    
     public void listarSaidaDeVisita(){
    
        
        // chamando o produtos controller
        controllerInoutVisitante controller = new controllerInoutVisitante();
        // capturando a lista de produtos que vem do banco de dados
        List<inoutVisitante> listarVisita= controller.listarSaidaDeVisita();
        
        // Obtendo o modelo da tabela
        DefaultTableModel modeloTabela = 
                (DefaultTableModel) tabelaVisitante.getModel();
    
    // Limpando a tabela antes de adicionar novos dados
       modeloTabela.setRowCount(0);
    
    // Verificando se a lista não é nula
    if (listarVisita != null && !listarVisita.isEmpty()) {
        // Jogando os dados para dentro da minha tabela
        for (inoutVisitante visita : listarVisita) {
            // Criando uma nova linha para a tabela
            Object[] linha = {
             
             visita.getNomeMorador(), // Ajuste para int
             visita.getNomeVisitante(), // Verifique se é null            
             visita.getStatu()// Verifique se é null
            };
            // Adicionando a linha ao modelo da tabela
            modeloTabela.addRow(linha);
           
        }
         
        
    } else {
        JOptionPane.showMessageDialog
        (this, "Nenhuma Visita Entrou.");
    }
    }
    
     public void ListagemVisitas(){
    
        
        // chamando o produtos controller
        controllerInoutVisitante controller = new controllerInoutVisitante();
        // capturando a lista de produtos que vem do banco de dados
        List<inoutVisitante> listarVisita= controller.listarVisitas();
        
        // Obtendo o modelo da tabela
        DefaultTableModel modeloTabela = 
                (DefaultTableModel) tblVisitante.getModel();
    
    // Limpando a tabela antes de adicionar novos dados
       modeloTabela.setRowCount(0);
    
    // Verificando se a lista não é nula
    if (listarVisita != null && !listarVisita.isEmpty()) {
        // Jogando os dados para dentro da minha tabela
        for (inoutVisitante visita : listarVisita) {
            // Criando uma nova linha para a tabela
            Object[] linha = {
             visita.getId_ControleEntradaSaida(), // Ajuste para int
             visita.getNomeMorador(), // Ajuste para int
             visita.getNomeVisitante(), // Verifique se é null
             visita.getNomeFuncionario(), // Verifique se é null
             visita.getDataVisita(), // Verifique se é null
             visita.getStatu()// Verifique se é null
            };
            // Adicionando a linha ao modelo da tabela
            modeloTabela.addRow(linha);
           
        }
         
        
    } else {
        JOptionPane.showMessageDialog
        (this, "Nenhuma Visita agendada.");
    }
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
        labelData = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        calendario = new com.toedter.calendar.JCalendar();
        campoCpf = new javax.swing.JTextField();
        campoNome = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        verificarPedido = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblVisitante = new javax.swing.JTable();
        bPermitirEntrada = new javax.swing.JButton();
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
        bSolicitarVisita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSolicitarVisitaActionPerformed(evt);
            }
        });
        solicitarEntrada.add(bSolicitarVisita, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 410, 170, 40));

        bCadastrarVisitante1.setText("CADASTRAR VISITANTE");
        bCadastrarVisitante1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCadastrarVisitante1ActionPerformed(evt);
            }
        });
        solicitarEntrada.add(bCadastrarVisitante1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 190, 35));

        jButton2.setText("SELECIONAR VISITANTE");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        solicitarEntrada.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 420, 190, 35));

        labelData.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        labelData.setForeground(new java.awt.Color(0, 0, 0));
        labelData.setText("Data da visita");
        solicitarEntrada.add(labelData, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 260, 162, -1));

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("CPF do Visitante:");
        solicitarEntrada.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 340, 162, -1));
        solicitarEntrada.add(calendario, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 280, 170, 120));
        solicitarEntrada.add(campoCpf, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 360, 180, 30));
        solicitarEntrada.add(campoNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 290, 180, 30));

        jLabel6.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Visitante já cadastrado ?");
        solicitarEntrada.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, 162, -1));

        jLabel7.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Nome do Visitante:");
        solicitarEntrada.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 270, 162, -1));

        SolicitEntrada.add(solicitarEntrada, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 717, 460));

        jTabbedPane1.addTab("Solicitação de Entrada", SolicitEntrada);

        verificarPedido.setBackground(new java.awt.Color(255, 204, 0));
        verificarPedido.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblVisitante.setModel(new javax.swing.table.DefaultTableModel(
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
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "CONTROLE", "MORADOR", "VISITANTE", "FUNCIONÁRIO", "DATA_VISITA", "STATUS"
            }
        ));
        tblVisitante.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblVisitanteMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblVisitante);

        verificarPedido.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 29, 681, 286));

        bPermitirEntrada.setText("PERMITIR ENTRADA");
        bPermitirEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bPermitirEntradaActionPerformed(evt);
            }
        });
        verificarPedido.add(bPermitirEntrada, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 350, 156, 35));

        jTabbedPane1.addTab("Visitas agendadas", verificarPedido);

        PanelSaida.setBackground(new java.awt.Color(255, 204, 0));
        PanelSaida.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        campoNomeVistante.setBackground(new java.awt.Color(255, 255, 255));
        campoNomeVistante.setForeground(new java.awt.Color(0, 0, 0));
        PanelSaida.add(campoNomeVistante, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 34, 200, 30));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("NOME VISITANTE:");
        PanelSaida.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, -1, -1));

        tabelaVisitante.setBackground(new java.awt.Color(255, 255, 255));
        tabelaVisitante.setForeground(new java.awt.Color(0, 0, 0));
        tabelaVisitante.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "NOME MORADOR", "NOME VISITANTE", "STATUS"
            }
        ));
        jScrollPane1.setViewportView(tabelaVisitante);

        PanelSaida.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 76, 705, 210));

        bPermitirSaida.setText("PERMITIR SAIDA");
        bPermitirSaida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bPermitirSaidaActionPerformed(evt);
            }
        });
        PanelSaida.add(bPermitirSaida, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 332, 130, 35));

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

    private void tabelaMoradorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaMoradorMouseClicked
        // TODO add your handling code here:
        // TODO add your handling code here:
         int linhaSelecionada = tabelaMorador.getSelectedRow();

        //verificando se alguam linha foi selecionada
        if(linhaSelecionada>=0){
            //definir modelo default para a tabela
            DefaultTableModel modeloTabela =
            (DefaultTableModel) tabelaMorador.getModel();

           nomeMor = modeloTabela.getValueAt(linhaSelecionada, 2).toString();
        }//fim do if
    }//GEN-LAST:event_tabelaMoradorMouseClicked

    private void bCadastrarVisitante1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCadastrarVisitante1ActionPerformed
        // TODO add your handling code here:
        TelaCadastroVisitante cadVisitante = new TelaCadastroVisitante();
        cadVisitante.setVisible(true);
        
    }//GEN-LAST:event_bCadastrarVisitante1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
       telaListadeVisitant tela = new telaListadeVisitant(null, true);
    tela.setVisible(true);
    
    campoNome.setText(tela.nomeVisita);
    campoCpf.setText(tela.cpf);
    
    Verificacao();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void bSolicitarVisitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSolicitarVisitaActionPerformed
        // TODO add your handling code here:
         if(calendario.getDate() == null){
            JOptionPane.showMessageDialog(null, "Escolha a data");
        }else{
        
        try{
       controllerInoutVisitante controller = new controllerInoutVisitante();
         // Suponha que você queira registrar nome do morador, visitante e data
        inoutVisitante iov = new inoutVisitante();
        iov.setNomeMorador(nomeMor);
        iov.setNomeVisitante(campoNome.getText());
        iov.setNomeFuncionario(idFunc);
        // Converter a data para String
            Date data = calendario.getDate();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            String dataFormatada = sdf.format(data);

// Você pode armazenar a data como String (se for o caso do seu banco, por exemplo)
            iov.setDataVisita(dataFormatada); // Supondo que o método aceita String

            
                // chamando o metodo de cadastrar o usuario no banco de dados
            controller.cadastroUsuario(iov);
            JOptionPane.showMessageDialog
            (null,"Visita agendada");

            campoNome.setText("");
             campoCpf.setText("");
            ListagemMorador();
            ListagemVisitas();
            listarSaidaDeVisita();

        }catch(Exception e){
             JOptionPane.showMessageDialog
            (null,"Não foi possível agendar Visita "+e);
        }
        }
    }//GEN-LAST:event_bSolicitarVisitaActionPerformed

    private void tblVisitanteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblVisitanteMouseClicked
        // TODO add your handling code here:
        int linhaSelecionada = tblVisitante.getSelectedRow();

        //verificando se alguam linha foi selecionada
        if(linhaSelecionada>=0){
            //definir modelo default para a tabela
            DefaultTableModel modeloTabela =
            (DefaultTableModel) tblVisitante.getModel();

           idVisitCont = modeloTabela.getValueAt(linhaSelecionada, 0).toString();
        }//fim do if
    }//GEN-LAST:event_tblVisitanteMouseClicked

    private void bPermitirEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bPermitirEntradaActionPerformed
        // TODO add your handling code here:
        if(idVisitCont == null){
            JOptionPane.showMessageDialog(null, "Escolha a Visita");
        }else{
        
        try{
       controllerInoutVisitante controller = new controllerInoutVisitante();
         // Suponha que você queira registrar nome do morador, visitante e data
        inoutVisitante iov = new inoutVisitante();
        iov.setStatu("ENTRADA");
        iov.setNomeFuncionario(idFunc);
        iov.setId_ControleEntradaSaida(idVisitCont);
        
            controller.editarVisita(iov);
            JOptionPane.showMessageDialog
            (null,"Entrada permitida");

            
            ListagemMorador();
            ListagemVisitas();
            listarSaidaDeVisita();

        }catch(Exception e){
             JOptionPane.showMessageDialog
            (null,"Entrada não foi permitida "+e);
        }
        }
    }//GEN-LAST:event_bPermitirEntradaActionPerformed

    private void bPermitirSaidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bPermitirSaidaActionPerformed
        // TODO add your handling code here:
        if(idVisitCont == null){
            JOptionPane.showMessageDialog(null, "Escolha a Visita");
        }else{
        
        try{
       controllerInoutVisitante controller = new controllerInoutVisitante();
         // Suponha que você queira registrar nome do morador, visitante e data
        inoutVisitante iov = new inoutVisitante();
        iov.setStatu("SAIDA");
        iov.setNomeFuncionario(idFunc);
        iov.setId_ControleEntradaSaida(idVisitCont);
        
            controller.editarVisita(iov);
            JOptionPane.showMessageDialog
            (null,"Sáida permitida");

            
            ListagemMorador();
            ListagemVisitas();
            listarSaidaDeVisita();

        }catch(Exception e){
             JOptionPane.showMessageDialog
            (null,"´Não foi possível permitir saída "+e);
        }
        }
    }//GEN-LAST:event_bPermitirSaidaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelSaida;
    private javax.swing.JPanel SolicitEntrada;
    private javax.swing.JButton bCadastrarVisitante1;
    private javax.swing.JButton bPermitirEntrada;
    private javax.swing.JButton bPermitirSaida;
    private javax.swing.JButton bSolicitarVisita;
    private com.toedter.calendar.JCalendar calendario;
    private javax.swing.JTextField campoCpf;
    private javax.swing.JTextField campoNome;
    private javax.swing.JTextField campoNomeVistante;
    private javax.swing.JTextField campoPesquisar;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel labelData;
    private javax.swing.JPanel solicitarEntrada;
    private javax.swing.JTable tabelaMorador;
    private javax.swing.JTable tabelaVisitante;
    private javax.swing.JTable tblVisitante;
    private javax.swing.JPanel verificarPedido;
    // End of variables declaration//GEN-END:variables
}
