package vistas;

import controladores.Crud;
import controladores.Herramientas;
import java.util.List;
import java.util.Set;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
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
        
        this.jtfNumeroFactura.setText(Herramientas.dfNumEntero.format(this.facturas.getNumfactura()));
        this.jtfNumeroFactura.setEditable(false);
        
        this.jtLineasFactura.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (e.getValueIsAdjusting()) {
                    actualizarInputsTexto();
                }
            }
        });
    }
    
    private void rellenarTablaLineasFactura() {
        for (Articulos a : (Set<Articulos>) facturas.getArticuloses()) {
            dtmLineaFacturas.addRow(new Object[]{this.facturas.getNumfactura(), a.getCodarticulo()});
        }
    }
    
    private void actualizarTabla() {
        Herramientas.limpiarTabla(dtmLineaFacturas);
        Set setArticulos = ((Facturas) crud.read(Facturas.class, facturas.getNumfactura())).getArticuloses();
        for (Articulos a : (Set<Articulos>) setArticulos) {
            dtmLineaFacturas.addRow(new Object[]{this.facturas.getNumfactura(), a.getCodarticulo()});
        }
    }
    
    private void actualizarInputsTexto() {
        jtfCodigoArticulo.setText(String.valueOf(jtLineasFactura.getValueAt(jtLineasFactura.getSelectedRow(), 1)));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jtfNumeroFactura = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jtfCodigoArticulo = new javax.swing.JTextField();
        jbCrear = new javax.swing.JButton();
        jbModificar = new javax.swing.JButton();
        jbBorrar = new javax.swing.JButton();
        jspLineasFactura = new javax.swing.JScrollPane();
        jtLineasFactura = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Número factura");

        jLabel3.setText("Código artículo");

        jbCrear.setText("Crea línea");
        jbCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCrearActionPerformed(evt);
            }
        });

        jbModificar.setText("Modificar línea");
        jbModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbModificarActionPerformed(evt);
            }
        });

        jbBorrar.setText("Eliminar línea");
        jbBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBorrarActionPerformed(evt);
            }
        });

        jtLineasFactura.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Numero factura", "Código artículo"
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
        jspLineasFactura.setViewportView(jtLineasFactura);
        jtLineasFactura.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbCrear)
                        .addGap(18, 18, 18)
                        .addComponent(jbModificar)
                        .addGap(18, 18, 18)
                        .addComponent(jbBorrar)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jspLineasFactura, javax.swing.GroupLayout.DEFAULT_SIZE, 366, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfNumeroFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jtfCodigoArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfNumeroFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfCodigoArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jspLineasFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCrearActionPerformed
        Articulos articulos = (Articulos) crud.read(Articulos.class, jtfCodigoArticulo.getText());
        if (articulos != null) {
            facturas.addArticulos(articulos);
            crud.update(facturas);
            actualizarTabla();
            
        }
    }//GEN-LAST:event_jbCrearActionPerformed

    private void jbModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbModificarActionPerformed
        /*if (!jtfNumeroFactura.getText().isEmpty()) {
            try {
                Articulos articulos = new Articulos(jtfNumeroFactura.getText(), familias, jtfCodigoArticulo.getText(), Herramientas.stringABigDecimalPrecio(jtfPrecio.getText()));
                if (familias.getArticuloses().contains(articulos)) {
                    crud.update(familias);
                } else {
                    int opcion = JOptionPane.showOptionDialog(null, "No existe un artículo con ese código de artículo."
                            + " ¿Desea crearlo?", "Crear", JOptionPane.YES_NO_CANCEL_OPTION,
                            JOptionPane.QUESTION_MESSAGE, null, null, null);
                    if (opcion == 0) {
                        articulos.setFacturases(new HashSet(0));
                        crud.create(articulos);
                    }
                }
                actualizarTabla();
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(null, "El precio proporcionado no es válido.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Proporcione un código de familia para iniciar la modificación.");
        }*/
    }//GEN-LAST:event_jbModificarActionPerformed

    private void jbBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBorrarActionPerformed
        /*if (!jtfNumeroFactura.getText().isEmpty()) {
            String error = crud.delete(new Articulos(jtfNumeroFactura.getText()));
            if (!error.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No se pudo borrar el artículo."
                        + "\nDescripción del error: " + error);
            } else {
                actualizarTabla();
            }
        }*/
    }//GEN-LAST:event_jbBorrarActionPerformed
    
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton jbBorrar;
    private javax.swing.JButton jbCrear;
    private javax.swing.JButton jbModificar;
    private javax.swing.JScrollPane jspLineasFactura;
    private javax.swing.JTable jtLineasFactura;
    private javax.swing.JTextField jtfCodigoArticulo;
    private javax.swing.JTextField jtfNumeroFactura;
    // End of variables declaration//GEN-END:variables
}
