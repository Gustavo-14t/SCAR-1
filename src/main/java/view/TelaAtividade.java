/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package view;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Insets;


/**
 *
 * @author devmat
 */
public class TelaAtividade extends javax.swing.JInternalFrame {

    /**
     * Creates new form JInternalFrame
     */
    public TelaAtividade() {
        initComponents();
        
    painelAtividades.setLayout(new javax.swing.BoxLayout(painelAtividades, javax.swing.BoxLayout.Y_AXIS));

// Envolva com JScrollPane
javax.swing.JScrollPane scrollPane = new javax.swing.JScrollPane(painelAtividades);
scrollPane.setVerticalScrollBarPolicy(javax.swing.JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
scrollPane.setHorizontalScrollBarPolicy(javax.swing.JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

getContentPane().add(scrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, 410));

        
        bExcluir.setVisible(false);
        bConcluida.setVisible(false);
        listarAtividadesNaTela();
    }
    
    private model.Atividade atividadeSelecionada;

    
    public class WrapLayout extends FlowLayout {
    public WrapLayout() {
        super();
    }

    public WrapLayout(int align) {
        super(align);
    }

    public WrapLayout(int align, int hgap, int vgap) {
        super(align, hgap, vgap);
    }

    @Override
    public Dimension preferredLayoutSize(Container target) {
        return layoutSize(target, true);
    }

    @Override
    public Dimension minimumLayoutSize(Container target) {
        Dimension minimum = layoutSize(target, false);
        minimum.width -= (getHgap() + 1);
        return minimum;
    }

    private Dimension layoutSize(Container target, boolean preferred) {
        synchronized (target.getTreeLock()) {
            int targetWidth = target.getWidth();

            if (targetWidth == 0) {
                targetWidth = Integer.MAX_VALUE;
            }

            int hgap = getHgap();
            int vgap = getVgap();
            Insets insets = target.getInsets();
            int maxWidth = targetWidth - (insets.left + insets.right + hgap * 2);

            Dimension dim = new Dimension(0, 0);
            int rowWidth = 0;
            int rowHeight = 0;

            int nmembers = target.getComponentCount();

            for (int i = 0; i < nmembers; i++) {
                Component m = target.getComponent(i);

                if (m.isVisible()) {
                    Dimension d = preferred ? m.getPreferredSize() : m.getMinimumSize();

                    if (rowWidth + d.width > maxWidth) {
                        addRow(dim, rowWidth, rowHeight);
                        rowWidth = 0;
                        rowHeight = 0;
                    }

                    if (rowWidth != 0) {
                        rowWidth += hgap;
                    }

                    rowWidth += d.width;
                    rowHeight = Math.max(rowHeight, d.height);
                }
            }

            addRow(dim, rowWidth, rowHeight);

            dim.width += insets.left + insets.right + hgap * 2;
            dim.height += insets.top + insets.bottom + vgap * 2;

            return dim;
        }
    }

    private void addRow(Dimension dim, int rowWidth, int rowHeight) {
        dim.width = Math.max(dim.width, rowWidth);

        if (dim.height > 0) {
            dim.height += getVgap();
        }

        dim.height += rowHeight;
    }
}
    
    private void listarAtividadesNaTela() {
    painelAtividades.removeAll(); // limpa antes de atualizar

    
    
    controller.AtividadeController controller = new controller.AtividadeController();
    java.util.List<model.Atividade> lista = controller.listarAtividade(); // chama o DAO

    if (lista != null) {
        for (model.Atividade a : lista) {
            javax.swing.JEditorPane area = new javax.swing.JEditorPane();
            area.setFont(new java.awt.Font("Dialog", java.awt.Font.PLAIN, 14)); // ou BOLD, ou 16

            area.addMouseListener(new java.awt.event.MouseAdapter() {
    @Override
    public void mouseClicked(java.awt.event.MouseEvent evt) {
        bExcluir.setVisible(true);
        bConcluida.setVisible(true);
      atividadeSelecionada = a; // guarda qual foi clicada
    }
});
            
area.setPreferredSize(new java.awt.Dimension(680, 100));
area.setContentType("text/html");
area.setText(
    "<html>" +
    "<b>Nome:</b> " + a.getNome() + "<br>" +
    "<b>Descrição:</b> " + a.getDescricao() + "<br>" +
    "<b>Prazo:</b> " + a.getDatas() + "<br>" +
    "<b>Status:</b> " + a.getStatu() +
    "</html>"
);
area.setEditable(false);
area.setBackground(new java.awt.Color(255, 255, 204));
area.setBorder(javax.swing.BorderFactory.createCompoundBorder(
    javax.swing.BorderFactory.createLineBorder(java.awt.Color.GRAY),
    javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10)
));

 area.addMouseListener(new java.awt.event.MouseAdapter() {
                @Override
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    bExcluir.setVisible(true);
                    bConcluida.setVisible(true);
                    atividadeSelecionada = a;
                }
            });

            painelAtividades.add(area);
            painelAtividades.add(javax.swing.Box.createVerticalStrut(10));
        }

        painelAtividades.revalidate();
        painelAtividades.repaint();
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
        bConcluida = new javax.swing.JButton();
        bExcluir = new javax.swing.JButton();
        bCadastrar = new javax.swing.JButton();
        bAtvConc = new javax.swing.JButton();
        painelAtividades = new javax.swing.JPanel();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 153, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bConcluida.setBackground(new java.awt.Color(255, 204, 0));
        bConcluida.setForeground(new java.awt.Color(0, 0, 0));
        bConcluida.setText("Concluída");
        bConcluida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bConcluidaActionPerformed(evt);
            }
        });
        jPanel1.add(bConcluida, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, 130, 40));

        bExcluir.setBackground(new java.awt.Color(255, 204, 0));
        bExcluir.setForeground(new java.awt.Color(0, 0, 0));
        bExcluir.setText("Excluir");
        bExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bExcluirActionPerformed(evt);
            }
        });
        jPanel1.add(bExcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 10, 130, 40));

        bCadastrar.setBackground(new java.awt.Color(255, 204, 0));
        bCadastrar.setForeground(new java.awt.Color(0, 0, 0));
        bCadastrar.setText("Cadastrar");
        bCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCadastrarActionPerformed(evt);
            }
        });
        jPanel1.add(bCadastrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 10, 130, 40));

        bAtvConc.setBackground(new java.awt.Color(255, 204, 0));
        bAtvConc.setForeground(new java.awt.Color(0, 0, 0));
        bAtvConc.setText("Atividades Concluídas");
        jPanel1.add(bAtvConc, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 410, 720, 60));

        painelAtividades.setBackground(new java.awt.Color(255, 204, 0));
        painelAtividades.setLayout(new javax.swing.BoxLayout(painelAtividades, javax.swing.BoxLayout.LINE_AXIS));
        getContentPane().add(painelAtividades, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, 410));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    
    private void bCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCadastrarActionPerformed
        // TODO add your handling code here:
         CadAtv cadastro = new CadAtv ();
        cadastro.setVisible(true);
        
         cadastro.addWindowListener(new java.awt.event.WindowAdapter() {
        @Override
        public void windowClosed(java.awt.event.WindowEvent e) {
            listarAtividadesNaTela(); // Atualiza a lista
        }
    });
    }//GEN-LAST:event_bCadastrarActionPerformed

    private void bConcluidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bConcluidaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bConcluidaActionPerformed

    private void bExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bExcluirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bExcluirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAtvConc;
    private javax.swing.JButton bCadastrar;
    private javax.swing.JButton bConcluida;
    private javax.swing.JButton bExcluir;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel painelAtividades;
    // End of variables declaration//GEN-END:variables
}
