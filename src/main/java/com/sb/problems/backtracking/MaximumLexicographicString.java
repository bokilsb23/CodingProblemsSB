package com.sb.problems.backtracking;

public class MaximumLexicographicString {

    public static void main(String[] args) {
        MaximumLexicographicString obj = new MaximumLexicographicString();
        System.out.println(obj.solve("254",1));
        System.out.println(obj.solve("254",2));
    }

    String currMax;
    public String solve(String A, int B) {
        currMax = A;
        searchMaxNum(currMax,B);
        return currMax;
    }

    private void searchMaxNum(String A, int B){
        if(Integer.parseInt(A) > Integer.parseInt(currMax)){
            currMax = A;
        }
        if(B == 0){
            return;
        }
        for(int i=0; i < A.length()-1; i++){
            for(int j = i+1; j < A.length(); j++){
                if(A.charAt(i) < A.charAt(j)){
                    A = swapChars(A,i,j);
                }
                searchMaxNum(A,B-1);
                A= swapChars(A,i,j);
            }
        }
    }

    private String swapChars(String str, int i, int j){
        return str.substring(0,i) + str.charAt(j) + str.substring(i+1,j) + str.charAt(i) + str.substring(j+1);
    }

}
