package LCS;

/**
 *
 * @author Grajalesmx
 */
public class LCS {

    private static int[][] L; // Matriz de Coicidencias
    private static int k; // Variable para almacenar numero de Coincidencias
    private static int[] XY; // Arreglo para Cadena 
    private static int A = 0;// Variable auxiliar

    public static void main(String[] args) {
        int X[] = {1, 7, 4, 6, 2, 5, 8};    //Cadena a Comparar
        int Y[] = {1, 4, 8, 6, 4, 5, 2, 8}; //Cadena a Comparar
//        String X[]={"o","s","i","t","o","b","i","m","b","o"};
//        String Y[]={"o","s","o","b","i","b","o"};

        L = new int[X.length + 1][Y.length + 1]; //Inicializar el arreglo de Tamaño n,m

        k = LCS.LCS(X, Y);
        
        System.out.println("");
        System.out.println(k); //Imprime el numero de Coincidencias      
    }

    public static int LCS(int[] X, int[] Y) {
//    public static int LCS(String[] X, String[] Y) {
        int m = X.length; //Numero de elementos en la cadena X
        int n = Y.length; //Numero de elementos en la cadena Y

        // Iniciamos el Arreglo de Coincidencias con la Fila y Columna de Sacrificio en 0
        for (int i = 0; i < X.length; i++) {
            L[i][0] = 0;
        }
        for (int j = 0; j < Y.length; j++) {
            L[0][j] = 0;
        }

        // Inicia el Recorrido de las cadenas
        for (int i = 1; i <= X.length; i++) {
            for (int j = 1; j <= Y.length; j++) {

                //Coincidencias
                if (X[i - 1]==(Y[j - 1])) {
//                    if (X[i - 1] == Y[j - 1]) {
                    L[i][j] = L[i - 1][j - 1] + 1; // Suma 1 al valor de la Diagonal izq.

                } // No Coincidencias
                else {
                    L[i][j] = Math.max(L[i - 1][j], L[i][j - 1]); //Obtiene el numero mayor entre el numero superior y el izq.
                }
            }
        }

        return L[m][n]; // Regresa el valor ubicado al final de la matriz con el numero mayor de coincidencias
    }

    }
