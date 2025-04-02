package Array_String;

public class MergeString {

    public static void main(String[] args) {
        String word1 = "abc", word2 = "pqrs";
        System.out.println(new MergeString().mergeAlternately(word1,word2));
        System.out.println(new MergeString().mergeAlternatelyOptimised(word1,word2));

    }

    //this is my solution    brute fore solution
    public String mergeAlternately(String word1, String word2) {
        int l1 = word1.length();
        int l2 = word2.length();
        int minLen = Math.min(l1, l2);
        StringBuilder mergStr = new StringBuilder();
        int i = 0;
        for(; i < minLen; i++){

            mergStr.append(word1, i, i+1).append(word2, i, i+1);
        }
        if(l1!= minLen)
            mergStr.append(word1,i,l1);
        if(l2!= minLen)
            mergStr.append(word2,i,l2);
        return String.valueOf(mergStr);
    }

    // this is a optimised solution from chat gpt
    public String mergeAlternatelyOptimised(String word1, String word2) {
        StringBuilder mergedStr = new StringBuilder();
        int i = 0, len1 = word1.length(), len2 = word2.length();

        // Merge characters alternately
        while (i < len1 || i < len2) {
            if (i < len1) mergedStr.append(word1.charAt(i));
            if (i < len2) mergedStr.append(word2.charAt(i));
            i++;
        }

        return mergedStr.toString();
    }


}
