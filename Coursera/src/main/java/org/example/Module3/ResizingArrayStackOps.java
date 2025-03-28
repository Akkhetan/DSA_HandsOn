package org.example.Module3;

import java.util.Arrays;

public class ResizingArrayStackOps {
    private String [] s = new String[1];
    private int n = 0;

    public void push(String item){
        System.out.println("Array length before push : " + s.length + " n = " + n + " , Array = " + Arrays.toString(s));
        if(n == s.length)
            resize(2*s.length);
        s[n++] = item;
        System.out.println("Array length after push : " + s.length + " n = " + n + " , Array = " + Arrays.toString(s));
    }

    public String pop(){
        System.out.println("Array length before pop : " + s.length + " n = " + n + " , Array = " + Arrays.toString(s));

        String item = s[--n];
        s[n] = null;
        if(n>0 && (n == s.length/4))
            resize(s.length/2);
        System.out.println("Array length after pop : " + s.length + " n = " + n + " , Array = " + Arrays.toString(s));
        return item;
    }

    public boolean isEmpty(){
        return n==0;
    }

    private void resize(int newCapacity){

        String [] copy = new String[newCapacity];
        for(int i = 0; newCapacity > s.length ? i< s.length : i< newCapacity; i++){
            copy[i] = s[i];
        }
        s = copy;
    }

    public static void main(String[] args) {
        ResizingArrayStackOps arrayStackOps = new ResizingArrayStackOps();
        for (int i = 0; i < 10; i++){
            System.out.println(" i = " + i);
            arrayStackOps.push(String.valueOf(i));
        }

        for (int i = 0; i < 12; i++){
            arrayStackOps.pop();
        }
        System.out.println("Array length : " + arrayStackOps.s.length);
        System.out.println("Array list : " + Arrays.toString(arrayStackOps.s));

    }
}