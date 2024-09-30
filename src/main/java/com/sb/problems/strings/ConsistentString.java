package com.sb.problems.strings;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ConsistentString {
    public int countConsistentStrings(String allowed, String[] words) {
        return Arrays.stream(words).filter(word -> containsAllChars(word,allowed)).collect(Collectors.toList()).size();
    }

    private boolean containsAllChars(String word, String allowed) {
        if (word == null || allowed == null) return false;
        for(char c : word.toCharArray()) {
            if (allowed.indexOf(c) == -1) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        ConsistentString s = new ConsistentString();
        System.out.println(s.countConsistentStrings("ab", new String[]{"ad","bd","aaab","baa","badab"}));
        System.out.println(s.countConsistentStrings("abc", new String[]{"a","b","c","ab","ac","bc","abc"}));
        System.out.println(s.countConsistentStrings("cad", new String[]{"cc","acd","b","ba","bac","bad","ac","d"}));

    }

}