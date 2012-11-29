package BTree;

/**
 *
 * @author General_de_Division_DEM
 */
public class Nodo<E> {

    private int size = 0;
    private E[] data;
    private Nodo<E>[] child;

    //crea un nodo vacio
    @SuppressWarnings("unchecked")
    public Nodo(int order) {

        data = (E[]) new Comparable[order - 1];
        child = (Nodo<E>[]) new Nodo[order];
        size = 0;

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
    public Nodo<E>[] getChild() {

        return child;

    }

    /**
     * @param child the child to set
     */
    public void setChild(Nodo<E>[] child) {

        this.child = child;

    }
    //numero de elementos en el nodo

}
