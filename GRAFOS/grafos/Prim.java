package com.sergio.grafos;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sergiomolinagonzalez
 */
public class Prim {
    
    /* *************************** INDICAR LA MATRIZ, CABECERA SOLO PUEDE SER CHAR (1 CARACTER) *************************** */
    
//    public static char[] cabecera=   {  '1', '2', '3', '4', '5', '6', '7'}; // Poner si son letras, siempre en minúsculas
//    public static int [][] matriz = { {  0,   2,   4,   1,  -1,  -1,  -1},//1
//                                      {  2,   0,  -1,   3,  10,  -1,  -1},//2
//                                      {  4,  -1,   0,   2,  -1,   5,  -1},//3
//                                      {  1,   3,   2,   0,   2,   8,   4},//4
//                                      { -1,  10,  -1,   2,   0,  -1,   6},//5
//                                      { -1,  -1,   5,   8,  -1,   0,   1},//6
//                                      { -1,  -1,  -1,   4,   6,   1,   0},//7
//                                      };
//    public static char[] cabecera=   {  'a', 'b', 'b', 'd', 'e', 'f', 'g', 'h', 'i', 'j'}; // Poner si son letras, siempre en minúsculas
//    public static int [][] matriz = { {   0,   3,  -1,   4,   4,  -1,  -1,  -1,  -1,  -1},//a
//                                      {   3,   0,  10,  -1,   2,   3,  -1,  -1,  -1,  -1},//b
//                                      {  -1,  10,   0,  -1,  -1,   6,   1,  -1,  -1,  -1},//c
//                                      {   4,  -1,  -1,   0,   5,  -1,  -1,   6,  -1,  -1},//d
//                                      {   4,   2,  -1,   5,   0,  11,  -1,   2,   1,  -1},//e
//                                      {  -1,   3,   6,  -1,  11,   0,   2,  -1,   3,  11},//f
//                                      {  -1,  -1,   1,  -1,  -1,   2,   0,  -1,  -1,   8},//g
//                                      {  -1,  -1,  -1,   6,   2,  -1,  -1,   0,   4,  -1},//h
//                                      {  -1,  -1,  -1,  -1,   1,   3,  -1,   4,   0,   7},//i
//                                      {  -1,  -1,  -1,  -1,  -1,  11,   8,  -1,   7,  0},//j
//                                      };
//    public static char[] cabecera=    { 'a', 'b', 'c', 'd', 'e', 'f'}; // Poner si son letras, siempre en minúsculas
//    public static int [][] matriz = { {   0,   5,   6,   4,   3,   7},//a
//                                      {   5,   0,   2,   4,   8,   5},//b
//                                      {   6,   2,   0,   4,   8,   8},//c
//                                      {   4,   4,   4,   0,   2,   5},//d
//                                      {   3,   8,   8,   2,   0,   4},//e
//                                      {   7,   5,   8,   5,   4,  0}};//f
//    
//    public static char[] cabecera ={  'a', 'b', 'b', 'g', 'm', 't'}; // Poner si son letras, siempre en minúsculas
//    public static int[][] matriz = {{  0,    0,  157,  223,149,  0 },//Andorra
//                                    {  0,    0,    0,   96, 56, 105 },//Barcelona
//                                    { 157,   0,    0,    0,118,  91 },//LLeida
//                                    { 223,  96,    0,    0,157,   0 },//Girona
//                                    { 149,  56,  118,  157,  0,   0 },//Manresa
//                                    {   0, 105,   91,    0,  0,  0 },//Tarragona
//                                    };
//    
//    public static char[] cabecera=   {  '1', '2', '3', '4', '5', '6', '7'};
//    public static int [][] matriz = { {  0,    9,   1,   2,  -1,  -1, -1},//1
//                                      {  9,    0,  -1,   8,  10,  -1, -1},//2
//                                      {  1,   -1,   0,   4,  -1,   3, -1},//3
//                                      {  2,    8,   4,   0,  11,   5,  7},//4
//                                      { -1,   10,  -1,  11,   0,  -1, 12},//5
//                                      { -1,   -1,   3,   5,  -1,   0,  6},//6
//                                      { -1,   -1,  -1,   7,  12,  6,  0},//7
//                                        };
    
