package com.sb.problems.queues;

import java.util.ArrayDeque;

/**
 * Given a string A denoting a stream of lowercase alphabets. You have to make new string B.
 *
 * B is formed such that we have to find first non-repeating character each time a character is inserted to the stream and append it at the end to B. If no non-repeating character is found then append '#' at the end of B.
 *
 * Problem Constraints
 * 1 <= length of the string <= 100000
 *
 * Input Format
 * The only argument given is string A.
 *
 * Output Format
 * Return a string B after processing the stream of lowercase alphabets A.
 *
 * Example Input
 * Input 1:
 *
 *  A = "abadbc"
 * Input 2:
 *
 *  A = "abcabc"
 *
 * Example Output
 * Output 1:
 *
 *  "aabbdd"
 * Output 2:
 *
 *  "aaabc#"
 *
 * Example Explanation
 * Explanation 1:
 *
 *     "a"      -   first non repeating character 'a'
 *     "ab"     -   first non repeating character 'a'
 *     "aba"    -   first non repeating character 'b'
 *     "abad"   -   first non repeating character 'b'
 *     "abadb"  -   first non repeating character 'd'
 *     "abadbc" -   first non repeating character 'd'
 * Explanation 2:
 *
 *     "a"      -   first non repeating character 'a'
 *     "ab"     -   first non repeating character 'a'
 *     "abc"    -   first non repeating character 'a'
 *     "abca"   -   first non repeating character 'b'
 *     "abcab"  -   first non repeating character 'c'
 *     "abcabc" -   no non repeating character so '#'
 */
public class FirstNonRepeatingCharacterInStream {

    public static void main(String[] args) {
        System.out.println(solve("aabc"));
        System.out.println(solve("aac"));
        System.out.println(solve("abadbc"));
        System.out.println(solve("abcabc"));
        System.out.println(solve("djuwrmoy"));

    }

    private static String solve(String A) {
        int[] arr = new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        ArrayDeque<Character> queue = new ArrayDeque<>();
        StringBuilder resultBuilder = new StringBuilder();
        for(Character c : A.toCharArray()) {
            arr[c-97]++;
            queue.addLast(c);
            while(!queue.isEmpty() && arr[queue.peekFirst()-97] > 1) {
                queue.pop();
            }
            if(queue.isEmpty()) {
                resultBuilder.append('#');
            } else {
                resultBuilder.append(queue.peekFirst());
            }
        }
        return resultBuilder.toString();
    }
}
