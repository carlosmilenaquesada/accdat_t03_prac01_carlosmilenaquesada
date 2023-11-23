package vistas;

import controladores.Crud;
import controladores.Herramientas;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import javax.swing.table.DefaultTableModel;
import modelos.Articulos;
import modelos.Familias;

public class FamiliaJDialog extends javax.swing.JDialog {

    private Crud crud;

    private DefaultTableModel dtmFamilia;
    private List<Familias> listaFamilias;
    private Familias familiaEnFoco;

    private DefaultTableModel dtmArticulo;

    public FamiliaJDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        this.crud = new Crud();
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
        actualizarTablas();
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
        jtfFamiliaArticulo.setText((String) jtArticulo.getValueAt(jtArticulo.getSelectedRow(), 0));
        jtfCodigoArticulo.setText((String) jtArticulo.getValueAt(jtArticulo.getSelectedRow(), 1));
        jtfNombreArticulo.setText((String) jtArticulo.getValueAt(jtArticulo.getSelectedRow(), 2));
        jtfPrecioArticulo.setText(jtArticulo.getValueAt(jtArticulo.getSelectedRow(), 3).toString());
    }

    private void actualizarTablas() {
        Herramientas.limpiarTabla(dtmFamilia);
        this.listaFamilias = crud.readAllHQL("from Familias f");
        for (Familias f : this.listaFamilias) {
            dtmFamilia.addRow(new Object[]{f.getCodfamilia(), f.getNomfamilia(), f.getDescfamilia()});
        }
        familiaEnFoco = null;
        jtfCodigoFamilia.setText("");
        jtfNombreFamilia.setText("");
        jtfDescripcionFamilia.setText("");
        actualizarTablaArticulos();
    }

    private void actualizarTablaArticulos() {
        Herramientas.limpiarTabla(dtmArticulo);
        if (familiaEnFoco != null) {
            for (Articulos a : (Set<Articulos>) familiaEnFoco.getArticuloses()) {
                dtmArticulo.addRow(
                        new Object[]{a.getFamilias().getCodfamilia(),
                            a.getCodarticulo(),
                            a.getNomarticulo(),
                            a.getPrecioarticulo()}
                );
            }
        }
        jtfFamiliaArticulo.setText("");
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
        jLabel6 = new javax.swing.JLabel();
        jtfFamiliaArticulo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jtfCodigoArticulo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jtfNombreArticulo = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
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
                "Código", "Nombre", "Descripción"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
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

        jLabel6.setText("Familia");

        jLabel4.setText("Código");

        jLabel5.setText("Nombre");

        jLabel7.setText("Precio");

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
                "Familia", "Código", "Nombre", "Precio"
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
        jtArticulo.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        javax.swing.GroupLayout jpArticuloLayout = new javax.swing.GroupLayout(jpArticulo);
        jpArticulo.setLayout(jpArticuloLayout);
        jpArticuloLayout.setHorizontalGroup(
            jpArticuloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpArticuloLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpArticuloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jspArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpArticuloLayout.createSequentialGroup()
                        .addComponent(jbCrearArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbModificarArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbBorrarArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jpArticuloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtfCodigoArticulo)
                    .addComponent(jtfNombreArticulo)
                    .addComponent(jtfFamiliaArticulo, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                    .addGroup(jpArticuloLayout.createSequentialGroup()
                        .addGroup(jpArticuloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jtfPrecioArticulo))
                .addContainerGap())
        );
        jpArticuloLayout.setVerticalGroup(
            jpArticuloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpArticuloLayout.createSequentialGroup()
                .addGroup(jpArticuloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpArticuloLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jpArticuloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jbCrearArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbModificarArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbBorrarArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpArticuloLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jpArticuloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jpArticuloLayout.createSequentialGroup()
                        .addComponent(jtfFamiliaArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfCodigoArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfNombreArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfPrecioArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jspArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(23, 23, 23))
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
                .addContainerGap(340, Short.MAX_VALUE)
                .addComponent(jpArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jpFamilia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(400, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbCrearFamiliaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCrearFamiliaActionPerformed
        //Compruebo que código de familia que pretendo crear no esté vacío
        if (jtfCodigoFamilia.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe proporcionar un código de familia.");
            return;
        }
        //Creo la familia nueva con todos sus campos. En este momento, al ser familia nueva, no tiene ningún artículo.
        Familias familia = new Familias(jtfCodigoFamilia.getText(), jtfNombreFamilia.getText(), jtfDescripcionFamilia.getText(), new HashSet(0));
        //Compruebo que no existiera previamente esa familia.
        if (listaFamilias.contains(familia)) {
            JOptionPane.showMessageDialog(null, "No se puede crear la familia porque ya existe una familia con ese código.");
            return;
        }
        //Inicio la creación
        String error = crud.create(familia);
        //Si "error" no está vacío, es que ha ocurrido un error al crear.
        if (!error.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No se pudo crear la familia." + "\nDescripción del error: " + error);
            return;
        }
        //Si "error" está vacío, es que todo ha ido bien, así que actualizo las tablas de la vista
        actualizarTablas();


        /*if (!jtfCodigoFamilia.getText().isEmpty()) {
            Familias familia = new Familias(jtfCodigoFamilia.getText());
            if (listaFamilias.contains(familia)) {
                JOptionPane.showMessageDialog(null, "No se puede crear la familia porque ya existe una familia con ese código.");
            } else {
                familia.setNomfamilia(jtfNombreFamilia.getText());
                familia.setDescfamilia(jtfDescripcionFamilia.getText());
                familia.setArticuloses(new HashSet(0));
                String error = crud.create(familia);
                if (!error.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "No se pudo crear la familia."
                            + "\nDescripción del error: " + error);
                } else {
                    actualizarTablas();
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe proporcionar un código de familia.");
        }*/
    }//GEN-LAST:event_jbCrearFamiliaActionPerformed

    private void jbModificarFamiliaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbModificarFamiliaActionPerformed
        //Compruebo que código de familia que pretendo modificar no esté vacío
        if (jtfCodigoFamilia.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe proporcionar un código de familia.");
            return;
        }
        //Compruebo que el código de familia proporcionado corresponda a una familia que ya exista
        int indexFamilia = listaFamilias.indexOf(new Familias(jtfFamiliaArticulo.getText()));
        if (indexFamilia == -1) {
            JOptionPane.showMessageDialog(null, "La familia proporcionada no existe.");
            return;
        }
        ///Si la familia existe, la tomo en una variable de tránsito para trabajar más comodamente
        Familias familia = listaFamilias.get(indexFamilia);

        //Le modifico los campos oportunos (excepto la colección de artículos 'articuloses', eso no cambiará)
        familia.setNomfamilia(jtfNombreFamilia.getText());
        familia.setDescfamilia(jtfDescripcionFamilia.getText());
        //Actualizo la familia
        String error = crud.update(familia);
        //Si "error" no está vacío, es que ha ocurrido un error al modificar.
        if (!error.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No se pudo modificar la familia." + "\nDescripción del error: " + error);
            return;
        }
        //Si "error" está vacío, es que todo ha ido bien, así que actualizo las tablas de la vista
        actualizarTablas();


        /*if (!jtfCodigoFamilia.getText().isEmpty()) {
            Familias familia = new Familias(jtfCodigoFamilia.getText());
            if (listaFamilias.contains(familia)) {
                familia.setNomfamilia(jtfNombreFamilia.getText());
                familia.setDescfamilia(jtfDescripcionFamilia.getText());
                String error = crud.update(familia);
                if (!error.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "No se pudo actualizar la familia."
                            + "\nDescripción del error: " + error);
                } else {
                    actualizarTablas();
                }
            } else {
                JOptionPane.showMessageDialog(null, "No existe un artículo en la lista con el código proporcionado.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe proporcionar un código de artículo.");
        }*/
    }//GEN-LAST:event_jbModificarFamiliaActionPerformed

    private void jbBorrarFamiliaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBorrarFamiliaActionPerformed
        //Intento borrar la familia con el código proporcionado
        String error = crud.delete(new Familias(jtfCodigoFamilia.getText()));
        //Si "error" no está vacío, es que ha ocurrido un error al borrar (probablemente la familia no exista)
        if (!error.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No se pudo borrar la familia." + "\nDescripción del error: " + error);
            return;
        }
        //Si "error" está vacío, es que todo ha ido bien, así que actualizo las tablas de la vista
        actualizarTablas();
        /*if (!jtfCodigoFamilia.getText().isEmpty()) {
            Familias familia = new Familias(jtfCodigoFamilia.getText());
            String error = crud.delete(familia);
            if (!error.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No se pudo borrar la familia."
                        + "\nDescripción del error: " + error);
            } else {
                actualizarTablas();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe proporcionar un código de familia.");
        }*/

    }//GEN-LAST:event_jbBorrarFamiliaActionPerformed

    private void jbActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbActualizarActionPerformed
        actualizarTablas();

    }//GEN-LAST:event_jbActualizarActionPerformed

    private void jbCrearArticuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCrearArticuloActionPerformed
        //Compruebo que el campo de código no esté vacío el código del artículo que pretendo modificar
        if (jtfCodigoArticulo.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe proporcionar un código de cliente.");
            return;
        }

        //Compruebo que el código de familia proporcionado para el nuevo producto corresponda con una familia que ya exista
        int indexFamilia = listaFamilias.indexOf(new Familias(jtfFamiliaArticulo.getText()));
        if (indexFamilia == -1) {
            JOptionPane.showMessageDialog(null, "La familia proporcionada no existe.");
            return;
        }
        ///Si la familia existe, la tomo en una variable de tránsito para trabajar más comodamente
        Familias familia = listaFamilias.get(indexFamilia);
        //Creo el artículo nuevo con todos sus campos. En este momento, al ser artículo nuevo, no tiene ninguna factura.
        Articulos articulo;
        try {
            articulo = new Articulos(jtfCodigoArticulo.getText(), familia, jtfNombreArticulo.getText(), BigDecimal.valueOf(new DecimalFormat("0.00").parse(jtfPrecioArticulo.getText()).doubleValue()), new HashSet(0));
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "El precio proporcionado no tiene un formato válido.");
            return;
        }
        //Añado el nuevo artículo a la colección de artículos de la familia, y la actualizo (por bidireccionalidad, también podría haber guardado con save el artículo directamente y obtendría el mismo resultado)
        familia.getArticuloses().add(articulo);
        String error = crud.update(listaFamilias.get(indexFamilia));
        //Si "error" no está vacío, es que ha ocurrido un error al crear (probablemente el artículo ya exista)
        if (!error.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No se pudo crear el artículo." + "\nDescripción del error: " + error);
            return;
        }
        //Si "error" está vacío, es que todo ha ido bien, así que actualizo las tablas de la vista
        actualizarTablas();

        /*if (!jtfCodigoArticulo.getText().isEmpty()) {
            Articulos articulo = (Articulos) crud.read(Articulos.class, jtfCodigoArticulo.getText());
            if (articulo != null) {
                JOptionPane.showMessageDialog(null, "No se puede crear el artículo porque ya existe un artículo con ese código.");
            } else {
                try {
                    Familias f = (Familias) crud.read(Familias.class, jtfFamiliaArticulo.getText());
                    if (f != null) {
                        articulo = new Articulos(jtfCodigoArticulo.getText(), f, jtfNombreArticulo.getText(), BigDecimal.valueOf(new DecimalFormat("0.00").parse(jtfPrecioArticulo.getText()).doubleValue()), new HashSet(0));
                        f.getArticuloses().add(articulo);
                        String error = crud.update(f);
                        if (!error.isEmpty()) {
                            JOptionPane.showMessageDialog(null, "No se pudo crear el artículo."
                                    + "\nDescripción del error: " + error);
                        } else {
                            actualizarTablas();
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "La familia proporcionada no es válida.");
                    }

                } catch (ParseException ex) {
                    JOptionPane.showMessageDialog(null, "El precio proporcionado no es válido.");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe proporcionar un código de cliente.");
        }*/
    }//GEN-LAST:event_jbCrearArticuloActionPerformed

    private void jbModificarArticuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbModificarArticuloActionPerformed
        //Compruebo que el campo de código del artículo que pretendo modificar no esté vacío
        if (jtfCodigoArticulo.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe proporcionar un código de artículo.");
            return;
        }
        //Creo un artículo auxiliar con ese código, con el que voy a trabajar
        Articulos articulo = new Articulos(jtfCodigoArticulo.getText());
        try {
            //Asigno el nuevo valor de precio
            articulo.setPrecioarticulo(BigDecimal.valueOf(new DecimalFormat("0.00").parse(jtfPrecioArticulo.getText()).doubleValue()));
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "El precio proporcionado no tiene un formato válido.");
            return;
        }
        //Compruebo que el código de nueva familia proporcionado corresponda con una familia que ya exista
        int indexFamilia = listaFamilias.indexOf(new Familias(jtfFamiliaArticulo.getText()));
        if (indexFamilia == -1) {
            JOptionPane.showMessageDialog(null, "La familia proporcionada no es válida.");
            return;
        }
        //Si la familia existe, se la asigno al nuevo valor de familia del artículo , apoyándome en el index conseguido en el paso anterior
        articulo.setFamilias(listaFamilias.get(indexFamilia));
        //Asigno el nuevo nombre al artículo
        articulo.setNomarticulo(jtfNombreArticulo.getText());
        //Actualizo el artículo
        String error = crud.update(articulo);
        //Si "error" no está vacío, es que ha ocurrido un error al borrar (probablemente el artículo no exista)
        if (!error.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No se pudo modificar el artículo." + "\nDescripción del error: " + error);
            return;
        }
        //Si "error" está vacío, es que todo ha ido bien, así que actualizo las tablas de la vista
        actualizarTablas();


        /*
//Tomo el código del artículo que pretendo modificar
        if (!jtfCodigoArticulo.getText().isEmpty()) {
            //Creo un artículo auxiliar con ese código
            Articulos articulo = new Articulos(jtfCodigoArticulo.getText());
            try {
                //Asigno el nuevo valor de precio (si el precio proporcionado no cumple, la excepción detiene el proceso)
                articulo.setPrecioarticulo(BigDecimal.valueOf((Double) new DecimalFormat("0.00").parse(jtfPrecioArticulo.getText())));
                //Creo una familia auxiliar con el código de familia proporcionado, y compruebo que exista en la lista de familias inicialmente cargada (que contiene todas las familias)
                Familias familia = new Familias(jtfFamiliaArticulo.getText());
                int indexFamilia = listaFamilias.indexOf(familia);
                if (indexFamilia != -1) {
                    //Si la familia existe, se la asigno al nuevo valor de familia del artículo , apoyándome en el index conseguido en el paso anterior
                    articulo.setFamilias(listaFamilias.get(indexFamilia));
                    //Asigno el nuevo nombre al artículo
                    articulo.setNomarticulo(jtfNombreArticulo.getText());
                    //Actualizo el artículo
                    String error = crud.update(articulo);
                    //Si "error" no está vacío, es que ha ocurrido un error al borrar (probablemente el artículo no exista)
                    if (!error.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "No se pudo actualizar el artículo."
                                + "\nDescripción del error: " + error);
                    } else {
                        //Si "error" está vacío, es que todo ha ido bien, así que actualizo las tablas de la vista
                        actualizarTablas();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "La familia proporcionada no es válida.");
                }
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(null, "El precio proporcionado no es válido.");
            }

        } else {
            JOptionPane.showMessageDialog(null, "Debe proporcionar un código de artículo.");
        }*/
    }//GEN-LAST:event_jbModificarArticuloActionPerformed

    private void jbBorrarArticuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBorrarArticuloActionPerformed
        //Intento borrar el artículo con el código proporcionado
        String error = crud.delete(new Articulos(jtfCodigoArticulo.getText()));
        //Si "error" no está vacío, es que ha ocurrido un error al borrar (probablemente el artículo no exista)
        if (!error.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No se pudo borrar el artículo." + "\nDescripción del error: " + error);
            return;
        }
        //Si "error" está vacío, es que todo ha ido bien, así que actualizo las tablas de la vista
        actualizarTablas();

        /*//Tomo el código del artículo que pretendo borrar
        if (!jtfCodigoArticulo.getText().isEmpty()) {
            //Creo un artículo auxiliar con ese código
            Articulos articulo = new Articulos(jtfCodigoArticulo.getText());
            
            String error = crud.delete(articulo);
           
            if (!error.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No se pudo borrar el artículo."
                        + "\nDescripción del error: " + error);
            } else {
                //Si "error" está vacío, es que todo ha ido bien, así que actualizo las tablas de la vista
                actualizarTablas();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe proporcionar un código de artículo para borrar.");
        }*/
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
    private javax.swing.JLabel jLabel7;
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
    private javax.swing.JTextField jtfFamiliaArticulo;
    private javax.swing.JTextField jtfNombreArticulo;
    private javax.swing.JTextField jtfNombreFamilia;
    private javax.swing.JTextField jtfPrecioArticulo;
    // End of variables declaration//GEN-END:variables
}
