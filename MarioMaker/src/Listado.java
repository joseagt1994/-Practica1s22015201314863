
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableCellRenderer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jose Antonio
 */
public class Listado extends javax.swing.JFrame {

    /**
     * Creates new form Listado
     */
    public  int numero;
    public  String cadena;
    public  boolean tipo;
    int contador = 0;
    ListaDE list = ListaDE.getInstancia();
    Object[] objetos;
    String[] columnas = new String[]{
        "Tipo",
        "Imagen",
        "Nombre",
        "",
        ""
    };
    Object[][] datos;
    
    final Class[] tiposColumnas = new Class[]{
        java.lang.String.class,
        JLabel.class,
        java.lang.String.class,
        JButton.class,
        JButton.class
    };
    
    
    public Listado(){
        initComponents();
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        //System.out.println(objetos.length);
        setTable();
        
//        for (int i=0; i<objetos.length;i++){
//            //System.out.println(i);
//            //System.out.println(objetos[i].getClass().toString());
//            switch (objetos[i].getClass().toString()){
//                case "class Suelo":
//                    Suelo s = (Suelo) objetos[i];
//                    datos[i][0] = "Suelo";
//                    datos[i][1] = new JLabel(s.getImagen());
//                    datos[i][2] = s.getNombre();
//                    datos[i][3] = new JButton("Editar");
//                    datos[i][4] = new JButton("Eliminar");
//                    break;
//                case "class Pared":
//                    Pared p = (Pared) objetos[i];
//                    datos[i][0] = "Pared";
//                    datos[i][1] = new JLabel(p.getImagen());
//                    datos[i][2] = p.getNombre();
//                    datos[i][3] = new JButton("Editar");
//                    datos[i][4] = new JButton("Eliminar");
//                    break;
//                case "class Goomba":
//                    Goomba g = (Goomba) objetos[i];
//                    datos[i][0] = "Goomba";
//                    datos[i][1] = new JLabel(g.getImagen());
//                    datos[i][2] = g.getNombre();
//                    datos[i][3] = new JButton("Editar");
//                    datos[i][4] = new JButton("Eliminar");
//                    break;
//                case "class Koopa":
//                    Koopa k = (Koopa) objetos[i];
//                    datos[i][0] = "Koopa";
//                    datos[i][1] = new JLabel(k.getImagen());
//                    datos[i][2] = k.getNombre();
//                    datos[i][3] = new JButton("Editar");
//                    datos[i][4] = new JButton("Eliminar");
//                    break;
//                case "class Ficha":
//                    Ficha f = (Ficha) objetos[i];
//                    datos[i][0] = "Ficha";
//                    datos[i][1] = new JLabel(f.getImagen());
//                    datos[i][2] = f.getNombre();
//                    datos[i][3] = new JButton("Editar");
//                    datos[i][4] = new JButton("Eliminar");
//                    break;
//                case "class Hongo":
//                    Hongo h = (Hongo) objetos[i];
//                    datos[i][0] = "Hongo";
//                    datos[i][1] = new JLabel(h.getImagen());
//                    datos[i][2] = h.getNombre();
//                    datos[i][3] = new JButton("Editar");
//                    datos[i][4] = new JButton("Eliminar");
//                    break;
//                case "class Personaje":
//                    Personaje pp = (Personaje) objetos[i];
//                    datos[i][0] = "Personaje";
//                    datos[i][1] = new JLabel(pp.getImagen());
//                    datos[i][2] = pp.getNombre();
//                    datos[i][3] = new JButton("Editar");
//                    datos[i][4] = new JButton("Eliminar");
//                    break;
//                case "class Castillo":
//                    Castillo c = (Castillo) objetos[i];
//                    datos[i][0] = "Castillo";
//                    datos[i][1] = new JLabel(c.getImagen());
//                    datos[i][2] = c.getNombre();
//                    datos[i][3] = new JButton("Editar");
//                    datos[i][4] = new JButton("Eliminar");
//                    break;
//                default:
//                    break; 
//            }
//            
//            jTable1.setRowHeight(40);
//            
//            jTable1.addMouseListener(new MouseAdapter(){
//                
//                public void MouseClicked(MouseEvent e){
//                    int fila = jTable1.rowAtPoint(e.getPoint());
//                    int columna = jTable1.columnAtPoint(e.getPoint());
//
//                /**
//                 * Preguntamos si hicimos clic sobre la celda que contiene el botón, si tuviéramos más de un botón 
//                 * por fila tendríamos que además preguntar por el contenido del botón o el nombre de la columna
//                 */
//                if (jTable1.getModel().getColumnClass(columna).equals(JButton.class)) {
//                    
////                    if(columna==3){
////                        Editar edit = new Editar();
////                        edit.setVisible(true);
////                    }else if(columna == 4){
////                        list.Eliminar(fila);
////                    }
//                    StringBuilder sb = new StringBuilder();
//                    for (int i = 0; i < jTable1.getModel().getColumnCount(); i++) {
//                        if (!jTable1.getModel().getColumnClass(i).equals(JButton.class)) {
//                            sb.append("\n").append(jTable1.getModel().getColumnName(i)).append(": ").append(jTable1.getModel().getValueAt(fila, i));
//                        }
//                    }
//                    JOptionPane.showMessageDialog(null, "Seleccionada la fila " + fila + sb.toString());
//                }
//            }
//        });
//                
//            
//        }
//        
//        jTable1.setModel(new javax.swing.table.DefaultTableModel(
//                datos,
//                columnas) {
//            // Esta variable nos permite conocer de antemano los tipos de datos de cada columna, dentro del TableModel
//            Class[] tipos = tiposColumnas;
//
//            @Override
//            public Class getColumnClass(int columnIndex) {
//                // Este método es invocado por el CellRenderer para saber que dibujar en la celda,
//                // observen que estamos retornando la clase que definimos de antemano.
//                return tipos[columnIndex];
//            }
//
//            @Override
//            public boolean isCellEditable(int row, int column) {
//                // Sobrescribimos este método para evitar que la columna que contiene los botones sea editada.
//                return !(this.getColumnClass(column).equals(JButton.class)||this.getColumnClass(column).equals(JLabel.class));
//            }
//        });
//        
//        jTable1.setDefaultRenderer(JButton.class, new TableCellRenderer() {
//            @Override
//            public Component getTableCellRendererComponent(JTable jtable, Object objeto, boolean estaSeleccionado, boolean tieneElFoco, int fila, int columna) {
//                /**
//                 * Observen que todo lo que hacemos en éste método es retornar el objeto que se va a dibujar en la 
//                 * celda. Esto significa que se dibujará en la celda el objeto que devuelva el TableModel. También 
//                 * significa que este renderer nos permitiría dibujar cualquier objeto gráfico en la grilla, pues 
//                 * retorna el objeto tal y como lo recibe.
//                 */
//                return (Component) objeto;
//            }
//        });
//        
//        jTable1.setDefaultRenderer(JLabel.class, new TableCellRenderer() {
//            @Override
//            public Component getTableCellRendererComponent(JTable jtable, Object objeto, boolean estaSeleccionado, boolean tieneElFoco, int fila, int columna) {
//                /**
//                 * Observen que todo lo que hacemos en éste método es retornar el objeto que se va a dibujar en la 
//                 * celda. Esto significa que se dibujará en la celda el objeto que devuelva el TableModel. También 
//                 * significa que este renderer nos permitiría dibujar cualquier objeto gráfico en la grilla, pues 
//                 * retorna el objeto tal y como lo recibe.
//                 */
//                return (Component) objeto;
//            }
//        });
        
    }
    
