/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;


import javax.swing.JOptionPane;
import model.Funcionario;

/**
 *
 * @author devmat
 */
public class TelaHome extends javax.swing.JFrame {

    /**
     * Creates new form TelaHome
     */
    Funcionario func;
    
    public TelaHome(String departamento,Funcionario funcionario) {
        initComponents();
        barraMenu.setVisible(true);
        optionCadastro.setVisible(false);
         optionRelatorio.setVisible(false);
         optionReserva.setVisible(false);
        func = funcionario;
        
         TelaAtividade atv = new TelaAtividade();
        areaTrabalho.add(atv);
       atv.setVisible(true);
        
          // Verifica o departamento do funcionário e ajusta a interface
        if (departamento.equals("Síndico")){
            // Adiciona funcionalidades exclusivas para o Síndico
            bCadastro.setEnabled(true); // Exemplo, permitir cadastro
            bRelatorio.setEnabled(true); // Exemplo, permitir relatórios
            bFinanceiro.setEnabled(true); // Exemplo, permitir acesso financeiro
            bReserva.setEnabled(true); // Exemplo, permitir reservas
            // Adicione mais botões se necessário
     
        } else if (departamento.equals("Porteiro")) {
            // Adiciona funcionalidades exclusivas para o Porteiro
            bCadastro.setVisible(false); // Exemplo, permitir cadastro
            bRelatorio.setEnabled(true); // Exemplo, permitir relatórios
            bFinanceiro.setEnabled(true); // Exemplo, permitir acesso financeiro
            bReserva.setEnabled(true); // Exemplo, permitir reservasermitir reservas
            // Adicione mais configurações para o porteiro
 
    }//fim do else
    }  
        
    public void fecharTelas(){
        if(optionCadastro.isVisible()|| optionRelatorio.isVisible() || optionReserva.isVisible() ){
            optionCadastro.setVisible(false);
            optionRelatorio.setVisible(false);
            optionReserva.setVisible(false);
            
           
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
        optionRelatorio = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        butaoHome = new javax.swing.JButton();
        barraMenu = new javax.swing.JPanel();
        bEntSaida = new javax.swing.JButton();
        bCadastro = new javax.swing.JButton();
        bRelatorio = new javax.swing.JButton();
        bReserva = new javax.swing.JButton();
        bFinanceiro = new javax.swing.JButton();
        bSolicServis = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        bSAC = new javax.swing.JButton();
        optionCadastro = new javax.swing.JPanel();
        bCadUni = new javax.swing.JButton();
        bCadFun = new javax.swing.JButton();
        bCadMor = new javax.swing.JButton();
        optionReserva = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        areaTrabalho = new javax.swing.JDesktopPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        optionRelatorio.setBackground(new java.awt.Color(255, 255, 255));
        optionRelatorio.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton3.setText("RELATÓRIO DE RESERVA");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        optionRelatorio.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 20));

