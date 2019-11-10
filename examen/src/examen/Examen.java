/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author David Ventura
 */

public class Examen {

    /**
     * @param args the command line arguments
     */
    
    
    public static alumno alumnos[] ;
    public static void main(String[] args) {
        // TODO code application logic here
        
        alumnos = new alumno[100];
        
        insertarDatos();
        
    }
    
    
    public static alumno getDerecha (int base) {
        return alumnos[base*2 + 1];
    }
    
    public static alumno getIzquierda (int base) {
        return alumnos[base *2 +2];
    }
    
    public static alumno getPadre (int base) {
        return alumnos[((base -1)/2)];
    }
    
    public static void insertarDatos () {
        // realiza carga masiva para obtener los datos del forato .csv
        
        JOptionPane.showMessageDialog(null, "Selecciona el archivo de carga masiva.");
        
        JFileChooser filechooser = new JFileChooser ();
        
        filechooser.showOpenDialog(filechooser);
        
        try {
            // abre el archivo y extrae la información necesaria
            String ruta = filechooser.getSelectedFile().getAbsolutePath();
            File archivo = new File (ruta) ;
            FileReader  fr = new FileReader (archivo);
            BufferedReader br = new BufferedReader (fr);
            
            String contenido  = "";
            String linea = br.readLine() ;
            int index = 0;
            
            // recorre cada fila del archivo
            while ( (  linea = br.readLine() ) != null ) {
                
                String datos[] = linea.split(",");
                
                String id = datos [0] ;
                String nombre = datos[1];
                
                alumno alumno_ = new alumno(datos [0], datos [1]);
                
                alumnos[index] = alumno_;
                
                contenido += linea;
                index ++;
                
            }
            
            
        } catch (Exception e) {JOptionPane.showMessageDialog(null, "No se ha podido encontrar el archivo.");}
        
        
        
        
    }
    
    public static void generarJS () {
        // genera el reporte de datos js
        
    }
    
}
