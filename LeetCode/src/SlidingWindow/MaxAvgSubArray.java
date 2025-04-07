/*
You are given an integer array nums consisting of n elements, and an integer k.
Find a contiguous subarray whose length is equal to k that has the maximum average value and return this value. Any answer with a calculation error less than 10-5 will be accepted.
Example 1:
Input: nums = [1,12,-5,-6,50,3], k = 4
Output: 12.75000
Explanation: Maximum average is (12 - 5 - 6 + 50) / 4 = 51 / 4 = 12.75
Example 2:
Input: nums = [5], k = 1
Output: 5.00000
 */
package SlidingWindow;

import java.util.Arrays;

public class MaxAvgSubArray {
    public static void main(String[] args) {
        int[] nums = {1,12,-5,-6,50,3};//  {0,1,1,3,3};//{1,12,-5,-6,50,3};
        int k = 4;
        System.out.println(findMaxAverage(nums,k));
        System.out.println(findMaxAverageOptimised(nums,k));

    }

    //brute force solution : Time complexity  = O(N*K)
    public static double findMaxAverage(int[] nums, int k) {
        double maxAvg = 0;
        int len = nums.length - k;
        for(int i =0; i<= len; i++){
            int sum = 0;
            boolean flag = false;
            for(int j = i; j<k+i; j++){
                sum = sum + nums[j];
                flag = true;
            }
            if(i==0){
                if(flag)
                    maxAvg = (double) sum /k;
                else{
                    Arrays.sort(nums);
                    maxAvg = nums[nums.length - 1];
                }
            }
            else {
                double avg = (double) sum /k;
                maxAvg = Math.max(maxAvg, avg);
            }
        }
        return maxAvg;
    }

    //Optimised solution : Time complexity  = O(N)
    public static double findMaxAverageOptimised(int[] nums, int k) {
        int sum = 0;
        int len = nums.length;
        for(int i = 0; i<k; i++){
            sum = sum + nums[i];
        }

        int maxSum = sum;

        for (int i = k; i < nums.length; i++) {
            sum = sum + nums[i] - nums[i - k];
            maxSum = Math.max(maxSum, sum);
        }

        return (double) maxSum /k;


    }

}
