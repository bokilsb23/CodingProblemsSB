package com.sb.problems.maths;

public class GreatestCommonDivisor {

    public static void main(String[] args) {
        GreatestCommonDivisor gcd = new GreatestCommonDivisor();
        //System.out.println(Integer.MAX_VALUE);
        //System.out.println(gcd.findGCD(2147483646, 12));
        System.out.println(gcd.findGCD(2147483646, 1073741823));
        System.out.println(gcd.findGCD(6, 9));
        //System.out.println(gcd.findGCD(150000, 15));
        System.out.println(gcd.findGCD(20, 28));
        System.out.println(gcd.findGCD(98, 56));



        //System.out.println(Integer.MAX_VALUE);
        System.out.println(gcd.findGCDEuclidean(2147483646, 12));
        System.out.println(gcd.findGCDEuclidean(2147483646, 1073741823));
        System.out.println(gcd.findGCDEuclidean(6, 9));
        //System.out.println(gcd.findGCD(150000, 15));
        System.out.println(gcd.findGCDEuclidean(20, 28));
        System.out.println(gcd.findGCDEuclidean(98, 56));
    }

    private int findGCD(int A, int B) {
        if(A == 0) {
            return B;
        }
        if(A == B || B == 0) {
            return A;
        }
        int greaterNumber = A > B ? A : B;
        int lesserNumber = A < B ? A : B;
        int gcd = 1;
        int maxLimit = greaterNumber/2 < lesserNumber ? greaterNumber/2 : lesserNumber;

        if(A%2 == 0 && B%2 == 0 && maxLimit%2 != 0) {
            maxLimit--;
        }

        for(int i = maxLimit; i > 1; i--) {
            if(A%i ==0 && B%i == 0 && gcd%i != 0) {
                gcd*=i;
            }
        }
        return gcd;
    }

    private int findGCDEuclidean(int A, int B) {
        if(A ==0) return B;
        if(B==0 || A==B) return A;

        /*if(A > B) {
            return findGCDEuclidean(A-B, B);
        }
        return findGCDEuclidean(A, B-A);*/
        return findGCDEuclidean(B, A%B);
    }
}
