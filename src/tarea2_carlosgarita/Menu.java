/*
Universidad: UNED
Curso:        Estructura de Datos 
Código:       00825
Tema:         Tarea 2
Estudiante:   Carlos Garita Campos
Periodo:      II Cuatrimestre 2020
 */

package tarea2_carlosgarita;

import java.util.ArrayList;
import java.util.Stack;
import javax.swing.JOptionPane;

/**
 *
 * @author cgari
 */
public class Menu extends javax.swing.JFrame {

    private ArrayList<Persona> p = new ArrayList();
    private Stack<Persona> menores = new Stack<Persona>();
    private Stack<Persona> adultos = new Stack<Persona>();
    private Stack<Persona> adultos_mayores = new Stack<Persona>();
    
    public Menu() {
        initComponents();
        this.setLocationRelativeTo(null); //Posiciona el JFrame en el centro de la pantalla     
        
        //Asignación de radioButtons a un buttonGroup
        this.btgOpciones.add(this.rdbExtraer);
        this.btgOpciones.add(this.rdbMostrarTam);
        this.btgOpciones.add(this.rdbReiniciar);
        this.btgOpciones.add(this.rdbVaciar);
        
        //Agrega datos al comboBox
        this.cbxVaciar.addItem("Menores");
        this.cbxVaciar.addItem("Adultos");
        this.cbxVaciar.addItem("Adultos Mayores");
        
        //Agrega datos al comboBox
        this.cbxMostrarTam.addItem("Menores");
        this.cbxMostrarTam.addItem("Adultos");
        this.cbxMostrarTam.addItem("Adultos Mayores");
        
         //Agrega datos al comboBox
        this.cbxExtraer.addItem("Menores");
        this.cbxExtraer.addItem("Adultos");
        this.cbxExtraer.addItem("Adultos Mayores");

        //Llama al método "GenerarAleatorios"
        GenerarAleatorios();
        ordenar();
        mostrar();
    }

     //Método para generar los números aleatorios y almacenarlos en el arreglo respectivo
    public void GenerarAleatorios() {

        //Declaración de variables locales
        int numAleatorio1, numAleatorio2;
        String texto = "", id="";
        boolean prueba;
     
        //Ciclo for para recorrer el arreglo y asignar los valores de los números aleatorios
       for (int i = 0; i < 50; i++) {

           prueba = true;
           
            //Genera los números aleatorios entre 0 y 999999999 y los asigna a la variable "numAleatorio"
            numAleatorio1 = (int) (Math.random() * 999999999);
            
            //Genera los números aleatorios entre 0 y 999999999 y los asigna a la variable "numAleatorio"
            numAleatorio2 = (int) (Math.random() * 99) + 1;

           while (prueba) {

               prueba = false;

               for (int j = 0; j < p.size(); j++) {
                   if (numAleatorio2 == p.get(j).getEdad() || numAleatorio1 == p.get(j).getId()) {

                        //Genera los números aleatorios entre 0 y 999999999 y los asigna a la variable "numAleatorio"
                       numAleatorio1 = (int) (Math.random() * 999999999);
                        //Genera los números aleatorios entre 0 y 999999999 y los asigna a la variable "numAleatorio"
                       numAleatorio2 = (int) (Math.random() * 99) + 1;
                       prueba = true;
                       j = 0;
                   }
               }
           }

            this.p.add(new Persona(numAleatorio1, numAleatorio2));   
            
            //Asigna el valor del número aleatorio en la posición "i" del arreglo como cadena de texto a la variable "texto"
            texto += "Identificación: " + p.get(i).getId() + " - " + "Edad: " + p.get(i).getEdad() + "\n";
        }


        //Asigna la cadena de texto de la variable "texto" al cuadro de área de texto para mostrar los números aleatorios en pantalla
        this.txaRespuesta.setText(texto);
    }
    
    public void ordenar() {        

        for (int i = 0; i < 50; i++) {
            if (this.p.get(i).getEdad() < 18) {
                this.menores.push(p.get(i));
            }
        }        

        for (int i = 0; i < 50; i++) {

            if (this.p.get(i).getEdad() >= 18 && this.p.get(i).getEdad() <= 64) {
                this.adultos.push(p.get(i));
            }
        }        
        
        for (int i = 0; i < 50; i++) {
            if (this.p.get(i).getEdad() > 64) {
                this.adultos_mayores.push(p.get(i));
            }
        }                  
    }
    
