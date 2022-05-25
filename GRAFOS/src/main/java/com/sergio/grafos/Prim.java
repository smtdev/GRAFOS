package com.sergio.grafos;

/**
 *
 * @author sergiomolinagonzalez
 */
public class Prim {
    
    /* *************************** INDICAR LA MATRIZ, CABECERA SOLO PUEDE SER CHAR (1 CARACTER) *************************** */
    
    public static char[] cabecera=   {  '1', '2', '3', '4', '5', '6', '7'};
    public static int [][] matriz = { {  0,   2,   4,   1,  -1,  -1,  -1},//1
                                      {  2,   0,  -1,   3,  10,  -1,  -1},//2
                                      {  4,  -1,   0,   2,  -1,   5,  -1},//3
                                      {  1,   3,   2,   0,   2,   8,   4},//4
                                      { -1,  10,  -1,   2,   0,  -1,   6},//5
                                      { -1,  -1,   5,   8,  -1,   0,   1},//6
                                      { -1,  -1,  -1,   4,   6,   1,   0},//7
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
                    if (distancias[i]!=-1){
                        if (distancias[i]<distancias[pivote]){
                            pivote=i;
                        }
                    }
                }
            }
           
            marcado[pivote]=true;
           
            for (int i = 0; i < matriz.length; i++) {
               
                if (!marcado[i]){
                    if (matriz[pivote][i]!=-1){
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
    }
    
    
}
