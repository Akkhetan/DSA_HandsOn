package org.example.Module3.Assignment;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;

public class RandomizedQueue<Item> implements Iterable<Item> {
    Node head ;
    Node tail;
    int size;
    private final Random random;

    private class Node{
        Item item;
        Node next;
        Node prev;

        Node(Item item){
            this.item = item;
        }
    }

    // construct an empty randomized queue
    public RandomizedQueue(){
        head = tail = null;
        size = 0;
        random = new Random();
    }

    // is the randomized queue empty?
    public boolean isEmpty(){
        return size == 0;
    }

    // return the number of items on the randomized queue
    public int size(){
        return size;
    }

    // add the item
    public void enqueue(Item item){
        if(item == null)
            throw new IllegalArgumentException();

        Node newNode = new Node(item);
        if(isEmpty())
            head = tail = newNode;
        else{
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }


    // remove and return a random item
    public Item dequeue(){
        if(isEmpty())
            throw new NoSuchElementException();

        int randomIndex = random.nextInt(size);
        Node nodeToRemove = getNodeAt(randomIndex);
        Item item = nodeToRemove.item;
        removeNode(nodeToRemove);
        size--;
        return item;
    }

    private Node getNodeAt(int index){
        Node current = head;
        for(int i = 0; i < index; i++)
            current = current.next;
        return current;
    }

    private void removeNode(Node node) {
        if (node == head) {
            head = head.next;
            if (head != null) head.prev = null;
        } else if (node == tail) {
            tail = tail.prev;
            if (tail != null) tail.next = null;
        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
    }

    // return a random item (but do not remove it)
    public Item sample(){
        if(isEmpty())
            throw new NoSuchElementException();

        int randomIndex = random.nextInt(size);
        Node randomNode = getNodeAt(randomIndex);
        return randomNode.item;
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator(){
          return new ListIterator();
    }

    private class ListIterator implements Iterator<Item>{

        private final Item[] shuffledArray = toShuffleArray();
        private int index = 0;

        @Override
        public boolean hasNext() {
            return index < shuffledArray.length;
        }

        @Override
        public Item next() {
            if(!hasNext())
                throw new NoSuchElementException();
           return shuffledArray[index++];
        }

        public void remove(){
            throw new UnsupportedOperationException();
        }
    }

    private Item[] toShuffleArray(){
        Object [] objects = new Object[size];
        Node current = head;
        int i = 0;
        while(current != null){
            objects[i++] = current;
            current = current.next;
        }
        shuffleArray(objects);
        return (Item[]) objects;
    }

    private void shuffleArray(Object[] objects){
        for(int i = objects.length - 1; i > 0; i--){
            int j = random.nextInt(i+1);
            Object temp = objects[i];
            objects[i] = objects[j];
            objects[j] = temp;
        }
    }


    // unit testing (required)
    public static void main(String[] args){
        RandomizedQueue<Integer> rq = new RandomizedQueue<>();
        rq.enqueue(10);
        rq.enqueue(20);
        rq.enqueue(30);
        rq.enqueue(40);
        rq.enqueue(50);

        System.out.println("Random Dequeue: " + rq.dequeue());
        System.out.println("Random Dequeue: " + rq.dequeue());

        System.out.println("Remaining Items (Random Order):");
        /*for (int item : rq) {
            System.out.println(item);
        }*/

        Iterator<Integer> iterator = rq.iterator();
        while(iterator.hasNext()){
            System.out.println("contents in deque : "+ iterator.next());
        }
    }

}