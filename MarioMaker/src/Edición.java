
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.TransferHandler;


//import javax.swing.ImageIcon;
//import javax.swing.JLabel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jose Antonio
 */
public class Edición extends javax.swing.JFrame {

    /**
     * Creates new form Edición
     */
    
    String seleccion = Opcion.envia.getSelectedItem().toString();
    ListaDE lista = ListaDE.getInstancia();
    int contador = 0;
    Object[] objetos;
    Matriz matriz = Matriz.getInstancia(); 
    Object[][] objetosMatriz;
    Boolean presionado = false;
    Boolean termino = false;
    public int suelo = Integer.parseInt(Inicio.c1.getText());
    public int pared = Integer.parseInt(Inicio.c2.getText());
    public int goomba = Integer.parseInt(Inicio.c3.getText());
    public int koopa = Integer.parseInt(Inicio.c4.getText());
    public int ficha = Integer.parseInt(Inicio.c5.getText());
    public int hongo = Integer.parseInt(Inicio.c6.getText());
    public int personaje = Integer.parseInt(Inicio.c7.getText());
    public int castillo = Integer.parseInt(Inicio.c8.getText());
    
    Archivo documento = new Archivo();
    int p = 1;
    
    public static Object[][] datos;
    
    public Edición() {
        initComponents();
        setLayout(null);
        recibe.setVisible(false);
//        ImageIcon imagen = new ImageIcon("C:/suelo.png");
//        JLabel label = new JLabel(imagen);
//        
//        label.setBounds(10, 10, 30, 30);
//        add(label);
        
        if(seleccion.equals("Pila")){
            objetos = lista.Pila();
            for(int i =0; i<objetos.length; i++){
                System.out.println(objetos[i]);
            }
            
        }else if(seleccion.equals("Cola")){
            objetos = lista.Cola();
            for(int i =0; i<objetos.length; i++){
                System.out.println(objetos[i]);
            }
            
        }
        
//        System.out.println(objetos.length);
        

        jScrollPane1.setViewportView(panel);
        jScrollPane1.getViewport().setView(panel);
        
        matriz.Inicio();
        matriz.NuevaFila();
        matriz.NuevaColumna();
        matriz.NuevaColumna();
        matriz.NuevaColumna();
        System.out.println(matriz.tamaño_x);
        System.out.println(matriz.tamaño_y);
        
        Pintar();
        
        
        MouseListener ml = new MouseListener(){

            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
                JComponent jc = (JComponent)e.getSource();
                TransferHandler th = jc.getTransferHandler();
                th.exportAsDrag(jc, e, TransferHandler.COPY);
                presionado = true;
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
                
                if(presionado){
                    contador++;
                    System.out.println("Contador: " + contador);
                }
            }
            
        };
        
        
        recibe.addMouseListener(ml);
        recibe.setTransferHandler(new TransferHandler("icon"));
        
