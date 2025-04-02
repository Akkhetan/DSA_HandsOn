package Array_String;

import java.util.Arrays;

public class ProductArrayExceptSelf {
    public static void main(String[] args) {
        int [] nums = {2,4,3,5,6};
        System.out.println(Arrays.toString(ProductArrayExceptSelf.productExceptSelf(nums)));
        System.out.println("productExceptSelfOptimised : " + Arrays.toString(ProductArrayExceptSelf.productExceptSelfOptimised(nums)));
        System.out.println("productExceptSelfOptimised2 : " + Arrays.toString(ProductArrayExceptSelf.productExceptSelfOptimised2(nums)));
    }

    //brute force solution : Time complexity  = O(N square)
    public static int[] productExceptSelf(int[] nums) {
        int[] multiNums = new int[nums.length];
        for(int i = 0; i< nums.length; i++){
            int mult = 1;
            for(int j = 0; j<nums.length; j++){
                if(j!=i)
                    mult = mult*nums[j];
            }
            multiNums[i] = mult;
        }

        return multiNums;
    }

    // optimised solution 1 : Time Complexity would be O(n), but we are now using Auxilary Space of O(n)
    public static int[] productExceptSelfOptimised(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        prefix[0] = 1;
        suffix[n-1] = 1;

        for(int i = 1; i < n; i++)
            prefix[i] = prefix[i-1]*nums[i-1];

        for(int j = n-2; j>=0; j--)
            suffix[j] = suffix[j+1]*nums[j+1];

        int[] ans = new int[n];

        for (int i = 0; i<n; i++){
            ans[i] = prefix[i]*suffix[i];
        }

        return ans;
    }

    // optimised solution 2 : Time Complexity would be O(n) but now, the Auxilary Space is O(1) (excluding the final answer array).
    public static int[] productExceptSelfOptimised2(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int current = 1;
        for(int i = 0; i < n; i++){
            ans[i] = current;
            current *= nums[i];
        }

        current = 1;
        for(int j = n-1; j >=0; j--) {
            ans[j] *= current;
            current *= nums[j];
        }

        return ans;
    }

    }
