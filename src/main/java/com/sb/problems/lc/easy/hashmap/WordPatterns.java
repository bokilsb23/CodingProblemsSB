package com.sb.problems.lc.easy.hashmap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class WordPatterns {
    public boolean wordPattern(String pattern, String s) {
        if(s == null || pattern == null) return false;
        s = s.trim();
        if(s.isEmpty() && pattern.isEmpty()) return true;
        Map<Character, String> map = new HashMap<>();
        String[] splitArray = Arrays.stream(s.split(" ")).filter(str -> !str.isEmpty()).toArray(String[]::new);
        if(splitArray.length != pattern.length())  {
            return false;
        }

        for (int i = 0; i < splitArray.length; i++) {
            if (map.containsKey(pattern.charAt(i))) {
                if (!map.get(pattern.charAt(i)).equals(splitArray[i])) {
                    return false;
                }
            } else {
                map.put(pattern.charAt(i), splitArray[i]);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        WordPatterns wp = new WordPatterns();
        System.out.println(wp.wordPattern("abba", "dog cat  cat dog"));
        System.out.println(wp.wordPattern("abba", "dog cat cat fish"));
        System.out.println(wp.wordPattern("aaaa", "dog cat cat dog"));
        System.out.println(wp.wordPattern("", "dog cat cat dog"));
        System.out.println(wp.wordPattern("a", " "));
    }
}
