package com.sergio.grafos;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sergiomolinagonzalez
 */
public class DFS_ArbolGenerador {
    
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
//    public static char[] cabecera=   { 'A','B','C','D','E'};
//    public static int [][] matriz = { {  0,  1,  1, -1,  1},//A
//                                      {  1,  0,  1,  1, -1},//B
//                                      {  1,  1,  0,  1,  1},//C
//                                      { -1,  1,  1, -1, -1},//D
//                                      {  1,  -1, 1, -1,  0}//E
//    };
     
//    public static char[] cabecera=   {  '1', '2', '3', '4', '5', '6', '7', '8', '9','0'};
//    public static int [][] matriz = { {  0,   1,  -1,  -1,   1,   1,  -1,  -1,  -1, -1},//1
//                                      {  1,   0,   1,  -1,  -1,  -1,   1,  -1,  -1, -1},//2
//                                      { -1,   1,   0,   1,  -1,  -1,  -1,   1,  -1, -1},//3
//                                      { -1,  -1,   1,   0,   1,  -1,  -1,  -1,   1, -1},//4
//                                      {  1,  -1,  -1,   1,   0,  -1,  -1,  -1,  -1,  1},//5
//                                      {  1,  -1,  -1,  -1,  -1,   0,  -1,   1,   1, -1},//6
//                                      { -1,   1,  -1,  -1,  -1,  -1,   0,  -1,   1,  1},//7
//                                      { -1,  -1,   1,  -1,  -1,   1,  -1,   0,   1, -1},//8
//                                      { -1,  -1,  -1,   1,  -1,   1,   1,  -1,   0, -1},//9
//                                      { -1,  -1,  -1,  -1,   1,  -1,   1,   1,  -1,  0}};//10}; 
    
    public static char[] cabecera={  '1', '2', '3', '4', '5', '6', '7', '8'};
    public static int[][] matriz = {{  0,   1,   0,   1,   0,   0,   0,   0},//1
                                    {  1,   0,   1,   0,   0,   0,   0,   0},//2
                                    {  0,   1,   0,   1,   0,   0,   0,   0},//3
                                    {  1,   0,   1,   0,   1,   0,   0,   1},//4
                                    {  0,   0,   0,   1,   0,   1,   0,   0},//5
                                    {  0,   0,   0,   0,   1,   0,   1,   0},//6
                                    {  0,   0,   0,   0,   0,   1,   0,   1},//7
                                    {  0,   0,   0,   1,   0,   0,   1,   0},//8
                                    };
    
    public static List <Integer> queue = new ArrayList<>();
    public static List <Character> result = new ArrayList<>();
    public static List <String> resultList = new ArrayList<>();
    public static void main(String[] args) {
        
       
        
        /* *************************** INDICAR NODO INICIAL SERÁ EL PIVOTE POR DONDE QUEREMOS EMPEZAR *************************** */
        int nodoInicial= 0; // <<<<<<<< PIVOTE, indicar la posición empezando desde cero.
        queue.add(nodoInicial);
        result.add(cabecera[nodoInicial]);
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
        System.out.println("║ P                                     │ Aristas añadidas│  DFS Arbol Generador                                                      ║");
        System.out.println("╠═══════════════════════════════════════╪═════════════════╪═══════════════════════════════════════════════════════════════════════════╣");
        System.out.println("║ "+cabecera[queue.get(nodoInicial)]+"                                     │ Ø               │                                                                           ║");

        String ayuda;
        boolean eliminamos;
        while(!queue.isEmpty()){
            ayuda=" -             ";
            eliminamos=FindNextNode(nodoInicial);
            if (!queue.isEmpty()){
                nodoInicial=queue.get(queue.size()-1);
            }
            String linea="║ ";
            if (!queue.isEmpty()){
                if (!eliminamos){
                    ayuda="{ "+String.valueOf(cabecera[queue.size()-2])+", "+String.valueOf(cabecera[queue.size()-1])+" }       ";
                    
                }
                for (int i = 0; i < queue.size()-1; i++) {
                    linea = linea+cabecera[queue.get(i)]+", ";
                }
                linea = linea+cabecera[queue.get(queue.size()-1)];
                linea= (linea + "                                      ").substring(0, 40)+"│ ";
            }else{
                linea= (linea + "Ø                                     ").substring(0, 40)+"│ ";
            }
            linea=linea+ayuda+" │ { ";
            String resultado="";
            for (int j = 0; j < resultList.size()-1; j++) {
                resultado=resultado+resultList.get(j)+",";
            }
            resultado=(resultado+resultList.get(resultList.size()-1)+" }                                                                          ").substring(0, 71)+" ║";
            linea=linea+resultado;
            System.out.println(linea);      
        }
        System.out.println("╚═══════════════════════════════════════╧═════════════════╧═══════════════════════════════════════════════════════════════════════════╝");
    }
    
    public  static boolean FindNextNode(int nodoInicial){
        for (int i = 0; i < matriz.length; i++) {
            if (matriz[nodoInicial][i]!=-1){
                if (i!=nodoInicial){
                    int nextNode=0;
                     boolean found = false;
                    while (!found &&  nextNode!=result.size()){
                        if (cabecera[i]==result.get(nextNode)){
                            found=true;
                        }
                        nextNode++;
                    }
                    if (!found){
                        queue.add(i);
                        result.add(cabecera[i]);
                        resultList.add("{"+String.valueOf(cabecera[nodoInicial])+","+String.valueOf(cabecera[i])+" }");
                        return false;
                    } 
                }    
            }
        }
        queue.remove(queue.size()-1);
        return true;
    }
}
