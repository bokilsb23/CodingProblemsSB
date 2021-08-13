package com.sb.problems.maths;

public class BaseConversion {

    private int convertToDecimal(int number, int base) {
        String numString = String.valueOf(number);
        int decValue = 0;
        for(int i=0; i <numString.length(); i++) {
            decValue += Long.parseLong(String.valueOf(numString.charAt(numString.length() - i - 1))) * Math.round(Math.pow(base, i));
        }
        return decValue;
    }

    /*This won't work for any base greater than 10*/
    private int convertToBaseN(int number, int base) {
        int divisionResult = number;
        StringBuilder result= new StringBuilder();
        while(divisionResult >= 1 ) {
            result = new StringBuilder((Long.toString(divisionResult%base))).append(result);
            divisionResult/=base;
        }
        return Integer.parseInt(result.toString());
    }

    private String convertToBinary(int A) {
        if(A == 0) {
            return String.valueOf(A);
        }
        int divResult = A;
        StringBuilder result = new StringBuilder();
        while(divResult >= 1) {
            result = new StringBuilder(Long.toString(divResult % 2)).append(result);
            divResult /= 2;
        }
        return result.toString();
    }


    public static void main(String[] args) {
        BaseConversion obj = new BaseConversion();
        System.out.println(obj.convertToDecimal(1010, 2));
        System.out.println(obj.convertToBaseN(1, 2));
        System.out.println(obj.convertToBinary(0));
    }
}
