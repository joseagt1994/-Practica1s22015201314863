/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jose Antonio
 */
public class ListaDE extends NodoDE{
    NodoDE inicio;
    int tamaño;
    NodoDE fin;
    
    static private ListaDE lista = null;
    
    private ListaDE(){}
    
        static public ListaDE getInstancia(){
            if(lista==null){
                lista = new ListaDE();
                }
            return lista;
        
    }
    
    public boolean Nuevo(Object o){
        if(inicio==null){
            inicio = new NodoDE(null,o,null);
            inicio.setID(tamaño);
            tamaño++;
            return true;
        }else{
            NodoDE temp = inicio;
            while(temp.TieneSiguiente()){
                temp = temp.getSiguiente();
                
            }
            temp.setSiguiente(new NodoDE(temp,o,null));
            temp.getSiguiente().setID(tamaño);
            tamaño++;
            fin = temp.getSiguiente();
            return true;
        }
    }
    
    public Object[] Pila(){
        
        int contador = 0;
        Object[] temporal = new Object[tamaño];
        NodoDE temp = inicio;
        while(temp.TieneSiguiente()){
            temporal[contador]=temp.getObjeto();
            temp = temp.getSiguiente();
            contador++;
        }
        temporal[contador]=fin.getObjeto();
        return temporal;
        
    }
    
    public Object[] Cola(){
        int contador = 0;
        Object[] temporal = new Object[tamaño];
        NodoDE temp = fin;
        while(temp.TieneAnterior()){
            temporal[contador]=temp.getObjeto();
            temp = temp.getAnterior();
            contador++;
        }
        temporal[contador]=inicio.getObjeto();
        return temporal;
    }
    
    public boolean Eliminar(int numero){
        int contador=0;
        NodoDE temp = inicio;
        while(temp.TieneSiguiente()){
            
            
            if(temp.getID()==numero){
                
                
                
                if(temp.getAnterior()!=null){
                temp.getAnterior().setSiguiente(temp.getSiguiente());
            }
                if(temp.getSiguiente()!=null){
                temp.getSiguiente().setAnterior(temp.getAnterior());
            }
                
                if(contador==0){
                    inicio = temp.getSiguiente();
                }
            }
            
            temp = temp.getSiguiente();
            contador++;
        }
        
        
//        temp.setAnterior(null);
//        temp.setSiguiente(null);
        tamaño--;
        return true;
    }
    
    public boolean Editar(int numero,Object obj){
        
        NodoDE temp = inicio;
        while(temp.TieneSiguiente()){
            temp = temp.getSiguiente();
            
            if(temp.getID()==numero){
                temp.setObjeto(obj);
            }
        }
        
        return true;
    }
    
    public String[] getCodigo(){
        String[] cadenas = new String[2];
        int c=0;
        String codigo="";
        String valores="";
        NodoDE temp = inicio;
        while(temp.TieneSiguiente()){
            
            valores+= "nodo " + c + "[label=" + temp.getObjeto().toString() + "]"+"/n";
            if(temp.TieneAnterior()){
                codigo+= "nodo"+temp.getID()+" -- " + "nodo"+temp.getAnterior().getID()+"/n";
            }
            if(temp.TieneSiguiente()){
                codigo+= "nodo"+temp.getID()+" -- " + "nodo"+temp.getSiguiente().getID()+"/n";
            }
            temp = temp.getSiguiente();
            
        }
        valores+= "nodo " + c + "[label=" + temp.getObjeto().toString() + "]"+"/n";
            if(temp.TieneAnterior()){
                codigo+= "nodo"+temp.getID()+" -- " + "nodo"+temp.getAnterior().getID()+"/n";
            }
            if(temp.TieneSiguiente()){
                codigo+= "nodo"+temp.getID()+" -- " + "nodo"+temp.getSiguiente().getID()+"/n";
            }
            
            cadenas[0]=valores;
            cadenas[1]=codigo;
            
        return cadenas;
    }
    
}
