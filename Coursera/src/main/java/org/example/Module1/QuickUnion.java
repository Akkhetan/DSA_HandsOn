package org.example.Module1;

import java.util.Arrays;

public class QuickUnion {
    public int[] id;

    public QuickUnion(int N) {
       id = new int[N];
       for(int i =0; i<N; i++)
           id[i] = i;
    }

    //chase parent pointers until reach roo
    private int root(int i){
        while(i != id[i])
            i = id[i];
        return i;
    }

    public boolean concatenated(int p, int q){
        return root(p) == root(q);
    }

    //change root of p to point to root of q
    public void union(int p, int q){
        int i = root(p);
        int j = root(q);
        id[i] = j;
        System.out.println("Array after current union : " + Arrays.toString(this.id));
    }

    public static void main(String[] args) {
        QuickUnion quickUnion = new QuickUnion(10);
        System.out.println("Original Array : " + Arrays.toString(quickUnion.id));
        quickUnion.union(4,3);
        quickUnion.union(3,8);
        quickUnion.union(6,5);
        quickUnion.union(9,4);
        quickUnion.union(2,1);
        quickUnion.union(5,0);
        quickUnion.union(7,2);
        quickUnion.union(6,1);
        quickUnion.union(7,3);




    }
}