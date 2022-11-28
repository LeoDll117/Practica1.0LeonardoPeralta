package Vista;

import Controlador.ControlPersona;
import Vista.ModeloTabla.TablaEmpleado;
import Vista.Utilidades.Utilidades;
import Vista.Utilidades.AdaptadorDao;
import com.toedter.calendar.JDateChooser;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import javax.swing.JOptionPane;

/**
 *
 * @author Leonardo 117
 */
public class VentanaEmpleado extends javax.swing.JDialog {

    private ControlPersona controlP;

    SimpleDateFormat formita = new SimpleDateFormat("dd/MM/yyyy");
    private TablaEmpleado tabla = new TablaEmpleado();
    private Date fechaNow = new Date();
    //private Date fechaIngreso;
    Integer fila = -1;
    long dias = 0;
    public long sueldoBasico = 425;

    public VentanaEmpleado(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setResizable(false);
        txtSueldo.setEditable(false);
        txtNombre.setEditable(false);
        txtApellido.setEditable(false);
        txtSueldo.setText("425");
        jDateChooser1.setEnabled(false);
        btonCalcularTiempo.setEnabled(false);
        lblFechaActual.setText("");
        btonGuardarEmpleado.setEnabled(false);
        btonElegirEmpleado.setEnabled(false);
        btonGuardarArchivo.setEnabled(false);
        lblTotalDias.setText("");
        txtGuardarJson.setText("");
    }

    private void guardarEmpleado() {

        controlP.getPersona().setNombre(txtNombre.getText());
        controlP.getPersona().setApellido(txtApellido.getText());
        controlP.getPersona().setFechaIngreso(jDateChooser1.getDate());
        controlP.getPersona().setTiempoEmpleo(dias);
        System.out.println("2)>> " + formita.format(jDateChooser1.getDate()));

        controlP.CalculoEmpleado(dias, controlP.getPersona(), fila);
        System.out.println(dias);
        try {

            controlP.modificarEmpleado(controlP.getPersona(), fila);
            limpiar();
        } catch (Exception e) {
            System.out.println("Error en guardar este Empleado >:c");
        }
        //System.out.println(formita.format(fechaIngreso));
    }

    private void limpiar() {
        txtNombre.setText("");
        txtApellido.setText("");
        jDateChooser1.setDate(null);
        controlP.setPersona(null);

        cargarTabla();
    }

    protected void calcularTiempoEmpleado(Date Ingreso) {
        String fecha1 = (formita.format(fechaNow)); // fechainicio
        String fecha2 = (formita.format(Ingreso)); // fecha ultima
        System.out.println("1)>> " + formita.format(Ingreso));

        try {
            Date fecha_ingreso = formita.parse(fecha1);
            Date fecha_ultima = formita.parse(fecha2);

            long aniosHechos = fecha_ingreso.getTime() - fecha_ultima.getTime();
            TimeUnit diasEmpleo = TimeUnit.DAYS;
            dias = diasEmpleo.convert(aniosHechos, TimeUnit.MILLISECONDS);
            System.out.println("-> " + dias);

            if (dias == 1) {
                lblTotalDias.setText("Tiempo de Empleado en Trabajo: " + dias + " dia.");
            }
            if (dias < 365 && dias != 1) {
                lblTotalDias.setText("Tiempo de Empleado en Trabajo: " + dias + " dias.");
            }
            if (dias > 365 && dias < 730) {
                long resta = dias / 365;
                System.out.println("division: " + resta);
                long restaR = Math.round(resta * 100) / 100; //division 
                System.out.println("redondeo: " + restaR);

                long anios = restaR * 365;
                System.out.println("producto de anios : " + anios);
                long finalOp = dias - anios;
                System.out.println("R>> anios: " + restaR + " dias: " + finalOp);
                lblTotalDias.setText("Tiempo de Empleado en Trabajo: " + restaR + " anio, " + finalOp + " dias.");
            }
            if (dias > 730) {
                long resta = dias / 365;
                System.out.println("division: " + resta);
                long restaR = Math.round(resta * 100) / 100; //division 
                System.out.println("redondeo: " + restaR);

                long anios = restaR * 365;
                System.out.println("producto de anios : " + anios);
                long finalOp = dias - anios;
                System.out.println("R>> anios: " + restaR + " dias: " + finalOp);
                lblTotalDias.setText("Tiempo de Empleado en Trabajo: " + restaR + " anios, " + finalOp + " dias.");
            }
        } catch (Exception e) {
            System.out.println("Error en calcular la fecha >:c");
        }
    }

