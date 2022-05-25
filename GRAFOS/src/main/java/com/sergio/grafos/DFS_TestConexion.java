package com.sergio.grafos;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sergiomolinagonzalez
 */
public class DFS_TestConexion {
    
    /* *************************** INDICAR LA MATRIZ, CABECERA SOLO PUEDE SER CHAR (1 CARACTER) *************************** */
//    public static char[] cabecera=   { '1','2','3','4','5','6','7'};
//    public static int [][] matriz = { {  0,  1,  1,  1, -1, -1, -1},
//                                      {  1,  0, -1, -1,  1, -1, -1},
//                                      {  1, -1,  0, -1, -1,  1, -1},
//                                      {  1, -1, -1,  0, -1, -1, -1},
//                                      { -1,  1, -1, -1,  0,  1, -1},
//                                      { -1, -1,  1, -1,  1,  0,  1},
//                                      { -1, -1, -1, -1, -1,  1,  0}};
    
//    public static char[] cabecera=   { '1','2','3','4','5','6','7'};
//    public static int [][] matriz = { {  0,  1,  1,  1, -1, -1, -1},
//                                      {  1,  0, -1,  1,  1, -1, -1},
//                                      {  1, -1,  0,  1, -1,  1, -1},
//                                      {  1,  1,  1,  0,  1,  1,  1},
//                                      { -1,  1, -1,  1,  0, -1,  1},
//                                      { -1, -1,  1,  1, -1,  0, 1},
//                                      { -1, -1, -1,  1,  1,  1,  0}};
//    
//    public static char[] cabecera=   { 'A','B','C','D','E','F','G','H','I','j'};
//    public static int [][] matriz = { {  0, -1, -1, -1, -1,  1, -1, -1,  1,  1},//A
//                                      { -1,  0,  1, -1, -1, -1,  1, -1, -1, -1},//B
//                                      { -1,  1,  0, -1,  1, -1,  1, -1, -1, -1},//C
//                                      { -1, -1, -1,  0, -1, -1, -1,  1, -1, -1},//D
//                                      { -1, -1,  1, -1,  0,  1,  1, -1, -1,  1},//E
//                                      {  1, -1, -1, -1,  1,  0, -1, -1,  1, -1},//F
//                                      { -1,  1,  1, -1,  1, -1,  0, -1, -1, -1},//G
//                                      { -1, -1, -1,  1, -1, -1, -1,  0, -1, -1},//H
//                                      {  1, -1, -1, -1, -1,  1, -1, -1,  0, -1},//I
//                                      {  1, -1, -1, -1,  1, -1, -1, -1, -1, 0 },//J
//    };
        public static char[] cabecera=   { 'A','B','C','D','E'};
        public static int [][] matriz = { {  0,  1,  1, -1,  1},//A
                                          {  1,  0,  1,  1, -1},//B
                                          {  1,  1,  0,  1,  1},//C
                                          { -1,  1,  1, -1, -1},//D
                                          {  1,  -1, 1, -1,  0}//E
        };
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
        char ayuda;
        boolean eliminamos;
        while(!queue.isEmpty()){
            ayuda=cabecera[nodoInicial];
            eliminamos=FindNextNode(nodoInicial);
            if (!queue.isEmpty()){
                nodoInicial=queue.get(queue.size()-1);
            }
            String linea="║ ";
            if (!queue.isEmpty()){
                if (!eliminamos){
                    ayuda=cabecera[queue.get(queue.size()-1)];
                }
                for (int i = 0; i < queue.size()-1; i++) {
                    linea = linea+cabecera[queue.get(i)]+", ";
                }
                linea = linea+cabecera[queue.get(queue.size()-1)];
                linea= (linea + "                                      ").substring(0, 27)+"│ ";
            }else{
                linea= (linea + "Ø                                     ").substring(0, 27)+"│ ";
            }
            if (eliminamos){
                linea=linea+"  │ "+ayuda+" │ [ ";
            }else{
                linea=linea+ayuda+" │   │ [ ";
            }
            
            String resultado="";
            for (int i = 0; i < result.size()-1; i++) {
                resultado=resultado+result.get(i)+", ";
               
            }
            resultado=(resultado+result.get(result.size()-1)+" ]                                 ").substring(0, 26)+" ║";
            linea=linea+resultado;
            System.out.println(linea);
            
        }
         System.out.println("╚══════════════════════════╧═══╧═══╧══════════════════════════════╝");
    }
    
    public  static boolean FindNextNode(int nodoInicial){
       
      
        
        boolean found;
        for (int i = 0; i < matriz.length; i++) {
            if (matriz[nodoInicial][i]!=-1){
                if (i!=nodoInicial){
                    int nextNode=0;
                    found=false;
                    while (!found &&  nextNode!=result.size()){
                        if (cabecera[i]==result.get(nextNode)){
                            found=true;
                        }
                        nextNode++;
                    }
                    if (!found){
                        queue.add(i);
                        result.add(cabecera[i]);
                        return false;
                    } 
                }    
            }
        }
        queue.remove(queue.size()-1);
        return true;
        
       
    }
}
