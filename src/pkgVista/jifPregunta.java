/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgVista;

/**
 *
 * @author kiritoxcii
 */
public class jifPregunta extends javax.swing.JInternalFrame {

    /**
     * Creates new form jifPregunta
     */
    public jifPregunta() {
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

        jplResponder = new javax.swing.JPanel();
        lblPregunta = new javax.swing.JLabel();
        btnNo = new javax.swing.JButton();
        btnSi = new javax.swing.JButton();

        setBackground(new java.awt.Color(204, 204, 255));
        setTitle("RESPONDER...");

        jplResponder.setBackground(new java.awt.Color(204, 204, 255));

        lblPregunta.setText("¿¿¿¿¿¿Aquí va la pregunta????????");

        btnNo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkgImagenes/delete_16.png"))); // NOI18N
        btnNo.setText("No");

        btnSi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkgImagenes/tick_16.png"))); // NOI18N
        btnSi.setText("Sí");

        javax.swing.GroupLayout jplResponderLayout = new javax.swing.GroupLayout(jplResponder);
        jplResponder.setLayout(jplResponderLayout);
        jplResponderLayout.setHorizontalGroup(
            jplResponderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jplResponderLayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(btnSi, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
                .addComponent(btnNo, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72))
            .addGroup(jplResponderLayout.createSequentialGroup()
                .addGap(153, 153, 153)
                .addComponent(lblPregunta)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jplResponderLayout.setVerticalGroup(
            jplResponderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jplResponderLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(lblPregunta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(jplResponderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSi)
                    .addComponent(btnNo))
                .addGap(38, 38, 38))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jplResponder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jplResponder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNo;
    private javax.swing.JButton btnSi;
    private javax.swing.JPanel jplResponder;
    private javax.swing.JLabel lblPregunta;
    // End of variables declaration//GEN-END:variables
}
