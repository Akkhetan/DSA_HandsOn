/*
You are given an integer array nums and an integer k.
In one operation, you can pick two numbers from the array whose sum equals k and remove them from the array.
Return the maximum number of operations you can perform on the array.

Example 1:

Input: nums = [1,2,3,4], k = 5
Output: 2
Explanation: Starting with nums = [1,2,3,4]:
- Remove numbers 1 and 4, then nums = [2,3]
- Remove numbers 2 and 3, then nums = []
There are no more pairs that sum up to 5, hence a total of 2 operations.
 */
package TwoPointers;

import java.util.Arrays;

public class MaxOperations {
    public static void main(String[] args) {
        int[] nums = {3,1,3,4,3,3,2,0,6};
        int k = 6;
        System.out.println(MaxOperations.maxOperations(nums,k));
    }

    public static int maxOperations(int[] nums, int k) {
        int left = 0;
        int right  = nums.length - 1;
        int count = 0;
        Arrays.sort(nums);
        while(left<right){
            if(nums[left] + nums[right] == k){
                count++;
                left++;
                right--;
            } else if (nums[left] + nums[right] > k)
                right--;
            else
                left++;
        }
        return count;
    }
}
