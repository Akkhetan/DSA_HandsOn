package org.example.Module3;

public class LinkedListStackOps {

    private Node first = null;

    private class Node{
        String item;
        Node next;
    }

    public void push(String item){
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
    }

    public String pop(){
        String item = first.item;
        first = first.next;
        return item;
    }

    public boolean isEmpty(){
        return first == null;
    }


        public static void main(String[] args) {
            LinkedListStackOps stackOps = new LinkedListStackOps();
            stackOps.push("1");
            stackOps.push("2");
            stackOps.push("3");
            stackOps.push("4");
            System.out.println("Pop out item : " + stackOps.pop());
        }
}