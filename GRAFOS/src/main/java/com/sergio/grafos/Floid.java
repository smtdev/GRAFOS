package com.sergio.grafos;

/**
 *
 * @author sergiomolinagonzalez
 */
public class Floid {
    
    public static void main(String[] args) {
        
        /* *************************** INDICAR LA MATRIZ, CABECERA SOLO PUEDE SER CHAR (1 CARACTER) *************************** */
                
//        char[] cabecera={   '1','2','3','4','5'};
//        int [][] matriz = { {  0,  96, -1, 56, 105},
//                            { 96,   0, -1, 157, -1},
//                            { -1,  -1,  0, 118, 91},
//                            { 56, 157, 118,  0, -1},
//                            {105,  -1,  91, -1,  0}};
//        
         char[] cabecera={'1','2','3','4','5'};
        int [][] matriz = { { 0,  3, 8, -1, 4},
                            { -1,  0,-1, 1, 7},
                            { -1,  4, 0, -1,-1},
                            { 2, -1, 5, 0,  -1},
                            { -1, -1,-1,6,  0}};
//        char[] cabecera={   'A',  'B', 'C', 'D',  'E', 'F','G'};
//        int [][] matriz = { { 0,   150, 320,  -1,  100,  -1, -1},
//                            { 150,   0, 150, 175,   -1,  -1, -1},
//                            { 320, 150,   0,  49,  130,  -1, -1},
//                            {  -1, 175,  49,   0,   -1,  -1, -1},
//                            { 100,  -1, 130,  -1,    0,  -1, -1},
//                            {  -1,  -1,  -1,  -1,   -1,   0, 60},
////                            {  -1,  -1,  -1,  -1,   -1,  60, -1}};
//         char[] cabecera=  {   'B',  'G', 'L', 'M',  'T'};
//        int [][] matriz = { {   0,   96,  -1,  56,  105},//B
//                            {  96,    0,  -1, 157,   -1},//G
//                            {  -1,   -1,   0, 118,   91},//L
//                            {  56,  157,  118,  0,   -1},//M
//                            { 105,   -1,  91,  -1,   0}};//T
        
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
        
        int pivote=0;
        while (pivote<matriz.length){
            for (int i = 0; i < matriz.length; i++) {
                for (int j = 0; j < matriz.length; j++) {
                    if (i!=pivote && j!=pivote && i!=j){
                        if (matriz[pivote][j]!=-1 && matriz[i][pivote]!=-1){
                            if(matriz[i][j]==-1){
                                matriz[i][j]=matriz[i][pivote]+matriz[pivote][j];
                            }else{ 
                                if(matriz[i][j]>(matriz[i][pivote]+matriz[pivote][j])){
                                    matriz[i][j]=matriz[i][pivote]+matriz[pivote][j];
                                }
                            }    
                        }
                    }
                }
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
            pivote++;
        }    
    }
    
    
}
