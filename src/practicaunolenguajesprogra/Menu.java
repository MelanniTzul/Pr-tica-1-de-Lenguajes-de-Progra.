package practicaunolenguajesprogra;

/**
 *
 * @author Melanni Tzul
 */
public class Menu extends javax.swing.JFrame {

    /**
     * Creates new form Menu
     */
    public Menu() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        Titulo = new javax.swing.JLabel();
        BotonoVerificar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        Descripcion = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        FondoImagen = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Titulo.setForeground(new java.awt.Color(255, 255, 255));
        Titulo.setText("IDENTIFICADOR DE CARACTERES");
        jPanel2.add(Titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 20, 220, 50));

        BotonoVerificar.setText("VERIFICAR");
        BotonoVerificar.setName(""); // NOI18N
        BotonoVerificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonoVerificarActionPerformed(evt);
            }
        });
        jPanel2.add(BotonoVerificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 250, 140, 40));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 90, 350, 120));

        Descripcion.setForeground(new java.awt.Color(255, 255, 255));
        Descripcion.setText("Ingrese el texto que desea verificar:");
        jPanel2.add(Descripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, 220, 40));

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 310, 340, 140));

        FondoImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Imagen1.jpg"))); // NOI18N
        jPanel2.add(FondoImagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BotonoVerificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonoVerificarActionPerformed

        String TextoVerificar;
        TextoVerificar = jTextArea1.getText();
        String Token = "";

        //For que me recorre el texto ingresado, para saber cuando tengo un token
        for (int i = 0; i < TextoVerificar.length(); i++) {
            if (Character.isSpaceChar(TextoVerificar.charAt(i))) {
                Verificar(Token);
                Token = ""; //Limpiar mi variable 

            } else {
                Token += TextoVerificar.charAt(i);
            }

        }
    }//GEN-LAST:event_BotonoVerificarActionPerformed

    //Funcion verificar 
    public void Verificar(String Token) {
        String token = Token;//Recibiendo token
        boolean Entero = true;
        boolean numdecimal = true;

        for (int i = 0; i < token.length() && !Entero; i++) {
            if (Character.isDigit(token.charAt(i))) {
                Entero = true;
            } else {
                Entero = false;
            }
        }
        
        
        boolean tieneLetra=false;
        for (int i = 0; i <token.length()&& !tieneLetra; i++) {
            if(Character.isLetter(token.charAt(i))){
                tieneLetra=true;
            } else {
                tieneLetra=false;
            }
        }

      /*  for (int i = 0; i < token.length() && !numdecimal; i++) {
            if (Character.isLetter(token.charAt(i))) {
                numdecimal = false;
            } else {
                numdecimal = true;
            }
        }*/
      
      
      
      

        if (Character.isLetter(token.charAt(0))) {
            Palabra dato = new Palabra(token, Texto.IDENTIFICADOR);
            jTextArea2.append("IDENTIFICADOR: " + dato.getTexto() + "\n");

        } else if (tieneLetra == false && Character.isDigit(token.charAt(0))) {
            Palabra dato1 = new Palabra(token, Texto.ENTERO);
            jTextArea2.append("ENTERO: " + dato1.getTexto() + "\n");

        } else if (token.contains("(") | token.contains(")") | token.contains(":") | token.contains(";") | token.contains("#") | token.contains("%") | token.contains("$") | token.contains("!") | token.contains("?") | token.contains("¡") | token.contains("*") | token.contains("+") | token.contains("~") | token.contains("´") | token.contains("/") | token.contains("＠")) {
            Palabra dato2 = new Palabra(token, Texto.CARACTER);
            jTextArea2.append("CARACTER: " + dato2.getTexto() + "\n");

        } else if (Character.isDigit(token.charAt(0)) && token.contains(".") && tieneLetra == false) {
            Palabra dato3 = new Palabra(token, Texto.DECIMAL);
            jTextArea2.append("DECIMAL: " + dato3.getTexto() + "\n");

        } else {
            Palabra dato4 = new Palabra(token, Texto.ERROR);
            jTextArea2.append("ERROR: " + dato4.getTexto() + "\n");

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
    private javax.swing.JButton BotonoVerificar;
    private javax.swing.JLabel Descripcion;
    private javax.swing.JLabel FondoImagen;
    private javax.swing.JLabel Titulo;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    // End of variables declaration//GEN-END:variables
}
