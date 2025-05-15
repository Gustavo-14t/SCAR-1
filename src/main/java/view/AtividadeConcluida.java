/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Component;
import java.awt.Container;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.io.File;
import java.io.FileOutputStream;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Todosdacasa
 */
public class AtividadeConcluida extends javax.swing.JFrame {

    /**
     * Creates new form AtividadeConcluida
     */
    public AtividadeConcluida() {
        initComponents();
        
        painelAtividades.setLayout(new javax.swing.BoxLayout(painelAtividades, javax.swing.BoxLayout.Y_AXIS));

// Envolva com JScrollPane
javax.swing.JScrollPane scrollPane = new javax.swing.JScrollPane(painelAtividades);
scrollPane.setVerticalScrollBarPolicy(javax.swing.JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
scrollPane.setHorizontalScrollBarPolicy(javax.swing.JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

getContentPane().add(scrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, 410));

listarAtividadesNaTela();
    }
    
    private void gerarRelatorioPDF(java.util.List<model.Atividade> lista) {
    try {
        String userHome = System.getProperty("user.home");
        String filePath = userHome + "/Downloads/relatorio_atividades.pdf";

        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, new FileOutputStream(filePath));
        document.open();

        // Título
        Font titleFont = new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD);
        Paragraph title = new Paragraph("Relatório de Atividades Concluídas", titleFont);
        title.setAlignment(Element.ALIGN_CENTER);
        title.setSpacingAfter(20);
        document.add(title);

        // Fonte padrão
        Font normalFont = new Font(Font.FontFamily.HELVETICA, 12, Font.NORMAL);

        // Tabela com 4 colunas
        PdfPTable table = new PdfPTable(4);
        table.setWidthPercentage(100);
        table.setWidths(new float[]{3, 5, 3, 2}); // larguras relativas das colunas
        table.setSpacingBefore(10f);
        table.setSpacingAfter(10f);

        // Cabeçalho da tabela
        Font headerFont = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD, BaseColor.WHITE);
        BaseColor headerColor = new BaseColor(255, 153, 0); // laranja

        String[] headers = {"Nome", "Descrição", "Prazo", "Status"};
        for (String col : headers) {
            PdfPCell header = new PdfPCell(new Phrase(col, headerFont));
            header.setBackgroundColor(headerColor);
            header.setHorizontalAlignment(Element.ALIGN_CENTER);
            header.setPadding(5);
            table.addCell(header);
        }

        // Dados da tabela
        for (model.Atividade a : lista) {
            table.addCell(new PdfPCell(new Phrase(a.getNome(), normalFont)));
            table.addCell(new PdfPCell(new Phrase(a.getDescricao(), normalFont)));
            table.addCell(new PdfPCell(new Phrase(a.getDatas(), normalFont)));
            table.addCell(new PdfPCell(new Phrase(a.getStatu(), normalFont)));
        }

        document.add(table);

        // Rodapé
        Paragraph footer = new Paragraph("Relatório gerado em: " + new java.util.Date(), new Font(Font.FontFamily.HELVETICA, 10, Font.ITALIC));
        footer.setAlignment(Element.ALIGN_RIGHT);
        document.add(footer);

        document.close();

        // Abrir automaticamente
        File pdfFile = new File(filePath);
        if (pdfFile.exists()) {
            Desktop.getDesktop().open(pdfFile);
        }

    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Erro ao gerar PDF: " + e.getMessage());
    }
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
    java.util.List<model.Atividade> lista = controller.listarAtividadeConc(); // chama o DAO

    if (lista != null) {
        for (model.Atividade a : lista) {
            javax.swing.JEditorPane area = new javax.swing.JEditorPane();
            area.setFont(new java.awt.Font("Dialog", java.awt.Font.PLAIN, 14)); // ou BOLD, ou 16

            area.addMouseListener(new java.awt.event.MouseAdapter() {
    @Override
    public void mouseClicked(java.awt.event.MouseEvent evt) {
        
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

        painelAtividades = new javax.swing.JPanel();
        painelBar = new javax.swing.JPanel();
        bBaixarRela = new javax.swing.JToggleButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        painelAtividades.setBackground(new java.awt.Color(255, 204, 0));

        javax.swing.GroupLayout painelAtividadesLayout = new javax.swing.GroupLayout(painelAtividades);
        painelAtividades.setLayout(painelAtividadesLayout);
        painelAtividadesLayout.setHorizontalGroup(
            painelAtividadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 720, Short.MAX_VALUE)
        );
        painelAtividadesLayout.setVerticalGroup(
            painelAtividadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );

        getContentPane().add(painelAtividades, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, 400));

        painelBar.setBackground(new java.awt.Color(255, 153, 0));
        painelBar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bBaixarRela.setText("Baixar Relatório");
        bBaixarRela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bBaixarRelaActionPerformed(evt);
            }
        });
        painelBar.add(bBaixarRela, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 11, 140, 38));

        jButton1.setText("Voltar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        painelBar.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 99, 40));

        getContentPane().add(painelBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 400, 720, 60));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void bBaixarRelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBaixarRelaActionPerformed
        // TODO add your handling code here:
        bBaixarRela.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
        controller.AtividadeController controller = new controller.AtividadeController();
        java.util.List<model.Atividade> lista = controller.listarAtividadeConc();

        if (lista != null && !lista.isEmpty()) {
            gerarRelatorioPDF(lista);
        } else {
            JOptionPane.showMessageDialog(null, "Nenhuma atividade encontrada para gerar o relatório.");
        }
    }
});

    }//GEN-LAST:event_bBaixarRelaActionPerformed

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
            java.util.logging.Logger.getLogger(AtividadeConcluida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AtividadeConcluida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AtividadeConcluida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AtividadeConcluida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AtividadeConcluida().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton bBaixarRela;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel painelAtividades;
    private javax.swing.JPanel painelBar;
    // End of variables declaration//GEN-END:variables
}
