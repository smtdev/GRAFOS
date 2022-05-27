package com.sergio.grafos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author sergiomolinagonzalez
 */
public class RecorridoTSPAproximadoPrim {
    
//    public static char[] cabecera ={  'a', 'b', 'c', 'd', 'e'}; // Poner si son letras, siempre en minúsculas
//    public static int[][] matriz = {{  0,   10,   1,  10,  0},//a
//                                    { 10,    0,   1,   0, 10},//b
//                                    {  1,    1,   0,   1,  1},//c
//                                    { 10,    0,   1,   0, 10},//d
//                                    {  0,   10,   1,  10,  0},//e
//                                    };
//    public static char[] cabecera ={  'a', 'b', 'c', 'd', 'e'}; // Poner si son letras, siempre en minúsculas
//    public static int[][] matriz = {{  0,   57,  64,   8,  26},//a
//                                    { 57,    0,  88,  54,  34},//b
//                                    { 64,   88,   0,  57,  56},//c
//                                    {  8,   54,  57,   0,  23},//d
//                                    { 26,   34,  56,  23,  0},//e
//                                    };
//    
//    public static char[] cabecera={  'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'}; // Poner si son letras, siempre en minúsculas
//    public static int[][] matriz = {{  0,   2,   2,   3,   2,   3,   3,   3},//a
//                                    {  2,   0,   2,   3,   2,   3,   1,   3},//b
//                                    {  2,   2,   0,   3,   2,   1,   3,   3},//c
//                                    {  3,   3,   3,   0,   1,   2,   2,   4},//d
//                                    {  2,   2,   2,   1,   0,   3,   3,   3},//e
//                                    {  3,   3,   1,   2,   3,   0,   2,   4},//f
//                                    {  3,   1,   3,   2,   3,   2,   0,   4},//g
//                                    {  3,   3,   3,   4,   3,   4,   4,   0},//h
//                                    };
//    public static char[] cabecera ={  'x', 'y', 'z', 't'}; // Poner si son letras, siempre en minúsculas
//    public static int[][] matriz = {{  0,    1,   2,   1},//x
//                                    {  1,    0,   1,   5},//y
//                                    {  2,    1,   0,   5},//z
//                                    {  1,    5,   5,   0},//t
//                                    };
    public static char[] cabecera=   {  '1', '2', '3', '4', '5', '6', '7'}; // Poner si son letras, siempre en minúsculas
    public static int [][] matriz = { {  0,    9,   1,   2,  -1,  -1, -1},//1
                                      {  9,    0,  -1,   8,  10,  -1, -1},//2
                                      {  1,   -1,   0,   4,  -1,   3, -1},//3
                                      {  2,    8,   4,   0,  11,   5,  7},//4
                                      { -1,   10,  -1,  11,   0,  -1, 12},//5
                                      { -1,   -1,   3,   5,  -1,   0,  6},//6
                                      { -1,   -1,  -1,   7,  12,  6,  0},//7
                                        };
    public static void main(String[] args) {
        
        int[] distancias= new int[matriz.length];
        char[] distanciasCabecera= new char[matriz.length];
        boolean[] marcado= new boolean[matriz.length];
        List <KruskalClass> mst = new ArrayList<KruskalClass>();
        
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
            mst.add(kruskalClass);
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
        marcado=new boolean[mst.size()];
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
        
        
        System.out.println("╔═══════════════════╗");
        System.out.println("║     ORDENADO      ║");   
        System.out.println("║     PREORDEN      ║");   
        System.out.println("╠═════════╤═════════╣");
        System.out.println("║ Aristas │ Pesos   ║");
        System.out.println("╠═════════╪═════════╣");
        
       
        int i=0;
        pesoTotal=0;
        while(i<resultListPreoreden.size()){
           pivote = resultListPreoreden.get(i).getNodoFinal();
           
           for (int j = i+1; j < resultListPreoreden.size(); j++) {
               if (resultListPreoreden.get(j).getNodoIncial()==pivote || resultListPreoreden.get(j).getNodoFinal()==pivote){
                   KruskalClass help=resultListPreoreden.get(j);
                   for (int k = j; k > (i+1); k--) {
                       resultListPreoreden.set(k, resultListPreoreden.get(k-1));
                   }
                   resultListPreoreden.set((i+1), help);
                   pivote=help.getNodoFinal();
                   i++;
               }
               
           }
           i++;
        }   
       
        for (KruskalClass list:resultListPreoreden){
            System.out.println("║ "+(list.toString()+"              ").substring(0, 18)+"║");
            pesoTotal=pesoTotal+list.getPeso();   
        }
        System.out.println("╠═════════╪═════════╣");
        System.out.println("║ Total   │ "+(String.valueOf(pesoTotal)+"           ").substring(0, 7)+" ║");
        System.out.println("╚═════════╧═════════╝");
        System.out.println("");
        
        
        int[] recorridoPreorden = new int[resultListPreoreden.size()+1];
        
        for (int j = 0; j < recorridoPreorden.length; j++) {
            recorridoPreorden[j]=-1;
        }
        
        recorridoPreorden[0]=resultListPreoreden.get(0).getNodoIncial();
       
        for (int j = 0; j < resultListPreoreden.size(); j++) {
            
            pivote=resultListPreoreden.get(j).getNodoIncial();
           
            int k=0;
            boolean found=false;
            
            while(k<recorridoPreorden.length & !found){
                if (recorridoPreorden[k]==pivote){
                    found=true;
                }else{
                    k++;
                }    
            }
            
            if (!found){
                int l=0;
                found=false;
                while (l<recorridoPreorden.length & !found){
                    if (recorridoPreorden[l]==-1){
                        recorridoPreorden[l]=pivote;
                        found=true;
                    }else{
                        l++;
                    }
                } 
            }
            pivote=resultListPreoreden.get(j).getNodoFinal();
            k=0;
            found=false;
            while(k<recorridoPreorden.length & !found){
                if (recorridoPreorden[k]==pivote){
                    found=true;
                }else{
                    k++;
                }    
            }
            
            if (!found){
                int l=0;
                found=false;
                while (l<recorridoPreorden.length & !found){
                    if (recorridoPreorden[l]==-1){
                        recorridoPreorden[l]=pivote;
                        found=true;
                    }else{
                        l++;
                    }
                } 
            } 
        }
       System.out.print("RECORRIDO EN PREORDEN => { ");
        for (int j = 0; j < recorridoPreorden.length; j++) {
            System.out.print(cabecera[recorridoPreorden[j]]);
            if(j!=recorridoPreorden.length-1){
                System.out.print(", ");
            }else{
                System.out.println(" }");
            }
        }
        
        System.out.print(" Añadimos la arista para obtener el ciclo hamiltoniano => { ");
        for (int j = 0; j < recorridoPreorden.length-1; j++) {
            System.out.print( "{"+cabecera[recorridoPreorden[j]]+", "+cabecera[recorridoPreorden[j+1]]+"}");
            if(j!=recorridoPreorden.length-2){
                System.out.print(", ");
            }else{
                System.out.println(", {"+cabecera[recorridoPreorden[j+1]]+", "+cabecera[recorridoPreorden[0]]+"} }");
            }
        }

        
    }
    
    
}
