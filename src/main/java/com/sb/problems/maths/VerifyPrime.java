package com.sb.problems.maths;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VerifyPrime {



    public boolean verifyPrime(int num) {
        Long number = (Integer.valueOf(num)).longValue();
        List<Character> endDigits = Arrays.asList('0', '2', '4', '6', '8');
        String s = number.toString();
        Character c = s.charAt(s.length() - 1);
        if(number <= 1) {
            return false;
        }
        if(endDigits.contains(c)) {
            return false;
        }

        long i = Math.round(Math.sqrt(number));
        i = i%2==0 ? i-1 : i;

        while(i > 1){
            if(number%i == 0) {
                return false;
            }
            i-=2;
        }
        return true;
    }

    public static void main(String[] args) {
        VerifyPrime prime = new VerifyPrime();
        System.out.println(prime.verifyPrime(5));
    }
}
