package vistas;

import controladores.Crud;
import controladores.Herramientas;
import java.awt.Frame;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import modelos.Cliente;

import modelos.Factura;

public class FacturaJDialog extends javax.swing.JDialog {

    Crud crud;
    DefaultTableModel dtmFactura;
    List<Factura> listaFacturas;
    private Factura facturaEnFoco;
    private int rowSeleccionada;

    public FacturaJDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        initConfiguracion();
    }

    private void initConfiguracion() {
        this.crud = new Crud();
        this.dtmFactura = (DefaultTableModel) jtFactura.getModel();
        this.jtFactura.setCellSelectionEnabled(false);
        this.jtFactura.setRowSelectionAllowed(true);
        actualizarTabla();

        this.rowSeleccionada = jtFactura.getSelectedRow();

        this.jtFactura.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (e.getValueIsAdjusting()) {
                    rowSeleccionada = jtFactura.getSelectedRow();
                    Object pkRowSeleccionada = jtFactura.getValueAt(rowSeleccionada, 0);
                    facturaEnFoco = listaFacturas.get(listaFacturas.indexOf(new Factura((BigDecimal) pkRowSeleccionada)));
                    actualizarInputsTexto();
                }
            }
        });
    }

    private void actualizarTabla() {
        listaFacturas = (List<Factura>) crud.readAllCriteria(Factura.class);
        Herramientas.limpiarTabla(dtmFactura);
        for (Factura f : listaFacturas) {
            dtmFactura.addRow(
                    new Object[]{f.getNumFactura(), f.getCliente().getCodCliente(), Herramientas.sdf.format(f.getFechaFactura()), f.getListaArticulos().size()}
            );
        }
    }

    private void actualizarInputsTexto() {
        rowSeleccionada = jtFactura.getSelectedRow();
        jtfNumero.setText(Herramientas.dfNumEntero.format(jtFactura.getValueAt(rowSeleccionada, 0)));
        jtfCliente.setText((String) jtFactura.getValueAt(rowSeleccionada, 1));
        jtfFecha.setText((String) jtFactura.getValueAt(rowSeleccionada, 2));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jtfNumero = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jtfCliente = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jtfFecha = new javax.swing.JTextField();
        jbCrear = new javax.swing.JButton();
        jbModificar = new javax.swing.JButton();
        jbBorrar = new javax.swing.JButton();
        jspFactura = new javax.swing.JScrollPane();
        jtFactura = new javax.swing.JTable();
        jbGestionFactura = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gestión de facturas");

        jLabel1.setText("Número factura");

        jLabel3.setText("Código cliente");

        jLabel4.setText("Fecha factura");

        jbCrear.setText("Crear factura");
        jbCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCrearActionPerformed(evt);
            }
        });

        jbModificar.setText("Modificar factura");
        jbModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbModificarActionPerformed(evt);
            }
        });

        jbBorrar.setText("Eliminar factura");
        jbBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBorrarActionPerformed(evt);
            }
        });

        jtFactura.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Número factura", "Código cliente", "Fecha factura", "Número de líneas"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtFactura.setColumnSelectionAllowed(true);
        jtFactura.getTableHeader().setReorderingAllowed(false);
        jspFactura.setViewportView(jtFactura);
        jtFactura.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        jbGestionFactura.setText("Gestionar líneas factura");
        jbGestionFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGestionFacturaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbCrear)
                        .addGap(18, 18, 18)
                        .addComponent(jbModificar)
                        .addGap(18, 18, 18)
                        .addComponent(jbBorrar)
                        .addGap(18, 18, 18)
                        .addComponent(jbGestionFactura))
                    .addComponent(jspFactura))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtfNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jtfCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jtfFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jspFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbGestionFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCrearActionPerformed
        if (!jtfNumero.getText().isEmpty()) {
            Factura facturas = null;
            try {
                Cliente c = (Cliente) crud.read(Cliente.class, jtfCliente.getText());
                if (c != null) {
                    facturas = new Factura(
                            Herramientas.stringABigDecimalNumEntero(jtfNumero.getText()),
                            c,
                            Herramientas.sdf.parse(jtfFecha.getText()),
                            null
                    );
                }

                if (facturas != null) {
                    String error = "";
                    error = crud.create(facturas);
                    if (!error.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "No se pudo crear la factura."
                                + "\nDescripción del error: " + error);
                    } else {
                        actualizarTabla();
                    }
                }
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(null, "El precio proporcionado no es válido.");
            }
        }
    }//GEN-LAST:event_jbCrearActionPerformed

    private void jbModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbModificarActionPerformed
        if (!jtfNumero.getText().isEmpty()) {
            try {
                Factura facturas = new Factura(Herramientas.stringABigDecimalNumEntero(jtfNumero.getText()));
                if (listaFacturas.contains(facturas)) {
                    facturas.setFechaFactura(Herramientas.sdf.parse(jtfFecha.getText()));
                    Cliente c = (Cliente) crud.read(Cliente.class, jtfCliente.getText());
                    if (c != null) {
                        facturas.setCliente(c);
                        crud.update(facturas);
                        actualizarTabla();
                    } else {
                        JOptionPane.showMessageDialog(null, "El cliente, al cual se pretende asociar la factura, no existe.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "No existe una factura con ese número de factura.");
                }
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(null, "El número de factura proporcionado no es válido.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Proporcione un número de factura para iniciar la modificación.");
        }
    }//GEN-LAST:event_jbModificarActionPerformed

    private void jbBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBorrarActionPerformed
        /*if (!jtfNumero.getText().isEmpty()) {
            String error = crud.delete(new Articulos(jtfNumero.getText()));
            if (!error.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No se pudo borrar el artículo."
                    + "\nDescripción del error: " + error);
            } else {
                actualizarTabla();
            }
        }*/
    }//GEN-LAST:event_jbBorrarActionPerformed

    private void jbGestionFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGestionFacturaActionPerformed
        if (facturaEnFoco != null) {
            LineaFacturaJDialog lineasFacturaJDialog = new LineaFacturaJDialog((Frame) this.getParent(), true, facturaEnFoco);
            lineasFacturaJDialog.setBounds(Herramientas.bondsDeDialogs(this, lineasFacturaJDialog));
            lineasFacturaJDialog.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Marque una familia en la tabla sobre la que gestionar los artículos.");
        }


    }//GEN-LAST:event_jbGestionFacturaActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FacturaJDialog dialog = new FacturaJDialog(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel jLabel4;
    private javax.swing.JButton jbBorrar;
    private javax.swing.JButton jbCrear;
    private javax.swing.JButton jbGestionFactura;
    private javax.swing.JButton jbModificar;
    private javax.swing.JScrollPane jspFactura;
    private javax.swing.JTable jtFactura;
    private javax.swing.JTextField jtfCliente;
    private javax.swing.JTextField jtfFecha;
    private javax.swing.JTextField jtfNumero;
    // End of variables declaration//GEN-END:variables
}
