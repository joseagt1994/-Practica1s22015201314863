
import javax.swing.JLabel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jose Antonio
 */
public class NodoMatriz extends JLabel{
    private NodoMatriz arriba = null;
    private NodoMatriz abajo = null;
    private NodoMatriz izquierda = null;
    private NodoMatriz derecha = null;
    
    private Object objeto;
    private String ruta = "C:\\Users\\Jose Antonio\\Documents\\NetBeansProjects\\MarioMaker\\src\\Cuadro.png";
    private int fila = 0;
    private int columna = 0;
    private int coordenada_x =0;
    private int coordenada_y=0;
    public int id;
    
    public NodoMatriz(){
        
    }
    //Nodo nuevo
    public NodoMatriz(int f, int c){
        this.fila = f;
        this.columna = c;
    }
    
    //Nodo que se agrega a la derecha de un nodo
    public NodoMatriz(NodoMatriz nodo, int f, int c, Object obj, String s){
        if(s.equals("abajo")){
            
            this.abajo = nodo;
            this.fila = f;
            this.columna = c;
            this.objeto = obj;
            
        }else if(s.equals("izq")){
            
            this.izquierda = nodo;
            this.fila = f;
            this.columna = c;
            this.objeto = obj;
            
        }
        
    }
    
    public void setArriba(NodoMatriz n){
        this.arriba = n;
    }
    
    public NodoMatriz getArriba(){
        return arriba;
    }
    
    public void setAbajo(NodoMatriz n){
        this.abajo = n;
    }
    
    public NodoMatriz getAbajo(){
        return abajo;
    }
    
    public void setDerecha(NodoMatriz n){
        this.derecha = n;
    }
    
    public NodoMatriz getDerecha(){
        return derecha;
    }
    
    public void setIzquierda(NodoMatriz n){
        this.izquierda = n;
    }
    
    public NodoMatriz getIzquierda(){
        return izquierda;
    }
    
    public void setObject(Object obj){
        this.objeto = obj;
    }
    
    public Object getObject(){
        return objeto;
    }
    
    public void setX(int n){
        this.columna = n;
    }
    
    public int getX(){
        return columna;
    }
    
    public void setY(int n){
        this.fila = n;
    }
    
    public int getY(){
        return fila;
    }
    
    public void setRuta(String s){
        this.ruta = s;
    }
    
    public String getRuta(){
        return ruta;
    }
    
    public void setCX(int s){
        this.coordenada_x = s;
    }
    
    public int getCX(){
        return coordenada_x;
    }
    
    public void setCY(int s){
        this.coordenada_y = s;
    }
    
    public int getCY(){
        return coordenada_y;
    }
    
    public void setID(int s){
        this.id = s;
    }
    
    public int getID(){
        return id;
    }
    
    public boolean TieneArriba(){
        return arriba!=null;
    }
    
    public boolean TieneDerecha(){
        return derecha!=null;
    }
    
    public boolean TieneAbajo(){
        return abajo!=null;
    }
    
    public boolean TieneIzquierda(){
        return izquierda!=null;
    }
    
    public boolean TieneObjeto(){
        return objeto!=null;
    }
}
