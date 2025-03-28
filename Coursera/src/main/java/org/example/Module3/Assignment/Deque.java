package org.example.Module3.Assignment;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
    Node first = null;
    Node last = null;
    int size = 0;

    class Node{
        Item item;
        Node next;
    }

    // construct an empty deque
    public Deque(){}

    // is the deque empty?
    public boolean isEmpty(){
        return size == 0;
    }

    // return the number of items on the deque
    public int size(){
       return size;
    }

    // add the item to the front
    public void addFirst(Item item){
        if(item == null)
            throw new IllegalArgumentException();
        Node oldNode = first;
        first = new Node();
        first.item = item;
        first.next = oldNode;
        if(last == null)
            last  = first;
        size++;
    }

    // add the item to the back
    public void addLast(Item item){
        if(item == null)
            throw new IllegalArgumentException();
        Node oldNode = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if(oldNode == null)
            first = last;
        else
            oldNode.next = last;

        size++;
    }

    // remove and return the item from the front
    public Item removeFirst(){
        if(isEmpty())
            throw new NoSuchElementException();
        Item item = first.item;
        first = first.next;
        if(first == null)
            last = null;
        size--;
        return item;
    }

    // remove and return the item from the back
    public Item removeLast(){
        if(isEmpty())
            throw new NoSuchElementException();
        Item item = last.item;

        if(first == last){
            first = last = null;
        }
        else {
            Node current = first;
            while(current.next != last){
                current = current.next;
            }
            last = current;
            last.next = null;
        }
        size --;
        return item;
    }

    // return an iterator over items in order from front to back
    public Iterator<Item> iterator(){
        return new ListIterator();
    }

    class ListIterator implements Iterator<Item>{

        private Node current = first;

        @Override
        public boolean hasNext() {
            return current !=null;
        }

        @Override
        public Item next() {
            if(current == null)
                throw new NoSuchElementException();
            Item item  = current.item;
            current = current.next;
            return item;
        }
    }

    // unit testing (required)
    public static void main(String[] args){
        Deque<String> deque = new Deque<>();
        System.out.println("Deque size : " + deque.size() );
        System.out.println("Is Deque empty? " + deque.isEmpty() );
        //deque.removeFirst();

        deque.addFirst("x");
        deque.addFirst("y");
        deque.addLast("z");

        Iterator<String> iterator = deque.iterator();
        while(iterator.hasNext()){
            System.out.println("contents in deque : "+ iterator.next());
        }
        deque.removeLast();
        deque.removeLast();


        System.out.println("Deque size : " + deque.size() );
        System.out.println("Is Deque empty? " + deque.isEmpty() );
       // deque.addFirst(null);
       // deque.addLast(null);
        iterator.next();


    }

}