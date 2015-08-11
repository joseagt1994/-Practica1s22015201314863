

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author JOSEGT
 */
public class Archivo {
    File f;
//    FileReader lector;
    FileWriter escritor;
    
    
    public void crearTxt(String texto,String nombre) throws IOException{
        
        try{
        f=new File(nombre);
        escritor = new FileWriter(f);
        BufferedWriter bw = new BufferedWriter(escritor);
        PrintWriter salida = new PrintWriter(bw);
        
        salida.write(texto);
        
        salida.close();
        bw.close();
        
    }catch(IOException e){System.out.println("Error: "+e.getMessage());}
    
}
    public void eliminar(String texto){
        File fichero = new File(texto);
        fichero.delete();
    }

}