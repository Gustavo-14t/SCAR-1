/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package view;

import com.itextpdf.text.Document;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import controller.ContServiceController;
import controller.MoradorController;
import controller.ServicoController;
import java.awt.Desktop;
import java.io.File;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Morador;
import model.RelatorioServico;
import model.Servico;

/**
 *
 * @author devmat
 */
public class TelaServiceRequest extends javax.swing.JInternalFrame {
    
    String morador;
    int idServicos;

    /**
     * Creates new form TelaServiceRequest
     */
    public TelaServiceRequest() {
        initComponents();
        
        outServicText.setVisible(false);
        outroServico.setVisible(false);
        
        ListagemUsuario();
        ListagemServicoPende();
        ListagemServicoAprovado();
        ListagemRelatorio();
    }
    
    public void ListagemRelatorio(){
        //cria um objeto de vendasController
        ContServiceController controller = new  ContServiceController();
        //capturando a lista de relatório de vendas
        List<RelatorioServico> lista = controller.listarServico();
        
        //modelo padrão de tabela
       DefaultTableModel modeloTabela = (DefaultTableModel)tabelaControleServico.getModel();
        
       //Limpando a tabela antes de adicionar nobvos dados
       modeloTabela.setRowCount(0);
       
       //verificar se a lista esta vazia
       if(lista !=null && !lista.isEmpty()){
           for (RelatorioServico servico : lista){
               Object[] linha = {
                   servico.getMorador(),
                   servico.getNomeServico(),
                   servico.getDiaDaSolciticao(),
                   servico.getDataConclusao(),
                   servico.getStatu(),
   
               };//fim do objeto linha
               modeloTabela.addRow(linha);
               
           }//fim do for
       }else{
           JOptionPane.showMessageDialog(null,"Não existem Servicos!");
       }//fim do else
    
    }
    
    public void LimparCampos(){
        outroServico.setText("");
         descricao.setText("");
         campoPrazo.setText("");
         boxServicos.setSelectedIndex(-1);
    }
    
    public void ListagemServicoAprovado(){
        //cria um objeto de vendasController
        ServicoController controller = new  ServicoController();
        //capturando a lista de relatório de vendas
        List<Servico> lista = controller.listaServicoAprovados();
        
        //modelo padrão de tabela
       DefaultTableModel modeloTabela = (DefaultTableModel)tabelaServicos2.getModel();
        
       //Limpando a tabela antes de adicionar nobvos dados
       modeloTabela.setRowCount(0);
       
       //verificar se a lista esta vazia
       if(lista !=null && !lista.isEmpty()){
           for (Servico servico : lista){
               Object[] linha = {
                   servico.getId_servico(),
                   servico.getNomeMorador(),
                   servico.getNome(),
                   servico.getDescricao(),
                   servico.getPrazo(),
                   servico.getStatu()
                   
                       
               };//fim do objeto linha
               modeloTabela.addRow(linha);
               
           }//fim do for
       }else{
           JOptionPane.showMessageDialog(null,"Não existem pedidos de serviço pendentes!");
       }//fim do else
        
    }//fim do método de ListagemVendas()
    
     public void ListagemServicoPende(){
        //cria um objeto de vendasController
        ServicoController controller = new  ServicoController();
        //capturando a lista de relatório de vendas
        List<Servico> lista = controller.listaServicoPend();
        
        //modelo padrão de tabela
       DefaultTableModel modeloTabela = (DefaultTableModel)tabelaServicos.getModel();
        
       //Limpando a tabela antes de adicionar nobvos dados
       modeloTabela.setRowCount(0);
       
       //verificar se a lista esta vazia
       if(lista !=null && !lista.isEmpty()){
           for (Servico servico : lista){
               Object[] linha = {
                   servico.getId_servico(),
                   servico.getNomeMorador(),
                   servico.getNome(),
                   servico.getDescricao(),
                   servico.getPrazo(),
                   servico.getStatu()
                   
                       
               };//fim do objeto linha
               modeloTabela.addRow(linha);
               
           }//fim do for
       }else{
           JOptionPane.showMessageDialog(null,"Não existem pedidos de serviço pendentes!");
       }//fim do else
        
    }//fim do método de ListagemVendas()
    
