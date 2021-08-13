package com.sb.problems.maths;

public class ExcelTitleBaseConversion {

    public static void main(String[] args) {
        ExcelTitleBaseConversion obj = new ExcelTitleBaseConversion();
        /*System.out.println(obj.convertExcelTitleBaseToDecimal("Z"));
        System.out.println(obj.convertExcelTitleBaseToDecimal("AZ"));
        System.out.println(obj.convertExcelTitleBaseToDecimal("BZ"));
        System.out.println(obj.convertExcelTitleBaseToDecimal("A"));
        System.out.println(obj.convertExcelTitleBaseToDecimal("AA"));
        System.out.println(obj.convertExcelTitleBaseToDecimal("BA"));*/
        System.out.println(obj.convertToExcelTitleBase(1353));

        /*System.out.println();
        System.out.println(obj.titleToNumber("Z"));
        System.out.println(obj.titleToNumber("AZ"));
        System.out.println(obj.titleToNumber("BZ"));
        System.out.println(obj.titleToNumber("A"));
        System.out.println(obj.titleToNumber("AA"));
        System.out.println(obj.titleToNumber("BA"));
        System.out.println(obj.titleToNumber("AZA"));
        System.out.println(obj.convertExcelTitleBaseToDecimal("AZA"));*/


    }

    //TODO:THIS CODE IS NOT WORKING CORRECTLY FOR 1353-AZA
    private String convertToExcelTitleBase(int number) {
        int divisionResult = number;
        StringBuilder result= new StringBuilder();
        int divMod=number;
        while(divisionResult > 1 || (divisionResult == 1 && divMod != 0)) {
            divMod = divisionResult%26;
            result = new StringBuilder((convertResultToLetters(divMod))).append(result);
            divisionResult/=26;
        }
        return result.toString();
    }

    private int titleToNumber(String A) {
        int result = 0;
        int power = 0;

        for(int i = A.length()-1; i>=0; i--){
            int d = A.charAt(i) - 'A' + 1;
            result+=(d * Math.pow(26,power));
            power++;
        }
        return result;
    }

    private int convertExcelTitleBaseToDecimal(String number) {
            String numString = String.valueOf(number);
            int decValue = 0;
            for(int i=0; i <numString.length(); i++) {
                long decimalValue = number.charAt(numString.length() - i - 1) - 'A' + 1;
                decValue += decimalValue * Math.round(Math.pow(26, i));
            }
            return decValue;
    }

    private String convertResultToLetters(long number) {
        if(number ==0) {
            number = 26;
        }

        return String.valueOf((char)(number + 64));

    }
}
