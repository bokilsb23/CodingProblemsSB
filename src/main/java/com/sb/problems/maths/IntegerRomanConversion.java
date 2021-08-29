package com.sb.problems.maths;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class IntegerRomanConversion {
    private static final TreeMap<Integer, String> intToRom = new TreeMap<>();
    private static final Map<Character, Integer> romToInt = new HashMap<>();
    static {

        intToRom.put(1, "I");
        intToRom.put(4, "IV");
        intToRom.put(5, "V");
        intToRom.put(9, "IX");
        intToRom.put(10, "X");
        intToRom.put(40, "XL");
        intToRom.put(50, "L");
        intToRom.put(90, "XC");
        intToRom.put(100, "C");
        intToRom.put(400, "CD");
        intToRom.put(500, "D");
        intToRom.put(900, "CM");
        intToRom.put(1000, "M");

        romToInt.put('I', 1);
        romToInt.put('V', 5);
        romToInt.put('X', 10);
        romToInt.put('L', 50);
        romToInt.put('C', 100);
        romToInt.put('D', 500);
        romToInt.put('M', 1000);

    }
    public static void main(String[] args) {
        IntegerRomanConversion itr = new IntegerRomanConversion();
        System.out.println(itr.integerToRoman(59));
        System.out.println(itr.integerToRoman(1904));
        System.out.println(itr.integerToRoman(3549));


        System.out.println(itr.romanToInteger("LIX"));
        System.out.println(itr.romanToInteger("IX"));
        System.out.println(itr.romanToInteger("XL"));
        System.out.println(itr.romanToInteger("MCMIV"));
    }

    /**
     * Convert given integer to roman numeral string
     * @param A - integer
     * @return - roman numeral representation
     */
    private String integerToRoman(int A) {
        int value = A;
        StringBuilder result = new StringBuilder();
        //map of all corresponding roman letters with negating values



        while(value > 0) {
            Map.Entry<Integer, String> entry = intToRom.floorEntry(value);//get closest entry from map which is lesser than number
            int quotient = value / entry.getKey(); //divide number with entry
            value %=entry.getKey();//update number to remainder

            for(int i=0; i<quotient;i++) {//add corresponding roman numeral quotient times into the string
                result.append(entry.getValue());
            }
        }

        return result.toString();
    }


    /**
     * Converts given roman numeral to integer
     * @param A - roman numeral string
     * @return - integer value
     */
    private int romanToInteger(String A) {

        int result = 0;
        int size = A.length();

        for(int i = 0; i< size; i++) {
            if(i != size-1 && romToInt.get(A.charAt(i)) < romToInt.get(A.charAt(i+1))) { //handling negation scenarios (IV/ XL etc)
                result += (romToInt.get(A.charAt(i+1)) - romToInt.get(A.charAt(i)));
                i++;
            }
            else {//in normal scenario, simply add current character's value to the total
                result += romToInt.get(A.charAt(i));
            }
        }
        return result;
    }
}

