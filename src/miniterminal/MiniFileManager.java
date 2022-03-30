/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package miniterminal;

import java.io.File;
import java.util.Date;

/**
 *
 * @author DAW
 */
public class MiniFileManager {

    private File file = new File("C:/Users/DAW/Documents/NetBeansProjects/miniTerminal");

    public void help() {
        System.out.println(" pwd: Muestra cual es la carpeta actual.\n"
                + "cd: Cambia la carpeta actual a ‘DIR’. Con .. cambia a la carpeta superior.\n"
                + "ls: Muestra la lista de directorios y archivos de la carpeta actual (primero directorios, luego\n"
                + "archivos, ambos ordenados alfabéticamente).\n"
                + "ll: Muestra la lista de directorios y archivos además el tamaño y la fecha de última modificación.\n"
                + "mkdir <DIR>: Crea el directorio ‘DIR’ en la carpeta actual.\n"
                + "rm <FILE>: Borra ‘FILE’. Si es una carpeta, borrará primero sus archivos y luego la carpeta. Si\n"
                + "tiene subcarpetas, las dejará intactas y mostrará un aviso al usuario.\n"
                + "mv <FILE1> <FILE2>: Mueve o renombra ‘FILE1’ a ‘FILE2’.\n"
                + "exit: Termina el programa.");
    }

    public String getPWD() {
        return file.getAbsolutePath();
    }

    public boolean changeDir(String part2) {
        
        File fileNuevo = new File(creaRuta(part2));
        if (fileNuevo.exists() && fileNuevo.isDirectory()) {
            file = fileNuevo;
            return true;
        }
        return false;
    }

    public void printList(boolean info) {
        if (info) {
            String[] lista = file.list();
            for (int i = 0; i < lista.length; i++) {
                Date fecha = new Date(file.lastModified());
                System.out.println(file.length() + " " + fecha + " " + lista[i]);
            }
        } else {
            String[] lista = file.list();
            for (int i = 0; i < lista.length; i++) {
                System.out.println(lista[i]);
            }
        }
    }

    public void mkdir(String part2) {
       
        File fileCreado = new File(creaRuta(part2));
        if (fileCreado.exists()) {
            System.out.println("Ya existe");
        } else {
            boolean comprobar = fileCreado.mkdir();
            System.out.println(comprobar);
        }

    }

    public void rm(String part2) {
         File fileBorrar = new File(creaRuta(part2));
        if(fileBorrar.delete()){
            System.out.println("borrado");
        }else{
            System.out.println("ERROR");
        }
        
    }

    public void mv(String antes, String despues) {
          File antiguo = new File(creaRuta(antes));
          File nuevo = new File(creaRuta(despues));
          if(antiguo.exists()){
         boolean cambioF = antiguo.renameTo(nuevo);
         System.out.println(cambioF);
          }
    }
    public String creaRuta(String part2){
        String ruta;
         if(part2.contains("/")){
        ruta= part2;
        }else{
             ruta=(file.getAbsolutePath()+"/"+ part2);
         }
        return ruta; 
    }
    
}