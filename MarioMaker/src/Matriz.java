
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
public class Matriz{
    public int tamaño_x = 0;
    public int tamaño_y = 0;
    NodoMatriz inicio;
    int contador=0;
    
    public void Inicio(){
        if(inicio == null){
            inicio = new NodoMatriz(0,0);
            tamaño_x++;
            tamaño_y++;
            inicio.setID(contador);
            contador++;
        }
    }
    
    public Object[][] getMatrizInicial(){
        Object[][] matriz = new Object[tamaño_y][tamaño_x];
        int i,j;
        //Almacenar todos los objetos contenidos en los nodos en la matriz para eso se debe de recorrer la matriz ortogonal
        NodoMatriz temp = inicio;
        i=0;
        j=0;
        
        matriz[i][j]=inicio;
        j++;
        while(temp.TieneDerecha()){
            temp = temp.getDerecha();
            matriz[i][j] = temp;
            j++;
        }
        j=0;
        temp = inicio;
        while(temp.TieneArriba()){
            
            temp = temp.getArriba();
            i++;
            matriz[i][j] = temp;
            NodoMatriz temp2 = temp;
            
            while(temp2.TieneDerecha()){
                temp2 = temp2.getDerecha();
                j++;
                matriz[i][j] = temp2;
            }
            j=0;
        }
        
        i=0;
        j=0;
        
        return matriz;
    }
    
    public void NuevaFila(){
        
        
        NodoMatriz temp = recorrerArriba(inicio);
        NodoMatriz aux = null;
        
        if(temp!=null){
            temp.setArriba(new NodoMatriz(temp,0,0,null,"abajo"));
            aux = temp.getArriba();
            aux.setID(contador);
            contador++;
            temp = inicio;
        }
        
        
        while(temp.TieneDerecha()){
            temp = temp.getDerecha();
            
            NodoMatriz arriba = recorrerArriba(temp);
            if(arriba!=null){
                arriba.setArriba(new NodoMatriz(arriba,0,0,null,"abajo"));
                arriba.getArriba().setIzquierda(aux);
                arriba.getArriba().setID(contador);
                contador++;
                aux.setDerecha(arriba.getArriba());
                aux = arriba.getArriba();
            }
        }

        tamaño_y++;
        
    }
    
    public void NuevaColumna(){
        
        NodoMatriz temp = recorrerDerecha(inicio);
        NodoMatriz aux = null;
        
        if(temp!=null){
            temp.setDerecha(new NodoMatriz(temp,0,0,null,"izq"));
            aux = temp.getDerecha();
            aux.setID(contador);
            contador++;
            temp = inicio;
        }
        
        
        while(temp.TieneArriba()){
            temp = temp.getArriba();
            
            NodoMatriz derecha = recorrerDerecha(temp);
            if(derecha!=null){
                derecha.setDerecha(new NodoMatriz(derecha,0,0,null,"izq"));
                derecha.getDerecha().setAbajo(aux);
                derecha.getDerecha().setID(contador);
                contador++;
                aux.setArriba(derecha.getDerecha());
                aux = derecha.getDerecha();
            }
        }
        
        tamaño_x++;
    }
    
    public NodoMatriz recorrerArriba(NodoMatriz inicio){
        NodoMatriz temp = inicio;
        while(temp.TieneArriba()){
            temp = temp.getArriba();
        }
        return temp;
    }
    
    public NodoMatriz recorrerArriba(NodoMatriz inicio,int n){
        NodoMatriz temp = inicio;
        while(temp.getCY()!= n){
            if(temp.TieneArriba()){
                temp = temp.getArriba();
            }
            
        }
        return temp;
    }
    
    public NodoMatriz recorrerDerecha(NodoMatriz inicio){
        NodoMatriz temp = inicio;
        while(temp.TieneDerecha()){
            temp = temp.getDerecha();
        }
        return temp;
    }
    
    public NodoMatriz recorrerDerecha(NodoMatriz inicio,int n){
        NodoMatriz temp = inicio;
        while(temp.getCX()!=n){
            if(temp.TieneDerecha()){
                temp = temp.getDerecha();
            }
            
        }
        return temp;
    }
    
