/*
Given an array of integers arr, return true if the number of occurrences of each value in the array is unique or false otherwise.
Example 1:
Input: arr = [1,2,2,1,1,3]
Output: true
Explanation: The value 1 has 3 occurrences, 2 has 2 and 3 has 1. No two values have the same number of occurrences.
Example 2:
Input: arr = [1,2]
Output: false
Example 3:
Input: arr = [-3,0,1,-3,1,1,1,-3,10,0]
Output: true
 */
package Hash_Map_Set;

import java.util.*;
import java.util.stream.Collectors;

public class UniqueOccurrences {
    public static void main(String[] args) {
        int[] arr = {1,2,2,1,1,3};
        System.out.println(uniqueOccurrences(arr));
        System.out.println(uniqueOccurrencesOptimised(arr));

    }


    //brute force solution : Time complexity  = O(n²) (due to Collections.frequency used inside stream) &  space complexity = O(k) for temporary substring
    public static boolean uniqueOccurrences(int[] arr) {
        List<Integer> list = Arrays.stream(arr).boxed().toList();
        Map<Integer, Integer> map = list.stream().collect(Collectors.toMap(x -> x, x -> Collections.frequency(list, x),
                (existing, replacement) -> existing));
        Collection<Integer> values = map.values();
        Set<Integer> valueSet = new HashSet<>(values);

        return values.size() == valueSet.size();
    }

    //Optimised solution : Time complexity  = O(N) Space: O(N)
    public static boolean uniqueOccurrencesOptimised(int[] arr) {
        Map<Integer, Integer> freqMap = new HashMap<>();

        // Count frequencies
        for (int num : arr) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        Set<Integer> seenFrequencies = new HashSet<>();
        for(Integer value : freqMap.values()){
            if(!seenFrequencies.add(value))
                return false;
        }
        return true;
    }
}
