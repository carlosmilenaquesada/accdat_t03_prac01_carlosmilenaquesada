package vistas;

import controladores.Crud;
import java.awt.Rectangle;
import java.util.ArrayList;
import javax.swing.JDialog;
import modelos.Familias;

public class PrincipalJFrame extends javax.swing.JFrame {
    
    public PrincipalJFrame() {
        initComponents();
        Crud crud = new Crud();
        /*Familias familias1 = new Familias("F001", "SOMBREROS", null);
        Familias familias2 = new Familias("F002", "ZAPATOS", null);
        Familias familias3 = new Familias("F003", "PANTALONES", null);
        Familias familias4 = new Familias("F004", "CAMISAS", null);
        crud.create(familias1);
        crud.create(familias2);
        crud.create(familias3);
        crud.create(familias4);*/
        ArrayList<Familias> fam = new ArrayList<>(crud.readAll("from Familias"));
        for (Familias f: fam) {
            System.out.println(f);
        }
        
        System.exit(0);
    }

    private Rectangle bondsDeDialogs(JDialog jDialog){
        return new Rectangle(this.getX() + 20, this.getY() + 20, jDialog.getWidth(), jDialog.getHeight());
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButtonGestArt = new javax.swing.JButton();
        jButtonGestClie = new javax.swing.JButton();
        jButtonGestFact = new javax.swing.JButton();
        jButtonGestFam = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gestión de ventas");
        setMinimumSize(new java.awt.Dimension(280, 240));
        setPreferredSize(new java.awt.Dimension(280, 240));
        setResizable(false);

        jPanel1.setMinimumSize(new java.awt.Dimension(280, 240));
        jPanel1.setPreferredSize(new java.awt.Dimension(280, 240));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Articulos");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(50, 20, 60, 25);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Clientes");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(50, 65, 60, 25);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Facturas");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(50, 110, 60, 25);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Familias");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(50, 155, 60, 25);

        jButtonGestArt.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButtonGestArt.setText("Gestionar");
        jButtonGestArt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGestArtActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonGestArt);
        jButtonGestArt.setBounds(130, 20, 100, 25);

        jButtonGestClie.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButtonGestClie.setText("Gestionar");
        jButtonGestClie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGestClieActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonGestClie);
        jButtonGestClie.setBounds(130, 65, 100, 25);

        jButtonGestFact.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButtonGestFact.setText("Gestionar");
        jButtonGestFact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGestFactActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonGestFact);
        jButtonGestFact.setBounds(130, 110, 100, 25);

        jButtonGestFam.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButtonGestFam.setText("Gestionar");
        jButtonGestFam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGestFamActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonGestFam);
        jButtonGestFam.setBounds(130, 155, 100, 25);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonGestArtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGestArtActionPerformed
        ArticulosJDialog articulosJDialog = new ArticulosJDialog(this, true);
        articulosJDialog.setBounds(bondsDeDialogs(articulosJDialog));
        articulosJDialog.setVisible(true);
    }//GEN-LAST:event_jButtonGestArtActionPerformed

    private void jButtonGestClieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGestClieActionPerformed
        ClientesJDialog clientesJDialog = new ClientesJDialog(this, true);
        clientesJDialog.setBounds(bondsDeDialogs(clientesJDialog));
        clientesJDialog.setVisible(true);
    }//GEN-LAST:event_jButtonGestClieActionPerformed

    private void jButtonGestFactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGestFactActionPerformed
        FacturasJDialog facturasJDialog = new FacturasJDialog(this, true);
        facturasJDialog.setBounds(bondsDeDialogs(facturasJDialog));
        facturasJDialog.setVisible(true);
    }//GEN-LAST:event_jButtonGestFactActionPerformed

    private void jButtonGestFamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGestFamActionPerformed
        FamiliasJDialog familiasJDialog = new FamiliasJDialog(this, true);
         familiasJDialog.setBounds(bondsDeDialogs(familiasJDialog));
        familiasJDialog.setVisible(true);
    }//GEN-LAST:event_jButtonGestFamActionPerformed

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
    private javax.swing.JButton jButtonGestArt;
    private javax.swing.JButton jButtonGestClie;
    private javax.swing.JButton jButtonGestFact;
    private javax.swing.JButton jButtonGestFam;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
