package LCS;

/**
 *
 * @author Grajalesmx
 */

public class LCS {

    private static int[][] L;
    private static int k;

    public static void main(String[] args) {
        int X[] = {1,7,4,6,2,5,8};
        int Y[] = {1,4,8,6,4,5,2,8};

        k = LCS.LCS(X, Y);

        System.out.println(k);
    }

    public static int LCS(int[] X, int[] Y) {
        int m = X.length;
        int n = Y.length;
        L = new int[X.length + 1][Y.length + 1];

        for (int i = 0; i < X.length; i++) {
            L[i][0] = 0;
        }
        for (int j = 0; j < Y.length; j++) {
            L[0][j] = 0;
        }

        for (int i = 1; i <= X.length; i++) {
            for (int j = 1; j <= Y.length; j++) {
                if (X[i - 1] == Y[j - 1]) {
                    L[i][j] = L[i - 1][j - 1] + 1;
                } else {
                    L[i][j] = Math.max(L[i - 1][j], L[i][j - 1]);
                }
            }
        }
        return L[m][n];
    }
}