        add(recibe);
        
    }
    
    public ImageIcon Imagen(String objeto, int numero){
        ImageIcon imagen;
        switch(objeto){
            case "class Suelo":
                    Suelo s = (Suelo) objetos[numero];
                    imagen = s.getImagen();
                    break;
                case "class Pared":
                    Pared p = (Pared) objetos[numero];
                    imagen = p.getImagen();
                    break;
                case "class Goomba":
                    Goomba g = (Goomba) objetos[numero];
                    imagen = g.getImagen();
                    break;
                case "class Koopa":
                    Koopa k = (Koopa) objetos[numero];
                    imagen = k.getImagen();
                    break;
                case "class Ficha":
                    Ficha f = (Ficha) objetos[numero];
                    imagen = f.getImagen();
                    break;
                case "class Hongo":
                    Hongo h = (Hongo) objetos[numero];
                    imagen = h.getImagen();
                    break;
                case "class Personaje":
                    Personaje pp = (Personaje) objetos[numero];
                    imagen = pp.getImagen();
                    break;
                case "class Castillo":
                    Castillo c = (Castillo) objetos[numero];
                    imagen = c.getImagen();
                    break;
                default:
                    imagen = null;
                    break;
        }
        return imagen;
    }
    
    public Object objeto(String objeto, int numero){
        switch(objeto){
                case "C:\\Users\\Jose Antonio\\Documents\\NetBeansProjects\\MarioMaker\\src\\suelo.png":
                    Suelo s = (Suelo) objetos[numero];
                    suelo--;
                    return s;
                    
                case "C:\\Users\\Jose Antonio\\Documents\\NetBeansProjects\\MarioMaker\\src\\pared.png":
                    Pared p = (Pared) objetos[numero];
                    pared--;
                    return p;
                    
                case "C:\\Users\\Jose Antonio\\Documents\\NetBeansProjects\\MarioMaker\\src\\goomba1.png":
                    Goomba g = (Goomba) objetos[numero];
                    goomba--;
                    return g;
                    
                case "C:\\Users\\Jose Antonio\\Documents\\NetBeansProjects\\MarioMaker\\src\\koopa1.png":
                    Koopa k = (Koopa) objetos[numero];
                    koopa--;
                    return k;
                    
                case "C:\\Users\\Jose Antonio\\Documents\\NetBeansProjects\\MarioMaker\\src\\ficha.png":
                    Ficha f = (Ficha) objetos[numero];
                    ficha--;
                    return f;
                    
                case "C:\\Users\\Jose Antonio\\Documents\\NetBeansProjects\\MarioMaker\\src\\hongo.png":
                    Hongo h = (Hongo) objetos[numero];
                    hongo--;
                    return h;
                    
                case "C:\\Users\\Jose Antonio\\Documents\\NetBeansProjects\\MarioMaker\\src\\mario.png":
                    Personaje pp = (Personaje) objetos[numero];
                    personaje--;
                    return pp;
                    
                case "C:\\Users\\Jose Antonio\\Documents\\NetBeansProjects\\MarioMaker\\src\\castillo.png":
                    Castillo c = (Castillo) objetos[numero];
                    castillo--;
                    return c;
                    
                default:
                    return null;
                    
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

        recibe = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        panel = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        fila = new javax.swing.JTextField();
        columna = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        recibe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Cuadro.png"))); // NOI18N

        jButton1.setText("Fila");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel7.setText("PANTALLA DE EDICION");

        jLabel2.setText("Deje presionado el mouse sobre el cuadro para seleccionar el objeto y arrastrelo hasta el espacio donde quiere.");

        panel.setMinimumSize(new java.awt.Dimension(2000, 2000));
        panel.setName(""); // NOI18N
        panel.setPreferredSize(new java.awt.Dimension(2000, 2000));
        panel.setRequestFocusEnabled(false);

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2000, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2000, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(panel);

        jButton2.setText("Iniciar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Agregar Columna");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Agregar Fila");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Eliminar");

        fila.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filaActionPerformed(evt);
            }
        });

        jButton5.setText("Columna");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel3.setText("Para quitar un objeto de una celda solo dele click a la imagen.");

        jButton6.setText("Ver Resumen");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("Jugar");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setText("Graficar");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel2))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(fila, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(columna, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton5))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(77, 77, 77)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(76, 76, 76)
                                .addComponent(recibe)))
                        .addGap(0, 15, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 579, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(jButton4)
                        .addComponent(jButton8)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(recibe)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jButton6)
                        .addGap(18, 18, 18)
                        .addComponent(jButton7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(fila, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(columna, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton5))
                        .addGap(94, 94, 94))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        //Empieza a mostrarse la imagen
        recibe.setIcon(Imagen(objetos[contador].getClass().toString(),contador));
        recibe.setVisible(true);
        jButton2.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if(matriz.tamaño_y > 0){
            if(fila.getText().equals("")){
            
        }else{
           if (matriz.eliminarFila(Integer.parseInt(fila.getText()))==false){
               JOptionPane.showMessageDialog(this, "No se puede borrar la fila: "+fila.getText()+
                       " porque tiene objetos.",
				"Error", JOptionPane.OK_OPTION);
           }else{
               panel.removeAll();
               panel.repaint();
               Pintar();
           }
        }
        
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        //Agregar fila a la matriz
        matriz.NuevaFila();
        panel.removeAll();
        panel.repaint();

//        Lienzo l = new Lienzo();
//        jScrollPane1.setViewportView(l);
//        jScrollPane1.revalidate();
        System.out.println(matriz.tamaño_x);
        System.out.println(matriz.tamaño_y);
        
        Pintar();
    }//GEN-LAST:event_jButton4ActionPerformed
        
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        matriz.NuevaColumna();
        panel.removeAll();
        panel.repaint();
        
