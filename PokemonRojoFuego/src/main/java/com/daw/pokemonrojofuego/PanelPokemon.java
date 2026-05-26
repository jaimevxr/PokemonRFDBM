/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.daw.pokemonrojofuego;

/**
 *
 * @author Kuroiryuudev
 */
public class PanelPokemon extends javax.swing.JPanel {

    private byte[] spriteTemporal = null;  // Variable para recordar la foto del Pokémon seleccionado
    private int filaInicio = 0; // Controla desde qué registro empezamos a mostrar
    private final int TAMANO_PAGINA = 8; // De cuánto en cuánto pasamos

    /**
     * Creates new form PanelPokemon
     */
    public PanelPokemon() {
        initComponents();

        // Solo ejecuta la base de datos si NO estamos en modo diseño, sino directamente no dejara configurar desde el jFrame
        if (!java.beans.Beans.isDesignTime()) {
            PokemonDAO dao = new PokemonDAO();
            cargarTablaPokemon(dao.obtenerTodos());
        }

        // Sistema de paginado para la tabla
        if (!java.beans.Beans.isDesignTime()) {
            PokemonDAO dao = new PokemonDAO();
            cargarTablaPokemon(dao.obtenerPaginados(filaInicio, TAMANO_PAGINA));
            actualizarInfoPagina();
        }
    }

    // Este método recibe una lista de Pokémon y los pinta en la tabla
    public void cargarTablaPokemon(java.util.List<Pokemon> lista) {
        javax.swing.table.DefaultTableModel modelo = (javax.swing.table.DefaultTableModel) tablaPokemon.getModel();
        modelo.setRowCount(0);

        for (Pokemon p : lista) {
            Object[] fila = new Object[6];
            fila[0] = p.getApodo();
            fila[1] = p.getIdPokemon();
            fila[2] = p.getEspecie();
            fila[3] = p.getNivel();

            // Si tiene entrenador, sacamos su ID. Si no, ponemos un aviso.
            if (p.getEntrenador() != null) {
                fila[4] = p.getEntrenador().getIdEntrenador();
            } else {
                fila[4] = "Libre";
            }

            // Tratamiento del Sprite
            byte[] spriteBytes = p.getSprite();
            if (spriteBytes != null && spriteBytes.length > 0) {
                try {
                    javax.swing.ImageIcon icono = new javax.swing.ImageIcon(spriteBytes);
                    java.awt.Image img = icono.getImage().getScaledInstance(60, 60, java.awt.Image.SCALE_SMOOTH);
                    fila[5] = new javax.swing.ImageIcon(img);
                } catch (Exception e) {
                    fila[5] = "Error";
                }
            } else {
                fila[5] = "Sin foto";
            }
            modelo.addRow(fila);
            // Creamos un renderizador que alinea el texto a la izquierda
            javax.swing.table.DefaultTableCellRenderer alineadoIzq = new javax.swing.table.DefaultTableCellRenderer();
            alineadoIzq.setHorizontalAlignment(javax.swing.JLabel.LEFT);

            tablaPokemon.getColumnModel().getColumn(1).setCellRenderer(alineadoIzq);
            tablaPokemon.getColumnModel().getColumn(3).setCellRenderer(alineadoIzq);
            tablaPokemon.getColumnModel().getColumn(4).setCellRenderer(alineadoIzq);
        }

        // Configuramos la altura y el renderizador de la imagen para el sprite columna 5
        tablaPokemon.setRowHeight(64);
        tablaPokemon.getColumnModel().getColumn(5).setCellRenderer(new javax.swing.table.DefaultTableCellRenderer() {
            @Override
            public java.awt.Component getTableCellRendererComponent(javax.swing.JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                if (value instanceof javax.swing.ImageIcon) {
                    javax.swing.JLabel label = new javax.swing.JLabel((javax.swing.ImageIcon) value);
                    label.setHorizontalAlignment(javax.swing.JLabel.CENTER);
                    if (isSelected) {
                        label.setBackground(table.getSelectionBackground());
                        label.setOpaque(true);
                    }
                    return label;
                }
                return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            }
        });
    }

    private void actualizarInfoPagina() {
        PokemonDAO dao = new PokemonDAO();
        long total = dao.contarTotalPokemon();
        int paginaActual = (filaInicio / TAMANO_PAGINA) + 1;
        int totalPaginas = (int) Math.ceil((double) total / TAMANO_PAGINA);
        lblPagina.setText("Página " + paginaActual + " de " + totalPaginas);
    }

