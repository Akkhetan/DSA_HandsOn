/*
1456. Maximum Number of Vowels in a Substring of Given Length
Given a string s and an integer k, return the maximum number of vowel letters in any substring of s with length k.
Example 1:
Input: s = "abciiidef", k = 3
Output: 3
Explanation: The substring "iii" contains 3 vowel letters.
Example 2:
Input: s = "aeiou", k = 2
Output: 2
Explanation: Any substring of length 2 contains 2 vowels.
Example 3:
Input: s = "leetcode", k = 3
Output: 2
Explanation: "lee", "eet" and "ode" contain 2 vowels.
 */

package SlidingWindow;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        String s = "leetcode";
        int k = 3;
        System.out.println(maxVowels(s,k));
        System.out.println(maxVowelsOptimised(s,k));

    }

    //brute force solution : Time complexity  = O(N*K) &  space complexity = O(k) for temporary substring

    public static int maxVowels(String s, int k) {
        List<Character> vowels = new ArrayList<>(List.of('a','e','i','o','u','A','E','I','O','U'));
        StringBuilder sb = new StringBuilder(s.substring(0, k));
        int count = 0;
        for(int i = 0; i< sb.length(); i++){
            char c = sb.charAt(i);
            if(vowels.contains(c))
                count++;
        }
        int maxcount = count;
        for(int j = k; j< s.length(); j++){
            sb = sb.deleteCharAt(0).append(s.charAt(j));
            count = 0;

            for(int i = 0; i< sb.length(); i++){
                char c = sb.charAt(i);
                if(vowels.contains(c))
                    count++;
            }
            maxcount = Math.max(maxcount,count);
        }
        return maxcount;
    }

    //Optimised solution : Time complexity  = O(N) Space: O(1) (Set of vowels is constant in size)
    public static int maxVowelsOptimised(String s, int k) {
        int count = 0;
        Set<Character> vowels = new HashSet<>(Set.of('a','e','i','o','u','A','E','I','O','U'));
        for(int i =0; i<k; i++){
            if(vowels.contains(s.charAt(i)))
                count++;
        }
        int maxCount = count;
        for(int i = k; i< s.length(); i++){
            if(vowels.contains(s.charAt(i)))
                count++;
            if(vowels.contains(s.charAt(i-k)))
                count--;

            maxCount = Math.max(maxCount,count);
        }
        return maxCount;
    }

}
