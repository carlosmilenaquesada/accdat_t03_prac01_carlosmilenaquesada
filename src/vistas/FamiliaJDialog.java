package vistas;

import controladores.Crud;
import controladores.Herramientas;
import java.awt.Frame;
import java.util.HashSet;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import javax.swing.table.DefaultTableModel;
import modelos.Familia;

public class FamiliaJDialog extends javax.swing.JDialog {

    private Crud crud;

    private DefaultTableModel dtmFamilia;
    private List<Familia> listaFamilias;
    private Familia familiaEnFoco;
    private int rowSeleccionada;

    public FamiliaJDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        initConfiguracion();
    }

    private void initConfiguracion() {
        this.crud = new Crud();
        this.dtmFamilia = (DefaultTableModel) jtFamilia.getModel();
        this.jtFamilia.setCellSelectionEnabled(false);
        this.jtFamilia.setRowSelectionAllowed(true);
        this.familiaEnFoco = null;
        actualizarTabla();
        this.rowSeleccionada = jtFamilia.getSelectedRow();

        this.jtFamilia.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (e.getValueIsAdjusting()) {
                    rowSeleccionada = jtFamilia.getSelectedRow();
                    Object pkRowSeleccionada = jtFamilia.getValueAt(rowSeleccionada, 0);
                    familiaEnFoco = listaFamilias.get(listaFamilias.indexOf(new Familia((String) pkRowSeleccionada)));
                    //Cada vez que selecciono una fila en la tabla Familia,
                    //necesito capturar el objeto Familia seleccionado para poder
                    //editarlo, borrarlo o mostrar sus artículos. Para ello,
                    //me ayudo del listaFamilias.get y listaFamilias.indexOf 
                    //proporcionándoles un new Familia con la pk de la familia
                    //marcada, ya que estos métodos utilizan el equals de la clase
                    //para identificar un elemento dentro de una List, y yo lo 
                    //tengo sobrecargado para que sea el "codFamilia" lo que 
                    //determine la igualdad.
                    actualizarInputsTexto(familiaEnFoco);
                }
            }
        });
    }

    private void actualizarInputsTexto(Familia familiaEnFoco) {
        jtfCodigo.setText(familiaEnFoco.getCodFamilia());
        jtfNombre.setText(familiaEnFoco.getNomFamilia());
        jtfDescripcion.setText(familiaEnFoco.getDescFamilia());
    }

    private void actualizarTabla() {
        listaFamilias = crud.readAllHQL("from Familia f");
        Herramientas.limpiarTabla(dtmFamilia);
        for (Familia f : this.listaFamilias) {
            dtmFamilia.addRow(new Object[]{f.getCodFamilia(), f.getNomFamilia(), f.getDescFamilia(), f.getListaArticulos().size()});
        }
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
        jtfDescripcion = new javax.swing.JTextField();
        jbCrear = new javax.swing.JButton();
        jbModificar = new javax.swing.JButton();
        jbBorrar = new javax.swing.JButton();
        jbGestionArticulo = new javax.swing.JButton();
        jspFamilia = new javax.swing.JScrollPane();
        jtFamilia = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gestión de familias");

        jbActualizarTabla.setText("Actualizar tabla");
        jbActualizarTabla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbActualizarTablaActionPerformed(evt);
            }
        });

        jLabel1.setText("Código");

        jLabel2.setText("Nombre");

        jLabel3.setText("Descripción");

        jbCrear.setText("Crear familia");
        jbCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCrearActionPerformed(evt);
            }
        });

        jbModificar.setText("Modificar familia");
        jbModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbModificarActionPerformed(evt);
            }
        });

        jbBorrar.setText("Eliminar familia");
        jbBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBorrarActionPerformed(evt);
            }
        });

        jbGestionArticulo.setText("Gestionar artículos de la familia");
        jbGestionArticulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGestionArticuloActionPerformed(evt);
            }
        });

        jtFamilia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nombre", "Descripción", "Artículos asociados"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtFamilia.setColumnSelectionAllowed(true);
        jtFamilia.getTableHeader().setReorderingAllowed(false);
        jspFamilia.setViewportView(jtFamilia);
        jtFamilia.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbGestionArticulo))
                    .addComponent(jspFamilia))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtfCodigo)
                    .addComponent(jtfNombre)
                    .addComponent(jtfDescripcion)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jbActualizarTabla))
                        .addGap(0, 117, Short.MAX_VALUE)))
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
                        .addComponent(jtfDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jspFamilia, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbGestionArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCrearActionPerformed
        if (!jtfCodigo.getText().isEmpty()) {
            Familia familias = new Familia(jtfCodigo.getText(), jtfNombre.getText(), jtfDescripcion.getText(), null);
            String error = crud.create(familias);
            if (!error.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No se pudo crear la familia."
                        + "\nDescripción del error: " + error);
            } else {
                actualizarTabla();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe proporcionar un código de familia válido.");
        }
    }//GEN-LAST:event_jbCrearActionPerformed

    private void jbModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbModificarActionPerformed
        if (!jtfCodigo.getText().isEmpty()) {
            Familia familias = new Familia(jtfCodigo.getText(), jtfNombre.getText(), jtfDescripcion.getText());
            if (listaFamilias.contains(familias)) {
                crud.update(familias);
            } else {
                int opcion = JOptionPane.showOptionDialog(null, "No existe una familia con ese código de familia."
                        + " ¿Desea crearla?", "Crear", JOptionPane.YES_NO_CANCEL_OPTION,
                        JOptionPane.QUESTION_MESSAGE, null, null, null);
                if (opcion == 0) {
                    familias.setListaArticulos(new HashSet(0));
                    crud.create(familias);
                }
            }
            actualizarTabla();
        } else {
            JOptionPane.showMessageDialog(null, "Debe seleccione o escriba un código de familia para iniciar la modificación.");
        }
    }//GEN-LAST:event_jbModificarActionPerformed

    private void jbBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBorrarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbBorrarActionPerformed

    private void jbGestionArticuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGestionArticuloActionPerformed
        if (familiaEnFoco != null) {
            if (familiaEnFoco.getListaArticulos().size() > 0) {
                ArticuloJDialog articulosJDialog = new ArticuloJDialog((Frame) this.getParent(), true, familiaEnFoco);
                articulosJDialog.setBounds(Herramientas.bondsDeDialogs(this, articulosJDialog));
                articulosJDialog.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "La familia seleccionada no dispone de artículos.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Marque una familia en la tabla sobre la que gestionar los artículos.");
        }

    }//GEN-LAST:event_jbGestionArticuloActionPerformed

    private void jbActualizarTablaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbActualizarTablaActionPerformed
        actualizarTabla();
    }//GEN-LAST:event_jbActualizarTablaActionPerformed

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FamiliaJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FamiliaJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FamiliaJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FamiliaJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FamiliaJDialog dialog = new FamiliaJDialog(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jbGestionArticulo;
    private javax.swing.JButton jbModificar;
    private javax.swing.JScrollPane jspFamilia;
    private javax.swing.JTable jtFamilia;
    private javax.swing.JTextField jtfCodigo;
    private javax.swing.JTextField jtfDescripcion;
    private javax.swing.JTextField jtfNombre;
    // End of variables declaration//GEN-END:variables
}
