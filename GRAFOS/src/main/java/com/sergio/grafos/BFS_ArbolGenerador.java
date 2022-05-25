package com.sergio.grafos;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sergiomolinagonzalez
 */
public class BFS_ArbolGenerador {
    
    /* *************************** INDICAR LA MATRIZ, CABECERA SOLO PUEDE SER CHAR (1 CARACTER) *************************** */
//    public static char[] cabecera=   { '1','2','3','4','5','6'};
//    public static int [][] matriz = { {  0,  1, -1, -1,  1, -1},//1
//                                      {  1,  0,  1, -1,  1, -1},//2
//                                      { -1,  1,  0,  1,  1, -1},//3
//                                      { -1, -1,  1,  0,  1,  1},//4
//                                      {  1,  1,  1,  1,  0, -1},//5
//                                      { -1, -1, -1,  1, -1,  0}};//6
    
//    public static char[] cabecera=   { '1','2','3','4','5','6','7'};
//    public static int [][] matriz = { {  0,  1,  1,  1, -1, -1, -1},
//                                      {  1,  0, -1,  1,  1, -1, -1},
//                                      {  1, -1,  0,  1, -1,  1, -1},
//                                      {  1,  1,  1,  0,  1,  1,  1},
//                                      { -1,  1, -1,  1,  0, -1,  1},
//                                      { -1, -1,  1,  1, -1,  0, 1},
//                                      { -1, -1, -1,  1,  1,  1,  0}};
    public static char[] cabecera=   {  '1', '2', '3', '4', '5', '6', '7', '8', '9','0'};
    public static int [][] matriz = { {  0,   1,  -1,  -1,   1,   1,  -1,  -1,  -1, -1},//1
                                      {  1,   0,   1,  -1,  -1,  -1,   1,  -1,  -1, -1},//2
                                      { -1,   1,   0,   1,  -1,  -1,  -1,   1,  -1, -1},//3
                                      { -1,  -1,   1,   0,   1,  -1,  -1,  -1,   1, -1},//4
                                      {  1,  -1,  -1,   1,   0,  -1,  -1,  -1,  -1,  1},//5
                                      {  1,  -1,  -1,  -1,  -1,   0,  -1,   1,   1, -1},//6
                                      { -1,   1,  -1,  -1,  -1,  -1,   0,  -1,   1,  1},//7
                                      { -1,  -1,   1,  -1,  -1,   1,  -1,   0,   1, -1},//8
                                      { -1,  -1,  -1,   1,  -1,   1,   1,  -1,   0, -1},//9
                                      { -1,  -1,  -1,  -1,   1,  -1,   1,   1,  -1,  0}};//10}; 
        
    public static List <Integer> queue = new ArrayList<>();
    public static List <Character> result = new ArrayList<>();
    public static List <String> resultList = new ArrayList<>();
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
        
        System.out.println("╔═══════════════════════════════════════╤═════════════════╤═══════════════════════════════════════════════════════════════════════════╗");
        System.out.println("║ P                                     │ Aristas añadidas│  BFS Arbol Generador                                                      ║");
        System.out.println("╠═══════════════════════════════════════╪═════════════════╪═══════════════════════════════════════════════════════════════════════════╣");
        System.out.println("║ "+cabecera[queue.get(nodoInicial)]+"                                     │ Ø               │                                                                           ║");
        String ayuda;
        while(!queue.isEmpty()){
            for (int i = 0; i < matriz.length; i++) {           
                if(matriz[nodoInicial][i]!=-1){
                    int nextNode=0;
                    boolean found=false;
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
                            resultList.add("{"+String.valueOf(cabecera[nodoInicial])+","+String.valueOf(cabecera[i])+"}");
                           
                            ayuda="{ "+String.valueOf(cabecera[nodoInicial])+", "+String.valueOf(cabecera[i])+" }       ";
                            
                            String linea="║ ";
                            for (int j = 0; j < queue.size()-1; j++) {
                                linea = linea+cabecera[queue.get(j)]+", "; 
                            }
                            linea = linea+cabecera[queue.get(queue.size()-1)];
                            linea= (linea + "                                             ").substring(0, 40)+"│ ";
                            linea=linea+ayuda+" │ { ";
                            String resultado="";
                            for (int j = 0; j < resultList.size()-1; j++) {
                                resultado=resultado+resultList.get(j)+",";
                            }
                            resultado=(resultado+resultList.get(resultList.size()-1)+" }                                                                          ").substring(0, 71)+" ║";
                            linea=linea+resultado;
                            System.out.println(linea);
                            nodoInicial=queue.get(0);
                        }
                    }
                }        
            }
            if (!queue.isEmpty()){
                ayuda=" - ";
                queue.remove(0);
                if (!queue.isEmpty()){
                    String linea="║ ";
                    for (int j = 0; j < queue.size()-1; j++) {
                        linea = linea+cabecera[queue.get(j)]+", "; 
                    }
                    linea = linea+cabecera[queue.get(queue.size()-1)];
                    linea= (linea + "                                             ").substring(0, 40)+"│ ";
                    linea=linea+ayuda+"             │ { ";
                     String resultado="";
                    for (int j = 0; j < resultList.size()-1; j++) {
                        resultado=resultado+resultList.get(j)+",";
                    }
                    resultado=(resultado+resultList.get(resultList.size()-1)+" }                                                                          ").substring(0, 71)+" ║";
                    linea=linea+resultado;
                    System.out.println(linea);
                    nodoInicial=queue.get(0);
                } else{
                    String linea="║ ";
                   
                    linea= (linea + "Ø                                     ").substring(0, 40)+"│ ";
                    linea=linea+ayuda+"             │ { ";
                    String resultado="";
                    for (int j = 0; j < resultList.size()-1; j++) {
                        resultado=resultado+resultList.get(j)+",";
                    }
                    resultado=(resultado+resultList.get(resultList.size()-1)+" }                                                                          ").substring(0, 71)+" ║";
                    linea=linea+resultado;
                    System.out.println(linea);
                }    
            } else {
                
            }
        }
        System.out.println("╚═══════════════════════════════════════╧═════════════════╧═══════════════════════════════════════════════════════════════════════════╝");
    }
    
}
