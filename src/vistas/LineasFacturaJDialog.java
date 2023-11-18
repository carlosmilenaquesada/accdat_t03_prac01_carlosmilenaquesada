package vistas;

import controladores.Crud;
import java.util.Set;
import javax.swing.table.DefaultTableModel;
import modelos.Articulos;
import modelos.Facturas;

public class LineasFacturaJDialog extends javax.swing.JDialog {

    Crud crud;
    private Facturas facturas;
    DefaultTableModel dtmLineaFacturas;

    public LineasFacturaJDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public LineasFacturaJDialog(java.awt.Frame parent, boolean modal, Facturas facturas) {
        super(parent, modal);
        initComponents();
        this.facturas = facturas;
        initConfiguracion();
    }

    private void initConfiguracion() {
        crud = new Crud();
        dtmLineaFacturas = (DefaultTableModel) jtLineasFactura.getModel();

        this.jtLineasFactura.setCellSelectionEnabled(false);
        this.jtLineasFactura.setRowSelectionAllowed(true);
        rellenarTablaLineasFactura();
        
        

    }

    private void rellenarTablaLineasFactura() {
        for (Articulos a : (Set<Articulos>) facturas.getArticuloses()) {
            dtmLineaFacturas.addRow(new Object[]{this.facturas.getNumfactura(), a.getCodarticulo()});
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jspLineaFactura = new javax.swing.JScrollPane();
        jtLineasFactura = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jtLineasFactura.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Número factura", "Código artículo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtLineasFactura.setColumnSelectionAllowed(true);
        jtLineasFactura.getTableHeader().setReorderingAllowed(false);
        jspLineaFactura.setViewportView(jtLineasFactura);
        jtLineasFactura.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jspLineaFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jspLineaFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {

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
            java.util.logging.Logger.getLogger(LineasFacturaJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LineasFacturaJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LineasFacturaJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LineasFacturaJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                LineasFacturaJDialog dialog = new LineasFacturaJDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jspLineaFactura;
    private javax.swing.JTable jtLineasFactura;
    // End of variables declaration//GEN-END:variables
}
