/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author David Ventura
 */
public class arbol {
    
    public alumno alumnos [] ;
    public int taman = 0 ;
    
    public arbol () {
        alumnos = new alumno[1000];
    }
    
   
    
    public void insertar (alumno al_ ) {
        
        this.insertarDato_(al_, 0);
        
    }
    
    public void insertarDato_(alumno al_ , int indice){
        if (indice > 999) {
            //JOptionPane.showMessageDialog(null, "Se ha alcanzado la profundidad máxima representada en el vector de datos", "error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        
        // verificar si el indice está vacío
        if (alumnos[indice] == null) {
            // insertar en esta posoción
            alumnos[indice]  = al_;
            this.taman ++;
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
    
    public void insertarOrdenado (alumno al) {
        this.alumnos[taman] = al;
        this.taman ++;
    }
    
    
    public void crearOrdenado () {
        //copiar los datos actuales
        alumno [] al0 = this.alumnos;
        alumno [] al1 = new alumno[this.taman];
        
        int contador = 0;
        for (int i  = 0 ; i < 900 ; i ++) {
            if (this.alumnos[i] != null) {
                al1[contador] = this.alumnos[i];
                contador ++;
            }
        }
        
        
        
        // crear nuevo objeto arbol
        arbol  a = new arbol();
        
        // obtener el vector ordenado
        a = this.crearOrdenado_(0, a);
        
        // limpiar la lista actual
        alumno[] al_ = a.alumnos;
        
        // limpiar los datos actuales de alumnos
        this.alumnos = new alumno[1000];
        
        // insertar los datos del abb en un vector 
        this.getPartes(al_);
        
        
    }
    
    
    public arbol crearOrdenado_ (int indice, arbol a) {
        
        // izquierda raiz derecha
        if (indice *2 + 1 < 100 && this.alumnos[indice * 2 +1]!= null) {
            a = this.crearOrdenado_ (indice *2 +1, a);
        }
        
        a.insertarOrdenado(this.alumnos[indice]);
        
        
        if (indice *2 + 2 < 100 && this.alumnos[indice * 2 +2]!= null) {
            a = this.crearOrdenado_ (indice *2 +2, a);
        }
        
        return a;
        
    }
    
    
    public void rotarIzquierda (int indice) {
        
        alumno aux = this.alumnos[indice * 2  +2];
        
        this.alumnos[indice*2 +1] = this.alumnos[indice*2+2];
        
        
    }
    
    public void getPartes (alumno[] al) {
        
        int tamano = al.length;
        
        if (tamano == 1 ) {
            
            this.insertarDato_(al[0], 0);
            
        }else if (tamano == 2) {
            this.insertarDato_(al[0], 0);
            this.insertarDato_(al[1], 0);
            
            
        } else {
            int mitad = tamano /2;
            
            this.insertarDato_(al[mitad] , 0);
            
            alumno [] al1;
            alumno [] al2; 
                    
            
            int tal2= 0;
            if (tamano % 2 == 0) {
                // es par
                tal2= mitad -1;
            }else {
                // es impar
                tal2 = mitad;
            }
            
            al1 = new alumno[mitad];
            al2 = new alumno [ tal2];
            
            for (int i = 0 ; i < mitad ; i++) {
                al1[i] = al[i];
            }
            
            for (int i = 0 ; i < tal2 ; i++) {
                al2 [i] = al[i + mitad + 1];
            }
            
            this.getPartes(al1);
            this.getPartes(al2);
            
            
        }
        
        
        
        
        
        
        
    }
    
    
    
    
}
