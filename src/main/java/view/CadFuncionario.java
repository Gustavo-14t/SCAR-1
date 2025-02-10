/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package view;

/**
 *
 * @author devmat
 */
public class CadFuncionario extends javax.swing.JInternalFrame {

    /**
     * Creates new form NewJInternalFrame
     */
    public CadFuncionario() {
        initComponents();
    }

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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        campoTelefone = new javax.swing.JTextField();
        campoNome = new javax.swing.JTextField();
        campoEndereco = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaFunc = new javax.swing.JTable();
        boxCargo = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        bCadastrar = new javax.swing.JToggleButton();
        butaoOcultar = new javax.swing.JButton();
        campoSenha = new javax.swing.JPasswordField();
        campoCpf = new javax.swing.JFormattedTextField();
        cadFunc = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        campoPesquisa = new javax.swing.JTextField();
        tabelaFuncDel = new javax.swing.JScrollPane();
        tabelaFunc1 = new javax.swing.JTable();
        bdelet = new javax.swing.JToggleButton();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("CARGO");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 20, 60, 20));

        jLabel2.setText("SENHA");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 80, 140, 20));

        jLabel3.setText("CPF");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 140, 20));

        jLabel4.setText("TELEFONE");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 140, 20));

        jLabel5.setText("ENDEREÇO");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 140, 20));
        jPanel2.add(campoTelefone, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 250, 30));

        campoNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoNomeActionPerformed(evt);
            }
        });
        jPanel2.add(campoNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 250, 30));
        jPanel2.add(campoEndereco, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 250, 30));

        tabelaFunc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
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
                "NOME", "CPF", "TELEFONE", "ENDEREÇO", "DEPARTAMENTO", "SENHA"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabelaFunc);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 690, 150));

        boxCargo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "sindico", "porteiro", "guarda", "zelador", "jardineiro", " " }));
        jPanel2.add(boxCargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 20, 150, -1));

        jLabel6.setText("NOME");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 140, 20));

        bCadastrar.setText("CADASTRAR");
        bCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCadastrarActionPerformed(evt);
            }
        });
        jPanel2.add(bCadastrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 160, -1, -1));
        jPanel2.add(butaoOcultar, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 100, 50, 30));

        campoSenha.setText("jPasswordField1");
        jPanel2.add(campoSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 100, 220, 30));

        try {
            campoCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###-###-###.##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanel2.add(campoCpf, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 250, 30));

        jTabbedPane1.addTab("Cadastrar", jPanel2);

        cadFunc.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setText("PESQUISAR");
        cadFunc.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 80, 30));

        campoPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoPesquisaActionPerformed(evt);
            }
        });
        cadFunc.add(campoPesquisa, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, 310, 30));

        tabelaFunc1.setModel(new javax.swing.table.DefaultTableModel(
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
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "NOME", "CPF", "TELEFONE", "ENDEREÇO", "DEPARTAMENTO", "SENHA"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaFuncDel.setViewportView(tabelaFunc1);

        cadFunc.add(tabelaFuncDel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 690, 310));

        bdelet.setText("Deletar");
        bdelet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bdeletActionPerformed(evt);
            }
        });
        cadFunc.add(bdelet, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 400, 100, -1));

        jTabbedPane1.addTab("Deletar", cadFunc);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, -5, 720, 470));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void campoPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoPesquisaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoPesquisaActionPerformed

    private void bCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCadastrarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bCadastrarActionPerformed

    private void campoNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoNomeActionPerformed

    private void bdeletActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bdeletActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bdeletActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton bCadastrar;
    private javax.swing.JToggleButton bdelet;
    private javax.swing.JComboBox<String> boxCargo;
    private javax.swing.JButton butaoOcultar;
    private javax.swing.JPanel cadFunc;
    private javax.swing.JFormattedTextField campoCpf;
    private javax.swing.JTextField campoEndereco;
    private javax.swing.JTextField campoNome;
    private javax.swing.JTextField campoPesquisa;
    private javax.swing.JPasswordField campoSenha;
    private javax.swing.JTextField campoTelefone;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tabelaFunc;
    private javax.swing.JTable tabelaFunc1;
    private javax.swing.JScrollPane tabelaFuncDel;
    // End of variables declaration//GEN-END:variables
}
