package vistas;

import controladores.Herramientas;

public class PrincipalJFrame extends javax.swing.JFrame {

    public PrincipalJFrame() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        jButtonFamilias = new javax.swing.JButton();
        jButtonClientes = new javax.swing.JButton();
        jButtonFacturas = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gestión de ventas");
        setMinimumSize(new java.awt.Dimension(280, 240));
        setResizable(false);

        jPanel1.setMinimumSize(new java.awt.Dimension(280, 240));
        jPanel1.setPreferredSize(new java.awt.Dimension(280, 240));

        jToolBar1.setRollover(true);

        jButtonFamilias.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButtonFamilias.setText("Familias");
        jButtonFamilias.setFocusable(false);
        jButtonFamilias.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonFamilias.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonFamilias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFamiliasActionPerformed(evt);
            }
        });
        jToolBar1.add(jButtonFamilias);

        jButtonClientes.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButtonClientes.setText("Clientes");
        jButtonClientes.setFocusable(false);
        jButtonClientes.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonClientes.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonClientesActionPerformed(evt);
            }
        });
        jToolBar1.add(jButtonClientes);

        jButtonFacturas.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButtonFacturas.setText("Facturas");
        jButtonFacturas.setFocusable(false);
        jButtonFacturas.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonFacturas.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonFacturas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFacturasActionPerformed(evt);
            }
        });
        jToolBar1.add(jButtonFacturas);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 533, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(335, 335, 335))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 533, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonClientesActionPerformed
        ClientesJDialog clientesJDialog = new ClientesJDialog(this, true);
        clientesJDialog.setBounds(Herramientas.bondsDeDialogs(this, clientesJDialog));
        clientesJDialog.setVisible(true);
    }//GEN-LAST:event_jButtonClientesActionPerformed

    private void jButtonFacturasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFacturasActionPerformed
        FacturasJDialog facturasJDialog = new FacturasJDialog(this, true);
        facturasJDialog.setBounds(Herramientas.bondsDeDialogs(this, facturasJDialog));
        facturasJDialog.setVisible(true);
    }//GEN-LAST:event_jButtonFacturasActionPerformed

    private void jButtonFamiliasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFamiliasActionPerformed
        FamiliasJDialog familiasJDialog = new FamiliasJDialog(this, true);
        familiasJDialog.setBounds(Herramientas.bondsDeDialogs(this, familiasJDialog));
        familiasJDialog.setVisible(true);
    }//GEN-LAST:event_jButtonFamiliasActionPerformed

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
            java.util.logging.Logger.getLogger(PrincipalJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PrincipalJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PrincipalJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PrincipalJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PrincipalJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonClientes;
    private javax.swing.JButton jButtonFacturas;
    private javax.swing.JButton jButtonFamilias;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables
}
