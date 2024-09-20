package com.sb.problems.lc.easy.maths;

import java.util.HashMap;
import java.util.Map;


public class RomanToInt {
    Map<Character, Integer> romanToIntMap = new HashMap<>();
    public RomanToInt() {
        romanToIntMap.put('I', 1);
        romanToIntMap.put('V', 5);
        romanToIntMap.put('X', 10);
        romanToIntMap.put('L', 50);
        romanToIntMap.put('C', 100);
        romanToIntMap.put('D', 500);
        romanToIntMap.put('M', 1000);
    }

    public int romanToInt(String roman) {
        int number = 0;
        char[] charArray = roman.toCharArray();
        for(int i =0; i < charArray.length; i++) {
            int currNum = romanToIntMap.get(charArray[i]);
            if (i+1 < charArray.length && romanToIntMap.get(charArray[i+1]) > currNum) {
                currNum = romanToIntMap.get(charArray[i+1]) - currNum;
                i++;
            }
            number += currNum;
        }
        return number;
    }

    public static void main(String[] args) {
        RomanToInt romanToInt = new RomanToInt();
        System.out.println(romanToInt.romanToInt("MCMXCIV"));
        System.out.println(romanToInt.romanToInt("LVIII"));
        System.out.println(romanToInt.romanToInt("CVII"));
        System.out.println(romanToInt.romanToInt("III"));
        System.out.println(romanToInt.romanToInt("XCVIII"));
    }

}
