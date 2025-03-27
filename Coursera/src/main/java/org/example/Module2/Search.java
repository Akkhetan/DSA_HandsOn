package org.example.Module2;

import java.util.Arrays;

public class Search {

    static int binarySearch(int [] numArray, int numtoSearch){
        int length = numArray.length;
        Arrays.sort(numArray);
        int start = 0;
        int end = length - 1;
        int mid;
        while(start <= end){
            mid = start + (end - start)/2;
            if(numtoSearch < numArray[mid])
                end = mid - 1;
            else if(numtoSearch > numArray[mid])
                start = mid + 1;
            else{
               // System.out.println(numtoSearch + " is at array index : " + mid);
                return mid;
            }
        }
       // System.out.println(numtoSearch + " doesn't exist in the array");
        return -1;
    }

    static int bruteforceSearch(int [] numArray, int numtoSearch){
        int length = numArray.length;
        for(int i =0; i<length; i++){
            if(numArray[i] == numtoSearch){
                System.out.println(numtoSearch + " is at array index : " + i);
                return i;
            }

        }
        System.out.println(numtoSearch + " doesn't exist in the array");
        return -1;
    }
}