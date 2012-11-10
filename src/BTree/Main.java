package BTree;

public class Main {

    /*
     @author Grajalesmx

     Input: E is an order array.
     element is an element to insert.
     m is the numer of elements inserted
     Output: E an order array with elements inserted
     phanton position value is -1 if array is not overflow
     */
    public static void main(String[] args) {

        int E[] = {11, 12, 23, 29};
        int EIn[] = {12, 23, 11, 30, 45};
        int EOut[] = null; //Out array
        int NOrder = 5;
        int element = 10;
        int search = 23;
        int m;
        int BSearch;

//m = E.length - 1;      
//        EOut = OrderedInsertion.OInsertion(E, element, m);
        //        for (int i = 0; i < EOut.length - 1; i++) {
//            System.out.println(EOut[i]);
//        }       

        CNode n1 = new CNode(NOrder);
        for (int i = 0; i < EIn.length - 1; i++) {
            element = EIn[i];
            n1.OInsertion(element);
        }
        for (int i = 0; i < n1.data.length - 1; i++) {
            System.out.println(n1.data[i]);
        }

        m = n1.data.length - 1;
        BSearch = CNode.BSearch(n1.data, search, 0, m);
        System.out.println("Posicion Hijo en :" + BSearch);
    }
}
//Adaptar "Busqueda Binaria" para que no regrese -1 si no se encuentra el 
//numero buscado, que regrese la posicion del hijo donde posiblemente este la llave
// Crear nodo de arbol B, con grado 5
//Order=grado
//node n1=new node(5);
//insertar al nodo los elementos 11,12,23,29
//OInsert (n1.data,12,0);
//OInsert (n1.data,23,1);
//realizar busquedas : 23,11,12,29,15 regresando la posicion.
//System.out.print(BinarySearch(n1.data,23));