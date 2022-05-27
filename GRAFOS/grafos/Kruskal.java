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
  
//    public static char[] cabecera=   {  '1', '2', '3', '4', '5', '6', '7'};
//    public static int [][] matriz = { {  0,   2,   4,   1,  -1,  -1,  -1},//1
//                                      {  2,   0,  -1,   3,  10,  -1,  -1},//2
//                                      {  4,  -1,   0,   2,  -1,   5,  -1},//3
//                                      {  1,   3,   2,   0,   2,   8,   4},//4
//                                      { -1,  10,  -1,   2,   0,  -1,   6},//5
//                                      { -1,  -1,   5,   8,  -1,   0,   1},//6
//                                      { -1,  -1,  -1,   4,   6,   1,   0},//7
//                                      };
//    public static char[] cabecera=   {  'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'k'}; // Poner si son letras, siempre en minúsculas
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
//    
//    public static char[] cabecera=    { 'a', 'b', 'c', 'd', 'e', 'f'}; // Poner si son letras, siempre en minúsculas
//    public static int [][] matriz = { {   0,   5,   6,   4,   3,   7},//a
//                                      {   5,   0,   2,   4,   8,   5},//b
//                                      {   6,   2,   0,   4,   8,   8},//c
//                                      {   4,   4,   4,   0,   2,   5},//d
//                                      {   3,   8,   8,   2,   0,   4},//e
//                                      {   7,   5,   8,   5,   4,  0}};//f
//     public static char[] cabecera={  'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'}; // Poner si son letras, siempre en minúsculas
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
    
//    public static char[] cabecera ={  'a', 'b', 'c', 'd', 'e'}; // Poner si son letras, siempre en minúsculas
//    public static int[][] matriz = {{  0,   57,  64,   8,  26},//a
//                                    { 57,    0,  88,  54,  34},//b
//                                    { 64,   88,   0,  57,  56},//c
//                                    {  8,   54,  57,   0,  23},//d
//                                    { 26,   34,  56,  23,  0},//e
//                                    };
    public static char[] cabecera=   {  '1', '2', '3', '4', '5', '6', '7'};
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
        int pesoTotal=0;
        for (KruskalClass list:mst){
            if (list.getNodo()!=""){
                System.out.println("║ "+(list+"              ").substring(0, 18)+"║");
                pesoTotal=pesoTotal+list.getPeso();
            }    
        }
        System.out.println("╠═════════╪═════════╣");
        System.out.println("║ Total   │ "+(String.valueOf(pesoTotal)+"           ").substring(0, 7)+" ║");
        System.out.println("╚═════════╧═════════╝");
        System.out.println("pesoTotal");
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
