package com.sb.problems.bit_manipulation;

public class NumberOf1sInBinaryRepresentation {

    /**
     * Get number of 1s in the binary representation of an integer
     * @param a - input integer
     * @return - number of 1s in the binary representation
     */
    private int getNumberOf1sInBinary(int a) {
        int numberOf1s = 0;
        if(a==0) {
            return 0;
        }
        int divResult = a;
        while(divResult >=1) {
            if(divResult%2 == 1){
                numberOf1s++;
            }
            divResult/=2;
        }
        if(a < 0) {
            numberOf1s++;
        }
        return numberOf1s;
    }


    private int solve(int a) {
        /*int bitPosition = 1;
        int n = 0;
        for(int i=0; i< Integer.SIZE-1; i++) {
            if((a & bitPosition) == 1) {
                n++;
            }
            bitPosition <<= 1;
        }
        return n;*/


        int count  = 0;
        for (int i = 0; i <= Math.log(a); i++) {
            if ((a & (1 << i)) == 1) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        NumberOf1sInBinaryRepresentation obj = new NumberOf1sInBinaryRepresentation();
        System.out.println(obj.getNumberOf1sInBinary(11));
        System.out.println(obj.getNumberOf1sInBinary(10));
        System.out.println(obj.solve(11));
        System.out.println(obj.solve(10));
    }
}
