package org.example.Module2;

import java.util.Arrays;

public class ThreeSum {
    public static void main(String[] args) {
        int [] numArray = {30,-40,-20,-10,40,0,10,5};
        bruteForce(numArray);
        System.out.println("--------------------------------------------------------------------");
        sortingBasedAlgo(numArray);
   }

    static void sortingBasedAlgo(int [] numArray){
        int length = numArray.length;
        System.out.println("Original Array = " + Arrays.toString(numArray));
        Arrays.sort(numArray);
        System.out.println("Sorted Array = " + Arrays.toString(numArray));
        for(int i = 0; i<length; i++){
            for(int j = i+1; j<length; j++){
                int numtoSearch = -(numArray[i] + numArray[j]);
                int k = Search.binarySearch(numArray, numtoSearch);
                if(k != -1 && numArray[i] < numArray[j] && numArray[j] < numArray[k])
                    System.out.println("3 sum pair : " + numArray[i] + " , " + numArray[j] + " , " + numArray[k]);
            }
        }
    }

    static void bruteForce(int [] numArray){
        int length = numArray.length;
        System.out.println("numArray = " + Arrays.toString(numArray));
        for(int i = 0; i<length; i++){
            for(int j = i + 1; j<length; j++){
                for(int k = j+1; k<length; k++){
                    if(numArray[i] + numArray[j] + numArray[k] ==0)
                        System.out.println("3 sum pair : " + numArray[i] + " , " + numArray[j] + " , " + numArray[k]);
                }
            }
        }
    }
}