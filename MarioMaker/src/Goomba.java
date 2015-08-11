
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jose Antonio
 */
public class Goomba extends Thread implements Runnable{
    ImageIcon goomba = new ImageIcon("C:\\Users\\Jose Antonio\\Documents\\NetBeansProjects\\MarioMaker\\src\\goomba1.png");
    String nombre;
    Image buffer;
    Graphics g;
    boolean seguir = true;
    boolean fill = true;
    private JPanel juego;
    
    int x =0;
    int y= 0;
    int xg = 10;
    
    public Goomba(String s){
        this.nombre = s;
    }
    
    public Goomba(JPanel panel){
        juego = panel;
        
    }

    @Override
    public void run(){
        
        while(seguir){
            move();
            rebotar();
            paint(juego.getGraphics());
            retrasar();
            eliminar();
        }
        
    }
    
    public void setXY(int x, int y){
        this.x=x;
        this.y=y;
    }
    
    void move(){
        x = x + xg;
//        if (x + xg > 0 && x + xg < juego.getWidth()-60){
//			x = x + xg;
//	}
    }
    
    public void rebotar(){
        if(x<=0 || x>=juego.getWidth()-30){
            xg = -xg;
        }
    }
    
    private boolean colisionar(){
        
        return true;
    }
    
    public void retrasar(){
        
        try {
            
                Thread.sleep(200);    
                juego.removeAll();
                juego.repaint();
                
            } catch (InterruptedException ex) {
                Logger.getLogger(Juego.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    
    public void paint(Graphics g){
//        buffer = juego.createImage(juego.getWidth(),juego.getHeight());
//        g = buffer.getGraphics();
////        g = juego.getGraphics();
//        updatePaint(g);
//        g = juego.getGraphics();
//        g.drawImage(suelo.getImage(), x, y, juego);
        update(g);
    }
    
    public void eliminar(){
        
        g = juego.getGraphics();
        g.drawImage(goomba.getImage(), x, y, juego);
    }
    
//    public Rectangle getBounds() {
//		return new Rectangle(x, y, 30, 30);
//	}
    
    public ImageIcon getImagen(){
        return goomba;
    }
    
    public void setNombre(String s){
        this.nombre = s;
    }
    
    public String getNombre(){
        return nombre;
    }

    private void update(Graphics g) {
         Color bg = juego.getBackground();
         Color fg = juego.getForeground();
         
         if(fill){
             g.drawImage(goomba.getImage(), x, y, juego);
             fill=false;
         }else{
             g.setColor(bg);
             g.drawImage(goomba.getImage(), x, y, juego);
//             g.fillRect(x, y, 30, 30);
             g.setColor(fg);
             fill=true;
         }
    }
}