     public static char[] cabecera=   {  '1', '2', '3', '4', '5', '6', '7', '8'}; // Poner si son letras, siempre en minúsculas
    public static int [][] matriz = { {  -1,    2,   2,   3,   2,   3,   3,  3},//1
                                      {  2,    0,   2,   3,   2,   3,   1,  3},//2
                                      {  2,    2,   0,   3,   2,   1,   3,  3},//3
                                      {  3,    3,   3,   0,   1,   2,   2,  4},//4
                                      {  2,    2,   2,   1,   0,   3,   3,  3},//5
                                      {  3,    3,   1,   2,   3,   0,   2,  4},//6
                                      {  3,    1,   3,   2,   3,   2,   0,  4},//7
                                      {  3,    3,   3,   4,   3,   4,   4,  0},//8
                                        };
    
    public static void main(String[] args) {
        
        
        int[] distancias= new int[matriz.length];
        char[] distanciasCabecera= new char[matriz.length];
        boolean[] marcado= new boolean[matriz.length];
    
        
        /* *************************** INDICAR NODO INICIAL SERÁ EL PIVOTE POR DONDE QUEREMOS EMPEZAR *************************** */
        int pivote= 0; // <<<<<<<< PIVOTE, indicar la posición empezando desde cero.
         
        for (int i = 0; i < matriz.length; i++) {
            distanciasCabecera[i]=cabecera[pivote];
            marcado[i]=false;
        }
        
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
        
        
        
        System.out.print("    ╔════════╤");
        for (int i = 1; i < cabecera.length-1; i++) {
            System.out.print("═════════╤");
        }
        System.out.println("═════════╗");
        
        System.out.print("    ║   "+cabecera[0]+"    │");
        for (int i = 1; i < cabecera.length-1; i++) {
            System.out.print("    "+cabecera[i]+"    │");
        }
        System.out.println("    "+cabecera[cabecera.length-1]+"    ║");
        System.out.print("╔═══╬════════╪");
        for (int i = 1; i < cabecera.length-1; i++) {
            System.out.print("═════════╪");
        }
        System.out.println("═════════╣");
        
        int linea=0;
       
        for (int i = 0; i < matriz.length; i++) {
            distancias[i]=-1;
        }
        distancias[pivote]=0;
        marcado[pivote]=true;
      
        
        System.out.print("║"+(String.valueOf(linea)+"   ").substring(0, 3)+"║");
        for (int i = 0; i < matriz.length-1; i++) {
            System.out.print("("+(String.valueOf(distancias[i])+"   ").substring(0, 3)+","+distanciasCabecera[i]+") │ ");
        }
        System.out.println("("+(String.valueOf(distancias[matriz.length-1])+"   ").substring(0, 3)+","+distanciasCabecera[matriz.length-1]+") ║");
        
       
        
        for (int i = 0; i < matriz.length; i++) {
            if (pivote!=i){
                if (matriz[pivote][i]>distancias[i]){
                    distancias[i]=matriz[pivote][i];
                   
                }
            }    
        }
        
        while (linea<matriz.length){
            linea++;
            System.out.print("║"+(String.valueOf(linea)+"   ").substring(0, 3)+"║");
            String marca;
            for (int i = 0; i < matriz.length-1; i++) {
                marca=pivote==i?"*":" ";
                System.out.print("("+(String.valueOf(distancias[i])+"   ").substring(0, 3)+","+distanciasCabecera[i]+")"+marca+"│ ");
            }
            marca=(pivote==matriz.length-1?"*":" ");
            System.out.println("("+(String.valueOf(distancias[matriz.length-1])+"   ").substring(0, 3)+","+distanciasCabecera[matriz.length-1]+")"+marca+"║");
            pivote = 0;
            for (int i = 0; i < matriz.length; i++) {
                if (!marcado[i]){
                    if (distancias[i]>distancias[pivote]){
                        pivote=i;
                    }
                }    
            }
            for (int i = 0; i < matriz.length; i++) {
               
                if (!marcado[i]){
                    if (distancias[i]>0){
                        if (distancias[i]<distancias[pivote]){
                            pivote=i;
                        }else {
                            if (distancias[i]==distancias[pivote]){
                                for (int j = 0; j < matriz.length; j++) {
                                     if (!marcado[j]){
                                         if (distanciasCabecera[i]<distanciasCabecera[pivote]){
                                             pivote=i;
                                         }
                                     }
                                }
                            }
                        }
                    }
                }
            }
           
            marcado[pivote]=true;
           
            for (int i = 0; i < matriz.length; i++) {
               
                if (!marcado[i]){
                    if (matriz[pivote][i]!=-1 ){
                        if (distancias[i]==-1){
                            distancias[i]=matriz[pivote][i];
                            distanciasCabecera[i]=cabecera[pivote]; 
                            
                        }else {
                            if (matriz[pivote][i]<distancias[i]){
                                distancias[i]=matriz[pivote][i];
                                distanciasCabecera[i]=cabecera[pivote]; 
                            }
                        }    
                    }    
                }
            }    
            
        }
        System.out.print("╚═══╩════════╧");
        for (int i = 1; i < cabecera.length-1; i++) {
            System.out.print("═════════╧");
        }
        System.out.println("═════════╝");
        
        KruskalClass kruskalClass=null;
        List <KruskalClass> resultListPreoreden = new ArrayList<KruskalClass>();
        int[] conversion= new int[distanciasCabecera.length];
        int[] conversionCabecera = new int[cabecera.length];
        
        for (int i = 0; i < conversion.length; i++) {
            if (distanciasCabecera[i]>=97){
                conversion[i]=(int) (distanciasCabecera[i]-  97); 
            }else{
                conversion[i]=(int) (distanciasCabecera[i]-  49); 
            }
        }
        for (int i = 0; i < cabecera.length; i++) {
           
            if (cabecera[i]>=97){
                conversionCabecera[i]=(int) (cabecera[i]-  97); 
                
            }else{
                conversionCabecera[i]=(int) (cabecera[i]-  49); 
            }
        }
        
        for (int i = 1; i < distancias.length; i++) {
            if(conversion[i]<=i){
                kruskalClass = new KruskalClass(conversion[i],i,distancias[i],"{ "+distanciasCabecera[i]+","+cabecera[i]+" }");
            }else{
                kruskalClass = new KruskalClass(i,conversion[i],distancias[i],"{ "+cabecera[i]+","+distanciasCabecera[i]+" }");
            } 
          
            resultListPreoreden.add(kruskalClass);
        }
       
         
        System.out.println("╔═══════════════════╗");
        System.out.println("║     RESULTADO     ║");        
        System.out.println("╠═════════╤═════════╣");
        System.out.println("║ Aristas │ Pesos   ║");
        System.out.println("╠═════════╪═════════╣");
        int pesoTotal=0;
        
        for (KruskalClass list:resultListPreoreden){
                System.out.println("║ "+(list+"              ").substring(0, 18)+"║");
                pesoTotal=pesoTotal+list.getPeso();
        }
        
        System.out.println("╠═════════╪═════════╣");
        System.out.println("║ Total   │ "+(String.valueOf(pesoTotal)+"           ").substring(0, 7)+" ║");
        System.out.println("╚═════════╧═════════╝");
        System.out.println("");
        
        
        System.out.println("╔═══════════════════╗");
        System.out.println("║     ORDENADO      ║");        
        System.out.println("╠═════════╤═════════╣");
        System.out.println("║ Aristas │ Pesos   ║");
        System.out.println("╠═════════╪═════════╣");
        
        pesoTotal=0;
      
        for (int i = 0; i < marcado.length; i++) {
            marcado[i]=false;
        }
        
        
        for (int i = 0; i < resultListPreoreden.size(); i++) {    
            for (int j = (i+1); j < resultListPreoreden.size(); j++) {
                if (resultListPreoreden.get(j).getNodoIncial()<resultListPreoreden.get(i).getNodoIncial()){
                    KruskalClass help=resultListPreoreden.get(i);
                    resultListPreoreden.set(i, resultListPreoreden.get(j));
                    resultListPreoreden.set(j, help);
                    
                } else {
                    if (resultListPreoreden.get(j).getNodoIncial()==resultListPreoreden.get(i).getNodoIncial()){
                        if (resultListPreoreden.get(j).getNodoFinal()<resultListPreoreden.get(i).getNodoFinal()){
                            KruskalClass help=resultListPreoreden.get(i);
                            resultListPreoreden.set(i, resultListPreoreden.get(j));
                            resultListPreoreden.set(j, help);
                        }
                    }
                }
            }
       } 
        for (KruskalClass list:resultListPreoreden){
            System.out.println("║ "+(list.toString()+"              ").substring(0, 18)+"║");
            pesoTotal=pesoTotal+list.getPeso();   
        }
        
        System.out.println("╠═════════╪═════════╣");
        System.out.println("║ Total   │ "+(String.valueOf(pesoTotal)+"           ").substring(0, 7)+" ║");
        System.out.println("╚═════════╧═════════╝");  
        System.out.println("");
        
    }
    
    
}