        jButton4.setText("RELATÓRIO FINANCEIRO");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        optionRelatorio.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 200, 20));

        jButton2.setText("RELATÓRIO ENTRADA/SAÍDA");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        optionRelatorio.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 200, 20));

        jPanel1.add(optionRelatorio, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 120, 200, 60));

        jPanel2.setBackground(new java.awt.Color(255, 153, 0));

        butaoHome.setBackground(new java.awt.Color(255, 153, 0));
        butaoHome.setIcon(new javax.swing.ImageIcon("C:\\Users\\devmat\\Documents\\SCAR-main\\src\\main\\java\\img\\casa.png")); // NOI18N
        butaoHome.setBorder(null);
        butaoHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butaoHomeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(butaoHome, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(833, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 15, Short.MAX_VALUE)
                .addComponent(butaoHome, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 930, 60));

        barraMenu.setBackground(new java.awt.Color(255, 204, 0));
        barraMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bEntSaida.setIcon(new javax.swing.ImageIcon("C:\\Users\\devmat\\Documents\\SCAR-main\\src\\main\\java\\img\\saida.png")); // NOI18N
        bEntSaida.setText("ENTRADAS E SAÍDAS");
        bEntSaida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEntSaidaActionPerformed(evt);
            }
        });
        barraMenu.add(bEntSaida, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, 200, 60));

        bCadastro.setIcon(new javax.swing.ImageIcon("C:\\Users\\devmat\\Documents\\SCAR-main\\src\\main\\java\\img\\usuarios-alt.png")); // NOI18N
        bCadastro.setText("CADASTRO");
        bCadastro.setIconTextGap(20);
        bCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCadastroActionPerformed(evt);
            }
        });
        barraMenu.add(bCadastro, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 200, 60));

        bRelatorio.setIcon(new javax.swing.ImageIcon("C:\\Users\\devmat\\Documents\\SCAR-main\\src\\main\\java\\img\\editar.png")); // NOI18N
        bRelatorio.setText("RELATÓRIO");
        bRelatorio.setIconTextGap(20);
        bRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bRelatorioActionPerformed(evt);
            }
        });
        barraMenu.add(bRelatorio, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 200, 60));

        bReserva.setIcon(new javax.swing.ImageIcon("C:\\Users\\devmat\\Documents\\SCAR-main\\src\\main\\java\\img\\calendario.png")); // NOI18N
        bReserva.setText("RESERVA");
        bReserva.setIconTextGap(20);
        bReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bReservaActionPerformed(evt);
            }
        });
        barraMenu.add(bReserva, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 200, 60));

        bFinanceiro.setIcon(new javax.swing.ImageIcon("C:\\Users\\devmat\\Documents\\SCAR-main\\src\\main\\java\\img\\dolar.png")); // NOI18N
        bFinanceiro.setText("FINANCEIRO");
        bFinanceiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bFinanceiroActionPerformed(evt);
            }
        });
        barraMenu.add(bFinanceiro, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 200, 60));

        bSolicServis.setIcon(new javax.swing.ImageIcon("C:\\Users\\devmat\\Documents\\SCAR-main\\src\\main\\java\\img\\servico-de-atendimento-ao-consumidor.png")); // NOI18N
        bSolicServis.setText("SOLICITAR SERVIÇOS");
        bSolicServis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSolicServisActionPerformed(evt);
            }
        });
        barraMenu.add(bSolicServis, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 200, 60));

        jButton6.setBackground(new java.awt.Color(255, 204, 0));
        jButton6.setIcon(new javax.swing.ImageIcon("C:\\Users\\devmat\\Documents\\SCAR-main\\src\\main\\java\\img\\config.png")); // NOI18N
        jButton6.setBorder(null);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        barraMenu.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 380, 50, 50));

        jButton7.setBackground(new java.awt.Color(255, 204, 0));
        jButton7.setIcon(new javax.swing.ImageIcon("C:\\Users\\devmat\\Documents\\SCAR-main\\src\\main\\java\\img\\saida.png")); // NOI18N
        jButton7.setBorder(null);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        barraMenu.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 450, 60, 50));

        bSAC.setBackground(new java.awt.Color(255, 204, 0));
        bSAC.setIcon(new javax.swing.ImageIcon("C:\\Users\\devmat\\Documents\\SCAR-main\\src\\main\\java\\img\\interrogatorio.png")); // NOI18N
        bSAC.setBorder(null);
        bSAC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSACActionPerformed(evt);
            }
        });
        barraMenu.add(bSAC, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, 50, 50));

        jPanel1.add(barraMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 54, 200, 510));

        optionCadastro.setBackground(new java.awt.Color(255, 255, 255));
        optionCadastro.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bCadUni.setText("CADASTRAR UNIDADE");
        bCadUni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCadUniActionPerformed(evt);
            }
        });
        optionCadastro.add(bCadUni, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 200, 20));

        bCadFun.setText("CADASTRAR FUNCIONARIO");
        bCadFun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCadFunActionPerformed(evt);
            }
        });
        optionCadastro.add(bCadFun, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 20));

        bCadMor.setText("CADASTRAR MORADOR");
        bCadMor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCadMorActionPerformed(evt);
            }
        });
        optionCadastro.add(bCadMor, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 200, 20));

        jPanel1.add(optionCadastro, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 60, 200, -1));

        optionReserva.setBackground(new java.awt.Color(255, 255, 255));
        optionReserva.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setText("FAZER RESERVA");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        optionReserva.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, -1));

        jButton5.setText("RESERVAS FEITAS");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        optionReserva.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 200, -1));

        jPanel1.add(optionReserva, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 180, 200, 60));

        javax.swing.GroupLayout areaTrabalhoLayout = new javax.swing.GroupLayout(areaTrabalho);
        areaTrabalho.setLayout(areaTrabalhoLayout);
        areaTrabalhoLayout.setHorizontalGroup(
            areaTrabalhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 730, Short.MAX_VALUE)
        );
        areaTrabalhoLayout.setVerticalGroup(
            areaTrabalhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 510, Short.MAX_VALUE)
        );

        jPanel1.add(areaTrabalho, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 60, 730, 510));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 930, 560));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bEntSaidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEntSaidaActionPerformed
        // TODO add your handling code here:
        TelaEmDev telaDev = new TelaEmDev();
        areaTrabalho.add(telaDev);
       telaDev.setVisible(true);
       
       fecharTelas();
    }//GEN-LAST:event_bEntSaidaActionPerformed

    private void bCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCadastroActionPerformed
        // TODO add your handling code here:
        if(optionRelatorio.isVisible()|| optionReserva.isVisible() ){
            optionRelatorio.setVisible(false);
            optionReserva.setVisible(false);
        }
        
        optionCadastro.setVisible(!optionCadastro.isVisible());
    }//GEN-LAST:event_bCadastroActionPerformed

    private void bRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bRelatorioActionPerformed
        // TODO add your handling code here:
        if(optionCadastro.isVisible()|| optionReserva.isVisible() ){
            optionCadastro.setVisible(false);
            optionReserva.setVisible(false);
        }
        
        optionRelatorio.setVisible(!optionRelatorio.isVisible());
        
    }//GEN-LAST:event_bRelatorioActionPerformed

    private void bReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bReservaActionPerformed
        // TODO add your handling code here:
        if(optionCadastro.isVisible()|| optionRelatorio.isVisible() ){
            optionCadastro.setVisible(false);
            optionRelatorio.setVisible(false);
        }
        
        optionReserva.setVisible(!optionReserva.isVisible());
    }//GEN-LAST:event_bReservaActionPerformed

    private void bFinanceiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bFinanceiroActionPerformed
        // TODO add your handling code here:
        TelaEmDev telaDev = new TelaEmDev();
        areaTrabalho.add(telaDev);
       telaDev.setVisible(true);
       
      fecharTelas();
        
    
    }//GEN-LAST:event_bFinanceiroActionPerformed

    private void bSolicServisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSolicServisActionPerformed
        // TODO add your handling code here:
       TelaEmDev telaDev = new TelaEmDev();
        areaTrabalho.add(telaDev);
       telaDev.setVisible(true);
       
       fecharTelas();
    }//GEN-LAST:event_bSolicServisActionPerformed

    private void bCadMorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCadMorActionPerformed
        // TODO add your handling code here:
         CadMorador morador = new CadMorador();
        areaTrabalho.add(morador);
       morador.setVisible(true);
       
       if(optionCadastro.isVisible()|| optionRelatorio.isVisible() || optionReserva.isVisible() ){
            optionCadastro.setVisible(false);
            optionRelatorio.setVisible(false);
            optionReserva.setVisible(false);
        }
    }//GEN-LAST:event_bCadMorActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        TelaEmDev telaDev = new TelaEmDev();
        areaTrabalho.add(telaDev);
       telaDev.setVisible(true);
       
      fecharTelas();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
       telaRelatorioReserva relareserv = new telaRelatorioReserva();
        areaTrabalho.add(relareserv);
       relareserv.setVisible(true);
       
       fecharTelas();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        TelaEmDev telaDev = new TelaEmDev();
        areaTrabalho.add(telaDev);
       telaDev.setVisible(true);
       
      fecharTelas();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        TelaReservas reserva = new TelaReservas(func);
        areaTrabalho.add(reserva);
       reserva.setVisible(true);
       
       fecharTelas();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void bCadFunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCadFunActionPerformed
        // TODO add your handling code here:
         CadFuncionario func = new CadFuncionario();
        areaTrabalho.add(func);
       func.setVisible(true);
       
       fecharTelas();
    }//GEN-LAST:event_bCadFunActionPerformed

    private void bCadUniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCadUniActionPerformed
        // TODO add your handling code here:
        TelaCadastroUnidade unidade = new TelaCadastroUnidade();
        areaTrabalho.add(unidade);
       unidade.setVisible(true);
       
       fecharTelas();
    }//GEN-LAST:event_bCadUniActionPerformed

    private void butaoHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butaoHomeActionPerformed
        // TODO add your handling code here:
        TelaAtividade tela = new TelaAtividade();
         areaTrabalho.add(tela);
       tela.setVisible(true);
       
      fecharTelas();
    }//GEN-LAST:event_butaoHomeActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        telaReservaFeita reserF = new telaReservaFeita(func);
         areaTrabalho.add(reserF);
       reserF.setVisible(true);
       
       
      fecharTelas();                             
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        int resposta = JOptionPane.showConfirmDialog(null, 
      "Deseja sair do sistema ?", 
       "Confirmação", 
       JOptionPane.YES_NO_OPTION);

        // Verifica a resposta do usuário
        if (resposta == JOptionPane.YES_OPTION) {

        TelaLogin login = new TelaLogin ();
        login.setVisible(true);
        
        dispose();
        }
        
    }//GEN-LAST:event_jButton7ActionPerformed

    private void bSACActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSACActionPerformed
        // TODO add your handling code here
        
        TelaSac sac = new TelaSac();
        sac.setVisible(true);
                
    }//GEN-LAST:event_bSACActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

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
            java.util.logging.Logger.getLogger(TelaHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Funcionario use = null;
                String departamento = null;
                new TelaHome(departamento,use).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane areaTrabalho;
    private javax.swing.JButton bCadFun;
    private javax.swing.JButton bCadMor;
    private javax.swing.JButton bCadUni;
    private javax.swing.JButton bCadastro;
    private javax.swing.JButton bEntSaida;
    private javax.swing.JButton bFinanceiro;
    private javax.swing.JButton bRelatorio;
    private javax.swing.JButton bReserva;
    private javax.swing.JButton bSAC;
    private javax.swing.JButton bSolicServis;
    private javax.swing.JPanel barraMenu;
    private javax.swing.JButton butaoHome;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel optionCadastro;
    private javax.swing.JPanel optionRelatorio;
    private javax.swing.JPanel optionReserva;
    // End of variables declaration//GEN-END:variables
}
