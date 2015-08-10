/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jose Antonio
 */
public class NodoDE {
    
    private NodoDE anterior;
    private NodoDE siguiente;
    private Object objeto;
    int ID = 0;
    
    public NodoDE(){
        
    }
    
    public NodoDE(NodoDE anterior, Object obj, NodoDE siguiente){
        this.anterior = anterior;
        this.objeto = obj; 
        this.siguiente = siguiente;
    }
    
    public void setSiguiente(NodoDE sig){
        this.siguiente = sig;
    }
    
    public NodoDE getSiguiente(){
        return siguiente;
    }
    
    public void setAnterior(NodoDE ant){
        this.anterior = ant;
    }
    
    public NodoDE getAnterior(){
        return anterior;
    }
    
    public void setObjeto(Object obj){
        this.objeto = obj;
    }
    
    public Object getObjeto(){
        return objeto;
    }
    
    public void setID(int n){
        this.ID = n;
    }
    
    public int getID(){
        return ID;
    }
    
    public boolean TieneSiguiente(){
        return siguiente!=null;
    }
    
    public boolean TieneAnterior(){
        return anterior!=null;
    }
    
}
