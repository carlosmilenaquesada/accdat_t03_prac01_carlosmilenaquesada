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
        this.dtmFamilias = (DefaultTableModel) jTableFamilias.getModel();
        this.jTableFamilias.setCellSelectionEnabled(false);
        this.jTableFamilias.setRowSelectionAllowed(true);
        this.familiaEnFoco = null;
        this.listaFamilias = crud.readAll("from Familias f");
        rellenarTablaFamilias();
        this.rowSeleccionada = -1;

        this.jTableFamilias.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (e.getValueIsAdjusting()) {
                    rowSeleccionada = jTableFamilias.getSelectedRow();
                    Object pkRowSeleccionada = jTableFamilias.getValueAt(rowSeleccionada, 0);
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
        jTextFieldCodigo.setText(familiaEnFoco.getCodfamilia());
        jTextFieldNombre.setText(familiaEnFoco.getNomfamilia());
        jTextFieldDescripcion.setText(familiaEnFoco.getDescfamilia());
    }

    private void rellenarTablaFamilias() {
        for (Familias f : this.listaFamilias) {
            dtmFamilias.addRow(new Object[]{f.getCodfamilia(), f.getNomfamilia(), f.getDescfamilia(), f.getArticuloses().size()});
        }
    }

    private void actualizarTabla() {
        listaFamilias = crud.readAll("from Familias f");
        Herramientas.limpiarTabla(dtmFamilias);
        rellenarTablaFamilias();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonBorrar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldCodigo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldNombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldDescripcion = new javax.swing.JTextField();
        jButtonCrear = new javax.swing.JButton();
        jButtonModificar = new javax.swing.JButton();
        jButtonGestionArticulos = new javax.swing.JButton();
        jButtonActualizarTabla = new javax.swing.JButton();
        jScrollPaneFamilias = new javax.swing.JScrollPane();
        jTableFamilias = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gestión de familias");

        jButtonBorrar.setText("Eliminar familia");
        jButtonBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBorrarActionPerformed(evt);
            }
        });

        jLabel1.setText("Código");

        jLabel2.setText("Nombre");

        jLabel3.setText("Descripción");

        jButtonCrear.setText("Crear familia");
        jButtonCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCrearActionPerformed(evt);
            }
        });

        jButtonModificar.setText("Modificar familia");
        jButtonModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModificarActionPerformed(evt);
            }
        });

        jButtonGestionArticulos.setText("Gestionar artículos de la familia");
        jButtonGestionArticulos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGestionArticulosActionPerformed(evt);
            }
        });

        jButtonActualizarTabla.setText("Actualizar tabla");
        jButtonActualizarTabla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonActualizarTablaActionPerformed(evt);
            }
        });

        jTableFamilias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nombre", "Descripción", "Cantidad artículos"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableFamilias.setColumnSelectionAllowed(true);
        jTableFamilias.getTableHeader().setReorderingAllowed(false);
        jScrollPaneFamilias.setViewportView(jTableFamilias);
        jTableFamilias.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonCrear)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonModificar)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonBorrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonGestionArticulos))
                    .addComponent(jScrollPaneFamilias))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldCodigo)
                    .addComponent(jTextFieldNombre)
                    .addComponent(jTextFieldDescripcion)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jButtonActualizarTabla))
                        .addGap(0, 117, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonActualizarTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPaneFamilias, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonGestionArticulos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCrearActionPerformed
        if (!jTextFieldCodigo.getText().isEmpty()) {
            Familias familias = new Familias(jTextFieldCodigo.getText(), jTextFieldNombre.getText(), jTextFieldDescripcion.getText(), null);
            String error = crud.create(familias);
            if (!error.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No se pudo completar la operación."
                        + "\nDescripción del error: " + error);
            } else {
                actualizarTabla();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe proporcionar un código de familia válido.");
        }
    }//GEN-LAST:event_jButtonCrearActionPerformed

    private void jButtonModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModificarActionPerformed
        if (!jTextFieldCodigo.getText().isEmpty()) {
            Familias familias = new Familias(jTextFieldCodigo.getText(), jTextFieldNombre.getText(), jTextFieldDescripcion.getText());
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
    }//GEN-LAST:event_jButtonModificarActionPerformed

    private void jButtonBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBorrarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonBorrarActionPerformed

    private void jButtonGestionArticulosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGestionArticulosActionPerformed
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

    }//GEN-LAST:event_jButtonGestionArticulosActionPerformed

    private void jButtonActualizarTablaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonActualizarTablaActionPerformed
        actualizarTabla();
    }//GEN-LAST:event_jButtonActualizarTablaActionPerformed

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
    private javax.swing.JButton jButtonActualizarTabla;
    private javax.swing.JButton jButtonBorrar;
    private javax.swing.JButton jButtonCrear;
    private javax.swing.JButton jButtonGestionArticulos;
    private javax.swing.JButton jButtonModificar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPaneFamilias;
    private javax.swing.JTable jTableFamilias;
    private javax.swing.JTextField jTextFieldCodigo;
    private javax.swing.JTextField jTextFieldDescripcion;
    private javax.swing.JTextField jTextFieldNombre;
    // End of variables declaration//GEN-END:variables
}