    public void mostrar(){
        String textoMenores = "", textoAdultos = "", textoAdultosMayores = "";
        
        for (int i = 0; i < this.menores.size(); i++) {
            textoMenores += "Identificación: " + this.menores.get(i).getId() + " - " + "Edad: " + this.menores.get(i).getEdad() + "\n";
        }

        this.txaMenores.setText(textoMenores);
        
        
        
        for (int i = 0; i < this.adultos.size(); i++) {
            textoAdultos += "Identificación: " + this.adultos.get(i).getId() + " - " + "Edad: " + this.adultos.get(i).getEdad() + "\n";
        }

        this.txaAdultos.setText(textoAdultos);
        
        
        
        for (int i = 0; i < this.adultos_mayores.size(); i++) {
            textoAdultosMayores += "Identificación: " + this.adultos_mayores.get(i).getId() + " - " + "Edad: " + this.adultos_mayores.get(i).getEdad() + "\n";
        }
        
        this.txaAdultosMayores.setText(textoAdultosMayores);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btgOpciones = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txaRespuesta = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        btnAceptar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        rdbExtraer = new javax.swing.JRadioButton();
        rdbMostrarTam = new javax.swing.JRadioButton();
        rdbVaciar = new javax.swing.JRadioButton();
        rdbReiniciar = new javax.swing.JRadioButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txaAdultos = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        txaAdultosMayores = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        txaMenores = new javax.swing.JTextArea();
        cbxVaciar = new javax.swing.JComboBox<>();
        cbxMostrarTam = new javax.swing.JComboBox<>();
        cbxExtraer = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txaRespuesta.setColumns(20);
        txaRespuesta.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        txaRespuesta.setRows(5);
        jScrollPane1.setViewportView(txaRespuesta);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Seleccione la opción que desea ejecutar:");

        btnAceptar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        btnSalir.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        rdbExtraer.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rdbExtraer.setText("Extraer elemento");

        rdbMostrarTam.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rdbMostrarTam.setText("Mostrar tamaño");

        rdbVaciar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rdbVaciar.setText("Vaciar");

        rdbReiniciar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rdbReiniciar.setText("Reiniciar");

        txaAdultos.setColumns(20);
        txaAdultos.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        txaAdultos.setRows(5);
        jScrollPane2.setViewportView(txaAdultos);

        txaAdultosMayores.setColumns(20);
        txaAdultosMayores.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        txaAdultosMayores.setRows(5);
        jScrollPane3.setViewportView(txaAdultosMayores);

        txaMenores.setColumns(20);
        txaMenores.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        txaMenores.setRows(5);
        jScrollPane4.setViewportView(txaMenores);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(585, 585, 585))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(515, 515, 515)
                        .addComponent(rdbMostrarTam)
                        .addGap(138, 138, 138)
                        .addComponent(rdbVaciar)
                        .addGap(47, 47, 47))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addGap(28, 28, 28)))
                .addGap(60, 60, 60)
                .addComponent(rdbReiniciar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(234, 234, 234)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cbxExtraer, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rdbExtraer))
                .addGap(149, 149, 149)
                .addComponent(cbxMostrarTam, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(88, 88, 88)
                .addComponent(cbxVaciar, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAceptar)
                .addGap(135, 135, 135))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(rdbExtraer))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rdbVaciar)
                            .addComponent(rdbReiniciar)
                            .addComponent(rdbMostrarTam))))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxExtraer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxMostrarTam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxVaciar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAceptar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 497, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 497, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 497, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 497, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnSalir)
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed

        String textoMenores = "", textoAdultos = "", textoAdultosMayores = "";

        if (!this.rdbExtraer.isSelected() && !this.rdbMostrarTam.isSelected() && !this.rdbReiniciar.isSelected() && !this.rdbVaciar.isSelected()) {
            //Muestra mensaje en pantalla 
            JOptionPane.showMessageDialog(this,
                    "Es necesario que seleccione una de las opciones para continuar",
                    "Alto",
                    JOptionPane.WARNING_MESSAGE);
        } else {

            if (this.rdbExtraer.isSelected()) {

                if (this.cbxExtraer.getSelectedItem() == "Menores") {
                    this.menores.pop();
                    mostrar();
                    
                    //Muestra mensaje en pantalla 
                    JOptionPane.showMessageDialog(this,
                            "Elemento extraído con éxito de la pila de 'Menores'",
                            "Excelente",
                            JOptionPane.INFORMATION_MESSAGE);
                }

                if (this.cbxExtraer.getSelectedItem() == "Adultos") {
                    this.adultos.pop();
                    mostrar();
                    
                    //Muestra mensaje en pantalla 
                    JOptionPane.showMessageDialog(this,
                            "Elemento extraído con éxito de la pila de 'Adultos'",
                            "Excelente",
                            JOptionPane.INFORMATION_MESSAGE);
                }

                if (this.cbxExtraer.getSelectedItem() == "Adultos Mayores") {
                    this.adultos_mayores.pop();
                    mostrar();
                    
                    //Muestra mensaje en pantalla 
                    JOptionPane.showMessageDialog(this,
                            "Elemento extraído con éxito de la pila de 'Adultos Mayores'",
                            "Excelente",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            }

            if (this.rdbMostrarTam.isSelected()) {
                int tamano = 50;

                if (this.cbxMostrarTam.getSelectedItem() == "Menores") {

                    tamano = this.menores.size();

                    //Muestra mensaje en pantalla 
                    JOptionPane.showMessageDialog(this,
                            "El tamaño del arreglo es de " + tamano + " elementos",
                            "Atención",
                            JOptionPane.INFORMATION_MESSAGE);
                }

                if (this.cbxMostrarTam.getSelectedItem() == "Adultos") {
                    tamano = this.adultos.size();

                    //Muestra mensaje en pantalla 
                    JOptionPane.showMessageDialog(this,
                            "El tamaño del arreglo es de " + tamano + " elementos",
                            "Atención",
                            JOptionPane.INFORMATION_MESSAGE);
                }

                if (this.cbxMostrarTam.getSelectedItem() == "Adultos Mayores") {
                    tamano = this.adultos_mayores.size();

                    //Muestra mensaje en pantalla 
                    JOptionPane.showMessageDialog(this,
                            "El tamaño del arreglo es de " + tamano + " elementos",
                            "Atención",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            }

            if (this.rdbReiniciar.isSelected()) {

                this.menores.clear();
                this.adultos.clear();
                this.adultos_mayores.clear();
                this.p.clear();
                
                GenerarAleatorios();
                ordenar();
                mostrar();
                
                //Muestra mensaje en pantalla 
                    JOptionPane.showMessageDialog(this,
                            "La información ha sido reiniciada con éxito",
                            "Excelente",
                            JOptionPane.INFORMATION_MESSAGE);
            }

            if (this.rdbVaciar.isSelected()) {
                if (this.cbxVaciar.getSelectedItem() == "Menores") {
                    
                    this.menores.clear();
                    
                    for (int i = 0; i < 50; i++) {              

                        textoMenores += "";
                    }

                    this.txaMenores.setText(textoMenores);  
                    
                    //Muestra mensaje en pantalla 
                    JOptionPane.showMessageDialog(this,
                            "La pila de 'Menores' ha sido vaciada con éxito",
                            "Excelente",
                            JOptionPane.INFORMATION_MESSAGE);
                }         
                
                if(this.cbxVaciar.getSelectedItem()=="Adultos"){
                    
                    this.adultos.clear();
                    
                    for(int i = 0; i < 50; i++){

                        textoAdultos += "";                
                    }
                    
                    this.txaAdultos.setText(textoAdultos); 
                    
                    //Muestra mensaje en pantalla 
                    JOptionPane.showMessageDialog(this,
                            "La pila de 'Adultos' ha sido vaciada con éxito",
                            "Excelente",
                            JOptionPane.INFORMATION_MESSAGE);
                }      
                
                if(this.cbxVaciar.getSelectedItem()=="Adultos Mayores"){
                    
                    this.adultos_mayores.clear();
                    
                    for(int i = 0; i < 50; i++){
                        
                        textoAdultosMayores += "";                
                    }
                    
                    this.txaAdultosMayores.setText(textoAdultosMayores); 
                    
                    //Muestra mensaje en pantalla 
                    JOptionPane.showMessageDialog(this,
                            "La pila de 'Adultos Mayores' ha sido vaciada con éxito",
                            "Excelente",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        //Cierra la ventana y finaliza el programa
        System.exit(0);
    }//GEN-LAST:event_btnSalirActionPerformed

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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btgOpciones;
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<String> cbxExtraer;
    private javax.swing.JComboBox<String> cbxMostrarTam;
    private javax.swing.JComboBox<String> cbxVaciar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JRadioButton rdbExtraer;
    private javax.swing.JRadioButton rdbMostrarTam;
    private javax.swing.JRadioButton rdbReiniciar;
    private javax.swing.JRadioButton rdbVaciar;
    private javax.swing.JTextArea txaAdultos;
    private javax.swing.JTextArea txaAdultosMayores;
    private javax.swing.JTextArea txaMenores;
    private javax.swing.JTextArea txaRespuesta;
    // End of variables declaration//GEN-END:variables
}