    // Cargamos todos los Pokémon nada más abrir el panel
    private void refrescarPaginaActual() {
        PokemonDAO dao = new PokemonDAO();
        // Cargamos los Pokémon empezando desde donde ya estábamos
        cargarTablaPokemon(dao.obtenerPaginados(filaInicio, TAMANO_PAGINA));
        actualizarInfoPagina();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaPokemon = new javax.swing.JTable();
        buscarPokemonLabel = new javax.swing.JLabel();
        txtBuscador = new javax.swing.JTextField();
        jButtonBuscar = new javax.swing.JButton();
        infoLabel = new javax.swing.JLabel();
        idPokemonLabel = new javax.swing.JLabel();
        apodoLabel = new javax.swing.JLabel();
        especieLabel = new javax.swing.JLabel();
        nivelLabel = new javax.swing.JLabel();
        idEntrenadorLabel = new javax.swing.JLabel();
        txtIdPokemon = new javax.swing.JTextField();
        txtApodo = new javax.swing.JTextField();
        txtEspecie = new javax.swing.JTextField();
        txtNivel = new javax.swing.JTextField();
        txtIdEntrenador = new javax.swing.JTextField();
        lblFoto = new javax.swing.JLabel();
        btnSeleccionarFoto = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnActualizarMasivo = new javax.swing.JButton();
        btnAnterior = new javax.swing.JButton();
        btnSiguiente = new javax.swing.JButton();
        lblPagina = new javax.swing.JLabel();

        tablaPokemon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Apodo", "ID", "Especie", "Nivel", "ID Entrenador", "Sprite"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaPokemon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaPokemonMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaPokemon);

        buscarPokemonLabel.setText("Buscar Pokemon");

        txtBuscador.setColumns(20);
        txtBuscador.setForeground(new java.awt.Color(153, 153, 153));
        txtBuscador.setText("Escribe un ID, entrenador o especie...");
        txtBuscador.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtBuscadorFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtBuscadorFocusLost(evt);
            }
        });
        txtBuscador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscadorActionPerformed(evt);
            }
        });

        jButtonBuscar.setText("Buscar");
        jButtonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarActionPerformed(evt);
            }
        });

        infoLabel.setText("Informacion del Pokemon");

        idPokemonLabel.setText("ID Pokemon");

        apodoLabel.setText("Apodo:");

        especieLabel.setText("Especie:");

        nivelLabel.setText("Nivel:");

        idEntrenadorLabel.setText("ID Entrenador:");

        txtIdPokemon.setEditable(false);
        txtIdPokemon.setColumns(5);

        txtApodo.setColumns(5);

        txtEspecie.setColumns(5);

        txtNivel.setColumns(5);

        txtIdEntrenador.setColumns(5);

        lblFoto.setBorder(javax.swing.BorderFactory.createTitledBorder("Previsualizacion del pokemon seleccionado"));

        btnSeleccionarFoto.setText("Seleccionar Foto");
        btnSeleccionarFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarFotoActionPerformed(evt);
            }
        });

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnBorrar.setText("Borrar");
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        btnActualizarMasivo.setText("Actualizar foto a toda la especie");
        btnActualizarMasivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarMasivoActionPerformed(evt);
            }
        });

        btnAnterior.setText("⬅️");
        btnAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnteriorActionPerformed(evt);
            }
        });

        btnSiguiente.setText("➡️");
        btnSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteActionPerformed(evt);
            }
        });

        lblPagina.setText("Pagina x de x");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 497, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblPagina)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAnterior)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSiguiente)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buscarPokemonLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBuscador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(infoLabel)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(idEntrenadorLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtIdEntrenador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(nivelLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtNivel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(especieLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtEspecie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(apodoLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtApodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(idPokemonLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtIdPokemon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButtonBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                                    .addComponent(btnBorrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnActualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(btnLimpiar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnActualizarMasivo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnSeleccionarFoto)
                        .addComponent(lblFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 12, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(buscarPokemonLabel)
                            .addComponent(txtBuscador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(infoLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(idPokemonLabel)
                            .addComponent(txtIdPokemon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnGuardar)
                            .addComponent(jButtonBuscar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(apodoLabel)
                            .addComponent(txtApodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBorrar)
                            .addComponent(btnActualizar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(especieLabel)
                            .addComponent(txtEspecie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnLimpiar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nivelLabel)
                            .addComponent(txtNivel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnActualizarMasivo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(idEntrenadorLabel)
                            .addComponent(txtIdEntrenador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(52, 52, 52)
                        .addComponent(lblFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 540, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnSeleccionarFoto)
                        .addComponent(btnAnterior)
                        .addComponent(btnSiguiente))
                    .addComponent(lblPagina))
                .addGap(0, 5, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarActionPerformed
        // TODO add your handling code here:         
        // Recogemos lo que ha escrito el usuario y lo pasamos a minúsculas
        String busqueda = txtBuscador.getText().trim().toLowerCase();
        PokemonDAO dao = new PokemonDAO();

        // Si le da a buscar con la caja vacía o con el texto por defecto, cargamos TODOS
        if (busqueda.isEmpty() || busqueda.equals("escribe un id, entrenador o especie...")) {
            cargarTablaPokemon(dao.obtenerTodos());
            return;
        }

        // COMPROBACIÓN DE ENTRENADORES DUPLICADOS ---
        EntrenadorDAO daoEntrenador = new EntrenadorDAO();
        java.util.List<Entrenador> entrenadoresCoincidentes = daoEntrenador.buscarPorNombre(busqueda);

        if (entrenadoresCoincidentes.size() > 1) {
            // Hay varios entrenadores con ese nombre, detenemos la búsqueda
            StringBuilder mensaje = new StringBuilder();
            mensaje.append("Hay varios entrenadores llamados '").append(busqueda).append("'.\n");
            mensaje.append("Sus equipos Pokémon se mezclarían en la tabla.\n");
            mensaje.append("Por favor, busca directamente por su 'ID Entrenador':\n\n");

            for (Entrenador e : entrenadoresCoincidentes) {
                mensaje.append(" - ID Entrenador: ").append(e.getIdEntrenador())
                        .append(" (Clase: ").append(e.getClase()).append(")\n");
            }

            javax.swing.JOptionPane.showMessageDialog(this, mensaje.toString(), "Aviso de colisión", javax.swing.JOptionPane.WARNING_MESSAGE);
            return; // Cortamos la ejecución aquí para que no mezcle los equipos
        }

        // Traemos a todos los Pokémon de la base de datos
        java.util.List<Pokemon> todos = dao.obtenerTodos();

        // Creamos una lista vacía para guardar solo los que coincidan y asi no saturamos la base de datos
        java.util.List<Pokemon> filtrados = new java.util.ArrayList<>();

        // Revisamos Pokémon por Pokémon
        for (Pokemon p : todos) {
            boolean coincide = false;

            if (String.valueOf(p.getIdPokemon()).equals(busqueda)) {
                coincide = true;
            }

            if (p.getApodo() != null && p.getApodo().toLowerCase().contains(busqueda)) {
                coincide = true;
            }

            if (p.getEspecie() != null && p.getEspecie().toLowerCase().contains(busqueda)) {
                coincide = true;
            }

            if (p.getEntrenador() != null) {

                if (String.valueOf(p.getEntrenador().getIdEntrenador()).equals(busqueda)) {
                    coincide = true;
                }

                if (p.getEntrenador().getNombreEntrenador().toLowerCase().contains(busqueda)) {
                    coincide = true;
                }
            }

            // Si ha coincidido en ALGO, lo metemos en nuestra lista de resultados
            if (coincide) {
                filtrados.add(p);
            }
        }

        // le pasamos nuestra lista filtrada al "Pintor de tablas"
        cargarTablaPokemon(filtrados);

        // Aviso si no encontró nada
        if (filtrados.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this, "No se encontró ningún Pokémon con esos datos.");
        }
    }//GEN-LAST:event_jButtonBuscarActionPerformed

    private void txtBuscadorFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBuscadorFocusGained
        // TODO add your handling code here:
        if (txtBuscador.getText().equals("Escribe un ID, entrenador o especie...")) {
            txtBuscador.setText("");
            txtBuscador.setForeground(new java.awt.Color(0, 0, 0)); // Letra negra al escribir
        }
    }//GEN-LAST:event_txtBuscadorFocusGained

    private void txtBuscadorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBuscadorFocusLost
        // TODO add your handling code here:
        if (txtBuscador.getText().isEmpty()) {
            txtBuscador.setForeground(new java.awt.Color(153, 153, 153)); // Vuelve al gris
            txtBuscador.setText("Escribe un ID, entrenador o especie...");
        }
    }//GEN-LAST:event_txtBuscadorFocusLost

    private void tablaPokemonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaPokemonMouseClicked
        // TODO add your handling code here:
        // Averiguamos en qué fila de la tabla ha hecho clic el usuario
        int fila = tablaPokemon.getSelectedRow();

        if (fila != -1) {

            // Pasamos los datos de la tabla a los text field
            txtApodo.setText(tablaPokemon.getValueAt(fila, 0) != null ? tablaPokemon.getValueAt(fila, 0).toString() : "");
            txtIdPokemon.setText(tablaPokemon.getValueAt(fila, 1).toString());
            txtEspecie.setText(tablaPokemon.getValueAt(fila, 2) != null ? tablaPokemon.getValueAt(fila, 2).toString() : "");
            txtNivel.setText(tablaPokemon.getValueAt(fila, 3) != null ? tablaPokemon.getValueAt(fila, 3).toString() : "");

            // Si el entrenador está libre, dejamos la caja vacía para que no ponga "Libre"
            String idEntrenador = tablaPokemon.getValueAt(fila, 4).toString();
            txtIdEntrenador.setText(idEntrenador.equals("Libre") ? "" : idEntrenador);

            // foto corregida para que no se salga del borde
            try {
                int id = Integer.parseInt(txtIdPokemon.getText());
                PokemonDAO dao = new PokemonDAO();
                Pokemon p = dao.buscarPorId(id);

                if (p != null && p.getSprite() != null) {
                    spriteTemporal = p.getSprite();
                    javax.swing.ImageIcon icono = new javax.swing.ImageIcon(spriteTemporal);

                    // Obtenemos el grosor del borde (los Insets)
                    java.awt.Insets insets = lblFoto.getInsets();

                    // Calculamos el espacio ÚTIL real que queda dentro del borde
                    int anchoUtil = lblFoto.getWidth() - insets.left - insets.right;
                    int altoUtil = lblFoto.getHeight() - insets.top - insets.bottom;

                    // si el label es muy pequeño, evitar errores
                    if (anchoUtil > 0 && altoUtil > 0) {
                        // Escalamos la imagen usando el espacio ÚTIL
                        java.awt.Image img = icono.getImage().getScaledInstance(anchoUtil, altoUtil, java.awt.Image.SCALE_SMOOTH);
                        lblFoto.setIcon(new javax.swing.ImageIcon(img));
                    } else {
                        // Si no cabe, no ponemos nada para no romper el diseño
                        lblFoto.setIcon(null);
                    }

                } else {
                    spriteTemporal = null;
                    lblFoto.setIcon(null);
                }
            } catch (Exception ex) {
                System.out.println("Error al cargar la foto: " + ex.getMessage());
            }
        }
    }//GEN-LAST:event_tablaPokemonMouseClicked

    private void btnSeleccionarFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarFotoActionPerformed
        // TODO add your handling code here:
        javax.swing.JFileChooser fileChooser = new javax.swing.JFileChooser();
        fileChooser.setDialogTitle("Seleccionar Sprite para el Pokémon");
        javax.swing.filechooser.FileNameExtensionFilter filtro = new javax.swing.filechooser.FileNameExtensionFilter("Imágenes", "jpg", "png", "gif");
        fileChooser.setFileFilter(filtro);

        if (fileChooser.showOpenDialog(this) == javax.swing.JFileChooser.APPROVE_OPTION) {
            try {
                spriteTemporal = java.nio.file.Files.readAllBytes(fileChooser.getSelectedFile().toPath());
                javax.swing.ImageIcon icono = new javax.swing.ImageIcon(spriteTemporal);
                java.awt.Insets insets = lblFoto.getInsets();
                java.awt.Image img = icono.getImage().getScaledInstance(lblFoto.getWidth() - insets.left - insets.right,
                        lblFoto.getHeight() - insets.top - insets.bottom,
                        java.awt.Image.SCALE_SMOOTH);
                lblFoto.setIcon(new javax.swing.ImageIcon(img));
            } catch (Exception ex) {
                javax.swing.JOptionPane.showMessageDialog(this, "Error al cargar imagen: " + ex.getMessage());
            }
        }
    }//GEN-LAST:event_btnSeleccionarFotoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        try {
            // Validaciones iniciales de campos vacíos
            if (txtIdEntrenador.getText().trim().isEmpty() || txtNivel.getText().trim().isEmpty()) {
                javax.swing.JOptionPane.showMessageDialog(this, "ID Entrenador y Nivel son campos obligatorios.");
                return;
            }

            int idEntrenador = Integer.parseInt(txtIdEntrenador.getText().trim());
            int nivel = Integer.parseInt(txtNivel.getText().trim());
            PokemonDAO pokeDao = new PokemonDAO();

            // Máximo 6 Pokémon por equipo
            if (pokeDao.contarPokemonDeEntrenador(idEntrenador) >= 6) {
                javax.swing.JOptionPane.showMessageDialog(this, "¡Equipo lleno! Este entrenador ya tiene 6 Pokémon.");
                return;
            }

            // Nivel entre 1 y 100
            if (nivel < 1 || nivel > 100) {
                javax.swing.JOptionPane.showMessageDialog(this, "El nivel debe estar entre 1 y 100.");
                return;
            }

            // Proceso de guardado
            Entrenador dueyo = new EntrenadorDAO().buscarPorId(idEntrenador);
            if (dueyo != null) {
                Pokemon nuevo = new Pokemon();
                nuevo.setApodo(txtApodo.getText().trim());
                nuevo.setEspecie(txtEspecie.getText().trim().toLowerCase());
                nuevo.setNivel(nivel);
                nuevo.setSprite(spriteTemporal);
                nuevo.setEntrenador(dueyo);

                pokeDao.guardar(nuevo);
                javax.swing.JOptionPane.showMessageDialog(this, "¡Pokémon guardado con éxito!");

                // Refrescar interfaz
                btnLimpiar.doClick();
                refrescarPaginaActual();
            } else {
                javax.swing.JOptionPane.showMessageDialog(this, "No existe ningún entrenador con ID: " + idEntrenador);
            }

        } catch (NumberFormatException e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Error: Nivel e ID Entrenador deben ser números enteros.");
        } catch (Exception ex) {
            javax.swing.JOptionPane.showMessageDialog(this, "Error al guardar: " + ex.getMessage());
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        // TODO add your handling code here:
        try {
            if (txtIdPokemon.getText().isEmpty()) {
                javax.swing.JOptionPane.showMessageDialog(this, "Selecciona primero un Pokémon de la tabla.");
                return;
            }

            int id = Integer.parseInt(txtIdPokemon.getText());
            int nivel = Integer.parseInt(txtNivel.getText().trim());

            // Nivel entre 1 y 100
            if (nivel < 1 || nivel > 100) {
                javax.swing.JOptionPane.showMessageDialog(this, "El nivel debe estar entre 1 y 100.");
                return;
            }

            PokemonDAO dao = new PokemonDAO();
            Pokemon p = dao.buscarPorId(id);

            if (p != null) {
                p.setApodo(txtApodo.getText().trim());
                p.setEspecie(txtEspecie.getText().trim().toLowerCase());
                p.setNivel(nivel);
                p.setSprite(spriteTemporal);

                // Actualizar dueño
                int idEntrenador = Integer.parseInt(txtIdEntrenador.getText().trim());
                p.setEntrenador(new EntrenadorDAO().buscarPorId(idEntrenador));

                dao.actualizar(p);
                javax.swing.JOptionPane.showMessageDialog(this, "¡Pokémon actualizado correctamente!");
                refrescarPaginaActual();
            }
        } catch (NumberFormatException e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Error: Revisa que los campos numéricos sean correctos.");
        } catch (Exception ex) {
            javax.swing.JOptionPane.showMessageDialog(this, "Error al actualizar: " + ex.getMessage());
        }
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        // TODO add your handling code here:
        if (txtIdPokemon.getText().isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this, "Selecciona un Pokémon para liberar.");
            return;
        }

        int respuesta = javax.swing.JOptionPane.showConfirmDialog(this,
                "¿Estás seguro de que quieres liberar a este Pokémon?", "Confirmar", javax.swing.JOptionPane.YES_NO_OPTION);

        if (respuesta == javax.swing.JOptionPane.YES_OPTION) {
            new PokemonDAO().borrar(Integer.parseInt(txtIdPokemon.getText()));
            btnLimpiar.doClick();
            refrescarPaginaActual();
        }
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        // Vaciamos todos los campos de texto
        txtIdPokemon.setText("");
        txtApodo.setText("");
        txtEspecie.setText("");
        txtNivel.setText("");
        txtIdEntrenador.setText("");

        // Vaciamos el buscador y le devolvemos su texto por defecto
        txtBuscador.setText("Escribe un ID, entrenador o especie...");
        txtBuscador.setForeground(new java.awt.Color(153, 153, 153)); // Volvemos al gris

        // Quitamos la foto de la previsualización y reseteamos la variable temporal
        lblFoto.setIcon(null);
        spriteTemporal = null;

        // Llamamos al DAO para traer a todos de nuevo
        try {
            PokemonDAO dao = new PokemonDAO();
            filaInicio = 0;
            refrescarPaginaActual();
        } catch (Exception e) {
            System.out.println("Error al reiniciar la tabla: " + e.getMessage());
        }
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnActualizarMasivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarMasivoActionPerformed
        // TODO add your handling code here:
        // Verificamos que el usuario haya seleccionado una foto primero
        if (spriteTemporal == null) {
            javax.swing.JOptionPane.showMessageDialog(this,
                    "Primero debes cargar una imagen con el botón 'Seleccionar Foto'.",
                    "Aviso", javax.swing.JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Pedimos al usuario la especie que quiere actualizar
        String especieACambiar = javax.swing.JOptionPane.showInputDialog(this,
                "¿A qué ESPECIE quieres aplicarle esta foto de forma masiva?\n(Ejemplo: pikachu, charizard...)");

        // Si el usuario no canceló y escribió algo
        if (especieACambiar != null && !especieACambiar.trim().isEmpty()) {

            String especieLimpia = especieACambiar.trim().toLowerCase();

            // Pedimos confirmación final
            int respuesta = javax.swing.JOptionPane.showConfirmDialog(this,
                    "¿Estás seguro de que quieres cambiar la foto de TODOS los " + especieLimpia + "?\nEsta acción no se puede deshacer.",
                    "Confirmar actualización masiva",
                    javax.swing.JOptionPane.YES_NO_OPTION,
                    javax.swing.JOptionPane.QUESTION_MESSAGE);

            if (respuesta == javax.swing.JOptionPane.YES_OPTION) {
                try {
                    PokemonDAO dao = new PokemonDAO();
                    dao.actualizarSpriteMasivo(especieLimpia, spriteTemporal);

                    javax.swing.JOptionPane.showMessageDialog(this, "¡Sprites actualizados con éxito!");

                    // Recargamos la tabla para que se vean los nuevos sprites de golpe
                    cargarTablaPokemon(dao.obtenerTodos());

                } catch (Exception ex) {
                    javax.swing.JOptionPane.showMessageDialog(this, "Error durante la actualización: " + ex.getMessage());
                }
            }
        }
    }//GEN-LAST:event_btnActualizarMasivoActionPerformed

    private void txtBuscadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscadorActionPerformed
        // TODO add your handling code here:
        jButtonBuscarActionPerformed(null);
    }//GEN-LAST:event_txtBuscadorActionPerformed

    private void btnAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnteriorActionPerformed
        // TODO add your handling code here:
        if (filaInicio - TAMANO_PAGINA >= 0) {
            filaInicio -= TAMANO_PAGINA;
            PokemonDAO dao = new PokemonDAO();
            cargarTablaPokemon(dao.obtenerPaginados(filaInicio, TAMANO_PAGINA));
            actualizarInfoPagina();
        }
    }//GEN-LAST:event_btnAnteriorActionPerformed

    private void btnSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteActionPerformed
        // TODO add your handling code here:
        PokemonDAO dao = new PokemonDAO();
        long total = dao.contarTotalPokemon();

        // Solo avanzamos si quedan más Pokémon por mostrar
        if (filaInicio + TAMANO_PAGINA < total) {
            filaInicio += TAMANO_PAGINA;
            cargarTablaPokemon(dao.obtenerPaginados(filaInicio, TAMANO_PAGINA));
            actualizarInfoPagina();
        }
    }//GEN-LAST:event_btnSiguienteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel apodoLabel;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnActualizarMasivo;
    private javax.swing.JButton btnAnterior;
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnSeleccionarFoto;
    private javax.swing.JButton btnSiguiente;
    private javax.swing.JLabel buscarPokemonLabel;
    private javax.swing.JLabel especieLabel;
    private javax.swing.JLabel idEntrenadorLabel;
    private javax.swing.JLabel idPokemonLabel;
    private javax.swing.JLabel infoLabel;
    private javax.swing.JButton jButtonBuscar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblFoto;
    private javax.swing.JLabel lblPagina;
    private javax.swing.JLabel nivelLabel;
    private javax.swing.JTable tablaPokemon;
    private javax.swing.JTextField txtApodo;
    private javax.swing.JTextField txtBuscador;
    private javax.swing.JTextField txtEspecie;
    private javax.swing.JTextField txtIdEntrenador;
    private javax.swing.JTextField txtIdPokemon;
    private javax.swing.JTextField txtNivel;
    // End of variables declaration//GEN-END:variables
}
