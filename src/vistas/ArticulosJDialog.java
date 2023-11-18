package vistas;

import controladores.Crud;
import controladores.Herramientas;
import java.text.ParseException;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import modelos.Articulos;
import modelos.Familias;

public class ArticulosJDialog extends javax.swing.JDialog {

    Crud crud;
    private Familias familias;
    DefaultTableModel dtmArticulos;
    

    public ArticulosJDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public ArticulosJDialog(java.awt.Frame parent, boolean modal, Familias familias) {
        super(parent, modal);
        this.familias = familias;
        initComponents();
        initConfiguracion();

    }

    private void initConfiguracion() {
        this.crud = new Crud();
        this.dtmArticulos = (DefaultTableModel) jtArticulos.getModel();

        this.jtArticulos.setCellSelectionEnabled(false);
        this.jtArticulos.setRowSelectionAllowed(true);
        rellenarTablaArticulos();

        this.jtArticulos.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (e.getValueIsAdjusting()) {
                    actualizarInputsTexto();
                }
            }
        });
    }

    private void rellenarTablaArticulos() {
        for (Articulos a : (Set<Articulos>) familias.getArticuloses()) {
            dtmArticulos.addRow(
                    new Object[]{a.getCodarticulo(),
                        a.getNomarticulo(),
                        Herramientas.dfPrecio.format(a.getPrecioarticulo()),
                        a.getFacturases().size()}
            );
        }
    }

    private void actualizarTabla() {
        familias = (Familias) crud.read(Familias.class, familias.getCodfamilia());
        Herramientas.limpiarTabla(dtmArticulos);
        rellenarTablaArticulos();
    }

    private void actualizarInputsTexto() {
        int rowSeleccionada = jtArticulos.getSelectedRow();
        jtfCodigo.setText((String) jtArticulos.getValueAt(rowSeleccionada, 0));
        jtfNombre.setText((String) jtArticulos.getValueAt(rowSeleccionada, 1));
        jtfPrecio.setText((String) jtArticulos.getValueAt(rowSeleccionada, 2));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jtfCodigo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jtfNombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jtfPrecio = new javax.swing.JTextField();
        jbCrear = new javax.swing.JButton();
        jbModificar = new javax.swing.JButton();
        jbBorrar = new javax.swing.JButton();
        jspArticulos = new javax.swing.JScrollPane();
        jtArticulos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gestion de artículos");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel1.setText("Código");

        jLabel3.setText("Nombre");

        jLabel4.setText("Precio");

        jbCrear.setText("Crear artículo");
        jbCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCrearActionPerformed(evt);
            }
        });

        jbModificar.setText("Modificar artículo");
        jbModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbModificarActionPerformed(evt);
            }
        });

        jbBorrar.setText("Eliminar artículo");
        jbBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBorrarActionPerformed(evt);
            }
        });

        jtArticulos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nombre", "Precio", "Facturas asociadas"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtArticulos.setColumnSelectionAllowed(true);
        jtArticulos.getTableHeader().setReorderingAllowed(false);
        jspArticulos.setViewportView(jtArticulos);
        jtArticulos.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jbCrear)
                        .addGap(18, 18, 18)
                        .addComponent(jbModificar)
                        .addGap(18, 18, 18)
                        .addComponent(jbBorrar)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jspArticulos, javax.swing.GroupLayout.DEFAULT_SIZE, 570, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jtfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(jtfPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jspArticulos, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCrearActionPerformed
        if (!jtfCodigo.getText().isEmpty()) {
            Articulos articulos = null;
            try {
                articulos = new Articulos(
                        jtfCodigo.getText(),
                        familias,
                        jtfNombre.getText(),
                        Herramientas.stringABigDecimalPrecio(jtfPrecio.getText()),
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

        }
    }//GEN-LAST:event_jbCrearActionPerformed

    private void jbModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbModificarActionPerformed
        if (!jtfCodigo.getText().isEmpty()) {
            try {
                Articulos articulos = new Articulos(jtfCodigo.getText(), familias, jtfNombre.getText(), Herramientas.stringABigDecimalPrecio(jtfPrecio.getText()));
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
        }
    }//GEN-LAST:event_jbModificarActionPerformed

    private void jbBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBorrarActionPerformed
        if (!jtfCodigo.getText().isEmpty()) {
            String error = crud.delete(new Articulos(jtfCodigo.getText()));
            if (!error.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No se pudo borrar el artículo."
                        + "\nDescripción del error: " + error);
            } else {
                actualizarTabla();
            }
        }

    }//GEN-LAST:event_jbBorrarActionPerformed

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ArticulosJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ArticulosJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ArticulosJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ArticulosJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ArticulosJDialog dialog = new ArticulosJDialog(new javax.swing.JFrame(), true);
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbBorrar;
    private javax.swing.JButton jbCrear;
    private javax.swing.JButton jbModificar;
    private javax.swing.JScrollPane jspArticulos;
    private javax.swing.JTable jtArticulos;
    private javax.swing.JTextField jtfCodigo;
    private javax.swing.JTextField jtfNombre;
    private javax.swing.JTextField jtfPrecio;
    // End of variables declaration//GEN-END:variables
}
