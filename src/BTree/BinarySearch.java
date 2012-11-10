package BTree;

/**
 *
 * @author Grajalesmx
 */
public class BinarySearch {

    public int BSearch(int[] E, int element,int lower,int upper) {
        int center = 0;

        while (lower <= upper) {
            center = (upper + lower) / 2;

            if (E[center] == element) {
                return center;
            } else if ( element>E[lower-1]) {
                
                return -lower;
            } else {
                return -center;
            }
        }
        return 0;
    }
}
