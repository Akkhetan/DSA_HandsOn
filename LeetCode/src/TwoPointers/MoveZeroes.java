/*
Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
Note that you must do this in-place without making a copy of the array.

Example 1:
Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]
Example 2:
Input: nums = [0]
Output: [0]
 */

package TwoPointers;

import java.util.Arrays;

public class MoveZeroes {
    public static void main(String[] args) {
        int[] nums = {1,0,2,0,3};
       // Solution.moveZeroes(nums);
        MoveZeroes.moveZeroesOptimized(nums);
    }

    //brute force solution : Time complexity  = O(N square)

    public static void moveZeroes(int[] nums) {
        int len = nums.length;
        int countZero = 0;
        for(int i = 0; i< len; i++){
            if(nums[i] ==0){
                countZero++;
            }
            else{
                int k = i;
                for(int j = 0; j < countZero; j++) {
                    int temp = nums[k];
                    nums[k] = nums[k - 1];
                    nums[k - 1] = temp;
                    k--;
                }
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    //Optimised solution : Time complexity  = O(N)
    public static void moveZeroesOptimized(int[] nums) {
    int left = 0;
    for(int right = 0; right<nums.length; right++){
        if (nums[right] != 0) {
            int temp = nums[right];
            nums[right] = nums[left];
            nums[left] = temp;
            left++;
        }
    }
        System.out.println(Arrays.toString(nums));
    }
    }

