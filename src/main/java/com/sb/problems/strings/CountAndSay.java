package com.sb.problems.strings;

public class CountAndSay {

    public static void main(String[] args) {
        CountAndSay obj = new CountAndSay();
        System.out.println(obj.countAndSay(5));
    }

    private String countAndSay(int A) {
        String prevElement = "1";
        if (A == 1) {
            return "1";
        }
        for (int i = 1; i < A; i++) {
            prevElement = getNextElement(prevElement);
        }
        return prevElement;
    }

    private String getNextElement(String currEle) {
        StringBuilder nextEle = new StringBuilder();
        Character currChar = null;
        int currCount = 0;
        for (char c : currEle.toCharArray()) {
            if(currChar != null) {
                if (currChar == c) {
                    currCount++;
                } else {
                    nextEle.append(currCount).append(currChar);
                    currChar = c;
                    currCount = 1;
                }
            } else {
                currChar = c;
                currCount=1;
            }
        }
        nextEle.append(currCount).append(currChar);
        return nextEle.toString();
    }
}
