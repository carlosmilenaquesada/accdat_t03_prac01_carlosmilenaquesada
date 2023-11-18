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
import modelos.Familias;

public class FamiliasJDialog extends javax.swing.JDialog {

    private Crud crud;

    private DefaultTableModel dtmFamilias;
    private List<Familias> listaFamilias;
    private Familias familiaEnFoco;
    private int rowSeleccionada;

    public FamiliasJDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        initConfiguracion();
    }

    private void initConfiguracion() {
        this.crud = new Crud();
        this.dtmFamilias = (DefaultTableModel) jtFamilias.getModel();
        this.jtFamilias.setCellSelectionEnabled(false);
        this.jtFamilias.setRowSelectionAllowed(true);
        this.familiaEnFoco = null;
        actualizarTabla();
        this.rowSeleccionada = jtFamilias.getSelectedRow();

        this.jtFamilias.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (e.getValueIsAdjusting()) {
                    rowSeleccionada = jtFamilias.getSelectedRow();
                    Object pkRowSeleccionada = jtFamilias.getValueAt(rowSeleccionada, 0);
                    familiaEnFoco = listaFamilias.get(listaFamilias.indexOf(new Familias((String) pkRowSeleccionada)));
                    //Cada vez que selecciono una fila en la tabla Familias,
                    //necesito capturar el objeto Familias seleccionado para poder
                    //editarlo, borrarlo o mostrar sus artículos. Para ello,
                    //me ayudo del listaFamilias.get y listaFamilias.indexOf 
                    //proporcionándoles un new Familias con la pk de la familia
                    //marcada, ya que estos métodos utilizan el equals de la clase
                    //para identificar un elemento dentro de una List, y yo lo 
                    //tengo sobrecargado para que sea el "codFamilia" lo que 
                    //determine la igualdad.
                    actualizarInputsTexto(familiaEnFoco);
                }
            }
        });
    }

    private void actualizarInputsTexto(Familias familiaEnFoco) {
        jtfCodigo.setText(familiaEnFoco.getCodfamilia());
        jtfNombre.setText(familiaEnFoco.getNomfamilia());
        jtfDescripcion.setText(familiaEnFoco.getDescfamilia());
    }


    private void actualizarTabla() {
        listaFamilias = crud.readAll("from Familias f");
        Herramientas.limpiarTabla(dtmFamilias);
        for (Familias f : this.listaFamilias) {
            dtmFamilias.addRow(new Object[]{f.getCodfamilia(), f.getNomfamilia(), f.getDescfamilia(), f.getArticuloses().size()});
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
        jbGestionArticulos = new javax.swing.JButton();
        jcPaneFamilias = new javax.swing.JScrollPane();
        jtFamilias = new javax.swing.JTable();

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

        jbGestionArticulos.setText("Gestionar artículos de la familia");
        jbGestionArticulos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGestionArticulosActionPerformed(evt);
            }
        });

        jtFamilias.setModel(new javax.swing.table.DefaultTableModel(
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
        jtFamilias.setColumnSelectionAllowed(true);
        jtFamilias.getTableHeader().setReorderingAllowed(false);
        jcPaneFamilias.setViewportView(jtFamilias);
        jtFamilias.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

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
                        .addComponent(jbGestionArticulos))
                    .addComponent(jcPaneFamilias))
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
                    .addComponent(jcPaneFamilias, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbGestionArticulos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCrearActionPerformed
        if (!jtfCodigo.getText().isEmpty()) {
            Familias familias = new Familias(jtfCodigo.getText(), jtfNombre.getText(), jtfDescripcion.getText(), null);
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
            Familias familias = new Familias(jtfCodigo.getText(), jtfNombre.getText(), jtfDescripcion.getText());
            if (listaFamilias.contains(familias)) {
                crud.update(familias);
            } else {
                int opcion = JOptionPane.showOptionDialog(null, "No existe una familia con ese código de familia."
                        + " ¿Desea crearla?", "Crear", JOptionPane.YES_NO_CANCEL_OPTION,
                        JOptionPane.QUESTION_MESSAGE, null, null, null);
                if (opcion == 0) {
                    familias.setArticuloses(new HashSet(0));
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

    private void jbGestionArticulosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGestionArticulosActionPerformed
        if (familiaEnFoco != null) {
            if (familiaEnFoco.getArticuloses().size() > 0) {
                ArticulosJDialog articulosJDialog = new ArticulosJDialog((Frame) this.getParent(), true, familiaEnFoco);
                articulosJDialog.setBounds(Herramientas.bondsDeDialogs(this, articulosJDialog));
                articulosJDialog.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "La familia seleccionada no dispone de artículos.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Marque una familia en la tabla sobre la que gestionar los artículos.");
        }

    }//GEN-LAST:event_jbGestionArticulosActionPerformed

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
            java.util.logging.Logger.getLogger(FamiliasJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FamiliasJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FamiliasJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FamiliasJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FamiliasJDialog dialog = new FamiliasJDialog(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jbGestionArticulos;
    private javax.swing.JButton jbModificar;
    private javax.swing.JScrollPane jcPaneFamilias;
    private javax.swing.JTable jtFamilias;
    private javax.swing.JTextField jtfCodigo;
    private javax.swing.JTextField jtfDescripcion;
    private javax.swing.JTextField jtfNombre;
    // End of variables declaration//GEN-END:variables
}
