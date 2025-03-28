package org.example.Module3;

public class ArrayWithFixedSizeStackOps {
    private final String [] S;
    private int n = 0;

    public ArrayWithFixedSizeStackOps(int capacity) {
        S = new String[capacity];
    }

    public void push(String item){
        S[n++] = item;
    }

    public String pop(){
        String item = S[--n];
        S[n] = null;
        return item;
    }

    public boolean isEmpty(){
        return n==0;
    }

    public static void main(String[] args) {
        ArrayWithFixedSizeStackOps arrayStackOps = new ArrayWithFixedSizeStackOps(10);
        arrayStackOps.push("1");
        arrayStackOps.push("2");
        arrayStackOps.push("3");
        arrayStackOps.push("4");
        System.out.println("Pop out item : " + arrayStackOps.pop());
    }
}