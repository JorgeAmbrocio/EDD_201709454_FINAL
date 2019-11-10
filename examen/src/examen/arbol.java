/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen;

import static examen.Examen.alumnos;
import static examen.Examen.insertarDato_;
import javax.swing.JOptionPane;

/**
 *
 * @author David Ventura
 */
public class arbol {
    
    public alumno alumnos [] ;
    
    public arbol () {
        alumnos = new alumno[100];
    }
    
    public void insertar (alumno al_ ) {
        
        
        
    }
    
    public void insertar(alumno al_ , int indice){
        if (indice > 99) {
            JOptionPane.showMessageDialog(null, "Se ha alcanzado la profundidad máxima representada en el vector de datos", "error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        
        // verificar si el indice está vacío
        if (alumnos[indice] == null) {
            // insertar en esta posoción
            alumnos[indice]  = al_;
        }else {
            
            if (al_.nombre.compareToIgnoreCase(alumnos[indice].nombre)< 0) {
                // insertar a la izquierda
                insertarDato_(al_, indice * 2 +1);
                
                
            }else {
                // insertar a la derecha
                insertarDato_(al_, indice * 2 +2);
                
                    
            }
            
        }
    }
    
    public void rotarIzquierda (int indice) {
        
        alumno aux = this.alumnos[indice * 2  +2];
        
        this.alumnos[indice*2 +1] = this.alumnos[indice*2+2];
        
        
    }
    
    
    
    
}