    public boolean eliminarFila(int y){
        
        NodoMatriz temp = recorrerArriba(inicio,y);
        NodoMatriz in = temp;
        NodoMatriz aux = in;
        NodoMatriz arriba;
        NodoMatriz abajo;
        boolean tiene = false;
        
        if(aux.TieneObjeto()){
            tiene = true;
        }else{
            while(aux.TieneDerecha()){
                aux = aux.getDerecha();
                if(aux.TieneObjeto()){
                    tiene = true;
                }
            }
        }
        
        if(tiene == true){
            
            return false; 
            
        }else{
            
        
        if(in!=null){
            
            arriba = in.getArriba();
            abajo = in.getAbajo();
            if(arriba!=null){
                arriba.setAbajo(abajo);
            }
            if(abajo!=null){
                abajo.setArriba(arriba);
                minimizarFila(abajo);
            }else{
                if(arriba!=null){
                    minimizarFila(arriba);
                    arriba.setCY(arriba.getCY()-1);
                }
            }
            
        }

        while(temp.TieneDerecha()){
            temp = temp.getDerecha();
            
            
            if(temp!=null){
                arriba = temp.getArriba();
                abajo = temp.getAbajo();
                if(arriba!=null){
                   arriba.setAbajo(abajo);
                }
                if(abajo!=null){
                   abajo.setArriba(arriba);
                   minimizarFila(abajo);
                }else{
                    if(arriba!=null){
                        minimizarFila(arriba);
                        arriba.setCY(arriba.getCY()-1);
                    }
                }
                temp.setAbajo(null);
                temp.setArriba(null);
                temp.setIzquierda(null);
            }
            
        }
        
        if(temp!=null){
                arriba = temp.getArriba();
                abajo = temp.getAbajo();
                if(arriba!=null){
                   arriba.setAbajo(abajo);
                }
                if(abajo!=null){
                   abajo.setArriba(arriba);
                   minimizarFila(abajo);
                }else{
                    if(arriba!=null){
                        minimizarFila(arriba);
                        arriba.setCY(arriba.getCY()-1);
                    }
                }
                
            }
        temp.setAbajo(null);
        temp.setArriba(null);
        temp.setIzquierda(null);
        temp.setDerecha(null);
        in.setAbajo(null);
        in.setArriba(null);
        tamaño_y--;
        return false;
        }
    }
    
    public boolean eliminarColumna(int y){
        
        NodoMatriz temp = recorrerDerecha(inicio,y);
        NodoMatriz in = temp;
        NodoMatriz aux = in;
        NodoMatriz derecha;
        NodoMatriz izquierda;
        boolean tiene = false;
        
        if(aux.TieneObjeto()){
            tiene = true;
        }else{
            while(aux.TieneArriba()){
                aux = aux.getArriba();
                if(aux.TieneObjeto()){
                    tiene = true;
                }
            }
        }
        if(tiene){
            return false;
        }else{
            
        
        if(in!=null){
            
            derecha = in.getDerecha();
            izquierda = in.getIzquierda();
            if(derecha!=null){
                derecha.setIzquierda(izquierda);
            }
            if(izquierda!=null){
                izquierda.setDerecha(derecha);
                minimizarColumna(izquierda);
            }else{
                if(derecha!=null){
                    minimizarColumna(derecha);
                    derecha.setCX(temp.getCX()-1);
                }
            }
            
        }

        while(temp.TieneArriba()){
            temp = temp.getArriba();
            
            if(temp!=null){
                derecha = temp.getDerecha();
                izquierda = temp.getIzquierda();
                if(derecha!=null){
                    derecha.setIzquierda(izquierda);
                
                }
                if(izquierda!=null){
                    izquierda.setDerecha(derecha);
                    minimizarColumna(izquierda);
                }else{
                    if(derecha!=null){
                        minimizarColumna(derecha);
                        derecha.setCX(temp.getCX()-1);
                    }
                }
            }
                temp.setAbajo(null);
                temp.setDerecha(null);
                temp.setIzquierda(null);
        }
        
        if(temp!=null){
                derecha = temp.getDerecha();
                izquierda = temp.getIzquierda();
                if(derecha!=null){
                    derecha.setIzquierda(izquierda);
                
                }
                if(izquierda!=null){
                    izquierda.setDerecha(derecha);
                    minimizarColumna(izquierda);
                }else{
                    if(derecha!=null){
                        minimizarColumna(derecha);
                        derecha.setCX(temp.getCX()-1);
                    }
                }
            }
        temp.setAbajo(null);
        temp.setDerecha(null);
        temp.setIzquierda(null);
        in.setAbajo(null);
        in.setDerecha(null);
        tamaño_x--;
        return true;
        }
    }
    
    public void minimizarFila(NodoMatriz n){
        NodoMatriz temp = n;
        while(temp.TieneArriba()){
            temp = temp.getArriba();
            
            temp.setCY(temp.getCY()-1);
            
        }
    }
    
    public void minimizarColumna(NodoMatriz n){
        NodoMatriz temp = n;
        while(temp.TieneDerecha()){
            temp = temp.getDerecha();
            
            temp.setCX(temp.getCX()-1);
            
        }
    }
    
}
