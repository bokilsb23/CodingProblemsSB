package com.sb.problems.arrays;

public class PrettyPrintMatrix {
    public int[][] prettyPrint(int A) {
        int size = A != 1 ? (A * 2) - 1 : 1;
        int[][] output = new int[size][size];
        for (int k = 0; k < size; k++) {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if ((i == k || i == size - (k + 1) || j == k || j == size - (k + 1)) && output[i][j] == 0) {
                        output[i][j] = A - k;
                    }
                }
            }
        }
        return output;
    }

    public static void main(String[] args) {
        PrettyPrintMatrix ppm = new PrettyPrintMatrix();
        int[][] ints = ppm.prettyPrint(5);
        for(int i=0; i< ints.length; i++) {
            for(int j=0; j<ints.length; j++){
                System.out.print(ints[i][j]+" ");
            }
            System.out.println("");
        }
    }
}
