package Array_String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

public class ReverseVowels {

    public static void main(String[] args) {
        String s = "IceCreAm";// "leetcode" ,"IceCreAm";
        System.out.println(new ReverseVowels().reverseVowels(s));
        System.out.println( " reverseVowelsOptimised : " + new ReverseVowels().reverseVowelsOptimised(s));
    }

    //brute force solution : Time complexity  = O(N) & Space complexity = O(N)
    public String reverseVowels(String s) {
        char[]  chars =  new char[]{'a','e','i','o','u','A','E','I','O','U'};
        char[] charArray = s.toCharArray();
        Arrays.sort(chars);
        List<Character> vowelsList = new ArrayList<>() ;
        for(int i=0; i<charArray.length; i++){
            if(Arrays.binarySearch(chars,charArray[i]) >= 0){
                vowelsList.add(charArray[i]);
            }
        }
        ListIterator<Character> listIterator = vowelsList.listIterator(vowelsList.size());

        for(int i=0; i<charArray.length; i++){
            if(Arrays.binarySearch(chars,charArray[i]) >= 0  && listIterator.hasPrevious()){
                charArray[i] = listIterator.previous();
            }
        }
        return String.valueOf(charArray);
    }

    //Optimised solution : Time complexity  = O(N) & Space complexity = O(1)
    public String reverseVowelsOptimised(String s) {
        String vowel = "aeiouAEIOU";
        char[] charArray = s.toCharArray();
        int left = 0;
        int right = charArray.length-1;

        while(left<right){
            while( left<right && vowel.indexOf(charArray[left]) == -1)
             left++;

            while( right> left && vowel.indexOf(charArray[right]) == -1)
                right--;

            if(left<right){
                char temp = charArray[left];
                charArray[left] = charArray[right];
                charArray[right] = temp;
                left++;
                right--;
            }
        }
        return String.valueOf(charArray);


    }
}
