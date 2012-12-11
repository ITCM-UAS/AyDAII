package Diagnostico;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author Grajalemx
 */
public class Main {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        Scanner sc = new Scanner(new FileReader("src/Diagnostico/in.txt"));
        int n = sc.nextInt();
        int Matriz[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Matriz[i][j] = sc.nextInt();
            }
        }

        //imprimir matriz en consola
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.println(Matriz[i][j]);
            }

        }
        int D1 = DiagonalD(Matriz);
        System.out.println(D1);
        int D2 = DiagonalI(Matriz);
        System.out.println(D2);
        String Sal = D1 + " " + D2;
        FileWriter fw = new FileWriter("out.txt");
        BufferedWriter br = new BufferedWriter(fw);
        PrintWriter pw = new PrintWriter(br);
        pw.print(Sal);
        pw.close();


    }

    public static int DiagonalD(int M[][]) {
        int D1 = 0;

        for (int i = 0; i <= M.length; i++) {
            for (int j = 0; j < M[0].length; j++) {
                if (i == j) {
                    D1 = D1 + M[i][j];
                }
            }
        }

        return D1;
    }

    public static int DiagonalI(int M[][]) {
        int D1 = 0;

        for (int i = M.length - 1; i >= 0; i--) {
            for (int j = M[0].length - 1; j >= 0; j--) {
                if (i == j) {
                    D1 = D1 + M[i][j];
                }
            }
        }

        return D1;
    }
}