    private void crearArregloEmpleado() {
        controlP = new ControlPersona(Integer.parseInt(cbxNumeroEmpleados.getSelectedItem().toString()));
        cargarTabla();
    }

    private void cargarTabla() {
        if (controlP != null && controlP.getPersonas() != null) {
            tabla.setPersona(controlP.getPersonas());
            TablaEmpleado.setModel(tabla);
            TablaEmpleado.updateUI();
        } else {
            System.out.println(">:c");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        cbxNumeroEmpleados = new javax.swing.JComboBox<>();
        btonCrear = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btonCalcularTiempo = new javax.swing.JButton();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        txtNombre = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtSueldo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        lblFechaActual = new javax.swing.JLabel();
        btonGuardarEmpleado = new javax.swing.JButton();
        lblTotalDias = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        btonElegirEmpleado = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaEmpleado = new javax.swing.JTable();
        btonGuardarArchivo = new javax.swing.JButton();
        txtGuardarJson = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setText("Numero de Empleados por registrar");

        cbxNumeroEmpleados.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15" }));

        btonCrear.setText("Crear");
        btonCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btonCrearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(cbxNumeroEmpleados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btonCrear)
                .addGap(25, 25, 25))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxNumeroEmpleados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btonCrear))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setText("Elegir Fecha de ingreso de Empleado");

        btonCalcularTiempo.setText("Definir Tiempo");
        btonCalcularTiempo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btonCalcularTiempoActionPerformed(evt);
            }
        });

        jDateChooser1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jDateChooser1MouseClicked(evt);
            }
        });

        txtApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidoActionPerformed(evt);
            }
        });

        jLabel4.setText("Nombre:");

        jLabel5.setText("Apellido:");

        txtSueldo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSueldoActionPerformed(evt);
            }
        });

        jLabel6.setText("Sueldo Basico:");

        lblFechaActual.setText("Fecha Hoy: ");

        btonGuardarEmpleado.setText("Guardar");
        btonGuardarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btonGuardarEmpleadoActionPerformed(evt);
            }
        });

        lblTotalDias.setText("jLabel7");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblFechaActual, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel6))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtSueldo, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                        .addComponent(txtApellido)))
                                .addComponent(jLabel1)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(139, 139, 139)
                                .addComponent(btonCalcularTiempo)))
                        .addGap(28, 28, 28))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTotalDias, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addComponent(btonGuardarEmpleado)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSueldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addComponent(lblFechaActual)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btonCalcularTiempo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(12, 12, 12)
                .addComponent(lblTotalDias)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btonGuardarEmpleado)
                .addContainerGap(43, Short.MAX_VALUE))
        );

        jPanel4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btonElegirEmpleado.setText("Seleccionar");
        btonElegirEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btonElegirEmpleadoActionPerformed(evt);
            }
        });

        TablaEmpleado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        TablaEmpleado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaEmpleadoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TablaEmpleado);

        btonGuardarArchivo.setText("Guardar en Archivo");
        btonGuardarArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btonGuardarArchivoActionPerformed(evt);
            }
        });

        txtGuardarJson.setText("jLabel3");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtGuardarJson, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btonElegirEmpleado)
                        .addGap(230, 230, 230)
                        .addComponent(btonGuardarArchivo))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btonElegirEmpleado)
                    .addComponent(btonGuardarArchivo))
                .addGap(22, 22, 22)
                .addComponent(txtGuardarJson)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(8, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(11, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btonCalcularTiempoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btonCalcularTiempoActionPerformed

        Date fechaIngreso = jDateChooser1.getDate();

        if (fechaIngreso == null) {
            JOptionPane.showMessageDialog(null, "Seleccionar fecha de Ingreso de Empleado");
        } else {
            calcularTiempoEmpleado(fechaIngreso);
            btonGuardarEmpleado.setEnabled(true);
        }
    }//GEN-LAST:event_btonCalcularTiempoActionPerformed


    private void txtApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellidoActionPerformed

    private void txtSueldoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSueldoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSueldoActionPerformed

    private void btonCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btonCrearActionPerformed
        // TODO add your handling code here:
        crearArregloEmpleado();

    }//GEN-LAST:event_btonCrearActionPerformed

    private void btonGuardarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btonGuardarEmpleadoActionPerformed
        // TODO add your handling code here:
        if (txtNombre.getText().isEmpty() || txtApellido.getText().isEmpty() || jDateChooser1.getDate() == null) {
            JOptionPane.showMessageDialog(null, "Llenar todos los campos correspondientes");
        } else {
            guardarEmpleado();

        }
    }//GEN-LAST:event_btonGuardarEmpleadoActionPerformed

    private void btonElegirEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btonElegirEmpleadoActionPerformed
        // TODO add your handling code here:
        btonCrear.setEnabled(false);
        btonCalcularTiempo.setEnabled(true);
        btonGuardarArchivo.setEnabled(true);
        jDateChooser1.setEnabled(true);
        txtNombre.setEditable(true);
        txtApellido.setEditable(true);
        lblFechaActual.setText("Fecha Actual: " + formita.format(fechaNow));

        fila = TablaEmpleado.getSelectedRow();
        if (fila >= 0) {
            controlP.setPersona(tabla.getPersona()[fila]);
            txtNombre.setText(controlP.getPersona().getNombre());
            txtApellido.setText(controlP.getPersona().getApellido());
            jDateChooser1.setDate(controlP.getPersona().getFechaIngreso());
        }
    }//GEN-LAST:event_btonElegirEmpleadoActionPerformed

    private void TablaEmpleadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaEmpleadoMouseClicked
        // TODO add your handling code here:
        btonElegirEmpleado.setEnabled(true);
        txtSueldo.setEditable(false);
        txtNombre.setEditable(false);
        txtApellido.setEditable(false);
        txtSueldo.setText("425.00");
        jDateChooser1.setEnabled(false);
        btonCalcularTiempo.setEnabled(false);
        lblFechaActual.setText("");
        btonGuardarEmpleado.setEnabled(false);
    }//GEN-LAST:event_TablaEmpleadoMouseClicked

    private void jDateChooser1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jDateChooser1MouseClicked
        // TODO add your handling code here:
        btonGuardarEmpleado.setEnabled(false);
    }//GEN-LAST:event_jDateChooser1MouseClicked

    private void btonGuardarArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btonGuardarArchivoActionPerformed
        // TODO add your handling code here:
        guardarJson();
    }//GEN-LAST:event_btonGuardarArchivoActionPerformed

    private void guardarJson() {
        if (controlP != null) {
           if(AdaptadorDao.guardarArchivo(controlP.getPersonas()) &&AdaptadorDao.guardarJson(controlP.getPersonas())){
               txtGuardarJson.setText("Empleados guardados en .json");
           }else{
               txtGuardarJson.setText("Error en guardar en .json");
           }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                VentanaEmpleado dialog = new VentanaEmpleado(new javax.swing.JFrame(), true);
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
    private javax.swing.JTable TablaEmpleado;
    private javax.swing.JButton btonCalcularTiempo;
    private javax.swing.JButton btonCrear;
    private javax.swing.JButton btonElegirEmpleado;
    private javax.swing.JButton btonGuardarArchivo;
    private javax.swing.JButton btonGuardarEmpleado;
    private javax.swing.JComboBox<String> cbxNumeroEmpleados;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblFechaActual;
    private javax.swing.JLabel lblTotalDias;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JLabel txtGuardarJson;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtSueldo;
    // End of variables declaration//GEN-END:variables
}
