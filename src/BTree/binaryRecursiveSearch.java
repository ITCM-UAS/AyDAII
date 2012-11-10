package BTree;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Victor Diaz
 */
public class binaryRecursiveSearch {

    public static int binaryRecursiveSearchA(double E[], double k, int low, int uper) {
        int mid=0;
        if (low <= uper) {
            mid = (low + uper) / 2;
            if (E[mid] == k) {
                return mid;
            } else if (E[mid] > k) {
                return binaryRecursiveSearchA(E, k, mid, uper);
            } else {
                return binaryRecursiveSearchA(E, k, low, mid-1);
            }
        }
        else{if (k>E[low-1]){
            return E.length;
        }else{
            return mid;
        }
    }
    }

}
