package com.sb.problems.maths;

public class DistributeInCircle {
    public int distribute(int A, int B, int C) {
        /*int startingIndex = C;
        if(C > B) {
            startingIndex = C%B;
        }
        return A%B + (startingIndex-1);*/
        //TODO: What's the difference between above solution and below solution?
        return (((A+C-1)%B) == 0) ? B : ((A+C-1)%B);
    }

    public static void main(String[] args) {
        DistributeInCircle obj = new DistributeInCircle();
        System.out.println(obj.distribute(2,5,1));
        System.out.println(obj.distribute(8,5,2));
        System.out.println(obj.distribute(Integer.MAX_VALUE,5,2));
        System.out.println(obj.distribute(8,Integer.MAX_VALUE,2));
        System.out.println(obj.distribute(8,5,Integer.MAX_VALUE));
        System.out.println(Integer.MAX_VALUE);
    }
}
