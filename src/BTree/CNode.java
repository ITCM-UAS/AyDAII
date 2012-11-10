package BTree;

/**
 *
 * @author Grajalesmx
 */
public class CNode<E extends Comparable<E>> {

    public int size;
    public E[] data;
    public CNode<E>[] child;

    public CNode(int order) {
        data = (E[]) new Comparable[order];
        child = (CNode<E>[]) new CNode[order];
        size = 0;
    }

    public void OInsertion(E e) {
        if (size < 5) {
            int i = data.length - 1;
            data[i] = e;
            E tmp = data[i];
            for (; i > 0 && (data[i - 1] == null || tmp.compareTo(data[i - 1]) < 0); i--) {
                data[i] = data[i - 1];
            }
            data[i] = tmp;
            size++;
        }
    }

    public static int BSearch(Comparable[] data, int search, int low, int uper) {

        int center = 0;
        if (low <= uper) {
            center = (low + uper) / 2;
            if (data[center] == (Comparable)search) {
                return center;
            } else if (data[center].compareTo(search) == 1) {
                return BSearch(data, search, center, uper);
            } else {
                return BSearch(data, search, low, center - 1);
            }
        } else {
            if ( data[low - 1].compareTo(search)==1 ) {
                return data.length;
            } else {
                return center;
            }
        }
    }
}
