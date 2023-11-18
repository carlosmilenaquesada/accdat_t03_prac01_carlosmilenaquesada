package vistas;

import controladores.Crud;
import controladores.Herramientas;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.HashSet;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import modelos.Clientes;

import modelos.Facturas;

public class FacturasJDialog extends javax.swing.JDialog {

    Crud crud;
    DefaultTableModel dtmFacturas;
    List<Facturas> listaFacturas;

    public FacturasJDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        initConfiguracion();
    }

    private void initConfiguracion() {
        this.crud = new Crud();
        this.dtmFacturas = (DefaultTableModel) jtFacturas.getModel();

        this.jtFacturas.setCellSelectionEnabled(false);
        this.jtFacturas.setRowSelectionAllowed(true);
        actualizarTabla();

        this.jtFacturas.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (e.getValueIsAdjusting()) {
                    actualizarInputsTexto();
                }
            }
        });
    }

    private void actualizarTabla() {
        listaFacturas = (List<Facturas>) crud.readAllCriteria(Facturas.class);
        Herramientas.limpiarTabla(dtmFacturas);
        for (Facturas f : listaFacturas) {
            System.out.println(f.getNumfactura());
            //System.out.println(f);

            dtmFacturas.addRow(
                    new Object[]{f.getNumfactura(), f.getClientes().getCodcliente(), Herramientas.sdf.format(f.getFechafactura()), f.getArticuloses().size()}
            );
        }
    }

    private void actualizarInputsTexto() {
        int rowSeleccionada = jtFacturas.getSelectedRow();
        jtfNumero.setText(Herramientas.dfNumEntero.format(jtFacturas.getValueAt(rowSeleccionada, 0)));
        jtfCliente.setText((String) jtFacturas.getValueAt(rowSeleccionada, 1));
        jtfFecha.setText((String) jtFacturas.getValueAt(rowSeleccionada, 2));
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
        jspFacturas = new javax.swing.JScrollPane();
        jtFacturas = new javax.swing.JTable();

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

        jtFacturas.setModel(new javax.swing.table.DefaultTableModel(
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
        jtFacturas.setColumnSelectionAllowed(true);
        jtFacturas.getTableHeader().setReorderingAllowed(false);
        jspFacturas.setViewportView(jtFacturas);
        jtFacturas.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

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
                        .addComponent(jspFacturas, javax.swing.GroupLayout.DEFAULT_SIZE, 479, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jtfCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(jtfFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
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
                    .addComponent(jspFacturas, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
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
        /*if (!jtfNumero.getText().isEmpty()) {
            Articulos articulos = null;
            try {
                articulos = new Articulos(
                    jtfNumero.getText(),
                    familias,
                    jtfCliente.getText(),
                    Herramientas.stringABigDecimalPrecio(jtfFecha.getText()),
                    null
                );
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(null, "El precio proporcionado no es válido.");
            }
            if (articulos != null) {
                String error = "";
                error = crud.create(articulos);
                if (!error.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "No se pudo crear el artículo."
                        + "\nDescripción del error: " + error);
                } else {
                    actualizarTabla();
                }
            }
        }*/
    }//GEN-LAST:event_jbCrearActionPerformed

    private void jbModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbModificarActionPerformed
        if (!jtfNumero.getText().isEmpty()) {
            try {
                Facturas facturas = new Facturas(Herramientas.stringABigDecimalNumEntero(jtfNumero.getText()));
                if (listaFacturas.contains(facturas)) {
                    facturas.setFechafactura(Herramientas.sdf.parse(jtfFecha.getText()));
                    Clientes c = (Clientes) crud.read(Clientes.class, jtfCliente.getText());
                    if (c != null) {
                        facturas.setClientes(c);
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

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FacturasJDialog dialog = new FacturasJDialog(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jbModificar;
    private javax.swing.JScrollPane jspFacturas;
    private javax.swing.JTable jtFacturas;
    private javax.swing.JTextField jtfCliente;
    private javax.swing.JTextField jtfFecha;
    private javax.swing.JTextField jtfNumero;
    // End of variables declaration//GEN-END:variables
}
