package com.sb.problems.maths;

public class PowerFunction {

    public static void main(String[] args) {
        PowerFunction pf = new PowerFunction();
        System.out.println(pf.pow(2,10, 16777216));
        System.out.println(pf.pow(2,3, 5));
        System.out.println(pf.pow(71045970,41535484,64735492));


        System.out.println(pf.powerMod(2,10, 16777216));
        System.out.println(pf.powerMod(2,3, 5));
        System.out.println(pf.powerMod(71045970,41535484,64735492));
    }

    public long powerMod(long x, long n, long d) {
        if(n==0) {
            return 1L%d;
        }

        if(n % 2 == 0) {
            long pow = powerMod(x, n/2L, d);
            return Math.floorMod((Math.multiplyExact(pow,pow)),d);
        }
        else {
            long pow = powerMod(x, (n-1L)/2L, d);
            return (((pow*pow)%d)*(x%d))%d;
        }
    }

    public long pow(long x, long n, long d) {
        long answer = 1;
        long base = x;
        while(n >0){
            if(n%2 == 1) {
                answer = (answer * (base))%d;
                n--;
            }
            else {
                base = (base*base)%d;
                n = n/2;
            }
        }
        return answer;
    }

}
