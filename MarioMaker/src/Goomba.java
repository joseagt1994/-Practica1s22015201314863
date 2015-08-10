
import javax.swing.ImageIcon;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jose Antonio
 */
public class Goomba {
    ImageIcon suelo = new ImageIcon("C:\\Users\\Jose Antonio\\Documents\\NetBeansProjects\\MarioMaker\\src\\goomba1.png");
    String nombre;
    
    public Goomba(String s){
        this.nombre = s;
    }
    
    public ImageIcon getImagen(){
        return suelo;
    }
    
    public void setNombre(String s){
        this.nombre = s;
    }
    
    public String getNombre(){
        return nombre;
    }
}
