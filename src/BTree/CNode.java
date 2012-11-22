package BTree;

/**
 *
 * @author Grajalesmx
 */
public class CNode<E extends Comparable<E>> {

    private int size;
    private E[] data;
    private CNode<E>[] child;
    private CNode<E> parent;

    public CNode(int order, CNode<E> parent) {
        
        this.data = (E[]) new Comparable[order];
        this.child = (CNode<E>[]) new CNode[order];
        this.size = 0;
        this.parent = parent;
        
    }

    public void OInsertion(E e) {
        if (getSize() < 5) {
            int i = getData().length - 1;
            getData()[i] = e;
            E tmp = getData()[i];
            for (; i > 0 && (getData()[i - 1] == null || tmp.compareTo(getData()[i - 1]) < 0); i--) {
                getData()[i] = getData()[i - 1];
            }
            getData()[i] = tmp;
            setSize(getSize() + 1);
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

    /**
     * @return the size
     */
    public int getSize() {
        
        return size;
        
    }

    /**
     * @param size the size to set
     */
    public void setSize(int size) {
        
        this.size = size;
        
    }

    /**
     * @return the data
     */
    public E[] getData() {
        
        return data;
        
    }

    /**
     * @param data the data to set
     */
    public void setData(E[] data) {
        
        this.data = data;
        
    }

    /**
     * @return the child
     */
    public CNode<E>[] getChild() {
        
        return child;
        
    }

    /**
     * @param child the child to set
     */
    public void setChild(CNode<E>[] child) {
        
        this.child = child;
        
    }

    /**
     * @return the parent
     */
    public CNode<E> getParent() {
        
        return parent;
        
    }

    /**
     * @param parent the parent to set
     */
    public void setParent(CNode<E> parent) {
        
        this.parent = parent;
        
    }
}
