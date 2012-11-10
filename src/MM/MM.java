package MM;

/**
 *
 * @author Grajalesmx
 */
public class MM {

    static int[][] M, S;

    public static void main(String[] args) {

        int r[] = {6,5,4,3,2,1};
        MatrixChain(r);
        System.out.println("Matriz M:");
        System.out.println("");
        
        for (int i=1;i<M.length;i++)
        {
            for (int j=1;j<M[i].length;j++)
            {
                System.out.print("|"+M[i][j]+"|");
            }
            System.out.println(" ");
        }
        System.out.println("");
        System.out.println("Matriz S:");
        for (int i=1;i<S.length;i++)
        {
            for (int j=1;j<S[i].length;j++)
            {
                System.out.print("|"+S[i][j]+"|");
            }
            System.out.println(" ");
        }
        
    }

    public static void MatrixChain(int r[]) {

        int i, q = 0, j = 0, n = r.length;

        M = new int[n][n];
        S = new int[n][n];

        for (i = 1; i < n; i++) {

            M[i][i] = 0;
            S[i][i]=i;
        }

        for (int l = 2; l < n; l++) {
            for (i = 1; i < (n - l) + 1; i++) {

                j = (i + l) - 1;
                M[i][j] = 99999;

                for (int k = i; k < j; k++) {

                    q = M[i][k] + M[k + 1][j] + (r[i - 1] * r[k] * r[j]);

                    if (q < M[i][j]) {

                        M[i][j] = q;
                        S[i][j] = k;
                    }
                }
            }
        }
    }
}