/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import guiamedico.Medico;
import java.util.List;
import javax.swing.DefaultListModel;

/**
 *
 * @author Thales
 */
public class ResultadoMedico extends javax.swing.JFrame {

    /**
     * Creates new form BuscaMedico
     */
    private GuiaMedicoMain janelaPrincipal;
    private List<Medico> med;

    public ResultadoMedico() {
        initComponents();
    }

    public ResultadoMedico(GuiaMedicoMain janelaAnterior, List<Medico> med) {
        this();
        this.janelaPrincipal = janelaAnterior;
        this.med = med;

        DefaultListModel listModel;
        listModel = new DefaultListModel();
        if (med.size() == 0) {
                listModel.addElement("Nenhum item corresponde à sua busca");
                jList1.setModel(listModel);
        } else {
            for (int i = 0; i < med.size(); i++) {
                listModel.addElement(med.get(i).getNome());
                listModel.addElement(med.get(i).getCrm());
                listModel.addElement(med.get(i).getEspecialidae());
                listModel.addElement(med.get(i).getEmail());
                listModel.addElement(med.get(i).getDisponibilidade());
                listModel.addElement("\n");
            }
            jList1.setModel(listModel);
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

        jpLogoMedico = new javax.swing.JPanel();
        lbMedico = new javax.swing.JLabel();
        jpStatusMedico = new javax.swing.JPanel();
        jbResultadoMedico = new javax.swing.JPanel();
        jspResultadoMedico = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();

        setBackground(new java.awt.Color(255, 255, 255));

        jpLogoMedico.setBackground(new java.awt.Color(255, 255, 255));
        jpLogoMedico.setPreferredSize(new java.awt.Dimension(550, 150));

        lbMedico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Logo Medicina.-800x800.jpg"))); // NOI18N
        lbMedico.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout jpLogoMedicoLayout = new javax.swing.GroupLayout(jpLogoMedico);
        jpLogoMedico.setLayout(jpLogoMedicoLayout);
        jpLogoMedicoLayout.setHorizontalGroup(
            jpLogoMedicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpLogoMedicoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbMedico, javax.swing.GroupLayout.DEFAULT_SIZE, 532, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpLogoMedicoLayout.setVerticalGroup(
            jpLogoMedicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpLogoMedicoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbMedico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(21, 21, 21))
        );

        jpStatusMedico.setBackground(new java.awt.Color(255, 255, 255));
        jpStatusMedico.setPreferredSize(new java.awt.Dimension(571, 60));

        javax.swing.GroupLayout jpStatusMedicoLayout = new javax.swing.GroupLayout(jpStatusMedico);
        jpStatusMedico.setLayout(jpStatusMedicoLayout);
        jpStatusMedicoLayout.setHorizontalGroup(
            jpStatusMedicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 552, Short.MAX_VALUE)
        );
        jpStatusMedicoLayout.setVerticalGroup(
            jpStatusMedicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 36, Short.MAX_VALUE)
        );

        jbResultadoMedico.setBackground(new java.awt.Color(255, 255, 255));

        jList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Médico 1 e dados", "Médico 2 e dados", "Médico 3 e dados", "Médico 4 e dados", "Médico 5 e dados", "Médico 6 e dados" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jspResultadoMedico.setViewportView(jList1);

        javax.swing.GroupLayout jbResultadoMedicoLayout = new javax.swing.GroupLayout(jbResultadoMedico);
        jbResultadoMedico.setLayout(jbResultadoMedicoLayout);
        jbResultadoMedicoLayout.setHorizontalGroup(
            jbResultadoMedicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jbResultadoMedicoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jspResultadoMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75))
        );
        jbResultadoMedicoLayout.setVerticalGroup(
            jbResultadoMedicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jbResultadoMedicoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jspResultadoMedico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbResultadoMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 552, Short.MAX_VALUE)
                    .addComponent(jpStatusMedico, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 552, Short.MAX_VALUE)
                    .addComponent(jpLogoMedico, javax.swing.GroupLayout.DEFAULT_SIZE, 552, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpLogoMedico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpStatusMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbResultadoMedico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(ResultadoMedico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ResultadoMedico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ResultadoMedico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ResultadoMedico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ResultadoMedico().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList jList1;
    private javax.swing.JPanel jbResultadoMedico;
    private javax.swing.JPanel jpLogoMedico;
    private javax.swing.JPanel jpStatusMedico;
    private javax.swing.JScrollPane jspResultadoMedico;
    private javax.swing.JLabel lbMedico;
    // End of variables declaration//GEN-END:variables
}
