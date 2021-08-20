package com.sb.problems.maths;

import java.util.Arrays;

public class NextSimilarNumber {
    public static void main(String[] args) {
        NextSimilarNumber obj = new NextSimilarNumber();

        System.out.println(obj.nextSimilarInt("13542"));//14532 - 14235
        System.out.println(obj.nextSimilarInt("93542"));//94532 - 94235
        System.out.println(obj.nextSimilarInt("94235"));//94253
        System.out.println(obj.nextSimilarInt("1234"));//94253
        System.out.println(obj.nextSimilarInt("4321"));//94253
        System.out.println(obj.nextSimilarInt("99999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999"));//94253
        System.out.println(obj.nextSimilarInt("1531"));//94253
        System.out.println(obj.nextSimilarInt("892795"));//895792-895279

    }


    private String nextSimilarInt(String A) {
        int prevDigit = getNum(A, A.length()-1);
        int selectedDigit = -1;
        int selectedIndex = -1;
        for(int i = A.length()-2; i >=0; i--) {
            int currNum = getNum(A, i);
            if(currNum < prevDigit) {
                selectedDigit = currNum;
                selectedIndex = i;
                break;
            }
            prevDigit = currNum;
        }
        if(selectedDigit == -1) {
            return "-1";
        }
        int smallestNumber = 10;
        int currSmallestIndex = selectedIndex;
        for(int i=selectedIndex+1; i< A.length();i++) {
            int currNum = getNum(A, i);
            if(currNum < smallestNumber && currNum > selectedDigit) {
                smallestNumber = currNum;
                currSmallestIndex = i;
            }
        }
        A = swapIndexes(A, selectedIndex, currSmallestIndex);


        String substr = A.substring(selectedIndex+1);


        char[] chars = substr.toCharArray();
        int[] intArray = new int[chars.length];
        for(int i=0; i<chars.length;i++) {
            intArray[i] = Character.getNumericValue(chars[i]);
        }
        Arrays.sort(intArray);
        StringBuilder sb = new StringBuilder();
        Arrays.stream(intArray).forEach(sb::append);

        return A.substring(0, selectedIndex+1).concat(sb.toString());
    }

    private String swapIndexes(String A, int index1, int index2) {
        char[] chars = A.toCharArray();
        char temp = chars[index1];
        chars[index1] = chars[index2];
        chars[index2] = temp;
        return new String(chars);
    }

    private int getNum(String A, int index) {
        return Character.getNumericValue(A.charAt(index));
    }
}