//        Lienzo l = new Lienzo();
//        jScrollPane1.setViewportView(l);
//        jScrollPane1.revalidate();
        System.out.println(matriz.tamaño_x);
        System.out.println(matriz.tamaño_y);

        Pintar();  
    }//GEN-LAST:event_jButton3ActionPerformed

    private void filaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_filaActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        //Eliminar columna
        if(matriz.tamaño_x > 0){
            if(columna.getText().equals("")){
            
        }else{
            if(matriz.eliminarColumna(Integer.parseInt(columna.getText()))==false){
                JOptionPane.showMessageDialog(this, "No se puede borrar la columna: "+columna.getText()+
                       " porque tiene objetos.",
				"Error", JOptionPane.OK_OPTION);
            }else{
                panel.removeAll();
                panel.repaint();
                Pintar();
            }
        }
        
        }  
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        
        datos = new Object[][]{
            {"Suelo",suelo},
            {"Pared",pared},
            {"Goomba",goomba},
            {"Koopa",koopa},
            {"Ficha",ficha},
            {"Hongo de vida",hongo},
            {"Personaje",personaje},
            {"Castillo final",castillo}
    };
        
        Resumen r = new Resumen();
        r.setVisible(true);
        
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        Juego juego = new Juego();
        juego.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        
        String[] texto = matriz.getCodigo();
        String codigo = "graph grafica{\n"+texto[0]+"\n"+texto[1]+"}";
        
        try {
            documento.crearTxt(codigo,"Matriz"+p+".txt");
            System.out.println("Matriz"+p+".txt");
        } catch (IOException ex) {
            Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
      
      //CAMBIAR LA DIRECCION DEL DOT.EXE PARA QUE SE PUEDA EJECUTAR
      String dotPath = "C:\\Users\\Jose Antonio\\Desktop\\Graphviz\\bin\\dot.exe";
      
      String fileInputPath = "Matriz"+p+".txt";
      String fileOutputPath = "Matriz"+p+".jpg";
      
      String tParam = "-Tjpg";
      String tOParam = "-o";
        
      String[] cmd = new String[5];
      cmd[0] = dotPath;
      cmd[1] = tParam;
      cmd[2] = fileInputPath;
      cmd[3] = tOParam;
      cmd[4] = fileOutputPath;
                  
      Runtime rt = Runtime.getRuntime();
      
      rt.exec( cmd );
      
    } catch (Exception ex) {
      ex.printStackTrace();
    } finally {
    }
        //Mostrar Imagen
        Imagen imagen = new Imagen();
        imagen.setVisible(true);
        
        imagen.setImagen(new ImageIcon("Matriz"+p+".jpg"));
        
        p++;
        
    }//GEN-LAST:event_jButton8ActionPerformed
    
    public void Pintar(){
        
        
        
        objetosMatriz = matriz.getMatrizInicial();
        
        for(int i=0;i<matriz.tamaño_y;i++){
            for(int j=0;j<matriz.tamaño_x;j++){
//                System.out.println(objetosMatriz[i][j].toString());
                NodoMatriz nodo = (NodoMatriz)objetosMatriz[i][j];
                nodo.setX(j*30);
                nodo.setCX(j);
                nodo.setY((matriz.tamaño_y - (i+1))*30);
                nodo.setCY(i);
                nodo.setIcon(new ImageIcon(nodo.getRuta()));
                nodo.setBounds(nodo.getX(),nodo.getY(),30,30);
                
                nodo.setName("X:"+nodo.getCX()+" "+"Y:"+nodo.getCY());
                
//                System.out.println("Objeto: " + nodo.getObject() + "Fila:"+nodo.getCY()+"Columna:"+nodo.getCX()+" "+"Ruta:" + nodo.getRuta());
                nodo.addMouseListener(new MouseListener() {

                    @Override
                    public void mouseClicked(MouseEvent e) {
                        
                        NodoMatriz n = (NodoMatriz)e.getSource();
                        lista.Nuevo(n.getObject());
                        if(seleccion.equals("Pila")){
                            objetos = lista.Pila();
                            for(int i =0; i<objetos.length; i++){
                                System.out.println("Nueva Lista");
                                System.out.println(objetos[i]);
                            }
            
                        }else if(seleccion.equals("Cola")){
                            objetos = lista.Cola();
                            for(int i =0; i<objetos.length; i++){
                                System.out.println("Nueva Lista");
                                System.out.println(objetos[i]);
                            }
            
                        }
                        System.out.println(n.getIcon().toString());
                        n.setRuta("C:\\Users\\Jose Antonio\\Documents\\NetBeansProjects\\MarioMaker\\src\\Cuadro.png");
                        n.setIcon(new ImageIcon("C:\\Users\\Jose Antonio\\Documents\\NetBeansProjects\\MarioMaker\\src\\Cuadro.png"));
                        if(termino){
                            recibe.setVisible(true);
                            if(seleccion.equals("Pila")){
                                contador = objetos.length-1;
                            }else if(seleccion.equals("Cola")){
                                contador = objetos.length-1;
                            }
                            
                        }
                    }

                    @Override
                    public void mousePressed(MouseEvent e) {
                    }

                    @Override
                    public void mouseReleased(MouseEvent e) {
                    }

                    @Override
                    public void mouseEntered(MouseEvent e) {
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        
                        System.out.println("Se solto el mouse");
//                recibe.setIcon(Imagen(objetos[contador].getClass().toString(),contador));
//                contador++;
                        NodoMatriz l = (NodoMatriz)e.getSource();
                if(presionado){
//                    contador++;
                    if(contador==objetos.length){
                        recibe.setVisible(false);
//                        System.out.println(recibe.getX());
//                        System.out.println(recibe.getY());
//                        System.out.println(recibe.getWidth());
                        contador=0;
                        termino=true;
                        if(termino ==true){
                            l.setRuta(l.getIcon().toString());
                        }
                    }
                    recibe.setIcon(Imagen(objetos[contador].getClass().toString(),contador));
                    
                
                        
                        
//                        System.out.println(l.getText());
//                        System.out.println(l.getIcon().toString());
//                        System.out.println(contador-1);
                        String ruta = l.getIcon().toString();
                        if(termino==false){
                            l.setObject(objeto(ruta,contador-1));
                            l.setRuta(ruta);
                            presionado = false;
                            System.out.println("Esta presionado y aqui se guarda la ruta ---");
                            System.out.println(l.getRuta());
                            System.out.println(l.getObject());
                        }
                        }
                    }
                });
                nodo.setTransferHandler(new TransferHandler("icon"));
                
                panel.add(nodo);
                
            }
        }
        
        for(int i=0;i<matriz.tamaño_y;i++){
            for(int j=0;j<matriz.tamaño_x;j++){
                NodoMatriz nodo = (NodoMatriz)objetosMatriz[i][j];
                
                System.out.println(" ");
                System.out.println("Coordenadas:("+nodo.getCY()+","+nodo.getCX()+")" + " ID: " + nodo.getID());
                System.out.println("Imagen:" + nodo.getRuta());
                System.out.println("Posicion:" + nodo.getY() + ","+nodo.getX());
//                if(nodo.getAbajo()!=null){
//                    System.out.println("Abajo: " + nodo.getAbajo().getID());
//                    System.out.println("Imagen:" + nodo.getAbajo().getRuta());
//                }
//                if(nodo.getArriba()!=null){
//                    System.out.println("Arriba: " + nodo.getArriba().getID());
//                System.out.println("Imagen:" + nodo.getArriba().getRuta());
//                }
//                if(nodo.getIzquierda()!=null){
//                    System.out.println("Izquierda: " + nodo.getIzquierda().getID());
//                    System.out.println("Imagen:" + nodo.getIzquierda().getRuta());
//                }
//                if(nodo.getDerecha()!=null){
//                    System.out.println("Derecha:" + nodo.getDerecha().getID());
//                   System.out.println("Imagen:" + nodo.getDerecha().getRuta());
//                
//                }

                
            }
        }
    }
    
    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(Edición.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Edición.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Edición.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Edición.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Edición().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField columna;
    private javax.swing.JTextField fila;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panel;
    private javax.swing.JLabel recibe;
    // End of variables declaration//GEN-END:variables
}
