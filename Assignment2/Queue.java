package Assignment2;

import java.security.PublicKey;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Queue<E> implements AbstractQueue<E>{
 private static class Node<E>{
      E element;
     Node<E> Next;
 public Node(E element){
     this.element= element;
     Next =null;
 }

 }
 private Node<E> head;
 private Node<E> tail;
 private int size;
public Queue(){
   head =null;
      tail = null;
      size =0;
}
    public void offer(E element) {
        Node<E> newNode = new Node<>(element);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.Next = newNode;
            tail = newNode;
        }size++;
    }
    public E poll() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        E element = head.element;
        head = head.Next;
        size--;
        return element;
    }

    public E peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        return head.element;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
    public void display() {
        System.out.print("\nData in the Queue:\n");
        if (isEmpty()) {
            System.out.print("Empty!!!\n");
            return;
        }
        Node<E> ptr = head;
        int i = 1;
        while (ptr != null) {
            System.out.println(i + ". " + ptr.element);
            ptr = ptr.Next;
            i++;
        }
        System.out.println("\n");
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private Node<E> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                E element = current.element;
                current = current.Next;
                return element;
            }
        };
    }
    @Override
    public String toString(){
       Node<E> Current = head;
        StringBuilder result = new StringBuilder("[");

        while (Current !=null){
            result.append(Current.element);
            if (Current.Next !=null){
                result.append(", ");}
            Current = Current.Next;
        }
        result.append("]");
        return result.toString();
    }
}

