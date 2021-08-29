package com.sb.problems.strings;

public class AtoiStringToIntConversion {

    public static void main(String[] args) {
        AtoiStringToIntConversion obj = new AtoiStringToIntConversion();
        System.out.println(obj.atoi("1234"));//1234
        System.out.println(obj.atoi("123a4"));//123
        System.out.println(obj.atoi("9 1234"));//9

        System.out.println(obj.atoi("-1234"));//-1234
        System.out.println(obj.atoi("-123a4"));//-123
        System.out.println(obj.atoi("-9 1234"));//-9
        System.out.println(obj.atoi(""));//0
        System.out.println(obj.atoi(null));//0
        System.out.println(obj.atoi("-"));//0
        System.out.println(obj.atoi("     -01"));//-1
        System.out.println(obj.atoi("-2147483648abc"));//-2147483648
        System.out.println(obj.atoi("   -01"));//-1

        System.out.println(obj.atoi("        -"));//0
        System.out.println(obj.atoi("- 5 88C340185Q 71 8079 834617385 2898422X5297Z6900"));//0
        System.out.println(obj.atoi("0 14119 16368 66S5265 5109 2 5K 53 3G 39654000"));//0

    }

    /**
     * Convert String to it's corresponding number, while taking care of all the corner cases.
     * @param A - string
     * @return - numeric value
     */
    private int atoi(String A) {
        if(A == null) {
            return 0;
        }
        int val = 0;
        boolean isNegative = false;
        boolean signOrNumberEncountered = false;
        int strLen = A.length();
        for (int i = 0; i< strLen; i++) {
            if((val == 0 && (A.charAt(i) == ' ' ||A.charAt(i) == 9) && !signOrNumberEncountered)) {//leading whitespaces
                continue;
            }
            if((val == 0 && A.charAt(i) == '-')){//first sign negative (first character or first after leading whitespaces)
                isNegative = true;
                signOrNumberEncountered = true;
                continue;
            }
            else if((val == 0 && A.charAt(i) == '+')){//first sign positive (first character or first after leading whitespaces)
                isNegative = false;
                signOrNumberEncountered = true;
                continue;
        }
            if(A.charAt(i) < '0' || A.charAt(i) > '9'){ // non digit character encountered
                if(!signOrNumberEncountered && (A.charAt(i) != ' ' || A.charAt(i) != 9)) { // encountered a non-whitespace character before encountering any sign or digit
                    return val;
                }
                if(signOrNumberEncountered) { // non digit character encountered after valid digits
                    return isNegative ? val- (val*2) : val;
                }
            }
            if(val >= Integer.MAX_VALUE/10) { //if next value is greater than integer max or lesser than integer min
                return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            signOrNumberEncountered = true;
            val = val * 10 + (A.charAt(i) - '0');
        }
        return isNegative ? val - (val*2) : val;
    }
}
