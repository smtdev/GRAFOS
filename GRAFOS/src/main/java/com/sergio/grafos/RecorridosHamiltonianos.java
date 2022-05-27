package com.sergio.grafos;

 
import java.util.ArrayList;
import java.util.List;
class RecorridosHamiltonianos {
  
    /* Gráfico asociado:
           (0) - - -- (2)
            |   \   /  |
            |    (1)   |
            |   /  |   |
            | /    |   |
           (5)----(4)--(3)*/
    
    
    // Driver Code
//    public static char[] cabecera={ 'A','B','C','D','E','F'};
//    public static int[][] matriz = {{  0,  1,  1,  0,  0,  1 },//A
//                                    {  1,  0,  1,  0,  1,  1 },//B
//                                    {  1,  1,  0,  1,  0,  0 },//C
//                                    {  0,  0,  1,  0,  1,  0 },//D
//                                    {  0,  1,  0,  1,  0,  1 },//E
//                                    {  1 , 1,  0,  0,  1,  0 },//F
//                                    };
      /* Gráfico asociado:
           
                (a)
               /   \
            (b)----(f)
            /  \   /  \
           /    \ /    \
         (c)----(d)----(e) */
//    public static char[] cabecera={  'A', 'B', 'C', 'D', 'E', 'F'};
//    public static int[][] matriz = {{  0,   1,   0,   0,   0,  1 },//A
//                                    {  1,   0,   1,   1,   0,  1 },//B
//                                    {  0,   1,   0,   1,   0,  0 },//C
//                                    {  0,   1,   1,   0,   1,  1 },//D
//                                    {  0,   0,   0,   1,   0,  1 },//E
//                                    {  1,   1,   0,   1,   1,  0 },//F
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
//    public static char[] cabecera={  'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i'};
//    public static int[][] matriz = {{  0,   1,   0,   1,   0,   0,   0,   0,  0},//a
//                                    {  0,   1,   1,   1,   1,   0,   0,   0,  0},//b
//                                    {  0,   0,   1,   0,   0,   1,   0,   0,  0},//c
//                                    {  1,   1,   0,   0,   1,   0,   1,   0,  0},//d
//                                    {  0,   1,   0,   1,   0,   1,   0,   1,  0},//e
//                                    {  0,   0,   1,   0,   1,   0,   0,   1,  1},//f
//                                    {  0,   0,   0,   1,   0,   0,   0,   1,  0},//g
//                                    {  0,   0,   0,   0,   1,   1,   1,   0,  1},//h
//                                    {  0,   0,   0,   0,   0,   1,   0,   1,  0},//i
//                                    };
//    public static char[] cabecera ={  'A', 'B', 'L', 'G', 'M', 'T'};
//    public static int[][] matriz = {{  0,    0,  157,  223,149,  0 },//Andorra
//                                    {  0,    0,    0,   96, 56, 105 },//Barcelona
//                                    { 157,   0,    0,    0,118,  91 },//LLeida
//                                    { 223,  96,    0,    0,157,   0 },//Girona
//                                    { 149,  56,  118,  157,  0,   0 },//Manresa
//                                    {   0, 105,   91,    0,  0,  0 },//Tarragona
//                                    };
    
//    public static char[] cabecera ={  'A', 'B', 'C', 'D', 'E'};
//    public static int[][] matriz = {{  0,   10,   1,  10,  0},//A
//                                    { 10,    0,   1,   0, 10},//B
//                                    {  1,    1,   0,   1,  1},//C
//                                    { 10,    0,   1,   0, 10},//D
//                                    {  0,   10,   1,  10,  0},//E
//                                    };
//    
//    public static char[] cabecera ={  'A', 'B', 'C', 'D', 'E'};
//    public static int[][] matriz = {{  0,   57,  64,   8,  26},//A
//                                    { 57,    0,  88,  54,  34},//B
//                                    { 64,   88,   0,  57,  56},//C
//                                    {  8,   54,  57,   0,  23},//D
//                                    { 26,   34,  56,  23,  0},//E
//                                    };
      public static char[] cabecera={  'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};
    public static int[][] matriz = {{  0,   2,   2,   3,   2,   3,   3,   3},//a
                                    {  2,   0,   2,   3,   2,   3,   1,   3},//b
                                    {  2,   2,   0,   3,   2,   1,   3,   3},//c
                                    {  3,   3,   3,   0,   1,   2,   2,   4},//d
                                    {  2,   2,   2,   1,   0,   3,   3,   3},//e
                                    {  3,   3,   1,   2,   3,   0,   2,   4},//f
                                    {  3,   1,   3,   2,   3,   2,   0,   4},//g
                                    {  3,   3,   3,   4,   3,   4,   4,   0},//h
                                    
                                    };
    public static List<KruskalClass> resultadoPesos;
    public static int bestPeso=0;
    
    public static void main(String args[]){
        RecorridosHamiltonianos hamiltonian = new RecorridosHamiltonianos();
        hamiltonian.hamCycle();
        System.out.println("╔═══════════════════╗");
        System.out.println("║     RESULTADO     ║");        
        System.out.println("╠═════════╤═════════╣");
        System.out.println("║ Aristas │ Pesos   ║");
        System.out.println("╠═════════╪═════════╣");
        int pesoTotal=0;
        for (KruskalClass list:resultadoPesos){
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
    
    // Función para verificar si se puede agregar un vértice v en el índice pos en el ciclo hamiltoniano.
    boolean isSafe(int v, ArrayList<Integer> path,int pos){
        
        // Si el vértice es adyacente al vértice del vértice agregado previamente.
        if (matriz[path.get(pos - 1)][v]== 0)
            return false;
  
        // Si el vértice ya ha sido incluido en el camino.
        for (int i = 0; i < pos; i++)
            if (path.get(i) == v)
                return false;
  
        // Las dos condiciones anteriores no son verdaderas, devuelve verdadero.
        return true;
    }
  
    // Para comprobar si existe al menos 1 ciclo hamiltoniano
    boolean hasCycle;
  
   // Función para encontrar todos los ciclos hamiltonianos posibles
    void hamCycle()
    {
        // El valor inicial de la bandera booleana es falso.
        
        hasCycle = false;
  
        // Guardamos el resultado en path.
        ArrayList<Integer> path = new ArrayList<>();
        path.add(0);
  
        // Mantiene el registro de los vértices visitados
        boolean[] visited = new boolean[matriz.length];
  
        for (int i = 0; i < visited.length; i++){
            visited[i] = false;
        }    
  
        int pivote=0;
        visited[pivote] = true;
        
        // Llamada de función para encontrar todos los ciclos hamiltonianos.
        FindHamCycle(1, path, visited);
  
        if (!hasCycle) {
            // Si no existe un ciclo hamiltoniano para el gráfico dado.
            System.out.println( "NO EXISTE CICLO HAMILTONIANO");
            return;
        }
    }
  
    // Función recursiva para encontrar el ciclo Hamiltoniano
    void FindHamCycle(int pos,ArrayList<Integer> path, boolean[] visited)
    {
        List<KruskalClass> listHelpPesos = new ArrayList();
        // Si todos los vértices están incluidos en el ciclo Hamiltoniano.
        if (pos == matriz.length) {
  
            // Si hay una arista desde el último vértice hasta el vértice de origen.
            if (matriz[path.get(path.size() - 1)][path.get(0)] != 0) {
  
               // Incluimos el vértice de origen en la ruta e imprimir la ruta.
                System.out.print("VÉRTICES ==> ");
                path.add(0);
                for (int i = 0; i < path.size(); i++) {
                    System.out.print( (cabecera[path.get(i)]+"          ").substring(0, 4));
                    if (i<path.size()-1){
                        System.out.print(" -> ");
                    }
                }
                System.out.println("");
                System.out.print("PESOS =====>   " );
                int peso = 0;
                for (int i = 0; i < path.size()-1; i++) {
                    KruskalClass kruskalClass = new KruskalClass(path.get(i),path.get(i+1),(matriz[path.get(i)][path.get(i+1)]),"{ "+cabecera[path.get(i)]+","+cabecera[path.get(i+1)]+" }");
                    System.out.print( (matriz[path.get(i)][path.get(i+1)]+"          ").substring(0, 4));
                    peso=peso+matriz[path.get(i)][path.get(i+1)];
                    listHelpPesos.add(kruskalClass);
                    if (i<path.size()-2){
                        System.out.print(" -> ");
                    }
                   
                }
                
                System.out.println(" ===> "+peso);
                
                if (bestPeso==0 || bestPeso>peso){
                    bestPeso=peso;
                    resultadoPesos=listHelpPesos; 
                }
  
                // Eliminamos el vértice agregado.
                path.remove(path.size() - 1);
  
                // Empezamos de nuevo.
                hasCycle = true;
            }
            return;
        }
  
        // Siguiente vértice
        for (int v = 0;  v < matriz.length; v++) {
             // Verificamos si este vértice se puede agregar al Ciclo.
            if (isSafe(v, path, pos) && !visited[v]) {
  
                path.add(v);
                visited[v] = true;
  
                // Siguiente vértice.
                FindHamCycle(pos + 1, path, visited);
  
                // Eliminamos y seguimos con el siguiente.
                visited[v] = false;
                path.remove(path.size() - 1);
            }
        }
    }
}