package com.sb.problems.maths;

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

public class AllFactorsOfANumber {
    public Set<Integer> allFactors(int number) {
        if(number == 0) {
            return Collections.emptySet();
        }
        Set<Integer> factors = new TreeSet<>();
        factors.add(1);
        factors.add(number);
        for(int i = Long.valueOf(Math.round(Math.sqrt(number))).intValue() ; i > 1 ; i--) {
            if(number%i == 0) {
                factors.add(i);
                factors.add(number/i);
            }
        }
        return factors;
    }

    public static void main(String[] args) {
        AllFactorsOfANumber obj = new AllFactorsOfANumber();
        System.out.println(obj.allFactors(875246889));
    }
}
