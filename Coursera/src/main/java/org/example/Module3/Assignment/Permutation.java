package org.example.Module3.Assignment;

//import edu.princeton.cs.algs4.StdIn;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;

public class Permutation {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int numOfInputs;
        int k = Integer.parseInt(args[0]);
        System.out.println("Enter number of inputs");
        numOfInputs = Integer.parseInt(br.readLine());

        System.out.println("Enter " + numOfInputs + " number of strings : ");
        RandomizedQueue<String> rq = new RandomizedQueue<>();
        while(numOfInputs-- > 0){
            rq.enqueue(String.valueOf(br.readLine()));
        }

        System.out.println("contents in deque : ");

        Iterator<String> iterator = rq.iterator();
        while(k-->0  && iterator.hasNext()){
            System.out.println( iterator.next());
        }
    }
}