    private void setTable(){
        
        objetos = list.Pila();
        for(int i =0; i<objetos.length;i++){
            System.out.println(objetos[i].toString());
        }
        datos = new Object[objetos.length][5];
        
        for (int i=0; i<objetos.length;i++){
            //System.out.println(i);
            //System.out.println(objetos[i].getClass().toString());
            switch (objetos[i].getClass().toString()){
                case "class Suelo":
                    Suelo s = (Suelo) objetos[i];
                    datos[i][0] = "Suelo";
                    datos[i][1] = new JLabel(s.getImagen());
                    datos[i][2] = s.getNombre();
                    datos[i][3] = new JButton("Editar");
                    datos[i][4] = new JButton("Eliminar");
                    break;
                case "class Pared":
                    Pared p = (Pared) objetos[i];
                    datos[i][0] = "Pared";
                    datos[i][1] = new JLabel(p.getImagen());
                    datos[i][2] = p.getNombre();
                    datos[i][3] = new JButton("Editar");
                    datos[i][4] = new JButton("Eliminar");
                    break;
                case "class Goomba":
                    Goomba g = (Goomba) objetos[i];
                    datos[i][0] = "Goomba";
                    datos[i][1] = new JLabel(g.getImagen());
                    datos[i][2] = g.getNombre();
                    datos[i][3] = new JButton("Editar");
                    datos[i][4] = new JButton("Eliminar");
                    break;
                case "class Koopa":
                    Koopa k = (Koopa) objetos[i];
                    datos[i][0] = "Koopa";
                    datos[i][1] = new JLabel(k.getImagen());
                    datos[i][2] = k.getNombre();
                    datos[i][3] = new JButton("Editar");
                    datos[i][4] = new JButton("Eliminar");
                    break;
                case "class Ficha":
                    Ficha f = (Ficha) objetos[i];
                    datos[i][0] = "Ficha";
                    datos[i][1] = new JLabel(f.getImagen());
                    datos[i][2] = f.getNombre();
                    datos[i][3] = new JButton("Editar");
                    datos[i][4] = new JButton("Eliminar");
                    break;
                case "class Hongo":
                    Hongo h = (Hongo) objetos[i];
                    datos[i][0] = "Hongo";
                    datos[i][1] = new JLabel(h.getImagen());
                    datos[i][2] = h.getNombre();
                    datos[i][3] = new JButton("Editar");
                    datos[i][4] = new JButton("Eliminar");
                    break;
                case "class Personaje":
                    Personaje pp = (Personaje) objetos[i];
                    datos[i][0] = "Personaje";
                    datos[i][1] = new JLabel(pp.getImagen());
                    datos[i][2] = pp.getNombre();
                    datos[i][3] = new JButton("Editar");
                    datos[i][4] = new JButton("Eliminar");
                    break;
                case "class Castillo":
                    Castillo c = (Castillo) objetos[i];
                    datos[i][0] = "Castillo";
                    datos[i][1] = new JLabel(c.getImagen());
                    datos[i][2] = c.getNombre();
                    datos[i][3] = new JButton("Editar");
                    datos[i][4] = new JButton("Eliminar");
                    break;
                default:
                    break; 
            }
            
            jTable1.setRowHeight(40);
            
            jTable1.addMouseListener(new MouseListener(){
                
              

                @Override
                public void mouseClicked(MouseEvent e) {
                    int fila = jTable1.rowAtPoint(e.getPoint());
                    int columna = jTable1.columnAtPoint(e.getPoint());
                    
                    if(contador==0){
                        System.out.println(fila+" "+ columna);
                    if(columna==3){
                        
                        String nombre = String.valueOf(jTable1.getValueAt(fila, 2));
                        numero=fila;
                        tipo=true;
                        switch (objetos[fila].getClass().toString()){
                case "class Suelo":
                    list.Editar(numero, new Suelo(nombre));
                    break;
                case "class Pared":
                    list.Editar(numero, new Pared(nombre));
                    break;
                case "class Goomba":
                    list.Editar(numero, new Goomba(nombre));
                    break;
                case "class Koopa":
                    list.Editar(numero, new Koopa(nombre));
                    break;
                case "class Ficha":
                    list.Editar(numero, new Ficha(nombre));
                    break;
                case "class Hongo":
                    list.Editar(numero, new Hongo(nombre));
                    break;
                case "class Personaje":
                    list.Editar(numero, new Personaje(nombre));
                    break;
                case "class Castillo":
                    list.Editar(numero, new Castillo(nombre));
                    break;
                default:
                    break; 
            }

                    }else if(columna==4){
                        System.out.println("Hola");
                        numero=fila;
                        tipo=false;
                        list.Eliminar(numero);
                        
                    }
                    contador++;
                    }
                    
                }

                @Override
                public void mousePressed(MouseEvent e) {
//                    System.out.println("Dejo de Presionar1");
                }

                @Override
                public void mouseReleased(MouseEvent e) {
//                    System.out.println("Dejo de Presionar2");
                    
                }

                @Override
                public void mouseEntered(MouseEvent e) {
//                    System.out.println("Dejo de Presionar3");
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    System.out.println("Dejo de Presionar4");
                    contador=0;
                }
        });
                
            
        }
        
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                datos,
                columnas) {
            // Esta variable nos permite conocer de antemano los tipos de datos de cada columna, dentro del TableModel
            Class[] tipos = tiposColumnas;

            @Override
            public Class getColumnClass(int columnIndex) {
                // Este método es invocado por el CellRenderer para saber que dibujar en la celda,
                // observen que estamos retornando la clase que definimos de antemano.
                return tipos[columnIndex];
            }

            @Override
            public boolean isCellEditable(int row, int column) {
                // Sobrescribimos este método para evitar que la columna que contiene los botones sea editada.
                return !(this.getColumnClass(column).equals(JButton.class)||this.getColumnClass(column).equals(JLabel.class));
            }
        });
        
        jTable1.setDefaultRenderer(JButton.class, new TableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable jtable, Object objeto, boolean estaSeleccionado, boolean tieneElFoco, int fila, int columna) {
                /**
                 * Observen que todo lo que hacemos en éste método es retornar el objeto que se va a dibujar en la 
                 * celda. Esto significa que se dibujará en la celda el objeto que devuelva el TableModel. También 
                 * significa que este renderer nos permitiría dibujar cualquier objeto gráfico en la grilla, pues 
                 * retorna el objeto tal y como lo recibe.
                 */
                return (Component) objeto;
            }
        });
        
        jTable1.setDefaultRenderer(JLabel.class, new TableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable jtable, Object objeto, boolean estaSeleccionado, boolean tieneElFoco, int fila, int columna) {
                /**
                 * Observen que todo lo que hacemos en éste método es retornar el objeto que se va a dibujar en la 
                 * celda. Esto significa que se dibujará en la celda el objeto que devuelva el TableModel. También 
                 * significa que este renderer nos permitiría dibujar cualquier objeto gráfico en la grilla, pues 
                 * retorna el objeto tal y como lo recibe.
                 */
                return (Component) objeto;
            }
        });
    }
    
    public int getNumero(){
        return numero;
    }
    
    public String getCadena(){
        return cadena;
    }
    
    public boolean getTipo(){
        return tipo;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("LISTADO DE OBJETOS AGREGADOS");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(48, 48, 48))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Listado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Listado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Listado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Listado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Listado().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
