package com.sb.problems.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class WaveArray {
    private ArrayList<Integer> waveArray(ArrayList<Integer> A) {
        Collections.sort(A);
        for(int i=0; i<A.size(); i+=2) {
            if(i+1 < A.size()) {
                Integer elementAtI = A.get(i);
                Integer elementAtIPlus1 = A.get(i+1);
                A.set(i, elementAtIPlus1);
                A.set(i+1, elementAtI);
            }
        }
        return A;
    }

    private ArrayList<Integer> waveArray2(ArrayList<Integer> A) {
        //Collections.sort(A);
        for(int i=0; i<A.size(); i+=2) {
            if(i>0 && A.get(i) < A.get(i-1)) {
                Integer currElement = A.get(i);
                Integer prevElement = A.get(i-1);
                A.set(i, prevElement);
                A.set(i-1, currElement);
            }
           if(i+1 < A.size() && A.get(i) < A.get(i+1) ) {
               Integer currElement = A.get(i);
               Integer nextElement = A.get(i+1);
               A.set(i, nextElement);
               A.set(i+1, currElement);
            }
        }
        return A;
    }


    public static void main(String[] args) {
        WaveArray wa = new WaveArray();
        /*ArrayList<Integer> arrayList1 = wa.waveArray(new ArrayList(Arrays.asList(1, 2, 3, 4)));
        ArrayList<Integer> arrayList2 = wa.waveArray(new ArrayList(Arrays.asList(4,3,2,1)));
        ArrayList<Integer> arrayList3 = wa.waveArray(new ArrayList(Arrays.asList(1)));
        ArrayList<Integer> arrayList4 = wa.waveArray(new ArrayList(Arrays.asList(1,15,23,51,12,15,24,24)));*/

        ArrayList<Integer> arrayList1 = wa.waveArray2(new ArrayList(Arrays.asList(1, 2, 3, 4)));
        ArrayList<Integer> arrayList2 = wa.waveArray2(new ArrayList(Arrays.asList(4,3,2,1)));
        ArrayList<Integer> arrayList3 = wa.waveArray2(new ArrayList(Arrays.asList(1)));
        ArrayList<Integer> arrayList4 = wa.waveArray2(new ArrayList(Arrays.asList(1,15,23,51,12,15,24,24)));

        arrayList1.forEach(e -> System.out.print(e + " "));
        System.out.println();
        arrayList2.forEach(e -> System.out.print(e + " "));
        System.out.println();
        arrayList3.forEach(e -> System.out.print(e + " "));
        System.out.println();
        arrayList4.forEach(e -> System.out.print(e + " "));
        System.out.println();
    }
}
