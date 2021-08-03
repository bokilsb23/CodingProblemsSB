package com.sb.problems.maths;

public class SquareRoot {

    public int sqrt(int A) {
        long highLong = A/2;
        long prevHighLong = highLong;
        while(A > 8 && Math.pow(highLong, 2) > A) {
            prevHighLong = highLong;
            highLong /=2;
        }
        long high = prevHighLong;

        if(Math.pow(high, 2) == A) {
            return Long.valueOf(high).intValue();
        }

        long low = 0;
        while(low <= high) {
            long mid = low + (high-low)/2;
            long square = Math.round(Math.pow(mid,2));
            long onePlusSquare = Math.round(Math.pow(mid+1,2));
            long oneMinusSquare = Math.round(Math.pow(mid-1,2));
            if(onePlusSquare == A) {
                return Long.valueOf(mid+1).intValue();
            }
            else if(oneMinusSquare == A) {
                return Long.valueOf(mid-1).intValue();
            }
            else if(square == A || ((square > A && oneMinusSquare < A) || (square < A && onePlusSquare > A))) {
                if(square > A && /*oneMinusSquare < A && */A > 8) {
                    return Long.valueOf(mid - 1).intValue();
                }
                if(square < A && /*onePlusSquare > A && */A > 8) {
                    if(A-square < onePlusSquare - A) {
                        return Long.valueOf(mid).intValue();
                    }
                    else {
                        return Long.valueOf(mid).intValue();
                    }
                }
                return Long.valueOf(mid).intValue();
            }
            else if(square > A) {
                high = mid-1;
            }
            else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        SquareRoot sqrt = new SquareRoot();
        System.out.println(sqrt.sqrt(20));
        System.out.println(sqrt.sqrt(3));
        System.out.println(sqrt.sqrt(2));
        System.out.println(sqrt.sqrt(9));
        System.out.println(sqrt.sqrt(101));
        System.out.println(sqrt.sqrt(2));
        System.out.println(sqrt.sqrt(3));
        System.out.println(sqrt.sqrt(11));
        System.out.println(sqrt.sqrt(740819855));
        System.out.println(sqrt.sqrt(930675566));
        System.out.println(sqrt.sqrt(323989976));//17999*/
        System.out.println(sqrt.sqrt(997133530));
    }
}
