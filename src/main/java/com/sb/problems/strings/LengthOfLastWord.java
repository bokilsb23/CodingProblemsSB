package com.sb.problems.strings;

public class LengthOfLastWord {

    public static void main(String[] args) {
        LengthOfLastWord obj = new LengthOfLastWord();
        System.out.println(obj.getLengthOfLastWord("Wordl   "));
        System.out.println(obj.getLengthOfLastWord("slamic State suicide bombers attacked crowds of people gathered Thursday outside Kabul airport hoping to flee Taliban-controlled Afghanistan, killing dozens including 13 US troops, as President Joe Biden vowed to hunt down those responsible.\n" +
                "The Taliban said the two blasts killed between 13 and 20 people. A health official in the previous government said the toll could rise to 60.\n" +
                "\n" +
                "President Joe Biden has vowed to \"hunt\" down the terrorists and make them \"pay\" for the deadly attacks outside the Kabul airport in which 13 US service members were killed and 18 others wounded. \n" +
                "\n" +
                "\"To those who carried out this attack, as well as anyone who wishes America harm notice, we will not forgive. We will not forget. We will hunt you down and make you pay. I will defend our interests and our people with every measure at my command,\" Biden told reporters at the White House on Thursday."));
    }

    private int getLengthOfLastWord(String A) {
        if(A.length() == 0) {
            return 0;
        }
        Character prevChar = null;
        int charsToSkip=0;
        for(int i = A.length()-1; i >= 0; i--) {
            if((prevChar == null || prevChar == ' ') && A.charAt(i) == ' ') {
                charsToSkip++;
                continue;
            }

            if(A.charAt(i) == ' ') {
                return A.length()- (i+1+charsToSkip);
            }
            prevChar = A.charAt(i);
        }
        return A.length()-charsToSkip;
    }
}
