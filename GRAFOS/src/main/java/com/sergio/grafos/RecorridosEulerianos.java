/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sergio.grafos;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sergiomolinagonzalez
 */
public class RecorridosEulerianos {
    
     /* Gráfico asociado:
             (a)--- (b)
              | \   / |
              |  \ /  |
              |  / \  |
              | /   \ |
             (d)----(c) */
    
    
    // Driver Code
//    public static char[] cabecera={ 'a', 'b', 'c', 'd'}; // Poner si son letras, siempre en minúsculas
//    public static int[][] matrix = {{  0,  1,   1,  1 },//a
//                                    {  1,  0,   1,  1 },//b
//                                    {  1,  1,   0,  1 },//c
//                                    {  1,  1,   1,  0 }//d
//                                    };
    
      /* Gráfico asociado:
             (a)--- (b)
              | \     |
              |  \    |
              |    \  |
              |     \ |
             (d)----(c) */
    
    
    // Driver Code
//
     /* Gráfico asociado:
           (0) - - -- (2)
            |   \   /  |
            |    (1)   |
            |   /  |   |
            | /    |   |
           (5)----(4)--(3)*/
    
    
    // Driver Code
//    public static char[] cabecera={ 'a','b','c','d','e','f'}; // // Poner si son letras, siempre en minúsculas
//    public static int[][] matrix = {{  0,  1,  1,  0,  0,  1 },//a
//                                    {  1,  0,  1,  0,  1,  1 },//b
//                                    {  1,  1,  0,  1,  0,  0 },//c
//                                    {  0,  0,  1,  0,  1,  0 },//d
//                                    {  0,  1,  0,  1,  0,  1 },//e
//                                    {  1 , 1,  0,  0,  1,  0 },//f
//                                    };
//      /* Gráfico asociado:
//           
//                (a)
//               /   \
//            (b)----(f)
//            /  \   /  \
//           /    \ /    \
//         (c)----(d)----(e) */
//    public static char[] cabecera={  'a', 'b', 'c', 'd', 'e', 'f'}; // Poner si son letras, siempre en minúsculas
//    public static int[][] matrix = {{  0,   1,   0,   0,   0,  1 },//a
//                                    {  1,   0,   1,   1,   0,  1 },//b
//                                    {  0,   1,   0,   1,   0,  0 },//c
//                                    {  0,   1,   1,   0,   1,  1 },//d
//                                    {  0,   0,   0,   1,   0,  1 },//e
//                                    {  1,   1,   0,   1,   1,  0 },//f
//                                    };
//    
    //      /* Gráfico asociado:
//           
//         (a)--(b)--(c)   
//          |   /|    | 
//          | /  |    | 
//         (d)--(e)--(f)
//          |    |   /|  
//          |    |  / |   
//         (g)--(h)--(i)    */
    public static char[] cabecera={  'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i'};
    public static int[][] matrix = {{  0,   1,   0,   1,   0,   0,   0,   0,  0},//a
                                    {  0,   1,   1,   1,   1,   0,   0,   0,  0},//b
                                    {  0,   0,   1,   0,   0,   1,   0,   0,  0},//c
                                    {  1,   1,   0,   0,   1,   0,   1,   0,  0},//d
                                    {  0,   1,   0,   1,   0,   1,   0,   1,  0},//e
                                    {  0,   0,   1,   0,   1,   0,   0,   1,  1},//f
                                    {  0,   0,   0,   1,   0,   0,   0,   1,  0},//g
                                    {  0,   0,   0,   0,   1,   1,   1,   0,  1},//h
                                    {  0,   0,   0,   0,   0,   1,   0,   1,  0},//i
                                    };
    
    public static int[] nodo = new int[matrix.length];
    public static boolean isEuler=true;
    public static boolean recorridoEuler=true;     
    
    public static void main(String[] args) {
        isEuler();
        if (!isEuler){
            System.out.println("El Grafo NO contiene un circuito euleriano , NO es euleriano: ");
            System.out.println("El número de nodos impares son :");
            for (int i = 0; i < nodo.length; i++) {
                if ((nodo[i]%2)!=0){
                    System.out.print("Nodo: "+cabecera[i]+" = "+nodo[i]);
                    if (i!= nodo.length-1){
                        System.out.print(", ");
                    }
                }
            }
        } else{
            System.out.println("El Grafo contiene un circuito euleriano, Es euleriano: ");
            circuitoEuler();
        }    
        System.out.println("");
        System.out.println("El grafo contiene un recorrido euleriano: "+recorridoEuler);   
    }
    
    public static void isEuler(){
     
        int numImparNodos=0;
        for (int i = 0; i < matrix.length; i++) {
            int count=0;
            for (int j = 0; j <  matrix.length; j++) {
                if (matrix[i][j]==1){
                    count++;
                }
            }    
            nodo[i]=count;
            if (count %2!=0){
                isEuler=false;
            }else{
                numImparNodos++;
            }
            
        }
        if (numImparNodos!=2){
            recorridoEuler=false;
        }
    }
    
    public static void circuitoEuler(){
         List <Integer> circuito = new ArrayList();
         int pivote = 0;
         boolean found=false;
         while (pivote< matrix.length && !found){
             if (matrix[0][pivote]==1){
                 circuito.add(1);
                 found=true;
             }
             pivote++;
        }
        if (found){
            System.out.println("Nodo Inicial ==> "+circuito.get(0));
         } else{
            System.out.println("El GRAFO NO ES CONEXO");
        }    
    }     
    
}
