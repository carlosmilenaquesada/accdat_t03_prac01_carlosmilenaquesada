package vistas;

import controladores.Crud;
import controladores.Herramientas;
import java.util.HashSet;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import modelos.Clientes;

public class ClienteJDialog extends javax.swing.JDialog {

    private Crud crud;
    private DefaultTableModel dtmCliente;
    private List<Clientes> listaClientes;

    public ClienteJDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        initConfiguracion();
    }

    private void initConfiguracion() {
        this.crud = new Crud();
        this.dtmCliente = (DefaultTableModel) jtCliente.getModel();
        this.jtCliente.setCellSelectionEnabled(false);
        this.jtCliente.setRowSelectionAllowed(true);
        actualizarTabla();

        this.jtCliente.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (e.getValueIsAdjusting()) {
                    actualizarInputsTexto();
                }
            }
        });
    }

    private void actualizarInputsTexto() {
        int rowSeleccionada = jtCliente.getSelectedRow();
        jtfCodigo.setText((String) jtCliente.getValueAt(rowSeleccionada, 0));
        jtfNombre.setText((String) jtCliente.getValueAt(rowSeleccionada, 1));
        jtfDomicilio.setText((String) jtCliente.getValueAt(rowSeleccionada, 2));
    }

    private void actualizarTabla() {
        listaClientes = crud.readAllHQL("from Cliente c");
        Herramientas.limpiarTabla(dtmCliente);
        for (Clientes c : this.listaClientes) {
            dtmCliente.addRow(new Object[]{c.getCodcliente(), c.getNomcliente(), c.getDomiciliocli()});
        }
        jtfCodigo.setText("");
        jtfNombre.setText("");
        jtfDomicilio.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jbActualizarTabla = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jtfCodigo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jtfNombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jtfDomicilio = new javax.swing.JTextField();
        jbCrear = new javax.swing.JButton();
        jbModificar = new javax.swing.JButton();
        jbBorrar = new javax.swing.JButton();
        jspCliente = new javax.swing.JScrollPane();
        jtCliente = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gestión de clientes");

        jbActualizarTabla.setText("Actualizar tabla");
        jbActualizarTabla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbActualizarTablaActionPerformed(evt);
            }
        });

        jLabel1.setText("Código");

        jLabel2.setText("Nombre");

        jLabel3.setText("Domicilio");

        jbCrear.setText("Crear cliente");
        jbCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCrearActionPerformed(evt);
            }
        });

        jbModificar.setText("Modificar Cliente");
        jbModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbModificarActionPerformed(evt);
            }
        });

        jbBorrar.setText("Eliminar Cliente");
        jbBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBorrarActionPerformed(evt);
            }
        });

        jtCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nombre", "Domicilio"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtCliente.setColumnSelectionAllowed(true);
        jtCliente.getTableHeader().setReorderingAllowed(false);
        jspCliente.setViewportView(jtCliente);
        jtCliente.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

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
                        .addComponent(jbBorrar))
                    .addComponent(jspCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 526, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtfCodigo)
                    .addComponent(jtfNombre)
                    .addComponent(jtfDomicilio)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jbActualizarTabla))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbActualizarTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfDomicilio, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jspCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbActualizarTablaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbActualizarTablaActionPerformed
        actualizarTabla();
    }//GEN-LAST:event_jbActualizarTablaActionPerformed

    private void jbCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCrearActionPerformed
        if (!jtfCodigo.getText().isEmpty()) {
            Clientes clientes = new Clientes(jtfCodigo.getText(), jtfNombre.getText(), jtfDomicilio.getText(), new HashSet(0));
            String error = crud.create(clientes);
            if (!error.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No se pudo crear el cliente."
                        + "\nDescripción del error: " + error);
            } else {
                actualizarTabla();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe proporcionar un código de cliente.");
        }
    }//GEN-LAST:event_jbCrearActionPerformed

    private void jbModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbModificarActionPerformed
        if (!jtfCodigo.getText().isEmpty()) {
            Clientes clientes = new Clientes(jtfCodigo.getText());
            if (listaClientes.contains(clientes)) {
                clientes.setNomcliente(jtfNombre.getText());
                clientes.setDomiciliocli(jtfDomicilio.getText());
                String error = crud.update(clientes);
                if (!error.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "No se pudo actualizar el cliente."
                            + "\nDescripción del error: " + error);
                } else {
                    actualizarTabla();
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe proporcionar un código de cliente.");
        }
    }//GEN-LAST:event_jbModificarActionPerformed

    private void jbBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBorrarActionPerformed
        if (!jtfCodigo.getText().isEmpty()) {
            Clientes clientes = new Clientes(jtfCodigo.getText());
            String error = crud.delete(clientes);
            if (!error.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No se pudo borrar el cliente."
                        + "\nDescripción del error: " + error);
            } else {
                actualizarTabla();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe proporcionar un código de cliente.");
        }
    }//GEN-LAST:event_jbBorrarActionPerformed

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
            java.util.logging.Logger.getLogger(ClienteJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClienteJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClienteJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClienteJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ClienteJDialog dialog = new ClienteJDialog(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton jbActualizarTabla;
    private javax.swing.JButton jbBorrar;
    private javax.swing.JButton jbCrear;
    private javax.swing.JButton jbModificar;
    private javax.swing.JScrollPane jspCliente;
    private javax.swing.JTable jtCliente;
    private javax.swing.JTextField jtfCodigo;
    private javax.swing.JTextField jtfDomicilio;
    private javax.swing.JTextField jtfNombre;
    // End of variables declaration//GEN-END:variables
}
