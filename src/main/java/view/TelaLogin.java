/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import javax.swing.ImageIcon;

/**
 *
 * @author Estudo_TI
 */
public class TelaLogin extends javax.swing.JFrame {

    /**
     * Creates new form TelaLogin
     */
    public TelaLogin() {
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

        jPanel1 = new javax.swing.JPanel();
        imagemScar = new javax.swing.JLabel();
        usuario = new javax.swing.JLabel();
        senha = new javax.swing.JLabel();
        campoUsuario = new javax.swing.JTextField();
        butaoOcultar = new javax.swing.JToggleButton();
        butaoEntrar = new javax.swing.JButton();
        campoSenha = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle(" SCAR - LOGIN");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setForeground(new java.awt.Color(51, 51, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        imagemScar.setIcon(new javax.swing.ImageIcon("C:\\Users\\devmat\\Documents\\NetBeansProjects\\SCAR\\SCAR-1\\src\\main\\java\\img\\SCAR_1.png")); // NOI18N
        imagemScar.setText("jLabel1");
        jPanel1.add(imagemScar, new org.netbeans.lib.awtextra.AbsoluteConstraints(-40, 0, 470, 460));

        usuario.setForeground(new java.awt.Color(255, 255, 255));
        usuario.setText("USUARIO");
        jPanel1.add(usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 110, 90, -1));

        senha.setForeground(new java.awt.Color(255, 255, 255));
        senha.setText("SENHA");
        jPanel1.add(senha, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 230, 80, -1));

        campoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoUsuarioActionPerformed(evt);
            }
        });
        jPanel1.add(campoUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 130, 247, 40));

        butaoOcultar.setBackground(new java.awt.Color(153, 153, 153));
        butaoOcultar.setIcon(new javax.swing.ImageIcon("C:\\Users\\devmat\\Documents\\NetBeansProjects\\SCAR\\SCAR-1\\src\\main\\java\\img\\escondido.png")); // NOI18N
        butaoOcultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butaoOcultarActionPerformed(evt);
            }
        });
        jPanel1.add(butaoOcultar, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 250, 50, 38));

        butaoEntrar.setText("ENTRAR");
        jPanel1.add(butaoEntrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 330, 100, 30));

        campoSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoSenhaActionPerformed(evt);
            }
        });
        jPanel1.add(campoSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 250, 247, 38));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 460));
        jPanel1.getAccessibleContext().setAccessibleName("");
        jPanel1.getAccessibleContext().setAccessibleDescription("");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void campoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoUsuarioActionPerformed
  
    //variavel que verifica se a senha esta oculta ou nao
    boolean oculto = true;
    private void butaoOcultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butaoOcultarActionPerformed

        if (oculto) {
        campoSenha.setEchoChar((char) 0); // Exibe a senha
        oculto = false;
        butaoOcultar.setIcon(new ImageIcon("C:/Users/devmat/Documents/NetBeansProjects/SCAR/SCAR-1/src/main/java/img/escondido.png")); // Ajuste o caminho correto
    } else {
        campoSenha.setEchoChar('\u2022'); // Oculta a senha
        oculto = true;
        butaoOcultar.setIcon(new ImageIcon("C:/Users/devmat/Documents/NetBeansProjects/SCAR/SCAR-1/src/main/java/img/visualizar.png")); // Ajuste o caminho correto
    }
                    
    }//GEN-LAST:event_butaoOcultarActionPerformed

    private void campoSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoSenhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoSenhaActionPerformed

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
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton butaoEntrar;
    private javax.swing.JToggleButton butaoOcultar;
    private javax.swing.JPasswordField campoSenha;
    private javax.swing.JTextField campoUsuario;
    private javax.swing.JLabel imagemScar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel senha;
    private javax.swing.JLabel usuario;
    // End of variables declaration//GEN-END:variables
}
