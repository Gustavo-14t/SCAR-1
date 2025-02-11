/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package view;

/**
 *
 * @author devmat
 */
public class TelaCadastroUnidade extends javax.swing.JInternalFrame {

    /**
     * Creates new form TelaCadastroUnidade
     */
    public TelaCadastroUnidade() {
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
        campoDimesoes = new javax.swing.JTextField();
        descicao = new javax.swing.JLabel();
        campoDescricao = new javax.swing.JTextField();
        nomeChave = new javax.swing.JLabel();
        campoNomeChave = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaUnidade = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 204, 0));

        nome.setForeground(new java.awt.Color(0, 0, 0));
        nome.setText("Nome:");

        campoNome.setBackground(new java.awt.Color(255, 255, 255));
        campoNome.setForeground(new java.awt.Color(0, 0, 0));

        tipo.setForeground(new java.awt.Color(0, 0, 0));
        tipo.setText("Tipo:");

        campoTipo.setBackground(new java.awt.Color(255, 255, 255));
        campoTipo.setForeground(new java.awt.Color(0, 0, 0));
        campoTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Casa", "Espaço De Evento", "Outos", " " }));

        numero.setForeground(new java.awt.Color(0, 0, 0));
        numero.setText("Numero:");

        campoNumero.setBackground(new java.awt.Color(255, 255, 255));
        campoNumero.setForeground(new java.awt.Color(0, 0, 0));

        bloco.setForeground(new java.awt.Color(0, 0, 0));
        bloco.setText("Bloco:");

        campoBloco.setBackground(new java.awt.Color(255, 255, 255));
        campoBloco.setForeground(new java.awt.Color(0, 0, 0));

        capacidade.setForeground(new java.awt.Color(0, 0, 0));
        capacidade.setText("Capacidade:");

        campoCapacidade.setBackground(new java.awt.Color(255, 255, 255));
        campoCapacidade.setForeground(new java.awt.Color(0, 0, 0));

        dimensoes.setForeground(new java.awt.Color(0, 0, 0));
        dimensoes.setText("Dimensões");

        campoDimesoes.setBackground(new java.awt.Color(255, 255, 255));
        campoDimesoes.setForeground(new java.awt.Color(0, 0, 0));

        descicao.setForeground(new java.awt.Color(0, 0, 0));
        descicao.setText("Descrição:");

        campoDescricao.setBackground(new java.awt.Color(255, 255, 255));
        campoDescricao.setForeground(new java.awt.Color(0, 0, 0));
        campoDescricao.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        nomeChave.setForeground(new java.awt.Color(0, 0, 0));
        nomeChave.setText("Nome Chave:");

        campoNomeChave.setBackground(new java.awt.Color(255, 255, 255));
        campoNomeChave.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 718, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(nome, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(194, 194, 194)
                            .addComponent(capacidade, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(156, 156, 156)
                            .addComponent(nomeChave, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(campoNome, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(44, 44, 44)
                            .addComponent(campoCapacidade, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(20, 20, 20)
                            .addComponent(campoNomeChave, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(tipo, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(202, 202, 202)
                            .addComponent(dimensoes, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(campoTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(44, 44, 44)
                            .addComponent(campoDimesoes, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(numero, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(208, 208, 208)
                            .addComponent(descicao, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(campoNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(bloco, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(campoBloco, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(44, 44, 44)
                            .addComponent(campoDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 439, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(nome)
                        .addComponent(capacidade)
                        .addComponent(nomeChave))
                    .addGap(7, 7, 7)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(campoNome, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(campoCapacidade, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(campoNomeChave, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(17, 17, 17)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(tipo)
                        .addComponent(dimensoes))
                    .addGap(6, 6, 6)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(campoTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(campoDimesoes, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(numero)
                        .addComponent(descicao))
                    .addGap(6, 6, 6)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(campoNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(bloco)
                            .addGap(6, 6, 6)
                            .addComponent(campoBloco, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(campoDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Cadastrar", jPanel1);

        jPanel4.setBackground(new java.awt.Color(255, 204, 0));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        listaUnidade.setBackground(new java.awt.Color(255, 255, 255));
        listaUnidade.setForeground(new java.awt.Color(0, 0, 0));
        listaUnidade.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", null},
                {"", "", null, "", ""},
                {"", "", "", "", null},
                {null, "", "", "", null},
                {"", null, "", null, "a"},
                {null, null, null, null, ""},
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
                "Nome", "Numero", "Bloco", "Tipo", "Capacidade"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        listaUnidade.setSelectionBackground(new java.awt.Color(255, 255, 255));
        listaUnidade.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(listaUnidade);

        jPanel4.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 98, 706, 285));

        jTextField1.setBackground(new java.awt.Color(255, 255, 255));
        jTextField1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel4.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 40, 380, 35));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("PESQUISAR:");
        jPanel4.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 14, 87, -1));

        jButton1.setBackground(new java.awt.Color(255, 204, 0));
        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setText("DELETAR");
        jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(328, 395, 85, 38));

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

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bloco;
    private javax.swing.JTextField campoBloco;
    private javax.swing.JTextField campoCapacidade;
    private javax.swing.JTextField campoDescricao;
    private javax.swing.JTextField campoDimesoes;
    private javax.swing.JTextField campoNome;
    private javax.swing.JTextField campoNomeChave;
    private javax.swing.JTextField campoNumero;
    private javax.swing.JComboBox<String> campoTipo;
    private javax.swing.JLabel capacidade;
    private javax.swing.JLabel descicao;
    private javax.swing.JLabel dimensoes;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable listaUnidade;
    private javax.swing.JLabel nome;
    private javax.swing.JLabel nomeChave;
    private javax.swing.JLabel numero;
    private javax.swing.JLabel tipo;
    // End of variables declaration//GEN-END:variables
}
