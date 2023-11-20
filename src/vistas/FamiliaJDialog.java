package vistas;

import controladores.Crud;
import controladores.Herramientas;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import javax.swing.table.DefaultTableModel;
import modelos.Articulo;
import modelos.Familia;

public class FamiliaJDialog extends javax.swing.JDialog {

    private Crud crud;

    private DefaultTableModel dtmFamilia;
    private List<Familia> listaFamilias;
    private Familia familiaEnFoco;

    private DefaultTableModel dtmArticulo;

    public FamiliaJDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        this.crud = new Crud();
        this.listaFamilias = crud.readAllHQL("from Familia f");
        initComponents();
        initConfiguracion();
    }

    private void initConfiguracion() {
        this.dtmFamilia = (DefaultTableModel) jtFamilia.getModel();
        this.dtmArticulo = (DefaultTableModel) jtArticulo.getModel();
        this.jtFamilia.setCellSelectionEnabled(false);
        this.jtArticulo.setCellSelectionEnabled(false);
        this.jtFamilia.setRowSelectionAllowed(true);
        this.jtArticulo.setRowSelectionAllowed(true);
        this.familiaEnFoco = null;
        actualizarTablaFamilias();
        this.jtFamilia.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (e.getValueIsAdjusting()) {
                    familiaEnFoco = listaFamilias.get(jtFamilia.getSelectedRow());
                    actualizarInputsFamilias();
                    actualizarTablaArticulos();
                }
            }
        });

        this.jtArticulo.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (e.getValueIsAdjusting()) {
                    actualizarInputsArticulos();
                }
            }
        });

    }

    private void actualizarInputsFamilias() {
        jtfCodigoFamilia.setText((String) jtFamilia.getValueAt(jtFamilia.getSelectedRow(), 0));
        jtfNombreFamilia.setText((String) jtFamilia.getValueAt(jtFamilia.getSelectedRow(), 1));
        jtfDescripcionFamilia.setText((String) jtFamilia.getValueAt(jtFamilia.getSelectedRow(), 2));
    }

    private void actualizarInputsArticulos() {
        jtfCodigoArticulo.setText((String) jtArticulo.getValueAt(jtArticulo.getSelectedRow(), 0));
        jtfNombreArticulo.setText((String) jtArticulo.getValueAt(jtArticulo.getSelectedRow(), 1));
        jtfPrecioArticulo.setText(jtArticulo.getValueAt(jtArticulo.getSelectedRow(), 2).toString());
    }

    private void actualizarTablaFamilias() {
        Herramientas.limpiarTabla(dtmFamilia);
        for (Familia f : this.listaFamilias) {
            dtmFamilia.addRow(new Object[]{f.getCodFamilia(), f.getNomFamilia(), f.getDescFamilia(), f.getListaArticulos().size()});
        }
        jtfCodigoFamilia.setText("");
        jtfNombreFamilia.setText("");
        jtfDescripcionFamilia.setText("");
        familiaEnFoco = null;
    }

    private void actualizarTablaArticulos() {
        Herramientas.limpiarTabla(dtmArticulo);
        if (familiaEnFoco != null) {
            for (Articulo a : (Set<Articulo>) familiaEnFoco.getListaArticulos()) {
                dtmArticulo.addRow(
                        new Object[]{a.getCodArticulo(),
                            a.getNomArticulo(),
                            a.getPrecioArticulo(),
                            a.getListaFacturas().size()}
                );
            }
        }
        jtfCodigoArticulo.setText("");
        jtfNombreArticulo.setText("");
        jtfPrecioArticulo.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpFamilia = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jtfCodigoFamilia = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jtfNombreFamilia = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jtfDescripcionFamilia = new javax.swing.JTextField();
        jbCrearFamilia = new javax.swing.JButton();
        jbModificarFamilia = new javax.swing.JButton();
        jbBorrarFamilia = new javax.swing.JButton();
        jbActualizar = new javax.swing.JButton();
        jspFamilia = new javax.swing.JScrollPane();
        jtFamilia = new javax.swing.JTable();
        jpArticulo = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jtfCodigoArticulo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jtfNombreArticulo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jtfPrecioArticulo = new javax.swing.JTextField();
        jbCrearArticulo = new javax.swing.JButton();
        jbModificarArticulo = new javax.swing.JButton();
        jbBorrarArticulo = new javax.swing.JButton();
        jspArticulo = new javax.swing.JScrollPane();
        jtArticulo = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gestión de familias");
        setMaximumSize(new java.awt.Dimension(684, 664));
        setMinimumSize(new java.awt.Dimension(684, 664));
        setResizable(false);

        jpFamilia.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Familia", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        jLabel1.setText("Código");

        jLabel2.setText("Nombre");

        jLabel3.setText("Descripción");

        jbCrearFamilia.setText("Crear familia");
        jbCrearFamilia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCrearFamiliaActionPerformed(evt);
            }
        });

        jbModificarFamilia.setText("Modificar familia");
        jbModificarFamilia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbModificarFamiliaActionPerformed(evt);
            }
        });

        jbBorrarFamilia.setText("Eliminar familia");
        jbBorrarFamilia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBorrarFamiliaActionPerformed(evt);
            }
        });

        jbActualizar.setText("Actualizar");
        jbActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbActualizarActionPerformed(evt);
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

        javax.swing.GroupLayout jpFamiliaLayout = new javax.swing.GroupLayout(jpFamilia);
        jpFamilia.setLayout(jpFamiliaLayout);
        jpFamiliaLayout.setHorizontalGroup(
            jpFamiliaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpFamiliaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpFamiliaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jpFamiliaLayout.createSequentialGroup()
                        .addComponent(jbCrearFamilia, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbModificarFamilia, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbBorrarFamilia, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jspFamilia, javax.swing.GroupLayout.PREFERRED_SIZE, 458, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpFamiliaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtfCodigoFamilia)
                    .addGroup(jpFamiliaLayout.createSequentialGroup()
                        .addGroup(jpFamiliaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 46, Short.MAX_VALUE))
                    .addComponent(jtfNombreFamilia)
                    .addComponent(jtfDescripcionFamilia)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpFamiliaLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jbActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jpFamiliaLayout.setVerticalGroup(
            jpFamiliaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpFamiliaLayout.createSequentialGroup()
                .addGroup(jpFamiliaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpFamiliaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jpFamiliaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jbCrearFamilia, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbModificarFamilia, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbBorrarFamilia, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jbActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpFamiliaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jpFamiliaLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfCodigoFamilia, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfNombreFamilia, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfDescripcionFamilia, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jspFamilia, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jpArticulo.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Articulos de la familia", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        jLabel4.setText("Código");

        jLabel5.setText("Nombre");

        jLabel6.setText("Precio");

        jbCrearArticulo.setText("Crear artículo");
        jbCrearArticulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCrearArticuloActionPerformed(evt);
            }
        });

        jbModificarArticulo.setText("Modificar artículo");
        jbModificarArticulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbModificarArticuloActionPerformed(evt);
            }
        });

        jbBorrarArticulo.setText("Eliminar artículo");
        jbBorrarArticulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBorrarArticuloActionPerformed(evt);
            }
        });

        jtArticulo.setModel(new javax.swing.table.DefaultTableModel(
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
        jtArticulo.setColumnSelectionAllowed(true);
        jtArticulo.getTableHeader().setReorderingAllowed(false);
        jspArticulo.setViewportView(jtArticulo);

        javax.swing.GroupLayout jpArticuloLayout = new javax.swing.GroupLayout(jpArticulo);
        jpArticulo.setLayout(jpArticuloLayout);
        jpArticuloLayout.setHorizontalGroup(
            jpArticuloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpArticuloLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpArticuloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpArticuloLayout.createSequentialGroup()
                        .addComponent(jspArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jpArticuloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfCodigoArticulo)
                            .addGroup(jpArticuloLayout.createSequentialGroup()
                                .addGroup(jpArticuloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 52, Short.MAX_VALUE))
                            .addComponent(jtfNombreArticulo)
                            .addComponent(jtfPrecioArticulo))
                        .addContainerGap())
                    .addGroup(jpArticuloLayout.createSequentialGroup()
                        .addComponent(jbCrearArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbModificarArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbBorrarArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jpArticuloLayout.setVerticalGroup(
            jpArticuloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpArticuloLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpArticuloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbCrearArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbModificarArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbBorrarArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jpArticuloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jpArticuloLayout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfCodigoArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfNombreArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfPrecioArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jspArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpArticulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jpFamilia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(336, Short.MAX_VALUE)
                .addComponent(jpArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jpFamilia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(336, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbCrearFamiliaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCrearFamiliaActionPerformed
        if (!jtfCodigoFamilia.getText().isEmpty()) {
            Familia familia = new Familia(jtfCodigoFamilia.getText(), jtfNombreFamilia.getText(), jtfDescripcionFamilia.getText(), null);
            String error = crud.create(familia);
            if (!error.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No se pudo crear la familia."
                        + "\nDescripción del error: " + error);
            } else {
                actualizarTablaFamilias();
                actualizarTablaArticulos();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe proporcionar un código de familia válido.");
        }
    }//GEN-LAST:event_jbCrearFamiliaActionPerformed

    private void jbModificarFamiliaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbModificarFamiliaActionPerformed
        if (!jtfCodigoFamilia.getText().isEmpty()) {
            Familia familias = new Familia(jtfCodigoFamilia.getText(), jtfNombreFamilia.getText(), jtfDescripcionFamilia.getText());
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
            actualizarTablaFamilias();
            actualizarTablaArticulos();
        } else {
            JOptionPane.showMessageDialog(null, "Debe seleccione o escriba un código de familia para iniciar la modificación.");
        }
    }//GEN-LAST:event_jbModificarFamiliaActionPerformed

    private void jbBorrarFamiliaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBorrarFamiliaActionPerformed
        if (!jtfCodigoFamilia.getText().isEmpty()) {
            crud.delete(new Familia(jtfCodigoFamilia.getText()));
            actualizarTablaFamilias();
            actualizarTablaArticulos();
        }
    }//GEN-LAST:event_jbBorrarFamiliaActionPerformed

    private void jbActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbActualizarActionPerformed
        actualizarTablaFamilias();
        actualizarTablaArticulos();
    }//GEN-LAST:event_jbActualizarActionPerformed

    private void jbCrearArticuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCrearArticuloActionPerformed
        if (!jtfCodigoArticulo.getText().isEmpty()) {
            Articulo articulos = null;
            try {
                articulos = new Articulo(
                        jtfCodigoArticulo.getText(),
                        familiaEnFoco,
                        jtfNombreArticulo.getText(),
                        BigDecimal.valueOf((double) new DecimalFormat("0.00").parse(jtfPrecioArticulo.getText())),
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
                    actualizarTablaFamilias();
                    actualizarTablaArticulos();
                }
            }
        }
    }//GEN-LAST:event_jbCrearArticuloActionPerformed

    private void jbModificarArticuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbModificarArticuloActionPerformed
        if (!jtfCodigoArticulo.getText().isEmpty()) {
            try {
                Articulo articulo = new Articulo(jtfCodigoArticulo.getText());
                if (familiaEnFoco.getListaArticulos().contains(articulo)) {
                    articulo.setFamilia(familiaEnFoco);
                    articulo.setNomArticulo(jtfNombreArticulo.getText());
                    articulo.setPrecioArticulo(BigDecimal.valueOf((double) new DecimalFormat("0.00").parse(jtfPrecioArticulo.getText())));
                    crud.update(articulo);
                } else {
                    int opcion = JOptionPane.showOptionDialog(null, "No existe un artículo con ese código de artículo."
                            + " ¿Desea crearlo?", "Crear", JOptionPane.YES_NO_CANCEL_OPTION,
                            JOptionPane.QUESTION_MESSAGE, null, null, null);
                    if (opcion == 0) {
                        articulo.setListaFacturas(new HashSet(0));
                        crud.create(articulo);
                    }
                }
                actualizarTablaFamilias();
                actualizarTablaArticulos();
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(null, "El precio proporcionado no es válido.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Proporcione un código de familia para iniciar la modificación.");
        }
    }//GEN-LAST:event_jbModificarArticuloActionPerformed

    private void jbBorrarArticuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBorrarArticuloActionPerformed
        if (!jtfCodigoArticulo.getText().isEmpty()) {
            String error = crud.delete(new Articulo(jtfCodigoArticulo.getText()));
            if (!error.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No se pudo borrar el artículo."
                        + "\nDescripción del error: " + error);
            } else {
                actualizarTablaFamilias();
                actualizarTablaArticulos();
            }
        }
    }//GEN-LAST:event_jbBorrarArticuloActionPerformed

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
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JButton jbActualizar;
    private javax.swing.JButton jbBorrarArticulo;
    private javax.swing.JButton jbBorrarFamilia;
    private javax.swing.JButton jbCrearArticulo;
    private javax.swing.JButton jbCrearFamilia;
    private javax.swing.JButton jbModificarArticulo;
    private javax.swing.JButton jbModificarFamilia;
    private javax.swing.JPanel jpArticulo;
    private javax.swing.JPanel jpFamilia;
    private javax.swing.JScrollPane jspArticulo;
    private javax.swing.JScrollPane jspFamilia;
    private javax.swing.JTable jtArticulo;
    private javax.swing.JTable jtFamilia;
    private javax.swing.JTextField jtfCodigoArticulo;
    private javax.swing.JTextField jtfCodigoFamilia;
    private javax.swing.JTextField jtfDescripcionFamilia;
    private javax.swing.JTextField jtfNombreArticulo;
    private javax.swing.JTextField jtfNombreFamilia;
    private javax.swing.JTextField jtfPrecioArticulo;
    // End of variables declaration//GEN-END:variables
}
