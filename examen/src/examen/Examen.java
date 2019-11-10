/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import org.omg.SendingContext.RunTime;

/**
 *
 * @author David Ventura
 */

public class Examen {

    /**
     * @param args the command line arguments
     */
    
    
    public static alumno alumnos[] ;
    public static fmr fmr_ ;
    
    public static arbol aa ;
    public static void main(String[] args) {
        // TODO code application logic here
        fmr_ = new fmr();
        aa = new arbol();
        alumnos = new alumno[100];
        
        fmr_.show();
        
        //int n = 12/2;
        //System.out.print(n);
        
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
        // limpia el vetor anterior
        alumnos = new alumno[100];
        
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
                
                alumno alumno_ = new alumno(datos [1], Integer.parseInt(datos [0]));
                
                //alumnos[index] = alumno_;
                
                insertarDato_(alumno_, 0);
                //aa.insertarDato_(alumno_, 0);
                
                contenido += linea;
                index ++;
                
            }
            
            //aa.crearOrdenado();
            
            JOptionPane.showMessageDialog(null, "La carga ha sido realizaa correctamente", "CARGA", JOptionPane.INFORMATION_MESSAGE);
            
        } catch (Exception e) {JOptionPane.showMessageDialog(null, "No se ha podido encontrar el archivo.");}
        
        
    }
    
    public static void insertarDato_ (alumno al, int indice) {
        
        
        if (indice > 99) {
            //JOptionPane.showMessageDialog(null, "Se ha alcanzado la profundidad máxima representada en el vector de datos", "error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        
        // verificar si el indice está vacío
        if (alumnos[indice] == null) {
            // insertar en esta posoción
            alumnos[indice]  = al;
        }else {
            
            if (al.nombre.compareToIgnoreCase(alumnos[indice].nombre)< 0) {
                // insertar a la izquierda
                insertarDato_(al, indice * 2 +1);
            }else {
                // insertar a la derecha
                insertarDato_(al, indice * 2 +2);
            }
            
        }
        
        
    }
    
    public static void generarJS () {
        // genera el reporte de datos js
        
        String cont = "";
        
        cont += "var chart_config = {\n";
        
        cont += "   chart: {\n";
        
        cont += "       container: \"#basic-example\",\n";
        cont += "       connectors: {\n";
        cont += "           type: \"bCurve\"\n";
        cont += "       },\n";
        cont += "       animatedOnInit: true,\n";
        cont += "       node:{\n";
        cont += "           collapsable: true,\n";
        cont += "           HTMLclass: \'nodeExample1\'\n" ;
        cont += "       },\n";
        cont += "       animation: {\n";
        cont += "           nodeAnimation: \"easeOutBounce\",\n";
        cont += "           nodeSpeed: 700,\n";
        cont += "           connectorsAnimation: \"bounce\",\n";
        cont += "           connectorsSpeed: 700\n";
        cont += "       }\n";
        cont += "   },\n";
        cont += "   nodeStructure: {\n";
        cont += getContenido(0);
        cont += "   }\n";
        cont += "};";
        
        
        FileWriter file;
        PrintWriter pw;
        
        try {
            String rutata =  "REPORTES/ejemplo.js";
            file = new FileWriter (rutata);
            pw  = new PrintWriter(file);
            pw.print(cont);
            file.close();
            
            JOptionPane.showMessageDialog(null, "Reporte creado con éxito.", "TITULO", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception r) {JOptionPane.showMessageDialog(null, "No se ha podido crear el reporte.", "ERROR", JOptionPane.ERROR_MESSAGE);}
        
        
    }
    
    public static String getContenido (int posicion) {
        String cont = "";
        System.out.println(posicion);
        if (alumnos[posicion] != null) {
        
            cont += "           text: {\n";

            cont += "               name: " + "\"" + alumnos[posicion].nombre +  "\",\n";
            cont += "               title: " +"\"" + alumnos[posicion].id + "\"\n";

            cont += "           },\n";

            int indiceIzquierda = posicion *2 + 1;
            int indiceDerecha = posicion * 2 + 2 ;

            if (indiceIzquierda < 100 || indiceDerecha < 100) {
                cont += "children: [\n";

                // llamar al hijo izquierda
                if (indiceIzquierda < 100 && alumnos [indiceIzquierda] != null) {
                    
                    cont += "{\n";
                    cont += getContenido(indiceIzquierda);
                    cont += "}\n";
                    if (indiceDerecha < 100 && alumnos[indiceDerecha] != null) {
                        cont += ",";
                    }
                }

                // llamar al hijo derecha
                if (indiceDerecha < 100 && alumnos[indiceDerecha] != null ) {
                    cont += "{\n";
                    cont += getContenido (indiceDerecha);
                    cont += "}\n";
                }

                cont += "]\n";
            }
            
        }
        
        return cont;
    }
    
    public static void abrirReporte () throws IOException {
        String ruta = "REPORTES/index.html" ;
        File file ;
        
        try {
            file = new File (ruta);
            
            String comando = "\"" + file.getAbsolutePath() + "\"";
            
            //Runtime.getRuntime().exec(comando);
            //Runtime.getRuntime().exec(comando);
            
        } catch (Exception e) {JOptionPane.showMessageDialog(null, "No se ha podido abrir el reporte.", "ERROR", JOptionPane.ERROR_MESSAGE);}
        
        file = new File (ruta);
        String comando = "" + file.getAbsolutePath() + "";
            
        abrirarchivo (comando);
    }
    
    public static void abrirarchivo(String archivo){

     try {

            File objetofile = new File (archivo);
            Desktop.getDesktop().open(objetofile);

     }catch (IOException ex) {

            System.out.println(ex);

     }

}    
    
}
