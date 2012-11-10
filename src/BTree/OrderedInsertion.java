package BTree;

public class OrderedInsertion {

    public static int[] OInsertion(int E[], int element, int m) {

        for (int i = m - 1; i >= 0; i--) {
            if (E[i] >= element) {
                E[i + 1] = E[i];
            } else {
                E[i + 1] = element;
            }
            if (E[i] == 0) {
                E[i] = element;
            }
            break;
        }
        return E;
    }
}