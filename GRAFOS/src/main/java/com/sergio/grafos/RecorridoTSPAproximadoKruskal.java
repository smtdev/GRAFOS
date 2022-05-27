package com.sergio.grafos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author sergiomolinagonzalez
 */
public class RecorridoTSPAproximadoKruskal {
    
//    public static char[] cabecera ={  'a', 'b', 'c', 'd', 'e'}; // Poner si son letras, siempre en minúsculas
//    public static int[][] matriz = {{  0,   10,   1,  10,  0},//a
//                                    { 10,    0,   1,   0, 10},//b
//                                    {  1,    1,   0,   1,  1},//c
//                                    { 10,    0,   1,   0, 10},//d
//                                    {  0,   10,   1,  10,  0},//e
//                                    };
//    public static char[] cabecera ={  'A', 'b', 'c', 'd', 'e'}; // Poner si son letras, siempre en minúsculas
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
//                                    
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
        List <KruskalClass> resultList = new ArrayList<KruskalClass>();
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
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                if (matriz[i][j]!=-1 && i!=j){
                    KruskalClass kruskalClass = new KruskalClass(i,j,(matriz[i][j]),"{ "+cabecera[i]+","+cabecera[j]+" }");
                    boolean found=false;
                    for (KruskalClass list:resultList){
                        if (kruskalClass.getNodoIncial()==list.getNodoFinal() && kruskalClass.getNodoFinal()==list.getNodoIncial()){
                             found=true;
                        }
                    }
                    if (!found)
                        resultList.add(kruskalClass);
                }          
            }
        }
        Collections.sort(resultList, new SortByPeso());
        
       // Stores the mst
        KruskalClass mst[] = new KruskalClass[resultList.size() - 1];
        for (int i = 0; i < resultList.size() - 1; i++) {
            mst[i] = new KruskalClass(-1, -1, -1,"");
        }
        int e = 0;      // Number of edges included in mst
        
        // Create v subsets, v is the number of vertices
        Subset subsets[] = new Subset[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            subsets[i] = new Subset();
        }
        // Initialise parent of all as itself and rank as 0
        for (int i = 0; i <resultList.size(); i++) {
            subsets[i].parent = i;
            subsets[i].rank = 0;
        }
        // One by one traverse all the edges
        for (int i = 0; i < resultList.size(); i++) {
            // Find the set of vertices present on this edge
            int x = find(subsets, resultList.get(i).getNodoIncial());
            int y = find(subsets, resultList.get(i).getNodoFinal());
            // If the set is not same(that is, no cycle is formed)
            // Add this edge to mst
            if (x != y) {
                mst[e].setNodoIncial(resultList.get(i).getNodoIncial());
                mst[e].setNodoFinal(resultList.get(i).getNodoFinal());
                mst[e].setPeso(resultList.get(i).getPeso());
                mst[e].setNodo(resultList.get(i).getNodo());
                Union(subsets, x, y);
                e++;
            } else {
                // Discard the edge
            }
        }
         
        System.out.println("╔═══════════════════╗");
        System.out.println("║     RESULTADO     ║");        
        System.out.println("╠═════════╤═════════╣");
        System.out.println("║ Aristas │ Pesos   ║");
        System.out.println("╠═════════╪═════════╣");
        int pesoTotal=0;
        for (KruskalClass list:mst){
            
            if (!"".equals(list.getNodo())){
                System.out.println("║ "+(list+"              ").substring(0, 18)+"║");
                pesoTotal=pesoTotal+list.getPeso();
            }    
        }
        System.out.println("╠═════════╪═════════╣");
        System.out.println("║ Total   │ "+(String.valueOf(pesoTotal)+"           ").substring(0, 7)+" ║");
        System.out.println("╚═════════╧═════════╝");
        System.out.println("pesoTotal");
        
        
        System.out.println("╔═══════════════════╗");
        System.out.println("║     ORDENADO      ║");        
        System.out.println("╠═════════╤═════════╣");
        System.out.println("║ Aristas │ Pesos   ║");
        System.out.println("╠═════════╪═════════╣");
        pesoTotal=0;
        boolean[] marcado=new boolean[mst.length];
        for (int i = 0; i < marcado.length; i++) {
            marcado[i]=false;
        }
        
        List <KruskalClass> resultListPreoreden = new ArrayList<KruskalClass>();
        
        for (KruskalClass list:mst){
            if (list.getNodo()!=""){
                resultListPreoreden.add(list);
            }
        }
        for (int i = 0; i < resultListPreoreden.size(); i++) {
            for (int j = i+1; j < resultListPreoreden.size(); j++) {
                if (resultListPreoreden.get(j).getNodoIncial()<resultListPreoreden.get(i).getNodoIncial()){
                    KruskalClass help=resultListPreoreden.get(i);
                    resultListPreoreden.set(i, resultListPreoreden.get(j));
                    resultListPreoreden.set(j, help);
                } else {
                    if (resultListPreoreden.get(j).getNodoIncial()==resultListPreoreden.get(i).getNodoIncial()){
                        if (resultListPreoreden.get(j).getNodoFinal()<=resultListPreoreden.get(i).getNodoFinal()){
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
           int pivote = resultListPreoreden.get(i).getNodoFinal();
           
           for (int j = i+1; j < resultListPreoreden.size(); j++) {
               if (resultListPreoreden.get(j).getNodoIncial()==pivote || resultListPreoreden.get(j).getNodoFinal()==pivote){
                   KruskalClass help=resultListPreoreden.get(j);
                   for (int k = j; k > (i+1); k--) {
                       resultListPreoreden.set(k, resultListPreoreden.get(k-1));
                   }
                   resultListPreoreden.set((i+1), help);
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
            
            int pivote=resultListPreoreden.get(j).getNodoIncial();
           
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
    
    static class SortByPeso implements Comparator<KruskalClass> {
        @Override
        public int compare(KruskalClass a, KruskalClass b) {
            return a.compareTo(b);
        }
    }
    
     private static int find(Subset subsets[], int i) {
        // Path Compression
        if (subsets[i].parent != i)
            subsets[i].parent = find(subsets, subsets[i].parent);
        return subsets[i].parent;
    }
     
    static class Subset {
        int parent;
        int rank;
    }
    
    // Function to perform union of two sets of x and y
    private static void Union(Subset subsets[], int x, int y) {
        int xRoot = find(subsets, x);
        int yRoot = find(subsets, y);
        // (Union by Rank)
        if (subsets[xRoot].rank < subsets[yRoot].rank) {
            subsets[xRoot].parent = yRoot;
        } else if (subsets[xRoot].rank > subsets[yRoot].rank) {
            subsets[yRoot].parent = xRoot;
        } else {
            // If rank are same, then make one as root and increment
            // its rank by one
            subsets[yRoot].parent = xRoot;
            subsets[xRoot].rank++;
        }
    }
}
