package com.sergio.grafos;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sergiomolinagonzalez
 */
public class BFS {
    
    /* *************************** INDICAR LA MATRIZ, CABECERA SOLO PUEDE SER CHAR (1 CARACTER) *************************** */
    public static char[] cabecera=   { '1','2','3','4','5','6','7'};
    public static int [][] matriz = { {  0,  1,  1,  1, -1, -1, -1},
                                      {  1,  0, -1, -1,  1, -1, -1},
                                      {  1, -1,  0, -1, -1,  1, -1},
                                      {  1, -1, -1,  0, -1, -1, -1},
                                      { -1,  1, -1, -1,  0,  1, -1},
                                      { -1, -1,  1, -1,  1,  0,  1},
                                      { -1, -1, -1, -1, -1,  1,  0}};
    
//    public static char[] cabecera=   { '1','2','3','4','5','6','7'};
//    public static int [][] matriz = { {  0,  1,  1,  1, -1, -1, -1},
//                                      {  1,  0, -1,  1,  1, -1, -1},
//                                      {  1, -1,  0,  1, -1,  1, -1},
//                                      {  1,  1,  1,  0,  1,  1,  1},
//                                      { -1,  1, -1,  1,  0, -1,  1},
//                                      { -1, -1,  1,  1, -1,  0, 1},
//                                      { -1, -1, -1,  1,  1,  1,  0}};
//    
    public static List <Integer> queue = new ArrayList<>();
    public static List <Character> result = new ArrayList<>();
    public static void main(String[] args) {
        
       
        /* *************************** INDICAR NODO INICIAL SERÁ EL PIVOTE POR DONDE QUEREMOS EMPEZAR *************************** */
        int nodoInicial= 0; // <<<<<<<< PIVOTE, indicar la posición empezando desde cero.
        queue.add(nodoInicial);
        result.add(cabecera[nodoInicial]);
        
        System.out.print("    ╔═════╤");
        for (int i = 1; i < cabecera.length-1; i++) {
            System.out.print("═════╤");
        }
        System.out.println("═════╗");
        
        System.out.print("    ║  "+cabecera[0]+"  │");
        for (int i = 1; i < cabecera.length-1; i++) {
            System.out.print("  "+cabecera[i]+"  │");
        }
        System.out.println("  "+cabecera[cabecera.length-1]+"  ║");
        System.out.print("╔═══╬═════╪");
        for (int i = 1; i < cabecera.length-1; i++) {
            System.out.print("═════╪");
        }
        System.out.println("═════╣");
        
        for (int i = 0; i < matriz.length; i++) {
            System.out.print("║ "+cabecera[i]+" ║");
            
            for (int j = 0; j < matriz.length-1; j++) {
                System.out.print(" "+(String.valueOf(matriz[i][j])+"   ").substring(0, 3)+" │");
            }
            System.out.println(" "+(String.valueOf(matriz[i][matriz.length-1])+"   ").substring(0, 3)+" ║");
        }
         System.out.print("╚═══╩═════╧");
        for (int i = 1; i < cabecera.length-1; i++) {
            System.out.print("═════╧");
        }
        System.out.println("═════╝");
        
        System.out.println("╔══════════════════════════╤═══╤═══╤══════════════════════════════╗");
        System.out.println("║ P                        │ A │ X │                              ║");
        System.out.println("╠══════════════════════════╪═══╪═══╪══════════════════════════════╣");
        System.out.println("║ "+(cabecera[queue.get(0)]+"                               ").substring(0, 25)+"│ "+cabecera[queue.get(0)]+" │   │ [ "+(result.get(0)+" ]                                 ").substring(0, 26)+" ║");
    
        int nextNode=0;
        boolean found=false;
        char ayuda=' ';
        while(!queue.isEmpty()){
            for (int i = 0; i < matriz.length; i++) {           
                if(matriz[nodoInicial][i]!=-1){
                    nextNode=0;
                    found=false;
                    if (i!=nodoInicial){
                        while (!found &&  nextNode!=result.size()){
                            if (cabecera[i]==result.get(nextNode)){
                                found=true;
                            }
                            nextNode++;
                        }
                        if (!found){
                            queue.add(i);
                            result.add(cabecera[i]);
                            ayuda=cabecera[queue.get(queue.size()-1)];
                            String linea="║ ";
                            for (int j = 0; j < queue.size()-1; j++) {
                                linea = linea+cabecera[queue.get(j)]+", "; 
                            }
                            linea = linea+cabecera[queue.get(queue.size()-1)];
                            linea= (linea + "                                             ").substring(0, 27)+"│ ";
                            linea=linea+ayuda+" │   │ [ ";
                            String resultado="";
                            for (int j = 0; j < result.size()-1; j++) {
                                resultado=resultado+result.get(j)+", ";
                            }
                            resultado=(resultado+result.get(result.size()-1)+" ]                                 ").substring(0, 26)+" ║";
                            linea=linea+resultado;
                            System.out.println(linea);
                            nodoInicial=queue.get(0);
                        }
                    }
                }        
            }
            if (queue.size()>0){
                ayuda=cabecera[queue.get(0)];
                queue.remove(0);
                if (queue.size()>0){
                    String linea="║ ";
                    for (int j = 0; j < queue.size()-1; j++) {
                        linea = linea+cabecera[queue.get(j)]+", "; 
                    }
                    linea = linea+cabecera[queue.get(queue.size()-1)];
                    linea= (linea + "                                             ").substring(0, 27)+"│ ";
                    linea=linea+"  │ "+ayuda+" │ [ ";
                    String resultado="";
                    for (int j = 0; j < result.size()-1; j++) {
                        resultado=resultado+result.get(j)+", ";
                    }
                    resultado=(resultado+result.get(result.size()-1)+" ]                                 ").substring(0, 26)+" ║";
                    linea=linea+resultado;
                    System.out.println(linea);
                    nodoInicial=queue.get(0);
                } else{
                    String linea="║ ";
                   
                    linea= (linea + "Ø                                     ").substring(0, 27)+"│ ";
                    linea=linea+"  │ "+ayuda+" │ [ ";
                    String resultado="";
                    for (int j = 0; j < result.size()-1; j++) {
                        resultado=resultado+result.get(j)+", ";
                    }
                    resultado=(resultado+result.get(result.size()-1)+" ]                                 ").substring(0, 26)+" ║";
                    linea=linea+resultado;
                    System.out.println(linea);
                }    
            } else {
                
            }
        }
        System.out.println("╚══════════════════════════╧═══╧═══╧══════════════════════════════╝");
    }
    
  
    
}