    public void campoCargoActionPerformed() {
        // Obtém o cargo selecionado no JComboBox
        String cargoSelecionado = (String)  boxServicos.getSelectedItem();
         if(cargoSelecionado != null && (cargoSelecionado.equals("Outros"))){
            
            outServicText.setVisible(true);
        outroServico.setVisible(true);
            
        }else{
             outServicText.setVisible(false);
        outroServico.setVisible(false);
         }//fim do else
    }
    
    public void ListagemUsuario(){
    
        
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

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaMorador = new javax.swing.JTable();
        bSolicitarServico = new javax.swing.JToggleButton();
        boxServicos = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        outServicText = new javax.swing.JLabel();
        descricao = new javax.swing.JTextField();
        outroServico = new javax.swing.JTextField();
        campoPrazo = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaServicos = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabelaServicos2 = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tabelaControleServico = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 204, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "CASA", "NOME", "CPF", "EMAIL", "DAT_NASC"
            }
        ));
        tabelaMorador.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaMoradorMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaMorador);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 23, 693, 171));

        bSolicitarServico.setText("Solicitar Serviço");
        bSolicitarServico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSolicitarServicoActionPerformed(evt);
            }
        });
        jPanel1.add(bSolicitarServico, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 360, 130, -1));

        boxServicos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Jardinagem", "Manutenção geral", "Limpeza", "Segurança", "Outros" }));
        boxServicos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxServicosActionPerformed(evt);
            }
        });
        jPanel1.add(boxServicos, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 220, 30));

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Prazo");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, -1, -1));

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Serviços");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, -1, -1));

        outServicText.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        outServicText.setForeground(new java.awt.Color(0, 0, 0));
        outServicText.setText("Outro serviço");
        jPanel1.add(outServicText, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 210, -1, 20));
        jPanel1.add(descricao, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 220, 30));
        jPanel1.add(outroServico, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 230, 220, 30));

        try {
            campoPrazo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        campoPrazo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoPrazoActionPerformed(evt);
            }
        });
        jPanel1.add(campoPrazo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, 220, 30));

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Descrição");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, -1, -1));

        jTabbedPane1.addTab("Solicitação de Serviço", jPanel1);

        jPanel3.setBackground(new java.awt.Color(255, 204, 51));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabelaServicos.setModel(new javax.swing.table.DefaultTableModel(
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
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "MORADOR", "SERVIÇO", "DESCRICÃO", "PRAZO", "STATUS"
            }
        ));
        tabelaServicos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaServicosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabelaServicos);

        jPanel3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 40, 680, 220));

        jButton1.setText("Aprovar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(596, 300, 100, -1));

        jButton2.setText("Negar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 300, 100, -1));

        jTabbedPane1.addTab("Verificação de Serviço Solicitado", jPanel3);

        jPanel2.setBackground(new java.awt.Color(255, 204, 51));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabelaServicos2.setModel(new javax.swing.table.DefaultTableModel(
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
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID_SERVIÇO", "MORADOR", "SERVIÇO", "SERVICO", "PRAZO", "STATUS"
            }
        ));
        tabelaServicos2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaServicos2MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tabelaServicos2);

        jPanel2.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 40, 680, 220));

        jButton3.setText("Concluída");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(546, 310, 150, -1));

        jTabbedPane1.addTab("Serviços Aprovados", jPanel2);

        jPanel4.setBackground(new java.awt.Color(255, 204, 51));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabelaControleServico.setModel(new javax.swing.table.DefaultTableModel(
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
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "MORADOR", "SERVIÇO", "DATA_SOLICITAÇÃO", "DATA_CONCLUSÃO", "STATUS"
            }
        ));
        jScrollPane4.setViewportView(tabelaControleServico);

        jPanel4.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 690, 340));

        jButton4.setText("BAIXAR RELATÓRIO");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 390, 170, 30));

        jTabbedPane1.addTab("Relatórios", jPanel4);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, 470));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bSolicitarServicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSolicitarServicoActionPerformed
        // TODO add your handling code here:
       // TODO add your handling code here:
       String selectService = (String) boxServicos.getSelectedItem();
       
       if (selectService.equals("Outros") && outroServico.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Escreva um outro serviço");
       } 
        if(descricao.getText().isEmpty() || campoPrazo.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Preencha todos os campos");
        }if (morador == null || morador.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Selecione um morador na tabela!");
        }
        else{
        
        try{
       ServicoController controller = new ServicoController();
         // criando um objeto do tipo usuario da pasta model
         Servico servico = new Servico();
          if(selectService.equals("Outros")){
              
                servico.setNome(outroServico.getText());
              
            }else{
                
                servico.setNome(boxServicos.getSelectedItem().toString());
                
            }
          
                servico.setNomeMorador(this.morador);
                servico.setDescricao(descricao.getText());
                servico.setPrazo(campoPrazo.getText());  

                // chamando o metodo de cadastrar o usuario no banco de dados
            controller.SolicitarServico(servico);
            JOptionPane.showMessageDialog
            (null,"Serviço solicitado com Sucesso!");
                
            LimparCampos();
            ListagemUsuario();  
            ListagemServicoPende();
            ListagemServicoAprovado();
            ListagemRelatorio();

        }catch(Exception e){
             JOptionPane.showMessageDialog
            (null,"Não foi possível solicitar Serviço! "+e);
        }
      }
    }//GEN-LAST:event_bSolicitarServicoActionPerformed

    private void boxServicosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxServicosActionPerformed
        // TODO add your handling code here:
       campoCargoActionPerformed();
    }//GEN-LAST:event_boxServicosActionPerformed

    private void campoPrazoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoPrazoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoPrazoActionPerformed

    private void tabelaMoradorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaMoradorMouseClicked
        // TODO add your handling code here:
        int linhaSelecionada = tabelaMorador.getSelectedRow();

        //verificando se alguam linha foi selecionada
        if(linhaSelecionada>=0){
            //definir modelo default para a tabela
            DefaultTableModel modeloTabela =
            (DefaultTableModel) tabelaMorador.getModel();

            //jogando os dados da tabela para os campos de texto
            morador = modeloTabela.getValueAt(linhaSelecionada, 0).toString();

        }//fim do if   
    }//GEN-LAST:event_tabelaMoradorMouseClicked

    private void tabelaServicos2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaServicos2MouseClicked
        // TODO add your handling code here:
        // TODO add your handling code here:
        int linhaSelecionada = tabelaServicos2.getSelectedRow();

    // Verificando se alguma linha foi selecionada
    if (linhaSelecionada >= 0) {
        // Definir modelo default para a tabela
        DefaultTableModel modeloTabela = (DefaultTableModel) tabelaServicos2.getModel();

        // Verificando se os valores não são nulos antes de usar toString()
        idServicos = modeloTabela.getValueAt(linhaSelecionada, 0) != null 
                    ? Integer.parseInt(modeloTabela.getValueAt(linhaSelecionada, 0).toString()) 
                    : 0;  // Valor padrão para idMorador (caso seja nulo)       
        
    } // fim do if
    }//GEN-LAST:event_tabelaServicos2MouseClicked

    private void tabelaServicosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaServicosMouseClicked
        // TODO add your handling code here:
        // TODO add your handling code here:
        // TODO add your handling code here:
        int linhaSelecionada = tabelaServicos.getSelectedRow();

    // Verificando se alguma linha foi selecionada
    if (linhaSelecionada >= 0) {
        // Definir modelo default para a tabela
        DefaultTableModel modeloTabela = (DefaultTableModel) tabelaServicos.getModel();

        // Verificando se os valores não são nulos antes de usar toString()
        idServicos = modeloTabela.getValueAt(linhaSelecionada, 0) != null 
                    ? Integer.parseInt(modeloTabela.getValueAt(linhaSelecionada, 0).toString()) 
                    : 0;  // Valor padrão para idMorador (caso seja nulo)       
        
    } // fim do if
    }//GEN-LAST:event_tabelaServicosMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
      ServicoController controller = new ServicoController();
        
        Servico svc = new Servico ();
        //passando os valores para o objeto vendas
         svc.setStatu("Aprovado");
        svc.setId_servico(this.idServicos);     
   
        // passando os dados da venda para o banco de dados
        boolean cadastrou = controller.editarServico(svc);
        if(cadastrou){
            JOptionPane.showMessageDialog(
                    null,"Servico aprovado com sucesso");
            
        }else{
           JOptionPane.showMessageDialog(
                    null,"Não foi possivel aprovar Servico!"); 
        }// fim do else 
        ListagemServicoPende();
        ListagemServicoAprovado();
        ListagemRelatorio();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:
        
        ServicoController controller = new ServicoController();

        try{
            controller.negarServico ( this.idServicos);
            JOptionPane.showMessageDialog(null,"Servico negado com sucesso");
           
        }catch(Exception erro){
            JOptionPane.showMessageDialog(null,"Erro ao negar Reserva" + erro);
        }     
        ListagemUsuario();
        ListagemServicoPende();
        ListagemServicoAprovado();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
            // TODO add your handling code here:
      ServicoController controller = new ServicoController();
        
        Servico svc = new Servico ();
        //passando os valores para o objeto vendas
         svc.setStatu("Concluído");
        svc.setId_servico(this.idServicos);     
   
        // passando os dados da venda para o banco de dados
        boolean cadastrou = controller.editarServico(svc);
        if(cadastrou){
            JOptionPane.showMessageDialog(
                    null,"Servico concluído com sucesso");
            
        }else{
           JOptionPane.showMessageDialog(
                    null,"Não foi possível marcar serviço como concluído!"); 
        }// fim do else 
        ListagemServicoPende();
        ListagemServicoAprovado();
        ListagemRelatorio();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
         // TODO add your handling code here:
        String pdfPath = "RelatorioDeReservas.pdf";
        
        try{
            
            //criando documento pdf
            Document documento = new Document();
            PdfWriter.getInstance(documento, new java.io.FileOutputStream(pdfPath));
            
            //abrir pdf
            documento.open();
            
            //Criando tabela no pdf
            //getColumn captura a quantidade do colunas da tabelaVendas
            int  colunas = tabelaControleServico.getColumnCount() ;
            //definindo a nossa tabela dentro do pdf
            PdfPTable tabela = new PdfPTable(colunas);
            //definindo a escala da tabela 100%, 80%, 50% 
            tabela.setWidthPercentage(100);
            
            //adicionando o nome das colunas na tabela do pdf
            for(int i=0 ; i< colunas; i++){
                tabela.addCell(new Phrase(tabelaControleServico.getColumnName(i)));
            }//fim do laço de repetição FOR
            
            //adicionando os dados na tabela pdf 
            DefaultTableModel modeloTabela = (DefaultTableModel) tabelaControleServico.getModel();
            //usnado laço de repetição para inserir os dados 
            for(int l = 0; l < modeloTabela.getRowCount(); l ++){
                for (int c = 0; c < modeloTabela.getColumnCount(); c++ ){
                    //Adicionando os dados e jogando em um objeto 
                    Object valorcelula = modeloTabela.getValueAt(l,c);
                tabela.addCell(valorcelula != null ? valorcelula.toString():"");
                
            }//fim do 2° for     
            }//fim do 1° for
            
            //adicionando a tabela dentro do pdf
            documento.add(tabela);
            
            // fechando o documento 
            documento.close();
            
            //mensagem de sucesso
            JOptionPane.showMessageDialog(this,"PDF GERADO COM SUCESSO");
            
            //abrir o pdf automaticamente
            File pdffile = new File(pdfPath);
            //se pdf existir 
            if(pdffile.exists()){
                
            if(Desktop.isDesktopSupported()){
                //achou o aplicativo que abre o pdf então
                //abre o arquivo dentro do aplicativo
                Desktop.getDesktop().open(pdffile);
            }
            else{
                JOptionPane.showMessageDialog(this,"Nenhum aplicativo suporta o PDF!");
            }//fim do else
            }//fim do if
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Não foi possível gerar PDF!" +e);
        }//fim do trycatch
    }//GEN-LAST:event_jButton4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton bSolicitarServico;
    private javax.swing.JComboBox<String> boxServicos;
    private javax.swing.JFormattedTextField campoPrazo;
    private javax.swing.JTextField descricao;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel outServicText;
    private javax.swing.JTextField outroServico;
    private javax.swing.JTable tabelaControleServico;
    private javax.swing.JTable tabelaMorador;
    private javax.swing.JTable tabelaServicos;
    private javax.swing.JTable tabelaServicos2;
    // End of variables declaration//GEN-END:variables
}
