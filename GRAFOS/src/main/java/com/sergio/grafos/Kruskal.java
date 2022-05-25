package com.sergio.grafos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author sergiomolinagonzalez
 */
public class Kruskal {
      
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
        
        
       
        
        System.out.println("╔═════════╤═════════╗");
        System.out.println("║ Aristas │ Pesos   ║");
        System.out.println("╠═════════╪═════════╣");
        
        for (KruskalClass list:resultList){
            boolean found = false;
            for (KruskalClass isInMst:mst){
                if (isInMst.equals(list)){
                    found=true;
                }
            }
            if (found){
                System.out.println("║ "+(list+" *             ").substring(0, 18)+"║");
            }else{
                System.out.println("║ "+(list+"              ").substring(0, 18)+"║");
            }    
        }
        System.out.println("╚═════════╧═════════╝");
         
        System.out.println("╔═══════════════════╗");
        System.out.println("║     RESULTADO     ║");        
        System.out.println("╠═════════╤═════════╣");
        System.out.println("║ Aristas │ Pesos   ║");
        System.out.println("╠═════════╪═════════╣");
        
        for (KruskalClass list:mst){
            if (list.getNodo()!=""){
                System.out.println("║ "+(list+"              ").substring(0, 18)+"║");
            }    
        }
        System.out.println("╚═════════╧═════════╝");
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
