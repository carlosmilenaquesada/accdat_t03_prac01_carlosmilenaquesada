package vistas;

import controladores.Crud;
import controladores.Herramientas;
import java.math.BigDecimal;
import java.sql.Date;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import javax.swing.table.DefaultTableModel;
import modelos.Articulos;
import modelos.Clientes;
import modelos.Facturas;

public class FacturaJDialog extends javax.swing.JDialog {

    private Crud crud;

    private DefaultTableModel dtmFactura;
    private List<Facturas> listaFacturas;
    private Facturas facturaEnFoco;

    private DefaultTableModel dtmLineaFactura;

    public FacturaJDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        this.crud = new Crud();
        initComponents();
        initConfiguracion();
    }

    private void initConfiguracion() {
        this.dtmFactura = (DefaultTableModel) jtFactura.getModel();
        this.dtmLineaFactura = (DefaultTableModel) jtLineaFactura.getModel();
        this.jtFactura.setCellSelectionEnabled(false);
        this.jtLineaFactura.setCellSelectionEnabled(false);
        this.jtFactura.setRowSelectionAllowed(true);
        this.jtLineaFactura.setRowSelectionAllowed(true);
        this.facturaEnFoco = null;
        actualizarTablas();
        this.jtFactura.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (e.getValueIsAdjusting()) {
                    facturaEnFoco = listaFacturas.get(jtFactura.getSelectedRow());
                    actualizarInputsFacturas();
                    actualizarTablaLineaFacturas();
                }
            }
        });

        this.jtLineaFactura.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (e.getValueIsAdjusting()) {
                    actualizarInputsLineaFacturas();
                }
            }
        });
    }

    private void actualizarInputsFacturas() {
        jtfNumeroFactura.setText(facturaEnFoco.getNumfactura().toString());
        jtfCodigoCliente.setText(facturaEnFoco.getClientes().getCodcliente());
        jtfFechaFactura.setText(new SimpleDateFormat("dd-MM-yyyy").format(facturaEnFoco.getFechafactura()));
    }

    private void actualizarInputsLineaFacturas() {
        jtfNumeroFacturaLinea.setText(jtLineaFactura.getValueAt(jtLineaFactura.getSelectedRow(), 0).toString());
        jtfCodigoArticuloLinea.setText((String) jtLineaFactura.getValueAt(jtLineaFactura.getSelectedRow(), 1));

    }

    private void actualizarTablas() {
        Herramientas.limpiarTabla(dtmFactura);
        this.listaFacturas = crud.readAllHQL("from Facturas f");
        for (Facturas f : this.listaFacturas) {
            dtmFactura.addRow(new Object[]{f.getNumfactura(), f.getClientes().getCodcliente(), new SimpleDateFormat("dd-MM-yyyy").format(f.getFechafactura())});
        }
        facturaEnFoco = null;
        jtfNumeroFactura.setText("");
        jtfCodigoCliente.setText("");
        jtfFechaFactura.setText("");
        actualizarTablaLineaFacturas();
    }

    private void actualizarTablaLineaFacturas() {
        Herramientas.limpiarTabla(dtmLineaFactura);
        if (facturaEnFoco != null) {
            for (Articulos a : (Set<Articulos>) facturaEnFoco.getArticuloses()) {
                dtmLineaFactura.addRow(
                        new Object[]{facturaEnFoco.getNumfactura(), a.getCodarticulo()});
            }
        }
        jtfNumeroFacturaLinea.setText("");
        jtfCodigoArticuloLinea.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpFactura = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jtfNumeroFactura = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jtfCodigoCliente = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jtfFechaFactura = new javax.swing.JTextField();
        jbCrearFactura = new javax.swing.JButton();
        jbModificarFactura = new javax.swing.JButton();
        jbBorrarFactura = new javax.swing.JButton();
        jbActualizar = new javax.swing.JButton();
        jspFactura = new javax.swing.JScrollPane();
        jtFactura = new javax.swing.JTable();
        jpLineaFactura = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jtfNumeroFacturaLinea = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jtfCodigoArticuloLinea = new javax.swing.JTextField();
        jbCrearLineaFactura = new javax.swing.JButton();
        jbBorrarLineaFactura = new javax.swing.JButton();
        jspLineaFactura = new javax.swing.JScrollPane();
        jtLineaFactura = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gestión de facturas");
        setMaximumSize(new java.awt.Dimension(684, 664));
        setMinimumSize(new java.awt.Dimension(684, 664));
        setResizable(false);

        jpFactura.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Factura", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        jLabel1.setText("Número factura");

        jLabel2.setText("Código cliente");

        jLabel3.setText("Fecha factura");

        jbCrearFactura.setText("Crear factura");
        jbCrearFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCrearFacturaActionPerformed(evt);
            }
        });

        jbModificarFactura.setText("Modificar factura");
        jbModificarFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbModificarFacturaActionPerformed(evt);
            }
        });

        jbBorrarFactura.setText("Eliminar factura");
        jbBorrarFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBorrarFacturaActionPerformed(evt);
            }
        });

        jbActualizar.setText("Actualizar");
        jbActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbActualizarActionPerformed(evt);
            }
        });

        jtFactura.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Número factura", "Código cliente", "Fecha factura"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtFactura.setColumnSelectionAllowed(true);
        jtFactura.getTableHeader().setReorderingAllowed(false);
        jspFactura.setViewportView(jtFactura);
        jtFactura.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        javax.swing.GroupLayout jpFacturaLayout = new javax.swing.GroupLayout(jpFactura);
        jpFactura.setLayout(jpFacturaLayout);
        jpFacturaLayout.setHorizontalGroup(
            jpFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpFacturaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jpFacturaLayout.createSequentialGroup()
                        .addComponent(jbCrearFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbModificarFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbBorrarFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jspFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 458, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtfNumeroFactura)
                    .addGroup(jpFacturaLayout.createSequentialGroup()
                        .addGroup(jpFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 46, Short.MAX_VALUE))
                    .addComponent(jtfCodigoCliente)
                    .addComponent(jtfFechaFactura)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpFacturaLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jbActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jpFacturaLayout.setVerticalGroup(
            jpFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpFacturaLayout.createSequentialGroup()
                .addGroup(jpFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpFacturaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jpFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jbCrearFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbModificarFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbBorrarFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jbActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jpFacturaLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfNumeroFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfCodigoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfFechaFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jspFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jpLineaFactura.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Líneas de la factura", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        jLabel4.setText("Número factura");

        jLabel5.setText("Código artículo");

        jbCrearLineaFactura.setText("Crear línea");
        jbCrearLineaFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCrearLineaFacturaActionPerformed(evt);
            }
        });

        jbBorrarLineaFactura.setText("Eliminar línea");
        jbBorrarLineaFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBorrarLineaFacturaActionPerformed(evt);
            }
        });

        jtLineaFactura.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Número factura", "Código artículo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtLineaFactura.setColumnSelectionAllowed(true);
        jtLineaFactura.getTableHeader().setReorderingAllowed(false);
        jspLineaFactura.setViewportView(jtLineaFactura);
        jtLineaFactura.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        javax.swing.GroupLayout jpLineaFacturaLayout = new javax.swing.GroupLayout(jpLineaFactura);
        jpLineaFactura.setLayout(jpLineaFacturaLayout);
        jpLineaFacturaLayout.setHorizontalGroup(
            jpLineaFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpLineaFacturaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpLineaFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpLineaFacturaLayout.createSequentialGroup()
                        .addComponent(jspLineaFactura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jpLineaFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfNumeroFacturaLinea)
                            .addComponent(jtfCodigoArticuloLinea)
                            .addGroup(jpLineaFacturaLayout.createSequentialGroup()
                                .addGroup(jpLineaFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 52, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(jpLineaFacturaLayout.createSequentialGroup()
                        .addComponent(jbCrearLineaFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbBorrarLineaFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jpLineaFacturaLayout.setVerticalGroup(
            jpLineaFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpLineaFacturaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpLineaFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbCrearLineaFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbBorrarLineaFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jpLineaFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpLineaFacturaLayout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfNumeroFacturaLinea, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfCodigoArticuloLinea, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jspLineaFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpLineaFactura, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jpFactura, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(336, Short.MAX_VALUE)
                .addComponent(jpLineaFactura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jpFactura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(336, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbCrearFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCrearFacturaActionPerformed
        //Compruebo que código de factura que pretendo crear no esté vacío
        if (jtfNumeroFactura.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe proporcionar un número de factura.");
            return;
        }
        //Creo la factura, a la que le asigno el número de factura
        Facturas factura;
        try {
            factura = new Facturas(BigDecimal.valueOf(new DecimalFormat("0").parse(jtfNumeroFactura.getText()).longValue()));
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "El número de factura proporcionado no tiene un formato válido.");
            return;
        }
        //Compruebo que no existiera previamente esa factura, para detener o no el proceso.
        if (listaFacturas.contains(factura)) {
            JOptionPane.showMessageDialog(null, "No se puede crear la factura porque ya existe una factura con ese código.");
            return;
        }
        //Añado el resto de atributos
        Clientes cliente = (Clientes) crud.read(Clientes.class, jtfCodigoCliente.getText());
        if (cliente == null) {
            JOptionPane.showMessageDialog(null, "El cliente proporcionado no existe.");
            return;
        }
        factura.setClientes(cliente);
        try {
            factura.setFechafactura(new SimpleDateFormat("dd-MM-yyyy").parse(jtfFechaFactura.getText()));
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "El fecha de factura proporcionada no tiene un formato válido.");
            return;
        }
        //Los artículos de la factura, en este momento están vacíos
        factura.setArticuloses(new HashSet(0));
        //Inicio la creación
        String error = crud.create(factura);
        //Si "error" no está vacío, es que ha ocurrido un error al crear.
        if (!error.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No se pudo crear la factura." + "\nDescripción del error: " + error);
            return;
        }
        //Si "error" está vacío, es que todo ha ido bien, así que actualizo las tablas de la vista
        actualizarTablas();

        /*  if (!jtfNumeroFactura.getText().isEmpty()) {
            try {
                Facturas factura = new Facturas(
                        ((BigDecimal) crud.readMaxValueCRITERIA(Facturas.class, "numFactura")).add(BigDecimal.ONE),
                        (Clientes) crud.read(Clientes.class, jtfCodigoCliente.getText()),
                        new SimpleDateFormat("dd-MM-yyyy").parse(jtfFechaFactura.getText()),
                        new HashSet(0)
                );
                String error = crud.create(factura);
                if (!error.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "No se pudo crear la factura."
                            + "\nDescripción del error: " + error);
                } else {
                    actualizarTablas();
                    actualizarTablaLineaFacturas();
                }
            } catch (ParseException ex) {
                Logger.getLogger(FacturaJDialog.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe proporcionar un código de factura válido.");
        }*/
    }//GEN-LAST:event_jbCrearFacturaActionPerformed

    private void jbModificarFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbModificarFacturaActionPerformed
        //Compruebo que número de factura que pretendo modificar no esté vacío
        if (jtfNumeroFactura.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe proporcionar un número de factura.");
            return;
        }
        //Compruebo que el código de factura proporcionado corresponda a una factura que ya exista
        int indexFactura = -1;
        try {
            indexFactura = listaFacturas.indexOf(new Facturas((BigDecimal.valueOf(new DecimalFormat("0").parse(jtfNumeroFactura.getText()).longValue()))));
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "El número de factura proporcionado no tiene un formato válido.");
            return;
        }
        if (indexFactura == -1) {
            JOptionPane.showMessageDialog(null, "La factura proporcionada no existe.");
            return;
        }
        ///Si la factura existe, la tomo en una variable de tránsito para trabajar más comodamente
        Facturas factura = listaFacturas.get(indexFactura);

        //Le modifico los campos oportunos (excepto la colección de artículos 'articuloses', eso no cambiará)
        Clientes cliente = (Clientes) crud.read(Clientes.class, jtfCodigoCliente.getText());
        if (cliente == null) {
            JOptionPane.showMessageDialog(null, "El cliente proporcionado no existe.");
            return;
        }
        factura.setClientes(cliente);
        try {
            factura.setFechafactura(new SimpleDateFormat("dd-MM-yyyy").parse(jtfFechaFactura.getText()));
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "El fecha de factura proporcionada no tiene un formato válido.");
            return;
        }
        //Actualizo la factura
        String error = crud.update(factura);
        //Si "error" no está vacío, es que ha ocurrido un error al modificar.
        if (!error.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No se pudo modificar la factura." + "\nDescripción del error: " + error);
            return;
        }
        //Si "error" está vacío, es que todo ha ido bien, así que actualizo las tablas de la vista
        actualizarTablas();

        /*  
        if (!jtfNumeroFactura.getText().isEmpty()) {
            try {
                Facturas factura = new Facturas(
                        BigDecimal.valueOf(Long.valueOf(jtfNumeroFactura.getText())),
                        (Clientes) crud.read(Clientes.class, jtfCodigoCliente.getText()),
                        new SimpleDateFormat("dd-MM-yyyy").parse(jtfFechaFactura.getText()),
                        facturaEnFoco.getArticuloses()
                );
                if (listaFacturas.contains(factura)) {
                    crud.update(factura);
                } else {
                    int opcion = JOptionPane.showOptionDialog(null, "No existe una factura con ese código de factura."
                            + " ¿Desea crearla?", "Crear", JOptionPane.YES_NO_CANCEL_OPTION,
                            JOptionPane.QUESTION_MESSAGE, null, null, null);
                    if (opcion == 0) {
                        factura.setArticuloses(new HashSet(0));
                        crud.create(factura);
                    }
                }
                actualizarTablas();
                actualizarTablaLineaFacturas();
            } catch (ParseException ex) {
                Logger.getLogger(FacturaJDialog.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe seleccione o escriba un código de factura para iniciar la modificación.");
        }*/
    }//GEN-LAST:event_jbModificarFacturaActionPerformed

    private void jbBorrarFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBorrarFacturaActionPerformed

        String error = "";
        try {
            //Intento borrar la factura con el código proporcionado
            error = crud.delete(new Facturas((BigDecimal.valueOf(new DecimalFormat("0").parse(jtfNumeroFactura.getText()).longValue()))));
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "El número de factura proporcionado no tiene un formato válido.");
            return;
        }
        //Si "error" no está vacío, es que ha ocurrido un error al borrar (probablemente la familia no exista)
        if (!error.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No se pudo borrar la familia." + "\nDescripción del error: " + error);
            return;
        }
        //Si "error" está vacío, es que todo ha ido bien, así que actualizo las tablas de la vista
        actualizarTablas();
    }//GEN-LAST:event_jbBorrarFacturaActionPerformed

    private void jbActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbActualizarActionPerformed
        actualizarTablas();
    }//GEN-LAST:event_jbActualizarActionPerformed

    private void jbCrearLineaFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCrearLineaFacturaActionPerformed
        //Compruebo que el código de artículo y número de factura proporcionados no estén vacíos
        if (jtfCodigoArticuloLinea.getText().isEmpty() || jtfNumeroFacturaLinea.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe proporcionar un código de artículo y un número de factura.");
            return;
        }
        //Obtengo el artículo que usaré en la pk compuesta de la fila insertada
        Articulos articulo = (Articulos) crud.read(Articulos.class, jtfCodigoArticuloLinea.getText());
        if (articulo == null) {
            JOptionPane.showMessageDialog(null, "No existe un artículo con el código proporcionado.");
            return;
        }
        //Obtengo la factura que usaré en la pk compuesta de la fila insertada
        Facturas factura;
        try {
            factura = (Facturas) crud.read(Facturas.class, BigDecimal.valueOf(Long.valueOf(jtfNumeroFacturaLinea.getText())));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "El número de factura proporcionado no tiene un formato válido.");
            return;
        }
        if (factura == null) {
            JOptionPane.showMessageDialog(null, "No existe una factura con el número proporcionado.");
            return;
        }
        if (articulo.getFacturases().contains(factura)) {
            JOptionPane.showMessageDialog(null, "Ya existe una línea con ese mismo artículo para la factura proporcionada");
            return;
        }
        //Añado el artículo a la factura, usando el méotodo 'add' personalizado, que también añade la factura al artículo.
        factura.addArticulo(articulo);
        //actualizo el master(artículo)
        String error = crud.update(articulo);
        //Si "error" no está vacío, es que ha ocurrido un error al borrar (probablemente la familia no exista)
        if (!error.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No se pudo crear la línea de factura." + "\nDescripción del error: " + error);
            return;
        }
        //Si "error" está vacío, es que todo ha ido bien, así que actualizo las tablas de la vista
        actualizarTablas();

    }//GEN-LAST:event_jbCrearLineaFacturaActionPerformed

    private void jbBorrarLineaFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBorrarLineaFacturaActionPerformed
        //Compruebo que el código de artículo y número de factura proporcionados no estén vacíos
        if (jtfCodigoArticuloLinea.getText().isEmpty() || jtfNumeroFacturaLinea.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe proporcionar un código de artículo y un número de factura.");
            return;
        }
        //Obtengo el artículo que usaré en la pk compuesta de la fila insertada
        Articulos articulo = (Articulos) crud.read(Articulos.class, jtfCodigoArticuloLinea.getText());
        if (articulo == null) {
            JOptionPane.showMessageDialog(null, "No existe un artículo con el código proporcionado.");
            return;
        }
        //Obtengo la factura que usaré en la pk compuesta de la fila insertada
        Facturas factura;
        try {
            factura = (Facturas) crud.read(Facturas.class, BigDecimal.valueOf(Long.valueOf(jtfNumeroFacturaLinea.getText())));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "El número de factura proporcionado no tiene un formato válido.");
            return;
        }
        if (factura == null) {
            JOptionPane.showMessageDialog(null, "No existe una factura con el número proporcionado.");
            return;
        }
        if (!articulo.getFacturases().contains(factura)) {
            JOptionPane.showMessageDialog(null, "No existe una línea con ese artículo para la factura proporcionada");
            return;
        }
        //Borro el artículo a la factura, usando el méotodo 'remove' personalizado, que también borra la factura del artículo.
        factura.removeArticulo(articulo);
        //En este caso, para que funcione, hay que actualizar el slave(factura)
        String error = crud.update(factura);
        //Si "error" no está vacío, es que ha ocurrido un error al borrar (probablemente la familia no exista)
        if (!error.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No se pudo borrar la línea de factura." + "\nDescripción del error: " + error);
            return;
        }
        //Si "error" está vacío, es que todo ha ido bien, así que actualizo las tablas de la vista
        actualizarTablas();
    }//GEN-LAST:event_jbBorrarLineaFacturaActionPerformed

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FacturaJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FacturaJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FacturaJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FacturaJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JButton jbActualizar;
    private javax.swing.JButton jbBorrarFactura;
    private javax.swing.JButton jbBorrarLineaFactura;
    private javax.swing.JButton jbCrearFactura;
    private javax.swing.JButton jbCrearLineaFactura;
    private javax.swing.JButton jbModificarFactura;
    private javax.swing.JPanel jpFactura;
    private javax.swing.JPanel jpLineaFactura;
    private javax.swing.JScrollPane jspFactura;
    private javax.swing.JScrollPane jspLineaFactura;
    private javax.swing.JTable jtFactura;
    private javax.swing.JTable jtLineaFactura;
    private javax.swing.JTextField jtfCodigoArticuloLinea;
    private javax.swing.JTextField jtfCodigoCliente;
    private javax.swing.JTextField jtfFechaFactura;
    private javax.swing.JTextField jtfNumeroFactura;
    private javax.swing.JTextField jtfNumeroFacturaLinea;
    // End of variables declaration//GEN-END:variables
}
